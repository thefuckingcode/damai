package com.youku.arch.solid;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.model.CompressInfo;
import com.youku.arch.solid.model.SoInfo;
import java.io.File;

/* compiled from: Taobao */
public final class SoInfoWrapper implements ZipDownloadItem {
    private static transient /* synthetic */ IpChange $ipChange;
    private SoGroupWrapper belongGroup;
    private volatile boolean hasDrive;
    private File localFile;
    private final DownloadTask.Priority priority;
    private final SoInfo soInfo;
    private volatile Status status = Status.WAIT_TO_DOWNLOAD;

    SoInfoWrapper(SoInfo soInfo2) {
        this.soInfo = soInfo2;
        this.priority = DownloadTask.Priority.getPriorityWithCode(soInfo2.priority);
    }

    /* access modifiers changed from: package-private */
    public CompressInfo compressInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "230872695")) {
            return this.soInfo.compressInfo;
        }
        return (CompressInfo) ipChange.ipc$dispatch("230872695", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public void downloadFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795853393")) {
            ipChange.ipc$dispatch("-1795853393", new Object[]{this});
            return;
        }
        updateStatus(Status.DOWNLOAD_FAIL);
    }

    public SoGroupWrapper getBelongGroup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1802311715")) {
            return this.belongGroup;
        }
        return (SoGroupWrapper) ipChange.ipc$dispatch("1802311715", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipMd5() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-828352098")) {
            return compressInfo().md5;
        }
        return (String) ipChange.ipc$dispatch("-828352098", new Object[]{this});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164809183")) {
            return (String) ipChange.ipc$dispatch("-164809183", new Object[]{this});
        }
        return soFileName() + ".zip";
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public DownloadTask.Priority getZipPriority(boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-520982366")) {
            return priority(z);
        }
        return (DownloadTask.Priority) ipChange.ipc$dispatch("-520982366", new Object[]{this, Boolean.valueOf(z)});
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "811210511")) {
            return compressInfo().url;
        }
        return (String) ipChange.ipc$dispatch("811210511", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoDownload() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-474536968")) {
            return this.soInfo.isAutoDownload;
        }
        return ((Boolean) ipChange.ipc$dispatch("-474536968", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public String libName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1138506181")) {
            return this.soInfo.libName;
        }
        return (String) ipChange.ipc$dispatch("-1138506181", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public File localFile() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1857516287")) {
            return this.localFile;
        }
        return (File) ipChange.ipc$dispatch("1857516287", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public String md5() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1354830345")) {
            return this.soInfo.md5;
        }
        return (String) ipChange.ipc$dispatch("1354830345", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public boolean needDownload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388023493")) {
            return ((Boolean) ipChange.ipc$dispatch("-1388023493", new Object[]{this})).booleanValue();
        } else if (this.status == Status.DOWNLOAD_FAIL) {
            return true;
        } else {
            if (this.status != Status.WAIT_TO_DOWNLOAD) {
                return false;
            }
            if (isAutoDownload() || this.hasDrive) {
                return true;
            }
            return false;
        }
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public boolean needDownloadZip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1466463274")) {
            return compressInfo() != null && status() == Status.WAIT_TO_DOWNLOAD;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1466463274", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public DownloadTask.Priority priority(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407760023")) {
            return (DownloadTask.Priority) ipChange.ipc$dispatch("407760023", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.status == Status.DOWNLOAD_FAIL) {
            return DownloadTask.Priority.IMPERATIVE;
        } else {
            if (z) {
                return this.priority;
            }
            return DownloadTask.Priority.IMPERATIVE;
        }
    }

    /* access modifiers changed from: package-private */
    public void setBelongGroup(SoGroupWrapper soGroupWrapper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109599985")) {
            ipChange.ipc$dispatch("109599985", new Object[]{this, soGroupWrapper});
        } else if (this.belongGroup == null && soGroupWrapper != null) {
            this.belongGroup = soGroupWrapper;
        }
    }

    /* access modifiers changed from: package-private */
    public void setDrive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671470611")) {
            ipChange.ipc$dispatch("-1671470611", new Object[]{this});
            return;
        }
        this.hasDrive = true;
    }

    /* access modifiers changed from: package-private */
    public void setLocalFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241995961")) {
            ipChange.ipc$dispatch("-241995961", new Object[]{this, file});
            return;
        }
        this.localFile = file;
    }

    /* access modifiers changed from: package-private */
    public String soFileName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "151879982")) {
            return this.soInfo.soName;
        }
        return (String) ipChange.ipc$dispatch("151879982", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public Status status() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "921898073")) {
            return this.status;
        }
        return (Status) ipChange.ipc$dispatch("921898073", new Object[]{this});
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142505865")) {
            return (String) ipChange.ipc$dispatch("-142505865", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\tSoInfo{\n\t\"compressInfo.url\": ");
        CompressInfo compressInfo = this.soInfo.compressInfo;
        String str = "null";
        sb.append(compressInfo == null ? str : compressInfo.url);
        sb.append("\n\t\"compressInfo.md5\": ");
        CompressInfo compressInfo2 = this.soInfo.compressInfo;
        if (compressInfo2 != null) {
            str = compressInfo2.md5;
        }
        sb.append(str);
        sb.append("\n\t\t\t\"md5\": \"");
        sb.append(this.soInfo.md5);
        sb.append("\"");
        sb.append(",\n\t\t\t\"url\": \"");
        sb.append(this.soInfo.url);
        sb.append("\"");
        sb.append(",\n\t\t\t\"libName\": \"");
        sb.append(this.soInfo.libName);
        sb.append("\"");
        sb.append(",\n\t\t\t\"soName\": \"");
        sb.append(this.soInfo.soName);
        sb.append("\"");
        sb.append(",\n\t\t\t\"status\": ");
        sb.append(this.status);
        sb.append("\n\t\t}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void updateStatus(Status status2) {
        SoGroupWrapper soGroupWrapper;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80796756")) {
            ipChange.ipc$dispatch("-80796756", new Object[]{this, status2});
            return;
        }
        this.status = status2;
        if (status2 == Status.DOWNLOADED && (soGroupWrapper = this.belongGroup) != null) {
            soGroupWrapper.onSoDownloaded();
        }
    }

    /* access modifiers changed from: package-private */
    public String url() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1300574342")) {
            return this.soInfo.url;
        }
        return (String) ipChange.ipc$dispatch("-1300574342", new Object[]{this});
    }
}
