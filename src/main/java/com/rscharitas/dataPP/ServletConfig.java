package com.rscharitas.dataPP;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
import org.thymeleaf.extras.tiles2.spring.web.configurer.ThymeleafTilesConfigurer;
import org.thymeleaf.extras.tiles2.spring.web.view.ThymeleafTilesView;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/26/13
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public ITemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");

        resolver.setTemplateMode("HTML5");

        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        Set<IDialect> additionalDialects = new HashSet<IDialect>();
        additionalDialects.add(new TilesDialect());
        additionalDialects.add(new ConditionalCommentsDialect());
        engine.setAdditionalDialects(additionalDialects);
        return engine;
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setViewClass(ThymeleafTilesView.class);
        resolver.setTemplateEngine(templateEngine());
//        resolver.setOrder(0);
        return resolver;
    }

    //    @Bean
//    public SpringTemplateEngine templateEngine(){
//        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
//        springTemplateEngine.setTemplateResolver(templateResolver());
//        Set<IDialect> additionalDialects = new HashSet<IDialect>();
//        additionalDialects.add(new TilesDialect());
//        springTemplateEngine.setAdditionalDialects(additionalDialects);
//        return springTemplateEngine;
//    }
    @Bean
    public TilesConfigurer tilesConfigurer() {
        ThymeleafTilesConfigurer configurer = new ThymeleafTilesConfigurer();
        configurer.setDefinitions(new String[]{"/WEB-INF/**/views.xml"});
        return configurer;
    }


}


