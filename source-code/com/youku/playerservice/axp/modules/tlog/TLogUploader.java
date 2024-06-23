package com.youku.playerservice.axp.modules.tlog;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.uploader.service.TLogFileUploader;
import com.taobao.tao.log.uploader.service.TLogFileUploaderCallBack;
import com.taobao.tao.log.uploader.service.TLogUploadFileModel;
import com.taobao.tao.log.uploader.service.TLogUploadMsg;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.ZipUtil;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class TLogUploader {
    public static final String TAG = "TlogUploader";
    private Context mContext;

    public TLogUploader(final Context context) {
        this.mContext = context;
        TLogInitializer.getInstance().setTLogUserDefineUploader("taobao_video_zip_21646297", new TLogFileUploader() {
            /* class com.youku.playerservice.axp.modules.tlog.TLogUploader.AnonymousClass1 */

            public void executeUploadTask(TLogUploadMsg tLogUploadMsg, TLogFileUploaderCallBack tLogFileUploaderCallBack) {
                String str;
                StringBuilder sb;
                try {
                    Map<String, String> map = tLogUploadMsg.extInfo;
                    if (map == null || map.size() <= 0 || !map.containsKey("filePath")) {
                        TLogUtil.loge(TLogUploader.TAG, "开始upload");
                        String absolutePath = context.getApplicationContext().getExternalCacheDir().getAbsolutePath();
                        File file = new File(absolutePath + "/dumpVideo");
                        File file2 = new File(absolutePath + "/dumpVideo.zip");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (file.exists() && file.isDirectory()) {
                            ZipUtil.zipFolder(file.getAbsolutePath(), file2.getAbsolutePath());
                            if (file2.exists()) {
                                TLogUploadFileModel tLogUploadFileModel = new TLogUploadFileModel();
                                tLogUploadFileModel.bizCode = getBizCode();
                                tLogUploadFileModel.filePath = file2.getAbsolutePath();
                                tLogUploadFileModel.extraInfos = new HashMap();
                                boolean booleanValue = tLogFileUploaderCallBack.onFileUpload(tLogUploadFileModel).booleanValue();
                                if (booleanValue) {
                                    ZipUtil.delete(file);
                                }
                                sb = new StringBuilder();
                                sb.append("executeUploadTask ");
                                sb.append(booleanValue);
                            } else {
                                str = "没有压缩成功";
                                TLogUtil.loge(TLogUploader.TAG, str);
                            }
                        } else {
                            return;
                        }
                    } else {
                        TLogUtil.loge(TLogUploader.TAG, "开始upload自定义文件");
                        File file3 = new File(map.get("filePath"));
                        if (!file3.isFile() || !file3.exists()) {
                            str = "文件不存在";
                            TLogUtil.loge(TLogUploader.TAG, str);
                        }
                        TLogUploadFileModel tLogUploadFileModel2 = new TLogUploadFileModel();
                        tLogUploadFileModel2.bizCode = getBizCode();
                        tLogUploadFileModel2.filePath = file3.getAbsolutePath();
                        tLogUploadFileModel2.extraInfos = new HashMap();
                        boolean booleanValue2 = tLogFileUploaderCallBack.onFileUpload(tLogUploadFileModel2).booleanValue();
                        sb = new StringBuilder();
                        sb.append("executeUploadTask ");
                        sb.append(booleanValue2);
                    }
                    str = sb.toString();
                    TLogUtil.loge(TLogUploader.TAG, str);
                } catch (Exception unused) {
                    TLogUtil.loge(TLogUploader.TAG, "executeUploadTask fail");
                }
            }

            @Override // com.taobao.tao.log.uploader.service.TLogFileUploader
            public String getBizCode() {
                return "taobao_video_zip_21646297";
            }
        });
    }

    private long getMaxSize() {
        String config = ConfigFetcher.getInstance().getConfig("player_strategy", "enable_max_dump_size", "30");
        if (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) {
            return 31457280;
        }
        return Long.valueOf(config).longValue() * 1024 * 1024;
    }

    public void cleanOldData(String str) {
        try {
            File file = new File(this.mContext.getApplicationContext().getExternalCacheDir().getAbsolutePath() + "/dumpVideo");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.getName().contains(str) && !file2.getName().contains("LocalData")) {
                        file2.delete();
                    }
                }
                long maxSize = getMaxSize();
                long folderSize = ZipUtil.getFolderSize(file);
                List asList = Arrays.asList(file.listFiles());
                Collections.sort(asList, new Comparator<File>() {
                    /* class com.youku.playerservice.axp.modules.tlog.TLogUploader.AnonymousClass2 */

                    public int compare(File file, File file2) {
                        return file.lastModified() > file2.lastModified() ? 1 : -1;
                    }
                });
                if (folderSize > maxSize) {
                    for (int i = 0; i < asList.size() / 2; i++) {
                        ((File) asList.get(i)).delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TLogUtil.loge(TAG, "清理数据失败" + e.getMessage());
        }
    }
}
