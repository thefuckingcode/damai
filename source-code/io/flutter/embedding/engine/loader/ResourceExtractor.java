package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import io.flutter.Log;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ResourceExtractor {
    private static final String[] SUPPORTED_ABIS = getSupportedAbis();
    private static final String TAG = "ResourceExtractor";
    private static final String TIMESTAMP_PREFIX = "res_timestamp-";
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final String mDataDirPath;
    private ExtractTask mExtractTask;
    @NonNull
    private final PackageManager mPackageManager;
    @NonNull
    private final String mPackageName;
    @NonNull
    private final HashSet<String> mResources = new HashSet<>();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ExtractTask extends AsyncTask<Void, Void, Void> {
        @NonNull
        private final AssetManager mAssetManager;
        @NonNull
        private final String mDataDirPath;
        @NonNull
        private final PackageManager mPackageManager;
        @NonNull
        private final String mPackageName;
        @NonNull
        private final HashSet<String> mResources;

        ExtractTask(@NonNull String str, @NonNull HashSet<String> hashSet, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
            this.mDataDirPath = str;
            this.mResources = hashSet;
            this.mAssetManager = assetManager;
            this.mPackageName = str2;
            this.mPackageManager = packageManager;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
            r2.addSuppressed(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            if (r1 != null) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0058, code lost:
            r2.addSuppressed(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
            throw r3;
         */
        @WorkerThread
        private boolean extractAPK(@NonNull File file) {
            Iterator<String> it = this.mResources.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    File file2 = new File(file, next);
                    if (!file2.exists()) {
                        if (file2.getParentFile() != null) {
                            file2.getParentFile().mkdirs();
                        }
                        InputStream open = this.mAssetManager.open(next);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        ResourceExtractor.copy(open, fileOutputStream);
                        fileOutputStream.close();
                        if (open != null) {
                            open.close();
                        }
                    }
                } catch (FileNotFoundException unused) {
                } catch (IOException e) {
                    Log.w(ResourceExtractor.TAG, "Exception unpacking resources: " + e.getMessage());
                    ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            File file = new File(this.mDataDirPath);
            String checkTimestamp = ResourceExtractor.checkTimestamp(file, this.mPackageManager, this.mPackageName);
            if (checkTimestamp == null) {
                return null;
            }
            ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
            if (!extractAPK(file)) {
                return null;
            }
            try {
                new File(file, checkTimestamp).createNewFile();
            } catch (IOException unused) {
                Log.w(ResourceExtractor.TAG, "Failed to write resource timestamp");
            }
            return null;
        }
    }

    ResourceExtractor(@NonNull String str, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
        this.mDataDirPath = str;
        this.mPackageName = str2;
        this.mPackageManager = packageManager;
        this.mAssetManager = assetManager;
    }

    /* access modifiers changed from: private */
    public static String checkTimestamp(@NonNull File file, @NonNull PackageManager packageManager, @NonNull String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return TIMESTAMP_PREFIX;
            }
            String str2 = TIMESTAMP_PREFIX + getVersionCode(packageInfo) + "-" + packageInfo.lastUpdateTime;
            String[] existingTimestamps = getExistingTimestamps(file);
            if (existingTimestamps != null && existingTimestamps.length == 1 && str2.equals(existingTimestamps[0])) {
                return null;
            }
            return str2;
        } catch (PackageManager.NameNotFoundException unused) {
            return TIMESTAMP_PREFIX;
        }
    }

    /* access modifiers changed from: private */
    public static void copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void deleteFiles(@NonNull String str, @NonNull HashSet<String> hashSet) {
        File file = new File(str);
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            File file2 = new File(file, it.next());
            if (file2.exists()) {
                file2.delete();
            }
        }
        String[] existingTimestamps = getExistingTimestamps(file);
        if (existingTimestamps != null) {
            for (String str2 : existingTimestamps) {
                new File(file, str2).delete();
            }
        }
    }

    private static String[] getExistingTimestamps(File file) {
        return file.list(new FilenameFilter() {
            /* class io.flutter.embedding.engine.loader.ResourceExtractor.AnonymousClass1 */

            public boolean accept(File file, String str) {
                return str.startsWith(ResourceExtractor.TIMESTAMP_PREFIX);
            }
        });
    }

    private static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI(), Build.CPU_ABI2));
        arrayList.removeAll(Arrays.asList(null, ""));
        return (String[]) arrayList.toArray(new String[0]);
    }

    static long getVersionCode(@NonNull PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    /* access modifiers changed from: package-private */
    public ResourceExtractor addResource(@NonNull String str) {
        this.mResources.add(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ResourceExtractor addResources(@NonNull Collection<String> collection) {
        this.mResources.addAll(collection);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ResourceExtractor start() {
        ExtractTask extractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
        this.mExtractTask = extractTask;
        extractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void waitForCompletion() {
        if (this.mExtractTask != null) {
            Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
            try {
                this.mExtractTask.get();
            } catch (InterruptedException | CancellationException | ExecutionException unused) {
                deleteFiles(this.mDataDirPath, this.mResources);
            }
            Trace.endSection();
        }
    }
}
