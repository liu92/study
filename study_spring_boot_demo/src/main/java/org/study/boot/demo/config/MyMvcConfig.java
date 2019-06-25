package org.study.boot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.study.boot.demo.compoent.MyLocalResolver;

/**
 * @ClassName MyMvcConfig
 * @Description TODO
 * @Author liuwanlin
 * @Date 2019/6/25 16:23
 **/
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {
    // WebMvcConfigurationSupport 扩展SpringMvc的功能


    @Override
    public void  addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/lin").setViewName("success");
    }

    /**
     * 所有的webMvcConfigurationSupport组件都会一起使用
     * 并将组件注入到容器中, 前提是这个容器要知道这个组件的存在，所以要加入@Bean 注解
     * 该方法主要是 来添加视图映射，直接把一个请求映射到那个页面。
     * @return
     */
    @Bean
    public WebMvcConfigurationSupport webMvcConfigurationSupport(){
        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport(){
            @Override
            protected void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
            }
        };
        return  support;
    }


    /**
     * 将 Locale添加到 容器中去就可以使用了
     * @return
     */
    @Bean
    public LocaleResolver resolver(){
        return new MyLocalResolver();
    }
}
