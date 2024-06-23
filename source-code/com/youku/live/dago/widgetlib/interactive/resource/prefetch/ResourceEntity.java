package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ResourceEntity {
    public List<Resource> resourceList = new ArrayList();

    /* compiled from: Taobao */
    public static class Resource {
        public final String key;
        public final long outdated;
        public final String path;
        public final Uri uri;

        public Resource(String str, String str2, Uri uri2) {
            this(str, str2, uri2, 0);
        }

        public Resource(String str, String str2, Uri uri2, long j) {
            this.key = str;
            this.path = str2;
            this.uri = uri2;
            this.outdated = j;
        }
    }
}
