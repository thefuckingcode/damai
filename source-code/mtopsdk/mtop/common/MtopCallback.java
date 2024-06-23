package mtopsdk.mtop.common;

/* compiled from: Taobao */
public class MtopCallback {

    /* compiled from: Taobao */
    public interface MtopCacheListener extends MtopListener {
        void onCached(MtopCacheEvent mtopCacheEvent, Object obj);
    }

    /* compiled from: Taobao */
    public interface MtopFinishListener extends MtopListener {
        void onFinished(MtopFinishEvent mtopFinishEvent, Object obj);
    }

    /* compiled from: Taobao */
    public interface MtopHeaderListener extends MtopListener {
        void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj);
    }

    @Deprecated
    /* compiled from: Taobao */
    public interface MtopProgressListener extends MtopListener {
        @Deprecated
        void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj);
    }
}
