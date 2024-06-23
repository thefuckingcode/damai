package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.s82;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ltb/s82;", "Landroid/view/View;", "Ltb/ur2;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {97, 99}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: Taobao */
public final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<s82<? super View>, Continuation<? super ur2>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewGroupKt$descendants$1(ViewGroup viewGroup, Continuation continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        k21.i(continuation, "completion");
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, continuation);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(s82<? super View> s82, Continuation<? super ur2> continuation) {
        return ((ViewGroupKt$descendants$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        s82 s82;
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1;
        int i;
        int i2;
        ViewGroup viewGroup;
        ViewGroupKt$descendants$1 viewGroupKt$descendants$12;
        s82 s822;
        ViewGroup viewGroup2;
        int i3;
        s82 s823;
        ViewGroup viewGroup3;
        View view;
        Sequence<View> descendants;
        Object obj2 = b.d();
        int i4 = this.label;
        if (i4 == 0) {
            k12.b(obj);
            s82 = (s82) this.L$0;
            viewGroup = this.$this_descendants;
            i2 = 0;
            i = viewGroup.getChildCount();
            viewGroupKt$descendants$1 = this;
        } else if (i4 == 1) {
            i3 = this.I$1;
            i2 = this.I$0;
            view = (View) this.L$2;
            viewGroup3 = (ViewGroup) this.L$1;
            s823 = (s82) this.L$0;
            k12.b(obj);
            viewGroupKt$descendants$12 = this;
            if (!(view instanceof ViewGroup)) {
                descendants = ViewGroupKt.getDescendants((ViewGroup) view);
                viewGroupKt$descendants$12.L$0 = s823;
                viewGroupKt$descendants$12.L$1 = viewGroup3;
                viewGroupKt$descendants$12.L$2 = null;
                viewGroupKt$descendants$12.I$0 = i2;
                viewGroupKt$descendants$12.I$1 = i3;
                viewGroupKt$descendants$12.label = 2;
                if (s823.c(descendants, viewGroupKt$descendants$12) != obj2) {
                    return obj2;
                }
                viewGroup2 = viewGroup3;
                s822 = s823;
                viewGroupKt$descendants$1 = viewGroupKt$descendants$12;
                s82 = s822;
                i = i3;
                viewGroup = viewGroup2;
                i2++;
                return obj2;
            }
            i = i3;
            viewGroup = viewGroup3;
            viewGroupKt$descendants$1 = viewGroupKt$descendants$12;
            s82 = s823;
            i2++;
        } else if (i4 == 2) {
            i3 = this.I$1;
            i2 = this.I$0;
            viewGroup2 = (ViewGroup) this.L$1;
            s822 = (s82) this.L$0;
            k12.b(obj);
            viewGroupKt$descendants$12 = this;
            viewGroupKt$descendants$1 = viewGroupKt$descendants$12;
            s82 = s822;
            i = i3;
            viewGroup = viewGroup2;
            i2++;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (i2 >= i) {
            View childAt = viewGroup.getChildAt(i2);
            k21.h(childAt, "getChildAt(index)");
            viewGroupKt$descendants$1.L$0 = s82;
            viewGroupKt$descendants$1.L$1 = viewGroup;
            viewGroupKt$descendants$1.L$2 = childAt;
            viewGroupKt$descendants$1.I$0 = i2;
            viewGroupKt$descendants$1.I$1 = i;
            viewGroupKt$descendants$1.label = 1;
            if (s82.a(childAt, viewGroupKt$descendants$1) == obj2) {
                return obj2;
            }
            s823 = s82;
            viewGroupKt$descendants$12 = viewGroupKt$descendants$1;
            viewGroup3 = viewGroup;
            i3 = i;
            view = childAt;
            if (!(view instanceof ViewGroup)) {
                i = i3;
                viewGroup = viewGroup3;
                viewGroupKt$descendants$1 = viewGroupKt$descendants$12;
                s82 = s823;
                i2++;
                if (i2 >= i) {
                }
            }
            descendants = ViewGroupKt.getDescendants((ViewGroup) view);
            viewGroupKt$descendants$12.L$0 = s823;
            viewGroupKt$descendants$12.L$1 = viewGroup3;
            viewGroupKt$descendants$12.L$2 = null;
            viewGroupKt$descendants$12.I$0 = i2;
            viewGroupKt$descendants$12.I$1 = i3;
            viewGroupKt$descendants$12.label = 2;
            if (s823.c(descendants, viewGroupKt$descendants$12) != obj2) {
            }
            return obj2;
            return obj2;
        }
        return ur2.INSTANCE;
    }
}
