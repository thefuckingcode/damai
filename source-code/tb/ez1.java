package tb;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Beta
/* compiled from: Taobao */
public final class ez1 {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        ds1.p(invocationHandler);
        ds1.k(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
