package com.youku.arch.solid;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.lifecycle.OnSoGroupStatusChangeListener;
import com.youku.arch.solid.lifecycle.SolidResponse;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.model.CompressInfo;
import com.youku.arch.solid.model.SoGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public final class SoGroupWrapper implements ZipDownloadItem {
    private static transient /* synthetic */ IpChange $ipChange;
    private final AtomicInteger completeCount = new AtomicInteger(0);
    private final List<OnSoGroupStatusChangeListener> listeners = new ArrayList();
    private final SoGroup soGroup;
    private final List<SoInfoWrapper> soItemList = new ArrayList();
    private volatile Status status = Status.WAIT_TO_DOWNLOAD;

    SoGroupWrapper(SoGroup soGroup2) {
        this.soGroup = soGroup2;
    }

    private boolean existDownloadedSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929248446")) {
            return ((Boolean) ipChange.ipc$dispatch("1929248446", new Object[]{this})).booleanValue();
        }
        for (SoInfoWrapper soInfoWrapper : getSoInfoList()) {
            if (soInfoWrapper.status() == Status.DOWNLOADED) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void addOnSoGroupReadyListener(OnSoGroupStatusChangeListener onSoGroupStatusChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661873053")) {
            ipChange.ipc$dispatch("-661873053", new Object[]{this, onSoGroupStatusChangeListener});
        } else if (onSoGroupStatusChangeListener != null) {
            synchronized (this.listeners) {
                if (this.status == Status.DOWNLOADED) {
                    notifySoGroupReady(onSoGroupStatusChangeListener);
                } else {
                    this.listeners.add(onSoGroupStatusChangeListener);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CompressInfo compressInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-550029736")) {
            return this.soGroup.compressInfo;
        }
        return (CompressInfo) ipChange.ipc$dispatch("-550029736", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public void downloadFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288880496")) {
            ipChange.ipc$dispatch("-288880496", new Object[]{this});
            return;
        }
        updateStatus(Status.DOWNLOAD_FAIL);
    }

    /* access modifiers changed from: package-private */
    public List<SoInfoWrapper> getSoInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-914322383")) {
            return this.soItemList;
        }
        return (List) ipChange.ipc$dispatch("-914322383", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipMd5() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1681412287")) {
            return compressInfo().md5;
        }
        return (String) ipChange.ipc$dispatch("1681412287", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328475424")) {
            return (String) ipChange.ipc$dispatch("328475424", new Object[]{this});
        }
        return name() + ".zip";
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public DownloadTask.Priority getZipPriority(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611831135")) {
            return (DownloadTask.Priority) ipChange.ipc$dispatch("-611831135", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.status == Status.DOWNLOAD_FAIL) {
            return DownloadTask.Priority.IMPERATIVE;
        } else {
            if (z) {
                return DownloadTask.Priority.getPriorityWithCode(this.soGroup.priority);
            }
            return DownloadTask.Priority.IMPERATIVE;
        }
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-973992400")) {
            return compressInfo().url;
        }
        return (String) ipChange.ipc$dispatch("-973992400", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoDownload() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "322438297")) {
            return this.soGroup.isAutoDownload;
        }
        return ((Boolean) ipChange.ipc$dispatch("322438297", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void linkSoInfo(SoInfoWrapper soInfoWrapper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799962657")) {
            ipChange.ipc$dispatch("1799962657", new Object[]{this, soInfoWrapper});
        } else if (soInfoWrapper != null) {
            this.soItemList.add(soInfoWrapper);
            soInfoWrapper.setBelongGroup(this);
        }
    }

    /* access modifiers changed from: package-private */
    public String name() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1954800469")) {
            return this.soGroup.name;
        }
        return (String) ipChange.ipc$dispatch("1954800469", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public boolean needDownloadZip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1764933461")) {
            return compressInfo() != null && status() == Status.WAIT_TO_DOWNLOAD && !existDownloadedSo();
        }
        return ((Boolean) ipChange.ipc$dispatch("1764933461", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void notifySoGroupReady(final OnSoGroupStatusChangeListener onSoGroupStatusChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409474608")) {
            ipChange.ipc$dispatch("-409474608", new Object[]{this, onSoGroupStatusChangeListener});
            return;
        }
        final SolidResponse solidResponse = new SolidResponse();
        solidResponse.groupName = new String(this.soGroup.name.getBytes());
        solidResponse.status = this.status;
        Solid.getInstance().executeTask(new Runnable() {
            /* class com.youku.arch.solid.SoGroupWrapper.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-741384548")) {
                    ipChange.ipc$dispatch("-741384548", new Object[]{this});
                    return;
                }
                onSoGroupStatusChangeListener.onResponse(solidResponse);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onSoDownloaded() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120436340")) {
            ipChange.ipc$dispatch("1120436340", new Object[]{this});
        } else if (this.completeCount.incrementAndGet() == this.soItemList.size()) {
            updateStatus(Status.DOWNLOADED);
        }
    }

    /* access modifiers changed from: package-private */
    public Status status() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1769362042")) {
            return this.status;
        }
        return (Status) ipChange.ipc$dispatch("1769362042", new Object[]{this});
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601022262")) {
            return (String) ipChange.ipc$dispatch("1601022262", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n.\nSoGroup{\n\t\"compressInfo.url\": ");
        CompressInfo compressInfo = this.soGroup.compressInfo;
        String str = "null";
        sb.append(compressInfo == null ? str : compressInfo.url);
        sb.append("\n\t\"compressInfo.md5\": ");
        CompressInfo compressInfo2 = this.soGroup.compressInfo;
        if (compressInfo2 != null) {
            str = compressInfo2.md5;
        }
        sb.append(str);
        sb.append("\n\t\"isAutoDownload\": ");
        sb.append(this.soGroup.isAutoDownload);
        sb.append(",\n\t\"name\": \"");
        sb.append(this.soGroup.name);
        sb.append("\"");
        sb.append(",\n\t\"priority\": ");
        sb.append(this.soGroup.priority);
        sb.append(",\n\t\"soItemList\": ");
        sb.append(this.soItemList);
        sb.append("\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void updateStatus(Status status2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972889195")) {
            ipChange.ipc$dispatch("1972889195", new Object[]{this, status2});
            return;
        }
        this.status = status2;
        if (status2 == Status.DOWNLOADED) {
            synchronized (this.listeners) {
                for (OnSoGroupStatusChangeListener onSoGroupStatusChangeListener : this.listeners) {
                    notifySoGroupReady(onSoGroupStatusChangeListener);
                }
            }
            SLog.e("SoGroup", "group success : " + this.soGroup.name);
        }
    }
}
