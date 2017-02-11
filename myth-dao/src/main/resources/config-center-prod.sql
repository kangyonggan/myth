INSERT INTO configuration (proj_code, environment, name, value, description)
VALUES
  ('myth', 'prod', 'app.name', '东方娇子', '项目名称'),
  ('myth', 'prod', 'app.author', '康永敢', '项目负责人'),
  ('myth', 'prod', 'app.ba.no', '皖ICP备16017743号-1', '备案号'),

  ('myth', 'prod', 'cache.open', 'Y', '是否开启缓存:{Y:开启,N:不开启}'),

  ('myth', 'prod', 'file.root.path', '/home/kyg/data/myth/', '文件上传根路径'),
  ('myth', 'prod', 'cdn.server', 'http://cdn.kangyonggan.com', 'cdn加速服务器'),

  ('myth', 'prod', 'jdbc.driver', 'com.mysql.jdbc.Driver', 'jdbc驱动'),
  ('myth', 'prod', 'jdbc.password', '123456', 'jdbc密码'),
  ('myth', 'prod', 'jdbc.url', 'jdbc:mysql://127.0.0.1:3306/myth?useUnicode=true&characterEncoding=UTF-8', 'jdbc地址'),
  ('myth', 'prod', 'jdbc.username', 'root', 'jdbc用户名'),

  ('myth', 'prod', 'mail.bufferSize', '50', '错误日志邮件缓冲区大小(单位:k)'),
  ('myth', 'prod', 'mail.host', 'smtp.163.com', '邮件服务器地址'),
  ('myth', 'prod', 'mail.password', '********', '邮件服务器密码'),
  ('myth', 'prod', 'mail.receiver', 'kangyonggan@gmail.com', '错误日志邮件接收人'),
  ('myth', 'prod', 'mail.timeout', '25000', '邮件发送超时时间'),
  ('myth', 'prod', 'mail.username', 'kangyg2017@163.com', '邮件服务器用户名'),

  ('myth', 'prod', 'redis.host', '127.0.0.1', 'redis主机'),
  ('myth', 'prod', 'redis.maxIdle', '100', 'redis最大等待数'),
  ('myth', 'prod', 'redis.maxTotal', '1000', 'redis最大连接数'),
  ('myth', 'prod', 'redis.minIdle', '50', 'redis最小等待数'),
  ('myth', 'prod', 'redis.password', '123456', 'redis密码'),
  ('myth', 'prod', 'redis.port', '6379', 'redis端口'),
  ('myth', 'prod', 'redis.prefix', 'myth', 'redis的key的前缀'),
  ('myth', 'prod', 'redis.testOnBorrow', 'true', 'redis测试支持'),

  ('myth', 'prod', 'sms.regionId', 'cn-hangzhou', '短信机房信息'),
  ('myth', 'prod', 'sms.accessKeyId', '******', '短信密钥ID'),
  ('myth', 'prod', 'sms.secret', '******', '短信密钥'),
  ('myth', 'prod', 'sms.domain', 'sms.aliyuncs.com', '短信主机'),
  ('myth', 'prod', 'sms.signName', '东方娇子', '短信签名'),
  ('myth', 'prod', 'sms.templateCode', '******', '短信模板'),
  ('myth', 'prod', 'sms.debug', 'true', '短信调试'),

  ('myth', 'prod', 'slow.interface.time', '5', '慢接口时间(秒)'),
  ('myth', 'prod', 'slow.method.time', '5', '慢方法时间(秒)'),

  ('myth', 'prod', 'book.base.url', 'http://www.biquge.cn/', '书籍根路径');