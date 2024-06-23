package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.update.UpdateFlagMarker;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.g;
import com.uc.webview.export.internal.utility.p;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public final class e extends UCSubSetupTask<e, e> {
    private List<ax> a;

    public e(List<ax> list) {
        this.a = list;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:18|19|20|(1:26)|27|(1:33)|34|35|(6:37|38|39|40|(2:46|90)|47)|89|49|53|(2:56|54)|94|57) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0190, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0191, code lost:
        r25 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0138 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0140 A[Catch:{ all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019d A[LOOP:2: B:54:0x0199->B:56:0x019d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ae A[SYNTHETIC, Splitter:B:60:0x01ae] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e9 A[SYNTHETIC] */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public final void run() {
        boolean z;
        String str;
        String str2;
        Iterator<ax> it;
        boolean z2;
        int i;
        Log.d("DeleteCoreTask", "======deleteSo=====");
        Context context = (Context) getOption("CONTEXT");
        String[] strArr = {"libWebCore_UC.so", "libV8_UC.so", "libandroid_uc_40.so", "libandroid_uc_41.so", "libandroid_uc_42.so", "libandroid_uc_43.so", "libandroid_uc_44.so", "libandroid_uc_50.so", "libskia_neon_uc.so", "libwebviewuc.so", "libimagehelper.so", "libvinit.so", "libInitHelper_UC.so", "libcrashsdk.so"};
        Iterator<ax> it2 = this.a.iterator();
        boolean z3 = false;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (it2.next() instanceof bb) {
                str2 = (String) this.mOptions.get(UCCore.OPTION_SO_FILE_PATH);
                str = (String) this.mOptions.get(UCCore.OPTION_RES_FILE_PATH);
                z = true;
            } else {
                str2 = null;
                str = null;
                z = false;
            }
            if (str2 != null && str2.equals(context.getApplicationInfo().nativeLibraryDir)) {
                str2 = null;
            }
            String sourceHash = UCCyclone.getSourceHash(((String) null) + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str);
            File b = p.b(p.a(context, Constants.KEY_FLAGS), "delcore");
            StringBuilder sb = new StringBuilder();
            sb.append(sourceHash);
            sb.append("_1");
            File file = new File(b, sb.toString());
            File file2 = new File(b, sourceHash + "_2");
            File file3 = new File(b, sourceHash + "_3");
            if (file3.exists()) {
                Log.d("DeleteCoreTask", "Skip delete UC files (over 3 times).");
                break;
            } else if (p.a((String) null)) {
                if (!p.a(str2)) {
                    File parentFile = new File(str2).getParentFile();
                    File finishFlag = UpdateFlagMarker.getFinishFlag(parentFile);
                    if (finishFlag.exists() && finishFlag.isFile() && finishFlag.length() == 0) {
                        finishFlag.delete();
                    }
                    File startFlag = UpdateFlagMarker.getStartFlag(parentFile);
                    if (startFlag.exists() && startFlag.isFile() && startFlag.length() == 0) {
                        startFlag.delete();
                    }
                    File[] listFiles = parentFile.listFiles();
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i2 < length) {
                        File file4 = listFiles[i2];
                        String name = file4.getName();
                        File parentFile2 = file4.getParentFile();
                        File parentFile3 = parentFile2.getParentFile();
                        StringBuilder sb2 = new StringBuilder();
                        it = it2;
                        try {
                            sb2.append(parentFile3.getName());
                            sb2.append(JSMethod.NOT_SET);
                            sb2.append(parentFile2.getName());
                            if (name.startsWith(sb2.toString()) && file4.isFile() && file4.length() == 0) {
                                file4.delete();
                            }
                            i2++;
                            listFiles = listFiles;
                            it2 = it;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            Log.w("DeleteCoreTask", "delete flag:", th2);
                            while (i < 14) {
                            }
                            z2 = true;
                            if (z) {
                            }
                        }
                    }
                    it = it2;
                    for (i = 0; i < 14; i++) {
                        g.a(str2, strArr[i]);
                    }
                    z2 = true;
                } else {
                    it = it2;
                    z2 = z3;
                }
                if (z) {
                    try {
                        Log.d("DeleteCoreTask", "deleteCoreFlagDir:" + b);
                        if (!file.exists()) {
                            file.createNewFile();
                        } else if (!file2.exists()) {
                            file2.createNewFile();
                        } else if (!file3.exists()) {
                            file3.createNewFile();
                        }
                    } catch (Throwable th3) {
                        Log.w("DeleteCoreTask", "deleteCoreFlag:", th3);
                    }
                    z3 = z2;
                    it2 = it;
                } else {
                    throw null;
                }
            } else {
                p.a(context, (String) null).getAbsolutePath();
                throw null;
            }
        }
        this.a.clear();
        if (z3) {
            IWaStat.WaStat.stat(IWaStat.SETUP_DELETE_CORE_COUNT);
        }
    }
}
