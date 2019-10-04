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
@MapperScan(basePackages = "com.king.dubbo.weixin.dao", sqlSessionTemplateRef = "wxSqlSessionTemplate")
public class WeiXinDataSourceConfig {

    @Value("${spring.datasource.weixin.jdbc-url}")
    private String url;

    @Value("${spring.datasource.weixin.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.weixin.username}")
    private String username;

    @Value("${spring.datasource.weixin.password}")
    private String password;

    @Bean(name = "wxDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.weixin")
    public DataSource getDataSource(){

        DruidDataSource  dataSource=new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "wxSqlSessionFactory")
    public SqlSessionFactory demoSqlSessionFactory(@Qualifier("wxDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/king/dubbo/weixin/dao/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "wxTransactionManager")
    public DataSourceTransactionManager demoTransactionManager(@Qualifier("wxDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "wxSqlSessionTemplate")
    public SqlSessionTemplate demoSqlSessionTemplate(@Qualifier("wxSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
