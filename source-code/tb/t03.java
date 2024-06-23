package tb;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.efs.sdk.base.a.d.a;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public abstract class t03 extends Handler {
    public a a;

    t03() {
        super(o13.a.getLooper());
        sendEmptyMessageDelayed(0, DateUtils.MILLIS_PER_MINUTE);
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, DateUtils.MILLIS_PER_MINUTE);
    }
}
