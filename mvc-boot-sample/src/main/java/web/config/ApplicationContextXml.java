package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by CQU-CST-WuErli on 2017/3/2 at 15:57.
 * Description :
 * Copyright (c) 2017 CQU_CST_WuErli. All rights reserved.
 */
@Configuration
@ComponentScan(basePackages = {"web"},
        //将之前DispatcherServletXml设置过的那个包排除了；也就是说，这两个扫描机制作用的范围正交
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class ApplicationContextXml {
}
