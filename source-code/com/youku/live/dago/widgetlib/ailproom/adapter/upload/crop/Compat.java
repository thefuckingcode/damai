package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.os.Build;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class Compat {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int SIXTY_FPS_INTERVAL = 16;

    public static int getPointerIndex(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "300013030")) {
            return getPointerIndexHoneyComb(i);
        }
        return ((Integer) ipChange.ipc$dispatch("300013030", new Object[]{Integer.valueOf(i)})).intValue();
    }

    private static int getPointerIndexHoneyComb(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-765935944")) {
            return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        }
        return ((Integer) ipChange.ipc$dispatch("-765935944", new Object[]{Integer.valueOf(i)})).intValue();
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409087322")) {
            ipChange.ipc$dispatch("409087322", new Object[]{view, runnable});
        } else if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802664182")) {
            ipChange.ipc$dispatch("-1802664182", new Object[]{view, runnable});
            return;
        }
        view.postOnAnimation(runnable);
    }
}
