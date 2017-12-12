drop table if exists t_user_info;

create table t_user_info(
  user_id int(10) auto_increment comment '用户id,主键' primary key,
  username varchar(200) comment '用户名',
  email varchar(100) comment '绑定邮箱',
  phone varchar(20) comment '绑定手机号',
  role_id int(10) comment '角色ID',
  login_password varchar(100) comment '登录密码',
  deal_password varchar(100) comment '交易密码',
  real_name varchar(200) comment '用户姓名',
  alias varchar(200) comment '别名',
  create_time timestamp comment '创建时间',
  last_modify_time timestamp comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;