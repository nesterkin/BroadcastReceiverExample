package com.github.nesterkin.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.github.nesterkin.broadcastreceiverexample.MainActivity.STATE;

public class MyReceiver extends BroadcastReceiver {

    private ViewCallback mViewCallback;

    public MyReceiver(ViewCallback viewCallback) {
        mViewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mViewCallback.onStateChange(intent.getStringExtra(STATE));
    }
}