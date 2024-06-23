package android.taobao.windvane.packageapp;

import android.app.Application;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppTypeEnum;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.taobao.windvane.util.TaoLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class ZipAppFileManager {
    private static ZipAppFileManager zipAppFileManager;
    private String TAG = "PackageApp-ZipAppFileManager";
    private ZipDegradeDecider mDecider;

    /* compiled from: Taobao */
    public interface ZipDegradeDecider {
        boolean needDegrade();
    }

    private boolean deleteDir(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (File file2 : listFiles) {
                        if (!file2.isDirectory()) {
                            file2.delete();
                        } else if (!str2.equals(file2.getName())) {
                            FileAccesser.deleteFile(file2);
                        }
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getFileAbsolutePath(ZipAppInfo zipAppInfo, boolean z) {
        String str = "";
        if (GlobalConfig.context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(z ? ZipAppConstants.ZIPAPP_ROOT_TMP_DIR : ZipAppConstants.ZIPAPP_ROOT_APPS_DIR);
        if (zipAppInfo.genMidPath(z) != null) {
            str = str2 + zipAppInfo.genMidPath(z);
        }
        sb.append(str);
        return sb.toString();
    }

    public static ZipAppFileManager getInstance() {
        if (zipAppFileManager == null) {
            synchronized (ZipAppFileManager.class) {
                if (zipAppFileManager == null) {
                    zipAppFileManager = new ZipAppFileManager();
                }
            }
        }
        return zipAppFileManager;
    }

    private boolean saveFile(String str, byte[] bArr) {
        try {
            return FileAccesser.write(str, ByteBuffer.wrap(bArr));
        } catch (Exception e) {
            String str2 = this.TAG;
            TaoLog.e(str2, "write file:[" + str + "]  exception:" + e.getMessage());
            return false;
        }
    }

    public boolean clearAppsDir() {
        return FileAccesser.deleteFile(new File(getFileAbsolutePath(null, false, true)), false);
    }

    public boolean clearTmpDir(String str, boolean z) {
        return FileAccesser.deleteFile(new File(getFileAbsolutePath(str, true, true)), z);
    }

    public boolean clearZCacheDir() {
        return FileAccesser.deleteFile(new File(getFileAbsolutePath(null, false, false)), false);
    }

    public boolean copyZipApp(ZipAppInfo zipAppInfo) {
        boolean z = true;
        String zipRootDir = getZipRootDir(zipAppInfo, true);
        String str = zipAppInfo.name + "/" + zipAppInfo.v;
        if (ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP != zipAppInfo.getAppType()) {
            z = false;
        }
        return FileManager.copyDir(zipRootDir, getFileAbsolutePath(str, false, z));
    }

    public boolean createZipAppInitDir() {
        Application application = GlobalConfig.context;
        if (application == null) {
            return false;
        }
        File createFolder = FileManager.createFolder(application, ZipAppConstants.ZIPAPP_ROOT_APPS_DIR);
        String str = this.TAG;
        TaoLog.d(str, "createDir: dir[" + createFolder.getAbsolutePath() + "]:" + createFolder.exists());
        if (!createFolder.exists()) {
            return false;
        }
        File createFolder2 = FileManager.createFolder(GlobalConfig.context, ZipAppConstants.ZIPAPP_ROOT_TMP_DIR);
        String str2 = this.TAG;
        TaoLog.d(str2, "createDir: dir[" + createFolder2.getAbsolutePath() + "]:" + createFolder2.exists());
        return createFolder2.exists();
    }

    public boolean deleteHisZipApp(ZipAppInfo zipAppInfo) {
        return deleteDir(getFileAbsolutePath(zipAppInfo.name, false, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType()), zipAppInfo.v);
    }

    public boolean deleteZipApp(ZipAppInfo zipAppInfo, boolean z) {
        File file = new File(getFileAbsolutePath(zipAppInfo.name, z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType()));
        if (file.exists()) {
            return FileAccesser.deleteFile(file);
        }
        return true;
    }

    public String getDownLoadPath() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_DOWNLOAD__DIR;
    }

    public String getGlobalConfigPath(boolean z) {
        return getFileAbsolutePath(ZipAppConstants.H5_APPS_NAME, z, true);
    }

    public String getNewRootDir(ZipAppInfo zipAppInfo) {
        boolean z = true;
        String genMidPath = zipAppInfo.genMidPath(true);
        if (ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP != zipAppInfo.getAppType()) {
            z = false;
        }
        return getFileAbsolutePath(genMidPath, false, z);
    }

    public String getNewZipResAbsolutePath(ZipAppInfo zipAppInfo, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        sb.append(zipAppInfo.genMidPath(true));
        sb.append(File.separator);
        sb.append(str);
        String sb2 = sb.toString();
        if (ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP != zipAppInfo.getAppType()) {
            z2 = false;
        }
        return getFileAbsolutePath(sb2, z, z2);
    }

    public InputStream getPreloadInputStream(String str) {
        try {
            return GlobalConfig.context.getResources().getAssets().open(str);
        } catch (FileNotFoundException unused) {
            TaoLog.i(this.TAG, "preload package not exists");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String getRootPath() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_ROOT_DIR;
    }

    public String getRootPathApps() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_ROOT_APPS_DIR;
    }

    public String getRootPathTmp() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_ROOT_TMP_DIR;
    }

    public String getZcacheConfigPath(boolean z) {
        return getFileAbsolutePath(ZipAppConstants.H5_ZCACHE_MAP, z, false);
    }

    public String getZipResAbsolutePath(ZipAppInfo zipAppInfo, String str, boolean z) {
        return getFileAbsolutePath(zipAppInfo.genMidPath(z) + File.separator + str, z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType());
    }

    public String getZipRootDir(ZipAppInfo zipAppInfo, boolean z) {
        return getFileAbsolutePath(zipAppInfo.genMidPath(z), z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType());
    }

    public String readFile(String str) {
        try {
            if (!FileAccesser.exists(str)) {
                String str2 = this.TAG;
                TaoLog.i(str2, "file[" + str + "] not found");
                return null;
            }
            byte[] read = FileAccesser.read(str);
            if (read != null) {
                if (read.length >= 1) {
                    return new String(read, ZipAppConstants.DEFAULT_ENCODING);
                }
            }
            String str3 = this.TAG;
            TaoLog.w(str3, "readConfig:[" + str + "] data is null");
            return null;
        } catch (Exception e) {
            String str4 = this.TAG;
            TaoLog.e(str4, "readFile:[" + str + "] exception:" + e.getMessage());
            return null;
        }
    }

    public String readGlobalConfig(boolean z) {
        return readFile(getGlobalConfigPath(z));
    }

    public String readZcacheConfig(boolean z) {
        return readFile(getZcacheConfigPath(z));
    }

    public String readZipAppRes(ZipAppInfo zipAppInfo, String str, boolean z) {
        return readFile(getZipResAbsolutePath(zipAppInfo, str, z));
    }

    public byte[] readZipAppResByte(ZipAppInfo zipAppInfo, String str, boolean z) {
        return FileAccesser.read(getZipResAbsolutePath(zipAppInfo, str, z));
    }

    public synchronized boolean saveGlobalConfig(byte[] bArr, boolean z) {
        return saveFile(getGlobalConfigPath(z), bArr);
    }

    public boolean saveZcacheConfig(byte[] bArr, boolean z) {
        return saveFile(getZcacheConfigPath(z), bArr);
    }

    public boolean saveZipAppRes(ZipAppInfo zipAppInfo, String str, byte[] bArr, boolean z) {
        return saveFile(getZipResAbsolutePath(zipAppInfo, str, z), bArr);
    }

    public void setZipDegradeDecider(ZipDegradeDecider zipDegradeDecider) {
        this.mDecider = zipDegradeDecider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[Catch:{ Exception -> 0x005f }] */
    public String unZipToTmp(ZipAppInfo zipAppInfo, String str) {
        FileAccesser.deleteFile(getZipRootDir(zipAppInfo, true));
        String str2 = "";
        try {
            File file = new File(str);
            ZipDegradeDecider zipDegradeDecider = this.mDecider;
            if (!(zipDegradeDecider != null ? zipDegradeDecider.needDegrade() : false)) {
                if (!WVCommonConfig.commonConfig.needZipDegrade) {
                    file.setReadOnly();
                    str2 = FileManager.unZipByFilePath(str, getZipRootDir(zipAppInfo, true));
                    file.setWritable(true);
                    if (file.exists()) {
                        file.delete();
                        String str3 = this.TAG;
                        TaoLog.d(str3, "Delete temp file:" + str);
                    }
                    return str2;
                }
            }
            if (FileManager.unzip(str, getZipRootDir(zipAppInfo, true))) {
                str2 = "success";
            }
            if (file.exists()) {
            }
        } catch (Exception e) {
            TaoLog.w(this.TAG, "unZipToTemp", e, new Object[0]);
            WVMonitorService.getPackageMonitorInterface().commitFail("UnzipError", WVCommonConfig.commonConfig.needZipDegrade ? -1 : -2, e.getMessage(), zipAppInfo.getZipUrl());
        }
        return str2;
    }

    private String getFileAbsolutePath(String str, boolean z) {
        String str2 = "";
        if (GlobalConfig.context == null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(z ? ZipAppConstants.ZIPAPP_ROOT_TMP_DIR : ZipAppConstants.ZIPAPP_ROOT_APPS_DIR);
        if (str != null) {
            str2 = str3 + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    private String getFileAbsolutePath(String str, boolean z, boolean z2) {
        String str2 = "";
        if (GlobalConfig.context == null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(z ? ZipAppConstants.ZIPAPP_ROOT_TMP_DIR : z2 ? ZipAppConstants.ZIPAPP_ROOT_APPS_DIR : ZipAppConstants.ZIPAPP_ROOT_ZCACHE_DIR);
        if (str != null) {
            str2 = str3 + str;
        }
        sb.append(str2);
        return sb.toString();
    }
}
