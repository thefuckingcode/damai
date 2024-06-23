package com.taobao.aranger.core.handler.reply;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.util.ArrayList;

/* compiled from: Taobao */
public abstract class a implements IReplyHandler {
    protected final Call a;

    protected a(Call call) {
        this.a = call;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(Object[] objArr) throws IPCException;

    @Override // com.taobao.aranger.core.handler.reply.IReplyHandler
    public Reply handleReply() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList();
        Object[] a2 = com.taobao.aranger.utils.a.a(this.a.getParameterWrappers(), arrayList);
        long currentTimeMillis = System.currentTimeMillis();
        Object a3 = a(a2);
        Reply invokeTime = Reply.obtain().setResult(a3).setInvokeTime(System.currentTimeMillis() - currentTimeMillis);
        if (!arrayList.isEmpty()) {
            ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[arrayList.size()];
            for (Integer num : arrayList) {
                int intValue = num.intValue();
                parameterWrapperArr[intValue] = ParameterWrapper.obtain().setData(a2[((Integer) arrayList.get(intValue)).intValue()]);
            }
            invokeTime.setFlowParameterWrappers(parameterWrapperArr);
        }
        return invokeTime;
    }
}
