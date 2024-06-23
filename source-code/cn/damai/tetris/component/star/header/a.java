package cn.damai.tetris.component.star.header;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.musicfestival.bean.ShareInfo;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.tetris.component.star.header.StarHeaderContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Random;
import tb.di;
import tb.i42;
import tb.ne2;
import tb.v50;
import tb.xd2;
import tb.xf2;
import tb.yd2;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;

    /* renamed from: cn.damai.tetris.component.star.header.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0050a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        /* renamed from: cn.damai.tetris.component.star.header.a$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0051a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0051a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1196099338")) {
                    ipChange.ipc$dispatch("1196099338", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                ((ImageView) C0050a.this.a.findViewById(R$id.user_star_b_headerbg_cover)).setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i, i, a.e(0.6f, i), a.e(0.4f, i)}));
            }
        }

        C0050a(ViewGroup viewGroup, int i, String str) {
            this.a = viewGroup;
            this.b = i;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1349474187")) {
                ipChange.ipc$dispatch("1349474187", new Object[]{this, eVar});
            } else if (eVar != null && eVar.b != null) {
                ((ImageView) this.a.findViewById(R$id.user_iv_header)).setImageDrawable(new di(eVar.b));
                if (this.b != 2) {
                    ViewGroup viewGroup = this.a;
                    int i = R$id.star_header_img_artist;
                    viewGroup.findViewById(i).setVisibility(0);
                    ((ImageView) this.a.findViewById(i)).setImageBitmap(eVar.b);
                    DMRGBUtil.g(1.0f, eVar.b, this.c, new C0051a());
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "741397324")) {
                ipChange.ipc$dispatch("741397324", new Object[]{this, eVar});
                return;
            }
            this.a.setBackgroundDrawable(eVar.a);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ViewGroup a;

        c(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "133320461")) {
                ipChange.ipc$dispatch("133320461", new Object[]{this, eVar});
            } else if (eVar != null && eVar.b != null) {
                ((ImageView) this.a.findViewById(R$id.star_header_img)).setImageBitmap(eVar.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ StarHeaderData a;
        final /* synthetic */ Activity b;
        final /* synthetic */ ViewGroup c;
        final /* synthetic */ BasePresenter d;

        d(StarHeaderData starHeaderData, Activity activity, ViewGroup viewGroup, BasePresenter basePresenter) {
            this.a = starHeaderData;
            this.b = activity;
            this.c = viewGroup;
            this.d = basePresenter;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "94328648")) {
                ipChange.ipc$dispatch("94328648", new Object[]{this, view});
                return;
            }
            a.k(this.a, this.b, this.c, this.d);
        }
    }

    public static void c(ViewGroup viewGroup, StarHeaderData starHeaderData, Activity activity, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100764184")) {
            ipChange.ipc$dispatch("-1100764184", new Object[]{viewGroup, starHeaderData, activity, trackInfo});
            return;
        }
        AttentionView attentionView = (AttentionView) viewGroup.findViewById(R$id.attent_view_star);
        attentionView.setPage(trackInfo.trackB);
        attentionView.setPageBdian(trackInfo.trackB);
        m(attentionView, trackInfo.trackB, "top", starHeaderData);
        l(starHeaderData, attentionView);
        if (activity != null) {
            int identifier = activity.getResources().getIdentifier("star_navbar_attention", "id", "cn.damai");
            if (activity.findViewById(identifier) != null) {
                AttentionView attentionView2 = (AttentionView) activity.findViewById(identifier);
                attentionView2.setPage(trackInfo.trackB);
                l(starHeaderData, attentionView2);
                m(attentionView2, trackInfo.trackB, "top_navbar", starHeaderData);
                attentionView.addAttentionView(attentionView2);
            }
            int identifier2 = activity.getResources().getIdentifier("attent_view_star_pop", "id", "cn.damai");
            if (activity.findViewById(identifier2) != null) {
                AttentionView attentionView3 = (AttentionView) activity.findViewById(identifier2);
                attentionView3.setPage(trackInfo.trackB);
                l(starHeaderData, attentionView3);
                m(attentionView3, trackInfo.trackB, TypedValues.Custom.S_FLOAT, starHeaderData);
                attentionView.addAttentionView(attentionView3);
            }
        }
    }

    public static void d(Activity activity, ViewGroup viewGroup, StarHeaderData starHeaderData, int i, StarHeaderContract.Model model, BasePresenter basePresenter) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29027345")) {
            ipChange.ipc$dispatch("29027345", new Object[]{activity, viewGroup, starHeaderData, Integer.valueOf(i), model, basePresenter});
            return;
        }
        int i2 = R$id.user_header_back;
        if (viewGroup.findViewById(i2) != null) {
            if (model.getFragmentType() == 0) {
                viewGroup.findViewById(i2).setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.findViewById(i2).getLayoutParams();
                layoutParams.setMargins(v50.a(activity, 21.0f), ne2.a(activity), 0, 0);
                viewGroup.findViewById(i2).setLayoutParams(layoutParams);
            } else {
                viewGroup.findViewById(i2).setVisibility(4);
            }
        }
        String str3 = starHeaderData.name;
        if (str3 == null) {
            str3 = "";
        }
        i(activity, R$id.star_user_tv_name, str3);
        TextView textView = (TextView) viewGroup.findViewById(R$id.user_tv_name);
        int i3 = i == 2 ? 140 : 245;
        if (!(textView == null || textView == null)) {
            textView.setText(str3);
            TextPaint paint = textView.getPaint();
            while (paint != null && paint.measureText(str3) > ((float) v50.a(activity, (float) i3)) && paint.getTextSize() > ((float) v50.a(activity, 10.0f))) {
                paint.setTextSize(paint.getTextSize() - 2.0f);
            }
        }
        if (starHeaderData.fansNum == 0) {
            int i4 = R$id.user_tv_fanscout;
            if (viewGroup.findViewById(i4) != null) {
                viewGroup.findViewById(i4).setVisibility(4);
            }
            viewGroup.findViewById(R$id.user_tv_fansdesc).setVisibility(4);
        } else {
            int i5 = R$id.user_tv_fanscout;
            if (viewGroup.findViewById(i5) != null) {
                viewGroup.findViewById(i5).setVisibility(0);
            }
            int i6 = R$id.user_tv_fansdesc;
            viewGroup.findViewById(i6).setVisibility(0);
            String[] f = f(starHeaderData.fansNum);
            j(viewGroup, i5, f[0]);
            j(viewGroup, i6, f[1]);
        }
        if (starHeaderData.projectShowNum == 0) {
            int i7 = R$id.user_tv_showcout;
            if (viewGroup.findViewById(i7) != null) {
                j(viewGroup, i7, "0");
            }
        } else {
            int i8 = R$id.user_tv_showcout;
            if (viewGroup.findViewById(i8) != null) {
                j(viewGroup, i8, starHeaderData.projectShowNum + "");
            }
        }
        int i9 = R$drawable.button_bg_gray;
        if (i == StarHeaderData.TYPE_COMMON) {
            viewGroup.findViewById(R$id.user_iv_header).setVisibility(0);
            String str4 = starHeaderData.headPic;
            if (str4 == null || !str4.contains("?")) {
                str2 = str4 + "?ran=" + new Random().nextInt();
            } else {
                str2 = str4 + "&ran=" + new Random().nextInt();
            }
            cn.damai.common.image.a.b().c(str2).c(R$drawable.c_default_bg).i(i9).n(new C0050a(viewGroup, i, str2)).f();
        } else if (i == StarHeaderData.TYPE_TAB) {
            int i10 = R$id.star_header_img;
            if (viewGroup.findViewById(i10) != null) {
                viewGroup.findViewById(i10).setVisibility(0);
            }
            viewGroup.findViewById(R$id.user_iv_header).setVisibility(8);
            cn.damai.common.image.a.b().c(starHeaderData.backgroundPic).n(new b(viewGroup.findViewById(R$id.star_index_headerbg))).f();
            String str5 = starHeaderData.bigHeadPic;
            if (str5 == null || !str5.contains("?")) {
                str = str5 + "?ran=" + new Random().nextInt();
            } else {
                str = str5 + "&ran=" + new Random().nextInt();
            }
            cn.damai.common.image.a.b().c(str).c(i9).i(i9).n(new c(viewGroup)).f();
        } else {
            ImageView imageView = (ImageView) viewGroup.findViewById(R$id.user_star_b_headerbg);
            imageView.setVisibility(0);
            a = false;
            cn.damai.common.image.a.b().c(starHeaderData.backgroundPicGif).n(new yd2(imageView)).f();
            cn.damai.common.image.a.b().c(starHeaderData.backgroundPic).n(new xd2(imageView)).f();
        }
        c(viewGroup, starHeaderData, activity, model.getTrackInfo());
        int i11 = R$id.star_header_ll_share;
        viewGroup.findViewById(i11).setVisibility(0);
        viewGroup.findViewById(i11).setOnClickListener(new d(starHeaderData, activity, viewGroup, basePresenter));
    }

    public static int e(float f, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1962684104")) {
            return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
        }
        return ((Integer) ipChange.ipc$dispatch("1962684104", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
    }

    public static String[] f(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716862812")) {
            return (String[]) ipChange.ipc$dispatch("716862812", new Object[]{Long.valueOf(j)});
        }
        String[] strArr = new String[2];
        if (j < 10000) {
            try {
                strArr[0] = j + "";
                strArr[1] = "粉丝";
                return strArr;
            } catch (Exception e) {
                e.printStackTrace();
                return new String[2];
            }
        } else {
            strArr[0] = (((float) (j / 1000)) / 10.0f) + "";
            strArr[1] = "万粉丝";
            return strArr;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(ImageView imageView, DMImageCreator.e eVar) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400580432")) {
            ipChange.ipc$dispatch("-400580432", new Object[]{imageView, eVar});
        } else if (eVar != null && (drawable = eVar.a) != null) {
            imageView.setImageDrawable(drawable);
            a = true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h(ImageView imageView, DMImageCreator.e eVar) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-929499471")) {
            ipChange.ipc$dispatch("-929499471", new Object[]{imageView, eVar});
        } else if (!a && eVar != null && (drawable = eVar.a) != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void i(Activity activity, @IdRes int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1174278361")) {
            ipChange.ipc$dispatch("-1174278361", new Object[]{activity, Integer.valueOf(i), str});
        } else if (activity != null && activity.findViewById(i) != null && !xf2.j(str)) {
            ((TextView) activity.findViewById(i)).setText(str.trim());
        }
    }

    public static void j(ViewGroup viewGroup, @IdRes int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715407334")) {
            ipChange.ipc$dispatch("-1715407334", new Object[]{viewGroup, Integer.valueOf(i), str});
        } else if (viewGroup != null && viewGroup.findViewById(i) != null && !xf2.j(str)) {
            ((TextView) viewGroup.findViewById(i)).setText(str.trim());
        }
    }

    public static void k(StarHeaderData starHeaderData, Activity activity, ViewGroup viewGroup, BasePresenter basePresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825139865")) {
            ipChange.ipc$dispatch("825139865", new Object[]{starHeaderData, activity, viewGroup, basePresenter});
            return;
        }
        Bundle bundle = new Bundle();
        ShareInfo shareInfo = starHeaderData.shareInfo;
        bundle.putString("title", shareInfo.shareTitle);
        bundle.putString("message", shareInfo.shareSubTitle);
        bundle.putString("imageurl", shareInfo.sharePic);
        bundle.putString("producturl", "https://m.damai.cn/damai/activity/passport/index.html?userId=" + starHeaderData.id + "&userType=" + starHeaderData.targetType);
        bundle.putBoolean("showGenerateImage", true);
        bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE);
        bundle.putString("projectName", shareInfo.shareTitle);
        if (!xf2.j(shareInfo.sharePic)) {
            bundle.putString("projectImage", shareInfo.sharePic);
        } else {
            bundle.putString("projectImage", i42.r(R$drawable.c_default_bg));
        }
        ShareManager.E().T(activity, bundle, viewGroup);
        ShareManager.E().L();
        ShareManager.E().q0();
        ShareManager.E().e0(ShareManager.E().F(activity, 2, starHeaderData.id, 1));
        ShareManager.E().l0();
        if (basePresenter != null) {
            basePresenter.userTrackClick("share", false);
        }
    }

    public static void l(StarHeaderData starHeaderData, AttentionView attentionView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505324206")) {
            ipChange.ipc$dispatch("-1505324206", new Object[]{starHeaderData, attentionView});
        } else if (attentionView != null) {
            attentionView.setInitParams(starHeaderData.id + "", starHeaderData.targetType + "");
            attentionView.setVisibility(0);
            attentionView.setState(starHeaderData.followStatus);
        }
    }

    private static void m(AttentionView attentionView, String str, String str2, StarHeaderData starHeaderData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544591866")) {
            ipChange.ipc$dispatch("544591866", new Object[]{attentionView, str, str2, starHeaderData});
        } else if (attentionView != null) {
            attentionView.setModule(str2);
            HashMap hashMap = new HashMap();
            hashMap.put("artist_id", starHeaderData.id);
            cn.damai.common.user.c.e().G(attentionView, "follow_btn", str2, str, hashMap);
        }
    }
}
