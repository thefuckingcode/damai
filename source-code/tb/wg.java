package tb;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wg {
    @NotNull
    public static final <E> Channel<E> a(int i, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, ur2> function1) {
        int i2 = 1;
        if (i == -2) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                i2 = Channel.Factory.a();
            }
            return new i7(i2, bufferOverflow, function1);
        } else if (i == -1) {
            if (bufferOverflow != BufferOverflow.SUSPEND) {
                i2 = 0;
            }
            if (i2 != 0) {
                return new fm(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i != 0) {
            if (i == Integer.MAX_VALUE) {
                return new p71(function1);
            }
            if (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new fm(function1);
            }
            return new i7(i, bufferOverflow, function1);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new tz1(function1);
        } else {
            return new i7(1, bufferOverflow, function1);
        }
    }

    public static /* synthetic */ Channel b(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return a(i, bufferOverflow, function1);
    }
}
