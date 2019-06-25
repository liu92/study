package org.study.boot.datasource.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * ClassName: DataSource2Config
 * Description: 数据源配置2
 * Date:     2019/3/24 16:55
 * History:
 * <version> 1.0
 * @author lin
 */
@Configuration
@MapperScan(basePackages = "com.base.mapper.test2",sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSource2Config {

    /**
     * @Description 创建DataSource
     * @param
     * @return javax.sql.DataSource
     * @exception   
     * @author lin
     * @Date 18:12 2019/3/24
     **/
    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2DataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/Bank2Mapper.xml"));
        return  bean.getObject();
    }


    @Bean(name = "test2TransactionManager")
    public DataSourceTransactionManager test2TransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate test2SqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
