package com.example.doinmac2.okhttp;

import android.util.Log;

public class MyTask implements Runnable {
    String TAG="八";
    private  int taskNum;
    public MyTask(int num){
        this.taskNum=num;
    }
    @Override
    public void run() {
        Log.d(TAG, "run: "+"执行开始"+taskNum);
        try{

            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "run: "+"执行完毕"+taskNum);
    }
}
