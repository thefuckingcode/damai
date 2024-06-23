package com.youku.network.a;

import android.text.TextUtils;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Header;
import anetwork.channel.Param;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.tao.log.TLog;
import com.ut.device.UTDevice;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.b;
import com.youku.network.c;
import com.youku.network.f;
import com.youku.network.f.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.ab;
import tb.e02;
import tb.nf2;

/* compiled from: Taobao */
public class d<I extends Request, O extends Response> extends a<I, O> {
    private c a;
    private IAntiFlowManager b;

    public d(IAntiFlowManager iAntiFlowManager) {
        this.b = iAntiFlowManager;
    }

    private List<Param> a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                arrayList.add(new nf2(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    private Request b(c cVar) {
        this.a = cVar;
        String antiCookie = this.b.getAntiCookie(cVar.k().get(IRequestConst.COOKIE));
        if (!TextUtils.isEmpty(antiCookie)) {
            cVar.a(IRequestConst.COOKIE, antiCookie);
        }
        List<Header> b2 = b(cVar.k());
        List<Param> a2 = a(cVar.l());
        e02 e02 = new e02(cVar.e());
        e02.setConnectTimeout(cVar.f());
        e02.setMethod(cVar.h());
        e02.setReadTimeout(cVar.g());
        e02.setFollowRedirects(cVar.i());
        e02.setCharset(cVar.n());
        if (b2 != null && b2.size() > 0) {
            e02.setHeaders(b2);
            for (Header header : b2) {
                if (IRequestConst.COOKIE.equalsIgnoreCase(header.getName()) && !TextUtils.isEmpty(header.getValue())) {
                    e02.setExtProperty("KeepCustomCookie", "true");
                }
            }
        }
        e02.setRetryTime(cVar.j());
        if (a2 != null && a2.size() > 0) {
            e02.setParams(a2);
        }
        if (!TextUtils.isEmpty(cVar.m())) {
            e02.setBodyEntry(new ByteArrayEntry(cVar.m().getBytes()));
        }
        if (cVar.L() != null) {
            f L = cVar.L();
            ByteArrayEntry byteArrayEntry = new ByteArrayEntry(L.a);
            byteArrayEntry.setContentType(L.b);
            e02.setBodyEntry(byteArrayEntry);
        }
        return e02;
    }

    private com.youku.network.d b(O o) {
        com.youku.network.d a2 = com.youku.network.d.a();
        a2.b(o.getStatusCode());
        a2.a(o.getBytedata());
        a2.a(o.getConnHeadFields());
        a2.a(o.getDesc());
        a2.a(o.getError());
        a2.a(o.getStatisticData());
        return a2;
    }

    private List<Header> b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && com.youku.httpcommunication.c.b(entry.getKey())) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (IRequestConst.USER_AGENT.equalsIgnoreCase(key)) {
                    value = a(value);
                }
                arrayList.add(new ab(key, value));
            }
        }
        if (b.b) {
            String utdid = UTDevice.getUtdid(b.a);
            ab abVar = new ab(HttpHeaderConstant.X_UTDID, utdid);
            String str = a.a;
            TLog.logd(str, "x-utdid:" + utdid);
            arrayList.add(abVar);
        }
        return arrayList;
    }

    public I a(c cVar) {
        return (I) b(cVar);
    }

    public com.youku.network.d a(O o) {
        return b(o);
    }
}
