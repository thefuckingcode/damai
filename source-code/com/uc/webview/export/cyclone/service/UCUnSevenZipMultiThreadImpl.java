package com.uc.webview.export.cyclone.service;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.taobao.weex.ui.component.WXComponent;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLibrary;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCService;
import java.io.File;
import java.io.IOException;

@Constant
/* compiled from: Taobao */
public class UCUnSevenZipMultiThreadImpl implements UCUnSevenZip {
    private static final String LOG_TAG = "UCUnSevenZipMultiThreadImplConstant";
    private static String mFailedFilePath = null;
    private static boolean mSoIsLoaded = false;
    private static UCKnownException mSoIsLoadedException = null;
    private static final boolean sSupportArm64 = true;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum ArchType {
        Arm,
        Arm64,
        Unknown
    }

    static {
        try {
            UCService.registerImpl(UCUnSevenZip.class, new UCUnSevenZipMultiThreadImpl());
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(WXComponent.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("UCUnSevenZipMultiThreadImplConstant register exception:", th);
            }
        }
    }

    private static native int dec7z(String str, String str2, String str3);

    private static ArchType getCurrentArch(String str) {
        ArchType archType = ArchType.Unknown;
        if (Build.VERSION.SDK_INT >= 23) {
            if (Process.is64Bit()) {
                return ArchType.Arm64;
            }
            return ArchType.Arm;
        } else if (str.indexOf("/lib/arm64/") > 0) {
            return ArchType.Arm64;
        } else {
            return str.indexOf("/lib/arm/") > 0 ? ArchType.Arm : archType;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        throw new com.uc.webview.export.cyclone.UCKnownException(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x001a */
    private static synchronized void loadSo(Context context, ArchType archType) {
        synchronized (UCUnSevenZipMultiThreadImpl.class) {
            if (!mSoIsLoaded) {
                UCKnownException uCKnownException = mSoIsLoadedException;
                if (uCKnownException == null) {
                    try {
                        ArchType archType2 = ArchType.Arm;
                        if (archType2 == archType || ArchType.Arm64 == archType) {
                            loadSoImpl(context, archType);
                        } else {
                            loadSoImpl(context, archType2);
                            loadSoImpl(context, ArchType.Arm64);
                        }
                        mSoIsLoaded = true;
                    } catch (Throwable th) {
                        UCKnownException uCKnownException2 = new UCKnownException(th);
                        mSoIsLoadedException = uCKnownException2;
                        throw uCKnownException2;
                    }
                } else {
                    throw uCKnownException;
                }
            }
        }
    }

    private static void loadSoImpl(Context context, ArchType archType) throws IOException {
        File file;
        try {
            if (ArchType.Arm == archType) {
                file = UCCyclone.genFile(context, null, "libdec7zmt-arm", ".so", 25977809, "b815846a1a67c293fea7d09625a9ced1", UCUnSevenZipMultiThreadImplConstantArm.genCodes(), new Object[0]);
            } else {
                file = ArchType.Arm64 == archType ? UCCyclone.genFile(context, null, "libdec7zmt-arm64", ".so", 25936580, "8e50b80c2ff7c7f2f62825e4e4ca4101", UCUnSevenZipMultiThreadImplConstantArm64.genCodes(), new Object[0]) : null;
            }
            if (file != null) {
                UCLibrary.load(context, file.getAbsolutePath(), null);
                return;
            }
            throw new UCKnownException("arch not support");
        } catch (IOException e) {
            throw e;
        }
    }

    public static void saveFailedFilePath(String str) {
        mFailedFilePath = str;
    }

    @Override // com.uc.webview.export.cyclone.service.UCUnSevenZip
    public int deccompress(Context context, String str, String str2) {
        loadSo(context, getCurrentArch(str));
        int dec7z = dec7z(str, str2, "");
        UCLogger create = !UCCyclone.enableDebugLog ? null : UCLogger.create("d", LOG_TAG);
        if (create != null) {
            create.print("UCUnSevenZipMultiThreadImpl.dec ret=" + dec7z, new Throwable[0]);
        }
        return dec7z;
    }

    @Override // com.uc.webview.export.cyclone.service.UCUnSevenZip
    public String failedFilePath() {
        return mFailedFilePath;
    }

    @Override // com.uc.webview.export.cyclone.service.UCServiceInterface
    public int getServiceVersion() {
        return 0;
    }

    @Override // com.uc.webview.export.cyclone.service.UCUnSevenZip
    public int deccompress(Context context, String str, String str2, String str3) {
        loadSo(context, getCurrentArch(str));
        int dec7z = dec7z(str, str2, str3);
        UCLogger create = !UCCyclone.enableDebugLog ? null : UCLogger.create("d", LOG_TAG);
        if (create != null) {
            create.print("UCUnSevenZipMultiThreadImpl.dec ret=" + dec7z, new Throwable[0]);
        }
        return dec7z;
    }
}
