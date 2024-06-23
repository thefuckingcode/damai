package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.p;
import java.io.File;

/* compiled from: Taobao */
public final class f extends UCSubSetupTask<f, f> {
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01fd A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0200 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f A[Catch:{ all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011b A[Catch:{ all -> 0x01f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0185 A[Catch:{ all -> 0x01f1 }] */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public final void run() {
        File file;
        File[] listFiles;
        File[] listFiles2;
        File file2;
        boolean z;
        File a;
        File file3;
        File[] listFiles3;
        File[] listFiles4;
        File file4;
        Pair<String, String> pair;
        try {
            Context context = (Context) getOption("CONTEXT");
            p.a(context);
            UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
            if (totalLoadedUCM.coreType != 2) {
                String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
                if (p.a(str)) {
                    return;
                }
                if ("0".equals(str)) {
                    Boolean valueOf = Boolean.valueOf(!p.b((Boolean) getOption("del_dec_fil")));
                    Boolean valueOf2 = Boolean.valueOf(!p.b((Boolean) getOption("del_upd_fil")));
                    try {
                        UCLogger create = !UCCyclone.enableDebugLog ? null : UCLogger.create("i", "DeleteFileTask");
                        try {
                            UCCyclone.deleteUnusedFiles(context);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        try {
                            p.b(context);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        try {
                            bt btVar = totalLoadedUCM.ucmPackageInfo;
                            if (!(btVar == null || (pair = btVar.coreImplModule) == null)) {
                                if (pair.second != null) {
                                    file4 = new File((String) totalLoadedUCM.ucmPackageInfo.coreImplModule.second);
                                    if (create != null) {
                                        create.print("loadedOdexDirFile " + file4, new Throwable[0]);
                                    }
                                    UCCyclone.recursiveDelete(p.a(context, "odexs"), true, file4);
                                    bt btVar2 = totalLoadedUCM.ucmPackageInfo;
                                    file = (btVar2 != null || btVar2.dataDir == null) ? null : new File(totalLoadedUCM.ucmPackageInfo.dataDir);
                                    if (create != null) {
                                        create.print("loadedDataDirFile " + file, new Throwable[0]);
                                    }
                                    a = p.a(context, "decompresses2");
                                    File[] listFiles5 = a.listFiles();
                                    if (listFiles5 != null && listFiles5.length > 0 && ((valueOf.booleanValue() || listFiles5.length >= 2 || (file != null && file.getAbsolutePath().startsWith(a.getAbsolutePath()))) && (listFiles4 = a.listFiles()) != null)) {
                                        for (File file5 : listFiles4) {
                                            if (create != null) {
                                                create.print("decompress delete files " + file5 + AVFSCacheConstants.COMMA_SEP + file, new Throwable[0]);
                                            }
                                            p.a(context, file5, file);
                                        }
                                    }
                                    if (p.a((Boolean) getOption(UCCore.OPTION_DELETE_OLD_DEX_DIR)) && (UCCore.BUSINESS_INIT_BY_NEW_CORE_DEX_DIR.equals((String) getOption(UCCore.OPTION_BUSINESS_INIT_TYPE)) || UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE.equals((String) getOption(UCCore.OPTION_BUSINESS_INIT_TYPE)))) {
                                        file3 = new File((String) getOption(UCCore.OPTION_OLD_DEX_DIR_PATH));
                                        if (!file3.getAbsolutePath().startsWith(a.getAbsolutePath())) {
                                            File file6 = new File((String) getOption(UCCore.OPTION_DECOMPRESS_ROOT_DIR));
                                            if (file3.getAbsolutePath().startsWith(file6.getAbsolutePath())) {
                                                file3 = file6;
                                            }
                                            File[] listFiles6 = file3.listFiles();
                                            if (listFiles6 != null && listFiles6.length > 0 && ((valueOf.booleanValue() || listFiles6.length >= 2 || (file != null && file.getAbsolutePath().startsWith(file3.getAbsolutePath()))) && (listFiles3 = file3.listFiles()) != null)) {
                                                for (File file7 : listFiles3) {
                                                    if (create != null) {
                                                        create.print("prehead init delete files " + file7 + AVFSCacheConstants.COMMA_SEP + file, new Throwable[0]);
                                                    }
                                                    p.a(context, file7, file);
                                                }
                                            }
                                        }
                                    }
                                    File a2 = p.a(context, "repairs");
                                    if (file != null) {
                                        z = true;
                                        file2 = null;
                                    } else {
                                        file2 = file.getParentFile().getParentFile();
                                        z = true;
                                    }
                                    UCCyclone.recursiveDelete(a2, z, file2);
                                    File a3 = p.a(context, "updates");
                                    listFiles = a3.listFiles();
                                    if (listFiles != null && listFiles.length > 0) {
                                        if ((valueOf2.booleanValue() || listFiles.length >= 2 || (file != null && file.getAbsolutePath().startsWith(a3.getAbsolutePath()))) && (listFiles2 = a3.listFiles()) != null) {
                                            for (File file8 : listFiles2) {
                                                if (create != null) {
                                                    create.print("update delete files " + file8 + AVFSCacheConstants.COMMA_SEP + file, new Throwable[0]);
                                                }
                                                p.a(context, file8, file);
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            file4 = null;
                            if (create != null) {
                            }
                            UCCyclone.recursiveDelete(p.a(context, "odexs"), true, file4);
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                        bt btVar22 = totalLoadedUCM.ucmPackageInfo;
                        if (btVar22 != null) {
                        }
                        if (create != null) {
                        }
                        try {
                            a = p.a(context, "decompresses2");
                            File[] listFiles52 = a.listFiles();
                            while (r15 < r14) {
                            }
                            file3 = new File((String) getOption(UCCore.OPTION_OLD_DEX_DIR_PATH));
                            if (!file3.getAbsolutePath().startsWith(a.getAbsolutePath())) {
                            }
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                        try {
                            File a22 = p.a(context, "repairs");
                            if (file != null) {
                            }
                            UCCyclone.recursiveDelete(a22, z, file2);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        try {
                            File a32 = p.a(context, "updates");
                            listFiles = a32.listFiles();
                            if (listFiles != null) {
                            }
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
        }
    }
}
