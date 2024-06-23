package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.api.opendevice.OdidResult;

/* compiled from: Taobao */
public interface OpenDeviceClient {
    Task<OdidResult> getOdid();
}
