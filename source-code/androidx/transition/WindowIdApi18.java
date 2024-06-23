package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* access modifiers changed from: package-private */
@RequiresApi(18)
/* compiled from: Taobao */
public class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    WindowIdApi18(@NonNull View view) {
        this.mWindowId = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).mWindowId.equals(this.mWindowId);
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}
