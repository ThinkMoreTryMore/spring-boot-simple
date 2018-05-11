# spring-boot-simple
# 简单的后台程序搭建 
# 基本上是注解配置
# spring boot模式 无需tomcat 在application.properties 中配置项目的具体属性
# 此spring mvc 没有视图 将返回json格式的数据 纯后端
# 此mybatis 使用lomback 的注解 @Setter和@Getter 如果表无法读取 请在model里使用 @Table(name="xx")注解
# 此spring 已经在使用 
# 此间配置了一个工具(generatorConfig.xml)可以用来生成 mapper.xml 和 mapper.java 和 model 需要注意或者修改的是其中对应的表名
# 处理数据的操作请放在service层
# spring mvc的入口放在controller层
# util包中的是 mybatis需要使用的MyMapper,读取spring的PropertiesUtils
# 此test可以进行单元测试


#此项目整合的是一个音乐网站项目
#由于Jsp格式难以配置，所以此项目配置的是一个ftl格式的页面
