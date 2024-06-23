package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

/* compiled from: Taobao */
public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0121 A[Catch:{ Exception -> 0x0151, all -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0134 A[Catch:{ Exception -> 0x014b, all -> 0x0149 }, LOOP:0: B:49:0x012d->B:51:0x0134, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x017f A[SYNTHETIC, Splitter:B:79:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0187 A[Catch:{ Exception -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0139 A[EDGE_INSN: B:87:0x0139->B:52:0x0139 ?: BREAK  , SYNTHETIC] */
    protected static String a(Context context, Uri uri, int i) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e;
        Throwable th2;
        Cursor cursor;
        String str;
        BufferedInputStream bufferedInputStream;
        File file;
        byte[] bArr;
        int read;
        Exception e2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            a.C0195a e3 = com.sina.weibo.sdk.b.a.e(context);
            String str2 = "";
            if (e3 != null) {
                str2 = e3.packageName;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "com.sina.weibo";
            }
            String str3 = "/Android/data/" + str2 + "/files/.composerTem/";
            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str3).mkdirs();
            Calendar instance = Calendar.getInstance();
            try {
                if ("file".equals(uri.getScheme())) {
                    str = instance.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(cursor.getColumnIndex("_display_name"));
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            try {
                                c.b("WBShareTag", "share util and exception is " + e2.getMessage());
                                e2.printStackTrace();
                                if (cursor != null) {
                                }
                                str = null;
                                if (TextUtils.isEmpty(str)) {
                                }
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor()));
                                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str3 + str);
                                if (file.exists()) {
                                }
                                fileOutputStream = new FileOutputStream(file);
                                bArr = new byte[1444];
                                while (true) {
                                    read = bufferedInputStream.read(bArr);
                                    if (read == -1) {
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                String path = file.getPath();
                                try {
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                return path;
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th2;
                            }
                        }
                    }
                    str = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e6) {
                e2 = e6;
                cursor = null;
                c.b("WBShareTag", "share util and exception is " + e2.getMessage());
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                str = null;
                if (TextUtils.isEmpty(str)) {
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor()));
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str3 + str);
                if (file.exists()) {
                }
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path2 = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path2;
            } catch (Throwable th4) {
                th2 = th4;
                cursor = null;
                if (cursor != null) {
                }
                throw th2;
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Calendar.getInstance().getTimeInMillis());
                sb.append(i == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                str = sb.toString();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor()));
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str3 + str);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
                try {
                    c.b("WBShareTag", "share util and error is " + e.getMessage());
                    throw new Throwable(e);
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedInputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path22 = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path22;
            } catch (Exception e8) {
                e = e8;
                bufferedInputStream2 = bufferedInputStream;
                c.b("WBShareTag", "share util and error is " + e.getMessage());
                throw new Throwable(e);
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream = null;
            c.b("WBShareTag", "share util and error is " + e.getMessage());
            throw new Throwable(e);
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    throw th;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
