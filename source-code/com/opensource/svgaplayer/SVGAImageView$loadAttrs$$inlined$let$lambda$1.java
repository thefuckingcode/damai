package com.opensource.svgaplayer;

import android.os.Handler;
import com.opensource.svgaplayer.SVGAParser;
import java.net.URL;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
final class SVGAImageView$loadAttrs$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ boolean $antiAlias$inlined;
    final /* synthetic */ boolean $autoPlay$inlined;
    final /* synthetic */ String $it;
    final /* synthetic */ SVGAParser $parser;
    final /* synthetic */ SVGAImageView this$0;

    SVGAImageView$loadAttrs$$inlined$let$lambda$1(String str, SVGAParser sVGAParser, SVGAImageView sVGAImageView, boolean z, boolean z2) {
        this.$it = str;
        this.$parser = sVGAParser;
        this.this$0 = sVGAImageView;
        this.$antiAlias$inlined = z;
        this.$autoPlay$inlined = z2;
    }

    public final void run() {
        AnonymousClass1 r0 = new SVGAParser.ParseCompletion(this) {
            /* class com.opensource.svgaplayer.SVGAImageView$loadAttrs$$inlined$let$lambda$1.AnonymousClass1 */
            final /* synthetic */ SVGAImageView$loadAttrs$$inlined$let$lambda$1 a;

            {
                this.a = r1;
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(@NotNull final SVGAVideoEntity sVGAVideoEntity) {
                k21.j(sVGAVideoEntity, "videoItem");
                Handler handler = this.a.this$0.getHandler();
                if (handler != null) {
                    handler.post(new Runnable(this) {
                        /* class com.opensource.svgaplayer.SVGAImageView$loadAttrs$$inlined$let$lambda$1.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void run() {
                            sVGAVideoEntity.o(this.this$0.a.$antiAlias$inlined);
                            this.this$0.a.this$0.setVideoItem(sVGAVideoEntity);
                            SVGAImageView$loadAttrs$$inlined$let$lambda$1 sVGAImageView$loadAttrs$$inlined$let$lambda$1 = this.this$0.a;
                            if (sVGAImageView$loadAttrs$$inlined$let$lambda$1.$autoPlay$inlined) {
                                sVGAImageView$loadAttrs$$inlined$let$lambda$1.this$0.startAnimation();
                            }
                        }
                    });
                }
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        };
        if ((o.L(this.$it, "http://", false, 2, null)) || (o.L(this.$it, "https://", false, 2, null))) {
            this.$parser.k(new URL(this.$it), r0);
        } else {
            this.$parser.j(this.$it, r0);
        }
    }
}
