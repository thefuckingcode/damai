package com.youku.network.call;

import android.os.Handler;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.youku.network.a;
import com.youku.network.a.b;
import com.youku.network.a.c;
import com.youku.network.d;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
public class f implements IRemoteListener {
    private a a;
    private Handler b;
    private c c;
    private d d;

    public f(a aVar, Handler handler, b bVar) {
        this.a = aVar;
        this.b = handler;
        this.c = (c) bVar;
    }

    public f(a aVar, b bVar) {
        this(aVar, null, bVar);
    }

    private void a() {
        a aVar = this.a;
        if (aVar != null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new MTopBusinessListener$1(this));
            } else {
                aVar.a(this.d);
            }
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        this.d = this.c.a(mtopResponse);
        a();
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        this.d = this.c.a(mtopResponse);
        a();
    }
}
