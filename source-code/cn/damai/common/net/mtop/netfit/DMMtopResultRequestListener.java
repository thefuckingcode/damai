package cn.damai.common.net.mtop.netfit;

import android.text.TextUtils;
import cn.damai.common.app.base.BaseErrorBean;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.net.mtop.netfit.DMMtopResultBaseData;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.uc.webview.export.media.MessageID;
import java.io.UnsupportedEncodingException;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import tb.s41;
import tb.xk2;
import tb.yz2;

/* compiled from: Taobao */
public abstract class DMMtopResultRequestListener<T> implements IRemoteBaseListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<T> clazz;
    public boolean isShowLoginUI;

    public DMMtopResultRequestListener(Class<T> cls) {
        this.clazz = cls;
    }

    private void XFlushUtilFail(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348286739")) {
            ipChange.ipc$dispatch("1348286739", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        yz2.c(str, "mtop", str2 + " 自定义code=" + str3 + AltriaXLaunchTime.SPACE + str4, str5, str6);
    }

    private void errorLog(int i, MtopResponse mtopResponse, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336955509")) {
            ipChange.ipc$dispatch("-1336955509", new Object[]{this, Integer.valueOf(i), mtopResponse, str});
            return;
        }
        String str3 = "   requestType=" + i + "  DMMtopRequestListener   fromError= " + str;
        if (mtopResponse == null) {
            try {
                XFlushUtilFail("", "服务端返回response为null", ERROR.MTOP_XFLUSH_ERROR_CODE, str3, "", "");
            } catch (Exception e) {
                String alarmApiName = getAlarmApiName(mtopResponse);
                if ((str3 + AltriaXLaunchTime.SPACE + e) != null) {
                    str2 = e.getMessage() + " trace=" + xk2.a(e);
                } else {
                    str2 = null;
                }
                String str4 = "";
                String retCode = mtopResponse == null ? str4 : mtopResponse.getRetCode();
                if (mtopResponse != null) {
                    str4 = mtopResponse.getRetMsg();
                }
                XFlushUtilFail(alarmApiName, "服务端异常trycatch", ERROR.MTOP_XFLUSH_ERROR_CODE, str2, retCode, str4);
            }
        } else {
            String e2 = s41.e(mtopResponse);
            XFlushUtilFail(getAlarmApiName(mtopResponse), mtopResponse.getRetCode(), ERROR.MTOP_XFLUSH_ERROR_CODE, e2 + str3, mtopResponse.getRetCode(), mtopResponse.getRetMsg());
        }
    }

    private String getAlarmApiName(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1390638174")) {
            return (String) ipChange.ipc$dispatch("1390638174", new Object[]{this, mtopResponse});
        } else if (mtopResponse == null) {
            return null;
        } else {
            return Util.getApiParam(mtopResponse.getApi(), mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().url : "");
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299024442")) {
            ipChange.ipc$dispatch("-1299024442", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
            return;
        }
        if (mtopResponse != null) {
            DMMtopErrorHelper.instance().setIsShowLoginUI(this.isShowLoginUI).error(mtopResponse);
            onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
        } else {
            onFail("", "");
        }
        errorLog(i, mtopResponse, MessageID.onError);
    }

    public abstract void onFail(String str, String str2);

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-634911439")) {
            ipChange.ipc$dispatch("-634911439", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
        } else if (mtopResponse != null) {
            try {
                String str2 = new String(mtopResponse.getBytedata(), "UTF-8");
                String alarmApiName = getAlarmApiName(mtopResponse);
                DMMtopResultBaseData.BaseMtopResponseData baseMtopResponseData = (DMMtopResultBaseData.BaseMtopResponseData) s41.a(str2, DMMtopResultBaseData.BaseMtopResponseData.class);
                String str3 = null;
                if (baseMtopResponseData == null || baseMtopResponseData.getData() == null) {
                    onFail("1000", "data为空");
                    Class<T> cls = this.clazz;
                    if (cls != null) {
                        str3 = cls.getName();
                    }
                    XFlushUtilFail(alarmApiName, yz2.i(str3, mtopResponse.getApi(), mtopResponse.getRetCode(), mtopResponse.getRetMsg(), s41.e(mtopResponse) + "  DMMtopResultRequestListener "), "-1000000", "data为空", mtopResponse.getRetCode(), mtopResponse.getRetMsg());
                    return;
                }
                String result = baseMtopResponseData.getData().getResult();
                if (TextUtils.isEmpty(result)) {
                    onFail("1000", "result为空");
                    Class<T> cls2 = this.clazz;
                    if (cls2 != null) {
                        str3 = cls2.getName();
                    }
                    XFlushUtilFail(alarmApiName, yz2.i(str3, mtopResponse.getApi(), mtopResponse.getRetCode(), mtopResponse.getRetMsg(), s41.e(mtopResponse) + " DMMtopResultRequestListener "), "-1000000", "result为空", mtopResponse.getRetCode(), mtopResponse.getRetMsg());
                    return;
                }
                BaseErrorBean baseErrorBean = (BaseErrorBean) s41.a(result, BaseErrorBean.class);
                if (baseErrorBean == null || (str = baseErrorBean.errorCode) == null) {
                    onSuccess(JSON.parseObject(result, this.clazz));
                    yz2.f(alarmApiName, "mtop", ERROR.MTOP_XFLUSH_SUCCESS_CODE, "-", "traceId = " + Util.getTraceId(mtopResponse));
                    return;
                }
                onFail(str, baseErrorBean.errorMsg);
                Class<T> cls3 = this.clazz;
                if (cls3 != null) {
                    str3 = cls3.getName();
                }
                XFlushUtilFail(alarmApiName, yz2.i(str3, mtopResponse.getApi(), mtopResponse.getRetCode() + " " + baseErrorBean.errorCode, mtopResponse.getRetMsg() + AltriaXLaunchTime.SPACE + baseErrorBean.errorMsg, s41.e(mtopResponse) + " DMMtopResultRequestListener "), ERROR.MTOP_XFLUSH_PARSE_CODE, "result解析异常", mtopResponse.getRetCode(), mtopResponse.getRetMsg());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void onSuccess(T t);

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731620201")) {
            ipChange.ipc$dispatch("-1731620201", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
            return;
        }
        if (mtopResponse != null) {
            DMMtopErrorHelper.instance().setIsShowLoginUI(this.isShowLoginUI).error(mtopResponse);
            onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
        } else {
            onFail("", "");
        }
        errorLog(i, mtopResponse, "onSystemError");
    }

    public void setShowLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000902993")) {
            ipChange.ipc$dispatch("-1000902993", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowLoginUI = z;
    }
}
