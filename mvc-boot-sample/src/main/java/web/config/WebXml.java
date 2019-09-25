package web.config;

import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 负责配置DispatcherServlet、初始化Spring MVC容器和Spring容器
 *
 * Created by CQU-CST-WuErli on 2017/3/2 at 15:56.
 * Description :
 * Copyright (c) 2017 CQU_CST_WuErli. All rights reserved.
 */
public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
    根容器; 用于获取Spring应用容器的配置文件
     <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>/WEB-INF/applicationContext.xml</param-value>
     </context-param>
     <listener>
         <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     </listener>
      */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationContextXml.class};
    }

    /*
    Spring mvc容器；负责获取Spring MVC应用容器
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <!--配置dispatcher.xml作为mvc的配置文件-->
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {DispatcherServletXml.class};
    }

    /*
    DispatcherServlet映射,从"/"开始；负责指定需要由DispatcherServlet映射的路径，
    这里给定的是"/"，意思是由DispatcherServlet处理所有向该应用发起的请求
    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
