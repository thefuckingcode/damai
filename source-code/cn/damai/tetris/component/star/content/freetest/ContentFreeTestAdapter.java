package cn.damai.tetris.component.star.content.freetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.star.content.freetest.bean.ContentFreeTestBean;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.s50;

/* compiled from: Taobao */
public class ContentFreeTestAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ContentFreeTestBean> contentFreeBeans;
    private LayoutInflater layoutInflater;

    public ContentFreeTestAdapter(Context context, List<ContentFreeTestBean> list) {
        this.contentFreeBeans = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923803442")) {
            return ((Integer) ipChange.ipc$dispatch("923803442", new Object[]{this})).intValue();
        }
        List<ContentFreeTestBean> list = this.contentFreeBeans;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1502057385")) {
            return (long) i;
        }
        return ((Long) ipChange.ipc$dispatch("1502057385", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421428487")) {
            return (View) ipChange.ipc$dispatch("1421428487", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        View inflate = this.layoutInflater.inflate(R$layout.item_stargrid_layout, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(s50.a(viewGroup.getContext(), 68.0f), s50.a(viewGroup.getContext(), 68.0f)));
        ContentFreeTestBean item = getItem(i);
        if (item != null) {
            ((TextView) inflate.findViewById(R$id.tv_gridView_item_name)).setText(item.name);
            DMAvatar dMAvatar = (DMAvatar) inflate.findViewById(R$id.icon_star_header);
            dMAvatar.setVisibility(0);
            dMAvatar.setAvatar(item.headPic);
            dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_40x40);
            dMAvatar.setAvatarPlaceholder(R$drawable.transparent_bg);
            dMAvatar.setAvatarVTagVisibility(0);
        }
        return inflate;
    }

    public ContentFreeTestBean getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041144392")) {
            return (ContentFreeTestBean) ipChange.ipc$dispatch("-2041144392", new Object[]{this, Integer.valueOf(i)});
        } else if (getCount() == 0 || i >= this.contentFreeBeans.size()) {
            return null;
        } else {
            return this.contentFreeBeans.get(i);
        }
    }
}
