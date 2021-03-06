package com.kt.james.wmsforserver.timer;

import com.kt.james.wmsforserver.core.RuntimeCore;
import com.kt.james.wmsforserver.util.TimeUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class AutoSaleTask implements BaseTimerTask {

    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;  //24小时执行一次


    @Override
    public TimerTask getTask() {
        return new TimerTask() {
            @Override
            public void run() {
                RuntimeCore.execAutoSalePython();
            }
        };
    }

    @Override
    public long getInterval() {
        return PERIOD_DAY;
    }

    @Override
    public Date getStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 39);
        calendar.set(Calendar.SECOND, 0);
        Date date=calendar.getTime();
        if (date.before(new Date())) {
            date = TimeUtils.addDay(date, 1);
        }
        return date;
    }

}
