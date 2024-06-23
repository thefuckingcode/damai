package tb;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class l61 extends Paint {
    public l61() {
    }

    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public l61(int i) {
        super(i);
    }

    public l61(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public l61(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
