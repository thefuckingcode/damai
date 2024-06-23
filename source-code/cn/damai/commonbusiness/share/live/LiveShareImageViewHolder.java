package cn.damai.commonbusiness.share.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.comment.view.DMTagView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$dimen;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.evaluate.EvaluateScriptMurderShopView;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import tb.a81;
import tb.b81;
import tb.c81;
import tb.d81;
import tb.s50;
import tb.s71;
import tb.ur2;
import tb.x71;
import tb.xf2;
import tb.y71;
import tb.z71;

/* compiled from: Taobao */
public class LiveShareImageViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    public ScrollView b;
    private View c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private ConstraintLayout g;
    private DMAvatar h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private View m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ConstraintLayout t;
    private View u;
    private View v;
    private LiveArtistView[] w;
    private EvaluateScriptMurderShopView x;
    private DMTagView y;
    private int z;

    /* compiled from: Taobao */
    public interface IFinishCallBack {
        void onFinish();
    }

    /* compiled from: Taobao */
    public class a implements DMAvatar.OnImageLoadListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ IFinishCallBack b;

        a(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack) {
            this.a = atomicInteger;
            this.b = iFinishCallBack;
        }

        @Override // com.alibaba.pictures.bricks.view.DMAvatar.OnImageLoadListener
        public void onImageLoadFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "583507749")) {
                ipChange.ipc$dispatch("583507749", new Object[]{this});
                return;
            }
            LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
        }

        @Override // com.alibaba.pictures.bricks.view.DMAvatar.OnImageLoadListener
        public void onImageLoadSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1186803188")) {
                ipChange.ipc$dispatch("-1186803188", new Object[]{this});
                return;
            }
            LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
        }
    }

    /* compiled from: Taobao */
    public class b implements Function0<ur2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ IFinishCallBack b;

        b(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack) {
            this.a = atomicInteger;
            this.b = iFinishCallBack;
        }

        /* renamed from: a */
        public ur2 invoke() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1881156373")) {
                return (ur2) ipChange.ipc$dispatch("1881156373", new Object[]{this});
            }
            LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
            return null;
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ IFinishCallBack b;

        c(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack) {
            this.a = atomicInteger;
            this.b = iFinishCallBack;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2089033990")) {
                ipChange.ipc$dispatch("2089033990", new Object[]{this, eVar});
                return;
            }
            LiveShareImageViewHolder.this.i(this.a.incrementAndGet(), this.b);
        }
    }

    public LiveShareImageViewHolder(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_generate_live_share_image, (ViewGroup) null);
        this.a = context;
        this.t = (ConstraintLayout) inflate.findViewById(R$id.multi_image_container);
        this.s = (ImageView) inflate.findViewById(R$id.multi_image_three);
        this.r = (ImageView) inflate.findViewById(R$id.multi_image_two);
        this.q = (ImageView) inflate.findViewById(R$id.multi_image_one);
        this.p = (ImageView) inflate.findViewById(R$id.share_qrcode);
        this.o = (TextView) inflate.findViewById(R$id.project_info);
        this.n = (TextView) inflate.findViewById(R$id.project_title);
        this.l = (ImageView) inflate.findViewById(R$id.project_image);
        this.m = inflate.findViewById(R$id.project_image_container);
        this.k = (TextView) inflate.findViewById(R$id.note_text);
        this.j = (TextView) inflate.findViewById(R$id.user_title_sub);
        this.i = (TextView) inflate.findViewById(R$id.user_title);
        this.h = (cn.damai.uikit.view.DMAvatar) inflate.findViewById(R$id.iv_account_image);
        this.g = (ConstraintLayout) inflate.findViewById(R$id.note_container);
        this.f = (ImageView) inflate.findViewById(R$id.image_count_label_icon);
        this.e = (TextView) inflate.findViewById(R$id.image_count);
        this.d = (ImageView) inflate.findViewById(R$id.single_image);
        this.c = inflate.findViewById(R$id.image_container);
        this.b = (ScrollView) inflate.findViewById(R$id.share_page);
        this.u = inflate.findViewById(R$id.dm_line_5);
        this.v = inflate.findViewById(R$id.live_share_artist_container);
        this.w = new LiveArtistView[]{(LiveArtistView) inflate.findViewById(R$id.live_share_artist_left), (LiveArtistView) inflate.findViewById(R$id.live_share_artist_right)};
        this.x = (EvaluateScriptMurderShopView) inflate.findViewById(R$id.script_murder_shop);
        this.y = (DMTagView) inflate.findViewById(R$id.dm_info);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void i(int i2, IFinishCallBack iFinishCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369245038")) {
            ipChange.ipc$dispatch("-369245038", new Object[]{this, Integer.valueOf(i2), iFinishCallBack});
            return;
        }
        if (i2 == this.z) {
            iFinishCallBack.onFinish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226719105")) {
            ipChange.ipc$dispatch("-1226719105", new Object[]{this, atomicInteger, iFinishCallBack, dVar});
            return;
        }
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886847775")) {
            ipChange.ipc$dispatch("1886847775", new Object[]{this, atomicInteger, iFinishCallBack, eVar});
            return;
        }
        this.d.setImageBitmap(eVar.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896618336")) {
            ipChange.ipc$dispatch("1896618336", new Object[]{this, atomicInteger, iFinishCallBack, eVar});
            return;
        }
        this.q.setImageBitmap(eVar.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906388897")) {
            ipChange.ipc$dispatch("1906388897", new Object[]{this, atomicInteger, iFinishCallBack, eVar});
            return;
        }
        this.r.setImageBitmap(eVar.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916159458")) {
            ipChange.ipc$dispatch("1916159458", new Object[]{this, atomicInteger, iFinishCallBack, eVar});
            return;
        }
        this.s.setImageBitmap(eVar.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ur2 o(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610649373")) {
            return (ur2) ipChange.ipc$dispatch("1610649373", new Object[]{this, atomicInteger, iFinishCallBack, drawable});
        }
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(AtomicInteger atomicInteger, IFinishCallBack iFinishCallBack, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1935700580")) {
            ipChange.ipc$dispatch("1935700580", new Object[]{this, atomicInteger, iFinishCallBack, eVar});
            return;
        }
        this.l.setImageBitmap(eVar.b);
        i(atomicInteger.incrementAndGet(), iFinishCallBack);
    }

    public void q(LiveShareImageBean liveShareImageBean, IFinishCallBack iFinishCallBack) {
        StoreInfo storeInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471894375")) {
            ipChange.ipc$dispatch("-471894375", new Object[]{this, liveShareImageBean, iFinishCallBack});
        } else if (liveShareImageBean != null) {
            cn.damai.common.image.a h2 = cn.damai.common.image.a.b().h(this.a);
            AtomicInteger atomicInteger = new AtomicInteger(0);
            int imageCount = liveShareImageBean.getImageCount();
            x71 x71 = new x71(this, atomicInteger, iFinishCallBack);
            int size = (!xf2.j(liveShareImageBean.mProjectImage) || (liveShareImageBean.itemType == 1 && (storeInfo = liveShareImageBean.storeInfo) != null && !TextUtils.isEmpty(storeInfo.getStoreImgUrl()))) ? 1 : !s71.a(liveShareImageBean.mArtistList) ? liveShareImageBean.mArtistList.size() > 2 ? 2 : liveShareImageBean.mArtistList.size() : 0;
            if (liveShareImageBean.itemType == 1 && liveShareImageBean.dmInfo != null) {
                size++;
            }
            if (imageCount == 0) {
                this.z = size + 1;
                this.f.setVisibility(8);
                this.e.setVisibility(8);
                this.c.setVisibility(8);
                this.g.setBackgroundResource(R$drawable.bg_generate_live_share_image_note_full_corner);
                ConstraintLayout constraintLayout = this.g;
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), this.a.getResources().getDimensionPixelOffset(R$dimen.live_share_image_note_padding_top), this.g.getPaddingRight(), this.g.getPaddingBottom());
            } else {
                this.f.setVisibility(0);
                this.e.setVisibility(0);
                TextView textView = this.e;
                textView.setText("" + imageCount);
                this.c.setVisibility(0);
                if (imageCount < 3) {
                    this.z = size + 2;
                    h2.c(liveShareImageBean.mLivePicList.get(0)).n(new a81(this, atomicInteger, iFinishCallBack)).e(x71).f();
                    this.d.setVisibility(0);
                    this.t.setVisibility(8);
                } else {
                    this.z = size + 4;
                    h2.c(liveShareImageBean.mLivePicList.get(0)).n(new c81(this, atomicInteger, iFinishCallBack)).e(x71).f();
                    h2.c(liveShareImageBean.mLivePicList.get(1)).n(new b81(this, atomicInteger, iFinishCallBack)).e(x71).f();
                    h2.c(liveShareImageBean.mLivePicList.get(2)).n(new y71(this, atomicInteger, iFinishCallBack)).e(x71).f();
                    this.d.setVisibility(8);
                    this.t.setVisibility(0);
                }
            }
            if (!TextUtils.isEmpty(liveShareImageBean.mShareQrcode)) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.a.getResources(), R$drawable.damai_small_logo);
                this.p.setImageBitmap(QrcodeUtil.b(s50.a(this.a, 70.0f), GenerateImageUtil.SHARE_URL + URLEncoder.encode(liveShareImageBean.mShareQrcode), decodeResource));
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            this.i.setText(liveShareImageBean.mUserTitle);
            this.j.setText(liveShareImageBean.mUserTitleSub);
            this.k.setText(liveShareImageBean.mNoteText);
            this.h.setAvatarBorderVisibility(liveShareImageBean.mIsVip ? 0 : 8);
            this.h.setAvatarCrownVisibility(liveShareImageBean.mIsVip ? 0 : 8);
            this.h.setOnImageLoadListener(new a(atomicInteger, iFinishCallBack));
            this.h.setAvatar(liveShareImageBean.mIvAccountImage);
            if (liveShareImageBean.itemType != 1 || liveShareImageBean.storeInfo == null) {
                this.y.setVisibility(8);
                if (!xf2.j(liveShareImageBean.mProjectImage)) {
                    this.x.setVisibility(8);
                    this.u.setVisibility(0);
                    this.m.setVisibility(0);
                    this.n.setVisibility(0);
                    this.o.setVisibility(0);
                    this.n.setText(liveShareImageBean.mProjectTitle);
                    this.o.setText(liveShareImageBean.mProjectInfo);
                    h2.c(liveShareImageBean.mProjectImage).n(new z71(this, atomicInteger, iFinishCallBack)).e(x71).f();
                }
                if (!s71.a(liveShareImageBean.mArtistList)) {
                    this.u.setVisibility(0);
                    this.v.setVisibility(0);
                    int size2 = liveShareImageBean.mArtistList.size();
                    if (size2 > 2) {
                        size2 = 2;
                    }
                    if (size2 < 2) {
                        this.w[1].setVisibility(8);
                    }
                    for (int i2 = 0; i2 < size2; i2++) {
                        try {
                            this.w[i2].setVisibility(0);
                            this.w[i2].handleView(liveShareImageBean.mArtistList.get(i2), new c(atomicInteger, iFinishCallBack), x71);
                        } catch (IndexOutOfBoundsException unused) {
                            this.w[i2].setVisibility(8);
                        }
                    }
                    return;
                }
                return;
            }
            DmInfo dmInfo = liveShareImageBean.dmInfo;
            if (dmInfo != null) {
                this.y.setDmBaseData(dmInfo.dmHeadImageUrl, dmInfo.dmName, new b(atomicInteger, iFinishCallBack));
                this.y.setDmTagData(liveShareImageBean.dmInfo.dmTags);
                this.y.setVisibility(0);
            } else {
                this.y.setVisibility(8);
            }
            this.x.setVisibility(0);
            this.u.setVisibility(0);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.x.getShopNameTv().setTextColor(-16777216);
            this.x.getShopNameTv().setTextSize(1, 14.0f);
            this.x.getShopSubTitleTv().setTextColor(this.a.getResources().getColor(R$color.color_9C9CA5));
            this.x.bindData(liveShareImageBean.storeInfo, new d81(this, atomicInteger, iFinishCallBack));
        }
    }
}
