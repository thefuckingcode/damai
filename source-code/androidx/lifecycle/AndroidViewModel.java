package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class AndroidViewModel extends ViewModel {
    @SuppressLint({"StaticFieldLeak"})
    private Application mApplication;

    public AndroidViewModel(@NonNull Application application) {
        this.mApplication = application;
    }

    @NonNull
    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
