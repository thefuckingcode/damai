package tb;

import android.content.ComponentName;
import android.text.TextUtils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.reply.a;
import com.taobao.aranger.core.ipc.channel.DefaultRemoteChannel;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.aranger.utils.ProxyRecoverProvider;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.d;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class nd1 extends a {
    private static final String f = "nd1";
    private String b;
    private Object c;
    private String d;
    private Method e;

    public nd1(Call call) throws IPCException {
        super(call);
        this.b = call.getServiceWrapper().getTimeStamp();
        b();
    }

    private void b() throws IPCException {
        Object c2 = z82.b().c(this.b);
        this.c = c2;
        if (c2 == null || !(c2 instanceof IServiceProxy)) {
            this.e = d.e().f(d.e().a(this.a.getServiceWrapper()), this.a.getMethodWrapper(), this.a.getParameterWrappers());
        } else {
            this.d = TypeUtils.getMethodId(this.a.getMethodWrapper().getName(), this.a.getParameterWrappers());
        }
    }

    @Override // com.taobao.aranger.core.handler.reply.a
    public Object a(Object[] objArr) throws IPCException {
        if (this.c == null) {
            try {
                String k = new DefaultRemoteChannel(IPCUtils.queryContentAuthorityFromProvider(new ComponentName(TextUtils.isEmpty(this.a.getCallingPackage()) ? ARanger.getContext().getPackageName() : this.a.getCallingPackage(), ProxyRecoverProvider.class.getName()))).k(this.b);
                if (!TextUtils.isEmpty(k)) {
                    this.b = k;
                    b();
                }
            } catch (Exception e2) {
                jz0.c(f, "[MethodInvokeReplyHandler][invoke] recover proxy error", e2, "timeStamp", this.b);
            }
            if (this.c == null) {
                jz0.d(f, "[MethodInvokeReplyHandler][invoke] proxy is null", "timeStamp", this.b);
                throw new IPCException(22, "can't find ipc object proxy");
            }
        }
        try {
            Object obj = this.c;
            return obj instanceof IServiceProxy ? ((IServiceProxy) obj).invoke(this.d, objArr) : this.e.invoke(obj, objArr);
        } catch (Exception e3) {
            jz0.d(f, "[MethodInvokeReplyHandler][invoke]", "timeStamp", this.b);
            if (e3 instanceof IPCException) {
                throw ((IPCException) e3);
            }
            throw new IPCException(3, e3);
        }
    }
}
