package com.taobao.analysis.v3;

import com.ali.user.open.tbauth.TbAuthConstants;
import tb.ja1;
import tb.qf2;
import tb.x11;

/* compiled from: Taobao */
public interface FalcoNetworkAbilitySpan extends FalcoAbilitySpan {
    public static final qf2 API_NAME = new qf2("apiName");
    public static final qf2 BIZ_ID = new qf2("bizID");
    public static final ja1 DESERIALIZE_TIME = new ja1("deserializeTime");
    public static final ja1 DISK_CACHE_LOOKUP_TIME = new ja1("diskCacheLookupTime");
    public static final ja1 FIRST_DATA_TIME = new ja1("firstDataTime");
    public static final qf2 HOST = new qf2("host");
    public static final qf2 IP = new qf2(TbAuthConstants.IP);
    public static final x11 IS_CB_MAIN = new x11("isCbMain");
    public static final x11 IS_REQ_MAIN = new x11("isReqMain");
    public static final x11 IS_REQ_SYNC = new x11("isReqSync");
    public static final x11 LAUNCH_TYPE = new x11("launchType");
    public static final ja1 MTOP_SIGN_TIME = new ja1("signTime");
    public static final qf2 NET_TYPE = new qf2("netType");
    public static final x11 PAGE_INDEX = new x11("pageIndex");
    public static final x11 PIC_DATA_FROM = new x11("dataFrom");
    public static final qf2 PROTOCOL_TYPE = new qf2("protocolType");
    public static final ja1 REQ_DEFLATE_SIZE = new ja1("reqDeflateSize");
    public static final ja1 REQ_INFLATE_SIZE = new ja1("reqInflateSize");
    public static final x11 RET = new x11("ret");
    public static final x11 RETRY_TIMES = new x11("retryTimes");
    public static final ja1 RSP_DEFLATE_SIZE = new ja1("rspDeflateSize");
    public static final ja1 RSP_INFLATE_SIZE = new ja1("rspInflateSize");
    public static final ja1 SEND_DATA_TIME = new ja1("sendDataTime");
    public static final qf2 SERVER_TRACE_ID = new qf2("serverTraceID");
    public static final qf2 TOPIC = new qf2("topic");
    public static final qf2 URL = new qf2("url");

    void callbackDispatch(Long l);

    void callbackEnd(Long l);

    void callbackStart(Long l);

    void requestProcessStart(Long l);

    void requestSendStart(Long l);

    void requestStart(Long l);

    void responseProcessStart(Long l);

    void responseReceiveEnd(Long l);

    void responseReceiveStart(Long l);

    void serverRT(long j);
}
