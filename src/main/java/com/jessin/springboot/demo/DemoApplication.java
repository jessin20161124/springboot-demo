package com.jessin.springboot.demo;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    @Bean
    public ServletWebServerFactory servletContainerFactory() {
        return new TomcatServletWebServerFactory() {
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
                try {
                    String token = System.getenv("tsf_token");
                    System.out.println("token:" + token);

                    System.setProperty("consul.token", System.getenv("tsf_token"));

                    Context context =
                            tomcat.addWebapp("/foo", "/Users/jessin/Documents/program/java/user-core-service2/user-core-service/starter/target/user-core-starter-1.4.6-RELEASE.war");

                    // 如果父类加载器是class path，则整个class path的路径下的资源都会扫描，这样就会使用父类的相关类了。例如tsf listener也能扫描到
                    context.setParentClassLoader(ClassLoader.getSystemClassLoader());
                    ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
                    ((StandardJarScanner) context.getJarScanner()).setScanClassPath(false);
                } catch (Exception ex) {
                    throw new IllegalStateException("Failed to add webapp", ex);
                }
                // 在tomcat.start之前，添加context
                return super.getTomcatWebServer(tomcat);
            }
        };
    }
}
