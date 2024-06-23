package tb;

import com.alibaba.ability.middleware.IMiddlewareHub;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ud1 {
    @NotNull
    public static final ud1 INSTANCE = new ud1();
    public static IMiddlewareHub a;

    private ud1() {
    }

    @NotNull
    public static final IMiddlewareHub a() {
        IMiddlewareHub iMiddlewareHub = a;
        if (iMiddlewareHub == null) {
            k21.A("middlewareHub");
        }
        return iMiddlewareHub;
    }
}
