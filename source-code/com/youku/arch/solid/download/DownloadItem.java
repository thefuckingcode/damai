package com.youku.arch.solid.download;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.ZipDownloadItem;
import com.youku.arch.solid.download.DownloadTask;

/* compiled from: Taobao */
public class DownloadItem implements Comparable<DownloadItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String md5;
    private String name;
    private String path;
    private DownloadTask.Priority priority;
    private String url;
    private ZipDownloadItem zipDownloadItem;

    /* compiled from: Taobao */
    public static class Builder {
        private ZipDownloadItem degradeDownloadItems;
        private String md5;
        private String name;
        private String path;
        private DownloadTask.Priority priority;
        private String url;

        public DownloadItem build() {
            String str = this.url;
            if (str == null || str.isEmpty()) {
                throw new RuntimeException("DownloadRequest.url cann't be null or empty string.");
            }
            String str2 = this.path;
            if (str2 == null || str2.isEmpty()) {
                throw new RuntimeException("DownloadRequest.path cann't be null or empty string.");
            }
            String str3 = this.name;
            if (str3 == null || str3.isEmpty()) {
                throw new RuntimeException("DownloadRequest.name cann't be null or empty string.");
            }
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = this.url;
            downloadItem.md5 = this.md5;
            downloadItem.path = this.path;
            downloadItem.name = this.name;
            downloadItem.priority = this.priority;
            downloadItem.zipDownloadItem = this.degradeDownloadItems;
            return downloadItem;
        }

        public Builder setMd5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setPath(String str) {
            this.path = str;
            return this;
        }

        public Builder setPriority(DownloadTask.Priority priority2) {
            this.priority = priority2;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setZipDownloadItem(ZipDownloadItem zipDownloadItem) {
            this.degradeDownloadItems = zipDownloadItem;
            return this;
        }
    }

    public String getMd5() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2090955302")) {
            return this.md5;
        }
        return (String) ipChange.ipc$dispatch("-2090955302", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-650802843")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-650802843", new Object[]{this});
    }

    public String getPath() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1532255745")) {
            return this.path;
        }
        return (String) ipChange.ipc$dispatch("-1532255745", new Object[]{this});
    }

    public DownloadTask.Priority getPriority() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1989213590")) {
            return this.priority;
        }
        return (DownloadTask.Priority) ipChange.ipc$dispatch("1989213590", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-451392693")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("-451392693", new Object[]{this});
    }

    public ZipDownloadItem getZipDownloadItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2070792886")) {
            return this.zipDownloadItem;
        }
        return (ZipDownloadItem) ipChange.ipc$dispatch("-2070792886", new Object[]{this});
    }

    public int compareTo(@NonNull DownloadItem downloadItem) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-31205499")) {
            return downloadItem.priority.code - this.priority.code;
        }
        return ((Integer) ipChange.ipc$dispatch("-31205499", new Object[]{this, downloadItem})).intValue();
    }
}
