package mtopsdk.framework.filter.before;

import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
public class CheckRequestParamBeforeFilter implements IBeforeFilter {
    private static final String TAG = "mtopsdk.CheckRequestParamBeforeFilter";

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b2 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b4 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    private boolean checkRequiredParam(MtopContext mtopContext) {
        String str;
        String str2;
        MtopResponse mtopResponse;
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        String str3 = mtopContext.seqNo;
        MtopResponse mtopResponse2 = null;
        if (mtopRequest == null) {
            str2 = "mtopRequest is invalid.mtopRequest=null";
            mtopResponse = new MtopResponse(ErrorConstant.ERRCODE_MTOPCONTEXT_INIT_ERROR, str2);
        } else if (!mtopRequest.isLegalRequest()) {
            str2 = "mtopRequest is invalid. " + mtopRequest.toString();
            mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), ErrorConstant.ERRCODE_MTOPCONTEXT_INIT_ERROR, str2);
        } else if (mtopNetworkProp == null) {
            str2 = "MtopNetworkProp is invalid.property=null";
            mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), ErrorConstant.ERRCODE_MTOPCONTEXT_INIT_ERROR, str2);
        } else {
            str = null;
            mtopContext.mtopResponse = mtopResponse2;
            if (StringUtils.isNotBlank(str) && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, str3, "[checkRequiredParam]" + str);
            }
            if (mtopRequest != null && TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, str3, "[checkRequiredParam]" + mtopRequest.toString());
            }
            FilterUtils.handleExceptionCallBack(mtopContext);
            if (!SwitchConfig.getInstance().isGlobalSpdySslSwitchOpen()) {
                TBSdkLog.w(TAG, str3, "[checkRequiredParam]MTOP SSL switch is false");
                mtopContext.property.protocol = ProtocolEnum.HTTP;
            }
            return mtopResponse2 != null;
        }
        mtopResponse2 = mtopResponse;
        str = str2;
        mtopContext.mtopResponse = mtopResponse2;
        TBSdkLog.e(TAG, str3, "[checkRequiredParam]" + str);
        TBSdkLog.d(TAG, str3, "[checkRequiredParam]" + mtopRequest.toString());
        FilterUtils.handleExceptionCallBack(mtopContext);
        if (!SwitchConfig.getInstance().isGlobalSpdySslSwitchOpen()) {
        }
        if (mtopResponse2 != null) {
        }
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        return checkRequiredParam(mtopContext) ? "CONTINUE" : "STOP";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
