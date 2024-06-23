package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGAParser$parse$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ SVGAParser.ParseCompletion $callback$inlined;
    final /* synthetic */ SVGAVideoEntity $it;
    final /* synthetic */ SVGAParser this$0;

    SVGAParser$parse$$inlined$let$lambda$1(SVGAVideoEntity sVGAVideoEntity, SVGAParser sVGAParser, SVGAParser.ParseCompletion parseCompletion) {
        this.$it = sVGAVideoEntity;
        this.this$0 = sVGAParser;
        this.$callback$inlined = parseCompletion;
    }

    public final void run() {
        this.$callback$inlined.onComplete(this.$it);
    }
}
