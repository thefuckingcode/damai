package android.taobao.windvane.webview;

/* compiled from: Taobao */
public interface IPreRenderWebView {
    long getExpireTime();

    boolean isPreLoad();

    boolean isPreRenderSuccess();

    void preRenderInit(String str);

    void setExpireTime(long j);

    void setPreRenderSuccess(boolean z);
}
