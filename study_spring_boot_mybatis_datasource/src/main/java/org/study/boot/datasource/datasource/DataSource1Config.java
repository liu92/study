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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * ClassName: DataSource1Config
 * Description: 数据源配置1 , 这个配置就是和spring 里面 的xml配置一样，只不过是通过java类 通过
 * Date:     2019/3/24 16:55
 * History:
 * <version> 1.0
 * @author lin
 */
@Configuration

@MapperScan(basePackages = "com.base.mapper.test1",sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSource1Config {

    /**
     * @MapperScan 该注解指名扫描dao层，并且将dao层注入到指定的sqlSessionTemplate, 所以的@Bean都需要按照命令指定
     * prefix(前缀) = "spring.datasource.test1" 表示配置文件中那个下面的所有属性
     **/


    /**
     * @Description  1、创建dataSource，2、创建SqlSessionFactory ,3、再创建事务 ，4、最后包装到SqlSessionTemplate
     * @param
     * @return javax.sql.DataSource
     * @exception   
     * @author lin
     * @Date 17:28 2019/3/24
     **/
    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    @Primary
    public DataSource testDateSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/Bank1Mapper.xml"));
        return  bean.getObject();
    }

    @Bean("test1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return  new SqlSessionTemplate(sqlSessionFactory);
    }
}
