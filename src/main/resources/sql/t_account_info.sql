drop table if exists t_account_info;

create table t_account_info(
  account_id int(10) auto_increment comment '账户id,主键' primary key,
  user_id int(10) comment '用户id',
  account_no varchar(50) comment '账户',
  account_name varchar(50) comment '账户名称',
  ref_account_id int(10) comment '关联账户',
  phone varchar(20) comment '绑定手机号',
  email varchar(50) comment '绑定邮箱',
  purpose varchar(50) comment '用途',
  description varchar(300) comment '描述',
  creator varchar(50) comment '创建人',
  create_time timestamp comment '创建时间',
  updater varchar(50) comment '修改人',
  last_modify_time timestamp comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;