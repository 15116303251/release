package com.king.dubbo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.king.dubbo.user.dao", sqlSessionTemplateRef = "userSqlSessionTemplate")

public class UserDataSourceConfig {

    @Value("${spring.datasource.user.jdbc-url}")
    private String url;

    @Value("${spring.datasource.user.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.user.username}")
    private String username;

    @Value("${spring.datasource.user.password}")
    private String password;

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource getDataSource(){

        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory demoSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/king/dubbo/user/dao/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager demoTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate demoSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
