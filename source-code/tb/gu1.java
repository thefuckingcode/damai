package tb;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gu1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String productUrl = "https://m.damai.cn/damai/detail/item.html?itemId=";

    /* compiled from: Taobao */
    public class a implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ DMShareMessage b;

        a(Activity activity, DMShareMessage dMShareMessage) {
            this.a = activity;
            this.b = dMShareMessage;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1905321051")) {
                ipChange.ipc$dispatch("1905321051", new Object[]{this});
                return;
            }
            GenerateImageUtil.p(this.a, this.b);
        }
    }

    public static void a(Activity activity, ProjectStaticDataBean projectStaticDataBean, long j) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-433064202")) {
            ipChange.ipc$dispatch("-433064202", new Object[]{activity, projectStaticDataBean, Long.valueOf(j)});
        } else if (activity != null) {
            try {
                String b = b(projectStaticDataBean);
                if (projectStaticDataBean != null) {
                    ProjectStaticItemBaseBean itemBase = projectStaticDataBean.getItemBase();
                    VenueBean venue = projectStaticDataBean.getVenue();
                    if (itemBase != null) {
                        str3 = itemBase.getItemName();
                        str4 = itemBase.getShowTime();
                    } else {
                        str4 = "";
                        str3 = str4;
                    }
                    if (venue != null) {
                        str2 = venue.getVenueName();
                        str = venue.getVenueCityName();
                    } else {
                        str = "";
                        str2 = str;
                    }
                } else {
                    str = "";
                    str4 = str;
                    str3 = str4;
                    str2 = str3;
                }
                DMShareMessage dMShareMessage = new DMShareMessage();
                dMShareMessage.shareImageStyle = "projectImage";
                dMShareMessage.sharePictureUrl = b;
                dMShareMessage.shareTitle = str3;
                dMShareMessage.shareContent = String.format("%1$s·%2$s | %3$s", str, str2, str4);
                dMShareMessage.shareLink = productUrl + j + "&from=appshare";
                dMShareMessage.fromWhere = GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL;
                dMShareMessage.userNick = "";
                dMShareMessage.userHeaderIcon = "";
                dMShareMessage.evaluateGrade = 0;
                dMShareMessage.evaluateTime = str4;
                dMShareMessage.projectId = String.valueOf(j);
                dMShareMessage.commentType = "";
                hp1.b(activity, false, lp1.STORAGE, "才能分享图片～", new a(activity, dMShareMessage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String b(ProjectStaticDataBean projectStaticDataBean) {
        PicInfo picInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109188747")) {
            return (String) ipChange.ipc$dispatch("-109188747", new Object[]{projectStaticDataBean});
        }
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null || projectStaticDataBean.getItemBase().getItemPics() == null || projectStaticDataBean.getItemBase().getItemPics().getItemPicList() == null || projectStaticDataBean.getItemBase().getItemPics().getItemPicList().isEmpty() || (picInfo = projectStaticDataBean.getItemBase().getItemPics().getItemPicList().get(0)) == null) {
            return "";
        }
        return picInfo.getPicUrl();
    }

    public static void c(Activity activity, String str, ProjectStaticDataBean projectStaticDataBean) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819333538")) {
            ipChange.ipc$dispatch("1819333538", new Object[]{activity, str, projectStaticDataBean});
        } else if (activity != null && projectStaticDataBean != null && !TextUtils.isEmpty(str)) {
            String b = b(projectStaticDataBean);
            ProjectStaticItemBaseBean itemBase = projectStaticDataBean.getItemBase();
            VenueBean venue = projectStaticDataBean.getVenue();
            String str3 = null;
            String venueCityName = venue != null ? venue.getVenueCityName() : null;
            if (itemBase != null) {
                str2 = itemBase.getItemName();
                str3 = itemBase.getShowTime();
            } else {
                str2 = null;
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(venueCityName)) {
                sb.append(venueCityName);
                sb.append(" | ");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str3);
            }
            d(activity, productUrl + str + "&from=appshare", str, sb.toString(), str2, b, GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL);
        }
    }

    private static void d(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825921742")) {
            ipChange.ipc$dispatch("825921742", new Object[]{activity, str, str2, str3, str4, str5, str6});
        } else if (!TextUtils.isEmpty(str4)) {
            c.e().x(ln2.r().X0(str2));
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl", str5);
            bundle.putString("uniqueIdent", str2);
            bundle.putString("projectName", str4);
            bundle.putString("mainMessage", str4);
            bundle.putString("channel", "1");
            bundle.putString("subMessage", str3);
            bundle.putString("producturl", str);
            bundle.putString("fromWhere", str6);
            bundle.putString("sceneType", "1");
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("fissionshare"));
        }
    }

    public static void e(int i, Activity activity, ProjectStaticDataBean projectStaticDataBean, long j, String str) {
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133143277")) {
            ipChange.ipc$dispatch("-1133143277", new Object[]{Integer.valueOf(i), activity, projectStaticDataBean, Long.valueOf(j), str});
        } else if (activity != null && projectStaticDataBean != null) {
            String b = b(projectStaticDataBean);
            ProjectStaticItemBaseBean itemBase = projectStaticDataBean.getItemBase();
            VenueBean venue = projectStaticDataBean.getVenue();
            String str4 = "";
            if (itemBase != null) {
                String itemName = itemBase.getItemName();
                str3 = itemBase.getShowTime();
                str2 = itemName;
            } else {
                str3 = str4;
                str2 = str3;
            }
            if (venue != null) {
                str4 = venue.getVenueName();
            }
            ShareUtil shareUtil = new ShareUtil(activity, GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL);
            shareUtil.initShareData(str2, Html.fromHtml(str4 + "<br/>" + str3).toString(), b, productUrl + j + "&from=appshare", str, "", j);
            shareUtil.shareByWchart(i);
        }
    }
}
