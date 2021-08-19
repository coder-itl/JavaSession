###  管理员表结构

```mysql
    -- 创建管理员数据表
    create table manager
    (
    username varchar(20) primary key,
    password varchar(20) not null
    ) charset = utf8;
    
    insert into manager values('coder-itl','coderitl');
    
    select * from manager;
```



###  查询所有数据显示存在BUG

```java
TODO: 无法获取正确结果集
```

