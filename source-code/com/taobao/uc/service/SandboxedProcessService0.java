package com.taobao.uc.service;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.uc.sandboxExport.SandboxedProcessService;

/* compiled from: Taobao */
public class SandboxedProcessService0 extends SandboxedProcessService {
    @Override // com.uc.sandboxExport.SandboxedProcessService
    public IBinder onBind(Intent intent) {
        Log.i("sandbox", intent.toString());
        return super.onBind(intent);
    }

    @Override // com.uc.sandboxExport.SandboxedProcessService
    public void onCreate() {
        super.onCreate();
        Log.i("sandbox", "use sandboxed process");
    }

    @Override // com.uc.sandboxExport.SandboxedProcessService
    public void onDestroy() {
        super.onDestroy();
    }
}
