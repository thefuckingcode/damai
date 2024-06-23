package com.alibaba.pictures.uploader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.sh0;
import tb.ss2;
import tb.ur2;
import tb.us2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.uploader.FileUploader$uploadGroup$1", f = "FileUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class FileUploader$uploadGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ List $filePathGroup;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileUploader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileUploader$uploadGroup$1(FileUploader fileUploader, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fileUploader;
        this.$filePathGroup = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562779912")) {
            return (Continuation) ipChange.ipc$dispatch("562779912", new Object[]{this, obj, continuation});
        }
        k21.i(continuation, "completion");
        FileUploader$uploadGroup$1 fileUploader$uploadGroup$1 = new FileUploader$uploadGroup$1(this.this$0, this.$filePathGroup, continuation);
        fileUploader$uploadGroup$1.L$0 = obj;
        return fileUploader$uploadGroup$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ur2> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-436291836")) {
            return ((FileUploader$uploadGroup$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
        }
        return ipChange.ipc$dispatch("-436291836", new Object[]{this, coroutineScope, continuation});
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-364329506")) {
            return ipChange.ipc$dispatch("-364329506", new Object[]{this, obj});
        }
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            for (String str : this.$filePathGroup) {
                ss2 ss2 = new ss2();
                ss2.k(UploadStatus.INIT);
                ss2.h(str);
                ss2.e(sh0.INSTANCE.a(FileUploader.Companion.b(), str));
                ss2.g(0);
                this.this$0.b.add(new us2(ss2, this.this$0.r()));
                this.this$0.a.add(ss2);
            }
            for (us2 us2 : this.this$0.b) {
                Job unused2 = f.b(coroutineScope, null, null, new FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1(us2, null, this, coroutineScope), 3, null);
            }
            FileUploader.Companion.h("任务开启完毕！");
            return ur2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
