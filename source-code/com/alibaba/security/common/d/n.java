package com.alibaba.security.common.d;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class n {
    private static final String a = "n";
    private static n c = null;
    private static final String d = "armeabi-v7a";
    private static final String e = "arm64-v8a";
    private final Context b;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements FileFilter {
        String a = "";

        public a(String str) {
            this.a = str;
        }

        public final boolean accept(File file) {
            return file.getName().startsWith(this.a);
        }
    }

    private n(Context context) {
        this.b = context;
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (c == null) {
                c = new n(context);
            }
            nVar = c;
        }
        return nVar;
    }

    public final boolean a(String str) {
        String str2 = str + "_bak";
        File filesDir = this.b.getFilesDir();
        if (a(filesDir.toString(), str2, str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            String str3 = File.separator;
            sb.append(str3);
            sb.append(SolidMonitor.CHECK_TYPE_LIB + str + ".so");
            File file = new File(filesDir.toString() + str3 + sb.toString());
            if (file.exists()) {
                try {
                    System.load(file.toString());
                    return true;
                } catch (UnsatisfiedLinkError e2) {
                    com.alibaba.security.common.c.a.d(a, e2.toString());
                }
            } else {
                com.alibaba.security.common.c.a.a(a, String.format(Locale.ENGLISH, "error can't find %1$s lib in plugins_lib", str));
            }
        } else {
            String.format(Locale.ENGLISH, "error copy %1$s lib fail", str);
        }
        return false;
    }

    private void a(File file, String str) {
        try {
            for (File file2 : file.listFiles(new a(str))) {
                a(file2);
            }
        } catch (Exception e2) {
            com.alibaba.security.common.c.a.d(a, e2.toString());
        }
    }

    private void a(File file) {
        File[] listFiles;
        if (!file.exists()) {
            com.alibaba.security.common.c.a.a(a, "File to be delete is not found");
        } else if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
            file.delete();
        }
    }

    private boolean a(String str, String str2, String str3) {
        String str4;
        String cpu_abi = Build.getCPU_ABI();
        String str5 = SolidMonitor.CHECK_TYPE_LIB + str3 + ".so";
        if (DeviceUtils.ABI_X86.equals(cpu_abi)) {
            str4 = "lib/armeabi-v7a/".concat(String.valueOf(str5));
        } else if (cpu_abi.startsWith("armeabi")) {
            str4 = "lib/armeabi-v7a/".concat(String.valueOf(str5));
        } else if (!cpu_abi.startsWith("arm64")) {
            return false;
        } else {
            str4 = "lib/arm64-v8a/".concat(String.valueOf(str5));
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str6 = File.separator;
            sb.append(str6);
            sb.append(str2);
            File file = new File(sb.toString());
            File file2 = new File(file.toString() + str6 + str5);
            a(file, SolidMonitor.CHECK_TYPE_LIB.concat(String.valueOf(str3)));
            file.mkdirs();
            return a(str4, file2);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a(String str, File file) {
        InputStream resourceAsStream = n.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            return false;
        }
        boolean a2 = a(resourceAsStream, file);
        try {
            resourceAsStream.close();
            return a2;
        } catch (IOException unused) {
            return a2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6 A[SYNTHETIC, Splitter:B:64:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be A[Catch:{ IOException -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c3 A[Catch:{ IOException -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    private static boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        FileNotFoundException e2;
        IOException e3;
        FileOutputStream fileOutputStream = null;
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedOutputStream.flush();
                                fileOutputStream2.flush();
                                try {
                                    fileOutputStream2.close();
                                    bufferedInputStream.close();
                                    bufferedOutputStream.close();
                                    return true;
                                } catch (IOException e4) {
                                    com.alibaba.security.common.c.a.d(a, e4.toString());
                                    return false;
                                }
                            }
                        }
                    } catch (FileNotFoundException e5) {
                        fileOutputStream = fileOutputStream2;
                        e2 = e5;
                        com.alibaba.security.common.c.a.d(a, e2.toString());
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                    } catch (IOException e6) {
                        fileOutputStream = fileOutputStream2;
                        e3 = e6;
                        try {
                            com.alibaba.security.common.c.a.d(a, e3.toString());
                            if (fileOutputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (bufferedOutputStream != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    com.alibaba.security.common.c.a.d(a, e7.toString());
                                    throw th;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        fileOutputStream = fileOutputStream2;
                        th = th3;
                        if (fileOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    fileOutputStream = fileOutputStream2;
                    e2 = e8;
                    bufferedOutputStream = null;
                    com.alibaba.security.common.c.a.d(a, e2.toString());
                    if (fileOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                } catch (IOException e9) {
                    fileOutputStream = fileOutputStream2;
                    e3 = e9;
                    bufferedOutputStream = null;
                    com.alibaba.security.common.c.a.d(a, e3.toString());
                    if (fileOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                } catch (Throwable th4) {
                    fileOutputStream = fileOutputStream2;
                    th = th4;
                    bufferedOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                e2 = e10;
                bufferedOutputStream = null;
                com.alibaba.security.common.c.a.d(a, e2.toString());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    return false;
                }
                bufferedOutputStream.close();
                return false;
            } catch (IOException e11) {
                e3 = e11;
                bufferedOutputStream = null;
                com.alibaba.security.common.c.a.d(a, e3.toString());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    return false;
                }
                bufferedOutputStream.close();
                return false;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                if (fileOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e12) {
            e2 = e12;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            com.alibaba.security.common.c.a.d(a, e2.toString());
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
        } catch (IOException e13) {
            e3 = e13;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            com.alibaba.security.common.c.a.d(a, e3.toString());
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
    }
}
