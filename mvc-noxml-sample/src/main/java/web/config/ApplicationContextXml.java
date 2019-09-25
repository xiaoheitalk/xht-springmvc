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
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class ApplicationContextXml {
}
