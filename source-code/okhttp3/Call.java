package okhttp3;

import java.io.IOException;
import okio.o;

/* compiled from: Taobao */
public interface Call extends Cloneable {

    /* compiled from: Taobao */
    public interface Factory {
        Call newCall(o oVar);
    }

    void cancel();

    @Override // java.lang.Object
    Call clone();

    void enqueue(Callback callback);

    q execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    o request();

    o timeout();
}
