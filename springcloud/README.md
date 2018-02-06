说明：

1.eurekaServer为注册中心，用于注册服务。

2.redisService、dbService分别为redis服务和mysql数据库服务。

3.springWeb 为web客户端。

4.本例只演示redis的缓存服务、本例不包含配置中心及路由和安全功能。

启动项目：

1.先启动eurekaServer。

2.启动redisService,启动成功后即可注册redis服务到eurekaServer。

3.启动springWeb。

4.访问如下地址查看服务注册情况：
  
  http://localhost:8761/
  
  
缓存演示：

1.访问如下链接可将用户信息写入到redis缓存中，演示所用的用户信息采用hardcode方式。

http://localhost:8888/cache/setUserList
  
2.访问如下链接验证缓存是否成功：

http://localhost:8888/cache/getUserList
  
3.访问如下链接调用redis服务并将用户信息显示在页面上：

http://localhost:8080/web/index
  
  
note：
缓存的用户信息 key为"userList"。