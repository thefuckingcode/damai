package com.opensource.svgaplayer;

import android.os.Handler;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAParser;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/io/InputStream;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Ljava/io/InputStream;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGAParser$parse$3 extends Lambda implements Function1<InputStream, ur2> {
    final /* synthetic */ SVGAParser.ParseCompletion $callback;
    final /* synthetic */ URL $url;
    final /* synthetic */ SVGAParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SVGAParser$parse$3(SVGAParser sVGAParser, URL url, SVGAParser.ParseCompletion parseCompletion) {
        super(1);
        this.this$0 = sVGAParser;
        this.$url = url;
        this.$callback = parseCompletion;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(InputStream inputStream) {
        invoke(inputStream);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull InputStream inputStream) {
        k21.j(inputStream, AdvanceSetting.NETWORK_TYPE);
        SVGAParser sVGAParser = this.this$0;
        final SVGAVideoEntity sVGAVideoEntity = sVGAParser.h(inputStream, sVGAParser.f(this.$url));
        if (sVGAVideoEntity != null) {
            sVGAVideoEntity.i(new Function0<ur2>(this) {
                /* class com.opensource.svgaplayer.SVGAParser$parse$3.AnonymousClass1 */
                final /* synthetic */ SVGAParser$parse$3 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    new Handler(this.this$0.this$0.b.getMainLooper()).post(new Runnable(this) {
                        /* class com.opensource.svgaplayer.SVGAParser$parse$3.AnonymousClass1.AnonymousClass1 */
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
            return;
        }
        Boolean valueOf = Boolean.valueOf(new Handler(this.this$0.b.getMainLooper()).post(new SVGAParser$parse$3$videoItem$1(this)));
        if (!(valueOf instanceof ur2)) {
            valueOf = null;
        }
        if (((ur2) valueOf) == null) {
            ur2 ur2 = ur2.INSTANCE;
        }
    }
}
