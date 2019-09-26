package example.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoheitalk
 * @type AppBootListener
 * @date 2019/9/25 20:15
 */
@SpringBootApplication(scanBasePackages = "example.service")
public class AppBootListener extends ContextLoader implements ServletContextListener {

    @Nullable
    private static volatile WebApplicationContext currentContext;

    private static final Map<ClassLoader, WebApplicationContext> currentContextPerThread =
            new ConcurrentHashMap<>(1);


    public AppBootListener() {
    }

    /**
     * Initialize the root web application context.
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
//        initWebApplicationContext(servletContext);

        ConfigurableApplicationContext context = SpringApplication.run(AppBootListener.class);

        if (context instanceof ConfigurableWebApplicationContext) {
            ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) context;
            if (!cwac.isActive()) {
                // The context has not yet been refreshed -> provide services such as
                // setting the parent context, setting the application context id, etc
                if (cwac.getParent() == null) {
                    // The context instance was injected without an explicit parent ->
                    // determine parent for root web application context, if any.
                    ApplicationContext parent = loadParentContext(servletContext);
                    cwac.setParent(parent);
                }
                configureAndRefreshWebApplicationContext(cwac, servletContext);
            }
        }
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);

//        ClassLoader ccl = Thread.currentThread().getContextClassLoader();
//        if (ccl == ContextLoader.class.getClassLoader()) {
//            currentContext = context;
//        }
//        else if (ccl != null) {
//            currentContextPerThread.put(ccl, context);
//        }

    }


    /**
     * Close the root web application context.
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
//        closeWebApplicationContext(event.getServletContext());
//        ContextCleanupListener.cleanupAttributes(event.getServletContext());
    }

}
