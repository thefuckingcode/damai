package cn.damai.h5container;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.taobao.windvane.webview.WVUIModel;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.model.RealNameInfo;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.login.havana.ILoginListener;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.mtop.wvplugin.MtopWVPlugin;
import com.taomai.android.h5container.ui.TaoMaiUCH5Fragment;
import com.taomai.android.h5container.webview.TaoMaiUCWebView;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.youku.android.utils.OPRUtils;
import java.io.File;
import java.net.URLEncoder;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aj2;
import tb.bj2;
import tb.d20;
import tb.g91;
import tb.gq1;
import tb.gr;
import tb.k21;
import tb.ou2;
import tb.uq;
import tb.vf1;
import tb.vq;
import tb.wq;
import tb.xq;
import tb.xs0;
import tb.yh1;

/* compiled from: Taobao */
public final class DMH5Fragment extends TaoMaiUCH5Fragment implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int backType;
    private boolean backtohome;
    @Nullable
    private Bundle bundle;
    private boolean isFromPush;
    @Nullable
    private ResponseErrorPage mErrorPage;
    @Nullable
    private ValueCallback<Uri> mUploadMessage;
    private boolean neterror;
    @NotNull
    private final ScreenShotDetector.IScreenShotExtraListener screenShotExtraListener = new wq(this);
    private boolean skip;
    @NotNull
    private final WebViewUtil util = new WebViewUtil();

    private final void initParam() {
        String str;
        Bundle arguments;
        Intent intent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942686420")) {
            ipChange.ipc$dispatch("1942686420", new Object[]{this});
            return;
        }
        if (this.bundle == null) {
            this.bundle = getArguments();
        }
        if (this.bundle == null) {
            FragmentActivity activity = getActivity();
            if ((activity != null ? activity.getIntent() : null) != null) {
                FragmentActivity activity2 = getActivity();
                this.bundle = (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getExtras();
            }
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.containsKey(DamaiConstants.PUSH_MSG_SUMMARY)) {
            setWebTitle("活动介绍");
            this.isFromPush = true;
            String string = requireArguments().getString(DamaiConstants.PUSH_MSG_SUMMARY);
            k21.f(string);
            int length = string.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = k21.k(string.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            setUrl(string.subSequence(i, length + 1).toString());
            Log.d("applink", " uri : PUSH_MSG_SUMMARY " + getUrl());
            Bundle bundle2 = this.bundle;
            k21.f(bundle2);
            this.backType = bundle2.getInt(DamaiConstants.PUSH_MSG_BACK_TYPE);
        }
        if (TextUtils.isEmpty(getUrl())) {
            ToastUtil.i("url出错啦.");
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
                return;
            }
            return;
        }
        String url = getUrl();
        k21.f(url);
        String str2 = "YES";
        if (StringsKt__StringsKt.Q(url, "refreshable=", false, 2, null)) {
            try {
                str = Uri.parse(getUrl()).getQueryParameter("refreshable");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (!(str == null || !k21.d("true", str) || (arguments = getArguments()) == null)) {
                arguments.putString("pullRefresh", str2);
            }
        } else {
            Bundle bundle3 = this.bundle;
            if (bundle3 != null) {
                k21.f(bundle3);
                if (bundle3.containsKey("refreshable")) {
                    Bundle bundle4 = this.bundle;
                    k21.f(bundle4);
                    boolean z3 = bundle4.getBoolean("refreshable");
                    Bundle arguments3 = getArguments();
                    if (arguments3 != null) {
                        if (!z3) {
                            str2 = "NO";
                        }
                        arguments3.putString("pullRefresh", str2);
                    }
                }
            }
        }
        String url2 = getUrl();
        k21.f(url2);
        if (StringsKt__StringsKt.Q(url2, "h5.m.taopiaopiao.com/app/movie/pages/index", false, 2, null)) {
            setUrl("https://h5.m.taopiaopiao.com/app/moviemain/pages/index/index.html?from=damai");
            return;
        }
        Bundle bundle5 = this.bundle;
        this.skip = bundle5 != null ? bundle5.getBoolean(MonitorType.SKIP, false) : false;
        if (AppConfig.g() == AppConfig.EnvMode.test || AppConfig.g() == AppConfig.EnvMode.prepare) {
            this.skip = true;
        }
        if (WVPluginManager.getPluginInfo(MtopWVPlugin.API_SERVER_NAME) == null) {
            vf1.a();
        }
        Bundle bundle6 = this.bundle;
        this.backtohome = bundle6 != null ? bundle6.getBoolean("backtohome", false) : false;
        Bundle bundle7 = this.bundle;
        boolean z4 = bundle7 != null ? bundle7.getBoolean("fromQr", false) : false;
        if (!this.skip) {
            Bundle bundle8 = this.bundle;
            k21.f(bundle8);
            if (!k21.d("true", bundle8.getString(MonitorType.SKIP))) {
                String url3 = getUrl();
                k21.f(url3);
                if (!(StringsKt__StringsKt.Q(url3, "dmskip=true", false, 2, null))) {
                    String url4 = getUrl();
                    k21.f(url4);
                    if (!(o.L(url4, "damai:", false, 2, null)) && z4 && !WVServerConfig.isTrustedUrl(getUrl())) {
                        if (LoginManager.k().q()) {
                            String url5 = getUrl();
                            k21.f(url5);
                            if (!(StringsKt__StringsKt.Q(url5, ShareperfenceConstants.OLD_LOGIN_KEY, false, 2, null))) {
                                setUrl(URLEncoder.encode(getUrl()));
                                setUrl("https://passport.damai.cn/third/rurl.do?url=" + getUrl() + "&loginkey=" + d20.q());
                                return;
                            }
                        }
                        setUrl(URLEncoder.encode(getUrl()));
                        setUrl("https://passport.damai.cn/third/rurl.do?url=" + getUrl());
                        return;
                    }
                }
            }
        }
        if (LoginManager.k().q()) {
            String url6 = getUrl();
            k21.f(url6);
            boolean unused = StringsKt__StringsKt.Q(url6, ShareperfenceConstants.OLD_LOGIN_KEY, false, 2, null);
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014797276")) {
            ipChange.ipc$dispatch("-2014797276", new Object[]{this});
            return;
        }
        HavanaProxy.v().g(this);
        webViewSetting();
        TaoMaiUCWebView webView = getWebView();
        if (webView != null) {
            WVUIModel wVUIModel = new WVUIModel(getActivity(), getWebView());
            ResponseErrorPage responseErrorPage = new ResponseErrorPage(getActivity(), OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, "麦麦很忙，系统很累请稍后重试", "");
            responseErrorPage.hideTitle();
            responseErrorPage.setRefreshListener(new vq(this));
            wVUIModel.setErrorView(responseErrorPage);
            webView.setWvUIModel(wVUIModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final void m27initView$lambda4$lambda3$lambda2(DMH5Fragment dMH5Fragment, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143370605")) {
            ipChange.ipc$dispatch("-1143370605", new Object[]{dMH5Fragment, Integer.valueOf(i)});
            return;
        }
        k21.i(dMH5Fragment, "this$0");
        TaoMaiUCWebView webView = dMH5Fragment.getWebView();
        if (webView != null) {
            webView.reload();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: screenShotExtraListener$lambda-6  reason: not valid java name */
    public static final void m28screenShotExtraListener$lambda6(DMH5Fragment dMH5Fragment, String str, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589698782")) {
            ipChange.ipc$dispatch("589698782", new Object[]{dMH5Fragment, str, activity});
            return;
        }
        k21.i(dMH5Fragment, "this$0");
        k21.h(str, "s");
        dMH5Fragment.showDetectView(str);
    }

    private final void showDetectView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809326334")) {
            ipChange.ipc$dispatch("809326334", new Object[]{this, str});
            return;
        }
        TaoMaiUCWebView webView = getWebView();
        if (webView != null) {
            webView.evaluateJavascript("isLiveH5('  Android调用js  ')", uq.a);
        }
        ScreenShotDetector.k().y(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDetectView$lambda-7  reason: not valid java name */
    public static final void m29showDetectView$lambda7(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147009323")) {
            ipChange.ipc$dispatch("2147009323", new Object[]{str});
            return;
        }
        g91.c("webviewFragmenteva", "a+b=" + str);
    }

    private final void webViewSetting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206749634")) {
            ipChange.ipc$dispatch("206749634", new Object[]{this});
            return;
        }
        DMBridge.registerPlugin(getActivity());
        TaoMaiUCWebView webView = getWebView();
        if (webView != null) {
            webView.setWebViewClient(new DmWebViewClient(this));
        }
        TaoMaiUCWebView webView2 = getWebView();
        if (webView2 != null) {
            webView2.setWebChromeClient(new DmWebChromeClient(this));
        }
        TaoMaiUCWebView webView3 = getWebView();
        if (webView3 != null) {
            webView3.requestFocus();
        }
        TaoMaiUCWebView webView4 = getWebView();
        if (webView4 != null) {
            webView4.setSelected(true);
        }
        TaoMaiUCWebView webView5 = getWebView();
        WebSettings settings = webView5 != null ? webView5.getSettings() : null;
        if (settings != null) {
            settings.setDefaultTextEncodingName("utf-8");
            settings.setJavaScriptEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(12582912);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setBlockNetworkImage(false);
            settings.setNeedInitialFocus(true);
            settings.setDefaultFontSize(14);
            settings.setCacheMode(-1);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(false);
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
            settings.setLoadWithOverviewMode(true);
            TaoMaiUCWebView webView6 = getWebView();
            if (webView6 != null) {
                webView6.setOverScrollMode(0);
            }
            String str = requireActivity().getFilesDir().getAbsolutePath() + "/dmcache";
            settings.setDatabasePath(str);
            settings.setAppCachePath(str);
            try {
                settings.setSupportMultipleWindows(false);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                TaoMaiUCWebView webView7 = getWebView();
                if (webView7 != null) {
                    webView7.addJavascriptInterface(this, "javatojs");
                }
                TaoMaiUCWebView webView8 = getWebView();
                if (webView8 != null) {
                    webView8.addJavascriptInterface(this, "android");
                }
                TaoMaiUCWebView webView9 = getWebView();
                if (webView9 != null) {
                    webView9.addJavascriptInterface(this, "special_title");
                }
                TaoMaiUCWebView webView10 = getWebView();
                if (webView10 != null) {
                    webView10.addJavascriptInterface(this, "wallet_authenticate");
                }
                TaoMaiUCWebView webView11 = getWebView();
                if (webView11 != null) {
                    webView11.addJavascriptInterface(this, "real_name");
                }
                settings.setAllowUniversalAccessFromFileURLs(true);
                settings.setAllowFileAccessFromFileURLs(true);
                TaoMaiUCWebView webView12 = getWebView();
                if (webView12 != null) {
                    webView12.setHorizontalScrollBarEnabled(false);
                }
                TaoMaiUCWebView webView13 = getWebView();
                if (webView13 != null) {
                    webView13.setVerticalScrollBarEnabled(false);
                }
                settings.setAllowContentAccess(true);
                TaoMaiUCWebView webView14 = getWebView();
                if (webView14 != null) {
                    webView14.setDownloadListener(new xq(this));
                }
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(AppConfig.v());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: webViewSetting$lambda-1  reason: not valid java name */
    public static final void m30webViewSetting$lambda1(DMH5Fragment dMH5Fragment, String str, String str2, String str3, String str4, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164706672")) {
            ipChange.ipc$dispatch("1164706672", new Object[]{dMH5Fragment, str, str2, str3, str4, Long.valueOf(j)});
            return;
        }
        k21.i(dMH5Fragment, "this$0");
        try {
            dMH5Fragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            ou2.b(e);
        }
    }

    public final void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1024970296")) {
            ipChange.ipc$dispatch("1024970296", new Object[]{this});
            return;
        }
        LoginManager.k().y(this, new Intent(), 10);
    }

    public final boolean checkNetError() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1439204066")) {
            return ((Boolean) ipChange.ipc$dispatch("1439204066", new Object[]{this})).booleanValue();
        }
        if (!yh1.b(getActivity())) {
            onResponseError("网络不可用,请检查您的网络。", "1001");
            z = true;
        } else {
            onResponseSuccess();
        }
        this.neterror = z;
        return z;
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    @NotNull
    public aj2 createWebViewChromeClient() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "927105437")) {
            return new DMH5Fragment$createWebViewChromeClient$1(this);
        }
        return (aj2) ipChange.ipc$dispatch("927105437", new Object[]{this});
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    @NotNull
    public bj2 createWebViewClient() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1489623672")) {
            return new DMH5Fragment$createWebViewClient$1(this);
        }
        return (bj2) ipChange.ipc$dispatch("1489623672", new Object[]{this});
    }

    @Nullable
    public final ResponseErrorPage getMErrorPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1278396365")) {
            return this.mErrorPage;
        }
        return (ResponseErrorPage) ipChange.ipc$dispatch("-1278396365", new Object[]{this});
    }

    @Nullable
    public final ValueCallback<Uri> getMUploadMessage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1457737146")) {
            return this.mUploadMessage;
        }
        return (ValueCallback) ipChange.ipc$dispatch("1457737146", new Object[]{this});
    }

    public final boolean getNeterror() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "370335412")) {
            return this.neterror;
        }
        return ((Boolean) ipChange.ipc$dispatch("370335412", new Object[]{this})).booleanValue();
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onActivityCreated(@Nullable Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180404573")) {
            ipChange.ipc$dispatch("180404573", new Object[]{this, bundle2});
            return;
        }
        super.onActivityCreated(bundle2);
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4607733")) {
            ipChange.ipc$dispatch("-4607733", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i == 10) {
            if (i2 == -1) {
                initView();
            } else if (i2 != 0) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.setResult(-1);
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
        if (-1 == i2) {
            switch (i) {
                case 257:
                    WebViewUtil webViewUtil = this.util;
                    k21.f(intent);
                    webViewUtil.startPhotoCapture(intent.getData(), getActivity());
                    return;
                case 258:
                    this.util.startPhotoCapture(Uri.fromFile(new File(gq1.a(getActivity()))), getActivity());
                    return;
                case H5MainActivity.REQUEST_CORP:
                    Uri fromFile = Uri.fromFile(new File(gq1.a(getActivity())));
                    ValueCallback<Uri> valueCallback = this.mUploadMessage;
                    if (valueCallback != null) {
                        k21.f(valueCallback);
                        valueCallback.onReceiveValue(fromFile);
                        this.mUploadMessage = null;
                        return;
                    }
                    return;
                case H5MainActivity.REQUEST_REALNAME:
                    RealNameInfo realNameInfo = (RealNameInfo) d20.h(ShareperfenceConstants.USER_DATA_REALNAMEINFO, RealNameInfo.class);
                    if (realNameInfo == null || !realNameInfo.realNameStatus) {
                        TaoMaiUCWebView webView = getWebView();
                        if (webView != null) {
                            webView.loadUrl("javascript:realNameThenticate('0')");
                            return;
                        }
                        return;
                    }
                    TaoMaiUCWebView webView2 = getWebView();
                    if (webView2 != null) {
                        webView2.loadUrl("javascript:realNameThenticate('1')");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            ValueCallback<Uri> valueCallback2 = this.mUploadMessage;
            if (valueCallback2 != null) {
                k21.f(valueCallback2);
                valueCallback2.onReceiveValue(null);
                this.mUploadMessage = null;
            }
        }
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public boolean onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446423047")) {
            return ((Boolean) ipChange.ipc$dispatch("-446423047", new Object[]{this})).booleanValue();
        } else if (this.backtohome) {
            DMNav.from(getActivity()).toUri(NavUri.b(gr.n));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return true;
        } else if (!this.isFromPush || this.backType == 1) {
            return super.onBackPressed();
        } else {
            DMNav.from(getActivity()).toUri(NavUri.b(gr.n));
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onCreate(@Nullable Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423737750")) {
            ipChange.ipc$dispatch("1423737750", new Object[]{this, bundle2});
            return;
        }
        super.onCreate(bundle2);
        if (!WindVaneSDK.isInitialized()) {
            Log.d("delayInit", "windvane lazy init start");
            String n = AppConfig.n(xs0.a());
            if (!TextUtils.isEmpty(n) && k21.d(n, "cn.damai")) {
                WindvaneAgent.initWindVane(xs0.a());
            }
        }
        initParam();
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257792046")) {
            return (View) ipChange.ipc$dispatch("1257792046", new Object[]{this, layoutInflater, viewGroup, bundle2});
        }
        k21.i(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle2);
        initView();
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989899178")) {
            ipChange.ipc$dispatch("-989899178", new Object[]{this});
            return;
        }
        super.onDestroy();
        HavanaProxy.v().Q(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-574677775")) {
            ipChange.ipc$dispatch("-574677775", new Object[]{this});
            return;
        }
        super.onDestroyView();
        ScreenShotDetector.k().x(null);
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onHiddenChanged(boolean z) {
        Bundle bundle2;
        TaoMaiUCWebView webView;
        String url;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "209334574")) {
            ipChange.ipc$dispatch("209334574", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onHiddenChanged(z);
        if (getWebView() != null) {
            TaoMaiUCWebView webView2 = getWebView();
            if ((webView2 != null ? webView2.getUrl() : null) != null && (bundle2 = this.bundle) != null) {
                k21.f(bundle2);
                if (bundle2.containsKey("url") && !z) {
                    Bundle bundle3 = this.bundle;
                    k21.f(bundle3);
                    String string = bundle3.getString("url");
                    initParam();
                    if (string != null) {
                        TaoMaiUCWebView webView3 = getWebView();
                        if (!k21.d(webView3 != null ? webView3.getUrl() : null, string)) {
                            TaoMaiUCWebView webView4 = getWebView();
                            if (webView4 == null || (url = webView4.getUrl()) == null || !(StringsKt__StringsKt.Q(url, string, false, 2, null))) {
                                z2 = false;
                            }
                            if (z2) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    String url2 = getUrl();
                    if (url2 != null && (webView = getWebView()) != null) {
                        webView.loadUrl(url2);
                    }
                }
            }
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559406829")) {
            ipChange.ipc$dispatch("1559406829", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131332535")) {
            ipChange.ipc$dispatch("-2131332535", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523976032")) {
            ipChange.ipc$dispatch("-1523976032", new Object[]{this});
            return;
        }
        reload();
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064993488")) {
            ipChange.ipc$dispatch("-1064993488", new Object[]{this});
        }
    }

    public final void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        TaoMaiUCWebView webView2;
        Intent intent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765559669")) {
            ipChange.ipc$dispatch("-1765559669", new Object[]{this, webView, str});
            return;
        }
        TaoMaiUCWebView webView3 = getWebView();
        String str2 = null;
        WebSettings settings = webView3 != null ? webView3.getSettings() : null;
        if (settings != null) {
            settings.setBlockNetworkImage(false);
        }
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (!(activity == null || (intent = activity.getIntent()) == null)) {
                str2 = intent.getStringExtra("datajson");
            }
            if (!TextUtils.isEmpty(str2) && (webView2 = getWebView()) != null) {
                webView2.loadUrl("javascript:orderCommentData(" + str2 + ')');
            }
        }
        WVStandardEventCenter.postNotificationToJS(getWebView(), "dmAndroidShare", "dmAndroidShare");
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734775706")) {
            ipChange.ipc$dispatch("734775706", new Object[]{this});
            return;
        }
        super.onPause();
    }

    @Override // com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523149781")) {
            ipChange.ipc$dispatch("1523149781", new Object[]{this});
            return;
        }
        super.onRefresh();
        if (yh1.b(getContext())) {
            onResponseSuccess();
            reload();
        }
    }

    public final void onResponseError(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405828413")) {
            ipChange.ipc$dispatch("1405828413", new Object[]{this, str, str2});
        }
    }

    public final void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889413682")) {
            ipChange.ipc$dispatch("-1889413682", new Object[]{this});
            return;
        }
        DMH5Activity dMH5Activity = null;
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                k21.f(responseErrorPage);
                responseErrorPage.setVisibility(8);
                this.mErrorPage = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof DMH5Activity) {
            dMH5Activity = (DMH5Activity) activity;
        }
        if (dMH5Activity != null) {
            dMH5Activity.hideShareMenu();
        }
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343970387")) {
            ipChange.ipc$dispatch("-1343970387", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().y(true);
        DMBridge.resume(getActivity());
        ScreenShotDetector.k().x(this.screenShotExtraListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777880494")) {
            ipChange.ipc$dispatch("777880494", new Object[]{this});
            return;
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377752328")) {
            ipChange.ipc$dispatch("-377752328", new Object[]{this});
            return;
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075645615")) {
            ipChange.ipc$dispatch("1075645615", new Object[]{this, view, bundle2});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle2);
    }

    public final void setBundle(@Nullable Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608543129")) {
            ipChange.ipc$dispatch("-1608543129", new Object[]{this, bundle2});
            return;
        }
        this.bundle = bundle2;
    }

    public final void setMErrorPage(@Nullable ResponseErrorPage responseErrorPage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073326253")) {
            ipChange.ipc$dispatch("-2073326253", new Object[]{this, responseErrorPage});
            return;
        }
        this.mErrorPage = responseErrorPage;
    }

    public final void setMUploadMessage(@Nullable ValueCallback<Uri> valueCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892322724")) {
            ipChange.ipc$dispatch("-892322724", new Object[]{this, valueCallback});
            return;
        }
        this.mUploadMessage = valueCallback;
    }

    public final void setNeterror(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493705936")) {
            ipChange.ipc$dispatch("-493705936", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.neterror = z;
    }

    @Override // androidx.fragment.app.Fragment, com.taomai.android.h5container.ui.TaoMaiUCH5Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253611367")) {
            ipChange.ipc$dispatch("1253611367", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
    }
}
