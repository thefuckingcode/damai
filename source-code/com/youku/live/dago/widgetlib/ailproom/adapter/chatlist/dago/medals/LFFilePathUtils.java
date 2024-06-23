package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.ali.user.open.core.Site;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
public class LFFilePathUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ACTIVE_MEDAL_FILE_NAME = "ActiveMedal";
    private static final String ACTIVE_MEDAL_SIGN_FILE_NAME = "ActiveMedalSign";
    private static final String ALL_MEDAL_FILE_NAME = "AllMedal";
    private static final String ALL_MEDAL_SIGN_FILE_NAME = "AllMedalSign";
    private static final String ANCHOR_REPORT_SET_NAME = "AnchorReport";
    private static String CustomMainDirName = null;
    private static final String ENTER_EFFECTES_FILE_NAME = "EnterEffects";
    private static final String EnterEffect_DIR_NAME = "EnterEffect";
    private static final String FANS_WALL_DIR_NAME = "fans_wall";
    private static final String FANS_WALL_SHOW_DIR_NAME = "LaifengShow";
    private static final String GIFTS_DIR_NAME = "gifts";
    private static final String GIFT_RESOURCES_NAME = "Resources";
    private static final String GIFT_ZIP_RESOURCES_NAME = "ZipResources";
    private static final String GOLD_MASTER_MEDAL_FILE_NAME = "GoldMasterMedal";
    private static final String GOLD_MASTER_MEDAL_SIGN_FILE_NAME = "GoldMasterMedalSign";
    private static final String HEAD_DIR_NAME = "head";
    private static final String IMAGE_DIR_NAME = "image";
    private static final String LAIFENG_LOG_DIR_NAME = "LaifengLog";
    private static final String LEVEL_NAME = "levelSource";
    private static final String MEDAL_DIR_NAME = "Medal2";
    public static final String PATH_SD_CARD = AppContextUtils.getApp().getFilesDir().getAbsolutePath();
    private static final String PRAISE_DIR_NAME = "praise";
    private static final String PRIZE_DIR_NAME = "prize";
    private static final String REPLAY_IM_FILE_NAME = "ReplayFiles";
    private static final String SCREEN_SHOT_DIR_NAME = "screenShot";
    private static final String SDPATH_SIGNGOLD = "download";
    private static final String SKIN_DIR_NAME = "skin";
    private static final String SOPCAST_DIR_NAME = "sopcast";
    private static final String SPLASH_DIR_NAME = "splash";
    private static final String SPLASH_SET_NAME = "advert";
    private static final String TAG = "LFFilePathUtils";
    private static final String UGCCOMPRESS_RESOURCES_NAME = "UgcCompressFile";
    private static final String UPDATE_DIR_NAME = "update";
    private static LFFilePathUtils mInstance = null;
    private static final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private static String mLogFileName = null;
    private static final Object mMutex = new Object();
    private static String mSDParentPath = Site.LAIFENG_NEW;
    private String CustomAnchorReportDir = null;
    private String CustomAnchorReportDirName = null;
    private String CustomFansWallDirName = null;
    private String CustomGiftResourcesDir = null;
    private String CustomGiftResourcesDirName = null;
    private String CustomGiftZipResourcesDir = null;
    private String CustomGiftZipResourcesDirName = null;
    private String CustomGiftsDir = null;
    private String CustomGiftsDirName = null;
    private String CustomHeadDir = null;
    private String CustomHeadDirName = null;
    private String CustomImageDir = null;
    private String CustomImageDirName = null;
    private String CustomLevelResourcesDir = null;
    private String CustomLevelResourcesDirName = null;
    private String CustomLogDir = null;
    private String CustomLogDirName = null;
    private String CustomMainDir = null;
    private String CustomPKThemeResource = null;
    private String CustomPkThemeResourceDir = null;
    private String CustomPrizeDir = null;
    private String CustomPrizeDirName = null;
    private String CustomReplayImDir = null;
    private String CustomSplashDirName = null;
    private String CustomSplashsDir = null;
    private String CustomUGCCompressResourcesDir = null;
    private String CustomUGCCompressResourcesDirName = null;
    private String CustomUpdateDir = null;
    private String CustomUpdateDirName = null;
    private String KEY_GIFT_CONFIG_DATA = "gift_config_data";
    private String KEY_GIFT_CONFIG_SIGN = "gift_config_sign";
    private String KEY_GIFT_SIGN = "gift_sign";
    private String KEY_RED_PACK_CONFIG_DATA = "red_pack_config_data";
    private String KEY_RED_PACK_CONFIG_SIGN = "red_pack_config_sign";
    private String KEY_RED_PACK_SIGN = "red_pack_sign";
    private String PK_THEME_RESOURCE = "pk_theme_resource";

    private LFFilePathUtils() {
    }

    public static void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431772125")) {
            ipChange.ipc$dispatch("-431772125", new Object[0]);
            return;
        }
        try {
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("data", 0);
            openFileOutput.write("".getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized String getActiveMasterMedalJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "179697558")) {
                return (String) ipChange.ipc$dispatch("179697558", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), ACTIVE_MEDAL_FILE_NAME));
        }
    }

    public static synchronized String getAllMedalJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1079561119")) {
                return (String) ipChange.ipc$dispatch("1079561119", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), ALL_MEDAL_FILE_NAME));
        }
    }

    private static Context getApplicationContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1020423485") ? (Context) ipChange.ipc$dispatch("1020423485", new Object[0]) : AppContextUtils.getApp();
    }

    public static File getCameraPhotoFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190621040")) {
            return (File) ipChange.ipc$dispatch("-1190621040", new Object[0]);
        }
        File file = new File(getFansWallShowDirName());
        return new File(file, "lf_photo_" + System.currentTimeMillis() + ".jpg");
    }

    public static synchronized String getEnterEffectsJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-518921389")) {
                return (String) ipChange.ipc$dispatch("-518921389", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(EnterEffect_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), ENTER_EFFECTES_FILE_NAME));
        }
    }

    public static int getExifOrientation(String str) {
        int attributeInt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693535485")) {
            return ((Integer) ipChange.ipc$dispatch("-1693535485", new Object[]{str})).intValue();
        }
        ExifInterface exifInterface = null;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) == -1) {
            return 0;
        }
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt == 6) {
            return 90;
        }
        if (attributeInt != 8) {
            return 0;
        }
        return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
    }

    public static synchronized String getFansWallShowDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1099881237")) {
                return (String) ipChange.ipc$dispatch("-1099881237", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append(FANS_WALL_SHOW_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getGoldMasterMedalJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "305045564")) {
                return (String) ipChange.ipc$dispatch("305045564", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), GOLD_MASTER_MEDAL_FILE_NAME));
        }
    }

    public static String getHistory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245001842")) {
            return (String) ipChange.ipc$dispatch("-245001842", new Object[0]);
        }
        try {
            FileInputStream openFileInput = getApplicationContext().openFileInput("history");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static LFFilePathUtils getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227001971")) {
            return (LFFilePathUtils) ipChange.ipc$dispatch("-1227001971", new Object[0]);
        }
        if (mInstance == null) {
            synchronized (mMutex) {
                if (mInstance == null) {
                    mInstance = new LFFilePathUtils();
                }
            }
        }
        return mInstance;
    }

    private synchronized String getLevelResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978791349")) {
            return (String) ipChange.ipc$dispatch("-1978791349", new Object[]{this});
        }
        if (this.CustomLevelResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + LEVEL_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomLevelResourcesDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomLevelResourcesDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomLevelResourcesDir = path2;
        return path2;
    }

    private synchronized String getLogDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95490646")) {
            return (String) ipChange.ipc$dispatch("-95490646", new Object[]{this});
        }
        if (this.CustomLogDirName == null) {
            file = new File(getMainDirPath(), LAIFENG_LOG_DIR_NAME);
        } else {
            file = new File(getMainDirPath(), this.CustomLogDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomLogDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomLogDir = path2;
        return path2;
    }

    public static synchronized String getMedalSignDataFromSd(int i) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2012257110")) {
                return (String) ipChange.ipc$dispatch("-2012257110", new Object[]{Integer.valueOf(i)});
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            String str = i == 1 ? GOLD_MASTER_MEDAL_SIGN_FILE_NAME : i == 2 ? ACTIVE_MEDAL_SIGN_FILE_NAME : ALL_MEDAL_SIGN_FILE_NAME;
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(CustomMainDirName);
            sb.append(str2);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), str));
        }
    }

    public static final int getOrientationFromContentUri(ContentResolver contentResolver, Uri uri) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1382965435")) {
            return ((Integer) ipChange.ipc$dispatch("1382965435", new Object[]{contentResolver, uri})).intValue();
        } else if ("content".equals(uri.getScheme())) {
            Cursor query = contentResolver.query(uri, new String[]{"orientation"}, null, null, null);
            if (query == null) {
                return 0;
            }
            if (query.moveToFirst()) {
                i = query.getInt(query.getColumnIndexOrThrow("orientation"));
            }
            query.close();
            return i;
        } else if ("file".equals(uri.getScheme())) {
            return getExifOrientation(uri.getPath());
        } else {
            return 0;
        }
    }

    public static String getPath(Activity activity, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154397718")) {
            return (String) ipChange.ipc$dispatch("-154397718", new Object[]{activity, uri});
        }
        Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        activity.startManagingCursor(managedQuery);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        String string = managedQuery.getString(columnIndexOrThrow);
        try {
            managedQuery.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }

    public static synchronized String getPraiseDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-178444970")) {
                return (String) ipChange.ipc$dispatch("-178444970", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append("praise");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getScreenShotDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1773317236")) {
                return (String) ipChange.ipc$dispatch("-1773317236", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append(SCREEN_SHOT_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getSignGoldDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493369675")) {
                return (String) ipChange.ipc$dispatch("-493369675", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append("download");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getSkinDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1172773771")) {
                return (String) ipChange.ipc$dispatch("-1172773771", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append("skin");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getSopcastDirPath() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1134682171")) {
                return (String) ipChange.ipc$dispatch("1134682171", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append(SOPCAST_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[SYNTHETIC, Splitter:B:31:0x0087] */
    public static String loadAnchorReportJsonDataFromSd(String str, String str2) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1463777848")) {
            return (String) ipChange.ipc$dispatch("1463777848", new Object[]{str, str2});
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer("");
        File file2 = new File(file.getAbsolutePath(), "AnchorReport_" + str2);
        if (file2.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Exception e5) {
                bufferedReader = null;
                e = e5;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                return stringBuffer.toString();
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[SYNTHETIC, Splitter:B:31:0x0074] */
    public static String readAdvertJsonDataFromSd(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095589315")) {
            return (String) ipChange.ipc$dispatch("-2095589315", new Object[]{str});
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer("");
        File file2 = new File(file.getAbsolutePath(), SPLASH_SET_NAME);
        if (file2.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Exception e5) {
                bufferedReader = null;
                e = e5;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                return stringBuffer.toString();
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        }
        return stringBuffer.toString();
    }

    public static String[] readData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447481185")) {
            return (String[]) ipChange.ipc$dispatch("-447481185", new Object[0]);
        }
        try {
            FileInputStream openFileInput = getApplicationContext().openFileInput("data");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray()).split(",");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String[] readkey() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594003520")) {
            return (String[]) ipChange.ipc$dispatch("594003520", new Object[]{this});
        }
        String[] strArr = null;
        try {
            mLock.readLock().lock();
            if (getApplicationContext().getFileStreamPath("key").exists()) {
                fileInputStream = getApplicationContext().openFileInput("key");
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    try {
                        e.printStackTrace();
                        FileUtils.closeQuietly(fileInputStream);
                        FileUtils.closeQuietly(byteArrayOutputStream);
                        mLock.readLock().unlock();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        FileUtils.closeQuietly(fileInputStream);
                        FileUtils.closeQuietly(byteArrayOutputStream);
                        mLock.readLock().unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    FileUtils.closeQuietly(fileInputStream);
                    FileUtils.closeQuietly(byteArrayOutputStream);
                    mLock.readLock().unlock();
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    strArr = new String(byteArrayOutputStream.toByteArray()).split(",");
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    FileUtils.closeQuietly(fileInputStream);
                    FileUtils.closeQuietly(byteArrayOutputStream);
                    mLock.readLock().unlock();
                    return null;
                }
            } else {
                fileInputStream = null;
                byteArrayOutputStream = null;
            }
            FileUtils.closeQuietly(fileInputStream);
            FileUtils.closeQuietly(byteArrayOutputStream);
            mLock.readLock().unlock();
            return strArr;
        } catch (IOException e4) {
            e = e4;
            fileInputStream = null;
            byteArrayOutputStream = null;
            e.printStackTrace();
            FileUtils.closeQuietly(fileInputStream);
            FileUtils.closeQuietly(byteArrayOutputStream);
            mLock.readLock().unlock();
            return null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            fileInputStream = null;
            FileUtils.closeQuietly(fileInputStream);
            FileUtils.closeQuietly(byteArrayOutputStream);
            mLock.readLock().unlock();
            throw th;
        }
    }

    public static synchronized boolean saveActiveMedalJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "106170998")) {
                return ((Boolean) ipChange.ipc$dispatch("106170998", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), ACTIVE_MEDAL_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static boolean saveAdvertJsonDataToSd(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179851737")) {
            return ((Boolean) ipChange.ipc$dispatch("1179851737", new Object[]{str, str2})).booleanValue();
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        } else {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getAbsolutePath(), SPLASH_SET_NAME), false);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(str2.getBytes());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileOutputStream.close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public static synchronized boolean saveAllMedalJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1207426445")) {
                return ((Boolean) ipChange.ipc$dispatch("1207426445", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), ALL_MEDAL_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static boolean saveAnchorReportJsonDataToSd(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251429234")) {
            return ((Boolean) ipChange.ipc$dispatch("-1251429234", new Object[]{str, str2, str3})).booleanValue();
        } else if (TextUtils.isEmpty(str3)) {
            return false;
        } else {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = file.getAbsolutePath();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(absolutePath, "AnchorReport_" + str2), false);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(str3.getBytes());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileOutputStream.close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public static synchronized boolean saveEnterEffectsJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1986600999")) {
                return ((Boolean) ipChange.ipc$dispatch("-1986600999", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(EnterEffect_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), ENTER_EFFECTES_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static synchronized boolean saveGoldMasterMedalJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-856939438")) {
                return ((Boolean) ipChange.ipc$dispatch("-856939438", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), GOLD_MASTER_MEDAL_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static synchronized boolean saveMedalSignDataToSd(String str, int i) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1848016208")) {
                return ((Boolean) ipChange.ipc$dispatch("1848016208", new Object[]{str, Integer.valueOf(i)})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), i == 1 ? GOLD_MASTER_MEDAL_SIGN_FILE_NAME : i == 2 ? ACTIVE_MEDAL_SIGN_FILE_NAME : ALL_MEDAL_SIGN_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static void updateHistory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396453689")) {
            ipChange.ipc$dispatch("396453689", new Object[]{str});
            return;
        }
        try {
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("history", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void writeData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825216419")) {
            ipChange.ipc$dispatch("825216419", new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21});
            return;
        }
        try {
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("data", 0);
            openFileOutput.write((str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6 + "," + str7 + "," + str8 + "," + str9 + "," + str10 + "," + str11 + "," + str12 + "," + str13 + "," + str14 + "," + str15 + "," + str16 + "," + str17 + "," + str18 + "," + str19 + "," + str20 + "," + str21).getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String UriToPath(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156262745")) {
            return (String) ipChange.ipc$dispatch("-156262745", new Object[]{this, uri});
        }
        Cursor query = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
        String str = "";
        if (query != null) {
            query.moveToFirst();
            str = query.getString(1);
            query.close();
        }
        return str;
    }

    public synchronized void createSZLMFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511535056")) {
            ipChange.ipc$dispatch("-511535056", new Object[]{this});
            return;
        }
        try {
            new File(getMainDirPath() + File.separator + "szlm.txt").createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized String getAnchorReportDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168952893")) {
            return (String) ipChange.ipc$dispatch("-168952893", new Object[]{this});
        }
        if (this.CustomAnchorReportDirName == null) {
            file = new File(getMainDirPath() + File.separator + ANCHOR_REPORT_SET_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomAnchorReportDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomAnchorReportDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomAnchorReportDir = path2;
        return path2;
    }

    public synchronized String getAnchorlevelDirPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348633825")) {
            return (String) ipChange.ipc$dispatch("-1348633825", new Object[]{this});
        }
        File file = new File(getLevelResourcesDirPath() + File.separator + "AnchorLevel");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public synchronized String getClientInfoFile() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "474675569")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("474675569", new Object[]{this});
    }

    public String getCustomPrizeDir() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-38311576")) {
            return this.CustomPrizeDir;
        }
        return (String) ipChange.ipc$dispatch("-38311576", new Object[]{this});
    }

    public String getCustomPrizeDirName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1058652653")) {
            return this.CustomPrizeDirName;
        }
        return (String) ipChange.ipc$dispatch("-1058652653", new Object[]{this});
    }

    public String getCustomSplashDirName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1142250278")) {
            return this.CustomSplashDirName;
        }
        return (String) ipChange.ipc$dispatch("-1142250278", new Object[]{this});
    }

    public String getCustomSplashsDir() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "179891406")) {
            return this.CustomSplashsDir;
        }
        return (String) ipChange.ipc$dispatch("179891406", new Object[]{this});
    }

    public synchronized String getFansWallDirPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904787778")) {
            return (String) ipChange.ipc$dispatch("1904787778", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_SD_CARD);
        String str = File.separator;
        sb.append(str);
        sb.append(mSDParentPath);
        sb.append(str);
        sb.append(FANS_WALL_DIR_NAME);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public synchronized String getGiftResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698713543")) {
            return (String) ipChange.ipc$dispatch("-698713543", new Object[]{this});
        }
        if (this.CustomGiftResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + GIFT_RESOURCES_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomGiftResourcesDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomGiftResourcesDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomGiftResourcesDir = path2;
        return path2;
    }

    public synchronized String getGiftZipResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39007320")) {
            return (String) ipChange.ipc$dispatch("39007320", new Object[]{this});
        }
        if (this.CustomGiftZipResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + GIFT_ZIP_RESOURCES_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomGiftZipResourcesDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomGiftZipResourcesDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomGiftZipResourcesDir = path2;
        return path2;
    }

    public synchronized String getGiftsDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646250997")) {
            return (String) ipChange.ipc$dispatch("-1646250997", new Object[]{this});
        }
        if (this.CustomGiftsDirName == null) {
            file = new File(getMainDirPath(), GIFTS_DIR_NAME);
        } else {
            file = new File(getMainDirPath(), this.CustomGiftsDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomGiftsDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomGiftsDir = path2;
        return path2;
    }

    public synchronized String getHeadDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388436276")) {
            return (String) ipChange.ipc$dispatch("-388436276", new Object[]{this});
        }
        if (this.CustomHeadDirName == null) {
            file = new File(getMainDirPath() + File.separator + HEAD_DIR_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomHeadDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomHeadDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomHeadDir = path2;
        return path2;
    }

    public synchronized String getImageDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173915405")) {
            return (String) ipChange.ipc$dispatch("-1173915405", new Object[]{this});
        }
        if (this.CustomImageDirName == null) {
            file = new File(getMainDirPath() + File.separator + "image");
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomImageDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomImageDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomImageDir = path2;
        return path2;
    }

    public synchronized String getLogFilePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704280545")) {
            return (String) ipChange.ipc$dispatch("-1704280545", new Object[]{this});
        }
        if (TextUtils.isEmpty(mLogFileName)) {
            String logDirPath = getLogDirPath();
            mLogFileName = new File(logDirPath, "log_" + System.currentTimeMillis() + ".txt").getAbsolutePath();
        }
        return mLogFileName;
    }

    public synchronized String getMainDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "22779731")) {
            return (String) ipChange.ipc$dispatch("22779731", new Object[]{this});
        }
        if (CustomMainDirName == null) {
            file = new File(PATH_SD_CARD + File.separator + mSDParentPath);
        } else {
            file = new File(PATH_SD_CARD + File.separator + CustomMainDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomMainDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomMainDir = path2;
        return path2;
    }

    public synchronized String getPkThemeresourcePath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708674341")) {
            return (String) ipChange.ipc$dispatch("-1708674341", new Object[]{this});
        }
        if (this.CustomPKThemeResource == null) {
            file = new File(getMainDirPath() + File.separator + this.PK_THEME_RESOURCE);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomPKThemeResource);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomPkThemeResourceDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomPkThemeResourceDir = path2;
        return path2;
    }

    public synchronized String getPrizeDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-231181348")) {
            return (String) ipChange.ipc$dispatch("-231181348", new Object[]{this});
        }
        if (this.CustomPrizeDirName == null) {
            file = new File(getMainDirPath() + File.separator + PRIZE_DIR_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomPrizeDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomPrizeDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomPrizeDir = path2;
        return path2;
    }

    public synchronized String getReplayFilesPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654504305")) {
            return (String) ipChange.ipc$dispatch("-654504305", new Object[]{this});
        }
        String str = REPLAY_IM_FILE_NAME;
        if (!TextUtils.isEmpty(this.CustomReplayImDir)) {
            str = this.CustomReplayImDir;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_SD_CARD);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(mSDParentPath);
        sb.append(str2);
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public String getSecretKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797906103")) {
            return (String) ipChange.ipc$dispatch("-797906103", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[0];
    }

    public synchronized String getSplashDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586660315")) {
            return (String) ipChange.ipc$dispatch("-586660315", new Object[]{this});
        }
        if (this.CustomSplashDirName == null) {
            file = new File(getMainDirPath() + File.separator + SPLASH_DIR_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomSplashDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomSplashsDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomSplashsDir = path2;
        return path2;
    }

    public String getThirdLoginType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49188776")) {
            return (String) ipChange.ipc$dispatch("-49188776", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[2];
    }

    public String getToken() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875577907")) {
            return (String) ipChange.ipc$dispatch("875577907", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[1];
    }

    public synchronized String getUGCCompressResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156223642")) {
            return (String) ipChange.ipc$dispatch("1156223642", new Object[]{this});
        }
        if (this.CustomUGCCompressResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + UGCCOMPRESS_RESOURCES_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomUGCCompressResourcesDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomUGCCompressResourcesDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomUGCCompressResourcesDir = path2;
        return path2;
    }

    public synchronized String getUpdateDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008135037")) {
            return (String) ipChange.ipc$dispatch("-2008135037", new Object[]{this});
        }
        if (this.CustomUpdateDirName == null) {
            file = new File(getMainDirPath() + File.separator + "update");
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomUpdateDirName);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            String path = file.getPath();
            this.CustomUpdateDir = path;
            return path;
        }
        String path2 = file.getPath();
        this.CustomUpdateDir = path2;
        return path2;
    }

    public synchronized String getUserlevelDirPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37292939")) {
            return (String) ipChange.ipc$dispatch("-37292939", new Object[]{this});
        }
        File file = new File(getLevelResourcesDirPath() + File.separator + "UserLevel");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public String getYKTK() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271505253")) {
            return (String) ipChange.ipc$dispatch("1271505253", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[3];
    }

    public synchronized boolean isSZLMFileExist() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1257035755")) {
            return ((Boolean) ipChange.ipc$dispatch("-1257035755", new Object[]{this})).booleanValue();
        }
        try {
            File file = new File(getMainDirPath(), "szlm.txt");
            if (!file.exists() || file.isDirectory()) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized String readGiftConfigSign() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894900395")) {
            return (String) ipChange.ipc$dispatch("-894900395", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "GiftSign.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized String readGiftData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142308448")) {
            return (String) ipChange.ipc$dispatch("-142308448", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "GiftConfig.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized String readRedPackConfigSign() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031232985")) {
            return (String) ipChange.ipc$dispatch("1031232985", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "RedPackSign.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized String readRedPackData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778332964")) {
            return (String) ipChange.ipc$dispatch("1778332964", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "RedPackConfig.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized void saveGiftConfigSign(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081512338")) {
            ipChange.ipc$dispatch("-2081512338", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "GiftSign.json"), str);
    }

    public synchronized void saveGiftData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297528765")) {
            ipChange.ipc$dispatch("-1297528765", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "GiftConfig.json"), str);
    }

    public synchronized void saveRedPackConfigSign(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644928936")) {
            ipChange.ipc$dispatch("-644928936", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "RedPackSign.json"), str);
    }

    public synchronized void saveRedPackData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722008659")) {
            ipChange.ipc$dispatch("-722008659", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "RedPackConfig.json"), str);
    }

    public void setCustomAnchorReportDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12109374")) {
            ipChange.ipc$dispatch("12109374", new Object[]{this, str});
            return;
        }
        this.CustomAnchorReportDirName = str;
    }

    public void setCustomGiftsDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582013404")) {
            ipChange.ipc$dispatch("582013404", new Object[]{this, str});
            return;
        }
        this.CustomGiftsDirName = str;
    }

    public void setCustomHeadDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700684117")) {
            ipChange.ipc$dispatch("1700684117", new Object[]{this, str});
            return;
        }
        this.CustomHeadDirName = str;
    }

    public void setCustomImageDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955452428")) {
            ipChange.ipc$dispatch("-1955452428", new Object[]{this, str});
            return;
        }
        this.CustomImageDirName = str;
    }

    public void setCustomLevelResourcesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493648522")) {
            ipChange.ipc$dispatch("-493648522", new Object[]{this, str});
            return;
        }
        this.CustomLevelResourcesDirName = str;
    }

    public void setCustomMainDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563478446")) {
            ipChange.ipc$dispatch("1563478446", new Object[]{this, str});
            return;
        }
        CustomMainDirName = str;
    }

    public void setCustomPrizeDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304765578")) {
            ipChange.ipc$dispatch("-304765578", new Object[]{this, str});
            return;
        }
        this.CustomPrizeDir = str;
    }

    public void setCustomPrizeDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499499563")) {
            ipChange.ipc$dispatch("1499499563", new Object[]{this, str});
            return;
        }
        this.CustomPrizeDirName = str;
    }

    public void setCustomReplayFilesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752595561")) {
            ipChange.ipc$dispatch("1752595561", new Object[]{this, str});
            return;
        }
        this.CustomReplayImDir = str;
    }

    public void setCustomSplashDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624669148")) {
            ipChange.ipc$dispatch("624669148", new Object[]{this, str});
            return;
        }
        this.CustomSplashDirName = str;
    }

    public void setCustomSplashsDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109871568")) {
            ipChange.ipc$dispatch("109871568", new Object[]{this, str});
            return;
        }
        this.CustomSplashsDir = str;
    }

    public void setCustomUpdateDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491374274")) {
            ipChange.ipc$dispatch("-491374274", new Object[]{this, str});
            return;
        }
        this.CustomUpdateDirName = str;
    }

    public void setGiftResourcesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427642143")) {
            ipChange.ipc$dispatch("427642143", new Object[]{this, str});
            return;
        }
        this.CustomGiftResourcesDirName = str;
    }

    public void setGiftZipResourcesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884952712")) {
            ipChange.ipc$dispatch("-884952712", new Object[]{this, str});
            return;
        }
        this.CustomGiftZipResourcesDirName = str;
    }

    public void writekey(String str, String str2, String str3, int i) {
        Lock lock;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172102101")) {
            ipChange.ipc$dispatch("1172102101", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        try {
            ReadWriteLock readWriteLock = mLock;
            readWriteLock.writeLock().lock();
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("key", 0);
            if (str3 == null || str3.isEmpty()) {
                str3 = "";
            }
            openFileOutput.write((str + "," + str2 + "," + i + "," + str3).getBytes());
            openFileOutput.close();
            lock = readWriteLock.writeLock();
        } catch (IOException e) {
            e.printStackTrace();
            lock = mLock.writeLock();
        } catch (Throwable th) {
            mLock.writeLock().unlock();
            throw th;
        }
        lock.unlock();
    }
}
