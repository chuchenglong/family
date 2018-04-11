package com.mc.family.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import javax.sql.DataSource;

/**
 * @author ChenglongChu
 * @description 支持多数据源连接管理配置
 * @create 2017/12/13 11:09
 * @since v0.1
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@EnableConfigurationProperties(MybatisProperties.class)
public class ConfigDataSource {
    @Autowired
    private MybatisProperties properties;

    @Autowired
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    /**
     * @description 创建主数据源
     * @author ChenglongChu
     * @create 2017/12/14 15:18
    **/
    @Bean(name="primary-datasource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    @Primary
    public DataSource createDataSource() {
        // 根据配置文件信息拿到数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name="primaryDataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryDataSourceTransactionManager(@Qualifier("primary-datasource") DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    /**
     * @description 创建session工厂，供Mybatis使用
     * @param dataSource 数据源
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 15:18
    **/
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("primary-datasource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        factory.setConfiguration(properties.getConfiguration());

        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }
        return factory.getObject();
    }

    /**
     * @description 获取session模板，供Mybatis使用
     * @param sqlSessionFactory session工厂
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 15:19
    **/
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        // 获取Mybatis配置执行器配置信息
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null) {
            // 用Mybatis已配置的执行器
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        } else {
            // 用Mybatis默认执行器SIMPLE
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }


    /**
     * @description 创建第二个数据源
     * @author ChenglongChu
     * @create 2017/11/27 14:32
    **/
    @Bean(name="sec-datasource")
    @ConfigurationProperties(prefix = "spring.datasource.secend")
    public DataSource createSecendDataSource() {
        // 根据配置文件信息拿到数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mqDataSourceTransactionManager")
    public DataSourceTransactionManager mqDataSourceTransactionManager(@Qualifier("sec-datasource") DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    /**
     * @description 第二个数据源的session工厂
     * @param dataSource 数据源
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 15:20
    **/
    @Bean(name = "secSqlSessionFactory")
    public SqlSessionFactory getSecendSqlSessionFactory(@Qualifier("sec-datasource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        factory.setConfiguration(properties.getConfiguration());

        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }
        return factory.getObject();
    }

    /**
     * @description 第二个数据源的session模板
     * @param sqlSessionFactory session工厂
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 15:20
    **/
    @Bean(name = "secSqlSessionTemplate")
    public SqlSessionTemplate getSecendSqlSessionTemplate(@Qualifier("secSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        // 获取Mybatis配置执行器配置信息
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null) {
            // 用Mybatis已配置的执行器
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        } else {
            // 用Mybatis默认执行器SIMPLE
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

}
