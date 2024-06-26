package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import tb.jl1;
import tb.o91;

/* compiled from: Taobao */
public class c {
    @NonNull
    private final LottieNetworkCacheProvider a;

    public c(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.a = lottieNetworkCacheProvider;
    }

    private static String b(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }

    @Nullable
    private File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File cacheDir = this.a.getCacheDir();
        if (cacheDir.isFile()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> a(String str) {
        FileExtension fileExtension;
        try {
            File c = c(str);
            if (c == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c);
            if (c.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            o91.a("Cache hit for " + str + " at " + c.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileExtension fileExtension) {
        File file = new File(d(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        o91.a("Copying temp file to real file (" + file2 + jl1.BRACKET_END_STR);
        if (!renameTo) {
            o91.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public File f(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(d(), b(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
