package com.example.eduardo.archandroidapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by eduardo on 07/07/17.
 */

public class MainViewModel extends ViewModel {

    private final MutableLiveData<String> name =  new MutableLiveData<>();
    private static final String x = "mah oe";

    public MainViewModel() {
        name.setValue("mah oe");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long l = SystemClock.elapsedRealtime();
                final String msg = x + " " + String.valueOf(l);
                Log.d(x, msg);

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        name.setValue(msg);
                    }
                });
            }
        }, 1000, 1000);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void doSomething() {

    }
}
