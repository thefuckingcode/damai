package com.taobao.aranger.core.handler.invoc;

import android.os.IBinder;
import androidx.annotation.Keep;
import com.taobao.aranger.annotation.method.oneway;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.channel.a;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.TypeUtils;
import java.lang.reflect.Method;
import tb.xg;

/* compiled from: Taobao */
public class CallbackInvocationHandler extends IPCInvocationHandler {
    private final String b;
    private final int c;
    private final a d;

    public CallbackInvocationHandler(IBinder iBinder, String str, int i) {
        this.b = str;
        this.c = i;
        this.d = xg.a(iBinder);
    }

    @Override // com.taobao.aranger.core.handler.invoc.IPCInvocationHandler
    public Reply a(Method method, Object[] objArr) throws IPCException {
        return this.d.c(Callback.obtain().setParameterWrappers(com.taobao.aranger.utils.a.b(method, objArr)).setMethodWrapper(MethodWrapper.obtain().setMethodName(method.getName()).setReturnType(TypeUtils.getClassId(method.getReturnType()))).setKey(this.b).setVoid(Constants.VOID.equals(method.getReturnType().getName())).setOneWay(method.getAnnotation(oneway.class) != null));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && hashCode() == obj.hashCode();
    }

    public int hashCode() {
        return this.c;
    }

    @Override // com.taobao.aranger.core.handler.invoc.IPCInvocationHandler, java.lang.reflect.InvocationHandler
    @Keep
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Method method, Object[] objArr) throws IPCException {
        return super.invoke(obj, method, objArr);
    }
}
