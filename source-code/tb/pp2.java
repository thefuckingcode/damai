package tb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.category.ui.ShowFragment;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$string;
import cn.damai.im.UserInfoUtil;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class pp2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SCHEME = "damai://V1/";
    public static final String SCHEME_CATEGORYPAGE = "damai://V1/CategoryPage";
    public static final String SCHEME_HOMEPAGE = "damai://V1/HomePage";
    public static final String SCHEME_MINEPAGE = "damai://V1/MinePage";
    public static final String SCHEME_PROJECT_DETAIL = "damai://V1/ProjectPage?id=";
    public static final String TPP_H5_URL = "https://h5.m.taopiaopiao.com/app/movie/pages/index/index.html?from=damai";
    private static volatile pp2 c = null;
    public static String d = "from";
    public static int e = 1;
    public static Map<String, String> f = new HashMap();
    Uri a;
    private boolean b = false;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(pp2 pp2) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-981985943")) {
                ipChange.ipc$dispatch("-981985943", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
        }
    }

    private pp2() {
        f.put("LiveRoom", "liveroom");
        f.put("IpDramaPage", "ipdrama");
        f.put("RepertoirePage", wz1.REPERTOITE);
        f.put("UserprofilePage", gr.Y);
        f.put("OrderDetailPage", gr.g);
        f.put("HNOrderDetailPage", gr.h);
        f.put("MediaBrowser", "videobrowse");
        f.put("TicketReceivePage", "ticklet");
        f.put("TicketDetailPage", "member_ticketwalletinfo");
        f.put("TicketListPage", "member_ticketwalletlist");
        f.put("CommentDetailPage", "commentdetail");
        f.put("CommentListPage", "comment_list");
        f.put("TicketToCommentListPage", "mycomment");
        f.put("FollowReplyPage", gr.y);
        f.put("PublishPage", "issue");
        f.put("RealNameAuthResult", "realname_auth_result");
        f.put("FeedBackDetailPage", "my_feed_back_detail");
        f.put("OrderCheckPage", gr.c);
        f.put("RankingListPage", gr.C);
        f.put("IPRankingListPage", gr.D);
        f.put("DetailedListPage", gr.E);
        f.put("DiscountPage", gr.DISCOUNT_TICKET);
        f.put("Discover", gr.PAGE_DISCOVER);
        f.put("DiscoverThemePage", gr.DISCOVER_THEME);
        f.put("DiscoverContentDetail", gr.DISCOVER_CONTENT_DETAIL);
        f.put("DramaComming", gr.DRAMA_COMMING);
        f.put("LiveHouseSecond", gr.LIVE_HOUSE_SECOND_PAGE);
        f.put("NewStarList", gr.r);
        f.put("NewBrandList", gr.s);
        f.put("MemberCenterTab", gr.q);
        f.put("ArtistOfficialContentListPage", gr.PAGE_ARTIST_OFFICAL_CONTENT_LIST);
        f.put("Popcorn", "popcorn_open_mock_case_list");
        f.put("skuPage", gr.F);
        f.put("PerformCalendar", gr.A);
        f.put("RankSquare", gr.B);
        f.put("RankSquareCmsPage", gr.RANK_SQUARE_CMS_HOST);
        f.put("DiscoverCircleThemePage", gr.DISCOVER_CIRCLE_THEME_PAGE);
        f.put("MessagePushSetting", gr.MESSAGE_PUSH_SETTING);
        f.put("ArtistOfficialContentListPage", gr.B);
        f.put("CmsCommonSecond", "cms_common_second");
        f.put("SystemSeting", gr.PERMISSION_ENTRANCE);
        f.put("PushSeting", gr.MESSAGE_PUSH_SETTING);
        f.put("PrivacySeting", gr.PRIVACY_SETTING);
        f.put("VenueNavi", "venuemap");
        f.put("ScriptPlay", gr.SCRIPT_SHOP_DETAIL);
        f.put("ScriptDetail", gr.SCRIPT_DETAIL);
        f.put("ScriptCouponDetail", gr.SCRIPT_COUPON_DETAIL);
        f.put("CouponPayResult", gr.SCRIPT_COUPON_PAY_RESULT);
        f.put("EvaluateList", gr.W);
        f.put("MinePage?value=FollowPage", gr.H);
        f.put("MinePage?value=FansPage", gr.H);
        f.put("MinePage?value=WantPraisePage", gr.I);
        f.put("MinePage?value=WantedPage", "MinePage");
        f.put("MessagePage", gr.x);
        f.put("MinePage?value=DynamicPage", "MinePage");
        f.put("MinePage?value=OrderPage", gr.f);
        f.put("MyAddressListPage", gr.N);
        f.put("SearchMainPage", gr.o);
        f.put("CustomersPage", gr.R);
        f.put("AddCustomerPage", gr.z);
        f.put("EditAccountPage", gr.J);
        f.put("AccountSafePage", gr.K);
        f.put("CouponOrderConfirm", gr.COUPON_ORDER_CONFIRM);
        f.put("CouponOrderDetail", gr.COUPON_ORDER_DETAIL);
        f.put("TicketSouvenirPage", gr.TICKET_SOUNENVIR);
        f.put("TicketESouvenirPage", gr.TICKET_E_SOUNENVIR);
        f.put("TicketVenuePage", gr.TICKET_VENUEPOINT);
        f.put("TicketNoticePage", gr.TICKET_NOTICE);
        f.put("ScriptSelect", gr.SCRIPT_SELECT);
        f.put("SettingsPage", gr.V);
        f.put("BroadcastListPage", "grab");
        f.put("DmCommonChannel", gr.NEW_SHOW_CALENDAR);
    }

    public static pp2 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328044061")) {
            return (pp2) ipChange.ipc$dispatch("328044061", new Object[0]);
        }
        if (c == null) {
            synchronized (pp2.class) {
                if (c == null) {
                    c = new pp2();
                }
            }
        }
        return c;
    }

    public static Bundle c(String str) {
        Set<String> queryParameterNames;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "243851001")) {
            return (Bundle) ipChange.ipc$dispatch("243851001", new Object[]{str});
        }
        String str2 = SCHEME + str;
        Bundle bundle = new Bundle();
        if (!xf2.j(str2)) {
            try {
                Uri parse = Uri.parse(str2);
                if (!(parse == null || (queryParameterNames = parse.getQueryParameterNames()) == null || queryParameterNames.iterator() == null)) {
                    for (String str3 : queryParameterNames) {
                        bundle.putString(str3, parse.getQueryParameter(str3));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return bundle;
    }

    private void d(Context context, String str, String str2, int i, Intent intent) {
        String str3;
        String str4;
        String str5;
        String str6;
        Exception e2;
        String str7;
        String str8;
        Exception e3;
        String str9;
        String str10;
        Exception e4;
        String queryParameter;
        String str11;
        String str12;
        String str13;
        String str14;
        Exception e5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572309649")) {
            ipChange.ipc$dispatch("-572309649", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
        } else if (str != null) {
            String str15 = "";
            if (str.contains("?")) {
                str3 = str.substring(0, str.indexOf("?"));
                str4 = str.substring(str.indexOf("?") + 1, str.length());
            } else {
                str3 = str;
                str4 = str15;
            }
            Uri parse = Uri.parse(str);
            if (str3 != null && !str3.equals(str15)) {
                if (str3.equals("CategoryPage")) {
                    if (str4 != 0 && !str4.equals(str15)) {
                        try {
                            str13 = parse.getQueryParameter("id");
                            try {
                                str14 = parse.getQueryParameter("option");
                            } catch (Exception e6) {
                                e5 = e6;
                                str14 = "0";
                                e5.printStackTrace();
                                str12 = str14;
                                str11 = "0";
                                e(context, str13, str2, str12, str11, i, intent);
                            }
                            try {
                                str11 = parse.getQueryParameter("type");
                                str12 = str14;
                            } catch (Exception e7) {
                                e5 = e7;
                                e5.printStackTrace();
                                str12 = str14;
                                str11 = "0";
                                e(context, str13, str2, str12, str11, i, intent);
                            }
                        } catch (Exception e8) {
                            e5 = e8;
                            str13 = "0";
                            str14 = str13;
                            e5.printStackTrace();
                            str12 = str14;
                            str11 = "0";
                            e(context, str13, str2, str12, str11, i, intent);
                        }
                        e(context, str13, str2, str12, str11, i, intent);
                    }
                } else if (str3.equals("MinePage")) {
                    if (str4 == 0 || str4.equals(str15)) {
                        w(context, new Intent(), i, gr.m(), intent);
                        return;
                    }
                    String queryParameter2 = parse.getQueryParameter("value");
                    if (queryParameter2 != null && !queryParameter2.equals(str15)) {
                        if (queryParameter2.equals("OrderPage")) {
                            p(context, i, intent);
                        } else if (queryParameter2.equals("FavouritePage")) {
                            k(context, i, intent);
                        } else if (queryParameter2.equals("SubscribePage")) {
                            n(context, i, intent);
                        } else if (queryParameter2.equals("FansPage")) {
                            g(context, i, intent, parse);
                        } else if (queryParameter2.equals("FollowPage")) {
                            h(context, i, intent, parse);
                        } else if (queryParameter2.equals("WantPraisePage")) {
                            u(context, i, intent, parse);
                        } else if (queryParameter2.equals("DynamicPage")) {
                            o(context, i, intent, queryParameter2);
                        } else if (queryParameter2.equals("WantedPage")) {
                            o(context, i, intent, queryParameter2);
                        } else if (queryParameter2.equals("PointsPage")) {
                            m(context, i, intent);
                        } else if (queryParameter2.equals("CouponPage")) {
                            l(context, i, intent);
                        } else if (queryParameter2.equals("AddressPage")) {
                            j(context, i, intent);
                        } else if (queryParameter2.equals("SecurityPage")) {
                            String b2 = bk2.b(context, R$string.damai_usercenter_security_center);
                            if (LoginManager.k().q()) {
                                Intent intent2 = new Intent();
                                if (!(intent == null || intent.getExtras() == null)) {
                                    intent2.putExtras(intent.getExtras());
                                }
                                intent2.putExtra("url", "https://msecurity.damai.cn/securityCenter-front-wap/index");
                                intent2.putExtra("status", true);
                                intent2.putExtra("title", b2);
                                x(context, intent2, i, gr.t);
                            }
                        } else {
                            w(context, new Intent(), i, gr.m(), intent);
                        }
                    }
                } else if (str3.equals("ProjectPage")) {
                    if (str4 != 0 && !str4.equals(str15) && (queryParameter = parse.getQueryParameter("id")) != null && !queryParameter.equals("0") && !queryParameter.equals(Constants.Name.UNDEFINED) && !queryParameter.equals("null")) {
                        try {
                            long parseLong = Long.parseLong(queryParameter);
                            Intent intent3 = new Intent();
                            Bundle bundle = new Bundle();
                            if (!(intent == null || intent.getExtras() == null)) {
                                bundle.putAll(intent.getExtras());
                            }
                            bundle.putLong(IssueConstants.ProjectID, parseLong);
                            intent3.putExtras(bundle);
                            v(context, intent3, i, gr.a());
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                } else if (str3.equals("WebPage")) {
                    if (str4 != 0 && !str4.equals(str15)) {
                        try {
                            str15 = Uri.parse(SCHEME + str).getQueryParameter("url");
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                        Intent intent4 = new Intent();
                        if (intent.getExtras() != null) {
                            intent4.putExtras(intent.getExtras());
                        }
                        intent4.putExtra("url", str15);
                        if (!TextUtils.isEmpty(str15)) {
                            intent4.putExtra("title", str15);
                        }
                        intent4.putExtra("qiandao", true);
                        intent4.putExtra(MonitorType.SKIP, false);
                        intent4.putExtra("fromQr", true);
                        int i2 = i == -1 ? 100 : i;
                        if (this.b) {
                            intent4.addFlags(268435456);
                        }
                        x(context, intent4, i2, gr.t);
                    }
                } else if (str3.equals("SearchPage")) {
                    if (str4 != 0 && !str4.equals(str15)) {
                        String queryParameter3 = parse.getQueryParameter("keyword");
                        Intent intent5 = new Intent();
                        intent5.putExtra("autowords", queryParameter3);
                        y(context, intent5, i, gr.o, intent);
                    }
                } else if (str3.equals("HomePage")) {
                    if (str4 == 0 || str4.equals(str15)) {
                        str9 = str15;
                    } else {
                        try {
                            str10 = parse.getQueryParameter("id");
                            try {
                                str15 = parse.getQueryParameter("type");
                            } catch (Exception e11) {
                                e4 = e11;
                                e4.printStackTrace();
                                str9 = str10;
                                i(context, str9, str15, i, intent);
                            }
                        } catch (Exception e12) {
                            e4 = e12;
                            str10 = str15;
                            e4.printStackTrace();
                            str9 = str10;
                            i(context, str9, str15, i, intent);
                        }
                        str9 = str10;
                    }
                    i(context, str9, str15, i, intent);
                } else if (str3.equals("SecondLevelHomePage")) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            str8 = parse.getQueryParameter("id");
                            try {
                                str15 = parse.getQueryParameter("type");
                            } catch (Exception e13) {
                                e3 = e13;
                                e3.printStackTrace();
                                str7 = str8;
                                f(context, str7, str15, i, intent);
                            }
                        } catch (Exception e14) {
                            e3 = e14;
                            str8 = str15;
                            e3.printStackTrace();
                            str7 = str8;
                            f(context, str7, str15, i, intent);
                        }
                        str7 = str8;
                    } else {
                        str7 = str15;
                    }
                    f(context, str7, str15, i, intent);
                } else if (str3.equals("LoginPage")) {
                    LoginManager.k().v(context);
                } else if (str3.equals("MovieListPage")) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("url", TPP_H5_URL);
                    y(context, intent6, i, gr.t, intent);
                } else if (str3.equals("ArtistOfficialContentListPage")) {
                    if (str4 == null || str4.equals(str15)) {
                        str5 = str15;
                    } else {
                        try {
                            str6 = parse.getQueryParameter("artistId");
                            try {
                                str15 = parse.getQueryParameter("type");
                            } catch (Exception e15) {
                                e2 = e15;
                                e2.printStackTrace();
                                str5 = str6;
                                t(context, str5, str15, i, intent);
                            }
                        } catch (Exception e16) {
                            e2 = e16;
                            str6 = str15;
                            e2.printStackTrace();
                            str5 = str6;
                            t(context, str5, str15, i, intent);
                        }
                        str5 = str6;
                    }
                    t(context, str5, str15, i, intent);
                } else if (str3.equals("EditAccountPage")) {
                    Bundle bundle2 = new Bundle();
                    if (!(intent == null || intent.getExtras() == null)) {
                        bundle2.putAll(intent.getExtras());
                    }
                    bundle2.putAll(c(str));
                    String str16 = f.get(str3);
                    if (!(UserInfoUtil.a() == null || UserInfoUtil.a().getUserBaseInfo() == null)) {
                        bundle2.putString("nickName", UserInfoUtil.a().getUserBaseInfo().getNickname());
                        bundle2.putString("userIntro", UserInfoUtil.a().getUserBaseInfo().getUserIntro());
                        bundle2.putString("birthday", UserInfoUtil.a().getUserBaseInfo().getBirthday());
                        bundle2.putInt("sex", UserInfoUtil.a().getUserBaseInfo().getSex());
                    }
                    if (context instanceof Activity) {
                        DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle2).toUri(NavUri.b(str16));
                    } else {
                        DMNav.from(context).stack(this.a).withExtras(bundle2).toUri(NavUri.b(str16));
                    }
                } else if (!xf2.j(f.get(str3))) {
                    Bundle bundle3 = new Bundle();
                    if (!(intent == null || intent.getExtras() == null)) {
                        bundle3.putAll(intent.getExtras());
                    }
                    bundle3.putAll(c(str));
                    String str17 = f.get(str3);
                    if (context instanceof Activity) {
                        DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle3).toUri(NavUri.b(str17));
                    } else {
                        DMNav.from(context).stack(this.a).withExtras(bundle3).toUri(NavUri.b(str17));
                    }
                } else {
                    new DMDialog(context).o(true).v(PurchaseConstants.NORMAL_WARNING_TITLE).q("请更新APP到最新版使用哦.").t(3).n("我知道了", new a(this)).show();
                    yz2.g("UIRouterManager" + ":jsondata={appVersion:" + AppConfig.q() + ",url:" + parse.toString() + "}", StaticsUtil.PLAY_CODE_103, "UIRouterManager地址转换异常");
                }
            }
        }
    }

    private void e(Context context, String str, String str2, String str3, String str4, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57754160")) {
            ipChange.ipc$dispatch("57754160", new Object[]{this, context, str, str2, str3, str4, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (!(intent == null || intent.getExtras() == null)) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("categoryId", str);
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra(ShowFragment.CATEGORYNAME_KEY, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent2.putExtra("option", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intent2.putExtra("type", str4);
        }
        x(context, intent2, i, gr.p);
    }

    private void f(Context context, String str, String str2, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583713694")) {
            ipChange.ipc$dispatch("583713694", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (!(intent == null || intent.getExtras() == null)) {
            intent2.putExtras(intent.getExtras());
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra("id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra("type", str2);
        }
        x(context, intent2, i, gr.m);
    }

    private void g(Context context, int i, Intent intent, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336928375")) {
            ipChange.ipc$dispatch("336928375", new Object[]{this, context, Integer.valueOf(i), intent, uri});
            return;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("self", true);
        if (!booleanQueryParameter || LoginManager.k().q()) {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            String queryParameter = uri.getQueryParameter("currentUserId");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = d20.i();
            }
            bundle.putString("userId", queryParameter);
            bundle.putString("relationType", "2");
            bundle.putString("targetType", "1");
            bundle.putString("targetId", queryParameter);
            bundle.putBoolean("self", booleanQueryParameter);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(gr.j());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.j());
            }
        } else {
            z(context);
        }
    }

    private void h(Context context, int i, Intent intent, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148933798")) {
            ipChange.ipc$dispatch("148933798", new Object[]{this, context, Integer.valueOf(i), intent, uri});
            return;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("self", true);
        if (!booleanQueryParameter || LoginManager.k().q()) {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            String queryParameter = uri.getQueryParameter("currentUserId");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = d20.i();
            }
            bundle.putString("userId", queryParameter);
            bundle.putString("relationType", "1");
            bundle.putBoolean("self", booleanQueryParameter);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(gr.j());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.j());
            }
        } else {
            z(context);
        }
    }

    private void i(Context context, String str, String str2, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1720460756")) {
            ipChange.ipc$dispatch("1720460756", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (!(intent == null || intent.getExtras() == null)) {
            intent2.putExtras(intent.getExtras());
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra("id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra("type", str2);
        }
        x(context, intent2, i, gr.n);
    }

    private void j(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686405241")) {
            ipChange.ipc$dispatch("1686405241", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(gr.g());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.g());
            }
        }
    }

    private void k(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838977632")) {
            ipChange.ipc$dispatch("1838977632", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            bundle.putString("userId", d20.i());
            bundle.putString("relationType", "1");
            bundle.putBoolean("self", true);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(gr.j());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.j());
            }
        }
    }

    private void l(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748018813")) {
            ipChange.ipc$dispatch("-1748018813", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            if ("1".equals(OrangeConfigCenter.c().b(ol1.b, "myCouponDowngrade", "0"))) {
                if (i != -1) {
                    DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(gr.d());
                } else {
                    DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.d());
                }
            } else if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri("damai://V1/Flutter?flutter_path=dm_coupon_list&bizType=0");
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri("damai://V1/Flutter?flutter_path=dm_coupon_list&bizType=0");
            }
        }
    }

    private void m(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640010329")) {
            ipChange.ipc$dispatch("1640010329", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(gr.h());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.h());
            }
        }
    }

    private void n(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809180812")) {
            ipChange.ipc$dispatch("-809180812", new Object[]{this, context, Integer.valueOf(i), intent});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            if (i != -1) {
                DMNav.from(context).stack(this.a).withExtras(bundle).forResult(i).toUri(gr.j());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.j());
            }
        }
    }

    private void o(Context context, int i, Intent intent, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624281747")) {
            ipChange.ipc$dispatch("-1624281747", new Object[]{this, context, Integer.valueOf(i), intent, str});
        } else if (!LoginManager.k().q()) {
            z(context);
        } else {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            bundle.putString("userId", d20.i());
            Bundle bundle2 = new Bundle();
            bundle2.putString("pageName", str);
            bundle.putBundle("pageKey", bundle2);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(gr.m());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.m());
            }
        }
    }

    private void p(Context context, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739133520")) {
            ipChange.ipc$dispatch("739133520", new Object[]{this, context, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (!(intent == null || intent.getExtras() == null)) {
            intent2.putExtras(intent.getExtras());
        }
        if (!LoginManager.k().q()) {
            z(context);
            return;
        }
        intent2.putExtra("from_where", "damai");
        x(context, intent2, i, gr.f);
    }

    private void t(Context context, String str, String str2, int i, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787703425")) {
            ipChange.ipc$dispatch("-1787703425", new Object[]{this, context, str, str2, Integer.valueOf(i), intent});
            return;
        }
        Intent intent2 = new Intent();
        if (!(intent == null || intent.getExtras() == null)) {
            intent2.putExtras(intent.getExtras());
        }
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra("artistId", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent2.putExtra("type", str2);
        }
        x(context, intent2, i, gr.PAGE_ARTIST_OFFICAL_CONTENT_LIST);
    }

    private void u(Context context, int i, Intent intent, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992467678")) {
            ipChange.ipc$dispatch("-1992467678", new Object[]{this, context, Integer.valueOf(i), intent, uri});
            return;
        }
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("self", true);
        if (!booleanQueryParameter || LoginManager.k().q()) {
            Bundle bundle = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle.putAll(intent.getExtras());
            }
            String queryParameter = uri.getQueryParameter("currentUserId");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = d20.i();
            }
            bundle.putString("userId", queryParameter);
            bundle.putString("targetIdStr", queryParameter);
            bundle.putBoolean("self", booleanQueryParameter);
            if (i != -1) {
                DMNav.from(context).stack(this.a).forResult(i).withExtras(bundle).toUri(gr.n());
            } else {
                DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.n());
            }
        } else {
            z(context);
        }
    }

    private void v(Context context, Intent intent, int i, NavUri navUri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259021269")) {
            ipChange.ipc$dispatch("-1259021269", new Object[]{this, context, intent, Integer.valueOf(i), navUri});
            return;
        }
        w(context, intent, i, navUri, null);
    }

    private void w(Context context, Intent intent, int i, NavUri navUri, Intent intent2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297358056")) {
            ipChange.ipc$dispatch("297358056", new Object[]{this, context, intent, Integer.valueOf(i), navUri, intent2});
            return;
        }
        DMNav from = DMNav.from(context);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (!(intent2 == null || intent2.getExtras() == null)) {
            extras.putAll(intent2.getExtras());
        }
        if (extras != null) {
            from = from.withExtras(extras);
        }
        if (i != -1 && (context instanceof Activity)) {
            from = from.forResult(i);
        }
        if (this.b) {
            from = from.withFlags(268435456);
        }
        Uri uri = this.a;
        if (uri != null) {
            from.stack(uri);
        }
        if (navUri != null) {
            from.toUri(navUri);
        }
    }

    private void x(Context context, Intent intent, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687755964")) {
            ipChange.ipc$dispatch("-1687755964", new Object[]{this, context, intent, Integer.valueOf(i), str});
            return;
        }
        w(context, intent, i, NavUri.b(str), null);
    }

    private void y(Context context, Intent intent, int i, String str, Intent intent2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097012481")) {
            ipChange.ipc$dispatch("2097012481", new Object[]{this, context, intent, Integer.valueOf(i), str, intent2});
            return;
        }
        w(context, intent, i, NavUri.b(str), intent2);
    }

    private void z(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145405405")) {
            ipChange.ipc$dispatch("-2145405405", new Object[]{this, context});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(d, e);
        DMNav.from(context).stack(this.a).withExtras(bundle).toUri(gr.f());
    }

    public void a(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018442982")) {
            ipChange.ipc$dispatch("1018442982", new Object[]{this, uri});
            return;
        }
        this.a = uri;
    }

    public void q(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065175733")) {
            ipChange.ipc$dispatch("-1065175733", new Object[]{this, activity, str});
            return;
        }
        r(activity, str, -1);
    }

    public void r(Context context, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676748512")) {
            ipChange.ipc$dispatch("1676748512", new Object[]{this, context, str, Integer.valueOf(i)});
            return;
        }
        s(context, str, i, false, null);
    }

    public void s(Context context, String str, int i, boolean z, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840534449")) {
            ipChange.ipc$dispatch("1840534449", new Object[]{this, context, str, Integer.valueOf(i), Boolean.valueOf(z), intent});
            return;
        }
        this.b = z;
        if (str == null || !str.startsWith(SCHEME)) {
            ToastUtil.i("invalidate path:" + str);
            return;
        }
        d(context, str.substring(11, str.length()), null, i, intent);
    }
}
