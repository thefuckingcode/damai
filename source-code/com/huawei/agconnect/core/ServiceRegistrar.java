package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

/* compiled from: Taobao */
public interface ServiceRegistrar {
    List<Service> getServices(Context context);

    void initialize(Context context);
}
