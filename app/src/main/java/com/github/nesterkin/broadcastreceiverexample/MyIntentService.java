package com.github.nesterkin.broadcastreceiverexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import static com.github.nesterkin.broadcastreceiverexample.MainActivity.ACTION;
import static com.github.nesterkin.broadcastreceiverexample.MainActivity.PERMISSION;
import static com.github.nesterkin.broadcastreceiverexample.MainActivity.STATE;

public class MyIntentService extends IntentService {

    private static final String LOG = MyIntentService.class.getName();

    private MyManager mManager = MyManager.getInstance();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v(LOG, "onHandleIntent");
        mManager.changeState();
        Intent broadcastIntent = new Intent(ACTION);
        broadcastIntent.putExtra(STATE, mManager.getState());
        broadcastIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(broadcastIntent, PERMISSION);
    }
}
