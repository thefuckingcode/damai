package com.taobao.accs.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;

@TargetApi(21)
/* compiled from: Taobao */
public class AccsJobService extends JobService {
    private static final String TAG = "AccsJobService";

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        ALog.d(TAG, "onStartJob", new Object[0]);
        try {
            String packageName = getPackageName();
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(packageName, AdapterUtilityImpl.channelService);
            IntentDispatch.dispatchIntent(getApplicationContext(), intent);
        } catch (Throwable th) {
            ALog.e(TAG, "onStartJob", th, new Object[0]);
        }
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        try {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(getPackageName(), AdapterUtilityImpl.channelService);
            IntentDispatch.dispatchIntent(getApplicationContext(), intent);
        } catch (Throwable th) {
            ALog.e(TAG, "onStopJob", th, new Object[0]);
        }
        return false;
    }
}
