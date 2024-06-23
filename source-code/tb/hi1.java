package tb;

import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.reply.a;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.d;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
public class hi1 extends a {
    private static final String f = "hi1";
    private final String b;
    private String c;
    private Constructor<?> d;
    private Constructor<?> e;

    public hi1(Call call) throws IPCException {
        super(call);
        boolean z;
        Class<?> cls;
        this.b = call.getServiceWrapper().getTimeStamp();
        Class<?> a = d.e().a(call.getServiceWrapper());
        try {
            d e2 = d.e();
            cls = e2.b(a.getName() + Constants.PROXY_SUFFIX);
            z = true;
        } catch (IPCException unused) {
            cls = null;
            z = false;
        }
        if (z) {
            this.c = TypeUtils.getMethodId(a.getSimpleName(), call.getParameterWrappers());
            this.d = TypeUtils.getConstructor(cls, new Class[0]);
            return;
        }
        this.e = TypeUtils.getConstructor(a, d.e().c(call.getParameterWrappers()));
    }

    @Override // com.taobao.aranger.core.handler.reply.a
    public Object a(Object[] objArr) throws IPCException {
        Object obj;
        try {
            Constructor<?> constructor = this.d;
            if (constructor != null) {
                obj = constructor.newInstance(new Object[0]);
                ((IServiceProxy) obj).create(this.c, objArr);
            } else if (objArr.length == 0) {
                obj = this.e.newInstance(new Object[0]);
            } else {
                obj = this.e.newInstance(objArr);
            }
            z82.b().d(this.b, obj);
            return null;
        } catch (Exception e2) {
            jz0.c(f, "[NewInstanceReplyHandler][invoke]", e2, "timeStamp", this.b);
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            }
            throw new IPCException(23, e2);
        }
    }
}
