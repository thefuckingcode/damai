package com.tencent.smtt.export.external.embeddedwidget.interfaces;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;

public interface IEmbeddedWidgetClient {
    void onActive();

    void onDeactive();

    void onDestroy();

    void onRectChanged(Rect rect);

    void onRequestRedraw();

    void onSurfaceCreated(Surface surface);

    void onSurfaceDestroyed(Surface surface);

    boolean onTouchEvent(MotionEvent motionEvent);

    void onVisibilityChanged(boolean z);
}
