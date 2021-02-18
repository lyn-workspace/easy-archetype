## 核心模块
> 集成众多功能

### cache
缓存自动配置类
#### 触发条件
- 添加了`EnableCaching`注解
- `easy.archetype.framework.cache.enable=true`(默认开启)

#### 功能
##### 1. 自动缓存key的生成
> 将类全限定名+方法全全限定名+JSON.toString(方法参数) 作为唯一的key

##### 2. 自动cacheNames 生成
>  只需要在类上添加 `@CacheConfig` 注解即可，不需要配置 cacheName

### configcenter
> 配置中心,实现项目中配置的外部接入和自动刷新
#### 触发条件
-  `ContextRefresher` 类存在
> 添加
```xml
      <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-context</artifactId>
        </dependency>
```
- 配置`easy.archetype.framework.config.center.enable=true`(默认开启)

#### 使用
##### 使用jdbc存储配置
1. 配置表添加
```mysql
CREATE TABLE `cc_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_name` varchar(255) DEFAULT NULL COMMENT '分组',
  `config_key` varchar(255) DEFAULT NULL COMMENT '配置的key',
  `config_value` varchar(255) DEFAULT NULL COMMENT '配置的value值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
```
2. `bean`注入
```java
 @Bean
    public PropertySource propertySource(DataSource dataSource) {
        return new JdbcPropertySource(dataSource, applicationName);
    }
```

##### 扩展其他配置
> 只需要扩展`PropertySource` 类即可


#### 3. 配置刷新
只需要在相应的需要动态刷新配置的类上添加`@RefreshScope` 注解即可



### generate 代码生成
> 代码生成器,可以通过不同的模板组实现生成代码的隔离,默认实现 数据库文档生成和spring 四层模板

### logger 日志
> 通过对@ApiOperate注解的切面,实现日志的统一拦截
#### 默认实现
> 日志打印功能(需要开启`easy.archetype.framework.logger.loggerPrint=true`配置)

### manage 常用方法封装,提供了缓存和没有缓存的两种实现
>

### mybatisplus 扩展
> mybatisplus扩展类

#### 方法扩展
```java
    int deleteByIdWithFill(T params);
    int batchDeleteWithFill(@Param(Constants.ENTITY) T param, @Param(Constants.WRAPPER) Wrapper<T> wrapper);
```
提供了逻辑删除和批量逻辑删除的两个实现

#### 自动配置类,自动注入分页插件

### redis redis的默认配置类
>实现对redis的默认的序列化配置

### spring
> spring

#### 1. 注解扩展
- `RestGetMapping`
- `RestPostMapping`

#### 2. `SpringContextHolder` spring上下文工具类
### thread  自定义线程池

#### 配置类 `BusinessThreadPoolProperties`

####  提供监控

#### 提供拦截器`BusinessThreadInterceptor`


### validation 参数校验
> 提供 `AddGroup` 和`UpdateGroup`的两个分组

### Version
> 版本号


### xxs过滤(默认开启)
> 对Post请求和Put请求 进行xss过滤

### sensitive脱敏
#### 使用
只需要在使用的字段上添加`Sensitive` 注解即可

### 敏感词过滤

### mybatis
- 增加Mybatis数组,符串互转的转换器

### 状态字典转换