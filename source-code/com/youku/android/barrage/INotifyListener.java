package com.youku.android.barrage;

import android.view.SurfaceHolder;

/* compiled from: Taobao */
public interface INotifyListener {
    void barrageLeave(long j);

    void barrageShow(long j);

    void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    void onSurfaceCreated(SurfaceHolder surfaceHolder);

    void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
}
