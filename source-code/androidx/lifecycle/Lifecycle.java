package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public abstract class Lifecycle {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    AtomicReference<Object> mInternalScopeRef = new AtomicReference<>();

    /* renamed from: androidx.lifecycle.Lifecycle$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0083 */
        static {
            int[] iArr = new int[Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_RESUME.ordinal()] = 5;
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_DESTROY.ordinal()] = 6;
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr2;
            iArr2[State.CREATED.ordinal()] = 1;
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.STARTED.ordinal()] = 2;
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.RESUMED.ordinal()] = 3;
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.DESTROYED.ordinal()] = 4;
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.INITIALIZED.ordinal()] = 5;
        }
    }

    /* compiled from: Taobao */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @Nullable
        public static Event downFrom(@NonNull State state) {
            int i = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_DESTROY;
            }
            if (i == 2) {
                return ON_STOP;
            }
            if (i != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        @Nullable
        public static Event downTo(@NonNull State state) {
            int i = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_STOP;
            }
            if (i == 2) {
                return ON_PAUSE;
            }
            if (i != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        @Nullable
        public static Event upFrom(@NonNull State state) {
            int i = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_START;
            }
            if (i == 2) {
                return ON_RESUME;
            }
            if (i != 5) {
                return null;
            }
            return ON_CREATE;
        }

        @Nullable
        public static Event upTo(@NonNull State state) {
            int i = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i == 1) {
                return ON_CREATE;
            }
            if (i == 2) {
                return ON_START;
            }
            if (i != 3) {
                return null;
            }
            return ON_RESUME;
        }

        @NonNull
        public State getTargetState() {
            switch (AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Taobao */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver lifecycleObserver);

    @NonNull
    @MainThread
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver lifecycleObserver);
}
