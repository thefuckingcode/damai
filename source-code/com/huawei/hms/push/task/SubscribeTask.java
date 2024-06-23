package com.huawei.hms.push.task;

/* compiled from: Taobao */
public class SubscribeTask extends BaseVoidTask {
    public SubscribeTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall, com.huawei.hms.push.task.BaseVoidTask
    public int getMinApkVersion() {
        return 40003000;
    }
}
