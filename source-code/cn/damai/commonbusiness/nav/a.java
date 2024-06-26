package cn.damai.commonbusiness.nav;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.nav.CommonInterceptRules;
import cn.damai.h5container.UniH5ContainerSwitcher;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.pay.AliPayActivity;
import cn.damai.wantsee.StartConfig;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.channel.activity.NewShowCalendarActivity;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import tb.d20;
import tb.g91;
import tb.gr;
import tb.hp1;
import tb.jr2;
import tb.kr2;
import tb.lp1;
import tb.p21;
import tb.pp2;
import tb.qt0;
import tb.s41;
import tb.sk;
import tb.wk;
import tb.xs0;
import tb.yj1;

/* compiled from: Taobao */
public class a extends sk {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String c = "checklogin";
    Uri a;
    List<CommonInterceptRules.RouterParam> b;

    public a() {
        this.b = new ArrayList();
        this.b = new CommonInterceptRules().getRules();
    }

    private boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354937640")) {
            return ((Boolean) ipChange.ipc$dispatch("1354937640", new Object[]{this, str})).booleanValue();
        } else if (!str.contains("/damai/activity/savecomment/index.html") && !str.contains("shows/pages/save-comment.html")) {
            return false;
        } else {
            String f = f();
            if ("all".equals(f)) {
                return true;
            }
            if ("none".equals(f)) {
                return false;
            }
            if (!"new".equals(f) || !str.contains("shows/pages/save-comment.html")) {
                return "old".equals(f) && str.contains("/damai/activity/savecomment/index.html");
            }
            return true;
        }
    }

    private boolean d(String str, Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69801884")) {
            return ((Boolean) ipChange.ipc$dispatch("-69801884", new Object[]{this, str, context, intent})).booleanValue();
        }
        List<CommonInterceptRules.RouterParam> list = this.b;
        if (list == null) {
            return false;
        }
        for (CommonInterceptRules.RouterParam routerParam : list) {
            g91.b("DMNav", "UnSkipProcessor commonInte : " + routerParam.keyUri);
            if (!TextUtils.isEmpty(routerParam.keyUri) && str.contains(routerParam.keyUri)) {
                Uri parse = Uri.parse(str);
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(routerParam.sourceParamKey)) {
                    String queryParameter = parse.getQueryParameter(routerParam.sourceParamKey);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString(routerParam.targetParamKey, queryParameter);
                    }
                }
                Bundle bundle2 = routerParam.extraBundle;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                if (intent != null) {
                    intent.putExtras(bundle);
                    DMNav.from(context).stack(g(intent)).withExtras(intent.getExtras()).toUri(NavUri.b(routerParam.targetUri));
                } else {
                    DMNav.from(context).withExtras(bundle).toUri(NavUri.b(routerParam.targetUri));
                }
                return true;
            }
        }
        return false;
    }

    private static String f() {
        JSONObject c2;
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85801351")) {
            return (String) ipChange.ipc$dispatch("85801351", new Object[0]);
        }
        String b2 = d20.b();
        if (TextUtils.isEmpty(b2) || (c2 = s41.c(b2)) == null || !c2.containsKey("publisherH5Intercept") || !(c2.get("publisherH5Intercept") instanceof JSONObject) || (jSONObject = (JSONObject) c2.get("publisherH5Intercept")) == null || !jSONObject.containsKey("type")) {
            return "all";
        }
        return jSONObject.getString("type");
    }

    private void h(Intent intent, Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671694476")) {
            ipChange.ipc$dispatch("-671694476", new Object[]{this, intent, context, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IssueConstants.ProjectID, str);
        intent.putExtras(bundle);
        DMNav.from(context).stack(g(intent)).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
    }

    private boolean i(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "632308819")) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return ((Boolean) ipChange.ipc$dispatch("632308819", new Object[]{this, str})).booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k(Context context, DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533580559")) {
            ipChange.ipc$dispatch("-533580559", new Object[]{context, dialogInterface, Integer.valueOf(i)});
            return;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com")));
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l(DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1557481136")) {
            ipChange.ipc$dispatch("1557481136", new Object[]{dialogInterface, Integer.valueOf(i)});
            return;
        }
        dialogInterface.dismiss();
    }

    @Override // tb.sk, cn.damai.common.nav.DMNav.NavPreprocessor
    public void addStackUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59051804")) {
            ipChange.ipc$dispatch("-59051804", new Object[]{this, uri});
            return;
        }
        this.a = uri;
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, Context context) {
        Uri parse;
        String queryParameter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916701050")) {
            return ((Boolean) ipChange.ipc$dispatch("-1916701050", new Object[]{this, intent, context})).booleanValue();
        }
        if (intent == null || TextUtils.isEmpty(intent.getDataString())) {
            return false;
        }
        String dataString = intent.getDataString();
        g91.b("DMNav", "UnSkipProcessor url : " + dataString);
        Uri parse2 = Uri.parse(dataString);
        if (parse2 != null && !parse2.isOpaque()) {
            String queryParameter2 = parse2.getQueryParameter("spm");
            if (!TextUtils.isEmpty(queryParameter2)) {
                g91.b("DMNav", "spm url 埋点拦截：" + queryParameter2 + " uri=" + dataString);
                HashMap hashMap = new HashMap();
                hashMap.put("spm-url", queryParameter2);
                UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(hashMap);
            }
        }
        if (dataString.startsWith("damai://perform_calendar") || dataString.startsWith("damai://V1/PerformCalendar")) {
            if (StartConfig.isOpenNewShowCalendar()) {
                NewShowCalendarActivity.Companion.a(context);
                return true;
            }
            DMNav.from(context).stack(g(intent)).toUri(Uri.parse("damai://cms_common_second?patternName=dm_project_filter_option&patternVersion=2.0&dateType=10&sortType=10&title=演出日历"));
            return true;
        } else if (dataString.startsWith(pp2.SCHEME)) {
            int intExtra = intent.getIntExtra(DMNav.KRequestCodeReferrer, -1);
            pp2.b().a(g(intent));
            pp2.b().s(context, dataString, intExtra, true, intent);
            g91.b("DMNav", "UnSkipProcessor goto  UIRouterManager : " + dataString);
            return true;
        } else if (!intent.getBooleanExtra(c, false) || LoginManager.k().q()) {
            if (parse2 != null) {
                Uri.Builder buildUpon = parse2.buildUpon();
                if ("true".equals(parse2.getQueryParameter("needcity"))) {
                    buildUpon.appendQueryParameter("citycode", String.valueOf(d20.c()));
                }
                if ("true".equals(parse2.getQueryParameter("needcoordinate")) && hp1.i(lp1.LOCATION)) {
                    buildUpon.appendQueryParameter("longitude", String.valueOf(d20.o())).appendQueryParameter("latitude", String.valueOf(d20.n()));
                }
                intent.setData(buildUpon.build());
            }
            String queryParameter3 = parse2.getQueryParameter("intercept");
            if (!TextUtils.isEmpty(queryParameter3) && "no".equals(queryParameter3) && dataString.trim().startsWith("http")) {
                g91.b("DMNav", "UnSkipProcessor intercept=no,open webview");
                Bundle bundle = new Bundle();
                bundle.putAll(intent.getExtras());
                bundle.putString("url", dataString.trim());
                DMNav.from(xs0.a()).stack(g(intent)).withExtras(bundle).toUri(NavUri.b(a.c.d));
                return true;
            } else if (j(dataString)) {
                g91.b("DMNav", "UnSkipProcessor goto ProjectDetail : " + dataString);
                if (dataString.contains("?")) {
                    dataString = dataString.substring(0, dataString.indexOf("?"));
                }
                h(intent, context, dataString.replace("https://piao.damai.cn/", "").replace("https://detail.damai.cn/", "").replace(".html", ""));
                return true;
            } else {
                if (dataString.startsWith("https://m.damai.cn/damai/project/item.html") || dataString.startsWith("https://item.damai.cn/item/project.htm")) {
                    g91.b("DMNav", "UnSkipProcessor goto ProjectDetail : " + dataString);
                    String queryParameter4 = Uri.parse(dataString).getQueryParameter("id");
                    if (i(queryParameter4)) {
                        h(intent, context, queryParameter4);
                        return true;
                    }
                }
                if (dataString.startsWith("https://m.damai.cn/damai/activity/performlist/index.html")) {
                    g91.b("DMNav", "UnSkipProcessor goto ranklist : " + dataString);
                    String queryParameter5 = Uri.parse(dataString).getQueryParameter("id");
                    if (i(queryParameter5)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(RankListFragment.KEY_RANK_ID, queryParameter5);
                        intent.putExtras(bundle2);
                        DMNav.from(context).stack(g(intent)).withExtras(bundle2).toUri(NavUri.b(gr.C));
                        return true;
                    }
                }
                if (dataString.startsWith("https://m.damai.cn/damai/activity/detaillist/index.html")) {
                    g91.b("DMNav", "UnSkipProcessor goto detaillist : " + dataString);
                    String queryParameter6 = Uri.parse(dataString).getQueryParameter("id");
                    if (i(queryParameter6)) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("id", queryParameter6);
                        intent.putExtras(bundle3);
                        DMNav.from(context).stack(g(intent)).withExtras(bundle3).toUri(NavUri.b("detailed_list"));
                        return true;
                    }
                }
                if (dataString.contains("/shows/pages/jbs/drama.html")) {
                    g91.b("DMNav", "UnSkipProcessor goto SCRIPT_DETAIL : " + dataString);
                    Uri parse3 = Uri.parse(dataString);
                    String queryParameter7 = parse3.getQueryParameter("scriptId");
                    String queryParameter8 = parse3.getQueryParameter("storeId");
                    if (i(queryParameter7)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("scriptId", queryParameter7);
                        bundle4.putString("storeId", queryParameter8);
                        intent.putExtras(bundle4);
                        DMNav.from(context).stack(g(intent)).withExtras(bundle4).toUri(NavUri.b(gr.SCRIPT_DETAIL));
                        return true;
                    }
                }
                if (c(dataString) && (queryParameter = (parse = Uri.parse(dataString)).getQueryParameter("publisherType")) != null && (queryParameter.equals("ReleaseType_Evaluate") || queryParameter.equals("ReleaseType_Edit_Evaluate") || queryParameter.equals("ReleaseType_Discovery_Privilege"))) {
                    String queryParameter9 = parse.getQueryParameter("targetId");
                    String queryParameter10 = parse.getQueryParameter("itemId");
                    String queryParameter11 = parse.getQueryParameter(p21.ISSUE_PARAM_COMMENT_ID);
                    String queryParameter12 = parse.getQueryParameter(p21.ISSUE_PARAM_COMMENT_TYPE);
                    String queryParameter13 = parse.getQueryParameter(p21.ISSUE_PARAM_PERFORM_TIMR);
                    String queryParameter14 = parse.getQueryParameter(p21.ISSUE_PARAM_TIMEDES);
                    String queryParameter15 = parse.getQueryParameter(p21.ISSUE_PARAM_WATCH_ACTIVITY_ID);
                    String queryParameter16 = parse.getQueryParameter("appPublishHint");
                    String queryParameter17 = parse.getQueryParameter(p21.ISSUE_PARAM_ORDER_ID);
                    String queryParameter18 = parse.getQueryParameter("scriptId");
                    Bundle bundle5 = new Bundle();
                    bundle5.putString(p21.ISSUE_PARAM_COMMENT_ID, queryParameter11);
                    bundle5.putString("publisherType", queryParameter);
                    bundle5.putString("appPublishHint", queryParameter16);
                    bundle5.putString("targetId", queryParameter9);
                    bundle5.putString("itemId", queryParameter10);
                    bundle5.putString(p21.ISSUE_PARAM_COMMENT_TYPE, queryParameter12);
                    bundle5.putString(p21.ISSUE_PARAM_TIMEDES, queryParameter14);
                    bundle5.putString(p21.ISSUE_PARAM_PERFORM_TIMR, queryParameter13);
                    bundle5.putString(p21.ISSUE_PARAM_WATCH_ACTIVITY_ID, queryParameter15);
                    bundle5.putString(p21.ISSUE_PARAM_ORDER_ID, queryParameter17);
                    bundle5.putString("scriptId", queryParameter18);
                    intent.putExtras(bundle5);
                    DMNav.from(context).stack(g(intent)).withExtras(bundle5).toUri(NavUri.b("issue"));
                    return true;
                } else if (qt0.e(dataString, qt0.c())) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        extras.putBoolean(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE, true);
                    }
                    DMNav.from(context).stack(g(intent)).withExtras(extras).toUri(NavUri.b(gr.h));
                    g91.b("DMNav", "UnSkipProcessor H5UrlConstant.interceptUrl getOrderUrls: " + dataString);
                    return true;
                } else if (qt0.e(dataString, qt0.b())) {
                    DMNav.from(context).stack(g(intent)).withExtras(intent.getExtras()).toUri(NavUri.b(gr.f));
                    g91.b("DMNav", "UnSkipProcessor H5UrlConstant.interceptUrl getOrderList: " + dataString);
                    return true;
                } else if (e(dataString, context, intent)) {
                    return true;
                } else {
                    if (dataString.startsWith("damai://webview") && UniH5ContainerSwitcher.getInstance().shouldInterceptUrl(intent.getStringExtra("url"))) {
                        DMNav.from(context).withExtras(intent.getExtras()).toUri(NavUri.b(gr.u));
                        return true;
                    } else if (dataString.startsWith("alipays:") || dataString.startsWith("alipay")) {
                        try {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(dataString)));
                            return true;
                        } catch (Exception unused) {
                            new DMDialog(context).q("未检测到支付宝客户端，请安装后重试。").n("立即安装", new jr2(context)).i("取消", kr2.a).t(3).o(true).show();
                            return true;
                        }
                    } else {
                        g91.b("DMNav", "UnSkipProcessor return false : " + dataString);
                        return false;
                    }
                }
            }
        } else {
            DMNav.from(context).forResult(intent.getIntExtra(DMNav.KRequestCodeReferrer, -1)).toUri("damai://login");
            g91.b("DMNav", "UnSkipProcessor goto login : " + dataString);
            return true;
        }
    }

    public boolean e(String str, Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759621563")) {
            return ((Boolean) ipChange.ipc$dispatch("1759621563", new Object[]{this, str, context, intent})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            if (d(str, context, intent)) {
                return true;
            }
            if (!str.startsWith(NewShowCalendarActivity.DEFAULT_CALENDAR_H5_PRE_URL) && !str.startsWith(NewShowCalendarActivity.DEFAULT_CALENDAR_H5_ONLINE_URL)) {
                return false;
            }
            NewShowCalendarActivity.Companion.a(context);
            return true;
        }
    }

    public Uri g(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071457154")) {
            return (Uri) ipChange.ipc$dispatch("2071457154", new Object[]{this, intent});
        } else if (intent == null || !"true".equals(intent.getStringExtra(yj1.KEY_DMNAV_PUSH_FLAT))) {
            return null;
        } else {
            return this.a;
        }
    }

    public boolean j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657949430")) {
            return ((Boolean) ipChange.ipc$dispatch("1657949430", new Object[]{this, str})).booleanValue();
        } else if (str == null || str.trim().length() == 0) {
            return false;
        } else {
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            if (str.startsWith("https://piao.damai.cn/") || (str.startsWith("https://detail.damai.cn/") && str.endsWith(".html"))) {
                return i(str.replace("https://piao.damai.cn/", "").replace("https://detail.damai.cn/", "").replace(".html", ""));
            }
            return false;
        }
    }
}
