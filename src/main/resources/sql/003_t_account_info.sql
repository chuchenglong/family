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