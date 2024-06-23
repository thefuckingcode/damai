package cn.damai.issue.tool.file;

import android.os.Handler;
import android.os.HandlerThread;
import cn.damai.common.AppConfig;
import cn.damai.common.util.a;
import cn.damai.issue.bean.DraftBean;
import cn.damai.issue.listener.MainThreadDraftListener;
import cn.damai.issue.listener.OnDraftListener;
import cn.damai.issue.tool.draft.DraftBox;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.nio.charset.Charset;
import tb.g91;
import tb.s41;
import tb.xb0;

/* compiled from: Taobao */
public class DraftStoreImpl implements IDraftStore {
    private static transient /* synthetic */ IpChange $ipChange;
    private HandlerThread a;
    private Handler b;
    private xb0 c = new xb0();

    public DraftStoreImpl() {
        HandlerThread handlerThread = new HandlerThread("Draft_Thread");
        this.a = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.a.getLooper());
    }

    @Override // cn.damai.issue.tool.file.IDraftStore
    public void deleteAsync(final DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1249635983")) {
            ipChange.ipc$dispatch("1249635983", new Object[]{this, draftBean});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.issue.tool.file.DraftStoreImpl.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-521719928")) {
                    ipChange.ipc$dispatch("-521719928", new Object[]{this});
                    return;
                }
                boolean a = DraftStoreImpl.this.c.a(draftBean);
                if (AppConfig.v()) {
                    g91.f(DraftBox.TAG, "DraftStoreImpl deleteAsync : del status :" + a + " filename:" + draftBean.draftMd5FileName);
                }
            }
        });
    }

    @Override // cn.damai.issue.tool.file.IDraftStore
    public void queryAsync(final String str, OnDraftListener onDraftListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978170869")) {
            ipChange.ipc$dispatch("1978170869", new Object[]{this, str, onDraftListener});
            return;
        }
        final MainThreadDraftListener mainThreadDraftListener = new MainThreadDraftListener(onDraftListener);
        this.b.post(new Runnable() {
            /* class cn.damai.issue.tool.file.DraftStoreImpl.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                byte[] h;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-718233433")) {
                    ipChange.ipc$dispatch("-718233433", new Object[]{this});
                    return;
                }
                DraftBean draftBean = null;
                try {
                    File c = DraftStoreImpl.this.c.c(new DraftBean(str));
                    if (c != null && c.isFile() && (h = a.h(c)) != null && h.length > 0) {
                        draftBean = (DraftBean) s41.a(new String(h, Charset.forName("UTF-8")), DraftBean.class);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    mainThreadDraftListener.onDraft(null);
                    throw th;
                }
                mainThreadDraftListener.onDraft(draftBean);
                if (AppConfig.v()) {
                    g91.f(DraftBox.TAG, "DraftStoreImpl queryAsync :" + draftBean);
                }
            }
        });
    }

    @Override // cn.damai.issue.tool.file.IDraftStore
    public void quitSafely() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1069944641")) {
            ipChange.ipc$dispatch("1069944641", new Object[]{this});
            return;
        }
        g91.c(DraftBox.TAG, " draft thread quitSafely");
        this.a.quitSafely();
    }

    @Override // cn.damai.issue.tool.file.IDraftStore
    public void saveAsync(final DraftBean draftBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064123459")) {
            ipChange.ipc$dispatch("-1064123459", new Object[]{this, draftBean});
            return;
        }
        this.b.post(new Runnable() {
            /* class cn.damai.issue.tool.file.DraftStoreImpl.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-914746938")) {
                    ipChange.ipc$dispatch("-914746938", new Object[]{this});
                    return;
                }
                boolean d = DraftStoreImpl.this.c.d(draftBean);
                if (AppConfig.v()) {
                    g91.f(DraftBox.TAG, "DraftStoreImpl saveAsync : save status:" + d + " filename:" + draftBean.draftMd5FileName);
                }
            }
        });
    }
}
