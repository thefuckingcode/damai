package anet.channel;

/* compiled from: Taobao */
public interface SessionGetCallback {
    void onSessionGetFail();

    void onSessionGetSuccess(Session session);
}
