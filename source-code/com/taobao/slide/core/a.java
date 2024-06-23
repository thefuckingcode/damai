package com.taobao.slide.core;

import com.taobao.slide.model.ValidDO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tb.as1;
import tb.o22;
import tb.uk;

/* compiled from: Taobao */
public class a<T extends ValidDO> {
    private File a;

    public a(File file) {
        this.a = file;
    }

    private boolean a(File file) {
        try {
            return file.delete();
        } catch (Throwable th) {
            o22.d("DiskCache", "delete", th, new Object[0]);
            return false;
        }
    }

    public T b(String str) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;
        try {
            File file = new File(this.a, str);
            if (!file.exists()) {
                uk.a(null);
                uk.a(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                try {
                    T t = (T) ((ValidDO) objectInputStream2.readObject());
                    as1.a(t.isValid(), String.format("%s:not valid", str));
                    uk.a(objectInputStream2);
                    uk.a(fileInputStream);
                    return t;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        uk.a(objectInputStream);
                        uk.a(fileInputStream);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
        if (r11 != false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public boolean c(String str, T t) {
        Throwable th;
        FileOutputStream fileOutputStream;
        File file;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        if (!this.a.exists()) {
            o22.g("DiskCache", "save", "mkdirs root", Boolean.valueOf(this.a.mkdirs()));
        }
        FileOutputStream fileOutputStream4 = null;
        try {
            File createTempFile = File.createTempFile(str, ".tmp", this.a);
            try {
                fileOutputStream2 = new FileOutputStream(createTempFile);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream4;
                file = createTempFile;
                try {
                    o22.d("DiskCache", "save", th, "name", str);
                    return false;
                } finally {
                    uk.a(fileOutputStream);
                    uk.a(fileOutputStream4);
                    if (file != 0 && file.exists()) {
                        a(file);
                    }
                }
            }
            try {
                ?? objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream2));
                try {
                    objectOutputStream.writeObject(t);
                    objectOutputStream.flush();
                    if (createTempFile.renameTo(new File(this.a, str))) {
                        uk.a(objectOutputStream);
                        uk.a(fileOutputStream2);
                        if (createTempFile.exists()) {
                            a(createTempFile);
                        }
                        return true;
                    }
                    o22.k("DiskCache", "save rename fail", str);
                    uk.a(objectOutputStream);
                    uk.a(fileOutputStream2);
                    boolean exists = createTempFile.exists();
                    File file2 = createTempFile;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream3 = objectOutputStream;
                    fileOutputStream4 = fileOutputStream2;
                    file = createTempFile;
                    fileOutputStream = fileOutputStream3;
                    o22.d("DiskCache", "save", th, "name", str);
                    return false;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream3 = fileOutputStream4;
                fileOutputStream4 = fileOutputStream2;
                file = createTempFile;
                fileOutputStream = fileOutputStream3;
                o22.d("DiskCache", "save", th, "name", str);
                return false;
            }
        } catch (Throwable th5) {
            th = th5;
            FileOutputStream fileOutputStream5 = fileOutputStream4;
            fileOutputStream = fileOutputStream5;
            file = fileOutputStream5;
            o22.d("DiskCache", "save", th, "name", str);
            return false;
        }
    }
}
