package com.ali.user.mobile.base;

import com.ali.user.mobile.model.RegionInfo;
import java.util.List;

/* compiled from: Taobao */
public interface BaseView {
    void dismissLoading();

    boolean isActive();

    void onGetRegion(List<RegionInfo> list);

    void showLoading();

    void toast(String str, int i);
}
