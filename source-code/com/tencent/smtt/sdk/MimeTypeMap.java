package com.tencent.smtt.sdk;

public class MimeTypeMap {
    private static MimeTypeMap a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        }
        return a2.c().h(str);
    }

    public boolean hasMimeType(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
        }
        return a2.c().i(str);
    }

    public String getMimeTypeFromExtension(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return a2.c().j(str);
    }

    public boolean hasExtension(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
        }
        return a2.c().k(str);
    }

    public String getExtensionFromMimeType(String str) {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return a2.c().l(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            if (a == null) {
                a = new MimeTypeMap();
            }
            mimeTypeMap = a;
        }
        return mimeTypeMap;
    }
}
