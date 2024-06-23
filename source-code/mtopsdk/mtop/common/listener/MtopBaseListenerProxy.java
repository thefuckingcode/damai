package mtopsdk.mtop.common.listener;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.DefaultMtopCallback;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
public class MtopBaseListenerProxy extends DefaultMtopCallback {
    private static final String TAG = "mtopsdk.MtopListenerProxy";
    protected boolean isCached = false;
    protected MtopListener listener;
    public Object reqContext = null;
    public MtopResponse response = null;

    public MtopBaseListenerProxy(MtopListener mtopListener) {
        this.listener = mtopListener;
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopProgressListener, mtopsdk.mtop.common.DefaultMtopCallback
    public void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj) {
        MtopListener mtopListener = this.listener;
        if (mtopListener instanceof MtopCallback.MtopProgressListener) {
            ((MtopCallback.MtopProgressListener) mtopListener).onDataReceived(mtopProgressEvent, obj);
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener, mtopsdk.mtop.common.DefaultMtopCallback
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        MtopResponse mtopResponse;
        if (!(mtopFinishEvent == null || mtopFinishEvent.getMtopResponse() == null)) {
            this.response = mtopFinishEvent.getMtopResponse();
            this.reqContext = obj;
        }
        synchronized (this) {
            try {
                notifyAll();
            } catch (Exception unused) {
                TBSdkLog.e(TAG, "[onFinished] notify error");
            }
        }
        if (!(this.listener instanceof MtopCallback.MtopFinishListener)) {
            return;
        }
        if (!this.isCached || ((mtopResponse = this.response) != null && mtopResponse.isApiSuccess())) {
            ((MtopCallback.MtopFinishListener) this.listener).onFinished(mtopFinishEvent, obj);
        }
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopHeaderListener, mtopsdk.mtop.common.DefaultMtopCallback
    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        MtopListener mtopListener = this.listener;
        if (mtopListener instanceof MtopCallback.MtopHeaderListener) {
            ((MtopCallback.MtopHeaderListener) mtopListener).onHeader(mtopHeaderEvent, obj);
        }
    }
}
