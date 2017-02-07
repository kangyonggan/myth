DROP DATABASE IF EXISTS myth;

CREATE DATABASE myth
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE myth;

-- ----------------------------
--  Table structure for user
-- ----------------------------
DROP TABLE
IF EXISTS user;

CREATE TABLE user
(
  id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  username     VARCHAR(20)                           NOT NULL
  COMMENT '用户名',
  email        VARCHAR(64)                           NOT NULL                    DEFAULT ''
  COMMENT '邮箱',
  mobile       VARCHAR(20)                           NOT NULL                    DEFAULT ''
  COMMENT '手机号',
  password     VARCHAR(64)                           NOT NULL
  COMMENT '密码',
  salt         VARCHAR(64)                           NOT NULL
  COMMENT '密码盐',
  fullname     VARCHAR(32)                           NOT NULL
  COMMENT '姓名',
  small_avatar VARCHAR(255)                          NOT NULL                    DEFAULT ''
  COMMENT '小头像',
  is_deleted   TINYINT                               NOT NULL                    DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '用户表';
CREATE UNIQUE INDEX id_UNIQUE
  ON user (id);
CREATE INDEX create_ix
  ON user (created_time);
CREATE UNIQUE INDEX username_UNIQUE
  ON user (username);

-- ----------------------------
--  Table structure for user_profile
-- ----------------------------
DROP TABLE
IF EXISTS user_profile;

CREATE TABLE user_profile
(
  id            BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  username      VARCHAR(20)                           NOT NULL
  COMMENT '用户名',
  medium_avatar VARCHAR(255)                          NOT NULL                    DEFAULT ''
  COMMENT '中头像',
  large_avatar  VARCHAR(255)                          NOT NULL                    DEFAULT ''
  COMMENT '大头像',
  sex           TINYINT                               NOT NULL                    DEFAULT 0
  COMMENT '性别:{0:男, 1:女}',
  phone         VARCHAR(32)                           NOT NULL                    DEFAULT ''
  COMMENT '座机号',
  qq            VARCHAR(16)                           NOT NULL                    DEFAULT ''
  COMMENT 'QQ号',
  weixin        VARCHAR(64)                           NOT NULL                    DEFAULT ''
  COMMENT '微信号',
  id_card       VARCHAR(32)                           NOT NULL                    DEFAULT ''
  COMMENT '身份证',
  web_site      VARCHAR(64)                           NOT NULL                    DEFAULT ''
  COMMENT '个人网站',
  address       VARCHAR(128)                          NOT NULL                    DEFAULT ''
  COMMENT '暂住址',
  remarks       VARCHAR(512)                          NOT NULL                    DEFAULT ''
  COMMENT '备注',
  is_deleted    TINYINT                               NOT NULL                    DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time  TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time  TIMESTAMP                             NOT NULL                    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '用户信息表';
CREATE UNIQUE INDEX id_UNIQUE
  ON user_profile (id);
CREATE UNIQUE INDEX username_UNIQUE
  ON user_profile (username);

-- ----------------------------
--  Table structure for role
-- ----------------------------
DROP TABLE
IF EXISTS role;

CREATE TABLE role
(
  id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  code         VARCHAR(32)                           NOT NULL
  COMMENT '角色代码',
  name         VARCHAR(32)                           NOT NULL
  COMMENT '角色名称',
  is_deleted   TINYINT                               NOT NULL                DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '角色表';
CREATE UNIQUE INDEX id_UNIQUE
  ON role (id);
CREATE INDEX create_ix
  ON role (created_time);
CREATE UNIQUE INDEX code_UNIQUE
  ON role (code);

-- ----------------------------
--  Table structure for menu
-- ----------------------------
DROP TABLE
IF EXISTS menu;

CREATE TABLE menu
(
  id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  code         VARCHAR(32)                           NOT NULL
  COMMENT '菜单代码',
  name         VARCHAR(32)                           NOT NULL
  COMMENT '菜单名称',
  pcode        VARCHAR(32)                           NOT NULL                DEFAULT ''
  COMMENT '父菜单代码',
  url          VARCHAR(128)                          NOT NULL                DEFAULT ''
  COMMENT '菜单地址',
  sort         INT(11)                               NOT NULL                DEFAULT 0
  COMMENT '菜单排序(从0开始)',
  icon         VARCHAR(128)                          NOT NULL                DEFAULT ''
  COMMENT '菜单图标的样式',
  is_deleted   TINYINT                               NOT NULL                DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '菜单表';
CREATE UNIQUE INDEX id_UNIQUE
  ON menu (id);
CREATE INDEX create_ix
  ON menu (created_time);
CREATE INDEX sort_ix
  ON menu (sort);
CREATE UNIQUE INDEX code_UNIQUE
  ON menu (code);

-- ----------------------------
--  Table structure for user_role
-- ----------------------------
DROP TABLE
IF EXISTS user_role;

CREATE TABLE user_role
(
  username  VARCHAR(20) NOT NULL
  COMMENT '用户名',
  role_code VARCHAR(32) NOT NULL
  COMMENT '角色代码',
  PRIMARY KEY (username, role_code)
)
  COMMENT '用户角色表';

-- ----------------------------
--  Table structure for role_menu
-- ----------------------------
DROP TABLE
IF EXISTS role_menu;

CREATE TABLE role_menu
(
  role_code VARCHAR(32) NOT NULL
  COMMENT '角色代码',
  menu_code VARCHAR(32) NOT NULL
  COMMENT '菜单代码',
  PRIMARY KEY (role_code, menu_code)
)
  COMMENT '角色菜单表';

-- ----------------------------
--  Table structure for dictionary
-- ----------------------------
DROP TABLE
IF EXISTS dictionary;

CREATE TABLE dictionary
(
  id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  code         VARCHAR(32)                           NOT NULL
  COMMENT '代码',
  value        VARCHAR(128)                          NOT NULL
  COMMENT '值',
  type         VARCHAR(16)                           NOT NULL
  COMMENT '类型',
  sort         INT(11)                               NOT NULL                DEFAULT 0
  COMMENT '排序(从0开始)',
  is_deleted   TINYINT                               NOT NULL                DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '字典表';
CREATE UNIQUE INDEX id_UNIQUE
  ON dictionary (id);
CREATE UNIQUE INDEX code_UNIQUE
  ON dictionary (code);
CREATE INDEX create_ix
  ON dictionary (created_time);
CREATE INDEX type_ix
  ON dictionary (type);
CREATE INDEX sort_ix
  ON dictionary (sort);

-- ----------------------------
--  Table structure for content
-- ----------------------------
CREATE TABLE content
(
  id           BIGINT(20) PRIMARY KEY  AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  title        VARCHAR(128)                           NOT NULL
  COMMENT '标题',
  template     VARCHAR(64)                            NOT NULL                DEFAULT 'page'
  COMMENT '模板',
  body         LONGTEXT                               NOT NULL
  COMMENT '内容',
  is_deleted   TINYINT                                NOT NULL                DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time TIMESTAMP                              NOT NULL                DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                              NOT NULL                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '内容表';
CREATE UNIQUE INDEX id_UNIQUE
  ON content (id);

-- ----------------------------
--  Table structure for token
-- ----------------------------
CREATE TABLE token
(
  id           BIGINT(20) PRIMARY KEY  AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  code         VARCHAR(128)                           NOT NULL
  COMMENT '记号代码',
  type         VARCHAR(500)                           NOT NULL                DEFAULT ''
  COMMENT '记号类型',
  user_id      BIGINT(20)                             NOT NULL                DEFAULT 0
  COMMENT '用户ID',
  expire_time  DATETIME                               NOT NULL
  COMMENT '失效时间',
  is_deleted   TINYINT                                NOT NULL                DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time TIMESTAMP                              NOT NULL                DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time TIMESTAMP                              NOT NULL                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '记号表';
CREATE UNIQUE INDEX id_UNIQUE
  ON token (id);
CREATE UNIQUE INDEX code_UNIQUE
  ON token (code);

-- ----------------------------
--  Table structure for attachment
-- ----------------------------
DROP TABLE
IF EXISTS attachment;

CREATE TABLE attachment
(
  id              BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL
  COMMENT '主键, 自增',
  source_id       BIGINT(20)                            NOT NULL                DEFAULT 0
  COMMENT '来源ID',
  name            VARCHAR(256)                          NOT NULL                DEFAULT ''
  COMMENT '附件原名',
  path            VARCHAR(256)                          NOT NULL
  COMMENT '附件路径',
  type            VARCHAR(32)                           NOT NULL
  COMMENT '类型',
  create_username VARCHAR(20)                           NOT NULL                DEFAULT ''
  COMMENT '上传人',
  is_deleted      TINYINT                               NOT NULL                DEFAULT 0
  COMMENT '逻辑删除:{0:未删除, 1:已删除}',
  created_time    TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  updated_time    TIMESTAMP                             NOT NULL                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间'
)
  COMMENT '附件表';
CREATE UNIQUE INDEX id_UNIQUE
  ON attachment (id);
CREATE INDEX create_ix
  ON attachment (created_time);

#====================初始数据====================#

-- ----------------------------
--  data for user
-- ----------------------------
INSERT INTO user
(username, email, mobile, password, salt, fullname)
VALUES
  ('admin', 'kangyonggan@gmail.com', '15121149571', '9606b0029ba4a8c9369f288cced0dc465eb5eabd', '3685072edcf8aad8',
   '管理员');

-- ----------------------------
--  data for user_profile
-- ----------------------------
INSERT INTO user_profile
(username, phone, id_card, qq, weixin, address, web_site)
VALUES
  ('admin', '021-63898580', '340321199112273095', '316071722', 'Brave_Kang', '上海市松江区九亭镇云润家园', 'http://kangyonggan.com');

-- ----------------------------
--  data for role
-- ----------------------------
INSERT INTO role
(code, name)
VALUES
  ('ROLE_ADMIN', '管理员'),
  ('ROLE_USER', '普通用户');

-- ----------------------------
--  data for menu
-- ----------------------------
INSERT INTO menu
(code, name, pcode, url, sort, icon)
VALUES
  ('DASHBOARD', '工作台', '', 'index', 0, 'menu-icon fa fa-dashboard'),

  ('SYSTEM', '系统', 'DASHBOARD', 'system', 1, 'menu-icon fa fa-cogs'),
  ('SYSTEM_USER', '用户管理', 'SYSTEM', 'system/user', 0, ''),
  ('SYSTEM_ROLE', '角色管理', 'SYSTEM', 'system/role', 1, ''),
  ('SYSTEM_MENU', '菜单管理', 'SYSTEM', 'system/menu', 2, ''),

  ('CONTENT', '内容', 'DASHBOARD', 'content', 2, 'menu-icon fa fa-gavel'),
  ('CONTENT_CACHE', '缓存管理', 'CONTENT', 'content/cache', 0, ''),
  ('CONTENT_DICTIONARY', '数据字典', 'CONTENT', 'content/dictionary', 1, ''),
  ('CONTENT_CONTENT', '内容管理', 'CONTENT', 'content/content', 2, ''),

  ('USER', '我的', 'DASHBOARD', 'user', 3, 'menu-icon fa fa-user'),
  ('USER_PROFILE', '个人资料', 'USER', 'user/profile', 0, '');

-- ----------------------------
--  data for user_role
-- ----------------------------
INSERT INTO user_role
VALUES
  ('admin', 'ROLE_ADMIN');

-- ----------------------------
--  data for role_menu
-- ----------------------------
INSERT INTO role_menu SELECT
                        'ROLE_ADMIN',
                        code
                      FROM menu;

INSERT INTO role_menu SELECT
                        'ROLE_USER',
                        code
                      FROM menu
                      WHERE code LIKE 'USER%' OR code = 'DASHBOARD';

INSERT INTO dictionary
(code, value, type, sort)
VALUES
  ('myth', '东方娇子', 'project', 0),
  ('page', '页面', 'template', 0),
  ('content', '内容', 'attachment', 0);

INSERT INTO content (id, title, template, body)
VALUES (1, '注册协议', 'page', '1.1 东方娇子的所有权和运营权归康永敢个人所有。

1.2 用户在注册之前，应当仔细阅读本协议，并同意遵守本协议后方可成为注册用户。一旦注册成功，则用户与康永敢之间自动形成协议关系，用户应当受本协议的约束。用户在使用特殊的服务或产品时，应当同意接受相关协议后方能使用。

1.3 本协议则可由康永敢随时更新，用户应当及时关注并同意本站不承担通知义务。本站的通知、公告、声明或其它类似内容是本协议的一部分。

2.1 东方娇子的具体内容由本站根据实际情况提供。

2.2 本站仅提供相关的网络服务，除此之外与相关网络服务有关的设备(如个人电脑、手机、及其他与接入互联网或移动网有关的装置)及所需的费用(如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费)均应由用户自行负担。

3.1 经本站注册系统完成注册程序并通过身份认证的用户即成为正式用户，可以获得本站规定用户所应享有的一切权限；未经认证仅享有本站规定的部分会员权限。康永敢有权对会员的权限设计进行变更。

3.2 用户只能按照注册要求使用真实姓名，及身份证号注册。用户有义务保证密码和帐号的安全，用户利用该密码和帐号所进行的一切活动引起的任何损失或损害，由用户自行承担全部责任，本站不承担任何责任。如用户发现帐号遭到未授权的使用或发生其他任何安全问题，应立即修改帐号密码并妥善保管，如有必要，请通知本站。因黑客行为或用户的保管疏忽导致帐号非法使用，本站不承担任何责任。

4.1 遵守中华人民共和国相关法律法规，包括但不限于《中华人民共和国计算机信息系统安全保护条例》、《计算机软件保护条例》、《最高人民法院关于审理涉及计算机网络著作权纠纷案件适用法律若干问题的解释(法释[2004]1号)》、《全国人大常委会关于维护互联网安全的决定》、《互联网电子公告服务管理规定》、《互联网新闻信息服务管理规定》、《互联网著作权行政保护办法》和《信息网络传播权保护条例》等有关计算机互联网规定和知识产权的法律和法规、实施办法。

4.2 用户对其自行发表、上传或传送的内容负全部责任，所有用户不得在本站任何页面发布、转载、传送含有下列内容之一的信息，否则本站有权自行处理并不通知用户：

(1)违反宪法确定的基本原则的；
(2)危害国家安全，泄漏国家机密，颠覆国家政权，破坏国家统一的；
(3)损害国家荣誉和利益的；
(4)煽动民族仇恨、民族歧视，破坏民族团结的；
(5)破坏国家宗教政策，宣扬邪教和封建迷信的；
(6)散布谣言，扰乱社会秩序，破坏社会稳定的；
(7)散布淫秽、色情、赌博、暴力、恐怖或者教唆犯罪的；
(8)侮辱或者诽谤他人，侵害他人合法权益的；
(9)煽动非法集会、结社、游行、示威、聚众扰乱社会秩序的；
(10)以非法民间组织名义活动的；
(11)含有法律、行政法规禁止的其他内容的。

4.3 用户承诺对其发表或者上传于本站的所有信息(即属于《中华人民共和国著作权法》规定的作品，包括但不限于文字、图片、音乐、电影、表演和录音录像制品和电脑程序等)均享有完整的知识产权，或者已经得到相关权利人的合法授权；如用户违反本条规定造成本站被第三人索赔的，用户应全额补偿本站一切费用(包括但不限于各种赔偿费、诉讼代理费及为此支出的其它合理费用)；

4.4 当第三方认为用户发表或者上传于本站的信息侵犯其权利，并根据《信息网络传播权保护条例》或者相关法律规定向本站发送权利通知书时，用户同意本站可以自行判断决定删除涉嫌侵权信息，除非用户提交书面证据材料排除侵权的可能性，本站将不会自动恢复上述删除的信息；
(1)不得为任何非法目的而使用网络服务系统；
(2)遵守所有与网络服务有关的网络协议、规定和程序；
(3)不得利用本站进行任何可能对互联网的正常运转造成不利影响的行为；
(4)不得利用本站进行任何不利于本站的行为。

4.5 如用户在使用网络服务时违反上述任何规定，本站有权要求用户改正或直接采取一切必要的措施(包括但不限于删除用户张贴的内容、暂停或终止用户使用网络服务的权利)以减轻用户不当行为而造成的影响。

5.1 本站不对外公开或向第三方提供单个用户的注册资料及用户在使用网络服务时存储在本站的非公开内容，但下列情况除外：
(1)事先获得用户的明确授权；
(2)根据有关的法律法规要求；
(3)按照相关政府主管部门的要求；
(4)为维护社会公众的利益。

5.2 本站可能会与第三方合作向用户提供相关的网络服务，在此情况下，如该第三方同意承担与本站同等的保护用户隐私的责任，则本站有权将用户的注册资料等提供给该第三方。

5.3 在不透露单个用户隐私资料的前提下，本站有权对整个用户数据库进行分析并对用户数据库进行商业上的利用。

6.1 本站的文字、图片、音频、视频等版权均归康永敢个人享有，未经本站许可，不得任意转载。

6.2 本站特有的标识、版面设计、编排方式等版权均属康永敢个人享有，未经本站许可，不得任意复制或转载。

6.3 使用本站的任何内容均应注明“来源于东方娇子”及署上作者姓名，按法律规定需要支付稿酬的，应当通知本站及作者及支付稿酬，并独立承担一切法律责任。

6.4 本站享有所有作品用于其它用途的优先权，包括但不限于网站、电子杂志、平面出版等，但在使用前会通知作者，并按同行业的标准支付稿酬。

6.5 本站所有内容仅代表作者自己的立场和观点，与本站无关，由作者本人承担一切法律责任。

6.6 恶意转载本站内容的，本站保留将其诉诸法律的权利。

7.1 用户明确同意其使用本站网络服务所存在的风险及一切后果将完全由用户本人承担，康永敢对此不承担任何责任。

7.2 本站无法保证网络服务一定能满足用户的要求，也不保证网络服务的及时性、安全性、准确性。

7.3 本站不保证为方便用户而设置的外部链接的准确性和完整性，同时，对于该等外部链接指向的不由本站实际控制的任何网页上的内容，本站不承担任何责任。

7.4 对于因不可抗力或本站不能控制的原因造成的网络服务中断或其它缺陷，本站不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。

7.5 对于站向用户提供的下列产品或者服务的质量缺陷本身及其引发的任何损失，本站无需承担任何责任：
(1)本站向用户免费提供的各项网络服务；
(2)本站向用户赠送的任何产品或者服务。

7.6 本站有权于任何时间暂时或永久修改或终止本服务(或其任何部分)，而无论其通知与否，本站对用户和任何第三人均无需承担任何责任。

8.1 本协议的订立、执行和解释及争议的解决均应适用中华人民共和国法律。

8.2 如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，本协议的其余条款仍应有效并且有约束力。

8.3 本协议解释权及修订权归康永敢个人所有。
');