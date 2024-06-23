package io.flutter.embedding.engine.deferredcomponents;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.annotation.JSMethod;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
public class HummerDeferredComponentManager implements DeferredComponentManager {
    public static final String LOCAL_FILES_MAPPING_KEY = "io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager.loadingFromLocalFiles";
    private static final String TAG = "flutter";
    public static final String default_packed_zip = "splitted_so.zip";
    public static final String default_split_load_dir = "split_load";
    private static String split_load_dir;
    private static SplitLoadProvider split_load_provider;
    @Nullable
    private DeferredComponentChannel channel;
    @NonNull
    private Context context;
    @NonNull
    private FlutterApplicationInfo flutterApplicationInfo;
    private List<FlutterJNI> flutterJNIList = new LinkedList();

    /* compiled from: Taobao */
    public interface SplitLoadProvider {
        void loadDartLibrary(int i, String str, DeferredComponentManager deferredComponentManager);
    }

    public HummerDeferredComponentManager(@NonNull Context context2, @Nullable FlutterJNI flutterJNI) {
        this.context = context2;
        this.flutterApplicationInfo = ApplicationInfoLoader.load(context2);
    }

    @NonNull
    private ApplicationInfo getApplicationInfo() {
        try {
            return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    private static ApplicationInfo getApplicationInfoFromContext(Context context2) {
        try {
            return context2.getPackageManager().getApplicationInfo(context2.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initForLocalTest(@NonNull Context context2) {
        Bundle bundle;
        ApplicationInfo applicationInfoFromContext = getApplicationInfoFromContext(context2);
        if (applicationInfoFromContext != null && (bundle = applicationInfoFromContext.metaData) != null && bundle.getBoolean(LOCAL_FILES_MAPPING_KEY, false)) {
            File file = new File(context2.getExternalFilesDir(default_split_load_dir).getAbsolutePath(), default_packed_zip);
            File file2 = new File(context2.getFilesDir().getAbsolutePath(), default_split_load_dir);
            if (split_load_dir == null) {
                split_load_dir = file2.getAbsolutePath();
            }
            try {
                if (file.exists() && file.isFile()) {
                    unzip(file, file2);
                }
                if (!file.exists() || !file.isFile()) {
                    return;
                }
            } catch (Exception unused) {
                if (!file.exists() || !file.isFile()) {
                    return;
                }
            } catch (Throwable th) {
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                throw th;
            }
            file.delete();
        }
    }

    public static void setSplitLoadDir(String str) {
        split_load_dir = str;
    }

    public static void setSplitLoadProvider(SplitLoadProvider splitLoadProvider) {
        split_load_provider = splitLoadProvider;
    }

    public static void unzip(File file, File file2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file3 = new File(file2, nextEntry.getName());
                    File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                    if (!parentFile.isDirectory()) {
                        if (!parentFile.mkdirs()) {
                            throw new FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                        }
                    }
                    if (!nextEntry.isDirectory()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            } finally {
                                fileOutputStream.close();
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        } finally {
            zipInputStream.close();
        }
    }

    private boolean verifyJNI() {
        if (this.flutterJNIList.size() != 0) {
            return true;
        }
        Log.e("flutter", "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
        return false;
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void destroy() {
        this.channel = null;
        this.flutterJNIList = new LinkedList();
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public String getDeferredComponentInstallState(int i, String str) {
        return i > 1 ? "installed" : "failed";
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void installDeferredComponent(final int i, String str) {
        final String str2 = "";
        if (str != null && !str.equals(str2)) {
            str2 = "hummer";
        }
        SplitLoadProvider splitLoadProvider = split_load_provider;
        if (splitLoadProvider == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class io.flutter.embedding.engine.deferredcomponents.HummerDeferredComponentManager.AnonymousClass1 */

                public void run() {
                    HummerDeferredComponentManager.this.loadDartLibrary(i, str2);
                }
            }, 1);
        } else {
            splitLoadProvider.loadDartLibrary(i, str, this);
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void loadAssets(int i, String str) {
        if (verifyJNI()) {
            try {
                AssetManager assets = this.context.getAssets();
                for (FlutterJNI flutterJNI : this.flutterJNIList) {
                    flutterJNI.updateJavaAssetManager(assets, this.flutterApplicationInfo.flutterAssetsDir);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void loadDartLibrary(int i, String str) {
        String str2;
        if (verifyJNI() && i >= 0) {
            String str3 = "app.so-" + i + ".part.so";
            if (Build.VERSION.SDK_INT >= 21) {
                str2 = Build.SUPPORTED_ABIS[0];
            } else {
                str2 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
            }
            str2.replace("-", JSMethod.NOT_SET);
            ArrayList<String> arrayList = new ArrayList();
            LinkedList linkedList = new LinkedList();
            if (split_load_dir == null) {
                linkedList.add(this.context.getFilesDir());
            } else {
                linkedList.add(new File(split_load_dir));
            }
            while (!linkedList.isEmpty()) {
                File file = (File) linkedList.remove();
                String str4 = Process.is64Bit() ? "arm64-v8a" : "armeabi-v7a";
                if (file != null && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        linkedList.add(file2);
                    }
                } else if (file.getName().equals(str3)) {
                    if (file.getAbsolutePath().indexOf(str4) != -1) {
                        arrayList.add(0, file.getAbsolutePath());
                    } else {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str3);
            for (String str5 : arrayList) {
                arrayList2.add(str5);
            }
            for (FlutterJNI flutterJNI : this.flutterJNIList) {
                flutterJNI.loadDartDeferredLibrary(i, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
            DeferredComponentChannel deferredComponentChannel = this.channel;
            if (deferredComponentChannel != null) {
                deferredComponentChannel.completeInstallSuccess(str);
            }
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel) {
        this.channel = deferredComponentChannel;
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void setJNI(@NonNull FlutterJNI flutterJNI) {
        if (flutterJNI == null) {
            this.flutterJNIList = new LinkedList();
        } else {
            this.flutterJNIList.add(flutterJNI);
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public boolean uninstallDeferredComponent(int i, String str) {
        if (str == null) {
            return true;
        }
        str.equals("");
        return true;
    }
}
