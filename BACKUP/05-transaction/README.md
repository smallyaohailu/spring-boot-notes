# 05-transaction：事务管理
说明：一些常见基于spring的事务处理方式。

## spring-annotation-transaction:基于spring的注解式事务管理
- 事务配置
- 注解及其参数说明
- 方法测试

## aop-transaction:基于aop的约定式事务管理
- 创建事务拦截器
- 注入aop切面，约定式管理事务

## multiple-datasource-transaction:多数据源事务配置/单一服务分布式事务配置
单一服务分布式事务配置：一个服务中存在多个数据源操作的事务管理，mybatis配置两个数据源，现象：
- 一个方法中，不配置事务，同时操作两个数据源保存数据，无异常 - 二者均保存成功
- 一个方法中，不配置事务，同时操作两个数据源，中间出现异常 - 不回滚
- 一个方法中，配置事务，同时操作两个数据源保存数据，无异常 - 二者均保存成功
- 一个方法中，配置事务，同时操作两个数据源，中间出现异常 - 指定事务管理器管理的数据源操作回滚，其他未回滚

结论：多个mapperScan的多数据源配置，一个方法的事务配置中只会对指定的事务管理器管理的数据源操作生效，其他忽略

@Transactional若未指定事务管理器，默认为配置了primary的事务管理器

单个项目中多数据源的事务管理解决方案：使用JTA进行分布式事务管理

JTA:Java Transaction API，JTA允许应用程序执行分布式事务处理——在两个或多个网络计算机资源上访问并且更新数据。

## *TODO* 微服务架构下分布式事务解决方案
解决方案：
- Try Confirm Cancel模式
- 基于事件驱动的服务架构
解释：TCC模式 - 分布尝试，统一确认，统一取消