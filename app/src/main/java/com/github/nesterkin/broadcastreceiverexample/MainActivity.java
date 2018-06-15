package com.github.nesterkin.broadcastreceiverexample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "com.nesterkin.SEND_STATE_FILTER";
    public static final String PERMISSION = "com.nesterkin.SEND_STATE_PERMISSION";
    public static final String STATE = "State";

    private static final String LOG = MainActivity.class.getName();
    private TextView mTextView;
    private Button mButton;

    private MyReceiver mReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.text_view);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent();
            }
        });

        mReceiver = new MyReceiver(new ViewCallbackImpl());
        mIntentFilter = new IntentFilter(ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter, PERMISSION, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    private void sendIntent() {
        Log.v(LOG, "generate start");
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);

        Log.v(LOG, "generate end");
    }

    private class ViewCallbackImpl implements ViewCallback {
        @Override
        public void onStateChange(String state) {
            mTextView.setText(state);
        }
    }
}