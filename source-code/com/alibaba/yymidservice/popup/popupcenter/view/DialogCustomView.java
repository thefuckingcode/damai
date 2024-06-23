package com.alibaba.yymidservice.popup.popupcenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/alibaba/yymidservice/popup/popupcenter/view/DialogCustomView;", "Landroid/widget/FrameLayout;", "Lcom/alibaba/yymidservice/popup/popupcenter/view/DialogViewCallBack;", "Lcom/alibaba/yymidservice/popup/request/bean/PopupDetailBean;", "showItem", "Ltb/ur2;", "bindData", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class DialogCustomView extends FrameLayout implements DialogViewCallBack {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DialogCustomView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DialogCustomView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogCustomView(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.view.DialogViewCallBack
    public void bindData(@NotNull PopupDetailBean popupDetailBean) {
        k21.i(popupDetailBean, "showItem");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DialogCustomView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
