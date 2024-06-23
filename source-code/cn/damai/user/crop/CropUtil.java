package cn.damai.user.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.user.crop.MonitoredActivity;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.TLogConstant;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.w81;

/* compiled from: Taobao */
public class CropUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class BackgroundJob extends MonitoredActivity.a implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final MonitoredActivity activity;
        private final Runnable cleanupRunner = new Runnable() {
            /* class cn.damai.user.crop.CropUtil.BackgroundJob.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-586506046")) {
                    ipChange.ipc$dispatch("-586506046", new Object[]{this});
                    return;
                }
                BackgroundJob.this.activity.b(BackgroundJob.this);
                if (BackgroundJob.this.dialog.getWindow() != null) {
                    BackgroundJob.this.dialog.dismiss();
                }
            }
        };
        private final ProgressDialog dialog;
        private final Handler handler;
        private final Runnable job;

        public BackgroundJob(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler2) {
            this.activity = monitoredActivity;
            this.dialog = progressDialog;
            this.job = runnable;
            monitoredActivity.a(this);
            this.handler = handler2;
        }

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener, cn.damai.user.crop.MonitoredActivity.a
        public void onActivityDestroyed(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1337011884")) {
                ipChange.ipc$dispatch("1337011884", new Object[]{this, monitoredActivity});
                return;
            }
            this.cleanupRunner.run();
            this.handler.removeCallbacks(this.cleanupRunner);
        }

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener, cn.damai.user.crop.MonitoredActivity.a
        public void onActivityStarted(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-221810172")) {
                ipChange.ipc$dispatch("-221810172", new Object[]{this, monitoredActivity});
                return;
            }
            this.dialog.show();
        }

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener, cn.damai.user.crop.MonitoredActivity.a
        public void onActivityStopped(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-698481096")) {
                ipChange.ipc$dispatch("-698481096", new Object[]{this, monitoredActivity});
                return;
            }
            this.dialog.hide();
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1888182511")) {
                ipChange.ipc$dispatch("1888182511", new Object[]{this});
                return;
            }
            try {
                this.job.run();
            } finally {
                this.handler.post(this.cleanupRunner);
            }
        }
    }

    public static void a(@Nullable Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486676320")) {
            ipChange.ipc$dispatch("-1486676320", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(File file, File file2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374836500")) {
            return ((Boolean) ipChange.ipc$dispatch("374836500", new Object[]{file, file2})).booleanValue();
        }
        if (!(file == null || file2 == null)) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException e) {
                w81.a("Error copying Exif data", e);
            }
        }
        return false;
    }

    public static int c(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009184789")) {
            return ((Integer) ipChange.ipc$dispatch("-2009184789", new Object[]{file})).intValue();
        } else if (file == null) {
            return 0;
        } else {
            try {
                int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt != 8) {
                    return 0;
                }
                return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
            } catch (IOException e) {
                w81.a("Error getting Exif data", e);
                return 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r3 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0094, code lost:
        if (r3 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0096, code lost:
        r3.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x009a */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6  */
    @Nullable
    public static File d(Context context, ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "116361715")) {
            return (File) ipChange.ipc$dispatch("116361715", new Object[]{context, contentResolver, uri});
        }
        cursor = null;
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if ("content".equals(uri.getScheme())) {
            try {
                cursor2 = contentResolver.query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            if (uri.toString().startsWith("content://com.google.android.gallery3d")) {
                                i = cursor2.getColumnIndex("_display_name");
                            } else {
                                i = cursor2.getColumnIndex("_data");
                            }
                            if (i != -1) {
                                String string = cursor2.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    File file = new File(string);
                                    cursor2.close();
                                    return file;
                                }
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        cursor = cursor2;
                        try {
                            File e = e(context, contentResolver, uri);
                            if (cursor != null) {
                            }
                            return e;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SecurityException unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursor2;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (IllegalArgumentException unknown) {
                File e2 = e(context, contentResolver, uri);
                if (cursor != null) {
                    cursor.close();
                }
                return e2;
            } catch (SecurityException unused3) {
                cursor2 = null;
            }
        }
        return null;
    }

    @Nullable
    private static File e(Context context, ContentResolver contentResolver, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "681833109")) {
            return (File) ipChange.ipc$dispatch("681833109", new Object[]{context, contentResolver, uri});
        }
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor());
            try {
                String f = f(context);
                fileOutputStream = new FileOutputStream(f);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            File file = new File(f);
                            a(fileInputStream);
                            a(fileOutputStream);
                            return file;
                        }
                    }
                } catch (IOException unused) {
                    a(fileInputStream);
                    a(fileOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a(fileInputStream2);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = null;
                a(fileInputStream);
                a(fileOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2);
                a(fileOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            a(fileInputStream);
            a(fileOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            a(fileInputStream2);
            a(fileOutputStream);
            throw th;
        }
    }

    private static String f(Context context) throws IOException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1087356244")) {
            return File.createTempFile("image", TLogConstant.RUBBISH_DIR, context.getCacheDir()).getAbsolutePath();
        }
        return (String) ipChange.ipc$dispatch("-1087356244", new Object[]{context});
    }

    public static void g(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325448745")) {
            ipChange.ipc$dispatch("-1325448745", new Object[]{monitoredActivity, str, str2, runnable, handler});
            return;
        }
        new Thread(new BackgroundJob(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }
}
