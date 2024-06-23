package com.youku.arch.solid;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.edge.pcdn.UniversalDownloader;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.model.SoGroup;
import com.youku.arch.solid.model.SoInfo;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.AbiUtils;
import com.youku.arch.solid.util.FileUtil;
import com.youku.arch.solid.util.LibPathUtil;
import com.youku.arch.solid.util.SoNameConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: Taobao */
public final class SoInfoManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CONFIG_KEY_IS_LOCAL = "isLocal";
    private static final String CONFIG_KEY_SO_GROUPS = "soGroups";
    private static final String SO_INFO_FILE_NAME_32 = "solid-info-armeabi.json";
    private static final String SO_INFO_FILE_NAME_32_v7a = "solid-info-armeabi-v7a.json";
    private static final String SO_INFO_FILE_NAME_64 = "solid-info-arm64-v8a.json";
    private static final String TAG = "SoInfoManager";
    private boolean isLocal = false;
    HashMap<String, SoGroupWrapper> soGroupMap = new HashMap<>();
    HashMap<String, SoInfoWrapper> soInfoMap = new HashMap<>();

    private void checkAndCopyOldSo(final File file) {
        SoInfoWrapper soInfoWithSoName;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1990385677")) {
            ipChange.ipc$dispatch("-1990385677", new Object[]{this, file});
        } else if (file == null || !file.exists()) {
            SLog.e(TAG, "no currentSoDir");
        } else {
            File parentFile = file.getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                SLog.e(TAG, "no parentFile");
                return;
            }
            File[] listFiles = parentFile.listFiles(new FilenameFilter() {
                /* class com.youku.arch.solid.SoInfoManager.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public boolean accept(File file, String str) {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "2093537498")) {
                        return str.startsWith("solid-") && !str.equals(file.getName());
                    }
                    return ((Boolean) ipChange.ipc$dispatch("2093537498", new Object[]{this, file, str})).booleanValue();
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                SLog.e(TAG, "no oldSoDirs");
                return;
            }
            File file2 = listFiles[0];
            if (file2 != null) {
                File[] listFiles2 = file2.listFiles();
                for (File file3 : listFiles2) {
                    if (file3 != null && file3.exists() && (soInfoWithSoName = getSoInfoWithSoName(file3.getName())) != null && TextUtils.equals(FileUtil.computeFileMD5(file3), soInfoWithSoName.md5())) {
                        File file4 = new File(file.getPath() + File.separator + file3.getName());
                        if (file3.renameTo(file4)) {
                            SLog.d(TAG, "copy old so success, new so -> " + file4.getPath());
                        }
                    }
                }
            }
            for (File file5 : listFiles) {
                LibPathUtil.deleteDirectory(file5);
                SLog.d(TAG, "clear oldSoDir");
            }
        }
    }

    private void checkLocalFileAndUpdateStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490168504")) {
            ipChange.ipc$dispatch("-490168504", new Object[]{this});
            return;
        }
        LibPathUtil.deleteDirectory(ensureSolidDirReady(Solid.getInstance().getConfig().getZipPath()));
        File ensureSolidDirReady = ensureSolidDirReady(Solid.getInstance().getConfig().getLibInstallPath());
        checkAndCopyOldSo(ensureSolidDirReady);
        File[] listFiles = ensureSolidDirReady.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    file.delete();
                } else {
                    String name = file.getName();
                    if (name.startsWith(SolidMonitor.CHECK_TYPE_LIB) && name.endsWith(".so")) {
                        SoInfoWrapper soInfoWithSoName = getSoInfoWithSoName(name);
                        if (soInfoWithSoName == null) {
                            file.delete();
                        } else if (TextUtils.equals(FileUtil.computeFileMD5(file), soInfoWithSoName.md5())) {
                            soInfoWithSoName.setLocalFile(file);
                            soInfoWithSoName.updateStatus(Status.DOWNLOADED);
                        } else {
                            file.delete();
                            soInfoWithSoName.updateStatus(Status.WAIT_TO_DOWNLOAD);
                            try {
                                UniversalDownloader.remove(file.getName());
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
        }
    }

    private File ensureSolidDirReady(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431941323")) {
            return (File) ipChange.ipc$dispatch("1431941323", new Object[]{this, str});
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (file.exists() && file.isFile() && !file.delete()) {
            throw new RuntimeException("can't delete solid file.");
        } else if (file.mkdirs()) {
            return file;
        } else {
            throw new RuntimeException("can't create solid dir.");
        }
    }

    private void printSoInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45361220")) {
            ipChange.ipc$dispatch("45361220", new Object[]{this});
            return;
        }
        for (SoGroupWrapper soGroupWrapper : this.soGroupMap.values()) {
            SLog.e("PrintSoGroup", soGroupWrapper.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public SoGroupWrapper getSoGroupWithName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1636673869")) {
            return this.soGroupMap.get(str);
        }
        return (SoGroupWrapper) ipChange.ipc$dispatch("-1636673869", new Object[]{this, str});
    }

    /* access modifiers changed from: package-private */
    public SoInfoWrapper getSoInfoWithSoName(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1750907405")) {
            return this.soInfoMap.get(str);
        }
        return (SoInfoWrapper) ipChange.ipc$dispatch("1750907405", new Object[]{this, str});
    }

    /* access modifiers changed from: package-private */
    public boolean isLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1592858846")) {
            return this.isLocal;
        }
        return ((Boolean) ipChange.ipc$dispatch("1592858846", new Object[]{this})).booleanValue();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:54|55|(2:56|(1:58)(1:103))|59|60|61|62|63|(5:66|(1:68)|69|(5:72|(2:75|73)|105|76|70)|104)|77|(1:79)|80) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:81|82|(0)|99|100|101) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:83|87|88|(2:90|91)|92|93|94) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x012e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x01e7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x01f0 */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e4 A[SYNTHETIC, Splitter:B:90:0x01e4] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ed A[SYNTHETIC, Splitter:B:97:0x01ed] */
    public boolean prepare() {
        boolean z;
        InputStreamReader inputStreamReader;
        boolean z2;
        InputStreamReader inputStreamReader2;
        boolean z3;
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803926408")) {
            return ((Boolean) ipChange.ipc$dispatch("-803926408", new Object[]{this})).booleanValue();
        }
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(Solid.getInstance().getConfig().getApplication().getResources().getAssets().open(SO_INFO_FILE_NAME_64), "UTF-8");
        } catch (IOException e2) {
            SLog.d(TAG, "no 64 solid config");
            if (e2 instanceof FileNotFoundException) {
                inputStreamReader = null;
                z = true;
            } else {
                inputStreamReader = null;
            }
        }
        z = false;
        try {
            inputStreamReader2 = new InputStreamReader(Solid.getInstance().getConfig().getApplication().getResources().getAssets().open(SO_INFO_FILE_NAME_32), "UTF-8");
        } catch (IOException e3) {
            SLog.d(TAG, "no 32 solid config");
            if (e3 instanceof FileNotFoundException) {
                inputStreamReader2 = null;
                z2 = true;
            } else {
                inputStreamReader2 = null;
            }
        }
        z2 = false;
        if (inputStreamReader2 == null) {
            try {
                inputStreamReader2 = new InputStreamReader(Solid.getInstance().getConfig().getApplication().getResources().getAssets().open(SO_INFO_FILE_NAME_32_v7a), "UTF-8");
            } catch (IOException e4) {
                SLog.d(TAG, "no 32_v7a solid config");
                if (e4 instanceof FileNotFoundException) {
                    z3 = true;
                }
            }
        }
        z3 = false;
        if (z && z2 && z3) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.youku.arch.solid.SoInfoManager.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1344861949")) {
                        ipChange.ipc$dispatch("-1344861949", new Object[]{this});
                        return;
                    }
                    throw new RuntimeException("lose solid-info.json");
                }
            });
        }
        if (!(inputStreamReader == null || inputStreamReader2 == null)) {
            SLog.e(TAG, "multiple configs");
            AbiUtils.AbiType abiType = Solid.getInstance().getConfig().getAbiType();
            AbiUtils.AbiType abiType2 = AbiUtils.AbiType.ABI_32;
            if (abiType != abiType2 && (Solid.getInstance().getConfig().getAbiType() == AbiUtils.AbiType.ABI_64 || AbiUtils.getCpuArchValueFromApk() != abiType2)) {
                inputStreamReader2 = null;
            } else {
                inputStreamReader = null;
            }
        }
        if (inputStreamReader != null) {
            SLog.e(TAG, "solid config: 64");
        } else if (inputStreamReader2 != null) {
            SLog.e(TAG, "solid config: 32");
            inputStreamReader = inputStreamReader2;
        } else {
            inputStreamReader = null;
        }
        if (inputStreamReader == null) {
            SLog.e(TAG, "solid init failed: config is empty");
            return false;
        }
        try {
            bufferedReader = new BufferedReader(inputStreamReader);
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                bufferedReader.close();
                inputStreamReader.close();
                if (sb2 != null) {
                    JSONObject parseObject = JSON.parseObject(sb2);
                    Boolean bool = parseObject.getBoolean(CONFIG_KEY_IS_LOCAL);
                    if (bool != null) {
                        this.isLocal = bool.booleanValue();
                    }
                    for (SoGroup soGroup : JSON.parseArray(parseObject.getJSONArray(CONFIG_KEY_SO_GROUPS).toString(), SoGroup.class)) {
                        SoGroupWrapper soGroupWrapper = new SoGroupWrapper(soGroup);
                        for (SoInfo soInfo : soGroup.soItemList) {
                            soInfo.isAutoDownload = soGroup.isAutoDownload;
                            soInfo.priority = soGroup.priority;
                            soInfo.libName = SoNameConverter.parseLibName(soInfo.soName);
                            SoInfoWrapper soInfoWrapper = new SoInfoWrapper(soInfo);
                            soGroupWrapper.linkSoInfo(soInfoWrapper);
                            this.soInfoMap.put(soInfoWrapper.soFileName(), soInfoWrapper);
                        }
                        this.soGroupMap.put(soGroupWrapper.name(), soGroupWrapper);
                    }
                }
                checkLocalFileAndUpdateStatus();
                if (Solid.getInstance().getConfig().isOpenLog()) {
                    printSoInfo();
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                try {
                    SLog.e(TAG, "solid init failed: " + e.getMessage());
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    inputStreamReader.close();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    inputStreamReader.close();
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            SLog.e(TAG, "solid init failed: " + e.getMessage());
            if (bufferedReader != null) {
            }
            inputStreamReader.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            inputStreamReader.close();
            throw th;
        }
    }
}
