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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.king.dubbo.animal.dao", sqlSessionTemplateRef = "demoSqlSessionTemplate")
public class DemoDataSourceConfig {

    @Value("${spring.datasource.demo.jdbc-url}")
    private String url;

    @Value("${spring.datasource.demo.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.demo.username}")
    private String username;

    @Value("${spring.datasource.demo.password}")
    private String password;

    @Bean(name = "demoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.demo")
    @Primary
    public DataSource getDataSource(){

        DruidDataSource  dataSource=new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
//      return DataSourceBuilder.create().build();
    }

    @Bean(name = "demoSqlSessionFactory")
    @Primary
    public SqlSessionFactory demoSqlSessionFactory(@Qualifier("demoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/king/dubbo/animal/dao/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "demoTransactionManager")
    @Primary
    public DataSourceTransactionManager demoTransactionManager(@Qualifier("demoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "demoSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate demoSqlSessionTemplate(@Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
