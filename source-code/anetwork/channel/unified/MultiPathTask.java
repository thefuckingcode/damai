package anetwork.channel.unified;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import anet.channel.RequestCb;
import anet.channel.request.Cancelable;
import anet.channel.request.a;
import anet.channel.session.HttpSession;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cookie.CookieManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.ag2;
import tb.hm;
import tb.ke1;
import tb.pd;
import tb.ry0;
import tb.ss0;
import tb.yy0;

/* compiled from: Taobao */
public class MultiPathTask implements IUnifiedTask {
    private static final String TAG = "anet.MultiPathTask";
    private static AtomicBoolean toastStatus = new AtomicBoolean(false);
    private static Handler uiHandler = new Handler(Looper.getMainLooper());
    volatile Cancelable cancelable = null;
    private int contentLength = 0;
    private int dataChunkIndex = 0;
    private String f_refer;
    private volatile boolean isCanceled = false;
    private b rc;
    private anet.channel.request.a req;
    private AtomicBoolean responseReturn = new AtomicBoolean(false);

    /* compiled from: Taobao */
    class a implements RequestCb {
        final /* synthetic */ RequestStatistic a;
        final /* synthetic */ anet.channel.request.a b;

        a(RequestStatistic requestStatistic, anet.channel.request.a aVar) {
            this.a = requestStatistic;
            this.b = aVar;
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(pd pdVar, boolean z) {
            if (MultiPathTask.this.responseReturn.get() && !MultiPathTask.this.isCanceled && !MultiPathTask.this.rc.d.get()) {
                MultiPathTask.access$408(MultiPathTask.this);
                if (MultiPathTask.this.rc.b != null) {
                    MultiPathTask.this.rc.b.onDataReceiveSize(MultiPathTask.this.dataChunkIndex, MultiPathTask.this.contentLength, pdVar);
                }
            }
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            if (MultiPathTask.this.responseReturn.get() && !MultiPathTask.this.isCanceled && !MultiPathTask.this.rc.d.getAndSet(true)) {
                if (ALog.g(2)) {
                    ALog.f(MultiPathTask.TAG, "[onFinish]", MultiPathTask.this.rc.c, "code", Integer.valueOf(i), "msg", str);
                }
                requestStatistic.useMultiPath = 1;
                MultiPathTask.this.rc.c();
                requestStatistic.isDone.set(true);
                if (MultiPathTask.this.rc.b != null) {
                    MultiPathTask.this.rc.b.onFinish(new DefaultFinishEvent(i, str, this.b));
                }
            }
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
            if (!MultiPathTask.this.rc.d.get() && !MultiPathTask.this.isCanceled && i == 200) {
                MultiPathTask.this.responseReturn.set(true);
                this.a.useMultiPath = 1;
                MultiPathTask.this.rc.c();
                CookieManager.l(MultiPathTask.this.rc.a.h(), map);
                MultiPathTask.this.contentLength = ry0.f(map);
                if (MultiPathTask.this.rc.b != null) {
                    MultiPathTask.this.rc.b.onResponseCode(i, map);
                }
            }
        }
    }

    public MultiPathTask(b bVar) {
        this.rc = bVar;
        this.req = bVar.a.b();
        this.f_refer = bVar.a.d().get(HttpHeaderConstant.F_REFER);
    }

    static /* synthetic */ int access$408(MultiPathTask multiPathTask) {
        int i = multiPathTask.dataChunkIndex;
        multiPathTask.dataChunkIndex = i + 1;
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    private anet.channel.request.a preProcessRequest(anet.channel.request.a aVar) {
        a.b bVar;
        if (this.rc.a.n()) {
            String i = CookieManager.i(this.rc.a.h());
            if (!TextUtils.isEmpty(i)) {
                bVar = aVar.u();
                String str = aVar.g().get(IRequestConst.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    i = ag2.e(str, "; ", i);
                }
                bVar.I(IRequestConst.COOKIE, i);
                return bVar != null ? aVar : bVar.J();
            }
        }
        bVar = null;
        if (bVar != null) {
        }
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        if (this.cancelable != null) {
            this.cancelable.cancel();
        }
    }

    public boolean isResponseReturn() {
        return this.responseReturn.get();
    }

    public void run() {
        if (!this.isCanceled && !this.rc.d.get()) {
            ALog.e(TAG, "start multi path request.", this.rc.c, new Object[0]);
            if (toastStatus.compareAndSet(false, true)) {
                uiHandler.post(new Runnable() {
                    /* class anetwork.channel.unified.MultiPathTask.AnonymousClass1 */

                    public void run() {
                        Toast.makeText(ss0.c(), "正在移动数据改善浏览体验，可在设置-通用里关闭", 0).show();
                    }
                });
            }
            anet.channel.request.a preProcessRequest = preProcessRequest(this.req);
            yy0 e = this.rc.a.e();
            RequestStatistic requestStatistic = this.rc.a.f;
            String e2 = ag2.e(e.j(), ke1.SCHEME_SLASH, e.d());
            Context c = ss0.c();
            HttpSession httpSession = new HttpSession(c, new hm(e2, this.rc.c + "_mc", null));
            httpSession.F(true);
            this.cancelable = httpSession.w(preProcessRequest, new a(requestStatistic, preProcessRequest));
        }
    }
}
