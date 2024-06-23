package com.youku.live.livesdk.wkit.widget.view;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.webview.WVWebView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.utils.ILaifengWebViewBinderInterface;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.activity.IActivityResultListener;
import com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener;
import java.io.IOException;

/* compiled from: Taobao */
public class WebWidgetView extends FrameLayout implements IDestroyable, IActivityResultListener, IActivityResumeStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private CommonJsBridge mCommonJsBridge;
    private IEngineInstance mEngineInstance;
    private WVWebView mWebView;

    /* compiled from: Taobao */
    public static class CommonJsBridge {
        public Runnable mCloseAction;

        @JavascriptInterface
        public void webViewClose() throws IllegalArgumentException, IllegalStateException, IOException {
            Runnable runnable = this.mCloseAction;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public WebWidgetView(@NonNull Context context) {
        super(context);
    }

    private WebView getWebView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605059167")) {
            return (WebView) ipChange.ipc$dispatch("-1605059167", new Object[]{this});
        }
        if (this.mWebView == null) {
            synchronized (this) {
                if (this.mWebView == null) {
                    this.mWebView = new WVWebView(getContext());
                }
            }
            setInstanceConfig();
        }
        return this.mWebView;
    }

    private void setInstanceConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152561846")) {
            ipChange.ipc$dispatch("1152561846", new Object[]{this});
            return;
        }
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null && wVWebView.getParent() == null) {
            addView(wVWebView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (wVWebView != null) {
            CommonJsBridge commonJsBridge = new CommonJsBridge();
            this.mCommonJsBridge = commonJsBridge;
            commonJsBridge.mCloseAction = new Runnable() {
                /* class com.youku.live.livesdk.wkit.widget.view.WebWidgetView.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-455946185")) {
                        ipChange.ipc$dispatch("-455946185", new Object[]{this});
                        return;
                    }
                    final IEngineInstance iEngineInstance = WebWidgetView.this.mEngineInstance;
                    if (iEngineInstance != null) {
                        iEngineInstance.runOnMainThread(new Runnable() {
                            /* class com.youku.live.livesdk.wkit.widget.view.WebWidgetView.AnonymousClass1.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1563647498")) {
                                    ipChange.ipc$dispatch("1563647498", new Object[]{this});
                                    return;
                                }
                                iEngineInstance.closeDialog(null);
                            }
                        });
                    }
                }
            };
            try {
                wVWebView.addJavascriptInterface(this.mCommonJsBridge, "lfJsObj");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            ((ILaifengWebViewBinderInterface) Dsl.getService(ILaifengWebViewBinderInterface.class)).bindWebView(wVWebView, null, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871347166")) {
            ipChange.ipc$dispatch("-871347166", new Object[]{this, iEngineInstance});
            return;
        }
        this.mEngineInstance = iEngineInstance;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494973653")) {
            ipChange.ipc$dispatch("1494973653", new Object[]{this});
            return;
        }
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.destroy();
            this.mWebView = null;
        }
        removeAllViews();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x003b;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "295620447")) {
            return ((Boolean) ipChange.ipc$dispatch("295620447", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            return super.dispatchTouchEvent(motionEvent);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582502521")) {
            ipChange.ipc$dispatch("-582502521", new Object[]{this});
            return;
        }
        getWebView().onPause();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985485")) {
            ipChange.ipc$dispatch("985485", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        WVWebView wVWebView = this.mWebView;
        if (wVWebView != null) {
            wVWebView.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770077536")) {
            ipChange.ipc$dispatch("770077536", new Object[]{this});
            return;
        }
        getWebView().onResume();
    }

    public void render(String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-7301681")) {
            ipChange.ipc$dispatch("-7301681", new Object[]{this, str});
            return;
        }
        try {
            z = ((ILaifengWebViewBinderInterface) Dsl.getService(ILaifengWebViewBinderInterface.class)).loadWebView(getWebView(), str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z) {
            getWebView().loadUrl(str);
        }
    }

    public WebWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
