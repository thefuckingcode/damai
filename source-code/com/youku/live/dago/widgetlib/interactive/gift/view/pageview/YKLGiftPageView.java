package com.youku.live.dago.widgetlib.interactive.gift.view.pageview;

import android.content.Context;
import android.util.AttributeSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftShowAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import java.util.List;

/* compiled from: Taobao */
public class YKLGiftPageView extends GiftBaseView<GiftInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    protected String mGroupId;
    protected String mGroupName;
    protected int mGroupPosition;

    public YKLGiftPageView(Context context) {
        super(context);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView
    public List<GiftInfoBean> getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853598678")) {
            return (List) ipChange.ipc$dispatch("853598678", new Object[]{this});
        }
        List<T> list = this.mData;
        if (list == null) {
            return null;
        }
        return list;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView
    public void reportUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315740602")) {
            ipChange.ipc$dispatch("-315740602", new Object[]{this});
        }
    }

    public void setGroupId(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744108110")) {
            ipChange.ipc$dispatch("744108110", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        this.mGroupId = str;
        this.mGroupName = str2;
        this.mGroupPosition = i;
    }

    /* Return type fixed from 'com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftShowAdapter' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView
    public CommonAdapter<GiftInfoBean> getAdapter(List<GiftInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-249690277")) {
            return new GiftShowAdapter(this.mContext, list);
        }
        return (GiftShowAdapter) ipChange.ipc$dispatch("-249690277", new Object[]{this, list});
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean> */
    /* JADX WARN: Multi-variable type inference failed */
    public YKLGiftPageView(Context context, List<GiftInfoBean> list) {
        super(context);
        this.mContext = context;
        this.mData = list;
    }

    public YKLGiftPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public YKLGiftPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }
}
