package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: Taobao */
public final class ff0 {
    @NonNull
    public static RuntimeException a(@NonNull Throwable th) {
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public static void b(@NonNull Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
