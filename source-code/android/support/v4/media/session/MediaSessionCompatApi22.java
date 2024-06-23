package android.support.v4.media.session;

import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
/* compiled from: Taobao */
class MediaSessionCompatApi22 {
    private MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object obj, int i) {
        ((MediaSession) obj).setRatingType(i);
    }
}
