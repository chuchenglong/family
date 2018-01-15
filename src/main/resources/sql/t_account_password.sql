drop table if exists t_account_password;

create table t_account_password(
  password_id int(10) auto_increment comment '密码id,主键' primary key,
  account_id int(10) comment '账户id',
  password_type varchar(10) comment '密码类型',
  password varchar(50) comment '密码',
  creator varchar(50) comment '创建人',
  create_time timestamp comment '创建时间',
  updater varchar(50) comment '修改人',
  last_modify_time timestamp comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;