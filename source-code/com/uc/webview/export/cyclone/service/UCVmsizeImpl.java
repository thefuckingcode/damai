package com.uc.webview.export.cyclone.service;

import android.content.Context;
import android.os.Build;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import com.taobao.weex.ui.component.WXComponent;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLibrary;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCService;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Constant
/* compiled from: Taobao */
public class UCVmsizeImpl implements UCVmsize {
    private static final String LOG_TAG = "UCVmsizeImpl";
    private static boolean mSoIsLoaded;
    private static UCKnownException mSoIsLoadedException;

    static {
        try {
            UCService.registerImpl(UCVmsize.class, new UCVmsizeImpl());
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(WXComponent.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("UCVmsizeImpl register exception:" + th, new Throwable[0]);
            }
        }
    }

    private static synchronized void loadSo(Context context) {
        synchronized (UCVmsizeImpl.class) {
            if (!mSoIsLoaded) {
                UCKnownException uCKnownException = mSoIsLoadedException;
                if (uCKnownException == null) {
                    try {
                        UCLibrary.load(context, UCCyclone.genFile(context, null, "libvmsize", ".so", 24713491, "e3d7b7107d5f402c1dde1a3930f7d7da", UCVmsizeImplConstant.genCodes(), new Object[0]).getAbsolutePath(), null);
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

    private static native int nativeSaveChromiumReservedSpace(long j);

    @Override // com.uc.webview.export.cyclone.service.UCServiceInterface
    public int getServiceVersion() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A[SYNTHETIC] */
    @Override // com.uc.webview.export.cyclone.service.UCVmsize
    public long saveChromiumReservedSpace(Context context) throws Exception {
        Class<?> cls;
        Field declaredField;
        Object obj;
        int i = Build.VERSION.SDK_INT;
        long j = 0;
        if (i >= 21 && i <= 27 && (declaredField = (cls = Class.forName("android.webkit.WebViewFactory")).getDeclaredField("sAddressSpaceReserved")) != null) {
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            if (declaredField.getBoolean(null)) {
                try {
                    Field declaredField2 = cls.getDeclaredField("sProviderLock");
                    if (declaredField2 == null) {
                        obj = this;
                        if (!mSoIsLoaded) {
                            loadSo(context);
                        }
                        synchronized (obj) {
                            declaredField.set(null, Boolean.FALSE);
                            try {
                                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
                                if (declaredMethod != null) {
                                    if (!declaredMethod.isAccessible()) {
                                        declaredMethod.setAccessible(true);
                                    }
                                    Long l = (Long) declaredMethod.invoke(null, "persist.sys.webview.vmsize", Long.valueOf((long) ZipAppConstants.LIMITED_APP_SPACE));
                                    if (l != null) {
                                        int nativeSaveChromiumReservedSpace = nativeSaveChromiumReservedSpace(l.longValue());
                                        if (nativeSaveChromiumReservedSpace == 0) {
                                            j = l.longValue();
                                        } else {
                                            throw new RuntimeException("Error:" + nativeSaveChromiumReservedSpace + " on nativeSaveChromiumReservedSpace");
                                        }
                                    } else {
                                        throw new RuntimeException("SystemProperties.getLong invoke return null.");
                                    }
                                } else {
                                    throw new RuntimeException("SystemProperties.getLong not found.");
                                }
                            } catch (Exception e) {
                                declaredField.set(null, Boolean.TRUE);
                                throw e;
                            }
                        }
                    } else {
                        if (!declaredField2.isAccessible()) {
                            declaredField2.setAccessible(true);
                        }
                        obj = declaredField2.get(null);
                        if (!mSoIsLoaded) {
                        }
                        synchronized (obj) {
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return j;
    }

    @Override // com.uc.webview.export.cyclone.service.UCServiceInterface
    public String toString() {
        return "UCVmsizeImpl." + getServiceVersion();
    }
}
