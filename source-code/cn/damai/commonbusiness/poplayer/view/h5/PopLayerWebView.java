package cn.damai.commonbusiness.poplayer.view.h5;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Looper;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebChromeClient;
import android.taobao.windvane.webview.WVWebView;
import android.taobao.windvane.webview.WVWebViewClient;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import cn.damai.h5container.DMBridge;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.factory.PLViewInfo;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.utils.ConsoleLogger$Level;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.net.URLEncoder;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.cr1;
import tb.dr1;
import tb.dz0;
import tb.fz2;
import tb.r30;

@PLViewInfo(isDefaultType = true, type = a.c.d)
/* compiled from: Taobao */
public class PopLayerWebView extends PopLayerBaseView<IWVWebView, dz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = PopLayerWebView.class.getSimpleName();
    private String mUrl;
    private boolean mWebViewAddEnable = true;

    /* compiled from: Taobao */
    public class a extends WVUCWebChromeClient {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient, com.uc.webview.export.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581148360")) {
                return ((Boolean) ipChange.ipc$dispatch("-581148360", new Object[]{this, consoleMessage})).booleanValue();
            }
            try {
                PopLayerWebView.this.sendLog(consoleMessage);
            } catch (Throwable th) {
                cr1.c("H5 WVUCWebChromeClient onConsoleMessage error", th);
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }

    /* compiled from: Taobao */
    public class b extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BaseConfigItem a;

        b(BaseConfigItem baseConfigItem) {
            this.a = baseConfigItem;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "373988881")) {
                ipChange.ipc$dispatch("373988881", new Object[]{this, view});
                return;
            }
            AlertDialog create = new AlertDialog.Builder(PopLayerWebView.this.getContext().getApplicationContext(), 3).setMessage(this.a.toString()).setTitle(String.format("Configuration DescItem for %s", this.a.uuid)).create();
            create.getWindow().setType(2038);
            create.show();
        }
    }

    public PopLayerWebView(Context context) {
        super(context);
    }

    private IWVWebView buildWebView(Context context, BaseConfigItem baseConfigItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421746983")) {
            return (IWVWebView) ipChange.ipc$dispatch("1421746983", new Object[]{this, context, baseConfigItem});
        } else if (TextUtils.isEmpty(this.mUrl) || !this.mUrl.contains("poplayer_force_use_native_webkit")) {
            WVUCWebView wVUCWebView = new WVUCWebView(context);
            wVUCWebView.setWebViewClient(new WVUCWebViewClient(context));
            wVUCWebView.setWebChromeClient(new a(context));
            cr1.b("buildWebView,use default UC webview.", new Object[0]);
            return wVUCWebView;
        } else {
            WVWebView wVWebView = new WVWebView(context);
            wVWebView.setWebViewClient(new WVWebViewClient(context));
            wVWebView.setWebChromeClient(new WVWebChromeClient(context) {
                /* class cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.taobao.windvane.webview.WVWebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1019157863")) {
                        return ((Boolean) ipChange.ipc$dispatch("-1019157863", new Object[]{this, consoleMessage})).booleanValue();
                    }
                    try {
                        PopLayerWebView.this.sendLog(consoleMessage);
                    } catch (Throwable th) {
                        cr1.c("H5 WVWebChromeClient onConsoleMessage error", th);
                    }
                    return super.onConsoleMessage(consoleMessage);
                }
            });
            cr1.b("buildWebView,use native webkit. contains:poplayer_force_use_native_webkit", new Object[0]);
            return wVWebView;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeMeOnMainThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876357394")) {
            ipChange.ipc$dispatch("1876357394", new Object[]{this});
            return;
        }
        try {
            InnerView innerview = this.mInnerView;
            if (innerview != null) {
                innerview.loadUrl("about:blank");
                InnerView innerview2 = this.mInnerView;
                if (innerview2 instanceof WVWebView) {
                    innerview2.getSettings().setJavaScriptEnabled(false);
                }
                InnerView innerview3 = this.mInnerView;
                if (innerview3 instanceof WVUCWebView) {
                    innerview3.getSettings().setJavaScriptEnabled(false);
                }
                if (this.mInnerView.getParent() != null) {
                    removeView(this.mInnerView);
                }
                InnerView innerview4 = this.mInnerView;
                if (innerview4 instanceof WVWebView) {
                    innerview4.destroy();
                } else if (innerview4 instanceof WVUCWebView) {
                    innerview4.destroy();
                }
                destroy();
                this.mInnerView = null;
            }
            ((dz0) this.mPopRequest).n(null);
            this.mPopRequest = null;
            cr1.b("%s.destroyView.success", TAG);
        } catch (Throwable th) {
            this.mWebViewAddEnable = false;
            throw th;
        }
        this.mWebViewAddEnable = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendLog(ConsoleMessage consoleMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349237734")) {
            ipChange.ipc$dispatch("349237734", new Object[]{this, consoleMessage});
            return;
        }
        consoleLog(String.format("%s\n@source-%s:lineNumber-%s", consoleMessage.message(), consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber())), ConsoleLogger$Level.find(fz2.WEBCONSOLE_LOGCAT_MAP.get(consoleMessage.messageLevel()).charValue()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: android.taobao.windvane.webview.IWVWebView */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:7|(1:9)|10|11|12|13|14|(1:16)(1:17)|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        tb.cr1.c("PopLayerWebView.addView error", r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ all -> 0x0074 }] */
    private void setWebView(IWVWebView iWVWebView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123388227")) {
            ipChange.ipc$dispatch("-1123388227", new Object[]{this, iWVWebView});
        } else if (iWVWebView != this.mInnerView) {
            iWVWebView.loadUrl(String.format("javascript:(function () {Object.defineProperty(window,'_ua_popLayer',{value:%s});}());", String.format("\"PopLayer/%s\"", PopLayer.getReference().getVersion())));
            InnerView innerview = this.mInnerView;
            if (innerview != null) {
                removeView(innerview);
            }
            this.mInnerView = iWVWebView;
            fz2.a(getContext(), this);
            if (!this.mWebViewAddEnable) {
                addView((View) iWVWebView, new FrameLayout.LayoutParams(-1, -1));
            } else {
                cr1.a("PopLayerWebView try add webview, WebView had destroyed,url:" + this.mUrl);
            }
            cr1.b("%s.setWebView.success", TAG);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void destroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138201893")) {
            ipChange.ipc$dispatch("-2138201893", new Object[]{this});
            return;
        }
        super.destroyView();
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            removeMeOnMainThread();
        } else {
            post(new Runnable() {
                /* class cn.damai.commonbusiness.poplayer.view.h5.PopLayerWebView.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-528264862")) {
                        ipChange.ipc$dispatch("-528264862", new Object[]{this});
                        return;
                    }
                    PopLayerWebView.this.removeMeOnMainThread();
                }
            });
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public SpannableStringBuilder getInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82428153")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("82428153", new Object[]{this});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            BaseConfigItem r = ((dz0) getPopRequest()).r();
            r30.a(spannableStringBuilder, "UUID", r.uuid, null, new b(r));
            r30.a(spannableStringBuilder, "PopTimes", dr1.b(r.uuid, -1) + "", null, null);
            if (getWebView() != null) {
                r30.a(spannableStringBuilder, "URL", getWebView().getUrl(), null, null);
            }
            r30.a(spannableStringBuilder, "Event", ((dz0) getPopRequest()).s().toString(), null, null);
            r30.a(spannableStringBuilder, "ModalThreshold", String.format("%.2f", Float.valueOf(((float) getPenetrateAlpha()) / 255.0f)) + "/" + getPenetrateAlpha(), null, null);
        } catch (Throwable unused) {
            r30.a(spannableStringBuilder, "Error", "getInfo Error", null, null);
        }
        return spannableStringBuilder;
    }

    public IWVWebView getWebView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "555381901")) {
            return this.mInnerView;
        }
        return (IWVWebView) ipChange.ipc$dispatch("555381901", new Object[]{this});
    }

    public void loadUrl(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1054439231")) {
            ipChange.ipc$dispatch("-1054439231", new Object[]{this, context, str});
        } else if (getWebView() != null && !TextUtils.isEmpty(str)) {
            String str2 = this.mUrl;
            String str3 = ((dz0) getPopRequest()).s().param;
            try {
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str2 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + URLEncoder.encode(str3, "utf-8");
                }
            } catch (Exception e) {
                cr1.c("reformatUrl.error." + e.toString(), e);
            }
            cr1.b("Load url : %s.", str2);
            try {
                DMBridge.resume(context);
                getWebView().loadUrl(str2);
            } catch (Exception e2) {
                cr1.c("loadUrl.error." + e2.toString(), e2);
            }
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onActivityPaused() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900420276")) {
            ipChange.ipc$dispatch("1900420276", new Object[]{this});
            return;
        }
        try {
            super.onActivityPaused();
            IWVWebView webView = getWebView();
            if (webView == null) {
                return;
            }
            if (webView instanceof WVWebView) {
                ((WVWebView) webView).onPause();
            } else if (webView instanceof WVUCWebView) {
                ((WVUCWebView) webView).onPause();
            }
        } catch (Throwable th) {
            cr1.c("H5 onActivityPaused error", th);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onActivityResumed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728295247")) {
            ipChange.ipc$dispatch("-1728295247", new Object[]{this});
            return;
        }
        try {
            super.onActivityResumed();
            IWVWebView webView = getWebView();
            if (webView == null) {
                return;
            }
            if (webView instanceof WVWebView) {
                ((WVWebView) webView).onResume();
            } else if (webView instanceof WVUCWebView) {
                ((WVUCWebView) webView).onResume();
            }
        } catch (Throwable th) {
            cr1.c("H5 onActivityResumed error", th);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onReceiveEvent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-265047762")) {
            ipChange.ipc$dispatch("-265047762", new Object[]{this, str, str2});
        } else if (getWebView() != null) {
            getWebView().fireEvent(str, str2);
        }
    }

    @Override // com.alibaba.poplayer.factory.view.base.PopLayerBaseView
    public void onViewAdded(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734767690")) {
            ipChange.ipc$dispatch("734767690", new Object[]{this, context});
            return;
        }
        loadUrl(context, this.mUrl);
    }

    public void setHardwareAccleration(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225151049")) {
            ipChange.ipc$dispatch("-1225151049", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = (View) getWebView();
        if (view != null && !z) {
            view.setLayerType(1, null);
        }
    }

    public void init(Context context, dz0 dz0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009578757")) {
            ipChange.ipc$dispatch("1009578757", new Object[]{this, context, dz0});
            return;
        }
        JSONObject jSONObject = null;
        try {
            String str = dz0.r().params;
            if (!TextUtils.isEmpty(str)) {
                jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            }
            if (jSONObject == null) {
                return;
            }
        } catch (Throwable th) {
            cr1.c("PopLayerView init fail.", th);
        }
        setVisibility(4);
        BaseConfigItem r = dz0.r();
        if (r == null) {
            cr1.b("PopLayerWebView init error,Poprequest`s config is empty.", new Object[0]);
            return;
        }
        this.mUrl = jSONObject.optString("url");
        IWVWebView buildWebView = buildWebView(context, r);
        if (buildWebView == null) {
            cr1.b("PopLayerWebView init error,build webview error.", new Object[0]);
            return;
        }
        setWebView(buildWebView);
        setHardwareAccleration(jSONObject.optBoolean("enableHardwareAcceleration", false));
        setPenetrateAlpha((int) (r.modalThreshold * 255.0d));
        showCloseButton(r.showCloseBtn);
        setPopRequest(dz0);
    }
}
