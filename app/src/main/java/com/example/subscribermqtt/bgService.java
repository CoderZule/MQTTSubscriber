package com.example.subscribermqtt;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;


public class bgService extends Service {

    private MqttAsyncClient mqttClient;
    private final IBinder binder = new LocalBinder();


    public class LocalBinder extends Binder {
        public bgService getService() {
            return bgService.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;
    }

 }
