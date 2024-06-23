package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public interface SplashScreen {
    @Nullable
    View createSplashView(@NonNull Context context, @Nullable Bundle bundle);

    @SuppressLint({"NewApi"})
    boolean doesSplashViewRememberItsTransition();

    @Nullable
    @SuppressLint({"NewApi"})
    Bundle saveSplashScreenState();

    void transitionToFlutter(@NonNull Runnable runnable);
}
