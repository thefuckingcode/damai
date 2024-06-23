package tb;

import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class yi1 implements TaskContext {
    @NotNull
    public static final yi1 INSTANCE = new yi1();
    private static final int a = 0;

    private yi1() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return a;
    }
}
