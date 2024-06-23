package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

/* compiled from: ApkUtil */
public class a {
    public static boolean a(Context context, File file, long j, int i) {
        if (file != null && file.exists()) {
            if (j > 0 && j != file.length()) {
                return false;
            }
            try {
                if (i == a(context, file) && "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(context, true, file))) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e A[SYNTHETIC, Splitter:B:25:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b A[SYNTHETIC, Splitter:B:33:0x006b] */
    public static String a(File file) {
        Throwable th;
        Exception e;
        FileInputStream fileInputStream;
        int i;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                int i2 = 0;
                for (i = 0; i < 16; i++) {
                    byte b = digest[i];
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b >>> 4) & 15];
                    i2 = i3 + 1;
                    cArr2[i3] = cArr[b & 15];
                }
                String str = new String(cArr2);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return str;
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static int a(Context context, File file) {
        try {
            return a(context, file, Build.VERSION.SDK_INT >= 20 ? !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME) : false);
        } catch (Exception unused) {
            TbsLog.i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    public static final String a(boolean z) {
        return b.c() ? z ? "x5.64.decouple.backup" : "x5.64.backup" : z ? "x5.decouple.backup" : "x5.backup";
    }

    private static int a(boolean z, File file) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            File[] listFiles = parentFile.listFiles();
            Pattern compile = Pattern.compile(a(z) + "(.*)");
            for (File file2 : listFiles) {
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int a(Context context, File file, boolean z) {
        int b;
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean contains = file.getName().contains("tbs.org");
                    boolean contains2 = file.getName().contains("x5.tbs.decouple");
                    if (contains || contains2) {
                        int a = a(contains2, file);
                        if (a > 0) {
                            return a;
                        }
                        if (!TbsShareManager.isThirdPartyApp(context)) {
                            if (!file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                                return 0;
                            }
                        }
                    }
                    boolean z2 = (Build.VERSION.SDK_INT == 23 || Build.VERSION.SDK_INT == 25) && Build.MANUFACTURER.toLowerCase().contains("mi");
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z = false;
                        z2 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if ((z || z2) && (b = b(file)) > 0) {
                        return b;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0071, code lost:
        if (r2 != null) goto L_0x004d;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007a A[SYNTHETIC, Splitter:B:47:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007f A[Catch:{ Exception -> 0x0082 }] */
    public static int b(File file) {
        BufferedReader bufferedReader;
        JarFile jarFile;
        Throwable th;
        Exception e;
        String[] split;
        synchronized (a.class) {
            try {
                jarFile = new JarFile(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(jarFile.getJarEntry("assets/webkit/tbs.conf"))));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                try {
                                    bufferedReader.close();
                                    break;
                                } catch (Exception unused) {
                                }
                            } else if (readLine.contains("tbs_core_version") && (split = readLine.split("=")) != null && split.length == 2) {
                                int parseInt = Integer.parseInt(split[1].trim());
                                bufferedReader.close();
                                jarFile.close();
                                return parseInt;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                }
                                if (jarFile != null) {
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (jarFile != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                jarFile = null;
                e = e4;
                bufferedReader = null;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
            } catch (Throwable th4) {
                jarFile = null;
                th = th4;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                        throw th;
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                throw th;
            }
            return -1;
        }
    }
}
