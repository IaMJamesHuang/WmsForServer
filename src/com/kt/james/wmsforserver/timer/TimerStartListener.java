package com.kt.james.wmsforserver.timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        TimerManager.getInstance().init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
