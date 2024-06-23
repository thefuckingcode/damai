package io.reactivex.rxkotlin;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005\"\b\b\u0002\u0010\u0004*\u00020\u00052\u0015\u0010\u0006\u001a\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u0011H\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b2\u0015\u0010\f\u001a\u0011H\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "T", "R", "U", "", "p1", "Lkotlin/ParameterName;", SerializableCookie.NAME, "first", "p2", "second", "p3", "third", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;"}, k = 3, mv = {1, 1, 11})
/* compiled from: flowable.kt */
final class FlowableKt$combineLatest$3 extends FunctionReference implements Function3<T, R, U, Triple<? extends T, ? extends R, ? extends U>> {
    public static final FlowableKt$combineLatest$3 INSTANCE = new FlowableKt$combineLatest$3();

    FlowableKt$combineLatest$3() {
        super(3);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Triple.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V";
    }

    @Override // kotlin.jvm.functions.Function3
    public final Triple<T, R, U> invoke(T t, R r, U u) {
        Intrinsics.checkParameterIsNotNull(t, "p1");
        Intrinsics.checkParameterIsNotNull(r, "p2");
        Intrinsics.checkParameterIsNotNull(u, "p3");
        return new Triple<>(t, r, u);
    }
}
