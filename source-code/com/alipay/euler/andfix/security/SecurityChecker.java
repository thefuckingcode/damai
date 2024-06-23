package com.alipay.euler.andfix.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alipay.euler.andfix.log.Log;
import com.alipay.euler.andfix.patch.PatchManager;
import com.uc.webview.export.extension.UCCore;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class SecurityChecker {
    public static final String SP_MD5 = "-md5";
    private final Context a;
    private PublicKey b;
    private boolean c;

    public SecurityChecker(Context context, boolean z) {
        this.a = context;
        d(context, z);
    }

    private boolean a(File file, Certificate[] certificateArr) {
        if (certificateArr.length <= 0) {
            return false;
        }
        for (int length = certificateArr.length - 1; length >= 0; length--) {
            try {
                certificateArr[length].verify(this.b);
                return true;
            } catch (Exception e) {
                Log.e("SecurityChecker", file.getAbsolutePath(), e);
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[SYNTHETIC, Splitter:B:23:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0055 A[SYNTHETIC, Splitter:B:31:0x0055] */
    private String b(File file) {
        Throwable th;
        Exception e;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        instance.update(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            Log.e("SecurityChecker", "getFileMD5", e2);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.e("SecurityChecker", "getFileMD5", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                Log.e("SecurityChecker", "getFileMD5", e4);
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                                Log.e("SecurityChecker", "getFileMD5", e5);
                            }
                        }
                        throw th;
                    }
                }
            }
            fileInputStream.close();
            return new BigInteger(instance.digest()).toString();
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            Log.e("SecurityChecker", "getFileMD5", e);
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    private String c(String str) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(PatchManager.SP_NAME, 4);
        return sharedPreferences.getString(str + "-md5", null);
    }

    private void d(Context context, boolean z) {
        if (z) {
            this.c = true;
            return;
        }
        try {
            this.b = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()))).getPublicKey();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("SecurityChecker", UCCore.LEGACY_EVENT_INIT, e);
        } catch (CertificateException e2) {
            Log.e("SecurityChecker", UCCore.LEGACY_EVENT_INIT, e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019  */
    private void e(JarFile jarFile, JarEntry jarEntry) throws IOException {
        Throwable th;
        InputStream inputStream;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream.read(new byte[8192]) > 0);
                inputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
    }

    private void f(String str, String str2) {
        SharedPreferences.Editor edit = this.a.getSharedPreferences(PatchManager.SP_NAME, 4).edit();
        edit.putString(str + "-md5", str2);
        edit.commit();
    }

    public boolean isDebug() {
        return this.c;
    }

    public void saveOptSig(File file) {
        f(file.getName(), b(file));
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065 A[SYNTHETIC, Splitter:B:38:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0074 A[SYNTHETIC, Splitter:B:44:0x0074] */
    public boolean verifyApk(File file) {
        JarFile jarFile;
        Throwable th;
        IOException e;
        if (this.c) {
            Log.d("SecurityChecker", "mDebuggable = true");
            return true;
        }
        try {
            jarFile = new JarFile(file);
            try {
                JarEntry jarEntry = jarFile.getJarEntry("classes.dex");
                if (jarEntry == null) {
                    try {
                        jarFile.close();
                    } catch (IOException e2) {
                        Log.e("SecurityChecker", file.getAbsolutePath(), e2);
                    }
                    return false;
                }
                e(jarFile, jarEntry);
                Certificate[] certificates = jarEntry.getCertificates();
                if (certificates == null) {
                    try {
                        jarFile.close();
                    } catch (IOException e3) {
                        Log.e("SecurityChecker", file.getAbsolutePath(), e3);
                    }
                    return false;
                }
                boolean a2 = a(file, certificates);
                try {
                    jarFile.close();
                } catch (IOException e4) {
                    Log.e("SecurityChecker", file.getAbsolutePath(), e4);
                }
                return a2;
            } catch (IOException e5) {
                e = e5;
                try {
                    Log.e("SecurityChecker", file.getAbsolutePath(), e);
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (IOException e6) {
                            Log.e("SecurityChecker", file.getAbsolutePath(), e6);
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (IOException e7) {
                            Log.e("SecurityChecker", file.getAbsolutePath(), e7);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e8) {
            jarFile = null;
            e = e8;
            Log.e("SecurityChecker", file.getAbsolutePath(), e);
            if (jarFile != null) {
            }
            return false;
        } catch (Throwable th3) {
            jarFile = null;
            th = th3;
            if (jarFile != null) {
            }
            throw th;
        }
    }

    public boolean verifyOpt(File file) {
        String b2 = b(file);
        return b2 != null && TextUtils.equals(b2, c(file.getName()));
    }
}
