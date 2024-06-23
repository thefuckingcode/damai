package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.user.repertoite.view.AttentionView;
import cn.damai.user.userprofile.UserIndexActivity;
import cn.damai.user.userprofile.UserIndexViewModel;
import cn.damai.user.userprofile.bean.UserData;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Random;

/* compiled from: Taobao */
public class vu0 extends ya {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ Activity b;
        final /* synthetic */ String c;

        a(View view, Activity activity, String str) {
            this.a = view;
            this.b = activity;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-902419546")) {
                ipChange.ipc$dispatch("-902419546", new Object[]{this, eVar});
            } else if (eVar != null && eVar.b != null) {
                ((ImageView) this.a.findViewById(R$id.user_iv_header)).setImageDrawable(new ci(eVar.b));
                Activity activity = this.b;
                if (activity instanceof UserIndexActivity) {
                    ((UserIndexViewModel) ViewModelProviders.of((UserIndexActivity) activity).get(UserIndexViewModel.class)).sinapath = vu0.f(this.c, eVar.b, this.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;

        b(Activity activity, String str) {
            this.a = activity;
            this.b = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1510496409")) {
                ipChange.ipc$dispatch("-1510496409", new Object[]{this, eVar});
            } else if (eVar != null && eVar.b != null) {
                Activity activity = this.a;
                if (activity instanceof UserIndexActivity) {
                    ((UserIndexViewModel) ViewModelProviders.of((UserIndexActivity) activity).get(UserIndexViewModel.class)).sinapath = vu0.f(this.b, eVar.b, this.a);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ UserData b;
        final /* synthetic */ View c;

        c(Activity activity, UserData userData, View view) {
            this.a = activity;
            this.b = userData;
            this.c = view;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2118573272")) {
                ipChange.ipc$dispatch("-2118573272", new Object[]{this, eVar});
                return;
            }
            Activity activity = this.a;
            if (activity != null) {
                Drawable[] drawableArr = new Drawable[2];
                drawableArr[1] = activity.getResources().getDrawable(R$drawable.account_header_gradient_bg);
                if (this.b.type == 1 && eVar != null && (drawable = eVar.a) != null) {
                    drawableArr[0] = drawable;
                    this.c.setBackground(new LayerDrawable(drawableArr));
                }
            }
        }
    }

    public static SpannableString d(long j, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097946863")) {
            return (SpannableString) ipChange.ipc$dispatch("-2097946863", new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)});
        }
        float f = 0.6f;
        if (z) {
            f = 1.0f;
        }
        if (j < 10000) {
            try {
                String e = e(j, str);
                SpannableString spannableString = new SpannableString(e);
                spannableString.setSpan(new RelativeSizeSpan(f), e.length() - str.length(), e.length(), 33);
                return spannableString;
            } catch (Exception e2) {
                e2.printStackTrace();
                return new SpannableString("");
            }
        } else {
            String e3 = e(j, str);
            SpannableString spannableString2 = new SpannableString(e3);
            spannableString2.setSpan(new RelativeSizeSpan(f), (e3.length() - str.length()) - 1, e3.length(), 33);
            return spannableString2;
        }
    }

    public static String e(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872559548")) {
            return (String) ipChange.ipc$dispatch("-872559548", new Object[]{Long.valueOf(j), str});
        } else if (j < 10000) {
            try {
                return j + str;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return (((float) (j / 1000)) / 10.0f) + "万" + str;
        }
    }

    public static String f(String str, Bitmap bitmap, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961217791")) {
            return (String) ipChange.ipc$dispatch("961217791", new Object[]{str, bitmap, context});
        }
        try {
            if (hp1.i(lp1.STORAGE)) {
                return tz0.d(str, bitmap, context);
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void g(UserData userData, AttentionView attentionView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046515965")) {
            ipChange.ipc$dispatch("-1046515965", new Object[]{userData, attentionView});
        } else if (attentionView != null) {
            if (userData.bid != 0) {
                attentionView.setInitParams(userData.bid + "", userData.type + "");
            } else if (!TextUtils.isEmpty(userData.havanaIdStr)) {
                attentionView.setInitParams(userData.havanaIdStr + "", userData.type + "");
            } else {
                attentionView.setInitParams(userData.userId + "", userData.type + "");
            }
            attentionView.setVisibility(0);
            attentionView.setState(userData.favoriteFlag);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0410 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0319  */
    public static void h(Activity activity, UserData userData, View view, int i) {
        String str;
        int i2;
        int i3;
        int i4;
        String str2;
        String str3;
        int i5;
        int i6;
        int i7;
        String str4;
        View findViewById;
        int i8;
        int i9;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1945465414")) {
            ipChange.ipc$dispatch("-1945465414", new Object[]{activity, userData, view, Integer.valueOf(i)});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_nick_name_status);
        TextView textView2 = (TextView) view.findViewById(R$id.user_tv_name);
        String str5 = userData.nickname;
        if (!(userData.type == 1 || textView2 == null)) {
            TextPaint paint = textView2.getPaint();
            while (paint != null && paint.measureText(str5) > ((float) v50.a(activity, 190.0f)) && paint.getTextSize() > ((float) v50.a(activity, 10.0f))) {
                paint.setTextSize(paint.getTextSize() - 2.0f);
            }
        }
        if (!userData.vaccount || userData.type != 3) {
            ((TextView) view.findViewById(R$id.user_tv_name)).setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = activity.getResources().getDrawable(R$drawable.user_v_tag);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((TextView) view.findViewById(R$id.user_tv_name)).setCompoundDrawables(null, null, drawable, null);
        }
        ya.c(view, R$id.user_tv_name, str5);
        if (textView != null) {
            String str6 = userData.nicknameStatus;
            if (str6 == null || TextUtils.isEmpty(str6)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(userData.nicknameStatus);
            }
        }
        String str7 = userData.summary;
        if (userData.lat <= 0.0d || userData.lng <= 0.0d || xf2.j(str7)) {
            str = "";
        } else {
            try {
                str = " " + activity.getResources().getString(R$string.iconfont_dingweichangguan_);
                try {
                    TextView textView3 = (TextView) view.findViewById(R$id.user_tv_desc);
                    if (textView3.getPaint().measureText(str7 + str) >= ((float) (textView3.getWidth() * 2))) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str7.substring(0, str7.length() - ("..." + str + "占位符").length()));
                        sb.append("...");
                        str7 = sb.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    int i10 = R$id.user_tv_desc;
                    ya.c(view, i10, str7 + str);
                    int i11 = R$id.ll_left;
                    View findViewById2 = view.findViewById(i11);
                    i2 = R$id.tv_fans_count;
                    ya.b(findViewById2, i2, d(userData.fansNum, "", userData.mySelf && userData.vaccount));
                    View findViewById3 = view.findViewById(i11);
                    i3 = R$id.tv_fans_title;
                    ya.c(findViewById3, i3, "粉丝");
                    if (userData.mySelf) {
                    }
                    int i12 = R$id.ll_mid;
                    ya.b(view.findViewById(i12), i2, d((long) userData.projectCount, "场", userData.mySelf && userData.vaccount));
                    ya.c(view.findViewById(i12), i3, "在售演出");
                    if (!userData.mySelf) {
                    }
                    ya.c(view, R$id.user_tv_followcout, userData.focusNum + "");
                    ya.c(view, R$id.user_tv_fanscout, userData.fansNum + "");
                    ya.c(view, R$id.user_tv_add, userData.city);
                    i4 = R$id.user_tv_sex;
                    if (view.findViewById(i4) != null) {
                    }
                    str2 = userData.headImg;
                    if (str2 != null) {
                    }
                    str3 = str2 + "?ran=" + new Random().nextInt();
                    i5 = R$drawable.color_60black;
                    i6 = R$id.user_iv_header;
                    if (view.findViewById(i6) != null) {
                    }
                    DMAvatar dMAvatar = (DMAvatar) view.findViewById(i6);
                    dMAvatar.setVisibility(0);
                    dMAvatar.setAvatar(str3);
                    dMAvatar.setAvatarVTagVisibility(userData.userTypeCode == 2 ? 0 : 8);
                    dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_100x100);
                    dMAvatar.setAvatarPlaceholder(R$drawable.transparent_bg);
                    dMAvatar.setAvatarCrownVisibility(userData.vip ? 0 : 8);
                    dMAvatar.setAvatarBorderVisibility(userData.vip ? 0 : 8);
                    cn.damai.common.image.a.b().c(str3).i(i5).n(new b(activity, str3)).f();
                    int i13 = R$id.user_img_viplevel;
                    if (!xf2.j(userData.vipLevelIcon)) {
                    }
                    if (!xf2.j(userData.userTypeIcon)) {
                    }
                    i7 = R$id.tv_header_v;
                    if (view.findViewById(i7) != null) {
                    }
                    str4 = userData.headBgImg;
                    findViewById = activity.findViewById(R$id.toolbar);
                    cn.damai.common.image.a.b().c(str4).n(new c(activity, userData, findViewById)).f();
                    if (!userData.mySelf) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str = "";
                e.printStackTrace();
                int i102 = R$id.user_tv_desc;
                ya.c(view, i102, str7 + str);
                int i112 = R$id.ll_left;
                View findViewById22 = view.findViewById(i112);
                i2 = R$id.tv_fans_count;
                ya.b(findViewById22, i2, d(userData.fansNum, "", userData.mySelf && userData.vaccount));
                View findViewById32 = view.findViewById(i112);
                i3 = R$id.tv_fans_title;
                ya.c(findViewById32, i3, "粉丝");
                if (userData.mySelf) {
                }
                int i122 = R$id.ll_mid;
                ya.b(view.findViewById(i122), i2, d((long) userData.projectCount, "场", userData.mySelf && userData.vaccount));
                ya.c(view.findViewById(i122), i3, "在售演出");
                if (!userData.mySelf) {
                }
                ya.c(view, R$id.user_tv_followcout, userData.focusNum + "");
                ya.c(view, R$id.user_tv_fanscout, userData.fansNum + "");
                ya.c(view, R$id.user_tv_add, userData.city);
                i4 = R$id.user_tv_sex;
                if (view.findViewById(i4) != null) {
                }
                str2 = userData.headImg;
                if (str2 != null) {
                }
                str3 = str2 + "?ran=" + new Random().nextInt();
                i5 = R$drawable.color_60black;
                i6 = R$id.user_iv_header;
                if (view.findViewById(i6) != null) {
                }
                cn.damai.uikit.view.DMAvatar dMAvatar2 = (cn.damai.uikit.view.DMAvatar) view.findViewById(i6);
                dMAvatar2.setVisibility(0);
                dMAvatar2.setAvatar(str3);
                dMAvatar2.setAvatarVTagVisibility(userData.userTypeCode == 2 ? 0 : 8);
                dMAvatar2.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_100x100);
                dMAvatar2.setAvatarPlaceholder(R$drawable.transparent_bg);
                dMAvatar2.setAvatarCrownVisibility(userData.vip ? 0 : 8);
                dMAvatar2.setAvatarBorderVisibility(userData.vip ? 0 : 8);
                cn.damai.common.image.a.b().c(str3).i(i5).n(new b(activity, str3)).f();
                int i132 = R$id.user_img_viplevel;
                if (!xf2.j(userData.vipLevelIcon)) {
                }
                if (!xf2.j(userData.userTypeIcon)) {
                }
                i7 = R$id.tv_header_v;
                if (view.findViewById(i7) != null) {
                }
                str4 = userData.headBgImg;
                findViewById = activity.findViewById(R$id.toolbar);
                cn.damai.common.image.a.b().c(str4).n(new c(activity, userData, findViewById)).f();
                if (!userData.mySelf) {
                }
            }
        }
        int i1022 = R$id.user_tv_desc;
        ya.c(view, i1022, str7 + str);
        int i1122 = R$id.ll_left;
        View findViewById222 = view.findViewById(i1122);
        i2 = R$id.tv_fans_count;
        ya.b(findViewById222, i2, d(userData.fansNum, "", userData.mySelf && userData.vaccount));
        View findViewById322 = view.findViewById(i1122);
        i3 = R$id.tv_fans_title;
        ya.c(findViewById322, i3, "粉丝");
        if (userData.mySelf || !userData.vaccount) {
            int i1222 = R$id.ll_mid;
            ya.b(view.findViewById(i1222), i2, d((long) userData.projectCount, "场", userData.mySelf && userData.vaccount));
            ya.c(view.findViewById(i1222), i3, "在售演出");
        } else {
            int i14 = R$id.ll_mid;
            ya.b(view.findViewById(i14), i2, d(userData.focusNum, "", !userData.mySelf && userData.vaccount));
            ya.c(view.findViewById(i14), i3, "关注");
        }
        if (!userData.mySelf) {
            int color = activity.getResources().getColor(R$color.color_ffffff);
            ya.a(view.findViewById(i1122), i2, color);
            ya.a(view.findViewById(i1122), i3, color);
            int i15 = R$id.ll_mid;
            ya.a(view.findViewById(i15), i2, color);
            ya.a(view.findViewById(i15), i3, color);
        }
        ya.c(view, R$id.user_tv_followcout, userData.focusNum + "");
        ya.c(view, R$id.user_tv_fanscout, userData.fansNum + "");
        ya.c(view, R$id.user_tv_add, userData.city);
        i4 = R$id.user_tv_sex;
        if (view.findViewById(i4) != null) {
            if (userData.sex == 1) {
                i9 = R$string.iconfont_nan16;
                i8 = activity.getResources().getColor(R$color.color_icon_boy);
            } else {
                i9 = R$string.iconfont_nv16;
                i8 = activity.getResources().getColor(R$color.color_FF1268);
            }
            TextView textView4 = (TextView) view.findViewById(i4);
            textView4.setText(activity.getString(i9));
            textView4.setTextColor(i8);
        }
        str2 = userData.headImg;
        if (str2 != null || !str2.contains("?")) {
            str3 = str2 + "?ran=" + new Random().nextInt();
        } else {
            str3 = str2 + "&ran=" + new Random().nextInt();
        }
        i5 = R$drawable.color_60black;
        i6 = R$id.user_iv_header;
        if (view.findViewById(i6) != null || (view.findViewById(i6) instanceof cn.damai.uikit.view.DMAvatar)) {
            cn.damai.uikit.view.DMAvatar dMAvatar22 = (cn.damai.uikit.view.DMAvatar) view.findViewById(i6);
            dMAvatar22.setVisibility(0);
            dMAvatar22.setAvatar(str3);
            dMAvatar22.setAvatarVTagVisibility(userData.userTypeCode == 2 ? 0 : 8);
            dMAvatar22.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_100x100);
            dMAvatar22.setAvatarPlaceholder(R$drawable.transparent_bg);
            dMAvatar22.setAvatarCrownVisibility(userData.vip ? 0 : 8);
            dMAvatar22.setAvatarBorderVisibility(userData.vip ? 0 : 8);
            cn.damai.common.image.a.b().c(str3).i(i5).n(new b(activity, str3)).f();
            int i1322 = R$id.user_img_viplevel;
            if (view.findViewById(i1322) != null && userData.mySelf) {
                if (!xf2.j(userData.vipLevelIcon)) {
                    view.findViewById(i1322).setVisibility(0);
                    cn.damai.common.image.a.b().c(userData.vipLevelIcon).i(i5).g((ImageView) view.findViewById(i1322));
                } else {
                    view.findViewById(i1322).setVisibility(4);
                }
            }
            if (!xf2.j(userData.userTypeIcon)) {
                view.findViewById(i1322).setVisibility(0);
                cn.damai.common.image.a.b().c(userData.userTypeIcon).i(i5).g((ImageView) view.findViewById(i1322));
            } else {
                view.findViewById(i1322).setVisibility(4);
            }
        } else if (userData.type != 3) {
            view.findViewById(i6).setVisibility(0);
            cn.damai.common.image.a.b().c(str3).i(i5).n(new a(view, activity, str3)).f();
        } else {
            view.findViewById(i6).setVisibility(8);
        }
        i7 = R$id.tv_header_v;
        if (view.findViewById(i7) != null) {
            if (!userData.vaccount) {
                view.findViewById(i7).setVisibility(8);
            } else if (userData.type == 3) {
                view.findViewById(i7).setVisibility(8);
            } else {
                view.findViewById(i7).setVisibility(0);
            }
        }
        str4 = userData.headBgImg;
        findViewById = activity.findViewById(R$id.toolbar);
        if (!xf2.j(str4) && findViewById != null) {
            cn.damai.common.image.a.b().c(str4).n(new c(activity, userData, findViewById)).f();
        }
        if (!userData.mySelf) {
            AttentionView attentionView = (AttentionView) view.findViewById(R$id.attent_view_c);
            g(userData, attentionView);
            if (attentionView != null) {
                attentionView.addAttentionView((AttentionView) activity.findViewById(R$id.tv_attention));
            }
            ya.c(view, i1022, userData.getTags());
        }
    }
}
