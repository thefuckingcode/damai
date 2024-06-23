package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
public class WebIconDatabase {
    private static WebIconDatabase a;

    @Deprecated
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void open(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
        } else {
            a2.c().b(str);
        }
    }

    public void close() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebIconDatabase.getInstance().close();
        } else {
            a2.c().m();
        }
    }

    public void removeAllIcons() {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } else {
            a2.c().l();
        }
    }

    public void requestIconForPageUrl(String str, final a aVar) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() {
                /* class com.tencent.smtt.sdk.WebIconDatabase.AnonymousClass2 */

                public void onReceivedIcon(String str, Bitmap bitmap) {
                    aVar.a(str, bitmap);
                }
            });
        } else {
            a2.c().a(str, new IconListener() {
                /* class com.tencent.smtt.sdk.WebIconDatabase.AnonymousClass1 */

                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str, Bitmap bitmap) {
                    aVar.a(str, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        } else {
            a2.c().c(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        } else {
            a2.c().d(str);
        }
    }

    public static WebIconDatabase getInstance() {
        return a();
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (a == null) {
                a = new WebIconDatabase();
            }
            webIconDatabase = a;
        }
        return webIconDatabase;
    }

    private WebIconDatabase() {
    }
}
