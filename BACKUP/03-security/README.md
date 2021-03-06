# 03-security:安全管理
## security：使用Spring Security进行基本安全控制
- 对访问进行动态管理，不同用户拥有不同的权限
- 依赖与默认配置
- 自定义权限控制配置
- 添加自定义用户、密码、角色

## security-swagger：swagger文档登录校验
- 访问接口文档需要登录认证，api接口放行
- 接口文档地址认证拦截
- security csrf ignore，其他api接口无需认证

## security-db：数据库动态管理用户权限
- 用户权限认证信息来源数据库，对所有访问进行认证拦截
- 未登录，跳转登录页；权限不足，跳转403页面
- 用户/角色/权限 - 表设计
- 自定义用户登录和权限获取
- 自定义权限认证过程：拦截/放行
- 相关配置解释

## security-html，数据库管理用户权限/自定义登录页面
- 用户的权限从数据库中动态获取
- 自定义登录页

## security-json，数据库管理用户权限/认证流程返回json信息
- 用户权限从数据库中获取。
- 认证流程中不跳转页面，而是提示自定义的json信息。
- 认证时不跳转登录页而是提示需要认证的json信息
- 自定义登录成功处理：登录成功，返回登录成功json信息
- 自定义登录失败处理：登录失败，返回登录失败json信息
- 自定义登出成功处理：登出成功，返回登出成功json信息
- 以json形式发送用户名密码参数实现登录

## security-db-swagger：数据库管理用户权限/认证流程返回json信息/整合swagger接口文档
- 用户权限从数据库中获取。
- 认证流程中不跳转页面，而是提示自定义的json信息。
- swagger文档被权限管理。
- 自定义权限校验，需要把swagger对应的路径交予security管理，不能忽略，放行swagger相关资源

## *TODO* oauth2：实现oauth2认证服务器和客户端
实现：一个oauth2.0 server / 一个oauth2.0 client
> 上面心中存在的问题:
- 登录后的生效时间是多少？
- security如何判断是登录的？token？cookie？
- 如何将这种认证流程抽取出来，成为一个单独的认证服务？而不是跟单个项目耦合？
- 认证基于自身可以这么做，如果需要第三方服务如何整合认证？
- 如何搭建一个独立的认证服务并能控制其他服务的权限呢？

#### *TODO* jwt：JSON Web Token