package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* access modifiers changed from: package-private */
@RequiresApi(21)
/* compiled from: Taobao */
public class VolumeProviderCompatApi21 {

    /* compiled from: Taobao */
    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i, int i2, int i3, final Delegate delegate) {
        return new VolumeProvider(i, i2, i3) {
            /* class androidx.media.VolumeProviderCompatApi21.AnonymousClass1 */

            public void onAdjustVolume(int i) {
                delegate.onAdjustVolume(i);
            }

            public void onSetVolumeTo(int i) {
                delegate.onSetVolumeTo(i);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
