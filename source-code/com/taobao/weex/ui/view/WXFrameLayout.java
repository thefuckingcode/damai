package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: Taobao */
public class WXFrameLayout extends BaseFrameLayout implements WXGestureObservable, IRenderStatus<WXDiv>, IRenderResult<WXDiv> {
    private WeakReference<WXDiv> mWeakReference;
    private WXGesture wxGesture;

    public WXFrameLayout(Context context) {
        super(context);
    }

    private int calLayerDeep(View view, int i) {
        int i2 = i + 1;
        return (view.getParent() == null || !(view.getParent() instanceof View)) ? i2 : calLayerDeep((View) view.getParent(), i2);
    }

    private int reportLayerOverFlowError() {
        int calLayerDeep = calLayerDeep(this, 0);
        if (getComponent() != null) {
            String instanceId = getComponent().getInstanceId();
            WXErrorCode wXErrorCode = WXErrorCode.WX_RENDER_ERR_LAYER_OVERFLOW;
            WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "draw android view", wXErrorCode.getErrorMsg() + "Layer overflow limit error: " + calLayerDeep + " layers!", null);
        }
        return calLayerDeep;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.view.BaseFrameLayout
    public void dispatchDraw(Canvas canvas) {
        WXSDKInstance y;
        try {
            super.dispatchDrawInterval(canvas);
        } catch (Throwable th) {
            if (getComponent() != null) {
                notifyLayerOverFlow();
                if (!(getComponent() == null || (y = WXSDKManager.v().y(getComponent().getInstanceId())) == null || y.getApmForInstance() == null || y.getApmForInstance().n)) {
                    y.getApmForInstance().n = true;
                    reportLayerOverFlowError();
                }
            }
            WXLogUtils.e("Layer overflow limit error", WXLogUtils.getStackTrace(th));
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? dispatchTouchEvent | wXGesture.onTouch(this, motionEvent) : dispatchTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public void notifyLayerOverFlow() {
        WXSDKInstance instance;
        if (!(getComponent() == null || (instance = getComponent().getInstance()) == null || instance.getLayerOverFlowListeners() == null)) {
            for (String str : instance.getLayerOverFlowListeners()) {
                WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(instance.getInstanceId(), str);
                HashMap hashMap = new HashMap();
                hashMap.put("ref", str);
                hashMap.put("instanceid", wXComponent.getInstanceId());
                wXComponent.fireEvent(Constants.Event.LAYEROVERFLOW, hashMap);
            }
        }
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.IRenderResult
    @Nullable
    public WXDiv getComponent() {
        WeakReference<WXDiv> weakReference = this.mWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void holdComponent(WXDiv wXDiv) {
        this.mWeakReference = new WeakReference<>(wXDiv);
    }
}
