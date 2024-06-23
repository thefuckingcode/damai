package com.taobao.weex.render;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class WXAbstractRenderContainer extends FrameLayout {
    protected boolean mHasConsumeEvent = false;
    protected WeakReference<WXSDKInstance> mSDKInstance;

    public WXAbstractRenderContainer(@NonNull Context context) {
        super(context);
    }

    public void createInstanceRenderView(String str) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mHasConsumeEvent = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean hasConsumeEvent() {
        return this.mHasConsumeEvent;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        WXSDKInstance wXSDKInstance;
        super.onSizeChanged(i, i2, i3, i4);
        WeakReference<WXSDKInstance> weakReference = this.mSDKInstance;
        if (weakReference != null && (wXSDKInstance = weakReference.get()) != null) {
            wXSDKInstance.setSize(i, i2);
        }
    }

    public void setSDKInstance(WXSDKInstance wXSDKInstance) {
        this.mSDKInstance = new WeakReference<>(wXSDKInstance);
    }

    public WXAbstractRenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WXAbstractRenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public WXAbstractRenderContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
