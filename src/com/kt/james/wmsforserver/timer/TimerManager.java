package com.kt.james.wmsforserver.timer;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class TimerManager {

    private static TimerManager mInstance;

    private List<AutoSaleTask> mTaskQueue;

    private Timer mTimer;

    {
        mTaskQueue = new LinkedList<>();
        mTaskQueue.add(new AutoSaleTask());
    }

    private TimerManager() {
        mTimer = new Timer();
    }

    public static TimerManager getInstance() {
        if (mInstance == null) {
            synchronized (TimerManager.class) {
                if (mInstance == null) {
                    mInstance = new TimerManager();
                }
            }
        }
        return mInstance;
    }

    public void init() {
        for (BaseTimerTask task : mTaskQueue) {
            mTimer.schedule(task.getTask(), task.getStartTime(), task.getInterval());
        }
    }


}
