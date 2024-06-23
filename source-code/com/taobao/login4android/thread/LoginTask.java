package com.taobao.login4android.thread;

import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;

/* compiled from: Taobao */
public abstract class LoginTask implements Runnable {
    public static final String TAG = "logni.LoginTask";

    public abstract void excuteTask();

    public void run() {
        try {
            excuteTask();
        } catch (Exception e) {
            LoginStatus.resetLoginFlag();
            LoginTLogAdapter.w(TAG, "LoginTask excute failed, reset login status", e);
            e.printStackTrace();
        }
    }
}
