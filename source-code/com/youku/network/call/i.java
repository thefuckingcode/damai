package com.youku.network.call;

import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.monitor.BandWidthSampler;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.poplayer.trigger.c;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.youku.network.d;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.domain.NetworkStats;

/* compiled from: Taobao */
public class i implements e {
    private static volatile boolean N;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public long M;
    public a a;
    public long b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public long r;
    public int s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    private void a(MtopResponse mtopResponse) {
        this.d = mtopResponse.getRetCode();
        this.e = "";
        MtopStatistics mtopStat = mtopResponse.getMtopStat();
        if (mtopStat != null) {
            this.h = mtopStat.domain;
            this.q = mtopStat.cacheSwitch;
            this.p = mtopStat.cacheHitType;
            this.i = mtopStat.clientTraceId;
            this.j = mtopStat.serverTraceId;
            this.l = mtopStat.pageName;
            this.k = mtopStat.pageUrl;
            this.m = String.valueOf(mtopStat.backGround ? 1 : 0);
            this.t = mtopStat.totalTime;
            this.y = mtopStat.netTotalTime;
            this.w = mtopStat.cacheCostTime;
            this.x = mtopStat.cacheResponseParseTime;
            this.u = mtopStat.waitExecuteTime;
            this.v = mtopStat.waitCallbackTime;
            this.z = mtopStat.computeSignTime;
            this.A = mtopStat.computeWuaTime;
            this.B = mtopStat.computeMiniWuaTime;
            NetworkStats networkStats = mtopStat.getNetworkStats();
            if (networkStats != null) {
                this.n = networkStats.connectionType;
                this.o = String.valueOf(networkStats.isSSL);
                this.s = networkStats.retryTimes;
                this.D = networkStats.firstDataTime;
                this.E = networkStats.recDataTime;
                this.C = networkStats.oneWayTime_ANet;
                this.F = networkStats.serverRT;
                this.H = networkStats.recvSize;
                this.G = networkStats.dataSpeed;
            }
            MtopStatistics.RbStatisticData rbStatData = mtopStat.getRbStatData();
            if (rbStatData != null) {
                this.I = rbStatData.rbReqTime;
                this.J = rbStatData.toMainThTime;
                this.K = rbStatData.jsonParseTime;
                this.L = rbStatData.mtopReqTime;
            }
        }
    }

    public void a() {
        Exception e2;
        String str;
        String str2;
        String str3;
        try {
            boolean z2 = N;
            String str4 = "cacheResponseParseTime";
            String str5 = "cacheCostTime";
            String str6 = "waitCallbackTime";
            String str7 = "waitExecuteTime";
            String str8 = ImageStatistics.KEY_TOTAL_TIME;
            String str9 = c.KEY_RETRY_TIME;
            String str10 = "cost";
            if (!z2) {
                try {
                    N = true;
                    DimensionSet addDimension = DimensionSet.create().addDimension("api").addDimension("domain").addDimension("retCode").addDimension("retMsg").addDimension("errorCode").addDimension("responseCode").addDimension("clientTraceId").addDimension("serverTraceId").addDimension(MtopJSBridge.MtopJSParam.PAGE_URL).addDimension("pageName").addDimension("backGround").addDimension("connType").addDimension("isSSL").addDimension("cacheHitType").addDimension("cacheSwitch");
                    str3 = "cacheSwitch";
                    str2 = "cacheHitType";
                    MeasureSet addMeasure = MeasureSet.create().addMeasure(str10);
                    str10 = str10;
                    MeasureSet addMeasure2 = addMeasure.addMeasure(str9);
                    str9 = str9;
                    MeasureSet addMeasure3 = addMeasure2.addMeasure(str8);
                    str8 = str8;
                    MeasureSet addMeasure4 = addMeasure3.addMeasure(str7);
                    str7 = str7;
                    MeasureSet addMeasure5 = addMeasure4.addMeasure(str6);
                    str6 = str6;
                    MeasureSet addMeasure6 = addMeasure5.addMeasure(str5);
                    str5 = str5;
                    MeasureSet addMeasure7 = addMeasure6.addMeasure(str4);
                    str4 = str4;
                    str = "isSSL";
                    AppMonitor.register("mtop_api", "api_request", addMeasure7.addMeasure("networkExeTime").addMeasure("signTime").addMeasure("wuaTime").addMeasure("miniWuaTime").addMeasure("oneWayTime_ANet").addMeasure("firstDataTime").addMeasure("recDataTime").addMeasure(IFullTraceAnalysisV3.Stage.SERVE_RT).addMeasure("dataSpeed").addMeasure("revSize").addMeasure("rbReqTime").addMeasure("toMainThTime").addMeasure("jsonParseTime").addMeasure("mtopReqTime").addMeasure("netSpeed"), addDimension);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                }
            } else {
                str3 = "cacheSwitch";
                str2 = "cacheHitType";
                str = "isSSL";
            }
            DimensionValueSet create = DimensionValueSet.create();
            try {
                create.setValue("api", this.c);
                create.setValue("domain", this.h);
                create.setValue("retCode", this.d);
                create.setValue("retMsg", this.e);
                create.setValue("errorCode", this.f);
                create.setValue("responseCode", this.g);
                create.setValue("clientTraceId", this.i);
                create.setValue("serverTraceId", this.j);
                create.setValue(MtopJSBridge.MtopJSParam.PAGE_URL, this.k);
                create.setValue("pageName", this.l);
                create.setValue("backGround", this.m);
                create.setValue("connType", this.n);
                create.setValue(str, this.o);
                create.setValue(str2, String.valueOf(this.p));
                create.setValue(str3, String.valueOf(this.q));
                MeasureValueSet create2 = MeasureValueSet.create();
                create2.setValue(str10, (double) this.r);
                create2.setValue(str9, (double) this.s);
                create2.setValue(str8, (double) this.t);
                create2.setValue(str7, (double) this.u);
                create2.setValue(str6, (double) this.v);
                create2.setValue(str5, (double) this.w);
                create2.setValue(str4, (double) this.x);
                create2.setValue("networkExeTime", (double) this.y);
                create2.setValue("signTime", (double) this.z);
                create2.setValue("wuaTime", (double) this.A);
                create2.setValue("miniWuaTime", (double) this.B);
                create2.setValue("oneWayTime_ANet", (double) this.C);
                create2.setValue("firstDataTime", (double) this.D);
                create2.setValue("recDataTime", (double) this.E);
                create2.setValue(IFullTraceAnalysisV3.Stage.SERVE_RT, (double) this.F);
                create2.setValue("dataSpeed", (double) this.G);
                create2.setValue("revSize", (double) this.H);
                create2.setValue("rbReqTime", (double) this.I);
                create2.setValue("toMainThTime", (double) this.J);
                create2.setValue("jsonParseTime", (double) this.K);
                create2.setValue("mtopReqTime", (double) this.L);
                create2.setValue("netSpeed", (double) this.M);
                AppMonitor.Stat.commit("mtop_api", "api_request", create, create2);
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            e2 = e5;
            e2.printStackTrace();
        }
    }

    @Override // com.youku.network.call.e
    public void a(a aVar) {
        this.a = aVar;
        this.b = System.currentTimeMillis();
        this.c = aVar.c().E();
    }

    @Override // com.youku.network.call.e
    public void a(d dVar) {
        this.r = System.currentTimeMillis() - this.b;
        this.g = String.valueOf(dVar.d());
        this.f = String.valueOf(dVar.b());
        this.M = (long) BandWidthSampler.f().g();
        a(dVar.i());
        a();
    }

    public String toString() {
        return "MTopMotuLogger{mCall=" + this.a + ", mBeforeRequestTS=" + this.b + ", api='" + this.c + '\'' + ", retCode='" + this.d + '\'' + ", retMsg='" + this.e + '\'' + ", errorCode='" + this.f + '\'' + ", responseCode='" + this.g + '\'' + ", domain='" + this.h + '\'' + ", clientTraceId='" + this.i + '\'' + ", serverTraceId='" + this.j + '\'' + ", pageUrl='" + this.k + '\'' + ", pageName='" + this.l + '\'' + ", backGround='" + this.m + '\'' + ", connType='" + this.n + '\'' + ", isSSL='" + this.o + '\'' + ", mCost=" + this.r + ", retryTime=" + this.s + ", totalTime=" + this.t + ", waitExecuteTime=" + this.u + ", waitCallbackTime=" + this.v + ", cacheHitType=" + this.p + ", cacheCostTime=" + this.w + ", cacheSwitch=" + this.q + ", cacheResponseParseTime=" + this.x + ", networkExeTime=" + this.y + ", signTime=" + this.z + ", wuaTime=" + this.A + ", miniWuaTime=" + this.B + ", oneWayTime_ANet=" + this.C + ", firstDataTime=" + this.D + ", recDataTime=" + this.E + ", serverRT=" + this.F + ", dataSpeed=" + this.G + ", revSize=" + this.H + ", rbReqTime=" + this.I + ", toMainThTime=" + this.J + ", jsonParseTime=" + this.K + ", mtopReqTime=" + this.L + '}';
    }
}
