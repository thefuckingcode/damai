package cn.damai.commonbusiness.photoselect.imageselected.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import tb.sm0;

/* compiled from: Taobao */
public class MediaUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static MediaUtils a = null;
    public static int b = 1000;
    public static int c = ((1000 * 500) * 1000);
    public static int d = 5;
    public static int e = 4;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a {
        boolean a;
        String b;

        public a(MediaUtils mediaUtils) {
        }
    }

    public static MediaUtils c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994698981")) {
            return (MediaUtils) ipChange.ipc$dispatch("-1994698981", new Object[0]);
        }
        if (a == null) {
            a = new MediaUtils();
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private a g(long j) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1306050946")) {
            return (a) ipChange.ipc$dispatch("-1306050946", new Object[]{this, Long.valueOf(j)});
        }
        a aVar = new a(this);
        int i = b;
        if (j < ((long) i)) {
            aVar.b = j + "B";
            aVar.a = false;
        } else if (j < ((long) (i * i))) {
            aVar.b = (((int) j) / i) + "K";
            aVar.a = false;
        } else {
            int i2 = (((int) j) / i) / i;
            int i3 = ((int) (j - ((long) ((i2 * i) * i)))) / i;
            String valueOf = String.valueOf(i3);
            if (i3 < 9) {
                valueOf = "00" + i3;
            } else if (i3 < 99) {
                valueOf = "0" + i3;
            }
            try {
                double doubleValue = new BigDecimal((double) Float.valueOf(i2 + "." + valueOf).floatValue()).setScale(1, 4).doubleValue();
                StringBuilder sb = new StringBuilder();
                sb.append(doubleValue);
                sb.append("M");
                aVar.b = sb.toString();
            } catch (Exception unused) {
                aVar.b = i2 + "." + valueOf + "M";
            }
            int i4 = b;
            if ((i2 * i4 * i4) + (i3 * i4) <= c) {
                z = false;
            }
            aVar.a = z;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private a h(long j) {
        long j2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1561541070")) {
            return (a) ipChange.ipc$dispatch("-1561541070", new Object[]{this, Long.valueOf(j)});
        }
        a aVar = new a(this);
        int i = (((int) j) / 1000) / 60;
        if (i > 0) {
            j2 = (long) ((int) Math.floor((double) ((j - ((long) ((i * 60) * 1000))) / 1000)));
            String valueOf = String.valueOf(j2);
            if (j2 < 10) {
                valueOf = "0" + j2;
            }
            aVar.b = i + ":" + valueOf;
        } else {
            j2 = (long) ((int) Math.floor((double) (j / 1000)));
            String valueOf2 = String.valueOf(j2);
            if (j2 < 10) {
                valueOf2 = "0" + String.valueOf(j2);
            }
            aVar.b = "0:" + valueOf2;
        }
        if (((long) (i * 60)) + j2 >= ((long) d)) {
            z = false;
        }
        aVar.a = z;
        return aVar;
    }

    public Bitmap d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348200887")) {
            return (Bitmap) ipChange.ipc$dispatch("1348200887", new Object[]{this, str});
        }
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 14) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
            mediaMetadataRetriever.release();
        }
        return bitmap;
    }

    public Bitmap e(String str, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484068873")) {
            return (Bitmap) ipChange.ipc$dispatch("-1484068873", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 8) {
            return null;
        } else {
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, i);
            return (i2 <= 0 || i3 <= 0) ? createVideoThumbnail : ThumbnailUtils.extractThumbnail(createVideoThumbnail, i2, i3, 2);
        }
    }

    public ArrayList<Image> f(final Context context, final ImageModel.DataCallback dataCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46299568")) {
            return (ArrayList) ipChange.ipc$dispatch("-46299568", new Object[]{this, context, dataCallback});
        } else if (context == null) {
            return null;
        } else {
            final ArrayList<Image> arrayList = new ArrayList<>();
            new Thread(new Runnable() {
                /* class cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    AnonymousClass1 r0 = this;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1179370287")) {
                        ipChange.ipc$dispatch("1179370287", new Object[]{r0});
                        return;
                    }
                    Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "title", "_display_name", "_data", "date_added", "_size", "duration", "bucket_id", "bucket_display_name"}, null, null, null);
                    if (!(query == null || query.getCount() == 0)) {
                        while (query.moveToNext()) {
                            String string = query.getString(query.getColumnIndex("title"));
                            String string2 = query.getString(query.getColumnIndex("_display_name"));
                            String string3 = query.getString(query.getColumnIndex("_data"));
                            long j = query.getLong(query.getColumnIndex("date_added"));
                            long j2 = query.getLong(query.getColumnIndex("_size"));
                            long j3 = query.getLong(query.getColumnIndex("duration"));
                            String string4 = query.getString(query.getColumnIndex("bucket_id"));
                            String string5 = query.getString(query.getColumnIndex("bucket_display_name"));
                            a h = MediaUtils.this.h(j3);
                            String str = h.b;
                            boolean z = h.a;
                            a g = MediaUtils.this.g(j2);
                            String str2 = g.b;
                            boolean z2 = g.a;
                            int indexOf = string3.indexOf(".");
                            Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, query.getLong(query.getColumnIndexOrThrow("_id")));
                            if (indexOf != -1) {
                                String substring = string3.substring(indexOf);
                                Image image = new Image();
                                image.setTitle(string);
                                image.setName(string2);
                                image.setType("2");
                                if (Build.VERSION.SDK_INT >= 29) {
                                    image.setPath(withAppendedId.toString());
                                } else {
                                    image.setPath(string3);
                                }
                                image.setAddDate(j);
                                image.setSize(j2);
                                image.setSizeShow(str2);
                                image.setLimitSize(z2);
                                image.setDuration(j3);
                                image.setDurationShow(str);
                                image.setLimitDur(z);
                                image.setBucketId(string4);
                                image.setBucketName(string5);
                                image.setSuffixType(substring);
                                r0 = this;
                                arrayList.add(image);
                            } else {
                                r0 = this;
                            }
                        }
                    }
                    query.close();
                    Collections.reverse(arrayList);
                    ArrayList<sm0> arrayList = new ArrayList<>();
                    arrayList.add(new sm0("所有视频", arrayList));
                    dataCallback.onSuccess(arrayList);
                }
            }).start();
            return arrayList;
        }
    }
}
