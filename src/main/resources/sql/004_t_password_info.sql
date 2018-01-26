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
