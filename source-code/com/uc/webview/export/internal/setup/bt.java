package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.h;
import com.uc.webview.export.internal.utility.p;
import com.youku.arch.solid.monitor.SolidMonitor;
import io.flutter.stat.StatServices;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public class bt {
    public static final String ASSETS_DIR = "assets";
    public static final String RES_PAKS_DIR_NAME = "paks";
    private static final String[] a = {"webviewuc"};
    private static final String[] b = {"imagehelper"};
    private Context c;
    public String coreCode;
    public final Pair<String, String> coreImplModule;
    private HashMap<String, String> d;
    public final String dataDir;
    public final String disabledFilePath;
    public boolean isFromDisk = false;
    public ClassLoader mCoreClassLoader;
    public ClassLoader mSdkShellClassLoader;
    public String mainLibrary;
    public final String pkgName;
    public final String resDirPath;
    public final Pair<String, String> sdkShellModule;
    public final String soDirPath;

    public bt(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2) throws UCSetupException {
        String str9 = null;
        this.mainLibrary = null;
        this.coreCode = "";
        this.mSdkShellClassLoader = null;
        this.mCoreClassLoader = null;
        this.d = new HashMap<>();
        Log.d("UCMPackageInfo", "UCMPackageInfo, dataDir: " + str4 + ", pkgName: " + str + ", soDirPath: " + str2 + ", resDirPath: " + str3 + ", sdkShellPath: " + str5);
        String f = p.f(str2);
        String f2 = p.f(str3);
        String f3 = p.f(str4);
        String f4 = p.f(str5);
        String f5 = p.f(str7);
        String f6 = p.f(str8);
        this.c = context.getApplicationContext();
        this.pkgName = str;
        this.soDirPath = f;
        f2 = z ? p.a(context, f3, f2) : f2;
        if (f2 == null) {
            f2 = null;
        } else if (!f2.endsWith("/")) {
            f2 = f2 + "/";
        }
        this.resDirPath = f2;
        if (p.f()) {
            this.dataDir = f3;
            this.disabledFilePath = p.g();
            this.sdkShellModule = null;
            if (p.a(f5)) {
                this.coreImplModule = null;
            } else {
                this.coreImplModule = new Pair<>(f5, f6);
            }
        } else if (f3 != null) {
            File b2 = p.b(f6 == null ? p.a(context, "odexs") : new File(f6), p.e(p.b(context, f3)));
            this.dataDir = f3;
            this.disabledFilePath = f3 + "/e1df430e25e9dacb26ead508abb3413f";
            this.sdkShellModule = new Pair<>(z ? p.b(context, f3, f4) : f4, b2.getAbsolutePath());
            this.coreImplModule = new Pair<>(z ? p.b(context, f3, f5) : f5, b2.getAbsolutePath());
        } else {
            this.dataDir = null;
            this.disabledFilePath = p.g();
            this.sdkShellModule = null;
            this.coreImplModule = null;
        }
        String f7 = p.a(f) ? p.f(context.getApplicationInfo().nativeLibraryDir) : f;
        String[] strArr = a;
        for (String str10 : strArr) {
            File file = new File(f7, SolidMonitor.CHECK_TYPE_LIB + str10 + ".so");
            if (file.exists() && (file.lastModified() <= 0 || file.lastModified() > 0)) {
                str9 = str10;
            }
        }
        if (str9 == null && !p.a(f)) {
            throw new UCSetupException(3001, String.format("Main so file U4 [%s] not exists.", "webviewuc"));
        } else if (!z2) {
            this.mainLibrary = str9;
            String str11 = "webviewuc".equals(str9) ? "u4" : this.mainLibrary == null ? "null" : "error";
            this.coreCode = str11;
            if (str11.equals("u4")) {
                String[] strArr2 = b;
                for (String str12 : strArr2) {
                    File file2 = new File(context.getApplicationInfo().nativeLibraryDir, SolidMonitor.CHECK_TYPE_LIB + str12 + ".so");
                    File file3 = new File(f7, SolidMonitor.CHECK_TYPE_LIB + str12 + ".so");
                    if (file2.exists()) {
                        long lastModified = file2.lastModified();
                        if (!file3.exists() || file3.lastModified() < lastModified) {
                            p.a(file2, file3, file3);
                        }
                    }
                }
            }
        }
    }

    public String getDirAlias(Context context) {
        Object obj;
        String str;
        Pair<String, String> pair = this.coreImplModule;
        if (pair == null || (obj = pair.first) == null || (str = (String) obj) == null) {
            return "nul";
        }
        if (str.startsWith(p.a(context, "decompresses2").getAbsolutePath())) {
            return "dec";
        }
        if (str.startsWith(p.a(context, "updates").getAbsolutePath())) {
            return "upd";
        }
        if (str.startsWith(p.a(context, "kjlinks").getAbsolutePath())) {
            return "kjl";
        }
        if (str.startsWith(p.a(context, "kjcopies").getAbsolutePath())) {
            return "kjc";
        }
        return str.startsWith(p.a(context, "repairs").getAbsolutePath()) ? "rep" : "oth";
    }

    public Map<String, String> getFileHashs() {
        HashMap hashMap = new HashMap(16);
        Pair<String, String> pair = this.coreImplModule;
        if (pair == null || pair.first == null) {
            hashMap.put(StatServices.CATEGORY, "null");
        } else {
            File file = new File((String) this.coreImplModule.first);
            hashMap.put(file.getName(), UCCyclone.hashFileContents(file, UCCyclone.MessageDigestType.MD5));
        }
        Pair<String, String> pair2 = this.sdkShellModule;
        if (pair2 == null || pair2.first == null) {
            hashMap.put("sdk_shell", "null");
        } else {
            File file2 = new File((String) this.sdkShellModule.first);
            hashMap.put(file2.getName(), UCCyclone.hashFileContents(file2, UCCyclone.MessageDigestType.MD5));
        }
        String str = this.soDirPath;
        if (p.a(str)) {
            str = this.c.getApplicationInfo().nativeLibraryDir;
        }
        if (str != null) {
            File file3 = new File(str);
            if (file3.isDirectory()) {
                String[][] d2 = h.d(this.mSdkShellClassLoader);
                if (d2 != null) {
                    for (String[] strArr : d2) {
                        String str2 = strArr[0];
                        p.d(strArr[1]);
                        String str3 = strArr[2];
                        String hashFileContents = UCCyclone.hashFileContents(new File(file3, str2), UCCyclone.MessageDigestType.MD5);
                        if (p.a(str3) || str3.equals(hashFileContents)) {
                            hashMap.put(str2, "ok");
                        } else {
                            hashMap.put(str2, hashFileContents);
                        }
                    }
                } else {
                    hashMap.put("NativeLibraries", "null");
                }
            } else {
                hashMap.put("so_dir", "null");
            }
        } else {
            hashMap.put("so_path", "null");
        }
        return hashMap;
    }

    public String getInitInfo(String str) {
        String str2;
        synchronized (this.d) {
            str2 = this.d.get(str);
        }
        return str2;
    }

    public boolean quickPathReady() {
        return this.isFromDisk;
    }

    public bt setInitInfo(String str, String str2) {
        synchronized (this.d) {
            this.d.put(str, str2);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("quick=" + this.isFromDisk);
        sb.append("\npkgName=" + this.pkgName);
        sb.append("\ndisbaledPath=" + this.disabledFilePath);
        sb.append("\nsoDir=" + this.soDirPath);
        sb.append("\nassetsDir=" + this.resDirPath);
        sb.append("\ndataDir=" + this.dataDir);
        sb.append("\nmainLib=" + this.mainLibrary);
        sb.append("\ncore=" + this.coreCode);
        sb.append("\n\nucbsLoader=" + bt.class.getClassLoader());
        sb.append("\n\nshellLoader=" + this.mSdkShellClassLoader);
        StringBuilder sb2 = new StringBuilder("\n\ncoreLoader=");
        ClassLoader classLoader = this.mCoreClassLoader;
        if (classLoader == null) {
            classLoader = af.e();
        }
        sb2.append(classLoader);
        sb.append(sb2.toString());
        sb.append(StringUtils.LF);
        if (this.sdkShellModule != null) {
            sb.append("\nshellPath=[");
            sb.append((String) this.sdkShellModule.first);
            sb.append(":");
            sb.append((String) this.sdkShellModule.second);
            sb.append(jl1.ARRAY_END_STR);
        } else {
            sb.append("\nshellPath=[null]");
        }
        if (this.coreImplModule != null) {
            sb.append("\ncorePath=[");
            sb.append((String) this.coreImplModule.first);
            sb.append(":");
            sb.append((String) this.coreImplModule.second);
            sb.append(jl1.ARRAY_END_STR);
        } else {
            sb.append("\ncorePath=[null]");
        }
        return sb.toString();
    }
}
