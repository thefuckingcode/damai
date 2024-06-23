package mtopsdk.network.util;

import android.text.TextUtils;
import anetwork.channel.Header;
import anetwork.channel.Request;
import anetwork.channel.statist.StatisticData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.network.domain.NetworkStats;
import mtopsdk.network.domain.ParcelableRequestBodyImpl;
import mtopsdk.network.impl.ParcelableRequestBodyEntry;
import mtopsdk.network.util.Constants;
import tb.ab;
import tb.e02;

/* compiled from: Taobao */
public final class ANetworkConverter {
    public static NetworkStats convertNetworkStats(StatisticData statisticData) {
        if (statisticData == null) {
            return null;
        }
        NetworkStats networkStats = new NetworkStats();
        networkStats.resultCode = statisticData.resultCode;
        networkStats.isRequestSuccess = statisticData.isRequestSuccess;
        networkStats.host = statisticData.host;
        networkStats.ip_port = statisticData.ip_port;
        networkStats.connectionType = statisticData.connectionType;
        networkStats.isSSL = statisticData.isSSL;
        networkStats.oneWayTime_ANet = statisticData.oneWayTime_ANet;
        networkStats.processTime = statisticData.processTime;
        networkStats.firstDataTime = statisticData.firstDataTime;
        networkStats.sendWaitTime = statisticData.sendBeforeTime;
        networkStats.recDataTime = statisticData.recDataTime;
        networkStats.sendSize = statisticData.sendSize;
        networkStats.recvSize = statisticData.totalSize;
        networkStats.serverRT = statisticData.serverRT;
        networkStats.dataSpeed = statisticData.dataSpeed;
        networkStats.retryTimes = statisticData.retryTime;
        return networkStats;
    }

    public static Request convertRequest(mtopsdk.network.domain.Request request) {
        e02 e02 = new e02(request.url);
        e02.setSeqNo(request.seqNo);
        e02.setRetryTime(request.retryTimes);
        e02.setConnectTimeout(request.connectTimeoutMills);
        e02.setReadTimeout(request.readTimeoutMills);
        if (!TextUtils.isEmpty(request.bizIdStr)) {
            e02.setBizId(request.bizIdStr);
        } else {
            e02.setBizId(request.bizId);
        }
        e02.setMethod(request.method);
        e02.setHeaders(createRequestHeaders(request.headers));
        e02.setExtProperty("APPKEY", request.appKey);
        e02.setExtProperty("AuthCode", request.authCode);
        if (!TextUtils.isEmpty(request.fullTraceId)) {
            e02.setExtProperty("f-traceId", request.fullTraceId);
        }
        int i = request.env;
        if (i == 0) {
            e02.setExtProperty("ENVIRONMENT", "online");
        } else if (i == 1) {
            e02.setExtProperty("ENVIRONMENT", "pre");
        } else if (i == 2) {
            e02.setExtProperty("ENVIRONMENT", "test");
        }
        if ("POST".equalsIgnoreCase(request.method)) {
            ParcelableRequestBodyImpl parcelableRequestBodyImpl = (ParcelableRequestBodyImpl) request.body;
            e02.setBodyEntry(new ParcelableRequestBodyEntry(parcelableRequestBodyImpl));
            e02.addHeader("Content-Type", parcelableRequestBodyImpl.contentType());
            long contentLength = parcelableRequestBodyImpl.contentLength();
            if (contentLength > 0) {
                e02.addHeader(Constants.Protocol.CONTENT_LENGTH, String.valueOf(contentLength));
            }
        }
        return e02;
    }

    public static List<Header> createRequestHeaders(Map<String, String> map) {
        if (map == null || map.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && StringUtils.isNotBlank(entry.getKey())) {
                arrayList.add(new ab(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }
}
