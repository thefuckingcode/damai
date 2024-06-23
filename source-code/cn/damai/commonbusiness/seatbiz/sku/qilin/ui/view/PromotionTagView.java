package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class PromotionTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String HALF_PRICE = "1004";
    @NotNull
    public static final String VIP_BUY = "1005";
    @NotNull
    public static final String ZAO_NIAO = "1001";
    @NotNull
    private final ImageView imageTag;
    @Nullable
    private Tag mTag;
    @NotNull
    private final TextView textTag;
    @NotNull
    private final View vipTag;
    @NotNull
    private final TextView vipTagDes;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromotionTagView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromotionTagView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @NotNull
    public final View getCurrentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1454508940")) {
            return (View) ipChange.ipc$dispatch("1454508940", new Object[]{this});
        } else if (this.imageTag.getVisibility() == 0) {
            return this.imageTag;
        } else {
            if (this.vipTag.getVisibility() == 0) {
                return this.vipTag;
            }
            return this.textTag;
        }
    }

    @NotNull
    public final ImageView getImageTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1348425715")) {
            return this.imageTag;
        }
        return (ImageView) ipChange.ipc$dispatch("-1348425715", new Object[]{this});
    }

    @NotNull
    public final TextView getTextTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1352360175")) {
            return this.textTag;
        }
        return (TextView) ipChange.ipc$dispatch("1352360175", new Object[]{this});
    }

    @NotNull
    public final View getVipTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-382756249")) {
            return this.vipTag;
        }
        return (View) ipChange.ipc$dispatch("-382756249", new Object[]{this});
    }

    @NotNull
    public final TextView getVipTagDes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1024182841")) {
            return this.vipTagDes;
        }
        return (TextView) ipChange.ipc$dispatch("-1024182841", new Object[]{this});
    }

    public final void setTag(@Nullable Tag tag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1536418948")) {
            ipChange.ipc$dispatch("-1536418948", new Object[]{this, tag});
        } else if (tag != null) {
            this.mTag = tag;
            setVisibility(0);
            if (k21.d(tag.tag, HALF_PRICE)) {
                this.imageTag.setVisibility(0);
                this.vipTag.setVisibility(8);
                this.textTag.setVisibility(8);
            } else if (k21.d(tag.tag, VIP_BUY)) {
                this.vipTag.setVisibility(0);
                this.imageTag.setVisibility(8);
                this.textTag.setVisibility(8);
                this.vipTagDes.setText("专享购");
            } else if (!TextUtils.isEmpty(tag.tagDesc)) {
                this.textTag.setVisibility(0);
                this.imageTag.setVisibility(8);
                this.vipTag.setVisibility(8);
                this.textTag.setText(tag.tagDesc);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PromotionTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.sku_ncov_itembox_tag, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.layout_tag_text);
        k21.h(findViewById, "findViewById(R.id.layout_tag_text)");
        this.textTag = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.layout_tag_img);
        k21.h(findViewById2, "findViewById(R.id.layout_tag_img)");
        this.imageTag = (ImageView) findViewById2;
        View findViewById3 = findViewById(R$id.layout_tag_vip);
        k21.h(findViewById3, "findViewById(R.id.layout_tag_vip)");
        this.vipTag = findViewById3;
        View findViewById4 = findViewById(R$id.layout_tag_vip_des);
        k21.h(findViewById4, "findViewById(R.id.layout_tag_vip_des)");
        this.vipTagDes = (TextView) findViewById4;
    }
}
