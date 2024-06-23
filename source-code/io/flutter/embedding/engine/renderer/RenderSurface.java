package io.flutter.embedding.engine.renderer;

import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* compiled from: Taobao */
public interface RenderSurface {

    @Keep
    /* compiled from: Taobao */
    public static class Helper {
        static final String TAG = "RenderSurface";
        static boolean sDisableImageView;

        @VisibleForTesting
        public static void setDisableImageView(boolean z) {
            sDisableImageView = z;
        }

        public static boolean suggestUseImageView() {
            if (!sDisableImageView && Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
    }

    void attachToRenderer(@NonNull FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    @Nullable
    FlutterRenderer getAttachedRenderer();

    boolean hasContent();

    boolean isPreRenderSurface();

    boolean isSurfaceAvailableForRendering();

    void onPresentSurface();

    void onPresentSurfaceCompleted();

    void pause();

    void setRenderTransparently(boolean z);

    void updateAndInvalidate();
}
