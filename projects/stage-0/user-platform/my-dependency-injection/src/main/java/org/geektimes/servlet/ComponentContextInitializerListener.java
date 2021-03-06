package org.geektimes.servlet;

import org.geektimes.context.ComponentContext;

import javax.servlet.*;
import java.util.Set;

/**
 * {@link ComponentContext} 初始化器
 * ContextLoaderListener
 */
public class ComponentContextInitializerListener implements ServletContextListener{

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
//        Controller component = context.getComponent("bean/UserController");
//        try {
//            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
//
//            ObjectName configName = new ObjectName("org.geektimes.demo:type=ConfigInfo");
//            //create mbean and register mbean
//            server.registerMBean(new ConfigInfo(), configName);
//        } catch (MalformedObjectNameException e) {
//            e.printStackTrace();
//        } catch (InstanceAlreadyExistsException e) {
//            e.printStackTrace();
//        } catch (MBeanRegistrationException e) {
//            e.printStackTrace();
//        } catch (NotCompliantMBeanException e) {
//            e.printStackTrace();
//        }



    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ComponentContext context = ComponentContext.getInstance();
//        context.destroy();
    }
}
