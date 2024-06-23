package com.youku.live.dago.widgetlib.ailpbaselib.net.mtop;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;

/* compiled from: Taobao */
public class MtopHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String API_VERSION_1_0 = "1.0";
    private static final int CONNECT_TIME_OUT = 10000;
    public static final int MAX_REQUESTS_PER_HOST = 15000;
    public static final String MTOP = "mtop.youku.platform";
    private static final int READ_TIME_OUT = 40000;
    private static final int RETRY_TIMES = 2000;
    private static final int SOCKET_TIME_OUT = 10000;
    public static final String TAG = "MtopHelper";
    private static final int WRITE_TIME_OUT = 40000;
    private static volatile MtopHelper instance;

    private MtopHelper() {
    }

    private void buildMtopBussiness(MtopBusiness mtopBusiness, final String str, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89890754")) {
            ipChange.ipc$dispatch("-89890754", new Object[]{this, mtopBusiness, str, map, Boolean.valueOf(z), iRemoteBaseListener});
            return;
        }
        mtopBusiness.reqMethod(z ? MethodEnum.GET : MethodEnum.POST);
        mtopBusiness.headers(buildRequestHeader(str, map));
        if (iRemoteBaseListener != null) {
            mtopBusiness.registerListener((IRemoteListener) iRemoteBaseListener);
        } else {
            mtopBusiness.registerListener((IRemoteListener) new IRemoteBaseListener() {
                /* class com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopHelper.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1262153271")) {
                        ipChange.ipc$dispatch("-1262153271", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                        return;
                    }
                    MtopHelper.this.callbackToOkHttpRequest(str, mtopResponse);
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2031629710")) {
                        ipChange.ipc$dispatch("2031629710", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                        return;
                    }
                    MtopHelper.this.callbackToOkHttpRequest(str, mtopResponse);
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1739988902")) {
                        ipChange.ipc$dispatch("-1739988902", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                        return;
                    }
                    MtopHelper.this.callbackToOkHttpRequest(str, mtopResponse);
                }
            });
        }
    }

    private Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-311948442")) {
            return new HashMap();
        }
        return (Map) ipChange.ipc$dispatch("-311948442", new Object[]{this, str, map});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void callbackToOkHttpRequest(String str, MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710822678")) {
            ipChange.ipc$dispatch("710822678", new Object[]{this, str, mtopResponse});
            return;
        }
        fetchCommonError(mtopResponse);
    }

    private void fetchCommonError(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964002214")) {
            ipChange.ipc$dispatch("-1964002214", new Object[]{this, mtopResponse});
            return;
        }
        Log.e("fornia", "passport  sendTokenValidBroadCast55555");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[SYNTHETIC, Splitter:B:28:0x0070] */
    private String getEnv() {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        String str = "";
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954932639")) {
            return (String) ipChange.ipc$dispatch("1954932639", new Object[]{this});
        }
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(AppContextUtils.getApp().getFilesDir().getAbsolutePath() + "/fornia", "env.txt");
            if (!file.exists()) {
                return str;
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                str = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            }
            return str;
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static MtopHelper getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521860541")) {
            return (MtopHelper) ipChange.ipc$dispatch("1521860541", new Object[0]);
        }
        if (instance == null) {
            synchronized (MtopHelper.class) {
                if (instance == null) {
                    instance = new MtopHelper();
                }
            }
        }
        return instance;
    }

    public static final Class getSuperClassGenricType(Class cls) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "67574465")) {
            return getSuperClassGenricType(cls, 0);
        }
        return (Class) ipChange.ipc$dispatch("67574465", new Object[]{cls});
    }

    private boolean isSuccessCode(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1552431621")) {
            return i >= 200 && i < 300;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1552431621", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    public void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401304863")) {
            ipChange.ipc$dispatch("-1401304863", new Object[]{this, mtopRequest, str, str2, Boolean.valueOf(z), map});
        } else if (TextUtils.isEmpty(str)) {
            ((ILog) Dsl.getService(ILog.class)).e(TAG, "mtop url api is empty!!!");
        } else {
            mtopRequest.setApiName(str);
            if (TextUtils.isEmpty(str2)) {
                mtopRequest.setVersion(API_VERSION_1_0);
            } else {
                mtopRequest.setVersion(str2);
            }
            mtopRequest.setNeedEcode(z);
            if (map == null) {
                map = new HashMap<>();
            }
            mtopRequest.setData(ReflectUtil.convertMapToDataStr(map));
        }
    }

    public <T> String doRequest(final String str, String str2, Map<String, String> map, boolean z, final GeneralCallback<T> generalCallback) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-142000024")) {
            return doRequest(str, map, z, new IRemoteBaseListener() {
                /* class com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopHelper.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-654076408")) {
                        ipChange.ipc$dispatch("-654076408", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                    } else if (mtopResponse != null) {
                        mtopResponse.getDataJsonObject();
                        ((ILog) Dsl.getService(ILog.class)).i("fornia", "mtopResponse:" + mtopResponse);
                        GeneralCallback generalCallback = generalCallback;
                        if (generalCallback != null) {
                            generalCallback.onFailure("onError:" + mtopResponse.getRetMsg());
                        }
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1064602321")) {
                        ipChange.ipc$dispatch("-1064602321", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i("fornia", "mtopResponse:" + mtopResponse);
                    if (mtopResponse != null) {
                        mtopResponse.getDataJsonObject();
                        if (generalCallback == null) {
                            return;
                        }
                        if (mtopResponse.getDataJsonObject() == null) {
                            generalCallback.onSuccess(null);
                            return;
                        }
                        try {
                            generalCallback.onSuccess(JSON.parseObject(mtopResponse.getDataJsonObject().toString(), MtopHelper.getSuperClassGenricType(generalCallback.getClass())));
                        } catch (Exception e) {
                            e.printStackTrace();
                            generalCallback.onFailure("onError:onSuccess json解析错误");
                        }
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-784467623")) {
                        ipChange.ipc$dispatch("-784467623", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i("fornia", "mtopResponse:" + mtopResponse);
                    if (mtopResponse != null) {
                        mtopResponse.getDataJsonObject();
                        GeneralCallback generalCallback = generalCallback;
                        if (generalCallback != null) {
                            generalCallback.onFailure("onSystemError:" + mtopResponse.getRetMsg());
                        }
                    }
                }
            }, str2, false);
        }
        return (String) ipChange.ipc$dispatch("-142000024", new Object[]{this, str, str2, map, Boolean.valueOf(z), generalCallback});
    }

    private static final Class getSuperClassGenricType(Class cls, int i) throws IndexOutOfBoundsException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314398236")) {
            return (Class) ipChange.ipc$dispatch("314398236", new Object[]{cls, Integer.valueOf(i)});
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (i >= actualTypeArguments.length || i < 0 || !(actualTypeArguments[i] instanceof Class)) {
            return Object.class;
        }
        return (Class) actualTypeArguments[i];
    }

    public String doRequest(String str, String str2, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1645441339")) {
            return doRequest(str, map, z, iRemoteBaseListener, str2, false);
        }
        return (String) ipChange.ipc$dispatch("1645441339", new Object[]{this, str, str2, map, Boolean.valueOf(z), iRemoteBaseListener});
    }

    public String doRequest(String str, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener, String str2, boolean z2) {
        MtopBusiness mtopBusiness;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220925403")) {
            return (String) ipChange.ipc$dispatch("-220925403", new Object[]{this, str, map, Boolean.valueOf(z), iRemoteBaseListener, str2, Boolean.valueOf(z2)});
        }
        MtopRequest mtopRequest = new MtopRequest();
        buildMtopRequest(mtopRequest, str, str2, z2, map);
        if (SdkChannel.isDamai(AppContextUtils.getApp())) {
            mtopBusiness = MtopBusiness.build(Mtop.instance(((INetClient) Dsl.getService(INetClient.class)).getMtopId(), AppContextUtils.getApp()), mtopRequest);
        } else {
            mtopBusiness = MtopBusiness.build(Mtop.instance(Mtop.Id.INNER, AppContextUtils.getApp()), mtopRequest);
        }
        buildMtopBussiness(mtopBusiness, str, map, z, iRemoteBaseListener);
        mtopBusiness.startRequest();
        return null;
    }
}
