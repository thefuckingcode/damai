package cn.damai.launcher.splash.model.listener;

import androidx.annotation.NonNull;
import cn.damai.launcher.splash.api.SplashResponse;
import java.io.File;

/* compiled from: Taobao */
public interface OnAdFetchListener {
    void dispatchAdFetchPhaseFail(int i, String str, String str2);

    void dispatchAdFetchSuccess(@NonNull File file, @NonNull SplashResponse splashResponse);
}
