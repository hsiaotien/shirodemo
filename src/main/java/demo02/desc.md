博客sample

login()代码跟进，可以看到Realm

> ModularRealmAuthenticator作用进行认证，需要调用realm查询用户信息（在数据库中存在用户信息）
>
> ModularRealmAuthenticator进行密码对比（认证过程）。
> 
> realm：需要根据token中的身份信息去查询数据库（入门程序使用ini配置文件），如果查到用户返回认证信息，如果查询不到返回null。