package com.uc.webview.export.business.setup;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.business.a;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.b;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class p extends SetupTask {
    private static final String a = p.class.getSimpleName();
    private static String d = "_odex_ready";
    private a c = new a();

    public static boolean b(String str, String str2) {
        try {
            File file = new File(UCCore.getExtractDirPath(str, str2));
            if (!file.exists() || com.uc.webview.export.internal.utility.p.a(file, d, false) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:44|45|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r10.c.a(com.uc.webview.export.business.a.c.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0216, code lost:
        r0 = com.uc.webview.export.business.setup.p.a;
        com.uc.webview.export.internal.utility.Log.d(r0, ".run stat: " + r10.c.a);
        r2 = r10.c.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0231, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0232, code lost:
        r3 = com.uc.webview.export.business.setup.p.a;
        com.uc.webview.export.internal.utility.Log.d(r3, ".run stat: " + r10.c.a);
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, java.lang.Long.toString(r10.c.a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0252, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x020f */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        long j;
        this.c.a(a.c.a);
        if (com.uc.webview.export.internal.utility.p.h() && com.uc.webview.export.internal.utility.p.a((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
            UCCore.setGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION, "1");
            SDKFactory.c(getContext());
        }
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (str == null || "0".equals(str) || (com.uc.webview.export.internal.utility.p.h() && "1".equals(str))) {
            String str2 = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
            String str3 = (String) getOption(UCCore.OPTION_DECOMPRESS_ROOT_DIR);
            String str4 = a;
            Log.d(str4, ".run decFilePath: " + str2 + " decRootDirPath: " + str3);
            if (com.uc.webview.export.internal.utility.p.a(str2) || com.uc.webview.export.internal.utility.p.a(str3)) {
                this.c.a(a.c.e);
                Log.d(str4, ".run stat: " + this.c.a);
                j = this.c.a;
                IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(j));
            }
            if (b(str3, str2)) {
                Log.d(str4, "readyDecompressAndODex");
                this.c.a(a.c.f);
                Log.d(str4, ".run stat: " + this.c.a);
                j = this.c.a;
            } else {
                l lVar = (l) new b().setParent(this);
                ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> concurrentHashMap = this.mCallbacks;
                if (concurrentHashMap != null) {
                    for (Map.Entry<String, ValueCallback<CALLBACK_TYPE>> entry : concurrentHashMap.entrySet()) {
                        lVar.onEvent(entry.getKey(), (ValueCallback) new q(this, entry));
                    }
                }
                ((l) ((l) lVar.onEvent("exception", (ValueCallback) new t(this))).onEvent(UCCore.EVENT_DIE, (ValueCallback) new s(this))).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) new r(this, str3, str2));
                this.c.a(a.c.b);
                Integer num = (Integer) getOption(UCCore.OPTION_VERIFY_POLICY);
                String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_VERIFY_POLICY);
                if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_ASYNC.equals(param)) {
                    num = Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH);
                } else if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_SYNC.equals(param)) {
                    num = Integer.valueOf(Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH).intValue() & Integer.MAX_VALUE);
                }
                ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) lVar.setOptions(this.mOptions)).setup(UCCore.OPTION_VERIFY_POLICY, (Object) num)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) Boolean.valueOf(!com.uc.webview.export.internal.utility.p.h()))).setup(UCCore.OPTION_CHECK_MULTI_CORE, (Object) Boolean.TRUE)).setup(UCCore.OPTION_ENABLE_LOAD_CLASS, (Object) Boolean.FALSE);
                this.mCallbacks = null;
                lVar.start();
                String str5 = a;
                Log.d(str5, ".run stat: " + this.c.a);
                j = this.c.a;
            }
            IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(j));
        }
        this.c.a(a.c.d);
        String str6 = a;
        Log.d(str6, ".run stat: " + this.c.a);
        j = this.c.a;
        IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(j));
    }

    public static void a(String str, String str2) {
        try {
            String extractDirPath = UCCore.getExtractDirPath(str, str2);
            File file = new File(str2);
            String decompressSourceHash = UCCyclone.getDecompressSourceHash(str2, file.length(), file.lastModified(), false);
            new File(extractDirPath, decompressSourceHash + d).createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void a(p pVar, l lVar) {
        ValueCallback valueCallback = (ValueCallback) pVar.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK);
        if (valueCallback != null) {
            String event = lVar.getEvent();
            Bundle bundle = new Bundle();
            bundle.putString("event", event);
            if (lVar.getException() != null) {
                bundle.putInt("errorCode", lVar.getException().errCode());
                bundle.putString("msg", lVar.getException().getMessage());
            }
            String str = a;
            Log.d(str, "decompressAndODex bundle: " + bundle);
            valueCallback.onReceiveValue(bundle);
        }
    }
}
