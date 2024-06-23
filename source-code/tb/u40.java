package tb;

import android.text.TextUtils;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.network.diagnosis.INetworkDiagnosisCenter;
import com.network.diagnosis.IServerDetector;
import com.network.diagnosis.NetworkDiagnosis;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;
import java.util.HashMap;

/* compiled from: Taobao */
public class u40 implements IFullTraceAnalysis {
    private boolean a;
    private boolean b;

    public u40() {
        try {
            Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
            SceneIdentifier.setContext(ss0.c());
            this.a = true;
        } catch (Exception unused) {
            this.a = false;
            ALog.e("awcn.DefaultFullTraceAnalysis", "not support FullTraceAnalysis", null, new Object[0]);
        }
        try {
            NetworkDiagnosis.setContext(ss0.c());
            INetworkDiagnosisCenter iNetworkDiagnosisCenter = NetworkDiagnosis.get();
            if (iNetworkDiagnosisCenter != null) {
                iNetworkDiagnosisCenter.initialize(ss0.c());
            }
            this.b = true;
        } catch (Exception unused2) {
            this.b = false;
            ALog.e("awcn.DefaultFullTraceAnalysis", "not support NetworkDiagnosis", null, new Object[0]);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public void commitRequest(String str, RequestStatistic requestStatistic) {
        INetworkDiagnosisCenter iNetworkDiagnosisCenter;
        if (this.a) {
            if (requestStatistic != null && !TextUtils.isEmpty(str)) {
                RequestInfo requestInfo = new RequestInfo();
                requestInfo.host = requestStatistic.host;
                requestInfo.bizId = requestStatistic.bizId;
                requestInfo.url = requestStatistic.url;
                requestInfo.retryTimes = requestStatistic.retryTimes;
                requestInfo.netType = requestStatistic.netType;
                requestInfo.protocolType = requestStatistic.protocolType;
                requestInfo.ret = requestStatistic.ret;
                requestInfo.isCbMain = false;
                requestInfo.isReqMain = requestStatistic.isReqMain;
                requestInfo.isReqSync = requestStatistic.isReqSync;
                requestInfo.netErrorCode = String.valueOf(requestStatistic.statusCode);
                requestInfo.pTraceId = requestStatistic.pTraceId;
                requestInfo.netReqStart = requestStatistic.netReqStart;
                requestInfo.netReqServiceBindEnd = requestStatistic.reqServiceTransmissionEnd;
                requestInfo.netReqProcessStart = requestStatistic.reqStart;
                requestInfo.netReqSendStart = requestStatistic.sendStart;
                requestInfo.netRspRecvEnd = requestStatistic.rspEnd;
                requestInfo.netRspCbDispatch = requestStatistic.rspCbDispatch;
                requestInfo.netRspCbStart = requestStatistic.rspCbStart;
                requestInfo.netRspCbEnd = requestStatistic.rspCbEnd;
                requestInfo.reqDeflateSize = requestStatistic.reqHeadDeflateSize + requestStatistic.reqBodyDeflateSize;
                requestInfo.reqInflateSize = requestStatistic.reqHeadInflateSize + requestStatistic.reqBodyInflateSize;
                requestInfo.rspDeflateSize = requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize;
                requestInfo.rspInflateSize = requestStatistic.rspHeadInflateSize + requestStatistic.rspBodyInflateSize;
                requestInfo.serverRT = requestStatistic.serverRT;
                requestInfo.sendDataTime = requestStatistic.sendDataTime;
                requestInfo.firstDataTime = requestStatistic.firstDataTime;
                requestInfo.recvDataTime = requestStatistic.recDataTime;
                requestInfo.useMultiPath = requestStatistic.useMultiPath;
                requestInfo.multiNetworkStatus = requestStatistic.multiNetworkStatus;
                FullTraceAnalysis.getInstance().commitRequest(str, "network", requestInfo);
            } else {
                return;
            }
        }
        if (this.b && (iNetworkDiagnosisCenter = NetworkDiagnosis.get()) != null) {
            IServerDetector serverDetector = iNetworkDiagnosisCenter.getServerDetector();
            HashMap hashMap = new HashMap();
            hashMap.put("host", requestStatistic.host);
            hashMap.put("url", requestStatistic.url);
            hashMap.put(IFullTraceAnalysisV3.Stage.SERVE_RT, Long.valueOf(requestStatistic.serverRT));
            hashMap.put("protocol", requestStatistic.protocolType);
            hashMap.put(TbAuthConstants.IP, requestStatistic.ip);
            hashMap.put("eagleEyeId", requestStatistic.eagleEyeId);
            hashMap.put("code", Integer.valueOf(requestStatistic.statusCode));
            serverDetector.checkRequest(hashMap);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public String createRequest() {
        if (this.a) {
            return FullTraceAnalysis.getInstance().createRequest("network");
        }
        return null;
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public c42 getSceneInfo() {
        if (!this.a) {
            return null;
        }
        c42 c42 = new c42();
        c42.b = SceneIdentifier.isUrlLaunch();
        c42.c = SceneIdentifier.getAppLaunchTime();
        c42.d = SceneIdentifier.getLastLaunchTime();
        c42.e = SceneIdentifier.getDeviceLevel();
        c42.a = SceneIdentifier.getStartType();
        c42.f = SceneIdentifier.getBucketInfo();
        c42.g = ABTestCenter.getUTABTestBucketId("networksdk");
        return c42;
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public void log(String str, String str2, String str3) {
        if (this.a) {
            FullTraceAnalysis.getInstance().log(str, "network", str2, str3);
        }
    }
}
