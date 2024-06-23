package com.youku.arch.solid.download;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DownloadTask {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DownloadItem> downloadItems = new ArrayList();

    /* compiled from: Taobao */
    public enum Priority {
        LOW(-1),
        NORMAL(0),
        HIGH(1),
        IMPERATIVE(2);
        
        public final int code;

        private Priority(int i) {
            this.code = i;
        }

        public static Priority getPriorityWithCode(int i) {
            Priority[] values = values();
            for (Priority priority : values) {
                if (priority.code == i) {
                    return priority;
                }
            }
            return NORMAL;
        }
    }

    public void addDownloadItem(DownloadItem downloadItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412490268")) {
            ipChange.ipc$dispatch("-412490268", new Object[]{this, downloadItem});
            return;
        }
        this.downloadItems.add(downloadItem);
    }

    public int getDownloadCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "500812066")) {
            return this.downloadItems.size();
        }
        return ((Integer) ipChange.ipc$dispatch("500812066", new Object[]{this})).intValue();
    }

    public List<DownloadItem> getDownloadItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1702056361")) {
            return this.downloadItems;
        }
        return (List) ipChange.ipc$dispatch("1702056361", new Object[]{this});
    }
}
