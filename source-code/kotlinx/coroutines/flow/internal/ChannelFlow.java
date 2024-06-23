package kotlinx.coroutines.flow.internal;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jl1;
import tb.k21;
import tb.n30;
import tb.q30;
import tb.ur2;
import tb.wn;

@InternalCoroutinesApi
/* compiled from: Taobao */
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    @JvmField
    @NotNull
    public final CoroutineContext a;
    @JvmField
    public final int b;
    @JvmField
    @NotNull
    public final BufferOverflow c;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        this.a = coroutineContext;
        this.b = i;
        this.c = bufferOverflow;
        if (n30.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
    }

    static /* synthetic */ Object b(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object d = wn.d(new ChannelFlow$collect$2(flowCollector, channelFlow, null), continuation);
        return d == b.d() ? d : ur2.INSTANCE;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String a() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super ur2> continuation);

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super ur2> continuation) {
        return b(this, flowCollector, continuation);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow);

    @NotNull
    public final Function2<ProducerScope<? super T>, Continuation<? super ur2>, Object> e() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int f() {
        int i = this.b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        boolean z = true;
        if (n30.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i2 = this.b;
            if (i2 != -3) {
                if (i != -3) {
                    if (i2 != -2) {
                        if (i != -2) {
                            if (n30.a()) {
                                if (!(this.b >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (n30.a()) {
                                if (i < 0) {
                                    z = false;
                                }
                                if (!z) {
                                    throw new AssertionError();
                                }
                            }
                            i2 = this.b + i;
                            if (i2 < 0) {
                                i = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i = i2;
            }
            bufferOverflow = this.c;
        }
        if (k21.d(plus, this.a) && i == this.b && bufferOverflow == this.c) {
            return this;
        }
        return d(plus, i, bufferOverflow);
    }

    @NotNull
    public ReceiveChannel<T> g(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.f(coroutineScope, this.a, f(), this.c, CoroutineStart.ATOMIC, null, e(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String a2 = a();
        if (a2 != null) {
            arrayList.add(a2);
        }
        CoroutineContext coroutineContext = this.a;
        if (coroutineContext != EmptyCoroutineContext.INSTANCE) {
            arrayList.add(k21.r("context=", coroutineContext));
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add(k21.r("capacity=", Integer.valueOf(i)));
        }
        BufferOverflow bufferOverflow = this.c;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add(k21.r("onBufferOverflow=", bufferOverflow));
        }
        return q30.a(this) + jl1.ARRAY_START + CollectionsKt___CollectionsKt.Z(arrayList, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, null, 62, null) + jl1.ARRAY_END;
    }
}
