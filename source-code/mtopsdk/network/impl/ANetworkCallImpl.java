package mtopsdk.network.impl;

import android.content.Context;
import anetwork.channel.Network;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MockResponse;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.AbstractCallImpl;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.domain.NetworkStats;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.Response;
import mtopsdk.network.util.ANetworkConverter;
import tb.m50;
import tb.uy0;

/* compiled from: Taobao */
public class ANetworkCallImpl extends AbstractCallImpl {
    private static final String TAG = "mtopsdk.ANetworkCallImpl";
    Network mDegradalbeNetwork;
    Network mHttpNetwork;
    Network mNetwork;

    public ANetworkCallImpl(Request request, Context context) {
        super(request, context);
        if (!SwitchConfig.getInstance().isGlobalSpdySwitchOpen()) {
            if (this.mHttpNetwork == null) {
                this.mHttpNetwork = new uy0(this.mContext);
            }
            this.mNetwork = this.mHttpNetwork;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, this.seqNo, "mNetwork=HttpNetwork in ANetworkCallImpl");
                return;
            }
            return;
        }
        m50 m50 = new m50(this.mContext);
        this.mDegradalbeNetwork = m50;
        this.mNetwork = m50;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, this.seqNo, "mNetwork=DegradableNetwork in ANetworkCallImpl");
        }
    }

    @Override // mtopsdk.network.Call
    public void enqueue(final NetworkCallback networkCallback) {
        MockResponse mockResponse;
        Request request = request();
        if (!AbstractCallImpl.isDebugApk || !AbstractCallImpl.isOpenMock) {
            mockResponse = null;
        } else {
            mockResponse = getMockResponse(request.api);
            if (mockResponse != null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, this.seqNo, "[enqueue]get MockResponse succeed.mockResponse=" + mockResponse);
                }
                final Response buildResponse = buildResponse(request, mockResponse.statusCode, null, mockResponse.headers, mockResponse.byteData, null);
                String str = this.seqNo;
                MtopSDKThreadPoolExecutorFactory.submitCallbackTask(str != null ? str.hashCode() : hashCode(), new Runnable() {
                    /* class mtopsdk.network.impl.ANetworkCallImpl.AnonymousClass1 */

                    public void run() {
                        try {
                            networkCallback.onResponse(ANetworkCallImpl.this, buildResponse);
                        } catch (Exception e) {
                            TBSdkLog.e(ANetworkCallImpl.TAG, ((AbstractCallImpl) ANetworkCallImpl.this).seqNo, "[enqueue]call NetworkCallback.onResponse error.", e);
                        }
                    }
                });
                return;
            }
        }
        if (mockResponse == null) {
            this.future = this.mNetwork.asyncSend(ANetworkConverter.convertRequest(request), request.reqContext, null, new NetworkListenerAdapter(this, networkCallback, request.seqNo));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    @Override // mtopsdk.network.Call
    public Response execute() throws Exception {
        byte[] bArr;
        Map<String, List<String>> map;
        MockResponse mockResponse;
        NetworkStats networkStats;
        String str;
        int i;
        Request request = request();
        int i2 = 0;
        if (!AbstractCallImpl.isDebugApk || !AbstractCallImpl.isOpenMock) {
            mockResponse = null;
            map = null;
        } else {
            mockResponse = getMockResponse(request.api);
            if (mockResponse != null) {
                i2 = mockResponse.statusCode;
                map = mockResponse.headers;
                bArr = mockResponse.byteData;
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, this.seqNo, "[execute]get MockResponse succeed.mockResponse=" + mockResponse);
                }
                if (mockResponse != null) {
                    anetwork.channel.Response syncSend = this.mNetwork.syncSend(ANetworkConverter.convertRequest(request), request.reqContext);
                    i = syncSend.getStatusCode();
                    str = syncSend.getDesc();
                    map = syncSend.getConnHeadFields();
                    bArr = syncSend.getBytedata();
                    networkStats = ANetworkConverter.convertNetworkStats(syncSend.getStatisticData());
                } else {
                    networkStats = null;
                    i = i2;
                    str = null;
                }
                return buildResponse(request, i, str, map, bArr, networkStats);
            }
            map = null;
        }
        bArr = map;
        if (mockResponse != null) {
        }
        return buildResponse(request, i, str, map, bArr, networkStats);
    }

    @Override // mtopsdk.network.Ext
    public boolean isNoNetworkError(int i) {
        return i == -200;
    }
}
