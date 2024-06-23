package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.a;
import com.airbnb.lottie.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import tb.o91;
import tb.oa1;

/* compiled from: Taobao */
public class d {
    @NonNull
    private final c a;
    @NonNull
    private final LottieNetworkFetcher b;

    public d(@NonNull c cVar, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.a = cVar;
        this.b = lottieNetworkFetcher;
    }

    @Nullable
    @WorkerThread
    private a a(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> a2;
        oa1<a> oa1;
        if (str2 == null || (a2 = this.a.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a2.first;
        InputStream inputStream = (InputStream) a2.second;
        if (fileExtension == FileExtension.ZIP) {
            oa1 = b.u(new ZipInputStream(inputStream), str);
        } else {
            oa1 = b.i(inputStream, str);
        }
        if (oa1.b() != null) {
            return oa1.b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    private oa1<a> b(@NonNull String str, @Nullable String str2) {
        o91.a("Fetching " + str);
        Closeable closeable = null;
        try {
            LottieFetchResult fetchSync = this.b.fetchSync(str);
            if (fetchSync.isSuccessful()) {
                oa1<a> d = d(str, fetchSync.bodyByteStream(), fetchSync.contentType(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(d.b() != null);
                o91.a(sb.toString());
                try {
                    fetchSync.close();
                } catch (IOException e) {
                    o91.d("LottieFetchResult close failed ", e);
                }
                return d;
            }
            oa1<a> oa1 = new oa1<>(new IllegalArgumentException(fetchSync.error()));
            try {
                fetchSync.close();
            } catch (IOException e2) {
                o91.d("LottieFetchResult close failed ", e2);
            }
            return oa1;
        } catch (Exception e3) {
            oa1<a> oa12 = new oa1<>(e3);
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e4) {
                    o91.d("LottieFetchResult close failed ", e4);
                }
            }
            return oa12;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    o91.d("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @NonNull
    private oa1<a> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        oa1<a> oa1;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            o91.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            oa1 = f(str, inputStream, str3);
        } else {
            o91.a("Received json response.");
            fileExtension = FileExtension.JSON;
            oa1 = e(str, inputStream, str3);
        }
        if (!(str3 == null || oa1.b() == null)) {
            this.a.e(str, fileExtension);
        }
        return oa1;
    }

    @NonNull
    private oa1<a> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return b.i(inputStream, null);
        }
        return b.i(new FileInputStream(new File(this.a.f(str, inputStream, FileExtension.JSON).getAbsolutePath())), str);
    }

    @NonNull
    private oa1<a> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return b.u(new ZipInputStream(inputStream), null);
        }
        return b.u(new ZipInputStream(new FileInputStream(this.a.f(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    @WorkerThread
    public oa1<a> c(@NonNull String str, @Nullable String str2) {
        a a2 = a(str, str2);
        if (a2 != null) {
            return new oa1<>(a2);
        }
        o91.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }
}
