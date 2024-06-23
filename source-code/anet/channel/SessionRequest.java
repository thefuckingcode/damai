package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import anet.channel.detect.Ipv6Detector;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.session.HttpSession;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.SessionConnStat;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.a92;
import tb.ag2;
import tb.b92;
import tb.d92;
import tb.e4;
import tb.gm;
import tb.h9;
import tb.hm;
import tb.ju2;
import tb.ke1;
import tb.ll;
import tb.ss0;
import tb.ue0;
import tb.w6;
import tb.yy0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SessionRequest {
    private String a;
    private String b;
    private c c;
    private d d;
    private a92 e;
    volatile Session f;
    private volatile Future g;
    volatile boolean h = false;
    private HashMap<SessionGetCallback, SessionGetWaitTimeoutTask> i = new HashMap<>();
    SessionConnStat j = null;
    private Object k = new Object();
    private boolean l;
    volatile SessionComplexTask m;
    volatile Future n;
    volatile Session o;
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean q = new AtomicBoolean(false);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ConnCb implements IConnCb {
        private Context a;
        private List<hm> b;
        private hm c;
        boolean d = false;

        ConnCb(Context context, List<hm> list, hm hmVar) {
            this.a = context;
            this.b = list;
            this.c = hmVar;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(final Session session, long j, int i) {
            boolean i2 = ss0.i();
            ALog.c("awcn.SessionRequest", "Connect Disconnect", this.c.h(), Preloader.KEY_SESSION, session, "host", SessionRequest.this.y(), "appIsBg", Boolean.valueOf(i2), "isHandleFinish", Boolean.valueOf(this.d));
            SessionRequest.this.d.h(SessionRequest.this, session);
            if (!this.d) {
                this.d = true;
                if (session.v) {
                    if (i2 && (SessionRequest.this.e == null || !SessionRequest.this.e.c || h9.i())) {
                        ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.c.h(), Preloader.KEY_SESSION, session);
                    } else if (!NetworkStatusHelper.n()) {
                        ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.c.h(), Preloader.KEY_SESSION, session);
                    } else {
                        try {
                            if (SessionRequest.this.d.f(SessionRequest.this, d92.a) != null) {
                                ALog.e("awcn.SessionRequest", "[onDisConnect]already have other session.", this.c.h(), new Object[0]);
                                return;
                            }
                            int i3 = 10000;
                            if (SessionRequest.this.e != null && SessionRequest.this.e.c) {
                                i3 = h9.a();
                            }
                            ALog.e("awcn.SessionRequest", "session disconnected, try to recreate session.", this.c.h(), "delay period ", Integer.valueOf(i3));
                            ThreadPoolExecutorFactory.j(new Runnable() {
                                /* class anet.channel.SessionRequest.ConnCb.AnonymousClass1 */

                                public void run() {
                                    try {
                                        ConnCb connCb = ConnCb.this;
                                        SessionRequest.this.F(connCb.a, session.g().e(), b92.a(SessionRequest.this.c.b), null, 0);
                                    } catch (Exception unused) {
                                    }
                                }
                            }, (long) (Math.random() * ((double) i3)), TimeUnit.MILLISECONDS);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j, int i, int i2) {
            if (ALog.g(1)) {
                ALog.c("awcn.SessionRequest", "Connect failed", this.c.h(), Preloader.KEY_SESSION, session, "host", SessionRequest.this.y(), "isHandleFinish", Boolean.valueOf(this.d));
            }
            if (SessionRequest.this.h) {
                SessionRequest.this.h = false;
            } else if (!this.d) {
                this.d = true;
                if (SessionRequest.this.q.get()) {
                    SessionRequest.this.d.h(SessionRequest.this, session);
                    if (!session.w || !NetworkStatusHelper.n() || this.b.isEmpty()) {
                        SessionRequest.this.u();
                        SessionRequest.this.q(session, i, i2);
                        synchronized (SessionRequest.this.i) {
                            for (Map.Entry entry : SessionRequest.this.i.entrySet()) {
                                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = (SessionGetWaitTimeoutTask) entry.getValue();
                                if (sessionGetWaitTimeoutTask.isFinish.compareAndSet(false, true)) {
                                    ThreadPoolExecutorFactory.a(sessionGetWaitTimeoutTask);
                                    ((SessionGetCallback) entry.getKey()).onSessionGetFail();
                                }
                            }
                            SessionRequest.this.i.clear();
                        }
                        return;
                    }
                    if (ALog.g(1)) {
                        ALog.c("awcn.SessionRequest", "use next connInfo to create session", this.c.h(), "host", SessionRequest.this.y());
                    }
                    hm hmVar = this.c;
                    if (hmVar.d == hmVar.e && (i2 == -2003 || i2 == -2410)) {
                        ListIterator<hm> listIterator = this.b.listIterator();
                        while (listIterator.hasNext()) {
                            if (session.i().equals(listIterator.next().a.getIp())) {
                                listIterator.remove();
                            }
                        }
                    }
                    if (ju2.d(session.i())) {
                        ListIterator<hm> listIterator2 = this.b.listIterator();
                        while (listIterator2.hasNext()) {
                            if (ju2.d(listIterator2.next().a.getIp())) {
                                listIterator2.remove();
                            }
                        }
                        if (SessionRequest.this.n == null) {
                            List<hm> list = this.b;
                            if ((list == null || list.isEmpty()) && Inet64Util.n() == 3) {
                                this.b = SessionRequest.this.w(anet.channel.strategy.a.a().getIpv4ConnStrategyListByHost(session.k(), SessionRequest.this.y().startsWith("https"), SessionRequest.this.x()), session.r);
                                ALog.e("awcn.SessionRequest", "ipv6 failed will retry with local dns ipv4 " + this.b.toString(), session.r, new Object[0]);
                            }
                        } else if (!SessionRequest.this.n.isDone()) {
                            ALog.c("awcn.SessionRequest", "it already failed , so start complex task!", session.r, new Object[0]);
                            SessionRequest.this.n.cancel(false);
                            ThreadPoolExecutorFactory.g(SessionRequest.this.m, ThreadPoolExecutorFactory.b.b);
                            return;
                        } else {
                            ALog.c("awcn.SessionRequest", "we already start complex!", session.r, new Object[0]);
                            return;
                        }
                    }
                    if (this.c.a().h() && ss0.i()) {
                        ListIterator<hm> listIterator3 = this.b.listIterator();
                        while (listIterator3.hasNext()) {
                            if (listIterator3.next().a().h()) {
                                listIterator3.remove();
                            }
                        }
                    }
                    if (this.b.isEmpty()) {
                        SessionRequest.this.u();
                        SessionRequest.this.q(session, i, i2);
                        synchronized (SessionRequest.this.i) {
                            for (Map.Entry entry2 : SessionRequest.this.i.entrySet()) {
                                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask2 = (SessionGetWaitTimeoutTask) entry2.getValue();
                                if (sessionGetWaitTimeoutTask2.isFinish.compareAndSet(false, true)) {
                                    ThreadPoolExecutorFactory.a(sessionGetWaitTimeoutTask2);
                                    ((SessionGetCallback) entry2.getKey()).onSessionGetFail();
                                }
                            }
                            SessionRequest.this.i.clear();
                        }
                        return;
                    }
                    hm remove = this.b.remove(0);
                    if (session.z) {
                        SessionRequest sessionRequest = SessionRequest.this;
                        Context context = this.a;
                        sessionRequest.s(context, remove, new ConnCb(context, this.b, remove), remove.h());
                        return;
                    }
                    SessionRequest sessionRequest2 = SessionRequest.this;
                    Context context2 = this.a;
                    sessionRequest2.t(context2, remove, new ConnCb(context2, this.b, remove), remove.h());
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j) {
            ALog.c("awcn.SessionRequest", "Connect Success", this.c.h(), Preloader.KEY_SESSION, session, "host", SessionRequest.this.y());
            try {
                if (SessionRequest.this.h) {
                    SessionRequest.this.h = false;
                    session.c(false);
                    SessionRequest.this.u();
                } else if (!h9.p() || ((SessionRequest.this.p.compareAndSet(false, true) && SessionRequest.this.q.get()) || session.A)) {
                    ALog.e("awcn.SessionRequest", "session connect Success", session.r, new Object[0]);
                    SessionRequest.this.d.a(SessionRequest.this, session);
                    SessionRequest.this.r(session);
                    synchronized (SessionRequest.this.i) {
                        for (Map.Entry entry : SessionRequest.this.i.entrySet()) {
                            SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = (SessionGetWaitTimeoutTask) entry.getValue();
                            if (sessionGetWaitTimeoutTask.isFinish.compareAndSet(false, true)) {
                                ThreadPoolExecutorFactory.a(sessionGetWaitTimeoutTask);
                                ((SessionGetCallback) entry.getKey()).onSessionGetSuccess(session);
                            }
                        }
                        SessionRequest.this.i.clear();
                    }
                    if (session.z) {
                        if (SessionRequest.this.f != null && !SessionRequest.this.f.q()) {
                            SessionRequest.this.f.s.isReported = false;
                            SessionRequest.this.f.c(false);
                            ALog.e("awcn.SessionRequest", "Complex session is success, cancel connectingSession !", null, "host", SessionRequest.this.b);
                        }
                    } else if (SessionRequest.this.n != null && !SessionRequest.this.n.isDone()) {
                        SessionRequest.this.n.cancel(true);
                        SessionRequest.this.n = null;
                        ALog.e("awcn.SessionRequest", " session is success, remove complex task !", null, "host", SessionRequest.this.b);
                    } else if (SessionRequest.this.o != null && !SessionRequest.this.o.q()) {
                        SessionRequest.this.o.s.isReported = false;
                        SessionRequest.this.o.c(false);
                        ALog.e("awcn.SessionRequest", " session is success, cancel complex session !", SessionRequest.this.o.r, "host", SessionRequest.this.b);
                    }
                    SessionRequest.this.u();
                } else {
                    ALog.e("awcn.SessionRequest", "session connect already finish", session.r, new Object[0]);
                    session.c(false);
                    SessionRequest.this.u();
                }
            } catch (Exception e2) {
                ALog.d("awcn.SessionRequest", "[onSuccess]:", this.c.h(), e2, new Object[0]);
            } catch (Throwable th) {
                SessionRequest.this.u();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ConnectTimeoutTask implements Runnable {
        String seq = null;

        ConnectTimeoutTask(String str) {
            this.seq = str;
        }

        public void run() {
            if (SessionRequest.this.q.get()) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.seq, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.j;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.j.start;
                if (SessionRequest.this.f != null) {
                    SessionRequest.this.f.w = false;
                    SessionRequest.this.f.b();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.j.syncValueFromSession(sessionRequest.f);
                }
                if (SessionRequest.this.o != null) {
                    SessionRequest.this.o.w = false;
                    SessionRequest.this.o.b();
                }
                w6.b().commitStat(SessionRequest.this.j);
                SessionRequest.this.E(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface IConnCb {
        void onDisConnect(Session session, long j, int i);

        void onFailed(Session session, long j, int i, int i2);

        void onSuccess(Session session, long j);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class SessionComplexTask implements Runnable {
        private List<hm> connInfoList = new ArrayList();
        private Context context;
        private SessionRequest sessionRequest;
        private int sessionType;

        public SessionComplexTask(Context context2, SessionRequest sessionRequest2, int i, List<hm> list) {
            this.context = context2;
            this.sessionRequest = sessionRequest2;
            this.sessionType = i;
            this.connInfoList = list;
        }

        public void run() {
            if (SessionRequest.this.d.f(this.sessionRequest, this.sessionType) != null) {
                ALog.e("awcn.SessionRequest", "SessionComplexTask cancel,  already connect successfully", null, "host", SessionRequest.this.b);
                return;
            }
            List<hm> list = this.connInfoList;
            if (list == null || list.size() <= 0) {
                ALog.e("awcn.SessionRequest", "SessionComplexTask cancel,  conn list is null", null, "host", SessionRequest.this.b);
                return;
            }
            hm remove = this.connInfoList.remove(0);
            ALog.e("awcn.SessionRequest", "SessionComplexTask run :" + remove.toString(), remove.h(), "host", SessionRequest.this.b);
            SessionRequest sessionRequest2 = SessionRequest.this;
            Context context2 = this.context;
            sessionRequest2.s(context2, remove, new ConnCb(context2, this.connInfoList, remove), remove.h());
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public class SessionGetWaitTimeoutTask implements Runnable {
        SessionGetCallback cb = null;
        AtomicBoolean isFinish = new AtomicBoolean(false);

        protected SessionGetWaitTimeoutTask(SessionGetCallback sessionGetCallback) {
            this.cb = sessionGetCallback;
        }

        public void run() {
            if (this.isFinish.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.i) {
                    SessionRequest.this.i.remove(this.cb);
                }
                this.cb.onSessionGetFail();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements EventCb {
        final /* synthetic */ IConnCb a;
        final /* synthetic */ long b;

        a(IConnCb iConnCb, long j) {
            this.a = iConnCb;
            this.b = j;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, ue0 ue0) {
            String str;
            if (session != null) {
                int i2 = ue0 == null ? 0 : ue0.a;
                if (ue0 == null) {
                    str = "";
                } else {
                    str = ue0.b;
                }
                if (i == 2) {
                    ALog.c("awcn.SessionRequest", null, session.r, "Session", session, "EventType", Integer.valueOf(i), "Event", ue0);
                    if (SessionRequest.this.d.b(SessionRequest.this, session)) {
                        this.a.onDisConnect(session, this.b, i);
                    } else {
                        this.a.onFailed(session, this.b, i, i2);
                    }
                    if (SessionRequest.this.e != null && SessionRequest.this.e.c && SessionRequest.this.d.e(SessionRequest.this.c.p(ag2.e("https", ke1.SCHEME_SLASH, SessionRequest.this.e.a))) == null) {
                        SessionRequest.this.B(session, i2, str);
                    } else if (SessionRequest.this.e != null && SessionRequest.this.e.c) {
                        ALog.e("awcn.SessionRequest", "sessionPool has accs session, will not send msg to accs!", session.r, new Object[0]);
                    }
                } else if (i == 256) {
                    ALog.c("awcn.SessionRequest", null, session.r, "Session", session, "EventType", Integer.valueOf(i), "Event", ue0);
                    this.a.onFailed(session, this.b, i, i2);
                } else if (i == 512) {
                    ALog.c("awcn.SessionRequest", null, session.r, "Session", session, "EventType", Integer.valueOf(i), "Event", ue0);
                    SessionRequest.this.B(session, 0, null);
                    this.a.onSuccess(session, this.b);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements EventCb {
        final /* synthetic */ Session a;

        b(Session session) {
            this.a = session;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, ue0 ue0) {
            ALog.c("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i));
            gm gmVar = new gm();
            if (i == 512) {
                gmVar.a = true;
            }
            if (SessionRequest.this.e != null) {
                gmVar.b = SessionRequest.this.e.c;
            }
            if (!session.s.isReported) {
                ALog.e("awcn.SessionRequest", "isReported is false!,we will not report to StrategyCenter", this.a.r, new Object[0]);
            } else {
                anet.channel.strategy.a.a().notifyConnEvent(this.a.k(), this.a.f(), gmVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements ServiceConnection {
        final /* synthetic */ Intent a;
        final /* synthetic */ Context b;

        c(SessionRequest sessionRequest, Intent intent, Context context) {
            this.a = intent;
            this.b = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.c("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
            try {
                Messenger messenger = new Messenger(iBinder);
                Message message = new Message();
                message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.a);
                messenger.send(message);
            } catch (Exception e) {
                ALog.d("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e, new Object[0]);
            } catch (Throwable th) {
                this.b.unbindService(this);
                throw th;
            }
            this.b.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ALog.c("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
            this.b.unbindService(this);
        }
    }

    SessionRequest(String str, c cVar) {
        this.a = str;
        String substring = str.substring(str.indexOf(ke1.SCHEME_SLASH) + 3);
        this.b = substring;
        this.c = cVar;
        this.e = cVar.f.b(substring);
        this.d = cVar.d;
    }

    private void A(Session session, IConnCb iConnCb, long j2, String str) {
        if (iConnCb != null) {
            session.v(4095, new a(iConnCb, j2));
            session.v(1792, new b(session));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void B(Session session, int i2, String str) {
        if (h9.L()) {
            D(session, i2, str);
        }
        C(session, i2, str);
    }

    private void C(Session session, int i2, String str) {
        a92 a92 = this.e;
        if (a92 != null && a92.c) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
            Intent intent = new Intent(Constants.ACTION_ACCS_CONNECT_INFO);
            intent.putExtra("command", 103);
            intent.putExtra("host", session.h());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean q2 = session.q();
            if (!q2) {
                intent.putExtra("errorCode", i2);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, q2);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            this.c.g.f(intent);
        }
    }

    private void D(Session session, int i2, String str) {
        a92 a92;
        Context c2 = ss0.c();
        if (c2 != null && (a92 = this.e) != null && a92.c) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
            try {
                Intent intent = new Intent(Constants.ACTION_RECEIVE);
                intent.setPackage(c2.getPackageName());
                intent.setClassName(c2, AdapterUtilityImpl.msgService);
                intent.putExtra("command", 103);
                intent.putExtra("host", session.h());
                intent.putExtra(Constants.KEY_CENTER_HOST, true);
                boolean q2 = session.q();
                if (!q2) {
                    intent.putExtra("errorCode", i2);
                    intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
                }
                intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, q2);
                intent.putExtra(Constants.KEY_TYPE_INAPP, true);
                if (Build.VERSION.SDK_INT >= 26) {
                    c2.bindService(intent, new c(this, intent, c2), 1);
                } else {
                    c2.startService(intent);
                }
            } catch (Throwable th) {
                ALog.d("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(Session session, int i2, int i3) {
        if (256 == i2 && i3 != -2613 && i3 != -2601) {
            e4 e4Var = new e4();
            e4Var.e = "networkPrefer";
            e4Var.f = "policy";
            e4Var.b = this.a;
            e4Var.c = String.valueOf(i3);
            e4Var.a = false;
            w6.b().commitAlarm(e4Var);
            SessionConnStat sessionConnStat = this.j;
            sessionConnStat.ret = 0;
            sessionConnStat.appendErrorTrace(i3);
            this.j.errorCode = String.valueOf(i3);
            this.j.totalTime = System.currentTimeMillis() - this.j.start;
            this.j.syncValueFromSession(session);
            SessionConnStat sessionConnStat2 = this.j;
            SessionStatistic sessionStatistic = session.s;
            sessionConnStat2.isComplex = sessionStatistic.isComplex;
            if (!sessionStatistic.isReported) {
                sessionConnStat2.ret = 2;
            }
            w6.b().commitStat(this.j);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r(Session session) {
        e4 e4Var = new e4();
        e4Var.e = "networkPrefer";
        e4Var.f = "policy";
        e4Var.b = this.a;
        e4Var.a = true;
        w6.b().commitAlarm(e4Var);
        this.j.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.j;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.j.start;
        SessionConnStat sessionConnStat2 = this.j;
        sessionConnStat2.isComplex = session.s.isComplex;
        sessionConnStat2.isCreated = session.A;
        a92 a92 = this.e;
        if (a92 != null && a92.c) {
            List<Session> c2 = this.d.c(this);
            this.j.sessionCount = c2 != null ? c2.size() : 0;
        }
        w6.b().commitStat(this.j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t(Context context, hm hmVar, IConnCb iConnCb, String str) {
        ConnType a2 = hmVar.a();
        if (context == null || a2.i()) {
            this.f = new HttpSession(context, hmVar);
        } else {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, hmVar);
            tnetSpdySession.Q(this.c.c);
            a92 b2 = this.c.f.b(this.b);
            this.e = b2;
            tnetSpdySession.R(b2);
            tnetSpdySession.U(this.c.f.a(this.b));
            SessionStatistic sessionStatistic = tnetSpdySession.s;
            sessionStatistic.xqcConnEnv += "-isContainHttp3=" + this.l;
            this.f = tnetSpdySession;
        }
        ALog.f("awcn.SessionRequest", "create connection...", str, BizTime.HOST, y(), "Type", hmVar.a(), "IP", hmVar.e(), "Port", Integer.valueOf(hmVar.f()), "heartbeat", Integer.valueOf(hmVar.c()), Preloader.KEY_SESSION, this.f);
        A(this.f, iConnCb, System.currentTimeMillis(), str);
        this.f.e();
        SessionConnStat sessionConnStat = this.j;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.j;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", hmVar.e());
            IConnStrategy iConnStrategy = hmVar.a;
            if (iConnStrategy != null) {
                this.j.firstIpType = iConnStrategy.getIpType();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void u() {
        E(false);
        synchronized (this.k) {
            this.k.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047 A[Catch:{ all -> 0x008d }] */
    private List<IConnStrategy> v(int i2, String str) {
        boolean z;
        ListIterator<IConnStrategy> listIterator;
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        try {
            yy0 g2 = yy0.g(y());
            if (g2 == null) {
                return list;
            }
            list = anet.channel.strategy.a.a().getConnStrategyListByHost(g2.d());
            if (!list.isEmpty()) {
                boolean equalsIgnoreCase = "https".equalsIgnoreCase(g2.j());
                if (!Inet64Util.o()) {
                    if (Ipv6Detector.d() != 0) {
                        z = false;
                        listIterator = list.listIterator();
                        while (listIterator.hasNext()) {
                            IConnStrategy next = listIterator.next();
                            ConnType l2 = ConnType.l(next.getProtocol());
                            if (l2 != null) {
                                if (l2.k() == equalsIgnoreCase) {
                                    if (i2 == d92.c || l2.e() == i2) {
                                        if (z && ju2.d(next.getIp())) {
                                            listIterator.remove();
                                        }
                                    }
                                }
                                listIterator.remove();
                            }
                        }
                    }
                }
                z = true;
                listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                }
            }
            ALog.e("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", list);
            return list;
        } catch (Throwable th) {
            ALog.d("awcn.SessionRequest", "", str, th, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<hm> w(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        this.l = false;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            IConnStrategy iConnStrategy = list.get(i3);
            int retryTimes = iConnStrategy.getRetryTimes();
            for (int i4 = 0; i4 <= retryTimes; i4++) {
                i2++;
                String y = y();
                hm hmVar = new hm(y, str + JSMethod.NOT_SET + i2, iConnStrategy);
                hmVar.d = i4;
                hmVar.e = retryTimes;
                arrayList.add(hmVar);
                if (hmVar.a().h()) {
                    this.l = true;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void E(boolean z) {
        this.q.set(z);
        if (!z) {
            if (this.g != null) {
                this.g.cancel(true);
                this.g = null;
            }
            this.f = null;
            this.o = null;
            if (this.n != null) {
                this.n.cancel(true);
                this.n = null;
            }
            this.m = null;
            this.p.set(false);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void F(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j2) {
        List<hm> b2;
        String a2 = TextUtils.isEmpty(str) ? b92.a(null) : str;
        ALog.c("awcn.SessionRequest", "SessionRequest start", a2, "host", this.a, "type", Integer.valueOf(i2));
        if (this.q.compareAndSet(false, true)) {
            Session f2 = this.d.f(this, i2);
            if (f2 != null) {
                ALog.e("awcn.SessionRequest", "Available Session exist!!!", a2, new Object[0]);
                if (sessionGetCallback != null) {
                    sessionGetCallback.onSessionGetSuccess(f2);
                }
                u();
                return;
            }
            E(true);
            this.g = ThreadPoolExecutorFactory.j(new ConnectTimeoutTask(a2), 45, TimeUnit.SECONDS);
            SessionConnStat sessionConnStat = new SessionConnStat();
            this.j = sessionConnStat;
            sessionConnStat.start = System.currentTimeMillis();
            if (!NetworkStatusHelper.n()) {
                if (ALog.g(1)) {
                    ALog.c("awcn.SessionRequest", "network is not available, can't create session", a2, "isConnected", Boolean.valueOf(NetworkStatusHelper.n()));
                }
                u();
                throw new RuntimeException("no network");
            }
            List<IConnStrategy> v = v(i2, a2);
            if (!v.isEmpty()) {
                List<hm> w = w(v, a2);
                try {
                    hm remove = w.remove(0);
                    t(context, remove, new ConnCb(context, w, remove), remove.h());
                    if (ll.d(this.b, remove.e()) && (b2 = ll.b(this.f, w, 1)) != null && b2.size() > 0) {
                        long a3 = ll.a();
                        ALog.c("awcn.SessionRequest", "sessionComplexTask will start", null, "delay", Long.valueOf(a3));
                        this.m = new SessionComplexTask(context, this, i2, b2);
                        this.n = ThreadPoolExecutorFactory.j(this.m, a3, TimeUnit.MILLISECONDS);
                    }
                    if (sessionGetCallback != null) {
                        SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = new SessionGetWaitTimeoutTask(sessionGetCallback);
                        synchronized (this.i) {
                            this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask);
                        }
                        ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask, j2, TimeUnit.MILLISECONDS);
                    }
                } catch (Throwable unused) {
                    u();
                }
                return;
            }
            ALog.f("awcn.SessionRequest", "no avalible strategy, can't create session", a2, "host", this.a, "type", Integer.valueOf(i2));
            u();
            throw new NoAvailStrategyException("no avalible strategy");
        }
        ALog.e("awcn.SessionRequest", "session connecting", a2, "host", y());
        if (sessionGetCallback != null) {
            if (x() == i2) {
                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask2 = new SessionGetWaitTimeoutTask(sessionGetCallback);
                synchronized (this.i) {
                    this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask2);
                }
                ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask2, j2, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void G(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j2) {
        List<hm> b2;
        String a2 = TextUtils.isEmpty(str) ? b92.a(null) : str;
        ALog.c("awcn.SessionRequest", "SessionRequest start", a2, "host", this.a, "type", Integer.valueOf(i2));
        if (this.q.compareAndSet(false, true)) {
            Session f2 = this.d.f(this, i2);
            if (f2 != null) {
                ALog.c("awcn.SessionRequest", "Available Session exist!!!", a2, new Object[0]);
                if (sessionGetCallback != null) {
                    sessionGetCallback.onSessionGetSuccess(f2);
                }
                u();
                return;
            }
            E(true);
            this.g = ThreadPoolExecutorFactory.j(new ConnectTimeoutTask(a2), 45, TimeUnit.SECONDS);
            SessionConnStat sessionConnStat = new SessionConnStat();
            this.j = sessionConnStat;
            sessionConnStat.start = System.currentTimeMillis();
            if (!NetworkStatusHelper.n()) {
                if (ALog.g(1)) {
                    ALog.c("awcn.SessionRequest", "network is not available, can't create session", a2, "isConnected", Boolean.valueOf(NetworkStatusHelper.n()));
                }
                u();
                throw new RuntimeException("no network");
            }
            List<IConnStrategy> v = v(i2, a2);
            if (!v.isEmpty()) {
                List<hm> w = w(v, a2);
                try {
                    hm remove = w.remove(0);
                    t(context, remove, new ConnCb(context, w, remove), remove.h());
                    if (ll.d(this.b, remove.e()) && (b2 = ll.b(this.f, w, 1)) != null && b2.size() > 0) {
                        long a3 = ll.a();
                        ALog.c("awcn.SessionRequest", "sessionComplexTask will start", null, "delay", Long.valueOf(a3));
                        this.m = new SessionComplexTask(context, this, i2, b2);
                        this.n = ThreadPoolExecutorFactory.j(this.m, a3, TimeUnit.MILLISECONDS);
                    }
                    SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = new SessionGetWaitTimeoutTask(sessionGetCallback);
                    synchronized (this.i) {
                        this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask);
                    }
                    ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask, j2, TimeUnit.MILLISECONDS);
                } catch (Throwable unused) {
                    u();
                }
                return;
            }
            ALog.f("awcn.SessionRequest", "no avalible strategy, can't create session", a2, "host", this.a, "type", Integer.valueOf(i2));
            u();
            throw new NoAvailStrategyException("no avalible strategy");
        }
        ALog.e("awcn.SessionRequest", "session connecting", a2, "host", y());
        if (sessionGetCallback != null) {
            if (x() == i2) {
                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask2 = new SessionGetWaitTimeoutTask(sessionGetCallback);
                synchronized (this.i) {
                    this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask2);
                }
                ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask2, j2, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void n(long j2) throws InterruptedException, TimeoutException {
        ALog.c("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j2));
        if (j2 > 0) {
            synchronized (this.k) {
                long currentTimeMillis = System.currentTimeMillis() + j2;
                while (true) {
                    if (!this.q.get()) {
                        break;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 >= currentTimeMillis) {
                        break;
                    }
                    this.k.wait(currentTimeMillis - currentTimeMillis2);
                }
                if (this.q.get()) {
                    throw new TimeoutException();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        List<Session> g2 = this.d.g(this);
        if (g2 != null) {
            for (Session session : g2) {
                if (session != null && session.q() && !session.g().i()) {
                    session.u(true, 5000);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p(boolean z) {
        ALog.c("awcn.SessionRequest", "closeSessions", this.c.b, "host", this.a, "autoCreate", Boolean.valueOf(z));
        if (!z && this.f != null) {
            this.f.w = false;
            this.f.c(false);
            if (this.o != null) {
                this.o.w = false;
                this.o.c(false);
            }
        }
        List<Session> g2 = this.d.g(this);
        if (g2 != null) {
            for (Session session : g2) {
                if (session != null) {
                    session.c(z);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void s(Context context, hm hmVar, IConnCb iConnCb, String str) {
        ConnType a2 = hmVar.a();
        if (context == null || a2.i()) {
            this.o = new HttpSession(context, hmVar);
        } else {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, hmVar);
            tnetSpdySession.Q(this.c.c);
            tnetSpdySession.R(this.e);
            tnetSpdySession.U(this.c.f.a(this.b));
            this.o = tnetSpdySession;
        }
        this.o.z = true;
        ALog.e("awcn.SessionRequest", "create complex connection...", str, BizTime.HOST, y(), "Type", hmVar.a(), "IP", hmVar.e(), "Port", Integer.valueOf(hmVar.f()), "heartbeat", Integer.valueOf(hmVar.c()), Preloader.KEY_SESSION, this.o);
        A(this.o, iConnCb, System.currentTimeMillis(), str);
        this.o.s.isComplex = true;
        this.o.e();
    }

    /* access modifiers changed from: protected */
    public int x() {
        Session session = this.f;
        if (session != null) {
            return session.k.e();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public String y() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void z(String str) {
        ALog.c("awcn.SessionRequest", "reCreateSession", str, "host", this.a);
        p(true);
    }
}
