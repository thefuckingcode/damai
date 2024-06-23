package com.opensource.svgaplayer;

import android.os.Handler;
import com.opensource.svgaplayer.SVGAParser;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGAParser$parse$5 implements Runnable {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ SVGAParser.ParseCompletion $callback;
    final /* synthetic */ boolean $closeInputStream;
    final /* synthetic */ InputStream $inputStream;
    final /* synthetic */ SVGAParser this$0;

    SVGAParser$parse$5(SVGAParser sVGAParser, InputStream inputStream, String str, boolean z, SVGAParser.ParseCompletion parseCompletion) {
        this.this$0 = sVGAParser;
        this.$inputStream = inputStream;
        this.$cacheKey = str;
        this.$closeInputStream = z;
        this.$callback = parseCompletion;
    }

    public final void run() {
        final SVGAVideoEntity sVGAVideoEntity = this.this$0.h(this.$inputStream, this.$cacheKey);
        if (this.$closeInputStream) {
            this.$inputStream.close();
        }
        if (sVGAVideoEntity != null) {
            sVGAVideoEntity.i(new Function0<ur2>(this) {
                /* class com.opensource.svgaplayer.SVGAParser$parse$5.AnonymousClass1 */
                final /* synthetic */ SVGAParser$parse$5 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    new Handler(this.this$0.this$0.b.getMainLooper()).post(new Runnable(this) {
                        /* class com.opensource.svgaplayer.SVGAParser$parse$5.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void run() {
                            AnonymousClass1 r0 = this.this$0;
                            r0.this$0.$callback.onComplete(sVGAVideoEntity);
                        }
                    });
                }
            });
        } else {
            new Handler(this.this$0.b.getMainLooper()).post(new Runnable(this) {
                /* class com.opensource.svgaplayer.SVGAParser$parse$5.AnonymousClass2 */
                final /* synthetic */ SVGAParser$parse$5 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    this.this$0.$callback.onError();
                }
            });
        }
    }
}
