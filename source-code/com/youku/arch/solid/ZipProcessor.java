package com.youku.arch.solid;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.arch.solid.download.DownloadItem;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.FileUtil;
import com.youku.arch.solid.util.TimeUtil;
import com.youku.arch.solid.util.ZipUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public final class ZipProcessor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "zip";

    private static boolean checkMd5(Map<String, File> map, List<SoInfoWrapper> list, List<SoInfoWrapper> list2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2055009130")) {
            return ((Boolean) ipChange.ipc$dispatch("2055009130", new Object[]{map, list, list2})).booleanValue();
        } else if (list == null || list.isEmpty()) {
            return false;
        } else {
            for (SoInfoWrapper soInfoWrapper : list) {
                File file = map.get(soInfoWrapper.soFileName());
                if (!TextUtils.equals(FileUtil.computeFileMD5(file), soInfoWrapper.md5())) {
                    file.delete();
                    list2.add(soInfoWrapper);
                    SLog.e(TAG, "unzip file check md5 fail: " + soInfoWrapper.soFileName());
                    z = false;
                } else {
                    soInfoWrapper.setLocalFile(file);
                    soInfoWrapper.updateStatus(Status.DOWNLOADED);
                    SLog.d(TAG, "unzip file check md5 success: " + soInfoWrapper.soFileName());
                }
            }
            return z;
        }
    }

    private static void degradeDownload(List<SoInfoWrapper> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978903226")) {
            ipChange.ipc$dispatch("-978903226", new Object[]{list});
        } else if (list != null && !list.isEmpty()) {
            DownloadTask downloadTask = new DownloadTask();
            StringBuilder sb = new StringBuilder();
            for (SoInfoWrapper soInfoWrapper : list) {
                DownloadItem build = new DownloadItem.Builder().setUrl(soInfoWrapper.url()).setMd5(soInfoWrapper.md5()).setPath(Solid.getInstance().getConfig().getLibInstallPath()).setName(soInfoWrapper.soFileName()).setPriority(DownloadTask.Priority.IMPERATIVE).build();
                soInfoWrapper.updateStatus(Status.DOWNLOADING);
                downloadTask.addDownloadItem(build);
                sb.append(soInfoWrapper.soFileName());
                sb.append(";");
            }
            if (downloadTask.getDownloadCount() > 0) {
                Solid.getInstance().doDownload("degradeDownload", false, downloadTask);
                HashMap hashMap = new HashMap();
                SolidMonitor.Params params = SolidMonitor.Params.NEED_DOWNLOAD_COUNT;
                hashMap.put(params, downloadTask.getDownloadCount() + "");
                hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_SO_LIST, sb.toString());
                Solid.getInstance().getMonitor().reportStageResult(SolidMonitor.Stage.SOLID_REQUEST, hashMap);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x011d  */
    public static void unzip(ZipDownloadItem zipDownloadItem, File file) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1592207358")) {
            ipChange.ipc$dispatch("1592207358", new Object[]{zipDownloadItem, file});
        } else if (zipDownloadItem != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (zipDownloadItem instanceof SoGroupWrapper) {
                arrayList2.addAll(((SoGroupWrapper) zipDownloadItem).getSoInfoList());
            } else if (zipDownloadItem instanceof SoInfoWrapper) {
                arrayList2.add((SoInfoWrapper) zipDownloadItem);
            }
            long curTimeStamp = TimeUtil.getCurTimeStamp();
            try {
                Map<String, File> unzipFileByKeyword = ZipUtil.unzipFileByKeyword(file, new File(Solid.getInstance().getConfig().getLibInstallPath()), null);
                long curTimeStamp2 = TimeUtil.getCurTimeStamp() - curTimeStamp;
                file.delete();
                if (unzipFileByKeyword == null || unzipFileByKeyword.isEmpty()) {
                    str = "unzipFile list is empty";
                    SLog.e(TAG, "unzip file fail: " + zipDownloadItem.getZipName() + AVFSCacheConstants.COMMA_SEP + str);
                    HashMap hashMap = new HashMap();
                    hashMap.put(SolidMonitor.Params.LIB_NAME, zipDownloadItem.getZipName());
                    hashMap.put(SolidMonitor.Params.SUCCESS, "0");
                    Solid.getInstance().getMonitor().reportStageResult(SolidMonitor.Stage.SOLID_UNZIP, hashMap);
                    if (arrayList.isEmpty()) {
                        arrayList.addAll(arrayList2);
                    }
                    degradeDownload(arrayList);
                } else if (checkMd5(unzipFileByKeyword, arrayList2, arrayList)) {
                    SLog.e(TAG, "unzip file success: " + zipDownloadItem.getZipName());
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(SolidMonitor.Params.LIB_NAME, zipDownloadItem.getZipName());
                    SolidMonitor.Params params = SolidMonitor.Params.COST_TIME;
                    hashMap2.put(params, curTimeStamp2 + "");
                    hashMap2.put(SolidMonitor.Params.SUCCESS, "1");
                    Solid.getInstance().getMonitor().reportStageResult(SolidMonitor.Stage.SOLID_UNZIP, hashMap2);
                } else {
                    str = "check md5 fail";
                    SLog.e(TAG, "unzip file fail: " + zipDownloadItem.getZipName() + AVFSCacheConstants.COMMA_SEP + str);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(SolidMonitor.Params.LIB_NAME, zipDownloadItem.getZipName());
                    hashMap3.put(SolidMonitor.Params.SUCCESS, "0");
                    Solid.getInstance().getMonitor().reportStageResult(SolidMonitor.Stage.SOLID_UNZIP, hashMap3);
                    if (arrayList.isEmpty()) {
                    }
                    degradeDownload(arrayList);
                }
            } catch (IOException e) {
                e.printStackTrace();
                String message = e.getMessage();
                file.delete();
                str = message;
            } catch (Throwable th) {
                file.delete();
                throw th;
            }
        }
    }
}
