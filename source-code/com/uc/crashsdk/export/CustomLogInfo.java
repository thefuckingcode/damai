package com.uc.crashsdk.export;

import java.util.ArrayList;

/* compiled from: Taobao */
public class CustomLogInfo {
    public boolean mAddBuildId = false;
    public boolean mAddFooter = true;
    public boolean mAddHeader = true;
    public boolean mAddLogcat = false;
    public boolean mAddThreadsDump = false;
    public ArrayList<String> mCachedInfos = null;
    public ArrayList<String> mCallbacks = null;
    public StringBuffer mData;
    public ArrayList<String> mDumpFiles = null;
    public ArrayList<Integer> mDumpTids = null;
    public String mLogType;
    public boolean mUploadNow = false;

    public CustomLogInfo(StringBuffer stringBuffer, String str) {
        this.mData = stringBuffer;
        this.mLogType = str;
    }

    public CustomLogInfo(CustomLogInfo customLogInfo) {
        this.mData = customLogInfo.mData;
        this.mLogType = customLogInfo.mLogType;
        this.mAddHeader = customLogInfo.mAddHeader;
        this.mAddFooter = customLogInfo.mAddFooter;
        this.mAddLogcat = customLogInfo.mAddLogcat;
        this.mUploadNow = customLogInfo.mUploadNow;
        this.mAddThreadsDump = customLogInfo.mAddThreadsDump;
        this.mAddBuildId = customLogInfo.mAddBuildId;
        if (customLogInfo.mDumpFiles != null) {
            this.mDumpFiles = new ArrayList<>(customLogInfo.mDumpFiles);
        }
        if (customLogInfo.mCallbacks != null) {
            this.mCallbacks = new ArrayList<>(customLogInfo.mCallbacks);
        }
        if (customLogInfo.mCachedInfos != null) {
            this.mCachedInfos = new ArrayList<>(customLogInfo.mCachedInfos);
        }
        if (customLogInfo.mDumpTids != null) {
            this.mDumpTids = new ArrayList<>(customLogInfo.mDumpTids);
        }
    }
}
