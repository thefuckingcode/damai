package cn.damai.commonbusiness.share.evaluate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.comment.view.DMTagView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.inf.OnFinishListener;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.NineGridlayout;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import tb.bn0;
import tb.g1;
import tb.g91;
import tb.jk;
import tb.op;
import tb.qe0;
import tb.s71;
import tb.up2;
import tb.ur2;
import tb.v50;
import tb.xf2;

public class EvaluateShareViewHolder extends g1<Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private ScrollView c;
    private DMPosterView d;
    private TextView e;
    private DMAvatar f;
    private TextView g;
    private View h;
    private ImageView i;
    private DMRatingBar j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private RelativeLayout n;
    private NineGridlayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private View u;
    private EvaluateScriptMurderShopView v;
    private DMTagView w;
    private AtomicInteger x = new AtomicInteger(0);
    private int y = 0;

    public class a implements DMAvatar.OnImageLoadListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnFinishListener a;

        a(OnFinishListener onFinishListener) {
            EvaluateShareViewHolder.this = r1;
            this.a = onFinishListener;
        }

        @Override // com.alibaba.pictures.bricks.view.DMAvatar.OnImageLoadListener
        public void onImageLoadFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1835298668")) {
                ipChange.ipc$dispatch("-1835298668", new Object[]{this});
                return;
            }
            EvaluateShareViewHolder.this.h(this.a);
        }

        @Override // com.alibaba.pictures.bricks.view.DMAvatar.OnImageLoadListener
        public void onImageLoadSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "689357691")) {
                ipChange.ipc$dispatch("689357691", new Object[]{this});
                return;
            }
            EvaluateShareViewHolder.this.h(this.a);
        }
    }

    public class b implements Function0<ur2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnFinishListener a;

        b(OnFinishListener onFinishListener) {
            EvaluateShareViewHolder.this = r1;
            this.a = onFinishListener;
        }

        /* renamed from: a */
        public ur2 invoke() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-537650044")) {
                return (ur2) ipChange.ipc$dispatch("-537650044", new Object[]{this});
            }
            EvaluateShareViewHolder.this.h(this.a);
            return null;
        }
    }

    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnFinishListener a;

        c(OnFinishListener onFinishListener) {
            EvaluateShareViewHolder.this = r1;
            this.a = onFinishListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2030395743")) {
                ipChange.ipc$dispatch("-2030395743", new Object[]{this, dVar});
                return;
            }
            EvaluateShareViewHolder.this.d.setImageDrawable(EvaluateShareViewHolder.this.a.getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
            ToastUtil.a().e(EvaluateShareViewHolder.this.a, "图片生成失败");
            EvaluateShareViewHolder.this.h(this.a);
        }
    }

    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnFinishListener a;

        d(OnFinishListener onFinishListener) {
            EvaluateShareViewHolder.this = r1;
            this.a = onFinishListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1358648182")) {
                ipChange.ipc$dispatch("1358648182", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap == null) {
                g91.a("bitmap is null");
                ToastUtil.a().e(EvaluateShareViewHolder.this.a, "图片生成失败");
                OnFinishListener onFinishListener = this.a;
                if (onFinishListener != null) {
                    onFinishListener.onViewUpdateFailure();
                    return;
                }
                return;
            }
            int a2 = v50.a(EvaluateShareViewHolder.this.a, 86.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, (bitmap.getHeight() * a2) / bitmap.getWidth());
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            int a3 = v50.a(EvaluateShareViewHolder.this.a, 21.0f);
            layoutParams.setMargins(a3, a3, 0, 0);
            EvaluateShareViewHolder.this.d.setLayoutParams(layoutParams);
            EvaluateShareViewHolder.this.d.setImageBitmap(bitmap);
            try {
                i = DMRGBUtil.f(bitmap);
            } catch (Exception unused) {
                i = Color.parseColor(Bitmap12ColorHex.C_HEX_7176D4);
            }
            EvaluateShareViewHolder.this.h.setBackgroundDrawable(new ColorDrawable(i));
            EvaluateShareViewHolder.this.h(this.a);
        }
    }

    public EvaluateShareViewHolder(Context context) {
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_generate_evaluate_image_v2, (ViewGroup) null);
        this.b = inflate;
        this.u = inflate.findViewById(R$id.common_header_info);
        this.c = (ScrollView) this.b.findViewById(R$id.share_page);
        this.d = (DMPosterView) this.b.findViewById(R$id.share_page_poster);
        this.e = (TextView) this.b.findViewById(R$id.share_page_title);
        this.f = (cn.damai.uikit.view.DMAvatar) this.b.findViewById(R$id.share_page_user_header_icon);
        this.g = (TextView) this.b.findViewById(R$id.share_page_user_nick);
        this.h = this.b.findViewById(R$id.evaluate_share_top_bg);
        this.i = (ImageView) this.b.findViewById(R$id.comment_vip_icon);
        this.j = (DMRatingBar) this.b.findViewById(R$id.share_page_user_grade_view);
        this.k = (TextView) this.b.findViewById(R$id.share_page_user_grade);
        this.l = (TextView) this.b.findViewById(R$id.share_page_user_evaluate_content);
        this.m = (ImageView) this.b.findViewById(R$id.share_page_qrcode_img);
        TextView textView = (TextView) this.b.findViewById(R$id.share_page_qrcode_tip);
        this.n = (RelativeLayout) this.b.findViewById(R$id.comment_share_white_bg);
        this.o = (NineGridlayout) this.b.findViewById(R$id.share_page_user_evaluate_pics);
        this.p = (TextView) this.b.findViewById(R$id.share_page_remark);
        this.q = (TextView) this.b.findViewById(R$id.share_page_remark_value);
        this.s = (TextView) this.b.findViewById(R$id.share_page_perform_time);
        this.r = (TextView) this.b.findViewById(R$id.share_page_perform_city);
        this.t = (TextView) this.b.findViewById(R$id.share_page_footer);
        this.v = (EvaluateScriptMurderShopView) this.b.findViewById(R$id.script_murder_header_info);
        this.w = (DMTagView) this.b.findViewById(R$id.share_page_dm_tag);
    }

    private boolean f(AtomicInteger atomicInteger, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-601869565")) {
            return atomicInteger.addAndGet(1) == i2;
        }
        return ((Boolean) ipChange.ipc$dispatch("-601869565", new Object[]{this, atomicInteger, Integer.valueOf(i2)})).booleanValue();
    }

    private void g(Context context, int i2, boolean z, NineGridlayout nineGridlayout, List<DMShareMessage.ExtraMedia> list, final OnFinishListener onFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552709305")) {
            ipChange.ipc$dispatch("-552709305", new Object[]{this, context, Integer.valueOf(i2), Boolean.valueOf(z), nineGridlayout, list, onFinishListener});
        } else if (s71.a(list)) {
            nineGridlayout.setVisibility(8);
        } else {
            ArrayList arrayList = new ArrayList();
            for (DMShareMessage.ExtraMedia extraMedia : list) {
                if (extraMedia != null && !xf2.j(extraMedia.coverUrl)) {
                    NineGridlayout.Image image = new NineGridlayout.Image(extraMedia.coverUrl + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
                    image.setShowPlay(extraMedia.isVideo);
                    arrayList.add(image);
                }
            }
            if (arrayList.size() > 0) {
                nineGridlayout.setAlwaysLoadImage(true);
                nineGridlayout.setRadius(v50.a(context, 6.0f));
                nineGridlayout.setGap(v50.a(context, 3.0f));
                nineGridlayout.setTotalWidth(i2);
                nineGridlayout.setAutoShrink(z);
                nineGridlayout.setOnImageLoadListener(new NineGridlayout.OnImageLoadFinishListener() {
                    /* class cn.damai.commonbusiness.share.evaluate.EvaluateShareViewHolder.AnonymousClass5 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.uikit.view.NineGridlayout.OnImageLoadFinishListener
                    public void onCompletion(boolean z) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-776583889")) {
                            ipChange.ipc$dispatch("-776583889", new Object[]{this, Boolean.valueOf(z)});
                            return;
                        }
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            /* class cn.damai.commonbusiness.share.evaluate.EvaluateShareViewHolder.AnonymousClass5.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "191192242")) {
                                    ipChange.ipc$dispatch("191192242", new Object[]{this});
                                    return;
                                }
                                AnonymousClass5 r0 = AnonymousClass5.this;
                                EvaluateShareViewHolder.this.h(onFinishListener);
                            }
                        }, 30);
                    }
                });
                nineGridlayout.setSingleWH(-1, -1);
                nineGridlayout.updateImages(arrayList);
                nineGridlayout.setVisibility(0);
                return;
            }
            nineGridlayout.setVisibility(8);
        }
    }

    private void h(OnFinishListener onFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "255530427")) {
            ipChange.ipc$dispatch("255530427", new Object[]{this, onFinishListener});
        } else if (f(this.x, this.y) && onFinishListener != null) {
            onFinishListener.onViewUpdateSuccess();
        }
    }

    /* access modifiers changed from: public */
    private /* synthetic */ ur2 k(OnFinishListener onFinishListener, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032624562")) {
            return (ur2) ipChange.ipc$dispatch("-1032624562", new Object[]{this, onFinishListener, drawable});
        } else if (drawable != null) {
            this.h.setBackgroundDrawable(drawable);
            h(onFinishListener);
            return null;
        } else if (!f(this.x, this.y) || onFinishListener == null) {
            return null;
        } else {
            onFinishListener.onViewUpdateFailure();
            return null;
        }
    }

    public View i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1383611200")) {
            return this.b;
        }
        return (View) ipChange.ipc$dispatch("-1383611200", new Object[]{this});
    }

    public ScrollView j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-92185080")) {
            return this.c;
        }
        return (ScrollView) ipChange.ipc$dispatch("-92185080", new Object[]{this});
    }

    public void l(Object obj, OnFinishListener onFinishListener) {
        StoreInfo storeInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-716976540")) {
            ipChange.ipc$dispatch("-716976540", new Object[]{this, obj, onFinishListener});
            return;
        }
        DMShareMessage dMShareMessage = (DMShareMessage) obj;
        this.f.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_40x40);
        int i2 = !TextUtils.isEmpty(dMShareMessage.userHeaderIcon) ? 1 : 0;
        if (!TextUtils.isEmpty(dMShareMessage.sharePictureUrl) || ((storeInfo = dMShareMessage.storeInfo) != null && !TextUtils.isEmpty(storeInfo.getStoreImgUrl()))) {
            i2++;
        }
        if (!s71.a(dMShareMessage.extraMedia)) {
            i2++;
        }
        if (dMShareMessage.itemType == 1 && dMShareMessage.dmInfo != null) {
            i2++;
        }
        this.y = i2;
        g(this.a, ((int) up2.d(this.a)) - v50.a(this.a, 84.0f), true, this.o, dMShareMessage.extraMedia, onFinishListener);
        if (!TextUtils.isEmpty(dMShareMessage.userHeaderIcon)) {
            this.f.setOnImageLoadListener(new a(onFinishListener));
            this.f.setAvatar(dMShareMessage.userHeaderIcon);
        } else {
            this.f.setAvatarPlaceholder(R$drawable.uikit_user_default_icon);
        }
        if (dMShareMessage.vip) {
            this.f.setAvatarCrownVisibility(0);
            this.f.setAvatarBorderVisibility(0);
        } else {
            this.f.setAvatarCrownVisibility(8);
            this.f.setAvatarBorderVisibility(8);
        }
        this.n.setPadding(v50.a(this.a, 21.0f), v50.a(this.a, 15.0f), v50.a(this.a, 21.0f), 0);
        this.f.setYYMemberTagView(dMShareMessage.vip, dMShareMessage.memberFlag);
        if (!TextUtils.isEmpty(dMShareMessage.vipLevelIcon)) {
            this.i.setVisibility(0);
            cn.damai.common.image.a.b().e(dMShareMessage.vipLevelIcon).g(this.i);
        } else {
            this.i.setVisibility(8);
        }
        this.g.setText(dMShareMessage.userNick);
        if (dMShareMessage.itemType == 1) {
            this.j.setMarkDrawable(R$drawable.rating_fill_type_2, R$drawable.rating_empty_type_2);
        }
        this.j.setStarMark(((float) dMShareMessage.evaluateGrade) / 2.0f);
        if (!TextUtils.isEmpty(dMShareMessage.evaluateGradeDesc)) {
            this.k.setText(dMShareMessage.evaluateGradeDesc);
        } else {
            this.k.setText(jk.a((float) dMShareMessage.evaluateGrade));
        }
        this.l.setText(dMShareMessage.shareContent);
        if (!xf2.j(dMShareMessage.shareFooter)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = this.a.getString(R$string.share_evaluate_rank_prefix);
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.append(dMShareMessage.shareFooter);
            spannableStringBuilder.append("条评价📝");
            spannableStringBuilder.setSpan(new op(bn0.a(this.a)), string.length(), string.length() + dMShareMessage.shareFooter.length(), 17);
            this.t.setText(spannableStringBuilder);
        } else {
            this.t.setVisibility(8);
        }
        this.m.setImageBitmap(QrcodeUtil.a(v50.a(this.a, 60.0f), dMShareMessage.shareLink));
        if (dMShareMessage.itemType == 1) {
            this.u.setVisibility(8);
            DmInfo dmInfo = dMShareMessage.dmInfo;
            if (dmInfo != null) {
                this.w.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName, new b(onFinishListener));
                this.w.setDmTagData(dMShareMessage.dmInfo.dmTags);
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            this.v.setVisibility(0);
            this.v.bindData(dMShareMessage.storeInfo, new qe0(this, onFinishListener));
            return;
        }
        this.u.setVisibility(0);
        this.v.setVisibility(8);
        this.e.setText(dMShareMessage.shareTitle);
        if (!xf2.j(dMShareMessage.remarkValue)) {
            this.q.setText(dMShareMessage.remarkValue);
        } else {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder();
        if (!xf2.j(dMShareMessage.projectTime)) {
            this.s.setText(dMShareMessage.projectTime);
            sb.append("| ");
        } else {
            this.s.setVisibility(8);
        }
        if (!xf2.j(dMShareMessage.projectCity)) {
            sb.append(dMShareMessage.projectCity);
            this.r.setText(sb.toString());
        }
        this.w.setVisibility(8);
        cn.damai.common.image.a.b().h(this.a).c(dMShareMessage.sharePictureUrl).k(new DMRoundedCornersBitmapProcessor(v50.a(this.a, 6.0f), 0)).n(new d(onFinishListener)).e(new c(onFinishListener)).f();
    }
}
