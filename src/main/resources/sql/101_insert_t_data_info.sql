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


