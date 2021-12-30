## p6spy-spring-boot-starter
让 p6spy 支持 springboot 的配置方式，直接在 bootstrap.yml 等配置文件配置，不用再写spy.properties

参考: 

* [P6Spy](https://github.com/p6spy/p6spy) 
* [klboke/p6spy-spring-boot-starter: p6spy快速集成的spring boot starter (github.com)](https://github.com/klboke/p6spy-spring-boot-starter)
* [gavlyukovskiy/spring-boot-data-source-decorator: Spring Boot integration with p6spy, datasource-proxy, flexy-pool and spring-cloud-sleuth (github.com)](https://github.com/gavlyukovskiy/spring-boot-data-source-decorator)

增加了对新的常用的配置字段的处理 如:  ``` executionThreshold ```等，配置方式和以前一样

简单的使用示例：

application.yml 配置：

```yml
spring:
  datasource:
    driver-class-name: com.p6spy.engine.spy.P6SpyDriver
    url: jdbc:p6spy:mysql://127.0.0.1:3306/table
    ...
    
    
p6spy:
  config:
    executionThreshold: 500 #记录执行时间大于500毫秒的sql
    logfile: slow.log #日志文件
    append: true
    dateformat: yyyy-MM-dd HH:mm:ss
    # 自定义的日志数据格式
    customLogMessageFormat: -%(currentTime)|%(executionTime)|%(category)|%(sql) 
    logMessageFormat: com.p6spy.engine.spy.appender.CustomLineFormat    
```

对于超过500毫秒的sql，就会被记录在项目根目录的 slow.log 文件里

![image-20211230170320076](C:\Users\rxf113\AppData\Roaming\Typora\typora-user-images\image-20211230170320076.png)



