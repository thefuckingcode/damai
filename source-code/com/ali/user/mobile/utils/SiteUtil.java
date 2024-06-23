package com.ali.user.mobile.utils;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;

/* compiled from: Taobao */
public class SiteUtil {
    public static int getDefaultLoginSite() {
        return DataProviderFactory.getDataProvider().getSite();
    }
}
