package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
final class SVGADynamicEntity$setDynamicImage$1$$special$$inlined$let$lambda$2 implements Runnable {
    final /* synthetic */ Bitmap $it;
    final /* synthetic */ SVGADynamicEntity$setDynamicImage$1 this$0;

    SVGADynamicEntity$setDynamicImage$1$$special$$inlined$let$lambda$2(Bitmap bitmap, SVGADynamicEntity$setDynamicImage$1 sVGADynamicEntity$setDynamicImage$1) {
        this.$it = bitmap;
        this.this$0 = sVGADynamicEntity$setDynamicImage$1;
    }

    public final void run() {
        SVGADynamicEntity$setDynamicImage$1 sVGADynamicEntity$setDynamicImage$1 = this.this$0;
        sVGADynamicEntity$setDynamicImage$1.this$0.h(this.$it, sVGADynamicEntity$setDynamicImage$1.$forKey);
    }
}
