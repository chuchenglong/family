drop table if exists t_user_info;

create table t_user_info(
  user_id int(10) auto_increment comment '用户id,主键' primary key,
  username varchar(50) comment '用户名',
  email varchar(50) comment '绑定邮箱',
  phone varchar(20) comment '绑定手机号',
  role_id int(10) comment '角色ID',
  login_password varchar(50) comment '登录密码',
  deal_password varchar(50) comment '交易密码',
  real_name varchar(50) comment '用户姓名',
  alias varchar(50) comment '别名',
  gender varchar(50) comment '性别',
  photo varchar(100) comment '人物头像',
  brief varchar(100) comment '简介',
  create_time timestamp comment '创建时间',
  last_modify_time timestamp comment '最后修改时间'
) engine=innodb auto_increment=1000000001 default charset=utf8;