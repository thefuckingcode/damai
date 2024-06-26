package com.youku.live.dago.widgetlib.interactive.gift.view.pageview;

import android.content.Context;
import android.util.AttributeSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftPropAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import java.util.List;

/* compiled from: Taobao */
public class YKLPropPageView extends GiftBaseView<GiftPropBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    protected String mGroupId;
    protected String mGroupName;
    protected int mGroupPosition;

    public YKLPropPageView(Context context) {
        super(context);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView
    public CommonAdapter<GiftPropBean> getAdapter(List<GiftPropBean> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-351254490")) {
            return new GiftPropAdapter(this.mContext, list);
        }
        return (CommonAdapter) ipChange.ipc$dispatch("-351254490", new Object[]{this, list});
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView
    public List<GiftPropBean> getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899970185")) {
            return (List) ipChange.ipc$dispatch("1899970185", new Object[]{this});
        }
        List<T> list = this.mData;
        if (list == null) {
            return null;
        }
        return list;
    }

    public List<GiftPropBean> getFirstPageList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123159806")) {
            return (List) ipChange.ipc$dispatch("-123159806", new Object[]{this});
        }
        List<List> list = this.mDataList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.mDataList.get(0);
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView
    public void reportUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456238649")) {
            ipChange.ipc$dispatch("1456238649", new Object[]{this});
        }
    }

    public void setGroupId(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1735363845")) {
            ipChange.ipc$dispatch("-1735363845", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        this.mGroupId = str;
        this.mGroupName = str2;
        this.mGroupPosition = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean> */
    /* JADX WARN: Multi-variable type inference failed */
    public YKLPropPageView(Context context, List<GiftPropBean> list) {
        super(context);
        this.mContext = context;
        this.mData = list;
    }

    public YKLPropPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public YKLPropPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }
}
