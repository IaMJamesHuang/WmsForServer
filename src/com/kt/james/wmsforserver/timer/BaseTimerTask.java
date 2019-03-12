package com.kt.james.wmsforserver.timer;

import java.util.Date;
import java.util.TimerTask;

public interface BaseTimerTask {

    TimerTask getTask();

    long getInterval();

    Date getStartTime();

}
