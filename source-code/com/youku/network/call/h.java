package com.youku.network.call;

import android.os.Handler;
import com.youku.network.a;
import com.youku.network.a.b;
import com.youku.network.a.c;
import com.youku.network.d;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;

/* compiled from: Taobao */
public class h implements MtopCallback.MtopFinishListener {
    private a a;
    private Handler b;
    private c c;
    private d d;

    public h(a aVar, Handler handler, b bVar) {
        this.a = aVar;
        this.b = handler;
        this.c = (c) bVar;
    }

    public h(a aVar, b bVar) {
        this(aVar, null, bVar);
    }

    private void a() {
        a aVar = this.a;
        if (aVar != null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new MTopListener$1(this));
            } else {
                aVar.a(this.d);
            }
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        this.d = this.c.a(mtopFinishEvent.getMtopResponse());
        a();
    }
}
