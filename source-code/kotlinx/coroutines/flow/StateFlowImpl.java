package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.collections.l;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.f2;
import tb.h2;
import tb.j41;
import tb.jh2;
import tb.k12;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class StateFlowImpl<T> extends f2<m> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    @NotNull
    private volatile /* synthetic */ Object _state;
    private int e;

    public StateFlowImpl(@NotNull Object obj) {
        this._state = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r8 = (kotlinx.coroutines.flow.m[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        if (r8 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        r2 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r3 >= r2) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        if (r4 != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        r4.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r8 = r6.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        if (r8 != r7) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0045, code lost:
        r6.e = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        r7 = f();
        r2 = tb.ur2.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
        r8 = r7;
        r7 = r8;
     */
    private final boolean i(Object obj, Object obj2) {
        f();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !k21.d(obj3, obj)) {
                return false;
            }
            if (k21.d(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i = this.e;
            if ((i & 1) == 0) {
                int i2 = i + 1;
                this.e = i2;
                h2[] f = f();
                ur2 ur2 = ur2.INSTANCE;
            } else {
                this.e = i + 2;
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        if (tb.k21.d(r11, r12) == false) goto L_0x00b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object obj;
        int i;
        Throwable th;
        StateFlowImpl<T> stateFlowImpl;
        m mVar;
        Object obj2;
        FlowCollector<? super T> flowCollector2;
        Job job;
        FlowCollector flowCollector3;
        Object obj3;
        if (continuation instanceof StateFlowImpl$collect$1) {
            stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
            int i2 = stateFlowImpl$collect$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                stateFlowImpl$collect$1.label = i2 - Integer.MIN_VALUE;
                Object obj4 = stateFlowImpl$collect$1.result;
                obj = b.d();
                i = stateFlowImpl$collect$1.label;
                if (i != 0) {
                    k12.b(obj4);
                    m mVar2 = (m) a();
                    try {
                        if (flowCollector instanceof SubscribedFlowCollector) {
                            stateFlowImpl$collect$1.L$0 = this;
                            stateFlowImpl$collect$1.L$1 = flowCollector;
                            stateFlowImpl$collect$1.L$2 = mVar2;
                            stateFlowImpl$collect$1.label = 1;
                            if (((SubscribedFlowCollector) flowCollector).a(stateFlowImpl$collect$1) == obj) {
                                return obj;
                            }
                        }
                        stateFlowImpl = this;
                        mVar = mVar2;
                    } catch (Throwable th2) {
                        th = th2;
                        stateFlowImpl = this;
                        mVar = mVar2;
                        stateFlowImpl.d(mVar);
                        throw th;
                    }
                } else if (i == 1) {
                    mVar = (m) stateFlowImpl$collect$1.L$2;
                    flowCollector = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    k12.b(obj4);
                } else if (i == 2) {
                    obj2 = stateFlowImpl$collect$1.L$4;
                    job = (Job) stateFlowImpl$collect$1.L$3;
                    mVar = (m) stateFlowImpl$collect$1.L$2;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    k12.b(obj4);
                    flowCollector2 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    flowCollector3 = flowCollector2;
                    if (!mVar.g()) {
                    }
                    Object obj5 = stateFlowImpl._state;
                    if (job != null) {
                    }
                    if (obj2 != null) {
                    }
                    if (obj5 == ek1.NULL) {
                    }
                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$1.L$1 = flowCollector3;
                    stateFlowImpl$collect$1.L$2 = mVar;
                    stateFlowImpl$collect$1.L$3 = job;
                    stateFlowImpl$collect$1.L$4 = obj5;
                    stateFlowImpl$collect$1.label = 2;
                    if (flowCollector3.emit(obj3, stateFlowImpl$collect$1) == obj) {
                    }
                    return obj;
                } else if (i == 3) {
                    obj2 = stateFlowImpl$collect$1.L$4;
                    job = (Job) stateFlowImpl$collect$1.L$3;
                    mVar = (m) stateFlowImpl$collect$1.L$2;
                    FlowCollector flowCollector4 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    try {
                        k12.b(obj4);
                        flowCollector3 = flowCollector4;
                        Object obj52 = stateFlowImpl._state;
                        if (job != null) {
                            j41.g(job);
                        }
                        if (obj2 != null) {
                            flowCollector2 = flowCollector3;
                        }
                        obj3 = obj52 == ek1.NULL ? null : obj52;
                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$1.L$1 = flowCollector3;
                        stateFlowImpl$collect$1.L$2 = mVar;
                        stateFlowImpl$collect$1.L$3 = job;
                        stateFlowImpl$collect$1.L$4 = obj52;
                        stateFlowImpl$collect$1.label = 2;
                        if (flowCollector3.emit(obj3, stateFlowImpl$collect$1) == obj) {
                            return obj;
                        }
                        obj2 = obj52;
                        flowCollector2 = flowCollector3;
                        flowCollector3 = flowCollector2;
                        if (!mVar.g()) {
                            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                            stateFlowImpl$collect$1.L$1 = flowCollector2;
                            stateFlowImpl$collect$1.L$2 = mVar;
                            stateFlowImpl$collect$1.L$3 = job;
                            stateFlowImpl$collect$1.L$4 = obj2;
                            stateFlowImpl$collect$1.label = 3;
                            flowCollector3 = flowCollector2;
                            if (mVar.d(stateFlowImpl$collect$1) == obj) {
                                return obj;
                            }
                        }
                        Object obj522 = stateFlowImpl._state;
                        if (job != null) {
                        }
                        if (obj2 != null) {
                        }
                        if (obj522 == ek1.NULL) {
                        }
                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$1.L$1 = flowCollector3;
                        stateFlowImpl$collect$1.L$2 = mVar;
                        stateFlowImpl$collect$1.L$3 = job;
                        stateFlowImpl$collect$1.L$4 = obj522;
                        stateFlowImpl$collect$1.label = 2;
                        if (flowCollector3.emit(obj3, stateFlowImpl$collect$1) == obj) {
                        }
                        return obj;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector3 = flowCollector;
                job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
                obj2 = null;
                Object obj5222 = stateFlowImpl._state;
                if (job != null) {
                }
                if (obj2 != null) {
                }
                if (obj5222 == ek1.NULL) {
                }
                stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                stateFlowImpl$collect$1.L$1 = flowCollector3;
                stateFlowImpl$collect$1.L$2 = mVar;
                stateFlowImpl$collect$1.L$3 = job;
                stateFlowImpl$collect$1.L$4 = obj5222;
                stateFlowImpl$collect$1.label = 2;
                if (flowCollector3.emit(obj3, stateFlowImpl$collect$1) == obj) {
                }
                return obj;
            }
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj42 = stateFlowImpl$collect$1.result;
        obj = b.d();
        i = stateFlowImpl$collect$1.label;
        if (i != 0) {
        }
        flowCollector3 = flowCollector;
        job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
        obj2 = null;
        Object obj52222 = stateFlowImpl._state;
        if (job != null) {
        }
        if (obj2 != null) {
        }
        if (obj52222 == ek1.NULL) {
        }
        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
        stateFlowImpl$collect$1.L$1 = flowCollector3;
        stateFlowImpl$collect$1.L$2 = mVar;
        stateFlowImpl$collect$1.L$3 = job;
        stateFlowImpl$collect$1.L$4 = obj52222;
        stateFlowImpl$collect$1.label = 2;
        if (flowCollector3.emit(obj3, stateFlowImpl$collect$1) == obj) {
        }
        return obj;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) ek1.NULL;
        }
        if (t2 == null) {
            t2 = (T) ek1.NULL;
        }
        return i(t, t2);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.MutableSharedFlow
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super ur2> continuation) {
        setValue(t);
        return ur2.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return l.d(this, coroutineContext, i, bufferOverflow);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: g */
    public m b() {
        return new m();
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        return l.e(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        jh2 jh2 = ek1.NULL;
        T t = (T) this._state;
        if (t == jh2) {
            return null;
        }
        return t;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: h */
    public m[] c(int i) {
        return new m[i];
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) ek1.NULL;
        }
        i(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }
}
