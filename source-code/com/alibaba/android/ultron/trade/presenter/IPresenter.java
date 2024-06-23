package com.alibaba.android.ultron.trade.presenter;

import android.app.Activity;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import tb.jk2;
import tb.kn2;

/* compiled from: Taobao */
public interface IPresenter {
    Activity getContext();

    IDMContext getDataContext();

    BaseDataManager getDataManager();

    String getModuleName();

    jk2 getThemeManager();

    kn2 getTradeEventHandler();

    b getViewManager();

    void respondToLinkage(IDMComponent iDMComponent);
}
