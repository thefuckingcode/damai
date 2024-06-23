package androidx.transition;

import android.os.IBinder;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
