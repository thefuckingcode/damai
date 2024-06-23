package com.youku.arch.solid.download;

import android.text.TextUtils;
import cn.damai.solid.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.util.FileUtil;
import com.youku.arch.solid.util.TimeUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class SystemDownloadImp implements IDownloader {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isFocusPriorityGroup = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SystemDownloadEvent {
        final AtomicBoolean hasError;
        final IDownloadListener listener;
        final long startTime;
        final AtomicInteger totalRemainingCount;

        private SystemDownloadEvent(int i, IDownloadListener iDownloadListener) {
            this.hasError = new AtomicBoolean(false);
            this.startTime = TimeUtil.getCurTimeStamp();
            this.listener = iDownloadListener;
            this.totalRemainingCount = new AtomicInteger(i);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface SystemDownloadListener {
        void onFinish();
    }

    public SystemDownloadImp() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fe, code lost:
        if (r10 != null) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0100, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013f, code lost:
        if (r10 == null) goto L_0x0142;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013c  */
    /* JADX WARNING: Unknown variable types count: 2 */
    private boolean downloadSo(DownloadItem downloadItem, IDownloadListener iDownloadListener) {
        boolean z;
        BufferedOutputStream bufferedOutputStream;
        ?? r11;
        InputStream inputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        ?? bufferedInputStream;
        FileOutputStream fileOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467554168")) {
            return ((Boolean) ipChange.ipc$dispatch("467554168", new Object[]{this, downloadItem, iDownloadListener})).booleanValue();
        }
        long curTimeStamp = TimeUtil.getCurTimeStamp();
        String str = downloadItem.getPath() + File.separator + downloadItem.getName();
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            URL url = new URL(downloadItem.getUrl());
            iDownloadListener.onLibStart(downloadItem);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(100000);
            httpURLConnection.setReadTimeout(100000);
            httpURLConnection.setRequestProperty("Range", "bytes=0-");
            httpURLConnection.connect();
            httpURLConnection.getContentLength();
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    bufferedOutputStream2 = bufferedInputStream;
                    z = false;
                    r11 = bufferedOutputStream2;
                    try {
                        file.delete();
                        iDownloadListener.onLibError(downloadItem, "Invalid: " + th.getMessage());
                        if (bufferedOutputStream != null) {
                        }
                        if (fileOutputStream2 != null) {
                        }
                        if (r11 != 0) {
                        }
                    } catch (Throwable th3) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                                throw th3;
                            }
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream3 = null;
                bufferedOutputStream = bufferedOutputStream3;
                bufferedOutputStream2 = bufferedOutputStream3;
                z = false;
                r11 = bufferedOutputStream2;
                file.delete();
                iDownloadListener.onLibError(downloadItem, "Invalid: " + th.getMessage());
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream2 != null) {
                }
                if (r11 != 0) {
                }
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    byte[] bArr = new byte[1024];
                    MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                        instance.update(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    String byteToHexString = FileUtil.byteToHexString(instance.digest());
                    String md5 = downloadItem.getMd5();
                    SLog.d(a.TAG, "dMd5: " + byteToHexString);
                    SLog.d(a.TAG, "eMd5: " + md5);
                    if (TextUtils.equals(byteToHexString, md5)) {
                        try {
                            iDownloadListener.onLibSuccess(downloadItem, str, TimeUtil.getCurTimeStamp() - curTimeStamp);
                            z = true;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream;
                            z = true;
                            r11 = bufferedInputStream;
                            file.delete();
                            iDownloadListener.onLibError(downloadItem, "Invalid: " + th.getMessage());
                            if (bufferedOutputStream != null) {
                            }
                            if (fileOutputStream2 != null) {
                            }
                            if (r11 != 0) {
                            }
                        }
                    } else {
                        file.delete();
                        iDownloadListener.onLibError(downloadItem, "Invalid: check md5 failed!");
                        z = false;
                    }
                    try {
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = fileOutputStream;
                    bufferedOutputStream2 = bufferedInputStream;
                    z = false;
                    r11 = bufferedOutputStream2;
                    file.delete();
                    iDownloadListener.onLibError(downloadItem, "Invalid: " + th.getMessage());
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    if (r11 != 0) {
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedOutputStream = null;
                fileOutputStream2 = fileOutputStream;
                bufferedOutputStream2 = bufferedInputStream;
                z = false;
                r11 = bufferedOutputStream2;
                file.delete();
                iDownloadListener.onLibError(downloadItem, "Invalid: " + th.getMessage());
                if (bufferedOutputStream != null) {
                }
                if (fileOutputStream2 != null) {
                }
                if (r11 != 0) {
                }
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            bufferedOutputStream3 = null;
            bufferedOutputStream = bufferedOutputStream3;
            bufferedOutputStream2 = bufferedOutputStream3;
            z = false;
            r11 = bufferedOutputStream2;
            file.delete();
            iDownloadListener.onLibError(downloadItem, "Invalid: " + th.getMessage());
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (r11 != 0) {
                r11.close();
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void downloadSoList(List<DownloadItem> list, final SystemDownloadEvent systemDownloadEvent, final SystemDownloadListener systemDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550000609")) {
            ipChange.ipc$dispatch("-1550000609", new Object[]{this, list, systemDownloadEvent, systemDownloadListener});
        } else if (list != null && !list.isEmpty()) {
            final AtomicInteger atomicInteger = new AtomicInteger(list.size());
            for (final DownloadItem downloadItem : list) {
                Solid.getInstance().executeTask(new Runnable() {
                    /* class com.youku.arch.solid.download.SystemDownloadImp.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        SystemDownloadListener systemDownloadListener;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-644349027")) {
                            ipChange.ipc$dispatch("-644349027", new Object[]{this});
                            return;
                        }
                        if (!SystemDownloadImp.this.downloadSo(downloadItem, systemDownloadEvent.listener)) {
                            systemDownloadEvent.hasError.getAndSet(true);
                        }
                        if (systemDownloadEvent.totalRemainingCount.decrementAndGet() == 0) {
                            if (systemDownloadEvent.hasError.get()) {
                                systemDownloadEvent.listener.onError();
                            } else {
                                systemDownloadEvent.listener.onSuccess(TimeUtil.getCurTimeStamp() - systemDownloadEvent.startTime);
                            }
                        }
                        if (atomicInteger.decrementAndGet() == 0 && (systemDownloadListener = systemDownloadListener) != null) {
                            systemDownloadListener.onFinish();
                        }
                    }
                });
            }
        } else if (systemDownloadListener != null) {
            systemDownloadListener.onFinish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<DownloadItem> getDownloadItemListWithPriority(List<DownloadItem> list, DownloadTask.Priority priority) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526544495")) {
            return (List) ipChange.ipc$dispatch("-1526544495", new Object[]{this, list, priority});
        }
        ArrayList arrayList = new ArrayList();
        if (!(priority == null || list == null || list.isEmpty())) {
            for (DownloadItem downloadItem : list) {
                if (downloadItem.getPriority() == priority) {
                    arrayList.add(downloadItem);
                }
            }
        }
        return arrayList;
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void download(final DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331851434")) {
            ipChange.ipc$dispatch("1331851434", new Object[]{this, downloadTask, iDownloadListener});
            return;
        }
        final SystemDownloadEvent systemDownloadEvent = new SystemDownloadEvent(downloadTask.getDownloadCount(), iDownloadListener);
        if (this.isFocusPriorityGroup) {
            final LinkedList linkedList = new LinkedList(Arrays.asList(DownloadTask.Priority.values()));
            downloadSoList(getDownloadItemListWithPriority(downloadTask.getDownloadItems(), (DownloadTask.Priority) linkedList.pollLast()), systemDownloadEvent, new SystemDownloadListener() {
                /* class com.youku.arch.solid.download.SystemDownloadImp.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.arch.solid.download.SystemDownloadImp.SystemDownloadListener
                public void onFinish() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1741202927")) {
                        ipChange.ipc$dispatch("1741202927", new Object[]{this});
                    } else if (linkedList.size() > 0) {
                        SystemDownloadImp systemDownloadImp = SystemDownloadImp.this;
                        systemDownloadImp.downloadSoList(systemDownloadImp.getDownloadItemListWithPriority(downloadTask.getDownloadItems(), (DownloadTask.Priority) linkedList.pollLast()), systemDownloadEvent, this);
                    }
                }
            });
            return;
        }
        List<DownloadItem> downloadItems = downloadTask.getDownloadItems();
        Collections.sort(downloadItems);
        downloadSoList(downloadItems, systemDownloadEvent, null);
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193703908")) {
            ipChange.ipc$dispatch("193703908", new Object[]{this});
        }
    }

    public SystemDownloadImp(boolean z) {
        this.isFocusPriorityGroup = z;
    }
}
