package cn.damai.launcher.splash.model;

import android.app.ActivityManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.bean.AdBitmapRes;
import cn.damai.launcher.splash.model.bean.AdCacheResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.Iterator;
import tb.nc;
import tb.rs1;

/* compiled from: Taobao */
public class AdBitmapPreloadProvider extends ContentProvider {
    private static transient /* synthetic */ IpChange $ipChange;

    private int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "529927618")) {
            return ((Integer) ipChange.ipc$dispatch("529927618", new Object[]{this, options, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            int i6 = i4 / 2;
            int i7 = i5 / 2;
            while (i6 / i3 >= i2 && i7 / i3 >= i) {
                i3 *= 2;
            }
        }
        return i3;
    }

    private boolean isDebug(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-50143986")) {
            return (context.getApplicationInfo().flags & 2) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-50143986", new Object[]{this, context})).booleanValue();
    }

    private void printLog(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898558982")) {
            ipChange.ipc$dispatch("898558982", new Object[]{this, context, str});
        } else if (isDebug(context)) {
            Log.e(nc.TAG, str);
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1483194663")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1483194663", new Object[]{this, uri, str, strArr})).intValue();
    }

    public void doAdBitmapPreloadTask(Context context) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "836426578")) {
            ipChange.ipc$dispatch("836426578", new Object[]{this, context});
        } else if (!rs1.e(context)) {
            printLog(context, "AdBitmapPreloadProvider 未同意隐私政策，任务不执行");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            printLog(context, "AdBitmapPreloadProvider doAdBitmapPreloadTask");
            AdCacheResult isShouldUseCacheAd = new AdLoader(context, null).isShouldUseCacheAd();
            if (isShouldUseCacheAd.isUseCache && !AdBitmapResTool.isCacheGetApiInvoked()) {
                SplashResponse splashResponse = isShouldUseCacheAd.cacheRes;
                File file = isShouldUseCacheAd.adCacheFile;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (options.outWidth > 0 && options.outHeight > 0) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                    int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
                    options2.inSampleSize = calculateInSampleSize(options, i, i2);
                    if (isDebug(context)) {
                        printLog(context, "Ad 原始size w=" + options.outWidth + " h=" + options.outHeight + " screen w=" + i + " h=" + i2 + " sampleSize=" + options2.inSampleSize);
                    }
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
                    if (!AdBitmapResTool.isCacheGetApiInvoked() && decodeFile != null) {
                        AdBitmapResTool.cache(new AdBitmapRes(new BitmapDrawable(context.getResources(), decodeFile), splashResponse));
                        z = true;
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            printLog(context, "AdBitmapPreloadProvider doAdBitmapPreloadTask " + z + " cost=" + currentTimeMillis2 + "ms");
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "786267952")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("786267952", new Object[]{this, uri});
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "459060150")) {
            return null;
        }
        return (Uri) ipChange.ipc$dispatch("459060150", new Object[]{this, uri, contentValues});
    }

    public boolean isMainProcess(Context context) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664057423")) {
            return ((Boolean) ipChange.ipc$dispatch("-1664057423", new Object[]{this, context})).booleanValue();
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                str = next.processName;
                break;
            }
        }
        return TextUtils.equals("cn.damai", str);
    }

    public boolean onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003700948")) {
            return ((Boolean) ipChange.ipc$dispatch("-2003700948", new Object[]{this})).booleanValue();
        }
        final Context context = getContext();
        if (context != null) {
            printLog(context, "AdBitmapPreloadProvider onCreate");
            new Thread(new Runnable() {
                /* class cn.damai.launcher.splash.model.AdBitmapPreloadProvider.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1520764017")) {
                        ipChange.ipc$dispatch("-1520764017", new Object[]{this});
                        return;
                    }
                    try {
                        AdBitmapPreloadProvider.this.doAdBitmapPreloadTask(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return true;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1365942225")) {
            return null;
        }
        return (Cursor) ipChange.ipc$dispatch("-1365942225", new Object[]{this, uri, strArr, str, strArr2, str2});
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "729764857")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("729764857", new Object[]{this, uri, contentValues, str, strArr})).intValue();
    }
}
