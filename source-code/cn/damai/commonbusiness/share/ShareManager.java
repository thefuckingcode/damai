package cn.damai.commonbusiness.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.common.AppConfig;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$array;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.R$style;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.MyScrollView;
import cn.damai.wxapi.ShareUtil;
import cn.damai.wxapi.WXAgent;
import com.ali.user.open.core.Site;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.moimage.DownloadImgListener;
import com.alibaba.pictures.moimage.MoImageDownloader;
import com.alibaba.pictures.moimage.MoImageLoadException;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import tb.bc1;
import tb.bk2;
import tb.d20;
import tb.f4;
import tb.h03;
import tb.l01;
import tb.n42;
import tb.p21;
import tb.q92;
import tb.v50;
import tb.wk;
import tb.xf2;
import tb.yt2;
import tb.z10;

/* compiled from: Taobao */
public class ShareManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ShareManager u0;
    private TextView A;
    private TextView B;
    private LinearLayout C;
    private TextView D;
    private TextView E;
    private String F;
    private boolean G;
    private String H = "chat_h5";
    private Bitmap I;
    private boolean J;
    private DMIconFontTextView K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public boolean U;
    public String V;
    public int W;
    public String X;
    private View Y;
    private View Z;
    private ShareUtil a;
    private View a0;
    private String[] b;
    private View b0;
    private IWXAPI c;
    private String c0;
    private String d = "";
    private MyScrollView d0;
    private String e;
    private RelativeLayout e0;
    private String f;
    private LinearLayout f0;
    private String g;
    private LinearLayout g0;
    private String h = null;
    private LinearLayout h0;
    private String i;
    private View i0;
    private String j;
    private long j0;
    private Bundle k;
    private boolean k0;
    private boolean l;
    private boolean l0;
    private boolean m;
    private boolean m0;
    private String n;
    public boolean n0 = true;
    private String o;
    private IImageShareInfoProvider o0;
    private long p;
    long p0 = System.currentTimeMillis();
    private PopupWindow q;
    DMShareMessage.YYMemberIntegrate q0;
    private View r;
    private View.OnClickListener r0 = new f();
    private Activity s;
    private OnGenerateImageClickListener s0;
    private View t;
    protected DMProgressDialog t0;
    private View u;
    private View v;
    private ImageView w;
    private TextView x;
    private View y;
    private View z;

    /* compiled from: Taobao */
    public interface OnGenerateImageClickListener {
        void onGenerateClick();
    }

    /* compiled from: Taobao */
    public class a implements DownloadImgListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void onDownloaded(@Nullable String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1156171473")) {
                ipChange.ipc$dispatch("1156171473", new Object[]{this, str, bitmap});
                return;
            }
            ShareManager.this.t0();
            ShareManager.this.a.setImageBitmap(bitmap);
            ShareManager.this.a.saveToLocal();
        }

        @Override // com.alibaba.pictures.moimage.DownloadImgListener
        public void onFail(@NonNull MoImageLoadException moImageLoadException, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "299232592")) {
                ipChange.ipc$dispatch("299232592", new Object[]{this, moImageLoadException, str});
                return;
            }
            ShareManager.this.t0();
            ToastUtil.f("保存失败");
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        b(Context context, int i, String str, int i2) {
            this.a = context;
            this.b = i;
            this.c = str;
            this.d = i2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1029637621")) {
                ipChange.ipc$dispatch("-1029637621", new Object[]{this, view});
                return;
            }
            ShareManager.this.b0(this.a, this.b, this.c, this.d);
        }
    }

    /* compiled from: Taobao */
    public class c implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(ShareManager shareManager) {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1963748254")) {
                ipChange.ipc$dispatch("-1963748254", new Object[]{this, dialogInterface});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements MyScrollView.ScrollYListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.uikit.view.MyScrollView.ScrollYListener
        public void onScroll(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1212493647")) {
                ipChange.ipc$dispatch("1212493647", new Object[]{this, view, Integer.valueOf(i)});
                return;
            }
            ShareManager.this.u0(((float) i) / ((float) v50.a(ShareManager.this.s, 50.0f)));
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1323497060")) {
                ipChange.ipc$dispatch("-1323497060", new Object[]{this, view});
                return;
            }
            DMNav.from(ShareManager.this.s).toUri(h03.j());
            cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e("share_pic", "share", "point", ShareManager.this.I(), Boolean.TRUE));
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "787793309")) {
                ipChange.ipc$dispatch("787793309", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.share_sina_btn) {
                cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "微博", ShareManager.this.k0(Site.WEIBO, "sinawb"), "item_2"));
                ShareManager.this.a.setProducturl(ShareManager.this.H(Site.WEIBO, "sinawb"));
                ShareManager.this.a.shareByWay(ShareManager.this.b[0]);
            } else if (id == R$id.share_wechat_btn) {
                cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "微信", ShareManager.this.k0("weixin", "wxpeople"), "item_0"));
                ShareManager.this.a.setProducturl(ShareManager.this.H("weixin", "wxpeople"));
                ShareManager.this.a.shareByWay(ShareManager.this.b[1]);
            } else if (id == R$id.share_qq_btn) {
                cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "QQ好友", ShareManager.this.k0(Site.QQ, "qqfriends"), "item_3"));
                ShareManager.this.a.setProducturl(ShareManager.this.H(Site.QQ, "qqfriends"));
                ShareManager.this.a.shareByWay(ShareManager.this.b[5]);
            } else if (id == R$id.share_wechat_circle_btn) {
                cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "朋友圈", ShareManager.this.k0("weixin", "wxfriends"), "item_1"));
                if (yt2.b(ShareManager.this.s, false)) {
                    if (!ShareManager.this.a.checkSharetype()) {
                        ToastUtil.a().e(ShareManager.this.s, bk2.b(ShareManager.this.s, R$string.damai_share_circle_load_toast));
                    } else if (!GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(ShareManager.this.j) || ShareManager.this.m0) {
                        ShareManager.this.a.setProducturl(ShareManager.this.H("weixin", "wxfriends"));
                        ShareManager.this.a.shareByWay(ShareManager.this.b[4]);
                    } else {
                        ShareManager.this.l0 = true;
                        ShareManager.this.Z(view);
                    }
                } else {
                    return;
                }
            } else if (id == R$id.share_dingding_circle_btn) {
                ShareManager.this.a.setProducturl(ShareManager.this.H(Site.DING, "dingdingapp"));
                ShareManager.this.a.shareByWay(ShareManager.this.b[2]);
                cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "钉钉", ShareManager.this.k0(Site.DING, "dingdingapp"), "item_4"));
            } else if (id == R$id.share_save_btn) {
                cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "保存图片", "", "save_img"));
                ShareManager.this.c0();
            } else if (id == R$id.share_cancel_area || id == R$id.share_cancel_btn) {
                ShareManager.this.C();
                cn.damai.common.user.c.e().x(wk.j().r(ShareManager.this.p, "item"));
            } else if (id == R$id.icon_back) {
                ShareManager.this.C();
            } else if (id == R$id.share_fans) {
                ShareManager.this.k0 = true;
                ShareManager.this.j0();
                HashMap hashMap = new HashMap();
                hashMap.put("titlelabel", ShareManager.this.j);
                hashMap.put("contentlabel", ShareManager.this.g);
                hashMap.put("usercode", d20.E());
                cn.damai.common.user.c.e().x(wk.j().e("share", "item", "send_fans", hashMap, Boolean.FALSE));
            }
            if (TextUtils.isEmpty(ShareManager.this.F) && !ShareManager.this.k0 && !ShareManager.this.l0) {
                ShareManager.this.C();
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g(ShareManager shareManager) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1298427665")) {
                ipChange.ipc$dispatch("1298427665", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2026958608")) {
                ipChange.ipc$dispatch("-2026958608", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ShareManager.this.i0();
        }
    }

    /* compiled from: Taobao */
    public class i implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "643020193")) {
                ipChange.ipc$dispatch("643020193", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(wk.j().s(ShareManager.this.p, "生成图片", "", "generate_img"));
            if (ShareManager.this.s0 != null) {
                ShareManager.this.s0.onGenerateClick();
            } else {
                ShareManager.this.Z(view);
            }
        }
    }

    /* compiled from: Taobao */
    public class j implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        j(View view) {
            this.a = view;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "894619950")) {
                ipChange.ipc$dispatch("894619950", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-875690987")) {
                ipChange.ipc$dispatch("-875690987", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            if (ShareManager.this.l0) {
                ShareManager shareManager = ShareManager.this;
                shareManager.n0(shareManager.b[4]);
            }
            ShareManager.this.C();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395341409")) {
            ipChange.ipc$dispatch("1395341409", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        if (z2) {
            this.s.setResult(-1);
        }
        this.s.finish();
    }

    public static ShareManager E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779673413")) {
            return (ShareManager) ipChange.ipc$dispatch("-779673413", new Object[0]);
        }
        if (u0 == null) {
            u0 = new ShareManager();
        }
        return u0;
    }

    public static float G(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1794931296")) {
            return (float) DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
        }
        return ((Float) ipChange.ipc$dispatch("1794931296", new Object[]{context})).floatValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    private String H(String str, String str2) {
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-795895278")) {
            return (String) ipChange.ipc$dispatch("-795895278", new Object[]{this, str, str2});
        }
        String str5 = "";
        if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.j)) {
            str4 = "alink_" + this.p;
        } else if (GenerateImageUtil.TYPE_FROMWHERE_DETAILCOMMENT.equalsIgnoreCase(this.j)) {
            str4 = "qr_comment_" + this.p;
        } else if ("H5".equalsIgnoreCase(this.j)) {
            str4 = "alink_appshareactivity20180305";
        } else {
            str3 = str5;
            StringBuffer stringBuffer = new StringBuffer();
            if (this.i.contains("?")) {
                stringBuffer.append(this.i + "?");
            } else {
                stringBuffer.append(this.i + "&");
            }
            stringBuffer.append("utm_source=" + str + "&utm_medium=" + str2 + "&utm_content=" + str5 + "&utm_campaign=" + str3);
            return stringBuffer.toString();
        }
        str3 = str4;
        str5 = "dmappshare";
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.i.contains("?")) {
        }
        stringBuffer2.append("utm_source=" + str + "&utm_medium=" + str2 + "&utm_content=" + str5 + "&utm_campaign=" + str3);
        return stringBuffer2.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map I() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94086954")) {
            return (Map) ipChange.ipc$dispatch("94086954", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", this.p + "");
        hashMap.put("vip_status", this.q0.memberFlag);
        hashMap.put("usercode", d20.E());
        return hashMap;
    }

    private void R(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597297202")) {
            ipChange.ipc$dispatch("1597297202", new Object[]{this, bundle});
        } else if (bundle == null || !bundle.containsKey(DMShareMessage.KEY_ADS_BANNER) || bundle.getSerializable(DMShareMessage.KEY_ADS_BANNER) == null) {
            this.z.setVisibility(8);
        } else {
            DMShareMessage.AdsBanner adsBanner = (DMShareMessage.AdsBanner) bundle.getSerializable(DMShareMessage.KEY_ADS_BANNER);
            if (adsBanner == null || xf2.j(adsBanner.title) || xf2.j(adsBanner.subTitle)) {
                this.z.setVisibility(8);
                return;
            }
            this.A.setText(adsBanner.title);
            this.B.setText(adsBanner.subTitle);
            this.A.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.A.getPaint().getTextSize() * ((float) this.A.getText().length()), 0.0f, Color.parseColor("#FF45BD"), Color.parseColor("#D34BFF"), Shader.TileMode.CLAMP));
            this.A.invalidate();
            this.z.setVisibility(0);
        }
    }

    private void S() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671541260")) {
            ipChange.ipc$dispatch("-671541260", new Object[]{this});
        } else if (this.I != null) {
            this.v.setVisibility(0);
            this.u.setVisibility(8);
            this.a0.setVisibility(0);
            this.Y.setVisibility(8);
            this.Z.setVisibility(8);
            float G2 = G(this.s) - ((float) n42.a(this.s, 42.0f));
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            layoutParams.height = (int) ((G2 / ((float) this.I.getWidth())) * ((float) this.I.getHeight()));
            this.w.setLayoutParams(layoutParams);
            this.w.setImageBitmap(this.I);
            this.a.setImageBitmap(this.I);
            if (!TextUtils.isEmpty(this.o)) {
                this.x.setText(this.o);
            }
        } else if (this.J) {
            this.u.setVisibility(0);
            this.v.setVisibility(8);
            this.a0.setVisibility(0);
        } else {
            this.v.setVisibility(8);
            this.u.setVisibility(0);
            this.a0.setVisibility(8);
        }
    }

    private void U() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621582042")) {
            ipChange.ipc$dispatch("621582042", new Object[]{this});
            return;
        }
        this.d0 = (MyScrollView) this.t.findViewById(R$id.share_scrollview);
        this.e0 = (RelativeLayout) this.t.findViewById(R$id.share_title_layout);
        MyScrollView myScrollView = this.d0;
        if (myScrollView != null) {
            myScrollView.setOnScrollYListener(new d());
        }
    }

    private void V(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187317250")) {
            ipChange.ipc$dispatch("187317250", new Object[]{this, bundle});
        } else if (bundle == null) {
            ToastUtil a2 = ToastUtil.a();
            Activity activity = this.s;
            a2.e(activity, bk2.b(activity, R$string.damai_sharesina_parameter_error_toast));
        } else {
            String string = bundle.getString("title", "");
            this.f = string;
            if (TextUtils.isEmpty(string)) {
                this.f = "我在大麦发现了一场超棒的演出";
            }
            String string2 = bundle.getString("message", "");
            this.g = string2;
            if (TextUtils.isEmpty(string2)) {
                this.g = "去现场，为所爱";
            }
            String string3 = bundle.getString("imageurl", "");
            this.h = string3;
            if (TextUtils.isEmpty(string3)) {
                this.h = "https://img.alicdn.com/imgextra/i2/O1CN01LRUb8s1hczQmxsaQ8_!!6000000004299-2-tps-300-238.png";
            }
            String string4 = bundle.getString("producturl", "");
            this.i = string4;
            if (TextUtils.isEmpty(string4)) {
                this.i = "https://m.damai.cn";
            }
            this.j = bundle.getString("fromWhere", "");
            this.m0 = bundle.getBoolean("isShrareImagePage", false);
            this.d = bundle.getString("sinaSharePath", "");
            this.e = bundle.getString("starwxshareurl", "");
            this.p = bundle.getLong("projectId", 0);
            this.o = bundle.getString("imageTitle", "");
            if (bundle.containsKey("imageModeUrl")) {
                this.F = bundle.getString("imageModeUrl");
                this.G = true;
            } else {
                this.F = "";
                this.G = false;
            }
            this.H = bundle.getString("shareType", "");
            this.c0 = bundle.getString("dimiss_action", "");
            this.l = bundle.getBoolean("showGenerateImage", false);
            this.m = bundle.getBoolean("hideCopyLink", false);
            this.n = bundle.getString("shareImageStyle", "");
            this.L = bundle.getString("price", "");
            this.M = bundle.getString(RankSquareCMSActivity.PRESET_CITY_NAME, "");
            this.N = bundle.getString("showDate", "");
            this.O = bundle.getString("venueName", "");
            this.R = bundle.getString("userNick", "");
            this.S = bundle.getString("userHeaderIcon", "");
            this.U = bundle.getBoolean("vip", false);
            this.T = bundle.getString("vipLevelIcon", "");
            this.V = bundle.getString("memberFlag", "0");
            this.W = bundle.getInt("evaluateGrade", 0);
            this.P = bundle.getString("projectImage", "");
            this.Q = bundle.getString("projectName", "");
            this.X = bundle.getString(p21.ISSUE_PARAM_COMMENT_TYPE, "");
            if (!TextUtils.isEmpty(this.g) && this.g.contains(this.i)) {
                String str = this.g;
                this.g = str.substring(0, str.indexOf(this.i));
            }
            this.a = new ShareUtil(this.s, this.j);
            if (!TextUtils.isEmpty(this.e)) {
                this.a.initShareData(this.f, this.g, this.h, this.i, this.d, this.e, this.p);
            } else {
                this.a.initShareData(this.f, this.g, this.h, this.i, this.d, this.p);
            }
            if (!TextUtils.isEmpty(this.F)) {
                this.a.setImageModeUrl(this.F);
            }
            if (!TextUtils.isEmpty(this.H)) {
                this.a.setShareType(this.H);
            }
            if (!TextUtils.isEmpty(this.M)) {
                this.a.setCityName(this.M);
            }
            if (!TextUtils.isEmpty(this.O)) {
                this.a.setVenueName(this.O);
            }
            if (!TextUtils.isEmpty(this.N)) {
                this.a.setShowDate(this.N);
            }
            if (!TextUtils.isEmpty(this.L)) {
                this.a.setPrice(this.L);
            }
            boolean z2 = bundle.getBoolean("miniprogram", true);
            this.n0 = z2;
            this.a.setShare2MiniProgram(z2);
        }
    }

    private void W() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430228543")) {
            ipChange.ipc$dispatch("430228543", new Object[]{this});
            return;
        }
        this.y.setVisibility(8);
    }

    private void X() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53817765")) {
            ipChange.ipc$dispatch("-53817765", new Object[]{this});
            return;
        }
        this.b = bk2.a(this.s, R$array.share_title);
        if (AppConfig.v()) {
            this.c = WXAPIFactory.createWXAPI(this.s, z10.a(WXAgent.APP_ID_DEBUG_CRYPT));
            return;
        }
        this.c = WXAPIFactory.createWXAPI(this.s, z10.a(WXAgent.APP_ID_CRYPT));
    }

    private void Y(Bundle bundle) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403098974")) {
            ipChange.ipc$dispatch("-403098974", new Object[]{this, bundle});
        } else if (bundle == null || !bundle.containsKey(DMShareMessage.KEY_YYMEMBER_INTEGRATE) || bundle.getSerializable(DMShareMessage.KEY_YYMEMBER_INTEGRATE) == null) {
            this.C.setVisibility(8);
        } else {
            this.q0 = (DMShareMessage.YYMemberIntegrate) bundle.getSerializable(DMShareMessage.KEY_YYMEMBER_INTEGRATE);
            Double valueOf = Double.valueOf(0.0d);
            try {
                if (!TextUtils.isEmpty(this.q0.oriScore)) {
                    valueOf = Double.valueOf(Double.parseDouble(this.q0.oriScore));
                }
            } catch (Exception unused) {
            }
            if (this.q0 == null || valueOf.doubleValue() <= 0.0d) {
                this.C.setVisibility(8);
                return;
            }
            this.C.setVisibility(0);
            if (h03.d(this.q0.memberFlag)) {
                str = "会员积分，可兑专享福利~";
                str2 = "去兑换";
            } else {
                str = "积分，升级会员可兑福利~";
                str2 = "去看看";
            }
            SpannableString spannableString = new SpannableString("评价获得" + this.q0.oriScore + str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FDA277")), "评价获得".length(), "评价获得".length() + this.q0.oriScore.length(), 33);
            this.D.setText(spannableString);
            this.E.setText(str2);
            this.C.setOnClickListener(new e());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Z(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111671029")) {
            ipChange.ipc$dispatch("-2111671029", new Object[]{this, view});
            return;
        }
        DMShareMessage dMShareMessage = new DMShareMessage();
        String str = this.n;
        dMShareMessage.shareImageStyle = str;
        dMShareMessage.sharePictureUrl = this.P;
        dMShareMessage.shareTitle = this.Q;
        if ("projectImage".equals(str)) {
            dMShareMessage.shareContent = String.format("%1$s·%2$s | %3$s", this.M, this.O, this.N);
        } else {
            dMShareMessage.shareContent = this.g;
        }
        dMShareMessage.shareLink = this.i;
        dMShareMessage.fromWhere = this.j;
        dMShareMessage.userNick = this.R;
        dMShareMessage.userHeaderIcon = this.S;
        dMShareMessage.vip = this.U;
        dMShareMessage.memberFlag = this.V;
        dMShareMessage.vipLevelIcon = this.T;
        dMShareMessage.evaluateGrade = this.W;
        dMShareMessage.evaluateTime = this.N;
        dMShareMessage.remarkValue = this.k.getString(DMShareMessage.KEY_EVALUATE_REMARK);
        dMShareMessage.projectCity = this.k.getString(DMShareMessage.KEY_PROJECT_CITY);
        dMShareMessage.projectTime = this.k.getString(DMShareMessage.KEY_PROJECT_TIME);
        dMShareMessage.shareFooter = this.k.getString(DMShareMessage.KEY_SHARE_FOOTER);
        dMShareMessage.windowTitle = this.o;
        dMShareMessage.itemType = this.k.getInt("itemType");
        dMShareMessage.dmInfo = (DmInfo) this.k.getSerializable(DMShareMessage.KEY_EVALUATE_DMINFO);
        dMShareMessage.storeInfo = (StoreInfo) this.k.getSerializable(DMShareMessage.KEY_EVALUATE_STOREINFO);
        DMShareMessage.ExtraMedia[] extraMediaArr = (DMShareMessage.ExtraMedia[]) this.k.getSerializable(DMShareMessage.KEY_EXTRA_MEDIA);
        if (extraMediaArr != null && extraMediaArr.length > 0) {
            dMShareMessage.extraMedia = Arrays.asList(extraMediaArr);
        }
        dMShareMessage.adsBanner = (DMShareMessage.AdsBanner) this.k.getSerializable(DMShareMessage.KEY_ADS_BANNER);
        dMShareMessage.vipScore = (DMShareMessage.YYMemberIntegrate) this.k.getSerializable(DMShareMessage.KEY_YYMEMBER_INTEGRATE);
        if ("projectImage".equals(this.n)) {
            dMShareMessage.projectId = String.valueOf(this.p);
            dMShareMessage.commentType = this.X;
        }
        view.setClickable(false);
        if (GenerateImageUtil.K(this.n)) {
            GenerateImageUtil.r(this.s, dMShareMessage, this.l0, this.o0);
        } else {
            GenerateImageUtil.q(this.s, dMShareMessage, this.l0);
        }
        GenerateImageUtil.G(new j(view));
    }

    private void a0(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036814963")) {
            ipChange.ipc$dispatch("-2036814963", new Object[]{this, bundle});
        } else if (bundle != null) {
            try {
                String string = bundle.getString("title", "");
                if (string != null && string.length() > 100) {
                    bundle.putString("title", string.substring(0, 100));
                }
                String string2 = bundle.getString("message", "");
                if (string2 != null && string2.length() > 100) {
                    bundle.putString("message", string2.substring(0, 100));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081204864")) {
            ipChange.ipc$dispatch("-2081204864", new Object[]{this});
        } else if (this.J) {
            try {
                if (!TextUtils.isEmpty(this.F)) {
                    s0("");
                    if (!this.F.startsWith("http")) {
                        this.a.setImageBitmap(bc1.a(this.s, this.F));
                        t0();
                        this.a.saveToLocal();
                        return;
                    }
                    MoImageDownloader.i(this.s).e(this.F).c(new a());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            this.a.saveToLocal();
        }
    }

    public static int d0(float f2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665414333")) {
            return ((Integer) ipChange.ipc$dispatch("-665414333", new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})).intValue();
        }
        return Color.argb((int) f2, (16711680 & i2) >> 16, (65280 & i2) >> 8, i2 & 255);
    }

    private void h0(View view, int... iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247317222")) {
            ipChange.ipc$dispatch("-247317222", new Object[]{this, view, iArr});
            return;
        }
        for (int i2 : iArr) {
            view.findViewById(i2).setOnClickListener(this.r0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998502932")) {
            ipChange.ipc$dispatch("998502932", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.j0 > 10000) {
            this.j0 = currentTimeMillis;
            ShareToFansMessage shareToFansMessage = new ShareToFansMessage();
            shareToFansMessage.imageurl = this.h;
            shareToFansMessage.message = this.g;
            shareToFansMessage.title = this.f;
            if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equalsIgnoreCase(this.j)) {
                shareToFansMessage.shareType = "chat_perform";
                shareToFansMessage.projectId = String.valueOf(this.p);
            } else if ("H5".equalsIgnoreCase(this.j)) {
                shareToFansMessage.shareType = "chat_h5";
                shareToFansMessage.producturl = this.i;
            } else if (GenerateImageUtil.TYPE_FROMWHERE_USERPROFILE.equalsIgnoreCase(this.j)) {
                shareToFansMessage.shareType = "chat_h5";
                shareToFansMessage.producturl = this.i;
            }
            ShareToFansRequest shareToFansRequest = new ShareToFansRequest();
            shareToFansRequest.showLoginUI(false);
            shareToFansRequest.shareDigest = this.f;
            shareToFansRequest.shareContent = JSON.toJSONString(shareToFansMessage);
            shareToFansRequest.shareType = this.j;
            shareToFansRequest.request(new DMMtopRequestListener<ShareToFansResponse>(ShareToFansResponse.class) {
                /* class cn.damai.commonbusiness.share.ShareManager.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-249644538")) {
                        ipChange.ipc$dispatch("-249644538", new Object[]{this, str, str2});
                        return;
                    }
                    ToastUtil.a().e(ShareManager.this.s, str2);
                    ShareManager.this.C();
                }

                public void onSuccess(ShareToFansResponse shareToFansResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-257204056")) {
                        ipChange.ipc$dispatch("-257204056", new Object[]{this, shareToFansResponse});
                    } else if ("true".equalsIgnoreCase(shareToFansResponse.shareSuccess)) {
                        ToastUtil.a().e(ShareManager.this.s, "分享成功");
                        ShareManager.this.C();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199963244")) {
            ipChange.ipc$dispatch("1199963244", new Object[]{this});
            return;
        }
        f4 f4Var = new f4(this.s);
        f4Var.e("分享给你的全部粉丝吗");
        f4Var.c(false);
        f4Var.f("取消", new g(this));
        f4Var.h("确定", new h());
        f4Var.j();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String k0(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151235881")) {
            return (String) ipChange.ipc$dispatch("-151235881", new Object[]{this, str, str2});
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.G) {
            stringBuffer.append("1&" + H(str, str2));
        } else {
            stringBuffer.append("0&" + H(str, str2));
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c9 A[SYNTHETIC, Splitter:B:34:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    private void n0(String str) {
        Throwable th;
        Exception e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425098203")) {
            ipChange.ipc$dispatch("-425098203", new Object[]{this, str});
            return;
        }
        String e3 = l01.e(this.s);
        if (!TextUtils.isEmpty(e3)) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(e3));
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2);
                    Bundle bundle = new Bundle();
                    bundle.putString("imageTitle", "分享");
                    bundle.putString("shareType", "chat_image");
                    bundle.putBoolean("hideCopyLink", true);
                    bundle.putString("imageModeUrl", e3);
                    V(bundle);
                    this.a.setImageBitmap(decodeStream);
                    if (this.b[4].equals(str)) {
                        this.a.setProducturl(H("weixin", "wxfriends"));
                        this.a.shareByWay(this.b[4]);
                    } else if (this.b[0].equals(str)) {
                        this.a.setProducturl(H(Site.WEIBO, "sinawb"));
                        this.a.shareByWay(this.b[0]);
                    } else if ("save_pic".equals(str)) {
                        c0();
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    fileInputStream = fileInputStream2;
                    try {
                        e2.printStackTrace();
                        if (fileInputStream == null) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e2 = e7;
                e2.printStackTrace();
                if (fileInputStream == null) {
                }
            }
        } else {
            ToastUtil.a().e(this.s, "分享失败");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u0(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137286323")) {
            ipChange.ipc$dispatch("137286323", new Object[]{this, Float.valueOf(f2)});
        } else if (f2 <= 0.0f) {
            DMIconFontTextView dMIconFontTextView = this.K;
            Resources resources = this.s.getResources();
            int i2 = R$color.color_ffffff;
            dMIconFontTextView.setTextColor(resources.getColor(i2));
            this.x.setTextColor(this.s.getResources().getColor(i2));
            this.e0.setBackgroundColor(this.s.getResources().getColor(R$color.transparent));
        } else if (f2 >= 1.0f) {
            DMIconFontTextView dMIconFontTextView2 = this.K;
            Resources resources2 = this.s.getResources();
            int i3 = R$color.color_111111;
            dMIconFontTextView2.setTextColor(resources2.getColor(i3));
            this.x.setTextColor(this.s.getResources().getColor(i3));
            this.e0.setBackgroundColor(this.s.getResources().getColor(R$color.color_ffffff));
        } else {
            float f3 = f2 * 255.0f;
            this.e0.setBackgroundColor(d0(f3, this.s.getResources().getColor(R$color.color_ffffff)));
            DMIconFontTextView dMIconFontTextView3 = this.K;
            Resources resources3 = this.s.getResources();
            int i4 = R$color.color_111111;
            dMIconFontTextView3.setTextColor(d0(f3, resources3.getColor(i4)));
            this.x.setTextColor(d0(f3, this.s.getResources().getColor(i4)));
        }
    }

    private void w0(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579180128")) {
            ipChange.ipc$dispatch("1579180128", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        DMShareMessage.YYMemberIntegrate yYMemberIntegrate = this.q0;
        if (yYMemberIntegrate != null && !TextUtils.isEmpty(yYMemberIntegrate.oriScore) && this.m0) {
            cn.damai.common.user.c.e().C("point", "share", "share_pic", "1.0", System.currentTimeMillis() - j2, I(), 2201);
        }
    }

    public void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619603508")) {
            ipChange.ipc$dispatch("-1619603508", new Object[]{this});
        } else if (this.m) {
            K();
        } else if (TextUtils.isEmpty(this.i) || !this.i.startsWith("http")) {
            K();
        } else {
            this.g0.setVisibility(0);
            this.i0.setVisibility(0);
            this.g0.removeAllViews();
            this.g0.addView(q92.c(this.s, this.i));
        }
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274088101")) {
            ipChange.ipc$dispatch("1274088101", new Object[]{this});
        } else if (this.l) {
            this.h0.setVisibility(0);
            this.i0.setVisibility(0);
            this.h0.removeAllViews();
            this.h0.addView(q92.f(this.s, new i()));
        } else {
            M();
        }
    }

    public void C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805256100")) {
            ipChange.ipc$dispatch("805256100", new Object[]{this});
            return;
        }
        if (this.t0 != null) {
            t0();
        }
        PopupWindow popupWindow = this.q;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.q = null;
            this.I = null;
            if ("finish".equalsIgnoreCase(this.c0) && this.s != null) {
                D(true);
            }
        }
        this.k0 = false;
        this.l0 = false;
    }

    public View F(Context context, int i2, String str, int i3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "98926561")) {
            return q92.g(context, new b(context, i2, str, i3));
        }
        return (View) ipChange.ipc$dispatch("98926561", new Object[]{this, context, Integer.valueOf(i2), str, Integer.valueOf(i3)});
    }

    public PopupWindow J() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "785499728")) {
            return this.q;
        }
        return (PopupWindow) ipChange.ipc$dispatch("785499728", new Object[]{this});
    }

    public void K() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1347211015")) {
            ipChange.ipc$dispatch("-1347211015", new Object[]{this});
            return;
        }
        this.g0.removeAllViews();
        this.g0.setVisibility(8);
        if (this.f0.getChildCount() <= 0 && this.h0.getChildCount() <= 0) {
            this.i0.setVisibility(8);
        }
    }

    public void L() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276121526")) {
            ipChange.ipc$dispatch("1276121526", new Object[]{this});
            return;
        }
        this.f0.removeAllViews();
        this.f0.setVisibility(8);
        if (this.g0.getChildCount() <= 0 && this.h0.getChildCount() <= 0) {
            this.i0.setVisibility(8);
        }
    }

    public void M() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736928360")) {
            ipChange.ipc$dispatch("-736928360", new Object[]{this});
            return;
        }
        this.h0.removeAllViews();
        this.h0.setVisibility(8);
        if (this.f0.getChildCount() <= 0 && this.g0.getChildCount() <= 0) {
            this.i0.setVisibility(8);
        }
    }

    public void N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50909497")) {
            ipChange.ipc$dispatch("-50909497", new Object[]{this});
            return;
        }
        this.b0.setVisibility(8);
        this.i0.setVisibility(8);
    }

    public void O(Activity activity, Bundle bundle, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922499597")) {
            ipChange.ipc$dispatch("1922499597", new Object[]{this, activity, bundle, Integer.valueOf(i2)});
            return;
        }
        P(activity, bundle, LayoutInflater.from(activity).inflate(i2, (ViewGroup) null));
    }

    public void P(Activity activity, Bundle bundle, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394943140")) {
            ipChange.ipc$dispatch("-1394943140", new Object[]{this, activity, bundle, view});
            return;
        }
        T(activity, bundle, view);
        l0();
    }

    public void Q(Activity activity, Bundle bundle, View view, IImageShareInfoProvider iImageShareInfoProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353858290")) {
            ipChange.ipc$dispatch("353858290", new Object[]{this, activity, bundle, view, iImageShareInfoProvider});
            return;
        }
        this.o0 = iImageShareInfoProvider;
        P(activity, bundle, view);
    }

    public void T(Activity activity, Bundle bundle, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803851230")) {
            ipChange.ipc$dispatch("1803851230", new Object[]{this, activity, bundle, view});
            return;
        }
        a0(bundle);
        this.s = activity;
        this.r = view;
        this.k = bundle;
        View inflate = LayoutInflater.from(activity).inflate(R$layout.share_activity, (ViewGroup) null);
        this.t = inflate;
        int i2 = R$id.share_save_btn;
        int i3 = R$id.share_cancel_btn;
        int i4 = R$id.share_cancel_area;
        int i5 = R$id.icon_back;
        h0(inflate, i2, R$id.share_wechat_btn, R$id.share_wechat_circle_btn, R$id.share_dingding_circle_btn, R$id.share_sina_btn, R$id.share_qq_btn, i3, i4, i5);
        PopupWindow popupWindow = new PopupWindow(this.t, -1, -1, true);
        this.q = popupWindow;
        popupWindow.setAnimationStyle(R$style.share_popwindow_anim_style);
        this.q.setTouchable(true);
        this.q.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#8A000000")));
        this.q.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class cn.damai.commonbusiness.share.ShareManager.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onDismiss() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "295747894")) {
                    ipChange.ipc$dispatch("295747894", new Object[]{this});
                    return;
                }
                ShareManager.this.q = null;
                ShareManager.this.I = null;
                if ("finish".equalsIgnoreCase(ShareManager.this.c0) && ShareManager.this.s != null) {
                    ShareManager.this.D(true);
                }
            }
        });
        this.v = this.t.findViewById(R$id.layout_image);
        this.u = this.t.findViewById(i4);
        this.K = (DMIconFontTextView) this.t.findViewById(i5);
        this.a0 = this.t.findViewById(i2);
        this.w = (ImageView) this.t.findViewById(R$id.image_share);
        this.Y = this.t.findViewById(R$id.text_share);
        this.Z = this.t.findViewById(i3);
        this.x = (TextView) this.t.findViewById(R$id.text_title);
        this.b0 = this.t.findViewById(R$id.layout_channel);
        this.f0 = (LinearLayout) this.t.findViewById(R$id.layout_extra);
        this.g0 = (LinearLayout) this.t.findViewById(R$id.layout_copy_link);
        this.h0 = (LinearLayout) this.t.findViewById(R$id.layout_generate_image);
        this.i0 = this.t.findViewById(R$id.divider_extra);
        this.y = this.t.findViewById(R$id.share_fans);
        this.z = this.t.findViewById(R$id.share_ads_banner);
        this.A = (TextView) this.t.findViewById(R$id.share_ads_banner_title);
        this.B = (TextView) this.t.findViewById(R$id.share_ads_banner_subtitle);
        this.C = (LinearLayout) this.t.findViewById(R$id.share_yymember_integrate);
        this.D = (TextView) this.t.findViewById(R$id.share_yymember_integrate_text);
        this.E = (TextView) this.t.findViewById(R$id.share_yymember_integrate_action);
        U();
        X();
        V(bundle);
        S();
        W();
        R(bundle);
        Y(bundle);
        A();
        B();
    }

    public void b0(Context context, int i2, String str, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412457477")) {
            ipChange.ipc$dispatch("-412457477", new Object[]{this, context, Integer.valueOf(i2), str, Integer.valueOf(i3)});
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("targetId", str);
            bundle.putInt("targetType", i3);
            bundle.putInt("type", i2);
            if (context == null) {
                E().C();
                return;
            }
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("report"));
            E().C();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            E().C();
            throw th;
        }
    }

    public ShareManager e0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350622544")) {
            return (ShareManager) ipChange.ipc$dispatch("350622544", new Object[]{this, view});
        }
        this.f0.setVisibility(0);
        this.i0.setVisibility(0);
        this.f0.removeAllViews();
        this.f0.addView(view);
        return this;
    }

    public ShareManager f0(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200581532")) {
            return (ShareManager) ipChange.ipc$dispatch("-1200581532", new Object[]{this, bitmap});
        }
        this.I = bitmap;
        return this;
    }

    public ShareManager g0(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516364151")) {
            return (ShareManager) ipChange.ipc$dispatch("-516364151", new Object[]{this, Boolean.valueOf(z2)});
        }
        this.J = z2;
        return this;
    }

    public void l0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102348543")) {
            ipChange.ipc$dispatch("102348543", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.q;
        if (popupWindow != null && !popupWindow.isShowing()) {
            this.q.showAtLocation(this.r, 80, 0, 0);
        }
    }

    public void m0(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730190803")) {
            ipChange.ipc$dispatch("-730190803", new Object[]{this, activity});
            return;
        }
        if (activity != null) {
            this.s = activity;
        }
        X();
        n0(this.b[4]);
    }

    public void o0(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430164115")) {
            ipChange.ipc$dispatch("430164115", new Object[]{this, activity});
            return;
        }
        if (activity != null) {
            this.s = activity;
        }
        this.b = bk2.a(activity, R$array.share_title);
        n0("save_pic");
    }

    public void p0(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898233895")) {
            ipChange.ipc$dispatch("-898233895", new Object[]{this, activity});
            return;
        }
        if (activity != null) {
            this.s = activity;
        }
        String[] a2 = bk2.a(activity, R$array.share_title);
        this.b = a2;
        n0(a2[0]);
    }

    public void q0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "558106946")) {
            ipChange.ipc$dispatch("558106946", new Object[]{this});
            return;
        }
        this.b0.setVisibility(0);
        this.i0.setVisibility(0);
    }

    public void r0(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429517739")) {
            ipChange.ipc$dispatch("-429517739", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
        }
    }

    public void s0(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-219678527")) {
            ipChange.ipc$dispatch("-219678527", new Object[]{this, str});
        } else if (!this.s.isFinishing()) {
            if (this.t0 == null) {
                this.t0 = new DMProgressDialog(this.s).a();
                if (!xf2.j(str)) {
                    this.t0.c(str);
                }
                this.t0.setOnDismissListener(new c(this));
            }
            this.t0.show();
        }
    }

    public void t0() {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459077893")) {
            ipChange.ipc$dispatch("459077893", new Object[]{this});
        } else if (!this.s.isFinishing() && (dMProgressDialog = this.t0) != null) {
            dMProgressDialog.dismiss();
            this.t0 = null;
        }
    }

    public void v0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913484853")) {
            ipChange.ipc$dispatch("913484853", new Object[]{this});
            return;
        }
        w0(this.p0);
    }
}
