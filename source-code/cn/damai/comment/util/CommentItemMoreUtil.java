package cn.damai.comment.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.comment.R$anim;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import mtopsdk.common.util.SymbolExpUtil;
import tb.p21;
import tb.q92;
import tb.xf2;

/* compiled from: Taobao */
public class CommentItemMoreUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static OnCommentDeleteSuccessListener a;

    /* compiled from: Taobao */
    public interface OnCommentDeleteSuccessListener {
        void onFailure(String str, String str2);

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;
        final /* synthetic */ String b;
        final /* synthetic */ DamaiBaseActivity c;

        a(CommentsItemBean commentsItemBean, String str, DamaiBaseActivity damaiBaseActivity) {
            this.a = commentsItemBean;
            this.b = str;
            this.c = damaiBaseActivity;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-257649789")) {
                ipChange.ipc$dispatch("-257649789", new Object[]{this, view});
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_EDIT);
                bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, this.a.getCommentId());
                bundle.putString("projectName", this.b);
                if (xf2.e(this.a.getGradeDOList()) > 0 && this.a.getGradeDOList().get(0) != null) {
                    String str = this.a.getGradeDOList().get(0).value;
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putInt(p21.ISSUE_PARAM_GRADES, (int) Float.parseFloat(str));
                    }
                }
                if (xf2.e(this.a.getTextDOList()) > 0 && this.a.getTextDOList().get(0) != null) {
                    bundle.putString("text", this.a.getTextDOList().get(0).getValue());
                }
                bundle.putStringArrayList("images", CommentItemMoreUtil.d(this.a.getImageDOList()));
                if (xf2.e(this.a.getSyncCircle()) > 0 && this.a.getSyncCircle().get(0) != null) {
                    bundle.putString("circleId", this.a.getSyncCircle().get(0).getCircleId());
                    bundle.putString("circleName", this.a.getSyncCircle().get(0).getCircleName());
                }
                DMNav.from(this.c).withExtras(bundle).toUri(NavUri.b("issue"));
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                ShareManager.E().C();
                throw th;
            }
            ShareManager.E().C();
        }
    }

    private static View b(DamaiBaseActivity damaiBaseActivity, String str, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-957900931")) {
            return q92.e(damaiBaseActivity, new a(commentsItemBean, str, damaiBaseActivity));
        }
        return (View) ipChange.ipc$dispatch("-957900931", new Object[]{damaiBaseActivity, str, commentsItemBean});
    }

    private static ArrayList<String> c(List<CommentImageInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299354019")) {
            return (ArrayList) ipChange.ipc$dispatch("-299354019", new Object[]{list});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.isEmpty(list.get(i).url)) {
                    arrayList.add(list.get(i).url);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> d(List<CommentImageInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240159035")) {
            return (ArrayList) ipChange.ipc$dispatch("-1240159035", new Object[]{list});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < xf2.e(list); i++) {
            CommentImageInfoBean commentImageInfoBean = list.get(i);
            if (commentImageInfoBean != null) {
                arrayList.add(commentImageInfoBean.url);
            }
        }
        return arrayList;
    }

    private static Bundle e(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428681938")) {
            return (Bundle) ipChange.ipc$dispatch("428681938", new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), str6, str7, str8, str9, str10, str11});
        }
        Bundle bundle = new Bundle();
        bundle.putString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_EVALUATE);
        bundle.putString("targetId", str);
        bundle.putString("targetType", "0");
        bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, "32");
        bundle.putString("itemId", str2);
        bundle.putString("projectName", str3);
        bundle.putString(p21.ISSUE_PARAM_PROJECT_POSTER, str4);
        bundle.putString(p21.ISSUE_PARAM_PERFORM_BEGIN_TIMR, str5);
        bundle.putString(p21.ISSUE_FROM, str6);
        bundle.putInt(p21.ISSUE_PARAM_GRADES, i);
        bundle.putString("timeAddress", str7);
        bundle.putString("circleId", str8);
        bundle.putString("circleName", str9);
        bundle.putString("themeId", str10);
        bundle.putString(p21.ISSUE_PARAM_LIVE_THEME_NAME, str11);
        return bundle;
    }

    public static void f(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70669461")) {
            ipChange.ipc$dispatch("-70669461", new Object[]{context, str, str2, str3, str4, str5, Integer.valueOf(i), str6, str7, Integer.valueOf(i2)});
            return;
        }
        DMNav.from(context).withExtras(e(str, str2, str3, str4, str5, i, str7, str6, null, null, null, null)).setTransition(R$anim.anim_bottom_in, R$anim.anim_no).forResult(i2).toUri(NavUri.b("issue"));
    }

    public static void g(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788547735")) {
            ipChange.ipc$dispatch("-788547735", new Object[]{context, str, str2, str3, str4, str5, str6});
            return;
        }
        DMNav.from(context).withExtras(e(str, str2, str3, str4, str5, 0, "", str6, null, null, null, null)).toUri(NavUri.b("issue"));
    }

    public static void h(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020336495")) {
            ipChange.ipc$dispatch("-1020336495", new Object[]{context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10});
            return;
        }
        DMNav.from(context).withExtras(e(str, str2, str3, str4, str5, 0, "", str6, str7, str8, str9, str10)).toUri(NavUri.b("issue"));
    }

    public static void i(DamaiBaseActivity damaiBaseActivity, String str, long j, String str2, String str3, String str4, String str5, CommentsItemBean commentsItemBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101406361")) {
            ipChange.ipc$dispatch("-2101406361", new Object[]{damaiBaseActivity, str, Long.valueOf(j), str2, str3, str4, str5, commentsItemBean, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        j(damaiBaseActivity, str, j, str2, str3, str4, str5, commentsItemBean, z, i, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02a1  */
    public static void j(DamaiBaseActivity damaiBaseActivity, String str, long j, String str2, String str3, String str4, String str5, CommentsItemBean commentsItemBean, boolean z, int i, boolean z2) {
        String str6;
        String str7;
        boolean z3;
        String str8;
        String str9;
        String str10;
        String str11;
        int i2;
        String str12;
        String str13;
        Bundle bundle;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719041971")) {
            ipChange.ipc$dispatch("-719041971", new Object[]{damaiBaseActivity, str, Long.valueOf(j), str2, str3, str4, str5, commentsItemBean, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)});
        } else if (commentsItemBean != null) {
            String commentId = commentsItemBean.getCommentId();
            String commentType = commentsItemBean.getCommentType();
            String format = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(new Date(Long.parseLong(commentsItemBean.getGmtCreateTime())));
            String url = commentsItemBean.getUrl();
            if (commentsItemBean.getUserDO() != null) {
                str10 = commentsItemBean.getUserDO().getNickname();
                String headerImage = commentsItemBean.getUserDO().getHeaderImage();
                if (xf2.e(commentsItemBean.getImageDOList()) > 0 && !TextUtils.isEmpty(commentsItemBean.getImageDOList().get(0).url)) {
                    headerImage = commentsItemBean.getImageDOList().get(0).url;
                }
                str11 = commentsItemBean.getUserDO().getNickname();
                String headerImage2 = commentsItemBean.getUserDO().getHeaderImage();
                str9 = headerImage;
                str8 = headerImage2;
                z3 = commentsItemBean.getUserDO().isVip();
                str7 = commentsItemBean.getUserDO().getMemberFlag();
                str6 = commentsItemBean.getUserDO().getVipLevelIcon();
            } else {
                str11 = "";
                str10 = str11;
                str9 = str10;
                str8 = str9;
                str6 = str8;
                str7 = "0";
                z3 = false;
            }
            if (xf2.e(commentsItemBean.getGradeDOList()) > 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= commentsItemBean.getGradeDOList().size()) {
                        break;
                    }
                    CommentGradeBean commentGradeBean = commentsItemBean.getGradeDOList().get(i3);
                    if (commentGradeBean == null || commentGradeBean.type != 1) {
                        i3++;
                    } else {
                        str12 = commentGradeBean.valueDesc;
                        if (!TextUtils.isEmpty(commentGradeBean.value)) {
                            try {
                                i2 = (int) Float.parseFloat(commentGradeBean.value);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (commentsItemBean.getTextDOList() == null) {
                    if (commentsItemBean.getTextDOList().get(0) != null) {
                        str13 = commentsItemBean.getTextDOList().get(0).getValue();
                        if (TextUtils.isEmpty(url)) {
                            url = String.format("%1$s%2$s", "https://m.damai.cn/damai/activity/dynamic/index.html?mainCommentId=", commentId);
                        }
                        bundle = new Bundle();
                        bundle.putString("title", str10);
                        bundle.putString("imageurl", str9);
                        bundle.putString("message", str13);
                        bundle.putString("producturl", url);
                        bundle.putString("shareType", "chat_h5");
                        bundle.putBoolean("showGenerateImage", z2);
                        bundle.putLong("projectId", j);
                        bundle.putString("projectName", str3);
                        bundle.putString("projectImage", str2);
                        bundle.putString("userNick", str11);
                        bundle.putString("showDate", format);
                        bundle.putString("userHeaderIcon", str8);
                        bundle.putString("vipLevelIcon", str6);
                        bundle.putString("memberFlag", str7);
                        bundle.putBoolean("vip", z3);
                        bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, commentType);
                        bundle.putString("fromWhere", str);
                        if (damaiBaseActivity != null) {
                            bundle.putString("imageTitle", damaiBaseActivity.getString(R$string.ticklet_share_title));
                        } else {
                            bundle.putString("imageTitle", "分享评价");
                        }
                        if (commentsItemBean.getStoreInfo() != null && commentsItemBean.getItemType() == 1) {
                            bundle.putSerializable(DMShareMessage.KEY_EVALUATE_DMINFO, commentsItemBean.getDmInfo());
                            bundle.putSerializable(DMShareMessage.KEY_EVALUATE_STOREINFO, commentsItemBean.getStoreInfo());
                            bundle.putInt("itemType", commentsItemBean.getItemType());
                        }
                        bundle.putSerializable(DMShareMessage.KEY_ADS_BANNER, null);
                        ArrayList<DMShareMessage.ExtraMedia> l = l(commentsItemBean.getVideoDO(), c(commentsItemBean.getImageDOList()));
                        bundle.putSerializable(DMShareMessage.KEY_EXTRA_MEDIA, (l != null || l.size() <= 0) ? null : l.toArray(new DMShareMessage.ExtraMedia[l.size()]));
                        bundle.putString(DMShareMessage.KEY_PROJECT_CITY, str4);
                        bundle.putString(DMShareMessage.KEY_PROJECT_TIME, str5);
                        bundle.putString(DMShareMessage.KEY_SHARE_FOOTER, "");
                        bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE);
                        bundle.putInt("evaluateGrade", i2);
                        bundle.putString("evaluateGradeDesc", str12);
                        ShareManager.E().T(damaiBaseActivity, bundle, LayoutInflater.from(damaiBaseActivity).inflate(i, (ViewGroup) null));
                        if (!z) {
                            ShareManager.E().e0(ShareManager.E().F(damaiBaseActivity, 0, commentId, Integer.parseInt(commentType)));
                        } else if (!commentsItemBean.isProhibitEditing()) {
                            ShareManager.E().e0(b(damaiBaseActivity, str3, commentsItemBean));
                        }
                        ShareManager.E().l0();
                    }
                }
                str13 = "";
                if (TextUtils.isEmpty(url)) {
                }
                bundle = new Bundle();
                bundle.putString("title", str10);
                bundle.putString("imageurl", str9);
                bundle.putString("message", str13);
                bundle.putString("producturl", url);
                bundle.putString("shareType", "chat_h5");
                bundle.putBoolean("showGenerateImage", z2);
                bundle.putLong("projectId", j);
                bundle.putString("projectName", str3);
                bundle.putString("projectImage", str2);
                bundle.putString("userNick", str11);
                bundle.putString("showDate", format);
                bundle.putString("userHeaderIcon", str8);
                bundle.putString("vipLevelIcon", str6);
                bundle.putString("memberFlag", str7);
                bundle.putBoolean("vip", z3);
                bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, commentType);
                bundle.putString("fromWhere", str);
                if (damaiBaseActivity != null) {
                }
                bundle.putSerializable(DMShareMessage.KEY_EVALUATE_DMINFO, commentsItemBean.getDmInfo());
                bundle.putSerializable(DMShareMessage.KEY_EVALUATE_STOREINFO, commentsItemBean.getStoreInfo());
                bundle.putInt("itemType", commentsItemBean.getItemType());
                bundle.putSerializable(DMShareMessage.KEY_ADS_BANNER, null);
                ArrayList<DMShareMessage.ExtraMedia> l2 = l(commentsItemBean.getVideoDO(), c(commentsItemBean.getImageDOList()));
                bundle.putSerializable(DMShareMessage.KEY_EXTRA_MEDIA, (l2 != null || l2.size() <= 0) ? null : l2.toArray(new DMShareMessage.ExtraMedia[l2.size()]));
                bundle.putString(DMShareMessage.KEY_PROJECT_CITY, str4);
                bundle.putString(DMShareMessage.KEY_PROJECT_TIME, str5);
                bundle.putString(DMShareMessage.KEY_SHARE_FOOTER, "");
                bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE);
                bundle.putInt("evaluateGrade", i2);
                bundle.putString("evaluateGradeDesc", str12);
                ShareManager.E().T(damaiBaseActivity, bundle, LayoutInflater.from(damaiBaseActivity).inflate(i, (ViewGroup) null));
                if (!z) {
                }
                ShareManager.E().l0();
            }
            str12 = "";
            i2 = 0;
            if (commentsItemBean.getTextDOList() == null) {
            }
            str13 = "";
            if (TextUtils.isEmpty(url)) {
            }
            bundle = new Bundle();
            bundle.putString("title", str10);
            bundle.putString("imageurl", str9);
            bundle.putString("message", str13);
            bundle.putString("producturl", url);
            bundle.putString("shareType", "chat_h5");
            bundle.putBoolean("showGenerateImage", z2);
            bundle.putLong("projectId", j);
            bundle.putString("projectName", str3);
            bundle.putString("projectImage", str2);
            bundle.putString("userNick", str11);
            bundle.putString("showDate", format);
            bundle.putString("userHeaderIcon", str8);
            bundle.putString("vipLevelIcon", str6);
            bundle.putString("memberFlag", str7);
            bundle.putBoolean("vip", z3);
            bundle.putString(p21.ISSUE_PARAM_COMMENT_TYPE, commentType);
            bundle.putString("fromWhere", str);
            if (damaiBaseActivity != null) {
            }
            bundle.putSerializable(DMShareMessage.KEY_EVALUATE_DMINFO, commentsItemBean.getDmInfo());
            bundle.putSerializable(DMShareMessage.KEY_EVALUATE_STOREINFO, commentsItemBean.getStoreInfo());
            bundle.putInt("itemType", commentsItemBean.getItemType());
            bundle.putSerializable(DMShareMessage.KEY_ADS_BANNER, null);
            ArrayList<DMShareMessage.ExtraMedia> l22 = l(commentsItemBean.getVideoDO(), c(commentsItemBean.getImageDOList()));
            bundle.putSerializable(DMShareMessage.KEY_EXTRA_MEDIA, (l22 != null || l22.size() <= 0) ? null : l22.toArray(new DMShareMessage.ExtraMedia[l22.size()]));
            bundle.putString(DMShareMessage.KEY_PROJECT_CITY, str4);
            bundle.putString(DMShareMessage.KEY_PROJECT_TIME, str5);
            bundle.putString(DMShareMessage.KEY_SHARE_FOOTER, "");
            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE);
            bundle.putInt("evaluateGrade", i2);
            bundle.putString("evaluateGradeDesc", str12);
            ShareManager.E().T(damaiBaseActivity, bundle, LayoutInflater.from(damaiBaseActivity).inflate(i, (ViewGroup) null));
            if (!z) {
            }
            ShareManager.E().l0();
        }
    }

    public static void k(OnCommentDeleteSuccessListener onCommentDeleteSuccessListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688398878")) {
            ipChange.ipc$dispatch("1688398878", new Object[]{onCommentDeleteSuccessListener});
            return;
        }
        a = onCommentDeleteSuccessListener;
    }

    public static ArrayList<DMShareMessage.ExtraMedia> l(CommentsVideoBean commentsVideoBean, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744104030")) {
            return (ArrayList) ipChange.ipc$dispatch("-744104030", new Object[]{commentsVideoBean, arrayList});
        }
        ArrayList<DMShareMessage.ExtraMedia> arrayList2 = new ArrayList<>();
        if (commentsVideoBean != null && !TextUtils.isEmpty(commentsVideoBean.getCoverUrl()) && !commentsVideoBean.isVideoStatusUnReview()) {
            DMShareMessage.ExtraMedia extraMedia = new DMShareMessage.ExtraMedia();
            extraMedia.coverUrl = commentsVideoBean.getCoverUrl();
            extraMedia.isVideo = true;
            arrayList2.add(extraMedia);
        }
        if (xf2.e(arrayList) > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                DMShareMessage.ExtraMedia extraMedia2 = new DMShareMessage.ExtraMedia();
                extraMedia2.coverUrl = arrayList.get(i);
                extraMedia2.isVideo = false;
                arrayList2.add(extraMedia2);
            }
        }
        return arrayList2;
    }

    public static String m(String str, String str2) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-983419347")) {
            return (String) ipChange.ipc$dispatch("-983419347", new Object[]{str, str2});
        }
        String str4 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(" | ")) {
                String[] split = str.split(" \\| ");
                if (split.length > 1) {
                    str4 = split[0] + " | ";
                    str3 = " | " + split[1];
                    return str4 + str2 + str3;
                }
            } else {
                if (str.contains("|")) {
                    String[] split2 = str.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                    if (split2.length > 1) {
                        str4 = split2[0] + " | ";
                        str3 = " | " + split2[1];
                    }
                } else {
                    str3 = " | " + str;
                }
                return str4 + str2 + str3;
            }
        }
        str3 = str4;
        return str4 + str2 + str3;
    }

    public static String n(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-851824541")) {
            return (String) ipChange.ipc$dispatch("-851824541", new Object[]{str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sb.append(str);
            sb.append(" | ");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            sb.append(" | ");
            sb.append(str3);
        }
        return sb.toString();
    }

    public static String o(Long l, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726140759")) {
            return (String) ipChange.ipc$dispatch("1726140759", new Object[]{l, str});
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(new Date(l.longValue()));
    }
}
