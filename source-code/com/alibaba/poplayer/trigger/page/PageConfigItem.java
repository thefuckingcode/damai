package com.alibaba.poplayer.trigger.page;

import com.alibaba.poplayer.trigger.BaseConfigItem;

/* compiled from: Taobao */
public class PageConfigItem extends BaseConfigItem {
    public static String LOG = "PageConfigItem";
    public BaseConfigItem.a pageInfo;

    @Override // com.alibaba.poplayer.trigger.BaseConfigItem
    public String toString() {
        return "Page{" + this.pageInfo + '}' + super.toString();
    }
}
