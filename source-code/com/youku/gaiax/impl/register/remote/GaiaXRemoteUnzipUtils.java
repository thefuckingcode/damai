package com.youku.gaiax.impl.register.remote;

import android.os.Build;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.dj;
import tb.k21;
import tb.ur2;
import tb.wd;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteUnzipUtils;", "", "Ljava/io/File;", "src", "", "target", "Ltb/ur2;", "unzip", "<init>", "()V", "ZipIO", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXRemoteUnzipUtils {
    @NotNull
    public static final GaiaXRemoteUnzipUtils INSTANCE = new GaiaXRemoteUnzipUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteUnzipUtils$ZipIO;", "", "Ljava/util/zip/ZipEntry;", "component1", "Ljava/io/File;", "component2", "entry", "output", by0.ARG_COPY, "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/zip/ZipEntry;", "getEntry", "()Ljava/util/zip/ZipEntry;", "Ljava/io/File;", "getOutput", "()Ljava/io/File;", "<init>", "(Ljava/util/zip/ZipEntry;Ljava/io/File;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class ZipIO {
        @NotNull
        private final ZipEntry entry;
        @NotNull
        private final File output;

        public ZipIO(@NotNull ZipEntry zipEntry, @NotNull File file) {
            k21.i(zipEntry, "entry");
            k21.i(file, "output");
            this.entry = zipEntry;
            this.output = file;
        }

        public static /* synthetic */ ZipIO copy$default(ZipIO zipIO, ZipEntry zipEntry, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                zipEntry = zipIO.entry;
            }
            if ((i & 2) != 0) {
                file = zipIO.output;
            }
            return zipIO.copy(zipEntry, file);
        }

        @NotNull
        public final ZipEntry component1() {
            return this.entry;
        }

        @NotNull
        public final File component2() {
            return this.output;
        }

        @NotNull
        public final ZipIO copy(@NotNull ZipEntry zipEntry, @NotNull File file) {
            k21.i(zipEntry, "entry");
            k21.i(file, "output");
            return new ZipIO(zipEntry, file);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZipIO)) {
                return false;
            }
            ZipIO zipIO = (ZipIO) obj;
            return k21.d(this.entry, zipIO.entry) && k21.d(this.output, zipIO.output);
        }

        @NotNull
        public final ZipEntry getEntry() {
            return this.entry;
        }

        @NotNull
        public final File getOutput() {
            return this.output;
        }

        public int hashCode() {
            return (this.entry.hashCode() * 31) + this.output.hashCode();
        }

        @NotNull
        public String toString() {
            return "ZipIO(entry=" + this.entry + ", output=" + this.output + ')';
        }
    }

    private GaiaXRemoteUnzipUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        tb.dj.a(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        tb.dj.a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        throw r7;
     */
    public final void unzip(@NotNull File file, @NotNull String str) {
        ZipFile zipFile;
        k21.i(file, "src");
        k21.i(str, "target");
        if (Build.VERSION.SDK_INT >= 24) {
            zipFile = new ZipFile(file, Charset.forName("GBK"));
        } else {
            zipFile = new ZipFile(file);
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        k21.h(entries, "zip.entries()");
        for (ZipIO zipIO : SequencesKt___SequencesKt.o(SequencesKt___SequencesKt.v(SequencesKt___SequencesKt.v(SequencesKt__SequencesKt.c(o.s(entries)), new GaiaXRemoteUnzipUtils$unzip$1(str)), GaiaXRemoteUnzipUtils$unzip$2.INSTANCE), GaiaXRemoteUnzipUtils$unzip$3.INSTANCE)) {
            ZipEntry component1 = zipIO.component1();
            File component2 = zipIO.component2();
            InputStream inputStream = zipFile.getInputStream(component1);
            FileOutputStream fileOutputStream = new FileOutputStream(component2);
            k21.h(inputStream, "input");
            wd.b(inputStream, fileOutputStream, 0, 2, null);
            ur2 ur2 = ur2.INSTANCE;
            dj.a(fileOutputStream, null);
            dj.a(inputStream, null);
        }
    }
}
