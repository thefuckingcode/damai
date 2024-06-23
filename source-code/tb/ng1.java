package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.share.inf.OnFinishListener;
import cn.damai.uikit.view.HoleCardView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ng1 extends g1<DMShareMessage> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private final View b;
    @NotNull
    private final ScrollView c;
    @NotNull
    private final HoleCardView d;
    @NotNull
    private final ImageView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final ImageView g;
    @NotNull
    private final TextView h;
    @NotNull
    private final TextView i;
    @NotNull
    private final ImageView j;

    public ng1(@NotNull Context context) {
        k21.i(context, "mContext");
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_generate_nft_card_image, (ViewGroup) null);
        k21.h(inflate, "from(mContext).inflate(R…ate_nft_card_image, null)");
        this.b = inflate;
        View findViewById = inflate.findViewById(R$id.share_page);
        k21.h(findViewById, "rootView.findViewById(R.id.share_page)");
        this.c = (ScrollView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.hv_container);
        k21.h(findViewById2, "rootView.findViewById(R.id.hv_container)");
        HoleCardView holeCardView = (HoleCardView) findViewById2;
        this.d = holeCardView;
        View findViewById3 = inflate.findViewById(R$id.iv_cover);
        k21.h(findViewById3, "rootView.findViewById(R.id.iv_cover)");
        this.e = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R$id.tv_title);
        k21.h(findViewById4, "rootView.findViewById(R.id.tv_title)");
        this.f = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R$id.iv_nft_back_rim);
        k21.h(findViewById5, "rootView.findViewById(R.id.iv_nft_back_rim)");
        this.g = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R$id.tv_user_name);
        k21.h(findViewById6, "rootView.findViewById(R.id.tv_user_name)");
        this.h = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R$id.tv_yc_code);
        k21.h(findViewById7, "rootView.findViewById(R.id.tv_yc_code)");
        this.i = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R$id.iv_qrcode_img);
        k21.h(findViewById8, "rootView.findViewById(R.id.iv_qrcode_img)");
        this.j = (ImageView) findViewById8;
        holeCardView.setmScallopPositionPx(s50.a(context, 175.0f));
    }

    /* access modifiers changed from: private */
    public static final void f(OnFinishListener onFinishListener, ng1 ng1, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407685058")) {
            ipChange.ipc$dispatch("-1407685058", new Object[]{onFinishListener, ng1, eVar});
            return;
        }
        k21.i(ng1, "this$0");
        Bitmap bitmap = eVar.b;
        if (bitmap != null) {
            ng1.e.setImageBitmap(bitmap);
        }
        if (onFinishListener != null) {
            onFinishListener.onViewUpdateSuccess();
        }
    }

    /* access modifiers changed from: private */
    public static final void g(ng1 ng1, OnFinishListener onFinishListener, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631378174")) {
            ipChange.ipc$dispatch("1631378174", new Object[]{ng1, onFinishListener, dVar});
            return;
        }
        k21.i(ng1, "this$0");
        ToastUtil.a().e(ng1.a, "图片生成失败");
        if (onFinishListener != null) {
            onFinishListener.onViewUpdateSuccess();
        }
    }

    @NotNull
    public final View c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2024288634")) {
            return this.b;
        }
        return (View) ipChange.ipc$dispatch("-2024288634", new Object[]{this});
    }

    @NotNull
    public final ScrollView d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-565194878")) {
            return this.c;
        }
        return (ScrollView) ipChange.ipc$dispatch("-565194878", new Object[]{this});
    }

    public void e(@Nullable DMShareMessage dMShareMessage, @Nullable OnFinishListener onFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818136830")) {
            ipChange.ipc$dispatch("1818136830", new Object[]{this, dMShareMessage, onFinishListener});
        } else if (dMShareMessage != null) {
            this.h.setText(dMShareMessage.userNick);
            this.f.setText(dMShareMessage.shareTitle);
            this.i.setText(dMShareMessage.ycCode);
            if (dMShareMessage.vip) {
                this.g.setImageResource(R$drawable.ticket_nft_back_rim_vip);
            } else {
                this.g.setImageResource(R$drawable.ticket_nft_back_rim);
            }
            int a2 = s50.a(this.a, 70.0f);
            this.j.setImageBitmap(QrcodeUtil.a(a2, GenerateImageUtil.SHARE_URL + URLEncoder.encode(dMShareMessage.shareLink)));
            a.b().h(this.a).c(dMShareMessage.sharePictureUrl).n(new mg1(onFinishListener, this)).e(new lg1(this, onFinishListener)).f();
        }
    }
}
