package mtopsdk.framework.util;

import android.os.Handler;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.after.ErrorCodeMappingAfterFilter;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
public final class FilterUtils {
    public static final ErrorCodeMappingAfterFilter errorCodeMappingAfterFilter = new ErrorCodeMappingAfterFilter();

    public static void checkFilterManager(FilterManager filterManager, MtopContext mtopContext) {
        if (filterManager == null) {
            MtopResponse mtopResponse = new MtopResponse(ErrorConstant.ERRCODE_MTOPSDK_INIT_ERROR, ErrorConstant.ERRMSG_MTOPSDK_INIT_ERROR);
            MtopRequest mtopRequest = mtopContext.mtopRequest;
            if (mtopRequest != null) {
                mtopResponse.setApi(mtopRequest.getApiName());
                mtopResponse.setV(mtopContext.mtopRequest.getVersion());
            }
            mtopContext.mtopResponse = mtopResponse;
            handleExceptionCallBack(mtopContext);
        }
    }

    public static void handleExceptionCallBack(final MtopContext mtopContext) {
        final MtopResponse mtopResponse = mtopContext.mtopResponse;
        if (mtopResponse != null && (mtopContext.mtopListener instanceof MtopCallback.MtopFinishListener)) {
            mtopResponse.setMtopStat(mtopContext.stats);
            final MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
            mtopFinishEvent.seqNo = mtopContext.seqNo;
            mtopContext.stats.rspCbDispatch = System.currentTimeMillis();
            errorCodeMappingAfterFilter.doAfter(mtopContext);
            submitCallbackTask(mtopContext.property.handler, new Runnable() {
                /* class mtopsdk.framework.util.FilterUtils.AnonymousClass1 */

                public void run() {
                    try {
                        mtopContext.stats.serverTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.SERVER_TRACE_ID);
                        mtopContext.stats.eagleEyeTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.EAGLE_TRACE_ID);
                        mtopContext.stats.statusCode = mtopResponse.getResponseCode();
                        mtopContext.stats.retCode = mtopResponse.getRetCode();
                        mtopContext.stats.mappingCode = mtopResponse.getMappingCode();
                        if (mtopResponse.isApiSuccess()) {
                            MtopStatistics mtopStatistics = mtopContext.stats;
                            if (3 == mtopStatistics.cacheHitType) {
                                mtopStatistics.statusCode = 304;
                            }
                        }
                        MtopContext mtopContext = mtopContext;
                        boolean z = !(mtopContext.mtopBuilder instanceof MtopBusiness);
                        if (z) {
                            mtopContext.stats.rspCbStart = System.currentTimeMillis();
                        }
                        MtopContext mtopContext2 = mtopContext;
                        ((MtopCallback.MtopFinishListener) mtopContext2.mtopListener).onFinished(mtopFinishEvent, mtopContext2.property.reqContext);
                        mtopContext.stats.onEndAndCommit();
                        if (z) {
                            mtopContext.stats.rspCbEnd = System.currentTimeMillis();
                            mtopContext.stats.commitFullTrace();
                        }
                    } catch (Exception unused) {
                    }
                }
            }, mtopContext.seqNo.hashCode());
        }
    }

    public static void parseRetCodeFromHeader(MtopResponse mtopResponse) {
        if (mtopResponse != null) {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_RETCODE);
            mtopResponse.mappingCodeSuffix = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_MAPPING_CODE);
            if (StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                mtopResponse.setRetCode(singleHeaderFieldByKey);
            } else {
                mtopResponse.parseJsonByte();
            }
        }
    }

    public static void submitCallbackTask(Handler handler, Runnable runnable, int i) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            MtopSDKThreadPoolExecutorFactory.submitCallbackTask(i, runnable);
        }
    }
}
