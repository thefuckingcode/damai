package com.taomai.android.h5container.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.taobao.windvane.webview.WVUIModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.damai.common.DamaiConstants;
import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taomai.android.h5container.R$id;
import com.taomai.android.h5container.R$layout;
import com.taomai.android.h5container.R$string;
import com.taomai.android.h5container.provider.IH5EventDispatcher;
import com.taomai.android.h5container.provider.IKeyboardHookProvider;
import com.taomai.android.h5container.provider.INavigationBarProvider;
import com.taomai.android.h5container.utils.ActivityStackManager;
import com.taomai.android.h5container.utils.ImageTool;
import com.taomai.android.h5container.webview.TaoMaiWebView;
import com.taomai.android.h5container.widget.H5Progress;
import com.taomai.android.h5container.widget.H5ToolBar;
import com.taomai.android.h5container.widget.TitleBar;
import com.youku.arch.v3.event.Subject;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import tb.hn0;
import tb.im2;
import tb.k21;
import tb.ur2;
import tb.zi2;

public class TaoMaiH5Fragment extends Fragment implements IH5EventDispatcher, IKeyboardHookProvider, INavigationBarProvider, ActivityStackManager.IActivityStackBackEvent {
    private boolean enableProgressBar = true;
    private ValueCallback<Uri[]> filePathCallback;
    private H5Progress h5ProgressView;
    private final Lazy handler$delegate = kotlin.b.b(TaoMaiH5Fragment$handler$2.INSTANCE);
    private boolean hasSetTitleFromBridge;
    private boolean hasSetTransparentTitleFromBridge;
    private boolean hookBackEvent;
    private boolean isLoadSuccess;
    private WebChromeClient.CustomViewCallback mCallBack;
    private View mCustomView;
    private boolean needHideTitleBar;
    private Integer originalVisibility;
    private Function4<? super WebView, ? super Integer, ? super String, ? super String, ur2> pageLoadErrorListener;
    private Function2<? super WebView, ? super String, ur2> pageLoadFinishListener;
    private Function3<? super WebView, ? super String, ? super Bitmap, ur2> pageLoadStartListener;
    private boolean readTitle = true;
    private SwipeRefreshLayout refreshLayout;
    private String title;
    public TitleBar titleBar;
    public H5ToolBar toolbar;
    private im2 transparentTitleHelper;
    private String url;
    private ViewGroup videoPlayerContainer;
    private ViewGroup webContainer;
    private TaoMaiWebView webView;

    public static final class a implements View.OnClickListener {
        final /* synthetic */ TaoMaiH5Fragment a;

        a(TaoMaiH5Fragment taoMaiH5Fragment) {
            this.a = taoMaiH5Fragment;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public static final class b implements SwipeRefreshLayout.OnRefreshListener {
        final /* synthetic */ TaoMaiH5Fragment a;

        b(TaoMaiH5Fragment taoMaiH5Fragment) {
            this.a = taoMaiH5Fragment;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.onRefresh();
        }
    }

    public static final class c implements SwipeRefreshLayout.OnChildScrollUpCallback {
        final /* synthetic */ TaoMaiH5Fragment a;

        c(TaoMaiH5Fragment taoMaiH5Fragment) {
            this.a = taoMaiH5Fragment;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnChildScrollUpCallback
        public final boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view) {
            k21.i(swipeRefreshLayout, "swipeRefreshLayout");
            try {
                if (this.a.getWebView() == null) {
                    return false;
                }
                TaoMaiWebView webView = this.a.getWebView();
                k21.f(webView);
                return webView.getScrollY() > 0;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static final class d implements H5Progress.ProgressNotifier {
        final /* synthetic */ TaoMaiH5Fragment a;

        d(TaoMaiH5Fragment taoMaiH5Fragment) {
            this.a = taoMaiH5Fragment;
        }

        @Override // com.taomai.android.h5container.widget.H5Progress.ProgressNotifier
        public void onProgressBegin() {
        }

        @Override // com.taomai.android.h5container.widget.H5Progress.ProgressNotifier
        public void onProgressEnd() {
            TaoMaiH5Fragment.access$getH5ProgressView$p(this.a).hideAndResetProgress();
        }
    }

    static final class e implements View.OnClickListener {
        final /* synthetic */ TaoMaiH5Fragment a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ View.OnClickListener c;

        e(TaoMaiH5Fragment taoMaiH5Fragment, JSONObject jSONObject, View.OnClickListener onClickListener) {
            this.a = taoMaiH5Fragment;
            this.b = jSONObject;
            this.c = onClickListener;
        }

        public final void onClick(View view) {
            this.a.fireEvent("optionMenu", this.b.toJSONString());
            this.c.onClick(view);
        }
    }

    public static final class f implements View.OnClickListener {
        final /* synthetic */ TaoMaiH5Fragment a;

        f(TaoMaiH5Fragment taoMaiH5Fragment) {
            this.a = taoMaiH5Fragment;
        }

        public final void onClick(View view) {
            TaoMaiWebView webView = this.a.getWebView();
            if (webView != null) {
                webView.reload();
            }
        }
    }

    public static final /* synthetic */ H5Progress access$getH5ProgressView$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        H5Progress h5Progress = taoMaiH5Fragment.h5ProgressView;
        if (h5Progress == null) {
            k21.A("h5ProgressView");
        }
        return h5Progress;
    }

    public static final /* synthetic */ boolean access$getHasSetTransparentTitleFromBridge$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        return taoMaiH5Fragment.hasSetTransparentTitleFromBridge;
    }

    public static final /* synthetic */ SwipeRefreshLayout access$getRefreshLayout$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        SwipeRefreshLayout swipeRefreshLayout = taoMaiH5Fragment.refreshLayout;
        if (swipeRefreshLayout == null) {
            k21.A("refreshLayout");
        }
        return swipeRefreshLayout;
    }

    public static final /* synthetic */ im2 access$getTransparentTitleHelper$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        return taoMaiH5Fragment.transparentTitleHelper;
    }

    public static final /* synthetic */ String access$getUrl$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        return taoMaiH5Fragment.url;
    }

    public static final /* synthetic */ void access$hideEmptyOrErrorView(TaoMaiH5Fragment taoMaiH5Fragment) {
        taoMaiH5Fragment.hideEmptyOrErrorView();
    }

    public static final /* synthetic */ void access$hideLoading(TaoMaiH5Fragment taoMaiH5Fragment) {
        taoMaiH5Fragment.hideLoading();
    }

    public static final /* synthetic */ void access$resetTitleStatus(TaoMaiH5Fragment taoMaiH5Fragment) {
        taoMaiH5Fragment.resetTitleStatus();
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(TaoMaiH5Fragment taoMaiH5Fragment, boolean z) {
        taoMaiH5Fragment.isLoadSuccess = z;
    }

    public static final /* synthetic */ void access$setTitleIfNeed(TaoMaiH5Fragment taoMaiH5Fragment, String str) {
        taoMaiH5Fragment.setTitleIfNeed(str);
    }

    public static final /* synthetic */ void access$showEmptyOrErrorView(TaoMaiH5Fragment taoMaiH5Fragment) {
        taoMaiH5Fragment.showEmptyOrErrorView();
    }

    public static final /* synthetic */ void access$showLoading(TaoMaiH5Fragment taoMaiH5Fragment) {
        taoMaiH5Fragment.showLoading();
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    private final void hideEmptyOrErrorView() {
        WVUIModel wvUIModel;
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null && (wvUIModel = taoMaiWebView.getWvUIModel()) != null) {
            wvUIModel.hideErrorPage();
        }
    }

    private final void hideLoading() {
    }

    private final void loadInitUrl() {
        TaoMaiWebView taoMaiWebView;
        String str = this.url;
        if (!(str == null || str.length() == 0) && (taoMaiWebView = this.webView) != null) {
            String str2 = this.url;
            k21.f(str2);
            taoMaiWebView.loadUrl(str2);
        }
    }

    private final void notifyH5BackPressed() {
        fireEvent("wvBackClickEvent", null);
    }

    private final void parseArguments() {
        String str;
        String string;
        Bundle arguments = getArguments();
        String str2 = null;
        this.url = arguments != null ? arguments.getString("url") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("title")) == null) {
            Bundle arguments3 = getArguments();
            str = arguments3 != null ? arguments3.getString("defaultTitle") : null;
        }
        this.title = str;
        Bundle arguments4 = getArguments();
        this.needHideTitleBar = k21.d(arguments4 != null ? arguments4.getString(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR) : null, "1");
        Bundle arguments5 = getArguments();
        if (!(arguments5 == null || (string = arguments5.getString("rt")) == null)) {
            this.readTitle = k21.d(string, "1");
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            boolean z = true;
            if (arguments6.containsKey("showProgress")) {
                Bundle arguments7 = getArguments();
                if (arguments7 != null) {
                    str2 = arguments7.getString("showProgress");
                }
                if (str2 == null || str2.length() == 0) {
                    Bundle arguments8 = getArguments();
                    if (arguments8 == null || !arguments8.getBoolean("showProgress")) {
                        z = false;
                    }
                } else {
                    z = k21.d(str2, "true");
                }
                this.enableProgressBar = z;
            }
        }
    }

    private final void registerProvider4Bridge() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.addJsObject(Subject.FRAGMENT, this);
        }
        TaoMaiWebView taoMaiWebView2 = this.webView;
        if (taoMaiWebView2 != null) {
            taoMaiWebView2.addJsObject("NavigationBarProvider", this);
        }
        TaoMaiWebView taoMaiWebView3 = this.webView;
        if (taoMaiWebView3 != null) {
            taoMaiWebView3.addJsObject("KeyboardHookProvider", this);
        }
    }

    private final void resetTitleStatus() {
        this.hasSetTitleFromBridge = false;
        this.hasSetTransparentTitleFromBridge = false;
    }

    private final void setCustomFullscreen(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            Window window = activity.getWindow();
            k21.h(window, "activity.window");
            View decorView = window.getDecorView();
            k21.h(decorView, "activity.window.decorView");
            if (z) {
                decorView.setSystemUiVisibility(5894);
                return;
            }
            Integer num = this.originalVisibility;
            decorView.setSystemUiVisibility(num != null ? num.intValue() : 1280);
        }
    }

    private final void setTitleIfNeed(String str) {
        if (this.hasSetTitleFromBridge) {
            return;
        }
        if (!this.readTitle || str == null || (StringsKt__StringsKt.Q(str, "http", false, 2, null)) || (StringsKt__StringsKt.Q(str, "mapi", false, 2, null))) {
            TitleBar titleBar2 = this.titleBar;
            if (titleBar2 == null) {
                k21.A("titleBar");
            }
            titleBar2.setTitle("");
            return;
        }
        TitleBar titleBar3 = this.titleBar;
        if (titleBar3 == null) {
            k21.A("titleBar");
        }
        titleBar3.setTitle(str);
    }

    private final void showEmptyOrErrorView() {
        WVUIModel wvUIModel;
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null && (wvUIModel = taoMaiWebView.getWvUIModel()) != null) {
            wvUIModel.loadErrorPage();
        }
    }

    private final void showLoading() {
    }

    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        k21.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.fragment_taomai_h5_container_sys_layout, viewGroup, false);
        k21.h(inflate, "view");
        initView(inflate);
        return inflate;
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void enableHookBackBtn() {
        setHookBackKey(true);
    }

    @Override // com.taomai.android.h5container.provider.IH5EventDispatcher
    public void fireEvent(String str, String str2) {
        if (this.webView != null && hn0.a(this)) {
            zi2.a(this.webView, str, str2);
        }
    }

    @Override // com.taomai.android.h5container.provider.IH5EventDispatcher
    public void fireGlobalEvent(String str, String str2) {
        zi2.b(str, str2);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function4<? super android.webkit.WebView, ? super java.lang.Integer, ? super java.lang.String, ? super java.lang.String, tb.ur2>, kotlin.jvm.functions.Function4<android.webkit.WebView, java.lang.Integer, java.lang.String, java.lang.String, tb.ur2> */
    public final Function4<WebView, Integer, String, String, ur2> getPageLoadErrorListener() {
        return this.pageLoadErrorListener;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.webkit.WebView, ? super java.lang.String, tb.ur2>, kotlin.jvm.functions.Function2<android.webkit.WebView, java.lang.String, tb.ur2> */
    public final Function2<WebView, String, ur2> getPageLoadFinishListener() {
        return this.pageLoadFinishListener;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function3<? super android.webkit.WebView, ? super java.lang.String, ? super android.graphics.Bitmap, tb.ur2>, kotlin.jvm.functions.Function3<android.webkit.WebView, java.lang.String, android.graphics.Bitmap, tb.ur2> */
    public final Function3<WebView, String, Bitmap, ur2> getPageLoadStartListener() {
        return this.pageLoadStartListener;
    }

    public final TitleBar getTitleBar() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        return titleBar2;
    }

    public final H5ToolBar getToolbar() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            k21.A("toolbar");
        }
        return h5ToolBar;
    }

    public final TaoMaiWebView getWebView() {
        return this.webView;
    }

    public void handleOnActivityCreated() {
        Bundle arguments = getArguments();
        this.url = arguments != null ? arguments.getString("url") : null;
        setupWebView();
        registerProvider4Bridge();
        if (getUserVisibleHint()) {
            loadInitUrl();
        }
    }

    public void handleUserVisibleHint(boolean z) {
        if (z && isVisible() && !this.isLoadSuccess) {
            loadInitUrl();
        }
        if (z) {
            pageAppear();
        } else {
            pageDisappear();
        }
    }

    public final void hideCustomView(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k21.h(activity, "activity ?: return");
            if (!z) {
                try {
                    WebChromeClient.CustomViewCallback customViewCallback = this.mCallBack;
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Window window = activity.getWindow();
            k21.h(window, "activity.window");
            View decorView = window.getDecorView();
            if (!(decorView instanceof FrameLayout)) {
                decorView = null;
            }
            FrameLayout frameLayout = (FrameLayout) decorView;
            if (frameLayout != null) {
                frameLayout.removeView(this.videoPlayerContainer);
            }
            ViewGroup viewGroup = this.videoPlayerContainer;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.videoPlayerContainer = null;
            this.mCustomView = null;
            this.mCallBack = null;
            setCustomFullscreen(activity, false);
            activity.setRequestedOrientation(1);
        }
    }

    public final void hideTitleBar() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            k21.A("toolbar");
        }
        h5ToolBar.setVisibility(8);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void hideWebOptionMenu() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        View rightButton = titleBar2.getRightButton();
        if (rightButton != null) {
            rightButton.setVisibility(8);
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void hideWebTitle() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            k21.A("toolbar");
        }
        h5ToolBar.setVisibility(8);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void hideWebTitleBackBtn() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        View leftButton = titleBar2.getLeftButton();
        k21.h(leftButton, "titleBar.leftButton");
        leftButton.setVisibility(8);
    }

    public final void initView(View view) {
        k21.i(view, "root");
        View findViewById = view.findViewById(R$id.toolbar);
        k21.h(findViewById, "root.findViewById(R.id.toolbar)");
        H5ToolBar h5ToolBar = (H5ToolBar) findViewById;
        this.toolbar = h5ToolBar;
        if (h5ToolBar == null) {
            k21.A("toolbar");
        }
        View findViewById2 = h5ToolBar.findViewById(R$id.titlebar);
        k21.h(findViewById2, "toolbar.findViewById(R.id.titlebar)");
        TitleBar titleBar2 = (TitleBar) findViewById2;
        this.titleBar = titleBar2;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        titleBar2.updateStyle();
        TitleBar titleBar3 = this.titleBar;
        if (titleBar3 == null) {
            k21.A("titleBar");
        }
        titleBar3.setType(2);
        if (this.needHideTitleBar) {
            hideTitleBar();
        }
        TitleBar titleBar4 = this.titleBar;
        if (titleBar4 == null) {
            k21.A("titleBar");
        }
        titleBar4.setLeftButtonText(getString(R$string.h5_ic_arrow_back));
        TitleBar titleBar5 = this.titleBar;
        if (titleBar5 == null) {
            k21.A("titleBar");
        }
        titleBar5.setLeftButtonListener(new a(this));
        String str = this.title;
        if (str != null) {
            TitleBar titleBar6 = this.titleBar;
            if (titleBar6 == null) {
                k21.A("titleBar");
            }
            titleBar6.setTitle(str);
        }
        View findViewById3 = view.findViewById(R$id.refresh_layout);
        k21.h(findViewById3, "root.findViewById(R.id.refresh_layout)");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById3;
        this.refreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout == null) {
            k21.A("refreshLayout");
        }
        swipeRefreshLayout.setColorScheme(17170454);
        SwipeRefreshLayout swipeRefreshLayout2 = this.refreshLayout;
        if (swipeRefreshLayout2 == null) {
            k21.A("refreshLayout");
        }
        Bundle arguments = getArguments();
        swipeRefreshLayout2.setEnabled(o.w("YES", arguments != null ? arguments.getString("pullRefresh") : null, true));
        SwipeRefreshLayout swipeRefreshLayout3 = this.refreshLayout;
        if (swipeRefreshLayout3 == null) {
            k21.A("refreshLayout");
        }
        swipeRefreshLayout3.setOnRefreshListener(new b(this));
        SwipeRefreshLayout swipeRefreshLayout4 = this.refreshLayout;
        if (swipeRefreshLayout4 == null) {
            k21.A("refreshLayout");
        }
        swipeRefreshLayout4.setOnChildScrollUpCallback(new c(this));
        this.webView = (TaoMaiWebView) view.findViewById(R$id.webview);
        this.webContainer = (ViewGroup) view.findViewById(R$id.web_container);
        View findViewById4 = view.findViewById(R$id.horizontal_progress);
        k21.h(findViewById4, "root.findViewById(R.id.horizontal_progress)");
        H5Progress h5Progress = (H5Progress) findViewById4;
        this.h5ProgressView = h5Progress;
        if (h5Progress == null) {
            k21.A("h5ProgressView");
        }
        h5Progress.setNotifier(new d(this));
        H5ToolBar h5ToolBar2 = this.toolbar;
        if (h5ToolBar2 == null) {
            k21.A("toolbar");
        }
        TaoMaiWebView taoMaiWebView = this.webView;
        k21.f(taoMaiWebView);
        this.transparentTitleHelper = new im2(h5ToolBar2, taoMaiWebView);
        H5ToolBar h5ToolBar3 = this.toolbar;
        if (h5ToolBar3 == null) {
            k21.A("toolbar");
        }
        h5ToolBar3.setType(2);
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider
    public boolean isBackHooked() {
        return this.hookBackEvent;
    }

    public final boolean isLoadSuccess() {
        return this.isLoadSuccess;
    }

    public final void loadUrl(String str) {
        k21.i(str, "url");
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.loadUrl(str);
        }
    }

    public final void notifyProgressEnd() {
        if (this.enableProgressBar) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                k21.A("h5ProgressView");
            }
            updateProgress(h5Progress.getMax());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        handleOnActivityCreated();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        List list;
        super.onActivityResult(i, i2, intent);
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.onActivityResult(i, i2, intent);
        }
        if (i == 15) {
            if (i2 != -1 || intent == null) {
                uriArr = null;
            } else {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    int itemCount = clipData.getItemCount();
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        ClipData.Item itemAt = clipData.getItemAt(i3);
                        k21.h(itemAt, "item");
                        uriArr[i3] = itemAt.getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
            }
            ValueCallback<Uri[]> valueCallback = this.filePathCallback;
            if (valueCallback != null) {
                if (uriArr == null || (list = ArraysKt___ArraysKt.s(uriArr)) == null) {
                    uriArr2 = null;
                } else {
                    Object[] array = list.toArray(new Uri[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    uriArr2 = (Uri[]) array;
                }
                valueCallback.onReceiveValue(uriArr2);
            }
            this.filePathCallback = null;
        }
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider
    public boolean onBackPressed() {
        ViewGroup viewGroup = this.videoPlayerContainer;
        if (viewGroup != null) {
            k21.f(viewGroup);
            if (viewGroup.getChildCount() > 0) {
                hideCustomView(false);
            }
        }
        if (isBackHooked()) {
            notifyH5BackPressed();
            return true;
        }
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            return taoMaiWebView.back();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k21.i(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return createView(layoutInflater, viewGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.doDestory();
        }
        this.webView = null;
        try {
            super.onDestroy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            pageDisappear();
        } else {
            pageAppear();
        }
    }

    @Override // com.taomai.android.h5container.utils.ActivityStackManager.IActivityStackBackEvent
    public void onPageBackResult(String str) {
        String str2;
        if (str != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("data", new org.json.JSONObject(str));
            str2 = jSONObject.toString();
        } else {
            str2 = null;
        }
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.setDataOnActive(str2);
        }
        fireEvent("wvPopToDataEvent", str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.onPause();
        }
        super.onPause();
        if (!isHidden() && getUserVisibleHint()) {
            pageDisappear();
        }
    }

    public void onRefresh() {
        reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.onResume();
        }
        super.onResume();
        if (!isHidden() && getUserVisibleHint()) {
            pageAppear();
        }
    }

    public void pageAppear() {
    }

    public void pageDisappear() {
    }

    public final void reload() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.reload();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        parseArguments();
    }

    public final void setEnableProgress(boolean z) {
        this.enableProgressBar = z;
        if (z) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                k21.A("h5ProgressView");
            }
            h5Progress.showProgress();
            return;
        }
        H5Progress h5Progress2 = this.h5ProgressView;
        if (h5Progress2 == null) {
            k21.A("h5ProgressView");
        }
        h5Progress2.hideProgress();
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider
    public void setHookBackKey(boolean z) {
        this.hookBackEvent = z;
    }

    public final void setPageLoadErrorListener(Function4<? super WebView, ? super Integer, ? super String, ? super String, ur2> function4) {
        this.pageLoadErrorListener = function4;
    }

    public final void setPageLoadFinishListener(Function2<? super WebView, ? super String, ur2> function2) {
        this.pageLoadFinishListener = function2;
    }

    public final void setPageLoadStartListener(Function3<? super WebView, ? super String, ? super Bitmap, ur2> function3) {
        this.pageLoadStartListener = function3;
    }

    public final void setTitleBar(TitleBar titleBar2) {
        k21.i(titleBar2, "<set-?>");
        this.titleBar = titleBar2;
    }

    public final void setToolbar(H5ToolBar h5ToolBar) {
        k21.i(h5ToolBar, "<set-?>");
        this.toolbar = h5ToolBar;
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void setTransparentTitle(String str) {
        this.hasSetTransparentTitleFromBridge = true;
        im2 im2 = this.transparentTitleHelper;
        if (im2 != null) {
            im2.n(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        handleUserVisibleHint(z);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void setWebOptionMenu(JSONObject jSONObject, View.OnClickListener onClickListener) {
        k21.i(onClickListener, "listener");
        if (jSONObject != null) {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("color");
            String string3 = jSONObject.getString(RemoteMessageConst.Notification.ICON);
            String string4 = jSONObject.getString("icontype");
            if (string4 == null) {
                string4 = jSONObject.getString("iconType");
            }
            boolean booleanValue = jSONObject.getBooleanValue("reset");
            boolean z = true;
            if (string == null || string.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        return;
                    }
                }
            }
            TitleBar titleBar2 = this.titleBar;
            if (titleBar2 == null) {
                k21.A("titleBar");
            }
            View findViewById = titleBar2.getRightButton().findViewById(R$id.titlebar_image);
            k21.h(findViewById, "titleBar.rightButton.fin…ById(R.id.titlebar_image)");
            ImageView imageView = (ImageView) findViewById;
            String str = "";
            if (booleanValue) {
                imageView.setImageBitmap(null);
                TitleBar titleBar3 = this.titleBar;
                if (titleBar3 == null) {
                    k21.A("titleBar");
                }
                titleBar3.setRightButtonText(str);
                TitleBar titleBar4 = this.titleBar;
                if (titleBar4 == null) {
                    k21.A("titleBar");
                }
                titleBar4.setRightButtonListener(null);
                return;
            }
            TitleBar titleBar5 = this.titleBar;
            if (titleBar5 == null) {
                k21.A("titleBar");
            }
            titleBar5.setRightButtonListener(new e(this, jSONObject, onClickListener));
            if (string3 == null || string3.length() == 0) {
                imageView.setVisibility(8);
            } else {
                TitleBar titleBar6 = this.titleBar;
                if (titleBar6 == null) {
                    k21.A("titleBar");
                }
                View rightButton = titleBar6.getRightButton();
                k21.h(rightButton, "titleBar.rightButton");
                rightButton.setVisibility(0);
                imageView.setVisibility(0);
                ImageTool.b(string3, imageView);
            }
            if (string == null || string.length() == 0) {
                if (string4 != null) {
                    int hashCode = string4.hashCode();
                    if (hashCode != 109400031) {
                        if (hashCode == 1434631203 && string4.equals("settings")) {
                            string = getString(R$string.h5_ic_settings);
                        }
                    } else if (string4.equals("share")) {
                        string = getString(R$string.h5_ic_share);
                    }
                }
                string = null;
            }
            if (!(string4 == null || string4.length() == 0)) {
                z = false;
            }
            if (z) {
                TitleBar titleBar7 = this.titleBar;
                if (titleBar7 == null) {
                    k21.A("titleBar");
                }
                titleBar7.setRightButtonTextSize(16);
            } else {
                TitleBar titleBar8 = this.titleBar;
                if (titleBar8 == null) {
                    k21.A("titleBar");
                }
                titleBar8.setRightButtonTextSize(22);
            }
            TitleBar titleBar9 = this.titleBar;
            if (titleBar9 == null) {
                k21.A("titleBar");
            }
            if (string != null) {
                str = string;
            }
            titleBar9.setRightButtonText(str);
            if (string2 != null) {
                try {
                    TitleBar titleBar10 = this.titleBar;
                    if (titleBar10 == null) {
                        k21.A("titleBar");
                    }
                    titleBar10.setRightButtonTextColor(Color.parseColor(string2));
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void setWebTitle(String str) {
        this.hasSetTitleFromBridge = true;
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        if (str == null) {
            str = "";
        }
        titleBar2.setTitle(str);
    }

    public void setupWebView() {
        TaoMaiWebView taoMaiWebView;
        WebSettings settings;
        WVUIModel wvUIModel;
        View errorView;
        TaoMaiWebView taoMaiWebView2 = this.webView;
        if (taoMaiWebView2 != null) {
            taoMaiWebView2.setWebChromeClient(new TaoMaiH5Fragment$setupWebView$1(this, requireActivity()));
        }
        TaoMaiWebView taoMaiWebView3 = this.webView;
        if (taoMaiWebView3 != null) {
            taoMaiWebView3.setWebViewClient(new TaoMaiH5Fragment$setupWebView$2(this, requireActivity()));
        }
        TaoMaiWebView taoMaiWebView4 = this.webView;
        if (!(taoMaiWebView4 == null || (wvUIModel = taoMaiWebView4.getWvUIModel()) == null || (errorView = wvUIModel.getErrorView()) == null)) {
            errorView.setOnClickListener(new f(this));
        }
        if (Build.VERSION.SDK_INT > 21 && (taoMaiWebView = this.webView) != null && (settings = taoMaiWebView.getSettings()) != null) {
            settings.setMixedContentMode(0);
        }
    }

    public void showCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k21.h(activity, "activity ?: return");
            try {
                this.mCallBack = customViewCallback;
                if (this.mCustomView == null) {
                    this.mCustomView = view;
                    FrameLayout frameLayout = new FrameLayout(activity);
                    this.videoPlayerContainer = frameLayout;
                    frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
                    Window window = activity.getWindow();
                    k21.h(window, "activity.window");
                    View decorView = window.getDecorView();
                    Integer num = null;
                    if (!(decorView instanceof FrameLayout)) {
                        decorView = null;
                    }
                    FrameLayout frameLayout2 = (FrameLayout) decorView;
                    if (frameLayout2 != null) {
                        frameLayout2.addView(this.videoPlayerContainer, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (frameLayout2 != null) {
                        num = Integer.valueOf(frameLayout2.getSystemUiVisibility());
                    }
                    this.originalVisibility = num;
                    if (view != null) {
                        view.setKeepScreenOn(true);
                    }
                    setCustomFullscreen(activity, true);
                    activity.setRequestedOrientation(6);
                } else if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void showProgressIfEnable() {
        if (this.enableProgressBar) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                k21.A("h5ProgressView");
            }
            h5Progress.showProgress();
            H5Progress h5Progress2 = this.h5ProgressView;
            if (h5Progress2 == null) {
                k21.A("h5ProgressView");
            }
            h5Progress2.updateProgress(10);
        }
    }

    public final void showTitleBar() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            k21.A("toolbar");
        }
        h5ToolBar.setVisibility(0);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void showWebOptionMenu() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        View rightButton = titleBar2.getRightButton();
        if (rightButton != null) {
            rightButton.setVisibility(0);
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void showWebTitle() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            k21.A("toolbar");
        }
        h5ToolBar.setVisibility(0);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void showWebTitleBackBtn() {
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            k21.A("titleBar");
        }
        View leftButton = titleBar2.getLeftButton();
        k21.h(leftButton, "titleBar.leftButton");
        leftButton.setVisibility(0);
    }

    public final void updateProgress(int i) {
        if (this.enableProgressBar) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                k21.A("h5ProgressView");
            }
            h5Progress.updateProgress(i);
        }
    }
}
