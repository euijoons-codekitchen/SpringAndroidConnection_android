package com.example.recyclerviewprj;

import android.app.Application;

public class GlobalApplication extends Application {

    private static GlobalApplication obj = null;

    @Override
    public void onCreate() {
        super.onCreate();
        obj = this;
    }

    public static GlobalApplication getGlobalApplicationContext(){
        return obj;
    }
}
