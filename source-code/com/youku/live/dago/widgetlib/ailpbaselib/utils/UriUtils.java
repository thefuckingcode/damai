package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
public class UriUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0 A[SYNTHETIC, Splitter:B:36:0x00a0] */
    public static Uri formatImageUri(Context context, File file) {
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972424330")) {
            return (Uri) ipChange.ipc$dispatch("-1972424330", new Object[]{context, file});
        }
        String absolutePath = file.getAbsolutePath();
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(query.getColumnIndex("_id"));
                        Uri parse = Uri.parse("content://media/external/images/media");
                        Uri withAppendedPath = Uri.withAppendedPath(parse, "" + i);
                        try {
                            query.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return withAppendedPath;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (file.exists()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", absolutePath);
                Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return insert;
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public static String formatUri(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180187116")) {
            return (String) ipChange.ipc$dispatch("-180187116", new Object[]{context, uri});
        }
        Uri uri2 = null;
        if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosContentUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocumentsUri(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return AppContextUtils.getApp().getFilesDir().getAbsolutePath() + "/" + split[1];
            }
        } else if (isDownloadsDocumentsUri(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (isMediaDocumentsUri(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[SYNTHETIC, Splitter:B:27:0x005d] */
    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626105994")) {
            return (String) ipChange.ipc$dispatch("-1626105994", new Object[]{context, uri, str, strArr});
        }
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        try {
                            query.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static boolean isDownloadsDocumentsUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "27434750")) {
            return "com.android.providers.downloads.documents".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("27434750", new Object[]{uri})).booleanValue();
    }

    private static boolean isExternalStorageDocumentsUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1704928381")) {
            return "com.android.externalstorage.documents".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1704928381", new Object[]{uri})).booleanValue();
    }

    private static boolean isGooglePhotosContentUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1356391654")) {
            return "com.google.android.apps.photos.content".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1356391654", new Object[]{uri})).booleanValue();
    }

    private static boolean isMediaDocumentsUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1117323657")) {
            return "com.android.providers.media.documents".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1117323657", new Object[]{uri})).booleanValue();
    }
}
