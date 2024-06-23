package com.uc.crashsdk.export;

import com.alibaba.motu.crashreporter2.CrashReporter;

/* compiled from: Taobao */
public class CustomInfo {
    public boolean mAddPvForNewDay = false;
    public int mAnrTraceStrategy = 2;
    public String mAppId = CrashReporter._MAGIC;
    public boolean mAutoDeleteOldVersionStats = true;
    public boolean mAutoDetectLifeCycle = true;
    public boolean mBackupLogs = false;
    public boolean mCallJavaDefaultHandler = true;
    public boolean mCallNativeDefaultHandler = false;
    public String mCrashLogsFolderName = "crashsdk/logs";
    public int mCrashRestartInterval = -1;
    public boolean mDebug = false;
    public long mDisableBackgroundSignals = 16386;
    public long mDisableSignals = 0;
    public boolean mDumpHprofDataForJavaOOM = false;
    public boolean mDumpUserSolibBuildId = true;
    public boolean mEnableLibcMallocDetail = false;
    public boolean mEnableMemoryGroup = false;
    public boolean mEnableStatReport = false;
    public boolean mEncryptLog = true;
    public int mFdDumpMinLimit = 900;
    public int mInfoSaveFrequency = 3;
    public int mInfoUpdateInterval = 50;
    public boolean mIsInternational = false;
    public String mJavaCrashLogFileName = null;
    public String mLibcMallocDetailConfig = null;
    public int mLogMaxBytesLimit = 1048576;
    public int mLogMaxUploadBytesLimit = 819200;
    public String mLogsBackupPathName = null;
    public int mMaxAnrLogCountPerProcess = 3;
    public int mMaxAnrLogcatLineCount = 1000;
    public int mMaxBuiltinLogFilesCount = 20;
    public int mMaxCustomLogCountPerTypePerDay = 6;
    public int mMaxCustomLogFilesCount = 10;
    public int mMaxJavaLogcatLineCount = 1500;
    public int mMaxNativeLogcatLineCount = 3000;
    public int mMaxUnexpLogcatLineCount = 500;
    public int mMaxUploadBuiltinLogCountPerDay = 25;
    public long mMaxUploadBytesPerDay = 1572864;
    public int mMaxUploadCustomLogCountPerDay = 20;
    public boolean mMonitorBattery = true;
    public String mNativeCrashLogFileName = null;
    public boolean mOmitJavaCrash = false;
    public boolean mOmitNativeCrash = false;
    public boolean mPrintStackInfos = false;
    public boolean mRenameFileToDefaultName = false;
    public int mReservedJavaFileHandleCount = 15;
    public int mReservedNativeFileHandleCount = 10;
    public long mReservedNativeMemoryBytes = 3145728;
    public boolean mSyncUploadLogs = true;
    public boolean mSyncUploadSetupCrashLogs = true;
    public String mTagFilesFolderName = "crashsdk/tags";
    public int mThreadsDumpMinLimit = 300;
    public String mUnexpCrashLogFileName = null;
    public int mUnexpDelayMillSeconds = 60000;
    public int mUnexpSubTypes = LogType.UNEXP_KNOWN_REASON;
    public boolean mZipLog = true;
    public String mZippedLogExtension = ".gz";

    public CustomInfo() {
    }

    public CustomInfo(String str) {
        this.mAppId = str;
    }

    public CustomInfo(CustomInfo customInfo) {
        this.mAppId = customInfo.mAppId;
        this.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
        this.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
        this.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
        this.mTagFilesFolderName = customInfo.mTagFilesFolderName;
        this.mCrashLogsFolderName = customInfo.mCrashLogsFolderName;
        this.mLogsBackupPathName = customInfo.mLogsBackupPathName;
        this.mMaxBuiltinLogFilesCount = customInfo.mMaxBuiltinLogFilesCount;
        this.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
        this.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
        this.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
        this.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
        this.mMaxAnrLogcatLineCount = customInfo.mMaxAnrLogcatLineCount;
        this.mUnexpDelayMillSeconds = customInfo.mUnexpDelayMillSeconds;
        this.mUnexpSubTypes = customInfo.mUnexpSubTypes;
        this.mBackupLogs = customInfo.mBackupLogs;
        this.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
        this.mSyncUploadLogs = customInfo.mSyncUploadLogs;
        this.mOmitJavaCrash = customInfo.mOmitJavaCrash;
        this.mOmitNativeCrash = customInfo.mOmitNativeCrash;
        this.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
        this.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
        this.mZipLog = customInfo.mZipLog;
        this.mZippedLogExtension = customInfo.mZippedLogExtension;
        this.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
        this.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
        this.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
        this.mMaxAnrLogCountPerProcess = customInfo.mMaxAnrLogCountPerProcess;
        this.mMaxUploadBuiltinLogCountPerDay = customInfo.mMaxUploadBuiltinLogCountPerDay;
        this.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
        this.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
        this.mCrashRestartInterval = customInfo.mCrashRestartInterval;
        this.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
        this.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
        this.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
        this.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
        this.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
        this.mInfoSaveFrequency = customInfo.mInfoSaveFrequency;
        this.mReservedJavaFileHandleCount = customInfo.mReservedJavaFileHandleCount;
        this.mReservedNativeFileHandleCount = customInfo.mReservedNativeFileHandleCount;
        this.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
        this.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
        this.mReservedNativeMemoryBytes = customInfo.mReservedNativeMemoryBytes;
        this.mDisableSignals = customInfo.mDisableSignals;
        this.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
        this.mEnableStatReport = customInfo.mEnableStatReport;
        this.mIsInternational = customInfo.mIsInternational;
        this.mAutoDetectLifeCycle = customInfo.mAutoDetectLifeCycle;
        this.mMonitorBattery = customInfo.mMonitorBattery;
        this.mAnrTraceStrategy = customInfo.mAnrTraceStrategy;
        this.mPrintStackInfos = customInfo.mPrintStackInfos;
        this.mDebug = customInfo.mDebug;
        this.mEncryptLog = customInfo.mEncryptLog;
        this.mAddPvForNewDay = customInfo.mAddPvForNewDay;
        this.mEnableMemoryGroup = customInfo.mEnableMemoryGroup;
        this.mEnableLibcMallocDetail = customInfo.mEnableLibcMallocDetail;
        this.mLibcMallocDetailConfig = customInfo.mLibcMallocDetailConfig;
    }
}
