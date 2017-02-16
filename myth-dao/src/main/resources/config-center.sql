INSERT INTO project (code, name, create_username)
VALUES ('myth', '东方娇子', 'admin');

INSERT INTO conf (proj_code, env, name, value, description, create_username)
VALUES
  ('myth', 'common', 'app.name', '东方娇子', '项目名称', 'admin'),
  ('myth', 'common', 'app.author', '康永敢', '项目负责人', 'admin'),
  ('myth', 'common', 'app.ba.no', '皖ICP备16017743号-1', '备案号', 'admin'),

  ('myth', 'common', 'cache.open', 'Y', '是否开启缓存:{Y:开启,N:不开启}', 'admin'),

  ('myth', 'common', 'file.root.path', '/Users/kyg/data/code/20170207/myth/myth-web/src/main/webapp/WEB-INF/', '文件上传根路径', 'admin'),
  ('myth', 'common', 'cdn.server', 'http://cdn.kangyonggan.com', 'cdn加速服务器', 'admin'),

  ('myth', 'common', 'jdbc.driver', 'com.mysql.jdbc.Driver', 'jdbc驱动', 'admin'),
  ('myth', 'common', 'jdbc.password', '123456', 'jdbc密码', 'admin'),
  ('myth', 'common', 'jdbc.url', 'jdbc:mysql://127.0.0.1:3306/myth?useUnicode=true&characterEncoding=UTF-8', 'jdbc地址', 'admin'),
  ('myth', 'common', 'jdbc.username', 'root', 'jdbc用户名', 'admin'),

  ('myth', 'common', 'mail.bufferSize', '50', '错误日志邮件缓冲区大小(单位:k)', 'admin'),
  ('myth', 'common', 'mail.host', 'smtp.163.com', '邮件服务器地址', 'admin'),
  ('myth', 'common', 'mail.password', '********', '邮件服务器密码', 'admin'),
  ('myth', 'common', 'mail.receiver', 'kangyonggan@gmail.com', '错误日志邮件接收人', 'admin'),
  ('myth', 'common', 'mail.timeout', '25000', '邮件发送超时时间', 'admin'),
  ('myth', 'common', 'mail.username', 'kangyg2017@163.com', '邮件服务器用户名', 'admin'),

  ('myth', 'common', 'redis.host', '127.0.0.1', 'redis主机', 'admin'),
  ('myth', 'common', 'redis.maxIdle', '100', 'redis最大等待数', 'admin'),
  ('myth', 'common', 'redis.maxTotal', '1000', 'redis最大连接数', 'admin'),
  ('myth', 'common', 'redis.minIdle', '50', 'redis最小等待数', 'admin'),
  ('myth', 'common', 'redis.password', '123456', 'redis密码', 'admin'),
  ('myth', 'common', 'redis.port', '6379', 'redis端口', 'admin'),
  ('myth', 'common', 'redis.prefix', 'myth', 'redis的key的前缀', 'admin'),
  ('myth', 'common', 'redis.testOnBorrow', 'true', 'redis测试支持', 'admin'),

  ('myth', 'common', 'sms.regionId', 'cn-hangzhou', '短信机房信息', 'admin'),
  ('myth', 'common', 'sms.accessKeyId', '******', '短信密钥ID', 'admin'),
  ('myth', 'common', 'sms.secret', '******', '短信密钥', 'admin'),
  ('myth', 'common', 'sms.domain', 'sms.aliyuncs.com', '短信主机', 'admin'),
  ('myth', 'common', 'sms.signName', '东方娇子', '短信签名', 'admin'),
  ('myth', 'common', 'sms.templateCode', '******', '短信模板', 'admin'),
  ('myth', 'common', 'sms.debug', 'true', '短信调试', 'admin'),

  ('myth', 'common', 'slow.interface.time', '5', '慢接口时间(秒)', 'admin'),
  ('myth', 'common', 'slow.method.time', '5', '慢方法时间(秒)', 'admin'),

  ('myth', 'common', 'book.base.url', 'http://www.biquge.cn/', '书籍根路径', 'admin');