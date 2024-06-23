package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftCheckableImageView;
import com.youku.live.dago.widgetlib.interactive.gift.view.PropItemView;
import java.util.List;

/* compiled from: Taobao */
public class GiftPropAdapter extends MultiItemCommonAdapter<GiftPropBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public GiftPropAdapter(Context context, List<GiftPropBean> list) {
        super(context, list, new MultiItemTypeSupport<GiftPropBean>() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.adapter.GiftPropAdapter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public int getItemViewType(int i, GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1107105119")) {
                    return 0;
                }
                return ((Integer) ipChange.ipc$dispatch("1107105119", new Object[]{this, Integer.valueOf(i), giftPropBean})).intValue();
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.MultiItemTypeSupport
            public int getViewTypeCount() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-429316274")) {
                    return 1;
                }
                return ((Integer) ipChange.ipc$dispatch("-429316274", new Object[]{this})).intValue();
            }

            public int getLayoutId(int i, GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1794131886")) {
                    return R.layout.dago_pgc_ykl_send_prop_sel_item;
                }
                return ((Integer) ipChange.ipc$dispatch("-1794131886", new Object[]{this, Integer.valueOf(i), giftPropBean})).intValue();
            }
        });
    }

    public void selected(AdapterView<?> adapterView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1499439120")) {
            ipChange.ipc$dispatch("-1499439120", new Object[]{this, adapterView, Integer.valueOf(i)});
            return;
        }
        this.mDatas.get(i).isChecked = true;
        ((PropItemView) adapterView.getChildAt(i - ((GridView) adapterView).getFirstVisiblePosition())).updateSelectState(this.mDatas.get(i));
    }

    public void unSelected(AdapterView<?> adapterView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106541860")) {
            ipChange.ipc$dispatch("2106541860", new Object[]{this, adapterView, str});
            return;
        }
        for (int i = 0; i < getCount(); i++) {
            if (!TextUtils.isEmpty(this.mDatas.get(i).id) && this.mDatas.get(i).id.equals(str)) {
                this.mDatas.get(i).isChecked = false;
                updateItem(adapterView, str, i);
            }
        }
    }

    public void updateCount(AdapterView<?> adapterView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333225121")) {
            ipChange.ipc$dispatch("333225121", new Object[]{this, adapterView, Integer.valueOf(i)});
        } else if (adapterView != null) {
            ((PropItemView) adapterView.getChildAt(i - ((GridView) adapterView).getFirstVisiblePosition())).updateData(this.mDatas.get(i));
        }
    }

    public void updateItem(AdapterView<?> adapterView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519390097")) {
            ipChange.ipc$dispatch("1519390097", new Object[]{this, adapterView, Integer.valueOf(i)});
        } else if (adapterView != null) {
            ((PropItemView) adapterView.getChildAt(i - ((GridView) adapterView).getFirstVisiblePosition())).setData(this.mDatas.get(i));
        }
    }

    public void convert(CommonViewHolder commonViewHolder, int i, GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242335636")) {
            ipChange.ipc$dispatch("-1242335636", new Object[]{this, commonViewHolder, Integer.valueOf(i), giftPropBean});
        } else if (commonViewHolder.getLayoutId() == R.layout.dago_pgc_ykl_send_prop_sel_item) {
            ((PropItemView) commonViewHolder.getView(R.id.id_prop_item_view)).setData(giftPropBean);
        }
    }

    private void updateItem(AdapterView<?> adapterView, String str, int i) {
        int firstVisiblePosition;
        PropItemView propItemView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570436217")) {
            ipChange.ipc$dispatch("-570436217", new Object[]{this, adapterView, str, Integer.valueOf(i)});
        } else if (i != -1 && i < getCount() && (firstVisiblePosition = i - adapterView.getFirstVisiblePosition()) >= 0) {
            View childAt = adapterView.getChildAt(firstVisiblePosition);
            if ((childAt instanceof PropItemView) && (propItemView = (PropItemView) childAt) != null && ((String) ((GiftCheckableImageView) propItemView.findViewById(R.id.id_iv_prop_check_state)).getTag()).equals(str)) {
                propItemView.updateSelectState(this.mDatas.get(i));
            }
        }
    }
}
