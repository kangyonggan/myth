INSERT INTO project (code, name, push_url)
VALUES ('myth', '东方娇子', 'http://kangyonggan.com/configcenter');

INSERT INTO configuration (proj_code, environment, name, value, description)
VALUES
  ('myth', 'local', 'app.name', '东方娇子', '项目名称'),
  ('myth', 'local', 'app.author', '康永敢', '项目负责人'),
  ('myth', 'local', 'app.ba.no', '皖ICP备16017743号-1', '备案号'),

  ('myth', 'local', 'cache.open', 'Y', '是否开启缓存:{Y:开启,N:不开启}'),

  ('myth', 'local', 'file.root.path', '/Users/kyg/data/code/20170207/myth/myth-web/src/main/webapp/WEB-INF/', '文件上传根路径'),
  ('myth', 'local', 'cdn.server', 'http://cdn.kangyonggan.com', 'cdn加速服务器'),

  ('myth', 'local', 'jdbc.driver', 'com.mysql.jdbc.Driver', 'jdbc驱动'),
  ('myth', 'local', 'jdbc.password', '123456', 'jdbc密码'),
  ('myth', 'local', 'jdbc.url', 'jdbc:mysql://127.0.0.1:3306/myth?useUnicode=true&characterEncoding=UTF-8', 'jdbc地址'),
  ('myth', 'local', 'jdbc.username', 'root', 'jdbc用户名'),

  ('myth', 'local', 'mail.bufferSize', '50', '错误日志邮件缓冲区大小(单位:k)'),
  ('myth', 'local', 'mail.host', 'smtp.163.com', '邮件服务器地址'),
  ('myth', 'local', 'mail.password', '********', '邮件服务器密码'),
  ('myth', 'local', 'mail.receiver', 'kangyonggan@gmail.com', '错误日志邮件接收人'),
  ('myth', 'local', 'mail.timeout', '25000', '邮件发送超时时间'),
  ('myth', 'local', 'mail.username', 'kangyg2017@163.com', '邮件服务器用户名'),

  ('myth', 'local', 'redis.host', '127.0.0.1', 'redis主机'),
  ('myth', 'local', 'redis.maxIdle', '100', 'redis最大等待数'),
  ('myth', 'local', 'redis.maxTotal', '1000', 'redis最大连接数'),
  ('myth', 'local', 'redis.minIdle', '50', 'redis最小等待数'),
  ('myth', 'local', 'redis.password', '123456', 'redis密码'),
  ('myth', 'local', 'redis.port', '6379', 'redis端口'),
  ('myth', 'local', 'redis.prefix', 'myth', 'redis的key的前缀'),
  ('myth', 'local', 'redis.testOnBorrow', 'true', 'redis测试支持'),

  ('myth', 'local', 'sms.regionId', 'cn-hangzhou', '短信机房信息'),
  ('myth', 'local', 'sms.accessKeyId', '******', '短信密钥ID'),
  ('myth', 'local', 'sms.secret', '******', '短信密钥'),
  ('myth', 'local', 'sms.domain', 'sms.aliyuncs.com', '短信主机'),
  ('myth', 'local', 'sms.signName', '东方娇子', '短信签名'),
  ('myth', 'local', 'sms.templateCode', '******', '短信模板'),
  ('myth', 'local', 'sms.debug', 'true', '短信调试'),

  ('myth', 'local', 'slow.interface.time', '5', '慢接口时间(秒)'),
  ('myth', 'local', 'slow.method.time', '5', '慢方法时间(秒)'),

  ('myth', 'local', 'book.base.url', 'http://www.biquge.cn/', '书籍根路径');