package androidx.multidex;

import android.app.Application;
import android.content.Context;

/* compiled from: Taobao */
public class MultiDexApplication extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
