package com.youku.network.call;

import android.os.Handler;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.ParcelableInputStream;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.c;
import com.youku.network.a;
import com.youku.network.d;
import com.youku.network.e;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* compiled from: Taobao */
public class l implements NetworkCallBack$FinishListener, NetworkCallBack$InputStreamListener, NetworkCallBack$ResponseCodeListener {
    private a a;
    private d b;
    private int c;
    private int d;
    private Map<String, List<String>> e;
    private volatile boolean f;
    private NetworkEvent$FinishEvent g;
    private boolean h;
    private ByteArrayOutputStream i;
    private Handler j;
    private IAntiFlowManager k;

    public l(Handler handler, a aVar, IAntiFlowManager iAntiFlowManager) {
        this.b = d.a();
        this.d = 0;
        this.f = false;
        this.g = null;
        this.h = false;
        this.i = null;
        this.a = aVar;
        this.j = handler;
        this.k = iAntiFlowManager;
    }

    public l(a aVar, IAntiFlowManager iAntiFlowManager) {
        this(null, aVar, iAntiFlowManager);
    }

    private int a(Map<String, List<String>> map) {
        String a2 = a(map, "content-length");
        if (c.b(a2)) {
            try {
                return Integer.parseInt(a2);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private String a(Map<String, List<String>> map, String str) {
        List<String> b2 = b(map, str);
        if (b2 == null || b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    /* access modifiers changed from: private */
    public void a(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        e.a().submit(new NetworkListener$2(this, networkEvent$FinishEvent, obj));
    }

    private List<String> b(Map<String, List<String>> map, String str) {
        if (map != null && !map.isEmpty() && !c.c(str)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void b(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        if (this.a != null) {
            this.b.b(networkEvent$FinishEvent.getHttpCode());
            this.b.a(this.e);
            this.b.a(networkEvent$FinishEvent.getDesc());
            ByteArrayOutputStream byteArrayOutputStream = this.i;
            if (byteArrayOutputStream != null) {
                this.b.a(byteArrayOutputStream.toByteArray());
            }
            this.b.a(networkEvent$FinishEvent.getStatisticData());
            this.k.afterCall(this.b.d(), this.b.f());
            Handler handler = this.j;
            if (handler != null) {
                handler.post(new NetworkListener$3(this));
            } else {
                this.a.a(this.b);
            }
        }
    }

    @Override // anetwork.channel.NetworkCallBack$FinishListener
    public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        synchronized (this) {
            this.g = networkEvent$FinishEvent;
            if (this.h || !this.f) {
                a(networkEvent$FinishEvent, obj);
            }
        }
    }

    @Override // anetwork.channel.NetworkCallBack$InputStreamListener
    public void onInputStreamGet(ParcelableInputStream parcelableInputStream, Object obj) {
        this.f = true;
        MtopSDKThreadPoolExecutorFactory.submitRequestTask(new NetworkListener$1(this, parcelableInputStream, obj));
    }

    @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
    public boolean onResponseCode(int i2, Map<String, List<String>> map, Object obj) {
        this.c = i2;
        this.e = map;
        this.d = a(map);
        return false;
    }
}
