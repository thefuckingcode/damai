package com.alibaba.pictures.share.weiboshare;

import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.openapi.IWBAPI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.qc;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.share.weiboshare.WeiboShareActivity$sendMultiMessage$1", f = "WeiboShareActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class WeiboShareActivity$sendMultiMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    int label;
    final /* synthetic */ WeiboShareActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WeiboShareActivity$sendMultiMessage$1(WeiboShareActivity weiboShareActivity, Continuation continuation) {
        super(2, continuation);
        this.this$0 = weiboShareActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883809383")) {
            return (Continuation) ipChange.ipc$dispatch("883809383", new Object[]{this, obj, continuation});
        }
        k21.i(continuation, "completion");
        return new WeiboShareActivity$sendMultiMessage$1(this.this$0, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ur2> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-557272861")) {
            return ((WeiboShareActivity$sendMultiMessage$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
        }
        return ipChange.ipc$dispatch("-557272861", new Object[]{this, coroutineScope, continuation});
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525137057")) {
            return ipChange.ipc$dispatch("-1525137057", new Object[]{this, obj});
        }
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            ShareContent shareContent = this.this$0.shareParams;
            Integer b = shareContent != null ? qc.b(shareContent.getShareType()) : null;
            if ((b != null && b.intValue() == 3) || (b != null && b.intValue() == 2)) {
                weiboMultiMessage.imageObject = this.this$0.getImageObj();
                WeiboShareActivity weiboShareActivity = this.this$0;
                if (weiboShareActivity.checkBitmap(weiboShareActivity.shareBmp)) {
                    this.this$0.finish();
                    return ur2.INSTANCE;
                }
                weiboMultiMessage.mediaObject = this.this$0.getWebpageObj();
                weiboMultiMessage.textObject = this.this$0.getTextObj();
            } else if (b != null && b.intValue() == 1) {
                weiboMultiMessage.imageObject = this.this$0.getImageObj();
                WeiboShareActivity weiboShareActivity2 = this.this$0;
                if (weiboShareActivity2.checkBitmap(weiboShareActivity2.shareBmp)) {
                    this.this$0.finish();
                    return ur2.INSTANCE;
                }
                weiboMultiMessage.textObject = this.this$0.getTextObj();
            } else if (b != null && b.intValue() == 0) {
                weiboMultiMessage.textObject = this.this$0.getTextObj();
            }
            IWBAPI c = ShareManager.INSTANCE.c();
            if (c != null) {
                c.shareMessage(this.this$0, weiboMultiMessage, false);
            }
            this.this$0.finish();
            return ur2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
