package com.acuizen.root.devaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;


public class SyncActivity extends Activity {

    AnimatedCircleLoadingView circleLoadingView;
    TextView syncText;
    Button viewTask,syncAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        syncText =  findViewById(R.id.sync_text);
        viewTask =  findViewById(R.id.view_task);
        syncAgain =  findViewById(R.id.sync_again);
        circleLoadingView = findViewById(R.id.circle_loading_view);
        sync();

        syncAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetLoading();
            }
        });

        viewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SyncActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
    }

    int i;
    private void sync(){
        circleLoadingView.startDeterminate();
        startPercentMockThread();

    }


    private void startPercentMockThread() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(1500);
                    for (i = 0; i <= 100; i++) {
                        Thread.sleep(65);
                        changePercent(i);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        new Thread(runnable).start();
        if(new Thread(runnable).isAlive()){
            Log.d("True","true");
            if(i>=100){
                syncText.setText("Sync Completed");
                viewTask.setVisibility(View.VISIBLE);
            }

        }

    }

    private void changePercent(final int percent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                circleLoadingView.setPercent(percent);
            }
        });
    }

    public void resetLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                circleLoadingView.resetLoading();
                sync();
            }
        });
    }

}
