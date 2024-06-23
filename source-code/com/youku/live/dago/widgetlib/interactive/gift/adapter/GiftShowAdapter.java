package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftItemView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.List;

/* compiled from: Taobao */
public class GiftShowAdapter extends MultiItemCommonAdapter<GiftInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private GiftStarItemView mCurrentSelectedView;
    private GiftInfoBean mGiftInfo;

    public GiftShowAdapter(Context context, List<GiftInfoBean> list) {
        super(context, list, new MultiItemTypeSupport<GiftInfoBean>() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftShowAdapter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.MultiItemTypeSupport
            public int getViewTypeCount() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1896316020")) {
                    return 2;
                }
                return ((Integer) ipChange.ipc$dispatch("1896316020", new Object[]{this})).intValue();
            }

            public int getItemViewType(int i, GiftInfoBean giftInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "138071386")) {
                    return ((Integer) ipChange.ipc$dispatch("138071386", new Object[]{this, Integer.valueOf(i), giftInfoBean})).intValue();
                }
                int i2 = giftInfoBean.girdViewType;
                return (i2 != 0 && i2 == 1) ? 1 : 0;
            }

            public int getLayoutId(int i, GiftInfoBean giftInfoBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1951059123")) {
                    return ((Integer) ipChange.ipc$dispatch("-1951059123", new Object[]{this, Integer.valueOf(i), giftInfoBean})).intValue();
                }
                int i2 = giftInfoBean.girdViewType;
                if (i2 == 0) {
                    return R.layout.dago_pgc_ykl_send_gift_sel_item;
                }
                if (i2 != 1) {
                    return R.layout.dago_pgc_ykl_send_gift_sel_item;
                }
                return R.layout.dago_pgc_gift_star_item;
            }
        });
    }

    private void updateItem(AdapterView<?> adapterView, String str, int i) {
        int firstVisiblePosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1660051039")) {
            ipChange.ipc$dispatch("-1660051039", new Object[]{this, adapterView, str, Integer.valueOf(i)});
        } else if (i != -1 && i < getCount() && (firstVisiblePosition = i - adapterView.getFirstVisiblePosition()) >= 0) {
            View childAt = adapterView.getChildAt(firstVisiblePosition);
            if (childAt instanceof GiftItemView) {
                GiftItemView giftItemView = (GiftItemView) childAt;
                if (giftItemView != null && giftItemView.getGiftId().equals(str)) {
                    giftItemView.updateSelectState(this.mDatas.get(i));
                    return;
                }
                return;
            }
            ((GiftStarItemView) childAt.findViewById(R.id.startView)).updateSelectState(this.mDatas.get(i));
        }
    }

    public GiftInfoBean getCheckedBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-936162764")) {
            return this.mGiftInfo;
        }
        return (GiftInfoBean) ipChange.ipc$dispatch("-936162764", new Object[]{this});
    }

    public View getCurrentSelectedView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "764858733")) {
            return this.mCurrentSelectedView;
        }
        return (View) ipChange.ipc$dispatch("764858733", new Object[]{this});
    }

    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822122807")) {
            ipChange.ipc$dispatch("-822122807", new Object[]{this});
            return;
        }
        super.notifyDataSetChanged();
        ((ILog) Dsl.getService(ILog.class)).i("liulei-datachange", "GiftShowAdapter.notifyDataSetChanged() 33333");
    }

    public void selected(AdapterView<?> adapterView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232452874")) {
            ipChange.ipc$dispatch("1232452874", new Object[]{this, adapterView, Integer.valueOf(i)});
            return;
        }
        GridView gridView = (GridView) adapterView;
        T t = this.mDatas.get(i);
        this.mGiftInfo = t;
        t.isChecked = true;
        int i2 = this.mDatas.get(i).girdViewType;
        if (i2 == 0) {
            ((GiftItemView) adapterView.getChildAt(i - gridView.getFirstVisiblePosition())).updateSelectState(this.mDatas.get(i));
        } else if (i2 == 1) {
            GiftStarItemView giftStarItemView = (GiftStarItemView) adapterView.getChildAt(i - gridView.getFirstVisiblePosition());
            if (this.mCurrentSelectedView == null && giftStarItemView.isRealView()) {
                this.mCurrentSelectedView = giftStarItemView;
            }
            giftStarItemView.updateSelectState(this.mDatas.get(i));
        }
    }

    public void unSelected(AdapterView<?> adapterView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240109002")) {
            ipChange.ipc$dispatch("1240109002", new Object[]{this, adapterView, str});
            return;
        }
        for (int i = 0; i < getCount(); i++) {
            if (this.mDatas.get(i).id.equals(str)) {
                this.mDatas.get(i).isChecked = false;
                updateItem(adapterView, str, i);
            }
        }
    }

    public void convert(CommonViewHolder commonViewHolder, int i, GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710699611")) {
            ipChange.ipc$dispatch("710699611", new Object[]{this, commonViewHolder, Integer.valueOf(i), giftInfoBean});
            return;
        }
        this.mGiftInfo = giftInfoBean;
        if (commonViewHolder.getLayoutId() == R.layout.dago_pgc_ykl_send_gift_sel_item) {
            ((GiftItemView) commonViewHolder.getView(R.id.id_gift_item_view)).setData(giftInfoBean);
        } else if (commonViewHolder.getLayoutId() == R.layout.dago_pgc_gift_star_item) {
            GiftStarItemView giftStarItemView = (GiftStarItemView) commonViewHolder.getView(R.id.startView);
            giftStarItemView.upDateState(giftInfoBean);
            if (this.mCurrentSelectedView == null && giftStarItemView.isRealView()) {
                this.mCurrentSelectedView = giftStarItemView;
            }
        }
    }
}
