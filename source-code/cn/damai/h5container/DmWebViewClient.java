package cn.damai.h5container;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.nav.a;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginUrlConstants;
import com.taobao.login4android.scan.QrScanActivity;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;
import com.uc.webview.export.WebResourceError;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.youku.android.utils.OPRUtils;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import tb.bj2;
import tb.d20;
import tb.gr;
import tb.p21;
import tb.pp2;
import tb.qt0;
import tb.rb0;
import tb.yh1;
import tb.yl;

/* compiled from: Taobao */
public class DmWebViewClient extends bj2 {
    private static transient /* synthetic */ IpChange $ipChange;
    final Pattern ACCEPTED_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
    Activity activity;
    Fragment fragment;
    a unSkipProcessor;

    public DmWebViewClient(Fragment fragment2) {
        super(fragment2.getActivity());
        this.fragment = fragment2;
        this.activity = fragment2.getActivity();
        this.unSkipProcessor = new a();
    }

    private void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782208999")) {
            ipChange.ipc$dispatch("-782208999", new Object[]{this});
            return;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 instanceof WebViewFragment) {
            ((WebViewFragment) fragment2).checkLogin();
        } else if (fragment2 instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment2).checkLogin();
        }
    }

    private boolean checkNetError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175882081")) {
            return ((Boolean) ipChange.ipc$dispatch("1175882081", new Object[]{this})).booleanValue();
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 instanceof WebViewFragment) {
            return ((WebViewFragment) fragment2).checkNetError();
        }
        if (fragment2 instanceof DMH5Fragment) {
            return ((DMH5Fragment) fragment2).checkNetError();
        }
        return false;
    }

    private void finishInterceptIfPageEmpty(WebView webView) {
        WebBackForwardList copyBackForwardList;
        Activity activity2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659845806")) {
            ipChange.ipc$dispatch("-1659845806", new Object[]{this, webView});
        } else if (webView != null && (copyBackForwardList = webView.copyBackForwardList()) != null) {
            Log.d("damai-webview", "finishInterceptIfPageEmpty: " + copyBackForwardList.getSize());
            if (copyBackForwardList.getSize() != 0 || (activity2 = this.activity) == null || activity2.isFinishing()) {
                WebHistoryItem currentItem = copyBackForwardList.getCurrentItem();
                if (currentItem != null && yl.Companion.c(currentItem.getUrl()) && !this.activity.isFinishing()) {
                    this.activity.finish();
                    return;
                }
                return;
            }
            this.activity.finish();
        }
    }

    private boolean isNumeric(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1285045637")) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1285045637", new Object[]{this, str})).booleanValue();
    }

    private boolean isSpecializedHandlerAvailable(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358442451")) {
            return ((Boolean) ipChange.ipc$dispatch("358442451", new Object[]{this, intent})).booleanValue();
        }
        List<ResolveInfo> queryIntentActivities = this.activity.getPackageManager().queryIntentActivities(intent, 64);
        if (!(queryIntentActivities == null || queryIntentActivities.size() == 0)) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (!(intentFilter == null || (intentFilter.countDataAuthorities() == 0 && intentFilter.countDataPaths() == 0))) {
                    return true;
                }
            }
        }
        return false;
    }

    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2090098275")) {
            return this.activity;
        }
        return (Activity) ipChange.ipc$dispatch("-2090098275", new Object[]{this});
    }

    @Override // com.uc.webview.export.WebViewClient, tb.bj2, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageFinished(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548221258")) {
            ipChange.ipc$dispatch("1548221258", new Object[]{this, webView, str});
            return;
        }
        super.onPageFinished(webView, str);
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            return;
        }
        if (fragment2 instanceof WebViewFragment) {
            ((WebViewFragment) fragment2).onPageFinished(webView, str);
        } else if (fragment2 instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment2).onPageFinished(webView, str);
        }
    }

    @Override // com.uc.webview.export.WebViewClient, tb.bj2, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Fragment fragment2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555569895")) {
            ipChange.ipc$dispatch("555569895", new Object[]{this, webView, str, bitmap});
            return;
        }
        super.onPageStarted(webView, str, bitmap);
        if (yh1.b(getActivity()) && (fragment2 = this.fragment) != null) {
            if (fragment2 instanceof WebViewFragment) {
                ((WebViewFragment) fragment2).onResponseSuccess();
            } else if (fragment2 instanceof DMH5Fragment) {
                ((DMH5Fragment) fragment2).onResponseSuccess();
            }
        }
    }

    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Fragment fragment2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-863344059")) {
            ipChange.ipc$dispatch("-863344059", new Object[]{this, webView, Integer.valueOf(i), str, str2});
            return;
        }
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT >= 23 || (fragment2 = this.fragment) == null) {
            return;
        }
        if (fragment2 instanceof WebViewFragment) {
            ((WebViewFragment) fragment2).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
            ((WebViewFragment) this.fragment).neterror = true;
        } else if (fragment2 instanceof DMH5Fragment) {
            ((DMH5Fragment) fragment2).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
            ((DMH5Fragment) this.fragment).setNeterror(true);
        }
    }

    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094993302")) {
            return (WebResourceResponse) ipChange.ipc$dispatch("-1094993302", new Object[]{this, webView, str});
        }
        Log.d("shouldIntercept", "url : ---- " + str);
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.uc.webview.export.WebViewClient, tb.bj2, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561395014")) {
            return ((Boolean) ipChange.ipc$dispatch("-1561395014", new Object[]{this, webView, str})).booleanValue();
        }
        Log.d("damai-webview", "H5MainActivity.shouldOverrideUrlLoading(): url=" + str);
        super.shouldOverrideUrlLoading(webView, str);
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            if (checkNetError()) {
                return true;
            }
            if (LoginUrlConstants.isCommonScanUrl(str)) {
                Intent intent = new Intent(getActivity(), QrScanActivity.class);
                intent.putExtra(LoginConstant.SCAN_KEY, str);
                this.activity.startActivity(intent);
                this.activity.finish();
                return true;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("intercept");
            if (!TextUtils.isEmpty(queryParameter) && "no".equals(queryParameter)) {
                return false;
            }
            if (HavanaProxy.v().B(str)) {
                if (!LoginManager.k().q()) {
                    new DMThemeDialog(this.activity).r(DMThemeDialog.DMDialogTheme.THEME_TAOBAO_LOGIN).o("淘宝授权 登录大麦账号").f(false).i("手机淘宝登录", new DialogInterface.OnClickListener() {
                        /* class cn.damai.h5container.DmWebViewClient.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1506113079")) {
                                ipChange.ipc$dispatch("1506113079", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                                return;
                            }
                            HavanaProxy.v().p(DmWebViewClient.this.activity);
                        }
                    }).g(true, null).show();
                } else {
                    HavanaProxy.v().P(this.activity, new HavanaProxy.UccTrustLoginListener() {
                        /* class cn.damai.h5container.DmWebViewClient.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
                        public void onFail() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-39013877")) {
                                ipChange.ipc$dispatch("-39013877", new Object[]{this});
                            }
                        }

                        @Override // cn.damai.login.havana.HavanaProxy.UccTrustLoginListener
                        public void onSuccess() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-2119202402")) {
                                ipChange.ipc$dispatch("-2119202402", new Object[]{this});
                                return;
                            }
                            Fragment fragment = DmWebViewClient.this.fragment;
                            if (fragment == null) {
                                return;
                            }
                            if (fragment instanceof WebViewFragment) {
                                if (((WebViewFragment) fragment).mWebView != null) {
                                    ((WebViewFragment) fragment).mWebView.reload();
                                }
                            } else if (fragment instanceof DMH5Fragment) {
                                ((DMH5Fragment) fragment).reload();
                            }
                        }
                    });
                }
                return true;
            } else if (str.contains("m.damai.cn/ticket")) {
                if (toDetailPage(str.substring(str.lastIndexOf("/") + 1, str.indexOf(".htm")), str, webView)) {
                    return true;
                }
            } else if (str.contains("piao.damai.cn/") || str.contains("m.damai.cn/ticket")) {
                int lastIndexOf = str.lastIndexOf("/");
                int indexOf = str.indexOf(".htm");
                int i = lastIndexOf + 1;
                if (i <= indexOf && i >= 0 && indexOf >= 0) {
                    try {
                        toDetailPage(str.substring(i, indexOf), str, webView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            } else if (str.contains("m.damai.cn/proj.aspx?id")) {
                HashMap<String, String> pamMap = WebViewUtil.getPamMap(str);
                if (pamMap != null && toDetailPage(pamMap.get("id"), str, webView)) {
                    return true;
                }
            } else if (str.contains("h5.m.taobao.com/damai/perform/item.html?projectId") || str.contains("m.damai.cn/damai/perform/item.html?projectId")) {
                HashMap<String, String> pamMap2 = WebViewUtil.getPamMap(str);
                if (pamMap2 != null && toDetailPage(pamMap2.get("projectId"), str, webView)) {
                    return true;
                }
            } else if (str.contains("m.damai.cn/weixinshare.aspx") || str.contains("m.damai.cn/weixinfshare.aspx")) {
                WebViewUtil.share(str, getActivity());
                return true;
            } else if (str.contains("m.damai.cn/children.html")) {
                getActivity().setResult(101);
                this.activity.finish();
            } else if (str.contains("mapi.damai.cn/Page/ScanCodeLogin/Success.aspx")) {
                getActivity().setResult(101);
                this.activity.finish();
            } else if (str.contains("mapi.damai.cn/Page/ScanCodeLogin/error.aspx?error=")) {
                checkLogin();
                this.activity.finish();
                return true;
            } else if (str.contains("msecurity.damai.cn/securityCenter-front-wap/successbind")) {
                d20.b0(true);
                d20.b0(true);
            } else if (str.contains("http://m.damai.cn/proj.aspx?id")) {
                HashMap<String, String> pamMap3 = WebViewUtil.getPamMap(str);
                if (pamMap3 == null) {
                    return false;
                }
                long parseLong = Long.parseLong(pamMap3.get("id"));
                if (this.mContext.get() != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(IssueConstants.ProjectID, parseLong);
                    DMNav.from(this.activity).withExtras(intent2.getExtras()).toUri(gr.a());
                }
                finishInterceptIfPageEmpty(webView);
                return true;
            } else if (str.startsWith("https://m.damai.cn/damai/activity/detaillist/index.html")) {
                String queryParameter2 = Uri.parse(str).getQueryParameter("id");
                if (isNumeric(queryParameter2)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", queryParameter2);
                    DMNav.from(this.activity).withExtras(bundle).toUri(NavUri.b("detailed_list"));
                    finishInterceptIfPageEmpty(webView);
                    return true;
                }
            } else if (str.startsWith("https://m.damai.cn/app/dmfe/dramas/pages/ip/index.html")) {
                String queryParameter3 = Uri.parse(str).getQueryParameter(p21.ISSUE_PARAM_IPID);
                if (isNumeric(queryParameter3)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("id", queryParameter3);
                    DMNav.from(this.activity).withExtras(bundle2).toUri(NavUri.b("ipdrama"));
                    finishInterceptIfPageEmpty(webView);
                    return true;
                }
            } else if (str.startsWith("https://m.damai.cn/app/dmfe/show/pages/starHome/index.html")) {
                String queryParameter4 = Uri.parse(str).getQueryParameter("artistId");
                if (isNumeric(queryParameter4)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("userId", queryParameter4);
                    bundle3.putString(RepertoireDetailFragment.USERTYPE, "2");
                    DMNav.from(this.activity).withExtras(bundle3).toUri(NavUri.b(gr.Y));
                    this.activity.finish();
                    return true;
                }
            } else if (str.startsWith("https://m.damai.cn/app/dmfe/show/pages/brand/index.html")) {
                String queryParameter5 = Uri.parse(str).getQueryParameter("brandId");
                if (isNumeric(queryParameter5)) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("userId", queryParameter5);
                    bundle4.putString(RepertoireDetailFragment.USERTYPE, "4");
                    DMNav.from(this.activity).withExtras(bundle4).toUri(NavUri.b(gr.Y));
                    this.activity.finish();
                    return true;
                }
            } else {
                int shouldIntercept = NativePageInterceptor.shouldIntercept(str);
                if (shouldIntercept != 0) {
                    NativePageInterceptor.interceptToNativePage(this.activity, shouldIntercept, str);
                    finishInterceptIfPageEmpty(webView);
                    return true;
                } else if (qt0.e(str, qt0.d()) && !str.contains(rb0.j)) {
                    Log.d("damai-webview", "H5UrlConstant.interceptUrl: url=" + str);
                    DMNav.from(this.activity).toUri(str);
                    return true;
                } else if (this.unSkipProcessor.e(str, this.activity, null)) {
                    finishInterceptIfPageEmpty(webView);
                    return true;
                } else if (!new PayTask(getActivity()).payInterceptorWithUrl(str, true, new H5PayCallback() {
                    /* class cn.damai.h5container.DmWebViewClient.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.alipay.sdk.app.H5PayCallback
                    public void onPayResult(H5PayResultModel h5PayResultModel) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1897277608")) {
                            ipChange.ipc$dispatch("-1897277608", new Object[]{this, h5PayResultModel});
                            return;
                        }
                        Log.d("damai-webview", "PayTask.onPayResult: result=" + h5PayResultModel.getReturnUrl() + ", :" + h5PayResultModel.getResultCode());
                        final String returnUrl = h5PayResultModel.getReturnUrl();
                        if (!TextUtils.isEmpty(returnUrl)) {
                            DmWebViewClient.this.getActivity().runOnUiThread(new Runnable() {
                                /* class cn.damai.h5container.DmWebViewClient.AnonymousClass3.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-801014839")) {
                                        ipChange.ipc$dispatch("-801014839", new Object[]{this});
                                        return;
                                    }
                                    Activity activity = DmWebViewClient.this.activity;
                                    if (activity != null) {
                                        DMNav.from(activity).toUri(returnUrl);
                                        DmWebViewClient.this.activity.finish();
                                    }
                                }
                            });
                        }
                    }
                })) {
                    return false;
                } else {
                    Log.d("damai-webview", "PayTask.payInterceptorWithUrl: url=" + str);
                    return true;
                }
            }
        } else if (str.contains("asyn://needLogIn")) {
            checkLogin();
            return true;
        } else if (str.contains("event://movie")) {
            Intent intent3 = new Intent();
            intent3.putExtra("url", pp2.TPP_H5_URL);
            DMNav.from(this.mContext.get()).withExtras(intent3.getExtras()).toUri(NavUri.b(gr.t));
            return true;
        } else if (str.equals("asyn://backToNative")) {
            this.activity.finish();
            return true;
        } else if (str.startsWith("alipays:") || str.startsWith("alipay")) {
            try {
                this.mContext.get().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
                new DMDialog(this.mContext.get()).q("未检测到支付宝客户端，请安装后重试。").n("立即安装", new DialogInterface.OnClickListener() {
                    /* class cn.damai.h5container.DmWebViewClient.AnonymousClass5 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1089469875")) {
                            ipChange.ipc$dispatch("1089469875", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                            return;
                        }
                        ((Context) ((WVUCWebViewClient) DmWebViewClient.this).mContext.get()).startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com")));
                        dialogInterface.dismiss();
                    }
                }).i("取消", new DialogInterface.OnClickListener() {
                    /* class cn.damai.h5container.DmWebViewClient.AnonymousClass4 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "119888852")) {
                            ipChange.ipc$dispatch("119888852", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                            return;
                        }
                        dialogInterface.dismiss();
                    }
                }).t(3).o(true).show();
            }
            return true;
        } else if (!str.startsWith(pp2.SCHEME)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (this.ACCEPTED_URI_SCHEMA.matcher(str).matches() && !isSpecializedHandlerAvailable(parseUri)) {
                    return false;
                }
                try {
                    this.activity.startActivityIfNeeded(parseUri, -1);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (URISyntaxException e3) {
                Log.w("Browser", "Bad URI " + str + ": " + e3.getMessage());
                return false;
            }
        } else if (str.startsWith("damai://V1/SystemSeting")) {
            DMNav.from(this.activity).toUri(str);
            finishInterceptIfPageEmpty(webView);
            return true;
        } else if (str.startsWith("damai://V1/PushSeting")) {
            DMNav.from(this.activity).toUri(str);
            finishInterceptIfPageEmpty(webView);
            return true;
        } else if (str.startsWith("damai://V1/PrivacySeting")) {
            DMNav.from(this.activity).toUri(str);
            finishInterceptIfPageEmpty(webView);
            return true;
        }
        return false;
    }

    public boolean toDetailPage(String str, String str2, WebView webView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982425899")) {
            return ((Boolean) ipChange.ipc$dispatch("982425899", new Object[]{this, str, str2, webView})).booleanValue();
        }
        try {
            if (str2.contains(rb0.j)) {
                return false;
            }
            long parseLong = Long.parseLong(str);
            Bundle bundle = new Bundle();
            bundle.putLong(IssueConstants.ProjectID, parseLong);
            DMNav.from(getActivity()).withExtras(bundle).toUri(gr.a());
            finishInterceptIfPageEmpty(webView);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Fragment fragment2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304525351")) {
            ipChange.ipc$dispatch("-304525351", new Object[]{this, webView, webResourceRequest, webResourceError});
            return;
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webResourceRequest.isForMainFrame() && (fragment2 = this.fragment) != null) {
            if (fragment2 instanceof WebViewFragment) {
                ((WebViewFragment) fragment2).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
                ((WebViewFragment) this.fragment).neterror = true;
            } else if (fragment2 instanceof DMH5Fragment) {
                ((DMH5Fragment) fragment2).onResponseError("网络不可用,请检查您的网络.", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
                ((DMH5Fragment) this.fragment).setNeterror(true);
            }
        }
    }
}
