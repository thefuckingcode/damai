package com.taobao.orange.sync;

import android.text.TextUtils;
import anet.channel.request.a;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import tb.pd;

/* compiled from: Taobao */
public class NetworkInterceptor implements Interceptor {
    private static final String ORANGE_LOCAL_ENV = "a-orange-env";
    static final String ORANGE_REQ_HEADER = "a-orange-q";
    private static final String ORANGE_REQ_HEADER_DIFF = "a-orange-dq";
    static final String ORANGE_RES_HEADER = "a-orange-p";
    private static final String ORANGE_RES_HEADER_DIFF = "a-orange-dp";
    static final String TAG = "NetworkInterceptor";

    private a.b addLocalEnvToBuilder(a.b bVar) {
        if (GlobalOrange.indexEnvCheck) {
            if (OConstant.ENV.ONLINE == GlobalOrange.env) {
                bVar.I(ORANGE_LOCAL_ENV, "prod");
            } else if (OConstant.ENV.PREPARE == GlobalOrange.env) {
                bVar.I(ORANGE_LOCAL_ENV, "pre");
            } else if (OConstant.ENV.TEST == GlobalOrange.env) {
                bVar.I(ORANGE_LOCAL_ENV, "daily");
            }
        }
        return bVar;
    }

    static String getOrangeFromKey(Map<String, List<String>> map, String str) {
        List<String> list;
        Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                list = null;
                break;
            }
            Map.Entry<String, List<String>> next = it.next();
            if (str.equalsIgnoreCase(next.getKey())) {
                list = next.getValue();
                break;
            }
        }
        if (list == null || list.isEmpty()) {
            OLog.w(TAG, "getOrangeFromKey fail", "not exist a-orange-p");
            return null;
        }
        for (String str2 : list) {
            if (str2 != null && str2.startsWith("resourceId")) {
                if (OLog.isPrintLog(1)) {
                    OLog.d(TAG, "getOrangeFromKey", "value", str2);
                }
                try {
                    return URLDecoder.decode(str2, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    OLog.w(TAG, "getOrangeFromKey", e, new Object[0]);
                    return null;
                }
            }
        }
        OLog.w(TAG, "getOrangeFromKey fail", "parseValue no resourceId");
        return null;
    }

    @Override // anetwork.channel.interceptor.Interceptor
    public Future intercept(final Interceptor.Chain chain) {
        boolean z;
        a.b bVar;
        a request = chain.request();
        Callback callback = chain.callback();
        boolean z2 = false;
        if (GlobalOrange.indexUpdMode != OConstant.UPDMODE.O_EVENT && !TextUtils.isEmpty(request.h()) && !GlobalOrange.probeHosts.isEmpty()) {
            Iterator<String> it = GlobalOrange.probeHosts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (request.h().contains(it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (GlobalOrange.processIsolated && GlobalOrange.isChannelProcess && OConstant.SUB_PROCESS_INDEX_QUERY_HOSTS[GlobalOrange.env.getEnvMode()].equals(request.h())) {
            z = true;
            z2 = true;
        }
        if (z) {
            if (GlobalOrange.indexDiff > 0) {
                if (z2) {
                    bVar = chain.request().u().K(true);
                } else {
                    bVar = chain.request().u();
                }
                a.b addLocalEnvToBuilder = addLocalEnvToBuilder(bVar);
                int i = GlobalOrange.indexDiff;
                if (i == 1) {
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeader)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader);
                    }
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeaderDiff)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER_DIFF, GlobalOrange.reqOrangeHeaderDiff);
                    }
                    request = addLocalEnvToBuilder.J();
                } else if (i != 2) {
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeader)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader);
                    }
                    request = addLocalEnvToBuilder.J();
                } else {
                    if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeaderDiff)) {
                        addLocalEnvToBuilder.I(ORANGE_REQ_HEADER_DIFF, GlobalOrange.reqOrangeHeaderDiff);
                    }
                    request = addLocalEnvToBuilder.J();
                }
            } else if (!TextUtils.isEmpty(GlobalOrange.reqOrangeHeader)) {
                a.b addLocalEnvToBuilder2 = addLocalEnvToBuilder(chain.request().u());
                if (z2) {
                    request = addLocalEnvToBuilder2.K(true).I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader).J();
                } else {
                    request = addLocalEnvToBuilder2.I(ORANGE_REQ_HEADER, GlobalOrange.reqOrangeHeader).J();
                }
            }
            callback = new Callback() {
                /* class com.taobao.orange.sync.NetworkInterceptor.AnonymousClass1 */

                @Override // anetwork.channel.interceptor.Callback
                public void onDataReceiveSize(int i, int i2, pd pdVar) {
                    chain.callback().onDataReceiveSize(i, i2, pdVar);
                }

                @Override // anetwork.channel.interceptor.Callback
                public void onFinish(DefaultFinishEvent defaultFinishEvent) {
                    chain.callback().onFinish(defaultFinishEvent);
                }

                @Override // anetwork.channel.interceptor.Callback
                public void onResponseCode(int i, final Map<String, List<String>> map) {
                    if (map != null) {
                        if (GlobalOrange.indexDiff > 0) {
                            if (map.containsKey(NetworkInterceptor.ORANGE_RES_HEADER_DIFF)) {
                                OThreadFactory.execute(new Runnable() {
                                    /* class com.taobao.orange.sync.NetworkInterceptor.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        try {
                                            AndroidUtil.setThreadPriority();
                                            String orangeFromKey = NetworkInterceptor.getOrangeFromKey(map, NetworkInterceptor.ORANGE_RES_HEADER_DIFF);
                                            GlobalOrange.indexResponseHeader = NetworkInterceptor.ORANGE_RES_HEADER_DIFF;
                                            IndexUpdateHandler.updateIndex(orangeFromKey, false);
                                        } catch (Throwable th) {
                                            OLog.e(NetworkInterceptor.TAG, "intercept", th, new Object[0]);
                                        }
                                    }
                                });
                            } else if (map.containsKey(NetworkInterceptor.ORANGE_RES_HEADER)) {
                                OThreadFactory.execute(new Runnable() {
                                    /* class com.taobao.orange.sync.NetworkInterceptor.AnonymousClass1.AnonymousClass2 */

                                    public void run() {
                                        try {
                                            AndroidUtil.setThreadPriority();
                                            String orangeFromKey = NetworkInterceptor.getOrangeFromKey(map, NetworkInterceptor.ORANGE_RES_HEADER);
                                            GlobalOrange.indexResponseHeader = NetworkInterceptor.ORANGE_RES_HEADER;
                                            IndexUpdateHandler.updateIndex(orangeFromKey, false);
                                        } catch (Throwable th) {
                                            OLog.e(NetworkInterceptor.TAG, "intercept", th, new Object[0]);
                                        }
                                    }
                                });
                            }
                        } else if (map.containsKey(NetworkInterceptor.ORANGE_RES_HEADER)) {
                            OThreadFactory.execute(new Runnable() {
                                /* class com.taobao.orange.sync.NetworkInterceptor.AnonymousClass1.AnonymousClass3 */

                                public void run() {
                                    try {
                                        AndroidUtil.setThreadPriority();
                                        String orangeFromKey = NetworkInterceptor.getOrangeFromKey(map, NetworkInterceptor.ORANGE_RES_HEADER);
                                        GlobalOrange.indexResponseHeader = NetworkInterceptor.ORANGE_RES_HEADER;
                                        IndexUpdateHandler.updateIndex(orangeFromKey, false);
                                    } catch (Throwable th) {
                                        OLog.e(NetworkInterceptor.TAG, "intercept", th, new Object[0]);
                                    }
                                }
                            });
                        }
                    }
                    chain.callback().onResponseCode(i, map);
                }
            };
        }
        return chain.proceed(request, callback);
    }
}
