package dev.fluttercommunity.plus.packageinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.youku.upsplayer.util.YKUpsConvert;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.collections.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.u91;

/* compiled from: Taobao */
public final class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @NotNull
    public static final C0262a Companion = new C0262a(null);
    @Nullable
    private Context a;
    @Nullable
    private MethodChannel b;

    /* renamed from: dev.fluttercommunity.plus.packageinfo.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0262a {
        private C0262a() {
        }

        public /* synthetic */ C0262a(m40 m40) {
            this();
        }
    }

    private final String a(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F};
        char[] cArr2 = new char[(bArr.length * 2)];
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            int i4 = i * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
            i = i2;
        }
        return new String(cArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if ((r5.length == 0) != false) goto L_0x0079;
     */
    private final String b(PackageManager packageManager) {
        String d;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Context context = this.a;
                k21.f(context);
                SigningInfo signingInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo == null) {
                    return null;
                }
                if (signingInfo.hasMultipleSigners()) {
                    Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                    k21.h(apkContentsSigners, "signingInfo.apkContentsSigners");
                    byte[] byteArray = ((Signature) e.u(apkContentsSigners)).toByteArray();
                    k21.h(byteArray, "signingInfo.apkContentsS…ers.first().toByteArray()");
                    d = d(byteArray);
                } else {
                    Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    k21.h(signingCertificateHistory, "signingInfo.signingCertificateHistory");
                    byte[] byteArray2 = ((Signature) e.u(signingCertificateHistory)).toByteArray();
                    k21.h(byteArray2, "signingInfo.signingCerti…ory.first().toByteArray()");
                    d = d(byteArray2);
                }
            } else {
                Context context2 = this.a;
                k21.f(context2);
                Signature[] signatureArr = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
                boolean z = false;
                if (signatureArr != null) {
                }
                z = true;
                if (z) {
                    return null;
                }
                k21.h(signatureArr, "packageInfo.signatures");
                if (e.u(signatureArr) == null) {
                    return null;
                }
                k21.h(signatureArr, "signatures");
                byte[] byteArray3 = ((Signature) e.u(signatureArr)).toByteArray();
                k21.h(byteArray3, "signatures.first().toByteArray()");
                d = d(byteArray3);
            }
            return d;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final long c(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    private final String d(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        instance.update(bArr);
        byte[] digest = instance.digest();
        k21.h(digest, "hashText");
        return a(digest);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k21.i(flutterPluginBinding, "binding");
        this.a = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
        this.b = methodChannel;
        k21.f(methodChannel);
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        k21.i(flutterPluginBinding, "binding");
        this.a = null;
        MethodChannel methodChannel = this.b;
        k21.f(methodChannel);
        methodChannel.setMethodCallHandler(null);
        this.b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        k21.i(methodCall, "call");
        k21.i(result, "result");
        try {
            if (k21.d(methodCall.method, "getAll")) {
                Context context = this.a;
                k21.f(context);
                PackageManager packageManager = context.getPackageManager();
                Context context2 = this.a;
                k21.f(context2);
                PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
                k21.h(packageManager, "packageManager");
                String b2 = b(packageManager);
                HashMap hashMap = new HashMap();
                hashMap.put("appName", packageInfo.applicationInfo.loadLabel(packageManager).toString());
                Context context3 = this.a;
                k21.f(context3);
                hashMap.put("packageName", context3.getPackageName());
                hashMap.put("version", packageInfo.versionName);
                k21.h(packageInfo, "info");
                hashMap.put("buildNumber", String.valueOf(c(packageInfo)));
                if (b2 != null) {
                    hashMap.put("buildSignature", b2);
                }
                result.success(hashMap);
                return;
            }
            result.notImplemented();
        } catch (PackageManager.NameNotFoundException e) {
            result.error("Name not found", e.getMessage(), null);
        }
    }
}
