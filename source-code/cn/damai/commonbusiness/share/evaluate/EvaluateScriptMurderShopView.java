package cn.damai.commonbusiness.share.evaluate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.image.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g91;
import tb.k21;
import tb.m40;
import tb.oe0;
import tb.pe0;
import tb.ur2;
import tb.v50;

/* compiled from: Taobao */
public final class EvaluateScriptMurderShopView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView shopNameTv;
    private final DMPosterView shopPoster;
    private final TextView shopSubTitleTv;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EvaluateScriptMurderShopView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EvaluateScriptMurderShopView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m13bindData$lambda0(EvaluateScriptMurderShopView evaluateScriptMurderShopView, Function1 function1, DMImageCreator.e eVar) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660549692")) {
            ipChange.ipc$dispatch("1660549692", new Object[]{evaluateScriptMurderShopView, function1, eVar});
            return;
        }
        k21.i(evaluateScriptMurderShopView, "this$0");
        k21.i(function1, "$callback");
        Bitmap bitmap = eVar.b;
        if (bitmap == null) {
            g91.a("bitmap is null");
            ToastUtil.a().e(evaluateScriptMurderShopView.getContext(), "图片生成失败");
            function1.invoke(null);
            return;
        }
        evaluateScriptMurderShopView.shopPoster.setImageBitmap(bitmap);
        try {
            i = DMRGBUtil.f(bitmap);
        } catch (Exception unused) {
            i = Color.parseColor(Bitmap12ColorHex.C_HEX_7176D4);
        }
        function1.invoke(new ColorDrawable(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-1  reason: not valid java name */
    public static final void m14bindData$lambda1(EvaluateScriptMurderShopView evaluateScriptMurderShopView, Function1 function1, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122872606")) {
            ipChange.ipc$dispatch("-122872606", new Object[]{evaluateScriptMurderShopView, function1, dVar});
            return;
        }
        k21.i(evaluateScriptMurderShopView, "this$0");
        k21.i(function1, "$callback");
        evaluateScriptMurderShopView.shopPoster.setImageDrawable(evaluateScriptMurderShopView.getContext().getResources().getDrawable(R$drawable.store_defult_img));
        ToastUtil.a().e(evaluateScriptMurderShopView.getContext(), "图片生成失败");
        function1.invoke(null);
    }

    public final void bindData(@Nullable StoreInfo storeInfo, @NotNull Function1<? super Drawable, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566248301")) {
            ipChange.ipc$dispatch("-1566248301", new Object[]{this, storeInfo, function1});
            return;
        }
        k21.i(function1, WXBridgeManager.METHOD_CALLBACK);
        if (storeInfo == null) {
            function1.invoke(null);
            return;
        }
        this.shopNameTv.setText(storeInfo.getStoreName());
        this.shopSubTitleTv.setText(storeInfo.getDes());
        a.b().h(getContext()).c(storeInfo.getStoreImgUrl()).k(new DMRoundedCornersBitmapProcessor(v50.a(getContext(), 6.0f), 0)).n(new pe0(this, function1)).e(new oe0(this, function1)).f();
    }

    public final TextView getShopNameTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2080237819")) {
            return this.shopNameTv;
        }
        return (TextView) ipChange.ipc$dispatch("-2080237819", new Object[]{this});
    }

    public final DMPosterView getShopPoster() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1934051081")) {
            return this.shopPoster;
        }
        return (DMPosterView) ipChange.ipc$dispatch("-1934051081", new Object[]{this});
    }

    public final TextView getShopSubTitleTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1049793480")) {
            return this.shopSubTitleTv;
        }
        return (TextView) ipChange.ipc$dispatch("-1049793480", new Object[]{this});
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EvaluateScriptMurderShopView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.view_generate_evaluate_script_kill_shop_info, (ViewGroup) this, true);
        this.shopNameTv = (TextView) findViewById(R$id.script_share_page_title);
        this.shopPoster = (DMPosterView) findViewById(R$id.script_share_page_poster);
        this.shopSubTitleTv = (TextView) findViewById(R$id.script_share_page_subtitle);
    }
}
