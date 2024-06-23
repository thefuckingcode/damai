package com.opensource.svgaplayer;

import android.os.Handler;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Ljava/lang/Exception;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGAParser$parse$4 extends Lambda implements Function1<Exception, ur2> {
    final /* synthetic */ SVGAParser.ParseCompletion $callback;
    final /* synthetic */ SVGAParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SVGAParser$parse$4(SVGAParser sVGAParser, SVGAParser.ParseCompletion parseCompletion) {
        super(1);
        this.this$0 = sVGAParser;
        this.$callback = parseCompletion;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Exception exc) {
        invoke(exc);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull Exception exc) {
        k21.j(exc, AdvanceSetting.NETWORK_TYPE);
        new Handler(this.this$0.b.getMainLooper()).post(new Runnable(this) {
            /* class com.opensource.svgaplayer.SVGAParser$parse$4.AnonymousClass1 */
            final /* synthetic */ SVGAParser$parse$4 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.$callback.onError();
            }
        });
    }
}
