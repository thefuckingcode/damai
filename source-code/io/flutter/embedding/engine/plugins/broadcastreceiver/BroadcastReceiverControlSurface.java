package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* compiled from: Taobao */
public interface BroadcastReceiverControlSurface {
    void attachToBroadcastReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull Lifecycle lifecycle);

    void detachFromBroadcastReceiver();
}
