package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* compiled from: Taobao */
class MediaDescriptionCompatApi23 {

    /* compiled from: Taobao */
    static class Builder {
        private Builder() {
        }

        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    private MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
