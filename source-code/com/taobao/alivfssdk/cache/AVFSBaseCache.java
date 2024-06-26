package com.taobao.alivfssdk.cache;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.alivfssdk.cache.IAVFSCache;
import java.io.InputStream;

/* compiled from: Taobao */
public abstract class AVFSBaseCache implements IAVFSCache {

    /* compiled from: Taobao */
    class a implements IAVFSCache.OnStreamGetCallback2 {
        final /* synthetic */ IAVFSCache.OnStreamGetCallback a;

        a(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnStreamGetCallback onStreamGetCallback) {
            this.a = onStreamGetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnStreamGetCallback2
        public void onStreamGetCallback(@NonNull String str, String str2, InputStream inputStream) {
            this.a.onStreamGetCallback(str, inputStream);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements IAVFSCache.OnStreamSetCallback2 {
        final /* synthetic */ IAVFSCache.OnStreamSetCallback a;

        b(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
            this.a = onStreamSetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnStreamSetCallback2
        public void onStreamSetCallback(@NonNull String str, String str2, boolean z) {
            this.a.onStreamSetCallback(str, z);
        }
    }

    /* compiled from: Taobao */
    class c implements IAVFSCache.OnObjectContainedCallback2 {
        final /* synthetic */ IAVFSCache.OnObjectContainedCallback a;

        c(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectContainedCallback onObjectContainedCallback) {
            this.a = onObjectContainedCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectContainedCallback2
        public void onObjectContainedCallback(@NonNull String str, String str2, boolean z) {
            this.a.onObjectContainedCallback(str, z);
        }
    }

    /* compiled from: Taobao */
    class d implements IAVFSCache.OnObjectGetCallback2<T> {
        final /* synthetic */ IAVFSCache.OnObjectGetCallback a;

        d(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectGetCallback onObjectGetCallback) {
            this.a = onObjectGetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectGetCallback2
        public void onObjectGetCallback(@NonNull String str, String str2, Object obj) {
            this.a.onObjectGetCallback(str, obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements IAVFSCache.OnObjectSetCallback2 {
        final /* synthetic */ IAVFSCache.OnObjectSetCallback a;

        e(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
            this.a = onObjectSetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectSetCallback2
        public void onObjectSetCallback(@NonNull String str, String str2, boolean z) {
            this.a.onObjectSetCallback(str, z);
        }
    }

    /* compiled from: Taobao */
    class f implements IAVFSCache.OnObjectRemoveCallback2 {
        final /* synthetic */ IAVFSCache.OnObjectRemoveCallback a;

        f(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectRemoveCallback onObjectRemoveCallback) {
            this.a = onObjectRemoveCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectRemoveCallback2
        public void onObjectRemoveCallback(@NonNull String str, String str2, boolean z) {
            this.a.onObjectRemoveCallback(str, z);
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str) {
        return containObjectForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public InputStream inputStreamForKey(@NonNull String str) {
        return inputStreamForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str) {
        return lengthForKey(str, null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str) {
        return (T) objectForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeAllObject(final IAVFSCache.OnAllObjectRemoveCallback onAllObjectRemoveCallback) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass10 */

            public void run() {
                onAllObjectRemoveCallback.onAllObjectRemoveCallback(AVFSBaseCache.this.removeAllObject());
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str) {
        return removeObjectForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, Object obj) {
        return setObjectForKey(str, (String) null, obj);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream) {
        return setStreamForKey(str, (String) null, inputStream);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void containObjectForKey(@NonNull String str, IAVFSCache.OnObjectContainedCallback onObjectContainedCallback) {
        containObjectForKey(str, (String) null, new c(this, onObjectContainedCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void inputStreamForKey(@NonNull String str, IAVFSCache.OnStreamGetCallback onStreamGetCallback) {
        inputStreamForKey(str, (String) null, new a(this, onStreamGetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, Class<T> cls) {
        return (T) objectForKey(str, (String) null, cls);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeObjectForKey(@NonNull String str, IAVFSCache.OnObjectRemoveCallback onObjectRemoveCallback) {
        removeObjectForKey(str, (String) null, new f(this, onObjectRemoveCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj) {
        return setObjectForKey(str, (String) null, obj, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream) {
        return setStreamForKey(str, str2, inputStream, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void containObjectForKey(@NonNull final String str, final String str2, final IAVFSCache.OnObjectContainedCallback2 onObjectContainedCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass2 */

            public void run() {
                IAVFSCache.OnObjectContainedCallback2 onObjectContainedCallback2 = onObjectContainedCallback2;
                String str = str;
                String str2 = str2;
                onObjectContainedCallback2.onObjectContainedCallback(str, str2, AVFSBaseCache.this.containObjectForKey(str, str2));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void inputStreamForKey(@NonNull final String str, final String str2, final IAVFSCache.OnStreamGetCallback2 onStreamGetCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass12 */

            public void run() {
                IAVFSCache.OnStreamGetCallback2 onStreamGetCallback2 = onStreamGetCallback2;
                String str = str;
                String str2 = str2;
                onStreamGetCallback2.onStreamGetCallback(str, str2, AVFSBaseCache.this.inputStreamForKey(str, str2));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> void objectForKey(@NonNull String str, Class<T> cls, IAVFSCache.OnObjectGetCallback<T> onObjectGetCallback) {
        objectForKey(str, (String) null, cls, new d(this, onObjectGetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeObjectForKey(@NonNull final String str, final String str2, final IAVFSCache.OnObjectRemoveCallback2 onObjectRemoveCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass9 */

            public void run() {
                IAVFSCache.OnObjectRemoveCallback2 onObjectRemoveCallback2 = onObjectRemoveCallback2;
                String str = str;
                String str2 = str2;
                onObjectRemoveCallback2.onObjectRemoveCallback(str, str2, AVFSBaseCache.this.removeObjectForKey(str, str2));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, Object obj, int i) {
        return setObjectForKey(str, (String) null, obj, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i) {
        return setStreamForKey(str, (String) null, inputStream, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> void objectForKey(@NonNull final String str, final String str2, final Class<T> cls, final IAVFSCache.OnObjectGetCallback2<T> onObjectGetCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass4 */

            public void run() {
                IAVFSCache.OnObjectGetCallback2 onObjectGetCallback2 = onObjectGetCallback2;
                String str = str;
                String str2 = str2;
                onObjectGetCallback2.onObjectGetCallback(str, str2, AVFSBaseCache.this.objectForKey(str, str2, cls));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, Object obj, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
        setObjectForKey(str, obj, 0, onObjectSetCallback);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
        setStreamForKey(str, inputStream, 0, onStreamSetCallback);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull final String str, final String str2, final Object obj, final IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass5 */

            public void run() {
                IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2 = onObjectSetCallback2;
                String str = str;
                String str2 = str2;
                onObjectSetCallback2.onObjectSetCallback(str, str2, AVFSBaseCache.this.setObjectForKey(str, str2, obj));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2) {
        setStreamForKey(str, str2, inputStream, 0, onStreamSetCallback2);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, Object obj, int i, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
        setObjectForKey(str, (String) null, obj, new e(this, onObjectSetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
        setStreamForKey(str, (String) null, inputStream, new b(this, onStreamSetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull final String str, final String str2, final Object obj, final int i, final IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass7 */

            public void run() {
                IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2 = onObjectSetCallback2;
                String str = str;
                String str2 = str2;
                onObjectSetCallback2.onObjectSetCallback(str, str2, AVFSBaseCache.this.setObjectForKey(str, str2, obj, i));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull final String str, final String str2, @NonNull final InputStream inputStream, int i, final IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2) {
        AsyncTask.execute(new Runnable() {
            /* class com.taobao.alivfssdk.cache.AVFSBaseCache.AnonymousClass14 */

            public void run() {
                IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2 = onStreamSetCallback2;
                String str = str;
                String str2 = str2;
                onStreamSetCallback2.onStreamSetCallback(str, str2, AVFSBaseCache.this.setStreamForKey(str, str2, inputStream, 0));
            }
        });
    }
}
