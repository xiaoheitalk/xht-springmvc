package example.listener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author xiaoheitalk
 * @type AppBoot
 * @date 2019/9/25 20:43
 */
@SpringBootApplication(scanBasePackages = "example.service")
//@ComponentScan(basePackages = {"example"},
//        excludeFilters = {
//                //将之前DispatcherServletXml设置过的那个包排除了；也就是说，这两个扫描机制作用的范围正交
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//        })
public class AppBoot {
}
