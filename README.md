#spring-boot项目基础搭建
## 1.启用了thymeleaf模版
## 2.启用了spring-test
## 3.集成了swagger-ui(localhost:8080/swagger-ui.html)
## 4.制作了了多环境打包（基于maven -P参数）
## 5.集成了mybatis
## 6.制作了日志工具类
## 7.加入了gson工具类（解决了1.时间格式化问题， 2.String转换时将null转换为"null"字符串问题。转换为了''空字符串）
## 8.httpclient工具类（线程池版本，支持http、https）
## 9.增强了mybatis注解的功能（可以使用list当作参数）
## 10.加入了mybatis-generator-maven-plugin，用于根据数据库表结构自动生成实体类以及mapper。
