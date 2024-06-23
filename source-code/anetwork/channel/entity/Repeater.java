package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.detect.NetworkDetector;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.fulltrace.a;
import anet.channel.statist.LongRequestMonitorStat;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestMonitorFullSampling;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;
import anetwork.channel.interceptor.Callback;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import tb.b02;
import tb.c42;
import tb.jl1;
import tb.ju2;
import tb.pd;
import tb.sh1;
import tb.ss0;
import tb.uz1;
import tb.w6;

/* compiled from: Taobao */
public class Repeater implements Callback {
    private ParcelableNetworkListener a;
    private String b;
    private ParcelableInputStreamImpl c = null;
    private boolean d = false;
    private b02 e = null;

    public Repeater(ParcelableNetworkListener parcelableNetworkListener, b02 b02) {
        this.a = parcelableNetworkListener;
        this.e = b02;
        if (parcelableNetworkListener != null) {
            try {
                if ((parcelableNetworkListener.getListenerState() & 8) != 0) {
                    this.d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h(final RequestStatistic requestStatistic) {
        if (sh1.r()) {
            ThreadPoolExecutorFactory.h(new Runnable() {
                /* class anetwork.channel.entity.Repeater.AnonymousClass4 */

                public void run() {
                    try {
                        Repeater.this.j(requestStatistic);
                    } catch (Exception e) {
                        ALog.d("anet.Repeater", "[checkLongRequet]error", null, e, new Object[0]);
                    }
                }
            });
        }
    }

    private void i(Runnable runnable) {
        if (this.e.o()) {
            runnable.run();
            return;
        }
        String str = this.b;
        uz1.b(str != null ? str.hashCode() : hashCode(), runnable);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(RequestStatistic requestStatistic) {
        String h;
        String obj;
        int length;
        int length2;
        int length3;
        if (requestStatistic != null && (length3 = (length = (h = this.e.h()).length()) + (length2 = (obj = this.e.d().toString()).length())) >= 6144) {
            LongRequestMonitorStat longRequestMonitorStat = new LongRequestMonitorStat(this.e.e().l());
            longRequestMonitorStat.originUrl = h;
            longRequestMonitorStat.header = obj;
            longRequestMonitorStat.headerSize = length2;
            longRequestMonitorStat.urlSize = length;
            longRequestMonitorStat.httpCode = requestStatistic.statusCode;
            longRequestMonitorStat.method = this.e.b().k();
            longRequestMonitorStat.refer = requestStatistic.f_refer;
            String str = null;
            int i = 0;
            for (Map.Entry<String, String> entry : this.e.d().entrySet()) {
                int length4 = entry.getValue().length();
                if (length4 > i) {
                    str = entry.getKey();
                    i = length4;
                }
            }
            longRequestMonitorStat.maxHeader = str;
            longRequestMonitorStat.maxHeaderSize = i;
            if (length3 >= 8192) {
                longRequestMonitorStat.reportType = 1;
            } else if (length3 >= 7168) {
                longRequestMonitorStat.reportType = 2;
            } else {
                longRequestMonitorStat.reportType = 3;
            }
            w6.b().commitStat(longRequestMonitorStat);
        }
    }

    public void k(String str) {
        this.b = str;
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onDataReceiveSize(final int i, final int i2, final pd pdVar) {
        final ParcelableNetworkListener parcelableNetworkListener = this.a;
        if (parcelableNetworkListener != null) {
            i(new Runnable() {
                /* class anetwork.channel.entity.Repeater.AnonymousClass2 */

                public void run() {
                    if (!Repeater.this.d) {
                        try {
                            parcelableNetworkListener.onDataReceived(new DefaultProgressEvent(i, pdVar.d(), i2, pdVar.c()));
                        } catch (RemoteException unused) {
                        }
                    } else {
                        try {
                            if (Repeater.this.c == null) {
                                Repeater.this.c = new ParcelableInputStreamImpl();
                                Repeater.this.c.init(Repeater.this.e, i2);
                                Repeater.this.c.write(pdVar);
                                parcelableNetworkListener.onInputStreamGet(Repeater.this.c);
                                return;
                            }
                            Repeater.this.c.write(pdVar);
                        } catch (Exception unused2) {
                            if (Repeater.this.c != null) {
                                Repeater.this.c.close();
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onFinish(final DefaultFinishEvent defaultFinishEvent) {
        if (ALog.g(2)) {
            ALog.f("anet.Repeater", "[onFinish] ", this.b, new Object[0]);
        }
        final ParcelableNetworkListener parcelableNetworkListener = this.a;
        if (parcelableNetworkListener != null) {
            AnonymousClass3 r2 = new Runnable() {
                /* class anetwork.channel.entity.Repeater.AnonymousClass3 */

                public void run() {
                    DefaultFinishEvent defaultFinishEvent = defaultFinishEvent;
                    String str = null;
                    if (defaultFinishEvent != null) {
                        defaultFinishEvent.setContext(null);
                    }
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        RequestStatistic requestStatistic = defaultFinishEvent.rs;
                        if (requestStatistic != null) {
                            requestStatistic.rspCbStart = currentTimeMillis;
                            a.f().log(requestStatistic.span, "netRspCbStart", null);
                            requestStatistic.lastProcessTime = currentTimeMillis - requestStatistic.rspEnd;
                            requestStatistic.oneWayTime = requestStatistic.retryCostTime + (currentTimeMillis - requestStatistic.start);
                            defaultFinishEvent.getStatisticData().filledBy(requestStatistic);
                        }
                        parcelableNetworkListener.onFinished(defaultFinishEvent);
                        if (requestStatistic != null) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            requestStatistic.rspCbEnd = currentTimeMillis2;
                            a.f().log(requestStatistic.span, "netRspCbEnd", null);
                            requestStatistic.callbackTime = currentTimeMillis2 - currentTimeMillis;
                            a.e().commitRequest(requestStatistic.falcoId, requestStatistic);
                            if (requestStatistic.span != null) {
                                a.f().finishRequest(requestStatistic.span, requestStatistic);
                            }
                        }
                        if (Repeater.this.c != null) {
                            Repeater.this.c.writeEnd();
                        }
                        if (requestStatistic != null) {
                            int i = 0;
                            ALog.e("anet.Repeater", "[falcoId:" + requestStatistic.falcoId + jl1.ARRAY_END_STR + "end, " + requestStatistic.toString(), Repeater.this.b, new Object[0]);
                            a.f().log(requestStatistic.span, IFullTraceAnalysis.Stage.FINISH, requestStatistic.toString());
                            CopyOnWriteArrayList<String> b = ss0.b();
                            if (b != null) {
                                int size = b.size();
                                for (int i2 = 0; i2 < size - 1; i2 += 2) {
                                    requestStatistic.putExtra(b.get(i2), b.get(i2 + 1));
                                }
                            }
                            if (ss0.i()) {
                                requestStatistic.putExtra("restrictBg", Integer.valueOf(NetworkStatusHelper.g()));
                            }
                            c42 sceneInfo = a.e().getSceneInfo();
                            if (sceneInfo != null) {
                                ALog.f("anet.Repeater", sceneInfo.toString(), Repeater.this.b, new Object[0]);
                                long j = requestStatistic.start;
                                long j2 = sceneInfo.c;
                                requestStatistic.sinceInitTime = j - j2;
                                int i3 = sceneInfo.a;
                                requestStatistic.startType = i3;
                                if (i3 != 1) {
                                    requestStatistic.sinceLastLaunchTime = j2 - sceneInfo.d;
                                }
                                requestStatistic.deviceLevel = sceneInfo.e;
                                if (sceneInfo.b) {
                                    i = 1;
                                }
                                requestStatistic.isFromExternal = i;
                                requestStatistic.speedBucket = sceneInfo.f;
                                requestStatistic.abTestBucket = sceneInfo.g;
                            }
                            requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                            requestStatistic.userInfo = Repeater.this.e.g("RequestUserInfo");
                            w6.b().commitStat(requestStatistic);
                            if (sh1.C(requestStatistic) || sh1.k(requestStatistic.bizId)) {
                                w6.b().commitStat(new RequestMonitorFullSampling(requestStatistic));
                            }
                            try {
                                String str2 = requestStatistic.ip;
                                JSONObject jSONObject = requestStatistic.extra;
                                if (jSONObject != null) {
                                    str = jSONObject.optString("firstIp");
                                }
                                if (ju2.d(str2) || ju2.d(str)) {
                                    w6.b().commitStat(new RequestMonitor(requestStatistic));
                                }
                            } catch (Exception unused) {
                            }
                            anetwork.channel.stat.a.a().put(Repeater.this.e.h(), defaultFinishEvent.getStatisticData());
                            NetworkDetector.a(requestStatistic);
                            Repeater.this.h(requestStatistic);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            };
            RequestStatistic requestStatistic = defaultFinishEvent.rs;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
                a.f().log(requestStatistic.span, "netRspCbDispatch", null);
            }
            i(r2);
        }
        this.a = null;
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onResponseCode(final int i, final Map<String, List<String>> map) {
        if (ALog.g(2)) {
            ALog.f("anet.Repeater", "[onResponseCode]", this.b, new Object[0]);
        }
        final ParcelableNetworkListener parcelableNetworkListener = this.a;
        if (parcelableNetworkListener != null) {
            i(new Runnable() {
                /* class anetwork.channel.entity.Repeater.AnonymousClass1 */

                public void run() {
                    try {
                        parcelableNetworkListener.onResponseCode(i, new ParcelableHeader(i, map));
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }
}
