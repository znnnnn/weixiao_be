## 简介
微校后端服务项目，项目基于 `Spring Boot API Project Seed`种子项目进行开发，感谢开源为我们带来如此方便的 `Seed`.

## Spring Boot API Project Seed 简介

项目原地址：https://github.com/lihengming/spring-boot-api-project-seed

是一个基于Spring Boot & MyBatis的种子项目，用于快速构建中小型API、RESTful API项目，该种子项目已经有过多个真实项目的实践，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写，减少加班。下面是一个简单的使用演示，看如何基于本项目在短短几十秒钟内实现一套简单的API，并运行提供服务。

## 项目第三方工具管理页面
* [Swagger2 API 页面](http://localhost:8080/doc.html)
* [druid监控页面](http://localhost:8080/druid/datasource.html)


## 技术选型&文档
- Spring Boot（[查看Spring Boot学习&使用指南](http://www.jianshu.com/p/1a9fd8936bd8)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
    - [MyBatis学习笔记（六）：一对一，一对多及鉴别器映射](https://zjxkenshine.github.io/2018/04/01/MyBatis%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%EF%BC%88%E5%85%AD%EF%BC%89%EF%BC%9A%E9%AB%98%E7%BA%A7%E6%9F%A5%E8%AF%A2-%E6%98%A0%E5%B0%84/)
    - [MyBatis 关联映射之一对多](https://blog.csdn.net/u010858605/article/details/70170979)
- MyBatisb通用Mapper插件（[查看官方中文文档](https://mapperhelper.github.io/docs/)）
    - [轻松搞定增删改查 - MyBatis通用Mapper介绍与使用](https://juejin.im/entry/5a3b482cf265da431281152b)
    - [在Spring Boot项目中使用MyBatis通用 Mapper插件](https://www.jianshu.com/p/b0af2c0a7a9d)
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- Fastjson（[查看官方中文文档](https://github.com/Alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5)）
- Swagger2
    - [Spring Boot中使用Swagger2构建强大的RESTful API文档](http://blog.didispace.com/springbootswagger2/)
    - [一个已整合完毕的项目](https://github.com/Gahon1995/spring-boot-api-project-seed)
    - [整合时遇到的问题](https://github.com/lihengming/spring-boot-api-project-seed/issues/58)
- 阿里云短信配置
    - [OpenAPI Explorer](https://api.aliyun.com/?spm=a2c4g.11186623.2.14.31a350a4SXcOam#/?product=Dysmsapi&api=SendSms)
    - [基于阿里大于的短信验证微服务 | 记路心晴](https://songwell1024.github.io/2019/01/06/CheckSmsCode/)
- 文件上传、并整合进阿里云OSS对象存储
    - [SpringBoot（十八） 文件上传下载](https://qq343509740.gitee.io/2018/08/04/Spring%E5%85%A8%E5%AE%B6%E6%A1%B6/SpringBoo2.x/SpringBoot%EF%BC%88%E5%8D%81%E5%85%AB%EF%BC%89%20%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0%E4%B8%8B%E8%BD%BD/#HTML)
    - [Springboot 迁移及上传文件至阿里云OSS](https://juejin.im/post/5baa3bf5e51d450e9a2e32b8)
    - [如何将multipart文件转换为文件？](https://codeday.me/bug/20171213/109115.html)
    - [spring boot实现文件上传下载](http://songwei.site/2017/12/08/fileUpDown/)
    
## 开发建议
- [RESTful API 接口实践 - 阮一峰](http://www.ruanyifeng.com/blog/2018/10/restful-api-best-practices.html)
- 表名，建议使用小写，多个单词使用下划线拼接
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解，详情见[通用Mapper插件文档说明](https://mapperhelper.github.io/docs/2.use/)
- 建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 需要工具类的话建议先从```apache-commons-*```和```guava```中找，实在没有再造轮子或引入类库，尽量精简项目
- 开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/alibaba/p3c))
- 建议在公司内部使用[ShowDoc](https://github.com/star7th/showdoc)、[SpringFox-Swagger2](https://github.com/springfox/springfox) 、[RAP](https://github.com/thx/RAP)等开源项目来编写、管理API文档