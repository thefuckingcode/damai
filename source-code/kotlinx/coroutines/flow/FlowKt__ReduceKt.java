package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.k12;
import tb.k21;
import tb.qc;
import tb.qj0;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final /* synthetic */ class FlowKt__ReduceKt {

    /* compiled from: Taobao */
    public static final class a implements FlowCollector<T> {
        final /* synthetic */ Ref$ObjectRef a;

        public a(Ref$ObjectRef ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            this.a.element = t;
            if (qc.a(false).booleanValue()) {
                return ur2.INSTANCE;
            }
            throw new AbortFlowException(this);
        }
    }

    /* compiled from: Taobao */
    public static final class b implements FlowCollector<T> {
        final /* synthetic */ Ref$ObjectRef a;

        public b(Ref$ObjectRef ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            this.a.element = t;
            if (qc.a(false).booleanValue()) {
                return ur2.INSTANCE;
            }
            throw new AbortFlowException(this);
        }
    }

    /* compiled from: Taobao */
    public static final class c implements FlowCollector<T> {
        final /* synthetic */ Ref$ObjectRef a;

        public c(Ref$ObjectRef ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            this.a.element = t;
            return ur2.INSTANCE;
        }
    }

    /* compiled from: Taobao */
    public static final class d implements FlowCollector<T> {
        final /* synthetic */ Ref$ObjectRef a;

        public d(Ref$ObjectRef ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            this.a.element = t;
            return ur2.INSTANCE;
        }
    }

    /* compiled from: Taobao */
    public static final class e implements FlowCollector<T> {
        final /* synthetic */ Ref$ObjectRef a;

        public e(Ref$ObjectRef ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            Ref$ObjectRef ref$ObjectRef = this.a;
            if (ref$ObjectRef.element == ek1.NULL) {
                ref$ObjectRef.element = t;
                return ur2.INSTANCE;
            }
            throw new IllegalArgumentException("Flow has more than one element".toString());
        }
    }

    /* compiled from: Taobao */
    public static final class f implements FlowCollector<T> {
        final /* synthetic */ Ref$ObjectRef a;

        public f(Ref$ObjectRef ref$ObjectRef) {
            this.a = ref$ObjectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
            boolean z;
            Ref$ObjectRef ref$ObjectRef = this.a;
            T t2 = ref$ObjectRef.element;
            T t3 = (T) ek1.NULL;
            if (t2 == t3) {
                ref$ObjectRef.element = t;
                z = true;
            } else {
                ref$ObjectRef.element = t3;
                z = false;
            }
            if (qc.a(z).booleanValue()) {
                return ur2.INSTANCE;
            }
            throw new AbortFlowException(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object a(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        T t;
        AbortFlowException e2;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (FlowKt__ReduceKt$first$1) continuation;
            int i2 = flowKt__ReduceKt$first$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$first$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) ek1.NULL;
                    FlowCollector<? super Object> aVar = new a(ref$ObjectRef2);
                    try {
                        flowKt__ReduceKt$first$1.L$0 = ref$ObjectRef2;
                        flowKt__ReduceKt$first$1.L$1 = aVar;
                        flowKt__ReduceKt$first$1.label = 1;
                        if (flow.collect(aVar, flowKt__ReduceKt$first$1) == obj2) {
                            return obj2;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e3) {
                        ref$ObjectRef = ref$ObjectRef2;
                        e2 = e3;
                        flowCollector = aVar;
                        qj0.a(e2, flowCollector);
                        t = ref$ObjectRef.element;
                        if (t != ek1.NULL) {
                        }
                    }
                } else if (i == 1) {
                    flowCollector = (a) flowKt__ReduceKt$first$1.L$1;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$first$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (AbortFlowException e4) {
                        e2 = e4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = ref$ObjectRef.element;
                if (t != ek1.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuation);
        Object obj3 = flowKt__ReduceKt$first$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$first$1.label;
        if (i != 0) {
        }
        t = ref$ObjectRef.element;
        if (t != ek1.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object b(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22;
        T t;
        AbortFlowException e2;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (FlowKt__ReduceKt$first$3) continuation;
            int i2 = flowKt__ReduceKt$first$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$3.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$first$3.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) ek1.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(function2, ref$ObjectRef2);
                    try {
                        flowKt__ReduceKt$first$3.L$0 = function2;
                        flowKt__ReduceKt$first$3.L$1 = ref$ObjectRef2;
                        flowKt__ReduceKt$first$3.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        flowKt__ReduceKt$first$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, flowKt__ReduceKt$first$3) == obj2) {
                            return obj2;
                        }
                        function22 = function2;
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e3) {
                        function22 = function2;
                        ref$ObjectRef = ref$ObjectRef2;
                        e2 = e3;
                        flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        qj0.a(e2, flowCollector);
                        t = ref$ObjectRef.element;
                        if (t != ek1.NULL) {
                        }
                    }
                } else if (i == 1) {
                    flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) flowKt__ReduceKt$first$3.L$2;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$first$3.L$1;
                    function22 = (Function2) flowKt__ReduceKt$first$3.L$0;
                    try {
                        k12.b(obj);
                    } catch (AbortFlowException e4) {
                        e2 = e4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = ref$ObjectRef.element;
                if (t != ek1.NULL) {
                    return t;
                }
                throw new NoSuchElementException(k21.r("Expected at least one element matching the predicate ", function22));
            }
        }
        flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuation);
        Object obj3 = flowKt__ReduceKt$first$3.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$first$3.label;
        if (i != 0) {
        }
        t = ref$ObjectRef.element;
        if (t != ek1.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object c(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$firstOrNull$1 flowKt__ReduceKt$firstOrNull$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e2;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$firstOrNull$1) {
            flowKt__ReduceKt$firstOrNull$1 = (FlowKt__ReduceKt$firstOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$firstOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$firstOrNull$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$firstOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    FlowCollector<? super Object> bVar = new b(ref$ObjectRef2);
                    try {
                        flowKt__ReduceKt$firstOrNull$1.L$0 = ref$ObjectRef2;
                        flowKt__ReduceKt$firstOrNull$1.L$1 = bVar;
                        flowKt__ReduceKt$firstOrNull$1.label = 1;
                        if (flow.collect(bVar, flowKt__ReduceKt$firstOrNull$1) == obj2) {
                            return obj2;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e3) {
                        ref$ObjectRef = ref$ObjectRef2;
                        e2 = e3;
                        flowCollector = bVar;
                        qj0.a(e2, flowCollector);
                        return ref$ObjectRef.element;
                    }
                } else if (i == 1) {
                    flowCollector = (b) flowKt__ReduceKt$firstOrNull$1.L$1;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$firstOrNull$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (AbortFlowException e4) {
                        e2 = e4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ref$ObjectRef.element;
            }
        }
        flowKt__ReduceKt$firstOrNull$1 = new FlowKt__ReduceKt$firstOrNull$1(continuation);
        Object obj3 = flowKt__ReduceKt$firstOrNull$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$firstOrNull$1.label;
        if (i != 0) {
        }
        return ref$ObjectRef.element;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object d(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$firstOrNull$3 flowKt__ReduceKt$firstOrNull$3;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e2;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$firstOrNull$3) {
            flowKt__ReduceKt$firstOrNull$3 = (FlowKt__ReduceKt$firstOrNull$3) continuation;
            int i2 = flowKt__ReduceKt$firstOrNull$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$3.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$firstOrNull$3.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$firstOrNull$3.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    FlowCollector<? super Object> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(function2, ref$ObjectRef2);
                    try {
                        flowKt__ReduceKt$firstOrNull$3.L$0 = ref$ObjectRef2;
                        flowKt__ReduceKt$firstOrNull$3.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                        flowKt__ReduceKt$firstOrNull$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2, flowKt__ReduceKt$firstOrNull$3) == obj2) {
                            return obj2;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e3) {
                        ref$ObjectRef = ref$ObjectRef2;
                        e2 = e3;
                        flowCollector = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                        qj0.a(e2, flowCollector);
                        return ref$ObjectRef.element;
                    }
                } else if (i == 1) {
                    flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) flowKt__ReduceKt$firstOrNull$3.L$1;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$firstOrNull$3.L$0;
                    try {
                        k12.b(obj);
                    } catch (AbortFlowException e4) {
                        e2 = e4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ref$ObjectRef.element;
            }
        }
        flowKt__ReduceKt$firstOrNull$3 = new FlowKt__ReduceKt$firstOrNull$3(continuation);
        Object obj3 = flowKt__ReduceKt$firstOrNull$3.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$firstOrNull$3.label;
        if (i != 0) {
        }
        return ref$ObjectRef.element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T, R> Object e(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        FlowKt__ReduceKt$fold$1 flowKt__ReduceKt$fold$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof FlowKt__ReduceKt$fold$1) {
            flowKt__ReduceKt$fold$1 = (FlowKt__ReduceKt$fold$1) continuation;
            int i2 = flowKt__ReduceKt$fold$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$fold$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$fold$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$fold$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = r;
                    FlowCollector<? super Object> flowKt__ReduceKt$fold$$inlined$collect$1 = new FlowKt__ReduceKt$fold$$inlined$collect$1(ref$ObjectRef2, function3);
                    flowKt__ReduceKt$fold$1.L$0 = ref$ObjectRef2;
                    flowKt__ReduceKt$fold$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$fold$$inlined$collect$1, flowKt__ReduceKt$fold$1) == obj2) {
                        return obj2;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$fold$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ref$ObjectRef.element;
            }
        }
        flowKt__ReduceKt$fold$1 = new FlowKt__ReduceKt$fold$1(continuation);
        Object obj3 = flowKt__ReduceKt$fold$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$fold$1.label;
        if (i != 0) {
        }
        return ref$ObjectRef.element;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object f(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$last$1 flowKt__ReduceKt$last$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$last$1) {
            flowKt__ReduceKt$last$1 = (FlowKt__ReduceKt$last$1) continuation;
            int i2 = flowKt__ReduceKt$last$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$last$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$last$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$last$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) ek1.NULL;
                    FlowCollector<? super Object> cVar = new c(ref$ObjectRef2);
                    flowKt__ReduceKt$last$1.L$0 = ref$ObjectRef2;
                    flowKt__ReduceKt$last$1.label = 1;
                    if (flow.collect(cVar, flowKt__ReduceKt$last$1) == obj2) {
                        return obj2;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$last$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = ref$ObjectRef.element;
                if (t == ek1.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$last$1 = new FlowKt__ReduceKt$last$1(continuation);
        Object obj3 = flowKt__ReduceKt$last$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$last$1.label;
        if (i != 0) {
        }
        t = ref$ObjectRef.element;
        if (t == ek1.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object g(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$lastOrNull$1 flowKt__ReduceKt$lastOrNull$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof FlowKt__ReduceKt$lastOrNull$1) {
            flowKt__ReduceKt$lastOrNull$1 = (FlowKt__ReduceKt$lastOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$lastOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$lastOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$lastOrNull$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$lastOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    FlowCollector<? super Object> dVar = new d(ref$ObjectRef2);
                    flowKt__ReduceKt$lastOrNull$1.L$0 = ref$ObjectRef2;
                    flowKt__ReduceKt$lastOrNull$1.label = 1;
                    if (flow.collect(dVar, flowKt__ReduceKt$lastOrNull$1) == obj2) {
                        return obj2;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$lastOrNull$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ref$ObjectRef.element;
            }
        }
        flowKt__ReduceKt$lastOrNull$1 = new FlowKt__ReduceKt$lastOrNull$1(continuation);
        Object obj3 = flowKt__ReduceKt$lastOrNull$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$lastOrNull$1.label;
        if (i != 0) {
        }
        return ref$ObjectRef.element;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <S, T extends S> Object h(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        FlowKt__ReduceKt$reduce$1 flowKt__ReduceKt$reduce$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$reduce$1) {
            flowKt__ReduceKt$reduce$1 = (FlowKt__ReduceKt$reduce$1) continuation;
            int i2 = flowKt__ReduceKt$reduce$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$reduce$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$reduce$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) ek1.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$reduce$$inlined$collect$1 = new FlowKt__ReduceKt$reduce$$inlined$collect$1(ref$ObjectRef2, function3);
                    flowKt__ReduceKt$reduce$1.L$0 = ref$ObjectRef2;
                    flowKt__ReduceKt$reduce$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$reduce$$inlined$collect$1, flowKt__ReduceKt$reduce$1) == obj2) {
                        return obj2;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$reduce$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = ref$ObjectRef.element;
                if (t == ek1.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Empty flow can't be reduced");
            }
        }
        flowKt__ReduceKt$reduce$1 = new FlowKt__ReduceKt$reduce$1(continuation);
        Object obj3 = flowKt__ReduceKt$reduce$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$reduce$1.label;
        if (i != 0) {
        }
        t = ref$ObjectRef.element;
        if (t == ek1.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object i(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$single$1 flowKt__ReduceKt$single$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$single$1) {
            flowKt__ReduceKt$single$1 = (FlowKt__ReduceKt$single$1) continuation;
            int i2 = flowKt__ReduceKt$single$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$single$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$single$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$single$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) ek1.NULL;
                    FlowCollector<? super Object> eVar = new e(ref$ObjectRef2);
                    flowKt__ReduceKt$single$1.L$0 = ref$ObjectRef2;
                    flowKt__ReduceKt$single$1.label = 1;
                    if (flow.collect(eVar, flowKt__ReduceKt$single$1) == obj2) {
                        return obj2;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                } else if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$single$1.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = ref$ObjectRef.element;
                if (t == ek1.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Flow is empty");
            }
        }
        flowKt__ReduceKt$single$1 = new FlowKt__ReduceKt$single$1(continuation);
        Object obj3 = flowKt__ReduceKt$single$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$single$1.label;
        if (i != 0) {
        }
        t = ref$ObjectRef.element;
        if (t == ek1.NULL) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final <T> Object j(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        FlowKt__ReduceKt$singleOrNull$1 flowKt__ReduceKt$singleOrNull$1;
        int i;
        Ref$ObjectRef ref$ObjectRef;
        T t;
        AbortFlowException e2;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$singleOrNull$1) {
            flowKt__ReduceKt$singleOrNull$1 = (FlowKt__ReduceKt$singleOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$singleOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$singleOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$singleOrNull$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = flowKt__ReduceKt$singleOrNull$1.label;
                if (i != 0) {
                    k12.b(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) ek1.NULL;
                    FlowCollector<? super Object> fVar = new f(ref$ObjectRef2);
                    try {
                        flowKt__ReduceKt$singleOrNull$1.L$0 = ref$ObjectRef2;
                        flowKt__ReduceKt$singleOrNull$1.L$1 = fVar;
                        flowKt__ReduceKt$singleOrNull$1.label = 1;
                        if (flow.collect(fVar, flowKt__ReduceKt$singleOrNull$1) == obj2) {
                            return obj2;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e3) {
                        ref$ObjectRef = ref$ObjectRef2;
                        e2 = e3;
                        flowCollector = fVar;
                        qj0.a(e2, flowCollector);
                        t = ref$ObjectRef.element;
                        if (t == ek1.NULL) {
                        }
                    }
                } else if (i == 1) {
                    flowCollector = (f) flowKt__ReduceKt$singleOrNull$1.L$1;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$singleOrNull$1.L$0;
                    try {
                        k12.b(obj);
                    } catch (AbortFlowException e4) {
                        e2 = e4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = ref$ObjectRef.element;
                if (t == ek1.NULL) {
                    return null;
                }
                return t;
            }
        }
        flowKt__ReduceKt$singleOrNull$1 = new FlowKt__ReduceKt$singleOrNull$1(continuation);
        Object obj3 = flowKt__ReduceKt$singleOrNull$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = flowKt__ReduceKt$singleOrNull$1.label;
        if (i != 0) {
        }
        t = ref$ObjectRef.element;
        if (t == ek1.NULL) {
        }
    }
}
