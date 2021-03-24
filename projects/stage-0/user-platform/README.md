# 第四周作业
完善 my dependency-injection 模块
 - 脱离 web.xml 配置实现 ComponentContext 自动初始化
 - 使用独立模块并且能够在 user-web 中运行成功

完善 my-configuration 模块
  - Config 对象如何能被 my-web-mvc 使用
  - 可能在 ServletContext 获取如何通过 ThreadLocal 获取
  
去提前阅读 Servlet 规范中 Security 章节（Servlet 容器安全）

作业提交链接： https://jinshuju.net/f/OubQma


思路：
   1. 定义ServletConfigInitializer 实现 ServletContainerInitializer 利用spi加载到容器中,触发ServletContextConfigSource的注册
   2. 定义ComponentContextInitializer 实现 ServletContainerInitializer 利用spi加载到容器中，触发 ComponentContext的初始化