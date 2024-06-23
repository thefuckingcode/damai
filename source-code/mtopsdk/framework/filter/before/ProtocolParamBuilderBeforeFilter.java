package mtopsdk.framework.filter.before;

import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.xstate.util.XStateConstants;
import tb.jl1;

/* compiled from: Taobao */
public class ProtocolParamBuilderBeforeFilter implements IBeforeFilter {
    private static final String TAG = "mtopsdk.ProtocolParamBuilderBeforeFilter";
    private ProtocolParamBuilder paramBuilder;

    public ProtocolParamBuilderBeforeFilter(ProtocolParamBuilder protocolParamBuilder) {
        this.paramBuilder = protocolParamBuilder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        Map<String, String> map;
        Throwable th;
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopResponse mtopResponse = null;
        try {
            map = this.paramBuilder.buildParams(mtopContext);
            if (map == null) {
                try {
                    mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), ErrorConstant.ERRCODE_INIT_MTOP_ISIGN_ERROR, ErrorConstant.ERRMSG_INIT_MTOP_ISIGN_ERROR);
                } catch (Throwable th2) {
                    th = th2;
                    TBSdkLog.e(TAG, mtopContext.seqNo, "[deBefore]execute ProtocolParamBuilder buildParams error.", th);
                    mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), ErrorConstant.ERRCODE_BUILD_PROTOCOL_PARAMS_ERROR, ErrorConstant.ERRMSG_BUILD_PROTOCOL_PARAMS_ERROR);
                    if (mtopResponse != null) {
                    }
                }
            } else if (map.get("sign") == null) {
                String str = map.get(XStateConstants.KEY_SG_ERROR_CODE);
                StringBuilder sb = new StringBuilder(48);
                sb.append(ErrorConstant.ERRCODE_GENERATE_MTOP_SIGN_ERROR);
                if (str != null) {
                    sb.append(jl1.BRACKET_START_STR);
                    sb.append(str);
                    sb.append(jl1.BRACKET_END_STR);
                }
                mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), sb.toString(), ErrorConstant.ERRMSG_GENERATE_MTOP_SIGN_ERROR);
            }
        } catch (Throwable th3) {
            map = null;
            th = th3;
            TBSdkLog.e(TAG, mtopContext.seqNo, "[deBefore]execute ProtocolParamBuilder buildParams error.", th);
            mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), ErrorConstant.ERRCODE_BUILD_PROTOCOL_PARAMS_ERROR, ErrorConstant.ERRMSG_BUILD_PROTOCOL_PARAMS_ERROR);
            if (mtopResponse != null) {
            }
        }
        if (mtopResponse != null) {
            mtopContext.mtopResponse = mtopResponse;
            FilterUtils.handleExceptionCallBack(mtopContext);
            return "STOP";
        }
        mtopContext.protocolParams = map;
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
