package com.youku.gaiax.provider.module.views;

import android.widget.ImageView;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Landroid/widget/ImageView;", "imageView", "", "uri", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaXImageView$onBindData$1 extends Lambda implements Function2<ImageView, String, ur2> {
    final /* synthetic */ GaiaXImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXImageView$onBindData$1(GaiaXImageView gaiaXImageView) {
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
        if (this.this$0.getPlaceHolderResId() != null) {
            Integer placeHolderResId = this.this$0.getPlaceHolderResId();
            k21.f(placeHolderResId);
            int intValue = placeHolderResId.intValue();
            Integer placeHolderResId2 = this.this$0.getPlaceHolderResId();
            k21.f(placeHolderResId2);
            ImageLoaderProviderProxy.loadinto(str, imageView, intValue, placeHolderResId2.intValue());
            return;
        }
        ImageLoaderProviderProxy.loadinto(str, imageView);
    }
}
