package kotlinx.coroutines.experimental.channels;

import com.lzy.okgo.model.HttpHeaders;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.channels.BroadcastChannel;
import kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel;
import kotlinx.coroutines.experimental.internal.ArrayCopyKt;
import kotlinx.coroutines.experimental.internal.Symbol;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;
import kotlinx.coroutines.experimental.selects.SelectClause2;
import kotlinx.coroutines.experimental.selects.SelectInstance;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u00049:;<B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J=\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u001b2\u0014\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0018\u00010\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0016\u0010$\u001a\u00020%2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002J\u0015\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u0017\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016JV\u0010.\u001a\u00020%\"\u0004\b\u0001\u0010/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0006\u0010'\u001a\u00028\u00002(\u00102\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/04\u0012\u0006\u0012\u0004\u0018\u00010\b03H\u0002ø\u0001\u0000¢\u0006\u0002\u00105J=\u00106\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0018\u00010\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002¢\u0006\u0002\u0010\u001fJ\u0019\u00107\u001a\u00020%2\u0006\u0010'\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00108R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR&\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00028\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00018\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0016\u0002\u0004\n\u0002\b\t¨\u0006="}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/experimental/channels/BroadcastChannel;", "value", "(Ljava/lang/Object;)V", "()V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_updating", "Lkotlinx/atomicfu/AtomicInt;", "isClosedForSend", "", "()Z", "isFull", "onSend", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "Lkotlinx/coroutines/experimental/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/experimental/selects/SelectClause2;", "value$annotations", "getValue", "()Ljava/lang/Object;", "valueOrNull", "valueOrNull$annotations", "getValueOrNull", "addSubscriber", "", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "([Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "cancel", "cause", "", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "closeSubscriber", "", "offer", "element", "(Ljava/lang/Object;)Z", "offerInternal", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "(Ljava/lang/Object;)Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "openSubscription", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "registerSelectSend", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Closed", "Companion", "State", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: ConflatedBroadcastChannel.kt */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    public static final Closed CLOSED = new Closed(null);
    @Deprecated
    public static final Companion Companion = new Companion(null);
    public static final State<Object> INITIAL_STATE;
    public static final Symbol UNDEFINED;
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
    private static final AtomicIntegerFieldUpdater _updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
    private volatile Object _state;
    private volatile int _updating;

    public static /* synthetic */ void value$annotations() {
    }

    public static /* synthetic */ void valueOrNull$annotations() {
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean isFull() {
        return false;
    }

    public ConflatedBroadcastChannel() {
        this._state = INITIAL_STATE;
        this._updating = 0;
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel
    @Deprecated(message = "Renamed to `openSubscription`", replaceWith = @ReplaceWith(expression = "openSubscription()", imports = {}))
    public SubscriptionReceiveChannel<E> open() {
        return BroadcastChannel.DefaultImpls.open(this);
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        _state$FU.lazySet(this, new State(e, null));
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "INITIAL_STATE", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/experimental/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ConflatedBroadcastChannel.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Symbol symbol = new Symbol("UNDEFINED");
        UNDEFINED = symbol;
        INITIAL_STATE = new State<>(symbol, null);
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ConflatedBroadcastChannel.kt */
    public static final class State<E> {
        public final Subscriber<E>[] subscribers;
        public final Object value;

        public State(Object obj, Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ConflatedBroadcastChannel.kt */
    public static final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable th) {
            this.closeCause = th;
        }

        public final Throwable getSendException() {
            Throwable th = this.closeCause;
            return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }

        public final Throwable getValueException() {
            Throwable th = this.closeCause;
            return th != null ? th : new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    public final E getValueOrNull() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            return null;
        }
        if (obj instanceof State) {
            State state = (State) obj;
            if (state.value == UNDEFINED) {
                return null;
            }
            return (E) state.value;
        }
        throw new IllegalStateException(("Invalid state " + obj).toString());
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel<E> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel$Subscriber */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel, kotlinx.coroutines.experimental.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Object obj;
        State state;
        Object obj2;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                if (state.value != UNDEFINED) {
                    subscriber.offerInternal(state.value);
                }
                obj2 = state.value;
                if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr != null) {
            return (Subscriber[]) ArraysKt.plus(subscriberArr, subscriber);
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[1];
        for (int i = 0; i < 1; i++) {
            subscriberArr2[i] = subscriber;
        }
        return subscriberArr2;
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        int length = subscriberArr.length;
        int indexOf = ArraysKt.indexOf(subscriberArr, subscriber);
        if (!(indexOf >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (length == 1) {
            return null;
        } else {
            Subscriber<E>[] subscriberArr2 = new Subscriber[(length - 1)];
            ArrayCopyKt.arraycopy(subscriberArr, 0, subscriberArr2, 0, indexOf);
            ArrayCopyKt.arraycopy(subscriberArr, indexOf + 1, subscriberArr2, indexOf, (length - indexOf) - 1);
            return subscriberArr2;
        }
    }

    @Override // kotlinx.coroutines.experimental.channels.BroadcastChannel
    public boolean cancel(Throwable th) {
        return close(th);
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal == null) {
            return Unit.INSTANCE;
        }
        throw offerInternal.getSendException();
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean offer(E e) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal == null) {
            return true;
        }
        throw offerInternal.getSendException();
    }

    private final Closed offerInternal(E e) {
        Object obj;
        if (!_updating$FU.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof Closed) {
                    Closed closed = (Closed) obj;
                    this._updating = 0;
                    return closed;
                } else if (!(obj instanceof State)) {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                } else if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
                }
            } finally {
                this._updating = 0;
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(e, ((State) obj).subscribers)));
        Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
        if (subscriberArr != null) {
            for (Subscriber<E> subscriber : subscriberArr) {
                subscriber.offerInternal(e);
            }
        }
        return null;
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return new ConflatedBroadcastChannel$onSend$1(this);
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        if (selectInstance.trySelect(null)) {
            Closed offerInternal = offerInternal(e);
            if (offerInternal != null) {
                selectInstance.resumeSelectCancellableWithException(offerInternal.getSendException());
            } else {
                UndispatchedKt.startCoroutineUndispatched(function2, this, selectInstance.getCompletion());
            }
        }
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/experimental/channels/ConflatedChannel;", "Lkotlinx/coroutines/experimental/channels/ReceiveChannel;", "Lkotlinx/coroutines/experimental/channels/SubscriptionReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/experimental/channels/ConflatedBroadcastChannel;)V", "cancel", "", "cause", "", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ConflatedBroadcastChannel.kt */
    public static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E>, SubscriptionReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        @Override // java.io.Closeable, java.lang.AutoCloseable, kotlinx.coroutines.experimental.channels.SubscriptionReceiveChannel
        @Deprecated(message = "Use `cancel`", replaceWith = @ReplaceWith(expression = "cancel()", imports = {}))
        public void close() {
            SubscriptionReceiveChannel.DefaultImpls.close(this);
        }

        public Subscriber(ConflatedBroadcastChannel<E> conflatedBroadcastChannel) {
            Intrinsics.checkParameterIsNotNull(conflatedBroadcastChannel, "broadcastChannel");
            this.broadcastChannel = conflatedBroadcastChannel;
        }

        @Override // kotlinx.coroutines.experimental.channels.ReceiveChannel, kotlinx.coroutines.experimental.channels.AbstractChannel
        public boolean cancel(Throwable th) {
            boolean close = close(th);
            if (close) {
                this.broadcastChannel.closeSubscriber(this);
            }
            return close;
        }

        @Override // kotlinx.coroutines.experimental.channels.AbstractSendChannel, kotlinx.coroutines.experimental.channels.ConflatedChannel
        public Object offerInternal(E e) {
            return super.offerInternal(e);
        }
    }

    public final E getValue() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            throw ((Closed) obj).getValueException();
        } else if (obj instanceof State) {
            State state = (State) obj;
            if (state.value != UNDEFINED) {
                return (E) state.value;
            }
            throw new IllegalStateException("No value");
        } else {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void closeSubscriber(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (!(obj instanceof Closed)) {
                if (obj instanceof State) {
                    State state = (State) obj;
                    obj2 = state.value;
                    if (obj != null) {
                        subscriberArr = state.subscribers;
                        if (subscriberArr == null) {
                            Intrinsics.throwNpe();
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } else {
                    throw new IllegalStateException(("Invalid state " + obj).toString());
                }
            } else {
                return;
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    @Override // kotlinx.coroutines.experimental.channels.SendChannel
    public boolean close(Throwable th) {
        Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, th == null ? CLOSED : new Closed(th)));
        if (obj != null) {
            Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
            if (subscriberArr == null) {
                return true;
            }
            for (Subscriber<E> subscriber : subscriberArr) {
                subscriber.close(th);
            }
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel.State<E>");
    }
}
