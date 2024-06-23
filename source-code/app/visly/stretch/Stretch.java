package app.visly.stretch;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import tb.m40;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lapp/visly/stretch/Stretch;", "", "<init>", "()V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Stretch {
    @NotNull
    public static final a Companion = new a(null);
    private static volatile boolean didInit;
    private static volatile boolean initing;
    private static volatile long ptr;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        private final long c() {
            return Stretch.nInit();
        }

        public final long a() {
            return Stretch.ptr;
        }

        public final void b() {
            if (!Stretch.didInit && !Stretch.initing && !Stretch.didInit) {
                synchronized (Stretch.class) {
                    if (!Stretch.didInit) {
                        if (!Stretch.initing) {
                            a aVar = Stretch.Companion;
                            Stretch.initing = true;
                            System.loadLibrary("stretch");
                            aVar.d(aVar.c());
                            Stretch.didInit = true;
                            Stretch.initing = false;
                            ur2 ur2 = ur2.INSTANCE;
                        }
                    }
                }
            }
        }

        public final void d(long j) {
            Stretch.ptr = j;
        }
    }

    /* access modifiers changed from: private */
    @JvmStatic
    public static final native long nInit();
}
