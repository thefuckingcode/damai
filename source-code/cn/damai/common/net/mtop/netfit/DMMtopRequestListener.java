package cn.damai.common.net.mtop.netfit;

import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.net.mtop.Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public abstract class DMMtopRequestListener<T> implements IRemoteBaseListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<T> clazz;
    public boolean isShowLoginUI;

    public DMMtopRequestListener(Class<T> cls) {
        this.clazz = cls;
    }

    private void XFlushUtilFail(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739589616")) {
            ipChange.ipc$dispatch("739589616", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        yz2.c(str, "mtop", str2 + " 自定义code=" + str3 + AltriaXLaunchTime.SPACE + str4, str5, str6);
    }

    private void errorLog(int i, MtopResponse mtopResponse, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944008590")) {
            ipChange.ipc$dispatch("1944008590", new Object[]{this, Integer.valueOf(i), mtopResponse, str});
            return;
        }
        String str3 = "   requestType=" + i + "  DMMtopRequestListener  fromError= " + str;
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
        if (AndroidInstantRuntime.support(ipChange, "-224873413")) {
            return (String) ipChange.ipc$dispatch("-224873413", new Object[]{this, mtopResponse});
        } else if (mtopResponse == null) {
            return null;
        } else {
            return Util.getApiParam(mtopResponse.getApi(), mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().url : "");
        }
    }

    private void reloadNetworkErrorXFlushMonitor(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386507605")) {
            ipChange.ipc$dispatch("-386507605", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        XFlushUtilFail(str2, yz2.i(str, str2, str4, str5, str6 + "  DMMtopRequestListener"), str3, str5, str4, str5);
    }

    public void dispatchStringResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878220674")) {
            ipChange.ipc$dispatch("1878220674", new Object[]{this, str});
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "330833763")) {
            ipChange.ipc$dispatch("330833763", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
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

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: cn.damai.common.net.mtop.netfit.DMMtopRequestListener<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Exception e;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16 = "";
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1721156404")) {
            ipChange.ipc$dispatch("1721156404", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
        } else if (mtopResponse != null) {
            try {
                String str17 = new String(mtopResponse.getBytedata(), "UTF-8");
                DMMtopBaseData dMMtopBaseData = (DMMtopBaseData) JSON.parseObject(str17, DMMtopBaseData.class);
                if (dMMtopBaseData != null) {
                    String data = dMMtopBaseData.getData();
                    JSONObject parseObject = JSON.parseObject(data);
                    if (!data.equalsIgnoreCase(str16)) {
                        String string = parseObject.getString("errorCode");
                        String string2 = parseObject.getString("errorMsg");
                        if (!TextUtils.isEmpty(string)) {
                            onFail(string, string2);
                            errorLog(i, mtopResponse, "onsuccess_to_error");
                            return;
                        }
                        Class<T> cls = this.clazz;
                        String api = dMMtopBaseData.getApi();
                        if (mtopResponse.getMtopStat() != null) {
                            str16 = mtopResponse.getMtopStat().url;
                        }
                        Object b = s41.b(data, cls, Util.getApiParam(api, str16), ERROR.MTOP_XFLUSH_PARSE_CODE, string, string2 + "  DMMtopRequestListener");
                        if (b != null) {
                            try {
                                dispatchStringResult(data);
                                onSuccess(b);
                                yz2.f(getAlarmApiName(mtopResponse), "mtop", ERROR.MTOP_XFLUSH_SUCCESS_CODE, "-", "traceId = " + Util.getTraceId(mtopResponse));
                            } catch (Exception e2) {
                                e = e2;
                                str8 = string2;
                                str7 = string;
                                str9 = data;
                                e.printStackTrace();
                                Log.e("parse_1", e.getMessage());
                                Class<T> cls2 = this.clazz;
                                if (cls2 != null) {
                                    str10 = cls2.getName();
                                } else {
                                    str10 = "class是null";
                                }
                                if (TextUtils.isEmpty(getAlarmApiName(mtopResponse))) {
                                    str11 = "apiName未正常获取";
                                } else {
                                    str11 = getAlarmApiName(mtopResponse);
                                }
                                if (TextUtils.isEmpty(str7)) {
                                    str12 = "parse_1";
                                } else {
                                    str12 = str7;
                                }
                                if ((str9 + AltriaXLaunchTime.SPACE + "DMMtopRequestListener" + " " + e) != null) {
                                    str13 = " trace=" + xk2.a(e);
                                } else {
                                    str13 = null;
                                }
                                reloadNetworkErrorXFlushMonitor(str10, str11, "-1000000", str12, str8, str13);
                                onFail("parse_1", "麦麦开小差了");
                            }
                        } else {
                            Class<T> cls3 = this.clazz;
                            if (cls3 != null) {
                                str14 = cls3.getName();
                            } else {
                                str14 = "class是null";
                            }
                            if (TextUtils.isEmpty(getAlarmApiName(mtopResponse))) {
                                str15 = "apiName未正常获取";
                            } else {
                                str15 = getAlarmApiName(mtopResponse);
                            }
                            str8 = string2;
                            str7 = string;
                            str9 = data;
                            try {
                                reloadNetworkErrorXFlushMonitor(str14, str15, "-1000000", "parse_0", "解析数据返回为null", str17);
                                onFail("parse_0", "麦麦开小差了");
                            } catch (Exception e3) {
                                e = e3;
                            }
                        }
                    } else {
                        Class<T> cls4 = this.clazz;
                        if (cls4 != null) {
                            str5 = cls4.getName();
                        } else {
                            str5 = "class是null";
                        }
                        if (TextUtils.isEmpty(getAlarmApiName(mtopResponse))) {
                            str6 = "apiName未正常获取";
                        } else {
                            str6 = getAlarmApiName(mtopResponse);
                        }
                        reloadNetworkErrorXFlushMonitor(str5, str6, "-1000000", "parse_2", "result为null", str17);
                        onFail("parse_2", "麦麦开小差了");
                    }
                } else {
                    Class<T> cls5 = this.clazz;
                    if (cls5 != null) {
                        str3 = cls5.getName();
                    } else {
                        str3 = "class是null";
                    }
                    if (TextUtils.isEmpty(getAlarmApiName(mtopResponse))) {
                        str4 = "apiName未正常获取";
                    } else {
                        str4 = getAlarmApiName(mtopResponse);
                    }
                    reloadNetworkErrorXFlushMonitor(str3, str4, "-1000000", "parse_3", "mtopBaseData为null", str17);
                    onFail("parse_3", "麦麦开小差了");
                }
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                Class<T> cls6 = this.clazz;
                if (cls6 != null) {
                    str = cls6.getName();
                } else {
                    str = "class是null";
                }
                if (TextUtils.isEmpty(getAlarmApiName(mtopResponse))) {
                    str2 = "apiName未正常获取";
                } else {
                    str2 = getAlarmApiName(mtopResponse);
                }
                reloadNetworkErrorXFlushMonitor(str, str2, "-1000000", "parse_4", "result为null", xk2.a(e4));
                onFail("parse_4", "麦麦开小差了");
            }
        }
    }

    public abstract void onSuccess(T t);

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947835508")) {
            ipChange.ipc$dispatch("947835508", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
            return;
        }
        if (mtopResponse != null) {
            DMMtopErrorHelper.instance().setIsShowLoginUI(this.isShowLoginUI).error(mtopResponse);
            if (!mtopResponse.isSessionInvalid() || !this.isShowLoginUI) {
                onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
            } else {
                onFail(mtopResponse.getRetCode(), "");
            }
        } else {
            onFail("", "");
        }
        errorLog(i, mtopResponse, "onSystemError");
    }

    public void setShowLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864864782")) {
            ipChange.ipc$dispatch("-864864782", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowLoginUI = z;
    }
}
