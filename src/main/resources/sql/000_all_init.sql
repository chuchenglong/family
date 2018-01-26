-- ------------------------------
-- 数据字典信息表
-- ------------------------------
drop table if exists t_data_info;

create table t_data_info(
  id int(10) not null auto_increment comment '数据字典id,主键' primary key,
  parent_code varchar(50) not null comment '父节点ID',
  data_code varchar(50) not null comment 'CODE',
  data_name varchar(50) not null comment '名称',
  display varchar(50) not null comment '显示名称',
  description varchar(300) default null comment '描述',
  creator varchar(50) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  updater varchar(50) not null comment '修改人',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;

-- ------------------------------
-- 用户信息表
-- ------------------------------
drop table if exists t_user_info;

create table t_user_info(
  id int(10) not null auto_increment comment '用户id,主键' primary key,
  username varchar(50) default null comment '用户名',
  email varchar(50) default null comment '邮箱',
  phone varchar(20) default null comment '手机号',
  role_id int(10) default null comment '角色ID',
  cert_type varchar(50) default null comment '证件类型',
  cert_no varchar(50) default null comment '证件号码',
  real_name varchar(50) default null comment '真实姓名',
  alias varchar(50) default null comment '昵称',
  gender varchar(50) default null comment '性别',
  photo varchar(100) default null comment '人物头像',
  brief varchar(100) default null comment '个人简介',
  status varchar(50) not null comment '用户状态',
  create_time timestamp not null comment '创建时间',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;

-- ------------------------------
-- 账户信息表
-- ------------------------------
drop table if exists t_account_info;

create table t_account_info(
  id int(10) not null auto_increment comment '账户id,主键' primary key,
  user_id int(10) not null comment '用户id',
  username varchar(50) default null comment '用户名',
  phone varchar(20) default null comment '手机号',
  email varchar(50) default null comment '邮箱',
  company varchar(50) not null comment '所属公司',
  product varchar(50) not null comment '适用产品',
  classify varchar(50) default null comment '类别',
  alias varchar(50) default null comment '别名',
  description varchar(300) default null comment '描述',
  rel_id int(10) default null comment '关联账户',
  creator varchar(50) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  updater varchar(50) not null comment '修改人',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;

-- ------------------------------
-- 密码信息表
-- ------------------------------
drop table if exists t_password_info;

create table t_password_info(
  id int(10) not null auto_increment comment '密码id,主键' primary key,
  rel_id int(10) not null comment '关联账户',
  rel_type varchar(50) not null comment '关联类型, 本系统/他系统',
  password_type varchar(50) not null comment '密码类型, 登录/查询/支付',
  password varchar(50) not null comment '密码',
  creator varchar(50) not null comment '创建人',
  create_time timestamp not null comment '创建时间',
  updater varchar(50) not null comment '修改人',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;







insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
values('top', 'daily', '日常管理', '日常管理', '日常管理的TOP层初始化数据', 'system', now(), 'system', now());

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account', '日常账户管理', '日常账户管理', '归属于日常管理daily的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company', '账户所属公司', '账户所属公司', '归属于日常账户管理daily_account的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify', '账户类别', '账户类别', '归属于日常账户管理daily_account的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account';

-- -----------------------
-- 账户所属公司
-- -----------------------
insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_99999', '未知', '未知', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_00001', '腾讯', '腾讯', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_00002', '阿里巴巴', '阿里巴巴', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_00003', '百度', '百度', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_00004', '网易', '网易', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_00005', '京东', '京东', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_company_00006', '暴风', '暴风', '归属于账户所属公司daily_account_company的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company';

-- -----------------------
-- 公司产品
-- -----------------------
insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00001', 'QQ', 'QQ', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00002', '微信', '微信', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00003', '欢乐斗地主', '欢乐斗地主', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00004', '王者荣耀', '王者荣耀', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00005', 'QQ阅读', 'QQ阅读', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00006', '腾讯新闻', '腾讯新闻', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00007', '腾讯视频', '腾讯视频', '归属于腾讯daily_account_company_00001的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00001';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00008', '淘宝', '淘宝', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00009', '天猫', '天猫', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00010', '支付宝', '支付宝', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00011', '淘票票', '淘票票', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00012', '口碑', '口碑', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00013', '优酷', '优酷', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00014', '滴滴出行', '滴滴出行', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_product_00015', '虾米音乐', '虾米音乐', '归属于阿里巴巴daily_account_company_00002的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_company_00002';

-- -----------------------
-- 账户类别
-- -----------------------
insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_001', '社交类', '社交类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_002', '视频类', '视频类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_003', '新闻类', '新闻类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_004', '音乐类', '音乐类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_005', '搜索类', '搜索类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_006', '金融类', '金融类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_007', '学习类', '学习类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';

insert into t_data_info(parent_code,data_code,data_name,display,description,creator,create_time,updater,last_modify_time)
select data_code, 'daily_account_classify_008', '工具类', '工具类', '归属于账户类别daily_account_classify的下一层', 'system', now(), 'system', now() from t_data_info where data_code = 'daily_account_classify';



