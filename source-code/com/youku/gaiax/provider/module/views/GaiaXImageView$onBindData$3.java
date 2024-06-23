package com.youku.gaiax.provider.module.views;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Landroid/widget/ImageView;", "imageView", "", "uri", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaXImageView$onBindData$3 extends Lambda implements Function2<ImageView, String, ur2> {
    final /* synthetic */ GaiaXImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXImageView$onBindData$3(GaiaXImageView gaiaXImageView) {
        super(2);
        this.this$0 = gaiaXImageView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ur2 invoke(ImageView imageView, String str) {
        invoke(imageView, str);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull ImageView imageView, @NotNull String str) {
        k21.i(imageView, "imageView");
        k21.i(str, "uri");
        String str2 = null;
        String str3 = o.L(str, GaiaXImageView.GAIAX_RES_PREFIX, false, 2, null) ? str : null;
        if (str3 != null) {
            this.this$0.dispatchRes(imageView, o.F(str, GaiaXImageView.GAIAX_RES_PREFIX, "", false, 4, null));
            str2 = str3;
        }
        if (str2 == null) {
            this.this$0.dispatchRes(imageView, str);
        }
    }
}
