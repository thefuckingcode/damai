package com.alibaba.pictures.uploader;

import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.a;
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
import tb.qs2;
import tb.ss2;
import tb.ur2;
import tb.us2;
import tb.vs2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/alibaba/pictures/uploader/FileUploader$uploadGroup$1$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.alibaba.pictures.uploader.FileUploader$uploadGroup$1$2$1", f = "FileUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CoroutineScope $this_launch$inlined;
    final /* synthetic */ us2 $uploadTask;
    int label;
    final /* synthetic */ FileUploader$uploadGroup$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1(us2 us2, Continuation continuation, FileUploader$uploadGroup$1 fileUploader$uploadGroup$1, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.$uploadTask = us2;
        this.this$0 = fileUploader$uploadGroup$1;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315361343")) {
            return (Continuation) ipChange.ipc$dispatch("-315361343", new Object[]{this, obj, continuation});
        }
        k21.i(continuation, "completion");
        return new FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1(this.$uploadTask, continuation, this.this$0, this.$this_launch$inlined);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ur2> continuation) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "477984573")) {
            return ((FileUploader$uploadGroup$1$invokeSuspend$$inlined$forEach$lambda$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
        }
        return ipChange.ipc$dispatch("477984573", new Object[]{this, coroutineScope, continuation});
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069884741")) {
            return ipChange.ipc$dispatch("2069884741", new Object[]{this, obj});
        }
        Object unused = b.d();
        if (this.label == 0) {
            k12.b(obj);
            String str = null;
            this.$uploadTask.a().e(qs2.a(this.$uploadTask.a().a(), null));
            if (k21.d(this.this$0.this$0.h, qc.a(true))) {
                FileUploader.a aVar = FileUploader.Companion;
                if (aVar.f() != null) {
                    aVar.h("startUpLoadGroup---处理压缩原链接：" + this.$uploadTask.a().a() + "，要压缩链接=" + this.$uploadTask.a().a() + '+' + System.currentTimeMillis());
                    ss2 a = this.$uploadTask.a();
                    IImageCompressor f = aVar.f();
                    if (f != null) {
                        str = f.compress(this.$uploadTask.a().a(), this.this$0.this$0.i);
                    }
                    a.e(str);
                    this.$uploadTask.a().k(UploadStatus.RESIZE);
                    aVar.h("startUpLoadGroup---处理压缩完成=" + this.$uploadTask.a().a() + '+' + System.currentTimeMillis());
                }
            }
            us2 us2 = this.$uploadTask;
            FileUploader.a aVar2 = FileUploader.Companion;
            aVar2.h("startUpLoadGroup---ARUS-uploadAsync=" + this.$uploadTask.a().a() + '+' + System.currentTimeMillis());
            a.a().uploadAsync(us2, new vs2(this.this$0.this$0), this.this$0.this$0.j);
            return ur2.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
