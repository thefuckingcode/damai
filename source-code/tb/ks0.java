package tb;

import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.reply.a;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class ks0 extends a {
    private static final String h = "ks0";
    private static final ConcurrentHashMap<String, Object> i = new ConcurrentHashMap<>();
    private final String b;
    private Object c;
    private String d;
    private Constructor<?> e;
    private Method f;
    private final Class<?> g;

    public ks0(Call call) throws IPCException {
        super(call);
        this.b = call.getServiceWrapper().getTimeStamp();
        Class<?> a = d.e().a(call.getServiceWrapper());
        this.g = a;
        Object obj = i.get(a.getName());
        this.c = obj;
        if (obj == null) {
            boolean z = true;
            Class<?> cls = null;
            try {
                d e2 = d.e();
                cls = e2.b(a.getName() + Constants.PROXY_SUFFIX);
            } catch (IPCException unused) {
                z = false;
            }
            if (z) {
                this.d = TypeUtils.getMethodId(call.getMethodWrapper().getName(), call.getParameterWrappers());
                this.e = TypeUtils.getConstructor(cls, new Class[0]);
                return;
            }
            Method methodForGettingInstance = TypeUtils.getMethodForGettingInstance(this.g, call.getMethodWrapper().getName(), d.e().c(call.getParameterWrappers()));
            this.f = methodForGettingInstance;
            if (!Modifier.isStatic(methodForGettingInstance.getModifiers())) {
                throw new IPCException(40, "Method " + this.f.getName() + " of class " + this.g.getName() + " is not static. " + "Only the static method can be invoked to get an instance.");
            }
        }
    }

    @Override // com.taobao.aranger.core.handler.reply.a
    public Object a(Object[] objArr) throws IPCException {
        try {
            if (this.c == null) {
                Constructor<?> constructor = this.e;
                if (constructor != null) {
                    Object newInstance = constructor.newInstance(new Object[0]);
                    this.c = newInstance;
                    ((IServiceProxy) newInstance).create(this.d, objArr);
                } else {
                    this.c = this.f.invoke(null, objArr);
                }
                i.putIfAbsent(this.g.getName(), this.c);
            }
            z82.b().d(this.b, this.c);
            return null;
        } catch (Exception e2) {
            jz0.c(h, "[GetInstanceReplyHandler][invoke]", e2, "timeStamp", this.b);
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            }
            throw new IPCException(24, e2);
        }
    }
}
