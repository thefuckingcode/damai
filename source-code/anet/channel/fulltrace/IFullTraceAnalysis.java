package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import tb.c42;

/* compiled from: Taobao */
public interface IFullTraceAnalysis {

    /* compiled from: Taobao */
    public interface Stage {
        public static final String FINISH = "netFinish";
        public static final String REQ_PROCESS_START = "netReqProcessStart";
        public static final String REQ_SEND_START = "netReqSendStart";
        public static final String REQ_START = "netReqStart";
        public static final String RSP_CB_DISPATCH = "netRspCbDispatch";
        public static final String RSP_CB_END = "netRspCbEnd";
        public static final String RSP_CB_START = "netRspCbStart";
        public static final String RSP_RECV_END = "netRspRecvEnd";
    }

    void commitRequest(String str, RequestStatistic requestStatistic);

    String createRequest();

    c42 getSceneInfo();

    void log(String str, String str2, String str3);
}
