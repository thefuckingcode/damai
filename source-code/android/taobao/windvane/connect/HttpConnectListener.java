package android.taobao.windvane.connect;

/* compiled from: Taobao */
public abstract class HttpConnectListener<T> {
    public void onError(int i, String str) {
    }

    public abstract void onFinish(T t, int i);

    public void onProcess(int i) {
    }

    public void onStart() {
    }
}
