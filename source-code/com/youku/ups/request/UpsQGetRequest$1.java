package com.youku.ups.request;

import android.text.TextUtils;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.ups.a.a;
import com.youku.ups.data.b;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.VideoCacheInfo;
import com.youku.upsplayer.util.Logger;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UpsQGetRequest$1 implements Runnable {
    final /* synthetic */ c this$0;

    UpsQGetRequest$1(c cVar) {
        this.this$0 = cVar;
    }

    public void run() {
        this.this$0.f.upsTimeTraceBean = new UpsTimeTraceBean();
        try {
            String a = a.a(this.this$0.b, this.this$0.g, false);
            c cVar = this.this$0;
            String str = cVar.a(cVar.g, a);
            if (TextUtils.isEmpty(str)) {
                this.this$0.e.onFailure(new com.youku.ups.data.a(28001, "invalid url", this.this$0.f));
                return;
            }
            Logger.d("UpsPlayer", "ups url=" + str);
            this.this$0.f.url = str;
            this.this$0.f.host = this.this$0.i;
            this.this$0.f.ip = this.this$0.j;
            if (this.this$0.h != null) {
                this.this$0.f.cookie = this.this$0.h.cookie;
                this.this$0.f.agent = this.this$0.h.userAgent;
                this.this$0.f.connect_timeout = this.this$0.h.connect_timeout;
                this.this$0.f.read_timeout = this.this$0.h.read_timeout;
            }
            if (this.this$0.f.connect_timeout == 0) {
                this.this$0.f.connect_timeout = 15000;
            }
            if (this.this$0.f.read_timeout == 0) {
                this.this$0.f.read_timeout = 15000;
            }
            GetInfoResult data = this.this$0.c.getData(this.this$0.f);
            List<VideoCacheInfo> a2 = this.this$0.a(data);
            data.connectStat.rawUpsData = data.data;
            this.this$0.e.onSuccess(new b(a2), data.connectStat);
        } catch (AntiTheftChainException e) {
            this.this$0.e.onFailure(new com.youku.ups.data.a(e.getErrorCode(), "ckey构建失败：" + e.getMessage(), this.this$0.f));
        }
    }
}
