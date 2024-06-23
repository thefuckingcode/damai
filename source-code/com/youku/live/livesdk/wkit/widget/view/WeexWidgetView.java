package com.youku.live.livesdk.wkit.widget.view;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.youku.live.livesdk.wkit.view.LoadingRetryView;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener;
import com.youku.live.widgets.widgets.weex.WeexInstance;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WeexWidgetView extends FrameLayout implements IWXRenderListener, WXSDKInstance.OnInstanceVisibleListener, IDestroyable, IActivityResumeStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WX_PAGE_APPEAR = "DAGOPageAppear";
    public static final String WX_PAGE_DISAPPEAR = "DAGOPageDisappear";
    public static final String WX_PAGE_FOREGROUND = "DAGOPageForeground";
    public static final String WX_PAGE_KEY = "state";
    public static final String WX_PAGE_STATE_CHANGED = "DAGOPageStateChanged";
    private final String ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
    private final String ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
    private final String ORIENTATION_PORTRAIT = "portrait";
    private final String ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
    private String currentAngleORIENTATION = "portrait";
    private int currentScreenStyle = 1;
    private IEngineInstance mEngineInstance;
    private LoadingRetryView mErrorRetryView;
    private WXGlobalEventReceiver mGlobalEventReceiver;
    private boolean mInBackground = false;
    private String mJsonInitData;
    private boolean mLastDisappear = false;
    private Map<String, Object> mOptions;
    private boolean mRefreshSuccess;
    private boolean mRenderSuccess;
    private String mTemplateUrl;
    private IWXRenderListener mWXRenderListener;
    private WeexInstance mWeexInstance;

    public WeexWidgetView(@NonNull Context context) {
        super(context);
    }

    private void fireGlobalEventImpl(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496546512")) {
            ipChange.ipc$dispatch("1496546512", new Object[]{this, str, map});
            return;
        }
        WeexInstance weexInstance = getWeexInstance();
        if (weexInstance != null) {
            weexInstance.fireGlobalEventCallback(str, map);
        }
    }

    private LoadingRetryView getErrorRetryView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653456857")) {
            return (LoadingRetryView) ipChange.ipc$dispatch("-653456857", new Object[]{this});
        }
        LoadingRetryView loadingRetryView = this.mErrorRetryView;
        if (loadingRetryView != null) {
            return loadingRetryView;
        }
        LoadingRetryView loadingRetryView2 = new LoadingRetryView(getContext());
        loadingRetryView2.setBackButtonVisible(false);
        loadingRetryView2.setBackgroundVisible(false);
        loadingRetryView2.setRetryListener(new View.OnClickListener() {
            /* class com.youku.live.livesdk.wkit.widget.view.WeexWidgetView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-850084548")) {
                    ipChange.ipc$dispatch("-850084548", new Object[]{this, view});
                    return;
                }
                LoadingRetryView loadingRetryView = WeexWidgetView.this.mErrorRetryView;
                if (loadingRetryView != null) {
                    loadingRetryView.hideRetry();
                    loadingRetryView.startLoading();
                    WeexWidgetView weexWidgetView = WeexWidgetView.this;
                    weexWidgetView.render(weexWidgetView.mTemplateUrl, WeexWidgetView.this.mOptions, WeexWidgetView.this.mJsonInitData);
                }
            }
        });
        addView(loadingRetryView2, new ViewGroup.LayoutParams(-1, -1));
        this.mErrorRetryView = loadingRetryView2;
        return loadingRetryView2;
    }

    private WeexInstance getWeexInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321291280")) {
            return (WeexInstance) ipChange.ipc$dispatch("-321291280", new Object[]{this});
        }
        if (this.mWeexInstance == null) {
            synchronized (this) {
                if (this.mWeexInstance == null) {
                    this.mWeexInstance = new WeexInstance();
                }
            }
            setInstanceConfig();
        }
        return this.mWeexInstance;
    }

    private void setInstanceConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-538007309")) {
            ipChange.ipc$dispatch("-538007309", new Object[]{this});
            return;
        }
        WeexInstance weexInstance = this.mWeexInstance;
        if (weexInstance != null) {
            weexInstance.init(getContext());
            weexInstance.registerRenderListener(this);
            weexInstance.addOnInstanceVisibleListener(this);
            IEngineInstance iEngineInstance = this.mEngineInstance;
            if (iEngineInstance != null) {
                weexInstance.bindEngineInstance(iEngineInstance);
            }
        }
    }

    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1229510943")) {
            ipChange.ipc$dispatch("1229510943", new Object[]{this, iEngineInstance});
            return;
        }
        this.mEngineInstance = iEngineInstance;
        getWeexInstance().bindEngineInstance(iEngineInstance);
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863166802")) {
            ipChange.ipc$dispatch("1863166802", new Object[]{this});
            return;
        }
        this.mRenderSuccess = false;
        this.mLastDisappear = true;
        WeexInstance weexInstance = this.mWeexInstance;
        if (weexInstance != null) {
            weexInstance.destroy();
            this.mWeexInstance = null;
        }
        removeAllViews();
    }

    public WXSDKInstance getWXSDKInstance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1138522908")) {
            return getWeexInstance();
        }
        return (WXSDKInstance) ipChange.ipc$dispatch("-1138522908", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835656956")) {
            ipChange.ipc$dispatch("-1835656956", new Object[]{this});
            return;
        }
        getWeexInstance().onActivityPause();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576995715")) {
            ipChange.ipc$dispatch("576995715", new Object[]{this});
            return;
        }
        getWeexInstance().onActivityResume();
    }

    public void onActivityStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792552168")) {
            ipChange.ipc$dispatch("-1792552168", new Object[]{this});
            return;
        }
        getWXSDKInstance().onActivityStart();
    }

    public void onActivityStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232067150")) {
            ipChange.ipc$dispatch("232067150", new Object[]{this});
            return;
        }
        getWXSDKInstance().onActivityStop();
    }

    @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
    public void onAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579188074")) {
            ipChange.ipc$dispatch("1579188074", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap(16);
        this.mInBackground = false;
        hashMap.put("state", "DAGOPageAppear");
        fireGlobalEventImpl("DAGOPageStateChanged", hashMap);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923882960")) {
            ipChange.ipc$dispatch("-923882960", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.mGlobalEventReceiver = new WXGlobalEventReceiver(getWeexInstance());
        getContext().registerReceiver(this.mGlobalEventReceiver, new IntentFilter(WXGlobalEventReceiver.EVENT_ACTION));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297153875")) {
            ipChange.ipc$dispatch("297153875", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        if (this.mGlobalEventReceiver != null) {
            getContext().unregisterReceiver(this.mGlobalEventReceiver);
            this.mGlobalEventReceiver = null;
        }
    }

    @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
    public void onDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1342781192")) {
            ipChange.ipc$dispatch("1342781192", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap(16);
        if (!this.mLastDisappear) {
            this.mInBackground = true;
        }
        hashMap.put("state", "DAGOPageDisappear");
        fireGlobalEventImpl("DAGOPageStateChanged", hashMap);
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224379994")) {
            ipChange.ipc$dispatch("-224379994", new Object[]{this, wXSDKInstance, str, str2});
            return;
        }
        if (this.mRenderSuccess) {
            this.mRefreshSuccess = false;
        }
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onException(wXSDKInstance, str, str2);
        }
        if (!this.mRenderSuccess) {
            getErrorRetryView().stopLoading();
            getErrorRetryView().showRetry();
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094437431")) {
            ipChange.ipc$dispatch("2094437431", new Object[]{this, wXSDKInstance, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRefreshSuccess = true;
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onRefreshSuccess(wXSDKInstance, i, i2);
        }
        LoadingRetryView loadingRetryView = this.mErrorRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.hideRetry();
            loadingRetryView.stopLoading();
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738135888")) {
            ipChange.ipc$dispatch("-738135888", new Object[]{this, wXSDKInstance, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRenderSuccess = true;
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onRenderSuccess(wXSDKInstance, i, i2);
        }
        LoadingRetryView loadingRetryView = this.mErrorRetryView;
        if (loadingRetryView != null) {
            loadingRetryView.hideRetry();
            loadingRetryView.stopLoading();
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753670452")) {
            ipChange.ipc$dispatch("-753670452", new Object[]{this, wXSDKInstance, view});
            return;
        }
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        IWXRenderListener iWXRenderListener = this.mWXRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onViewCreated(wXSDKInstance, view);
        }
    }

    public void render(String str, Map<String, Object> map, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1341711197")) {
            ipChange.ipc$dispatch("1341711197", new Object[]{this, str, map, str2});
            return;
        }
        this.mTemplateUrl = str;
        this.mOptions = map;
        this.mJsonInitData = str2;
        if (this.mRenderSuccess) {
            Log.e("WeexWidgetView", "renderImpl; Success");
            getWeexInstance().refreshInstance(map);
            return;
        }
        Log.e("WeexWidgetView", "renderImpl; Success");
        getWeexInstance().renderByUrl(str, str, map, str2, WXRenderStrategy.APPEND_ASYNC);
    }

    public void setRenderListener(IWXRenderListener iWXRenderListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486168664")) {
            ipChange.ipc$dispatch("-486168664", new Object[]{this, iWXRenderListener});
            return;
        }
        this.mWXRenderListener = iWXRenderListener;
    }

    public void setScreenType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "988886015")) {
            ipChange.ipc$dispatch("988886015", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.currentAngleORIENTATION == null) {
            this.currentAngleORIENTATION = i == 1 ? "portrait" : "landscapeLeft";
        }
        HashMap hashMap = new HashMap();
        if (i == 1) {
            if (this.currentAngleORIENTATION.equals("portrait") || this.currentAngleORIENTATION.equals("portraitUpsideDown")) {
                hashMap.put("orientation", this.currentAngleORIENTATION);
            } else {
                this.currentAngleORIENTATION = "portrait";
                hashMap.put("orientation", "portrait");
            }
        } else if (this.currentAngleORIENTATION.equals("landscapeRight") || this.currentAngleORIENTATION.equals("landscapeLeft")) {
            hashMap.put("orientation", this.currentAngleORIENTATION);
        } else {
            this.currentAngleORIENTATION = "landscapeLeft";
            hashMap.put("orientation", "landscapeLeft");
        }
        fireGlobalEventImpl("DAGOOrientationChange", hashMap);
    }

    public WeexWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WeexWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
