1. 执行项目下init.sql，创建数据库和数据表
2. 在项目路径下打包
```
mvn -DskipTests package
```
3. 运行项目
```
java -DdbUserPassword=xxx -DdbIp=xxx -DdbUser=xxx -jar /Users/jessin/Documents/program/java/springboot-demo/target/demo-0.0.1-SNAPSHOT.jar

```
