package anet.channel.statist;

import anet.channel.monitor.BandWidthSampler;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.youku.live.livesdk.preloader.Preloader;
import org.json.JSONObject;
import tb.e4;
import tb.h9;
import tb.hm;
import tb.ss0;

@Monitor(module = "networkPrefer", monitorPoint = Preloader.KEY_SESSION)
/* compiled from: Taobao */
public class SessionStatistic extends StatObject {
    public static int maxRetryTime;
    @Measure
    public long ackTime;
    @Measure(max = 15000.0d)
    public long authTime;
    @Measure
    public long cfRCount;
    @Dimension
    public String closeReason;
    @Dimension
    public int congControlKind;
    @Measure(max = 15000.0d, name = "connTime")
    public long connectionTime;
    @Dimension(name = "protocolType")
    public String conntype;
    @Dimension
    public String dcid;
    @Dimension
    public long errorCode;
    @Dimension
    public JSONObject extra = null;
    @Dimension
    public String host;
    @Measure
    public long inceptCount;
    @Dimension
    public String ip;
    @Dimension
    public int ipRefer = 0;
    @Dimension
    public int ipStackType;
    @Dimension
    public int ipType = 1;
    @Dimension
    public boolean isBackground;
    @Dimension
    public String isBg;
    public boolean isCommitted = false;
    @Dimension
    public boolean isComplex;
    @Dimension
    public boolean isComplexEnable;
    @Dimension
    public int isHitTicket;
    @Dimension
    public long isKL;
    @Dimension
    public int isProxy = 0;
    public boolean isReported = true;
    @Dimension
    public boolean isTicketStore;
    @Dimension
    public String isTunnel;
    @Measure
    public int lastPingInterval;
    @Measure(max = 86400.0d)
    public long liveTime = 0;
    @Measure
    public double lossRate;
    @Dimension
    public int mss;
    @Dimension
    public int netSpeed;
    @Dimension
    public String netType;
    @Measure
    public long pRate;
    @Dimension
    public int port;
    @Measure
    public long ppkgCount;
    @Measure
    public long recvSizeCount;
    @Measure(constantValue = 1.0d)
    public long requestCount = 1;
    @Dimension
    public int ret;
    @Measure
    public double retransmissionRate;
    @Dimension
    public long retryTimes;
    @Measure
    public int rtoCount;
    @Dimension
    public String scid;
    @Dimension
    public int sdkv;
    @Measure
    public long sendSizeCount;
    @Measure
    public long srtt;
    @Measure(max = 15000.0d)
    public long sslCalTime;
    @Measure(max = 15000.0d)
    public long sslTime;
    @Measure(constantValue = 0.0d)
    public long stdRCount = 1;
    @Dimension
    public long ticketTime;
    @Measure
    public int tlpCount;
    @Dimension
    public int xqc0RttStatus;
    @Dimension
    public String xqcConnEnv;

    public SessionStatistic(hm hmVar) {
        if (hmVar != null) {
            this.ip = hmVar.e();
            this.port = hmVar.f();
            IConnStrategy iConnStrategy = hmVar.a;
            if (iConnStrategy != null) {
                this.ipRefer = iConnStrategy.getIpSource();
                this.ipType = hmVar.a.getIpType();
            }
            this.pRate = (long) hmVar.c();
            this.conntype = hmVar.a().toString();
            this.retryTimes = (long) hmVar.d;
            maxRetryTime = hmVar.e;
            int i = Http3ConnectionDetector.i();
            boolean u = h9.u();
            this.xqcConnEnv = "http3OrangeEnable=" + u + "-http3Detect=" + i + "-http3ABEnable=" + h9.r();
            this.isBg = ss0.i() ? "bg" : "fg";
            this.ipStackType = Inet64Util.n();
            this.netSpeed = BandWidthSampler.f().h();
            this.isComplexEnable = h9.p();
            this.isTicketStore = h9.P();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r3 != -2601) goto L_0x0053;
     */
    @Override // anet.channel.statist.StatObject
    public boolean beforeCommit() {
        if (this.ret == 0) {
            if (this.retryTimes == ((long) maxRetryTime)) {
                long j = this.errorCode;
                if (j != -2613) {
                }
            }
            if (ALog.g(1)) {
                ALog.c("SessionStat no need commit", null, "retry:", Long.valueOf(this.retryTimes), "maxRetryTime", Integer.valueOf(maxRetryTime), "errorCode", Long.valueOf(this.errorCode));
            }
            return false;
        }
        if (this.isCommitted) {
            return false;
        }
        this.isCommitted = true;
        return true;
    }

    public e4 getAlarmObject() {
        e4 e4Var = new e4();
        e4Var.e = "networkPrefer";
        e4Var.f = "connect_succ_rate";
        boolean z = this.ret != 0;
        e4Var.a = z;
        if (z) {
            e4Var.b = this.closeReason;
        } else {
            e4Var.c = String.valueOf(this.errorCode);
        }
        return e4Var;
    }
}
