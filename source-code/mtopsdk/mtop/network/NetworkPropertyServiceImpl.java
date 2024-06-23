package mtopsdk.mtop.network;

import mtopsdk.common.util.TBSdkLog;
import tb.ss0;

/* compiled from: Taobao */
public class NetworkPropertyServiceImpl implements NetworkPropertyService {
    private static final String TAG = "mtopsdk.NetworkPropertyServiceImpl";

    @Override // mtopsdk.mtop.network.NetworkPropertyService
    public void setTtid(String str) {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setTtid] set NetworkProperty ttid =" + str);
        }
        ss0.p(str);
    }

    @Override // mtopsdk.mtop.network.NetworkPropertyService
    public void setUserId(String str) {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setUserId] set NetworkProperty UserId =" + str);
        }
        ss0.q(str);
    }
}
