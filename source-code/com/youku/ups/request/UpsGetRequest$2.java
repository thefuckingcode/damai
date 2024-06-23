package com.youku.ups.request;

import android.text.TextUtils;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.ups.a.a;
import com.youku.ups.data.RequestParams;
import com.youku.ups.data.b;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.util.Logger;
import com.youku.upsplayer.util.PlayStageTracker;

/* compiled from: Taobao */
class UpsGetRequest$2 implements Runnable {
    final /* synthetic */ b this$0;

    UpsGetRequest$2(b bVar) {
        this.this$0 = bVar;
    }

    public void run() {
        this.this$0.l.upsTimeTraceBean = new UpsTimeTraceBean();
        this.this$0.l.upsTimeTraceBean.startTrace();
        try {
            String a = a.a(this.this$0.o, this.this$0.g, this.this$0.n);
            b bVar = this.this$0;
            String a2 = bVar.a((b) bVar.g, (RequestParams) a);
            this.this$0.l.upsTimeTraceBean.traceTimeGetCkey();
            if (TextUtils.isEmpty(a2)) {
                Logger.d("UpsGetRequest", "invalid url");
                this.this$0.i.onFailure(new com.youku.ups.data.a(28001, "invalid url", this.this$0.l));
                return;
            }
            Logger.d("UpsPlayer", "ups url=" + a2);
            this.this$0.l.url = a2;
            this.this$0.l.mTopUpsRequest = this.this$0.a((b) a);
            this.this$0.l.upsType = 1;
            this.this$0.l.host = this.this$0.j;
            this.this$0.l.ip = this.this$0.k;
            if (this.this$0.f != null) {
                this.this$0.l.cookie = this.this$0.f.cookie;
                this.this$0.l.agent = this.this$0.f.userAgent;
                this.this$0.l.connect_timeout = this.this$0.f.connect_timeout;
                this.this$0.l.read_timeout = this.this$0.f.read_timeout;
            }
            if (this.this$0.l.connect_timeout == 0) {
                this.this$0.l.connect_timeout = 15000;
            }
            if (this.this$0.l.read_timeout == 0) {
                this.this$0.l.read_timeout = 15000;
            }
            Logger.d("UpsGetRequest", "run start");
            PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
            upsRequest.beginSection("apiRequest");
            if (!(this.this$0.l == null || this.this$0.l.upsTimeTraceBean == null)) {
                this.this$0.l.upsTimeTraceBean.traceTimeStartRequest();
            }
            GetInfoResult data = this.this$0.e.getData(this.this$0.l);
            upsRequest.endSection();
            if (!(this.this$0.l == null || this.this$0.l.upsTimeTraceBean == null)) {
                this.this$0.l.upsTimeTraceBean.traceTimeStartParseResult();
            }
            VideoInfo a3 = this.this$0.a((b) data);
            if (!(this.this$0.l == null || this.this$0.l.upsTimeTraceBean == null)) {
                this.this$0.l.upsTimeTraceBean.traceTimeEndParse();
                Logger.d("UpsPlayer", this.this$0.l.vid + " total ups parse cost:" + this.this$0.l.upsTimeTraceBean.timeEndParse + "; compress:" + this.this$0.l.compress);
            }
            if (a3 != null) {
                this.this$0.a((b) a3, (VideoInfo) data);
            }
            Logger.d("UpsPlayer", "call back result");
            if (!(this.this$0.l == null || this.this$0.l.upsTimeTraceBean == null)) {
                data.connectStat.mUpsTimeTraceBean = this.this$0.l.upsTimeTraceBean;
                data.connectStat.rawUpsData = data.data;
            }
            this.this$0.i.onSuccess(new b(a3), data.connectStat);
            Logger.d("UpsGetRequest", "run finish");
        } catch (AntiTheftChainException e) {
            this.this$0.i.onFailure(new com.youku.ups.data.a(e.getErrorCode(), "ckey构建失败：" + e.getMessage(), this.this$0.l));
        }
    }
}
