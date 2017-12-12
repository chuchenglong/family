package com.mc.family.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChenglongChu
 * @description Mybatis依赖加入和相关配置信息
 * @create 2017/11/27 10:22
 * @since v0.1
 */
@Configuration
@MapperScan(basePackages = "com.mc.family.mapper", sqlSessionFactoryRef = "sqlSessionFactory", sqlSessionTemplateRef = "sqlSessionTemplate")
public class ConfigMybatis {
}
