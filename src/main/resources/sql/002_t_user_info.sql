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
  alias varchar(50) default null comment '别名',
  gender varchar(50) default null comment '性别',
  photo varchar(100) default null comment '人物头像',
  brief varchar(100) default null comment '个人简介',
  status varchar(50) not null comment '用户状态',
  create_time timestamp not null comment '创建时间',
  last_modify_time timestamp not null comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;