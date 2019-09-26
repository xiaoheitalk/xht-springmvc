package web.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author xiaoheitalk
 * @type AppBoot
 * @date 2019/9/25 19:55
 */
@SpringBootApplication
@ComponentScan(basePackages = {"web"},
        //将之前DispatcherServletXml设置过的那个包排除了；也就是说，这两个扫描机制作用的范围正交
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class AppBoot {
}
