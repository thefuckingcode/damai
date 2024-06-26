package com.google.vr.ndk.base;

import android.view.ViewGroup;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;

/* compiled from: Taobao */
public interface ExtensionManager {
    void initialize(ViewGroup viewGroup, GvrApi gvrApi);

    void onPause();

    void onResume();

    void reportTelemetry(IVrCoreLoggingService iVrCoreLoggingService);

    void shutdown();
}
