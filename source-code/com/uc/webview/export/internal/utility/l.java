package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.j;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: Taobao */
public final class l {

    /* compiled from: Taobao */
    public static class b implements ValueCallback<Object[]> {
        private String a;

        public b(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Object[] objArr) {
            Object[] objArr2 = objArr;
            Log.d("VerifyStat", "orign: " + this.a + " objects: " + Arrays.toString(objArr2));
            if (objArr2 != null && objArr2.length == 2 && (objArr2[0] instanceof Integer) && (objArr2[1] instanceof Integer)) {
                String num = ((Integer) objArr2[1]).toString();
                int intValue = ((Integer) objArr2[0]).intValue();
                if (intValue == 8) {
                    IWaStat.WaStat.stat(String.format("%s_err_%s", this.a, num));
                } else if (intValue == 10) {
                    IWaStat.WaStat.stat(String.format("%s_ver_%s", this.a, num));
                }
            }
        }
    }

    public static boolean a(String str, Context context, Context context2, ValueCallback<Object[]> valueCallback) {
        try {
            w.a(str, context);
            boolean a2 = a(str, context, context2, valueCallback, null);
            if (!a2) {
                w.a(str, context, a2);
            }
            return a2;
        } catch (UCSetupException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        public static Signature[] a(Context context, String str) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("SignatureVerifier", e.getMessage());
                return null;
            }
        }

        private static Signature[] b(Context context, String str) throws Exception {
            Object obj;
            Object obj2;
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                obj = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                obj = cls.getConstructor(String.class).newInstance("");
            }
            if (i >= 21) {
                obj2 = cls.getMethod("parsePackage", File.class, Integer.TYPE).invoke(obj, new File(str), 0);
            } else {
                obj2 = cls.getMethod("parsePackage", File.class, String.class, DisplayMetrics.class, Integer.TYPE).invoke(obj, new File(str), null, context.getResources().getDisplayMetrics(), 0);
            }
            try {
                cls.getMethod("collectCertificates", Class.forName("android.content.pm.PackageParser$Package"), Integer.TYPE).invoke(obj, obj2, 64);
                return (Signature[]) obj2.getClass().getField("mSignatures").get(obj2);
            } catch (Throwable unused) {
                cls.getMethod("collectCertificates", Class.forName("android.content.pm.PackageParser$Package"), Boolean.TYPE).invoke(obj, obj2, Boolean.TRUE);
                Object obj3 = obj2.getClass().getField("mSigningDetails").get(obj2);
                return (Signature[]) obj3.getClass().getField("signatures").get(obj3);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0083 A[SYNTHETIC, Splitter:B:24:0x0083] */
        public static Signature[] a(Context context, String str, ValueCallback<Object[]> valueCallback) {
            Throwable th;
            boolean z;
            Signature[] signatureArr;
            int i;
            boolean z2;
            Log.d("SignatureVerifier", String.format("getUninstalledAPKSignature(): archiveApkFilePath = %1s", str));
            Signature[] signatureArr2 = null;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Boolean valueOf = Boolean.valueOf(Boolean.parseBoolean(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_FORCE_VERIFY_V1)));
                if (valueOf == null) {
                    z = false;
                } else {
                    z = valueOf.booleanValue();
                }
                if (!z) {
                    if (!UCCyclone.detectZipByFileType(str)) {
                        z2 = false;
                    } else if (a.a(str)) {
                        z2 = true;
                    } else {
                        z2 = x.a(str);
                    }
                    if (z2) {
                        Log.d("SignatureVerifier", "摘要校验V2!");
                        X509Certificate[][] b = a.b(str);
                        signatureArr = new Signature[b.length];
                        for (int i2 = 0; i2 < b.length; i2++) {
                            signatureArr[i2] = new Signature(b[i2][0].getEncoded());
                        }
                        i = 2;
                        if (valueCallback != null) {
                            try {
                                valueCallback.onReceiveValue(new Object[]{10, Integer.valueOf(i)});
                            } catch (Throwable unused) {
                            }
                        }
                        if (signatureArr != null || signatureArr.length <= 0) {
                            Log.e("SignatureVerifier", "摘要校验失败");
                        } else {
                            try {
                                Log.d("SignatureVerifier", "摘要校验成功!");
                                signatureArr2 = signatureArr;
                            } catch (Throwable th2) {
                                th = th2;
                                signatureArr2 = signatureArr;
                                th.printStackTrace();
                                Log.e("SignatureVerifier", th.getMessage());
                                return signatureArr2;
                            }
                        }
                        Log.i("SignatureVerifier", "耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        return signatureArr2;
                    }
                }
                Log.d("SignatureVerifier", "摘要校验V1! 强制V1:" + z);
                signatureArr = b(context, str);
                i = 1;
                if (valueCallback != null) {
                }
                if (signatureArr != null) {
                }
                Log.e("SignatureVerifier", "摘要校验失败");
                Log.i("SignatureVerifier", "耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                Log.e("SignatureVerifier", th.getMessage());
                return signatureArr2;
            }
            return signatureArr2;
        }

        static Signature[] a(byte[] bArr) throws Exception {
            X509Certificate[][] a = a.a(ByteBuffer.wrap(bArr));
            Signature[] signatureArr = new Signature[a.length];
            for (int i = 0; i < a.length; i++) {
                signatureArr[i] = new Signature(a[i][0].getEncoded());
            }
            return signatureArr;
        }

        public static PublicKey[] a(Signature[] signatureArr) {
            if (signatureArr != null) {
                try {
                    if (signatureArr.length != 0) {
                        int length = signatureArr.length;
                        PublicKey[] publicKeyArr = new PublicKey[length];
                        for (int i = 0; i < length; i++) {
                            publicKeyArr[i] = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i].toByteArray()))).getPublicKey();
                        }
                        return publicKeyArr;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("SignatureVerifier", "获取公钥异常：\n" + e.getMessage());
                }
            }
            return null;
        }

        public static final boolean a(PublicKey[] publicKeyArr) {
            return publicKeyArr == null || publicKeyArr.length <= 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    public static boolean a(String str, Context context, Context context2, ValueCallback<Object[]> valueCallback, j.a aVar) {
        long currentTimeMillis;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        if (!new File(str).exists()) {
            return false;
        }
        Log.d("SignatureVerifier", "verify: file = " + str);
        currentTimeMillis = System.currentTimeMillis();
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            Signature[] a2 = a.a(context, str, valueCallback);
            if (a2 == null || a2.length <= 0) {
                Log.d("SignatureVerifier", "verify: failed: Signatures of archive is empty. Costs " + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
                if (valueCallback != null) {
                    try {
                        valueCallback.onReceiveValue(new Object[]{8, 1});
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (aVar != null) {
                    aVar.a(j.a.i);
                }
                sb3 = new StringBuilder("Verify: total costs:");
            } else {
                PublicKey[] a3 = a.a(a2);
                if (a.a(a3)) {
                    Log.d("SignatureVerifier", "verify: failed: PublicKeys of archive is empty. Costs " + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
                    if (valueCallback != null) {
                        try {
                            valueCallback.onReceiveValue(new Object[]{8, 2});
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (aVar != null) {
                        aVar.a(j.a.j);
                    }
                    sb3 = new StringBuilder("Verify: total costs:");
                } else {
                    Log.d("SignatureVerifier", "verify: step 0: get PublicKeys of archive ok. Costs " + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
                    if (context2 != null) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (a(a3, a.a(context, context2.getPackageName()))) {
                            Log.d("SignatureVerifier", "verify: step 1: get Signatures of app from current context and verify ok. Costs " + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
                            sb2 = new StringBuilder("Verify: total costs:");
                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                            sb2.append("ms");
                            Log.d("SignatureVerifier", sb2.toString());
                            return true;
                        }
                        Log.d("SignatureVerifier", "verify: step 1: get Signatures of app from current context and verify failed. Costs " + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
                    }
                    long currentTimeMillis4 = System.currentTimeMillis();
                    try {
                        if (a(a3, a.a(Base64.decode("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", 2)))) {
                            Log.d("SignatureVerifier", "verify: step 2: get Signatures of app from hardcode app and verify ok. Costs " + (System.currentTimeMillis() - currentTimeMillis4) + "ms.");
                            sb2 = new StringBuilder("Verify: total costs:");
                            sb2.append(System.currentTimeMillis() - currentTimeMillis);
                            sb2.append("ms");
                            Log.d("SignatureVerifier", sb2.toString());
                            return true;
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    Log.d("SignatureVerifier", "verify: step 2: get Signatures of app from hardcode app and verify failed. Costs " + (System.currentTimeMillis() - currentTimeMillis4) + "ms.");
                    if (valueCallback != null) {
                        try {
                            valueCallback.onReceiveValue(new Object[]{8, 3});
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    sb = new StringBuilder("Verify: total costs:");
                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                    sb.append("ms");
                    Log.d("SignatureVerifier", sb.toString());
                    if (aVar != null) {
                        return false;
                    }
                    aVar.a(j.a.l);
                    return false;
                }
            }
            sb3.append(System.currentTimeMillis() - currentTimeMillis);
            sb3.append("ms");
            Log.d("SignatureVerifier", sb3.toString());
            return false;
        } catch (Throwable th5) {
            Log.d("SignatureVerifier", "Verify: total costs:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            throw th5;
        }
        if (aVar != null) {
            aVar.a(j.a.m);
        }
        if (aVar != null) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_SIG_VERIFY_EXCEPTION);
        }
        if (aVar != null) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_SIG_VERIFY_EXCEPTION_VALUE, j.b(th.toString()));
        }
        th.printStackTrace();
        sb = new StringBuilder("Verify: total costs:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append("ms");
        Log.d("SignatureVerifier", sb.toString());
        if (aVar != null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    private static final boolean a(PublicKey[] publicKeyArr, Signature[] signatureArr) {
        boolean z;
        try {
            PublicKey[] a2 = a.a(signatureArr);
            if (a.a(a2)) {
                Log.d("SignatureVerifier", "公钥校验错误：Implement.isEmpty(appPublicKeys) == true");
                return false;
            }
            if (a2 != null) {
                if (publicKeyArr != null) {
                    HashSet hashSet = new HashSet();
                    for (PublicKey publicKey : a2) {
                        hashSet.add(publicKey);
                    }
                    HashSet hashSet2 = new HashSet();
                    for (PublicKey publicKey2 : publicKeyArr) {
                        hashSet2.add(publicKey2);
                    }
                    if (hashSet.equals(hashSet2)) {
                        z = true;
                        if (!z) {
                            Log.d("SignatureVerifier", "公钥校验错误：Implement.equals(appPublicKeys, archiveKeys) == false");
                            return false;
                        }
                        Log.d("SignatureVerifier", "公钥校验正确!");
                        return true;
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            Log.e("SignatureVerifier", "Sign.equals: s1 == null || s2 == null");
            z = false;
            if (!z) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Log.d("SignatureVerifier", "公钥校验错误：Implement.isEmpty(appPublicKeys) == true");
            return false;
        }
    }
}
