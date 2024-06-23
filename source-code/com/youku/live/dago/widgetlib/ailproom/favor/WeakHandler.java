package com.youku.live.dago.widgetlib.ailproom.favor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class WeakHandler extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    private WeakReference<IFavorHandler> mHandler;

    public WeakHandler(IFavorHandler iFavorHandler) {
        super(Looper.getMainLooper());
        this.mHandler = new WeakReference<>(iFavorHandler);
    }

    public void handleMessage(Message message) {
        IFavorHandler iFavorHandler;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419590375")) {
            ipChange.ipc$dispatch("1419590375", new Object[]{this, message});
            return;
        }
        WeakReference<IFavorHandler> weakReference = this.mHandler;
        if (weakReference != null && (iFavorHandler = weakReference.get()) != null) {
            iFavorHandler.handleMessage(message);
        }
    }
}
