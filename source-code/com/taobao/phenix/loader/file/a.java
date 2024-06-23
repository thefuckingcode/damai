package com.taobao.phenix.loader.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import tb.i42;
import tb.r02;
import tb.tp1;

/* compiled from: Taobao */
public class a implements FileLoader {
    private static boolean a;

    public String a(Context context, String str, int i, boolean z) {
        Uri uri;
        Cursor cursor;
        if (z) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(uri, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        long j = -1;
        if (query != null) {
            if (query.moveToFirst()) {
                j = (long) query.getInt(query.getColumnIndex("_id"));
            }
            query.close();
        }
        String str2 = null;
        if (j > 0) {
            if (z) {
                cursor = contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data"}, "video_id=" + j + " AND " + "kind" + "=" + i, null, null);
            } else {
                cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(contentResolver, j, i, null);
            }
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    str2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
                cursor.close();
            }
        }
        return str2;
    }

    @Override // com.taobao.phenix.loader.file.FileLoader
    public r02 load(i42 i42, String str, Map<String, String> map) throws IOException, Resources.NotFoundException, UnSupportedSchemeException {
        int i;
        int i2 = i42.a;
        if (i2 != 33) {
            if (i2 == 34) {
                Context applicationContext = tp1.o().applicationContext();
                if (applicationContext != null) {
                    InputStream open = applicationContext.getResources().getAssets().open(i42.h);
                    return new r02(open, open.available());
                }
                throw new IOException("Phenix.with(Context) hasn't been called before FileLoader(asset) loading");
            } else if (i2 == 36) {
                Context applicationContext2 = tp1.o().applicationContext();
                if (applicationContext2 != null) {
                    TypedValue typedValue = new TypedValue();
                    InputStream openRawResource = applicationContext2.getResources().openRawResource(i42.i, typedValue);
                    return new r02(openRawResource, openRawResource.available(), typedValue);
                }
                throw new IOException("Phenix.with(Context) hasn't been called before FileLoader(resource) loading");
            } else if (i2 == 40) {
                byte[] decode = Base64.decode(i42.j, 0);
                return new r02(decode, 0, decode.length);
            } else if (i2 == 48) {
                try {
                    return tp1.o().i().get(i42.k).handleScheme(str);
                } catch (IndexOutOfBoundsException unused) {
                    throw new UnSupportedSchemeException(i2);
                }
            } else {
                throw new UnSupportedSchemeException(i2);
            }
        } else if (str.startsWith("content://")) {
            Context applicationContext3 = tp1.o().applicationContext();
            if (applicationContext3 != null) {
                InputStream openInputStream = applicationContext3.getContentResolver().openInputStream(Uri.parse(str));
                if (a && Build.VERSION.SDK_INT >= 29 && ((i = i42.l) == 1 || i == 3)) {
                    byte[] thumbnail = new ExifInterface(openInputStream).getThumbnail();
                    openInputStream.close();
                    openInputStream = (thumbnail == null || thumbnail.length <= 0) ? applicationContext3.getContentResolver().openInputStream(Uri.parse(str)) : new ByteArrayInputStream(thumbnail);
                }
                return new r02(openInputStream, openInputStream.available());
            }
            throw new IOException("Phenix.with(Context) hasn't been called before FileLoader UriContent loading");
        } else {
            String str2 = i42.h;
            int i3 = i42.l;
            if (i3 == 1 || i3 == 3) {
                Context applicationContext4 = tp1.o().applicationContext();
                if (applicationContext4 != null) {
                    String a2 = a(applicationContext4, str2, i42.l, false);
                    str2 = TextUtils.isEmpty(a2) ? a(applicationContext4, str2, i42.l, true) : a2;
                    if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                        if (i42.m) {
                            str2 = i42.h;
                        } else {
                            throw new IOException("Retrieved thumbnail(type:" + i42.l + ") failed from local path");
                        }
                    }
                } else {
                    throw new IOException("Phenix.with(Context) hasn't been called before FileLoader(thumbnail) loading");
                }
            }
            File file = new File(str2);
            return new r02(new FileInputStream(file), (int) file.length());
        }
    }
}
