package cn.damai.category.discountticket.model;

import android.os.Bundle;

/* compiled from: Taobao */
public interface OnShareListener {
    void onShare(Bundle bundle);

    void showLoading(boolean z);

    void toast(String str);
}
