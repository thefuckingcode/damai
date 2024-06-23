package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class DexClassLoaderProviderService extends Service {
    private static final String LOGTAG = "dexloader";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onCreate()");
        DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onStartCommand(" + intent + ")");
        if (intent == null) {
            return 1;
        }
        try {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
            if (stringArrayListExtra == null) {
                return 1;
            }
            String str = stringArrayListExtra.get(1);
            String str2 = stringArrayListExtra.get(2);
            String str3 = stringArrayListExtra.get(3);
            Log.d(LOGTAG, "DexClassLoaderProviderService -- onStartCommand(" + stringArrayListExtra.get(0) + ")");
            ClassLoader classLoader = getClassLoader();
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, getApplicationContext());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        Log.d(LOGTAG, "DexClassLoaderProviderService -- onDestroy()");
        System.exit(0);
    }
}
