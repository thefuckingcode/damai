package cn.damai.tetris.component.star.content.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.star.content.feed.bean.ContentFeedBean;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.s50;

/* compiled from: Taobao */
public class ContentFeedAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ContentFeedBean> contentFeedBeans;
    private LayoutInflater layoutInflater;

    public ContentFeedAdapter(Context context, List<ContentFeedBean> list) {
        this.contentFeedBeans = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28993554")) {
            return ((Integer) ipChange.ipc$dispatch("28993554", new Object[]{this})).intValue();
        }
        List<ContentFeedBean> list = this.contentFeedBeans;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "583214217")) {
            return (long) i;
        }
        return ((Long) ipChange.ipc$dispatch("583214217", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "810920487")) {
            return (View) ipChange.ipc$dispatch("810920487", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        View inflate = this.layoutInflater.inflate(R$layout.item_stargrid_layout, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(s50.a(viewGroup.getContext(), 68.0f), s50.a(viewGroup.getContext(), 68.0f)));
        ContentFeedBean item = getItem(i);
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

    public ContentFeedBean getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050677896")) {
            return (ContentFeedBean) ipChange.ipc$dispatch("-2050677896", new Object[]{this, Integer.valueOf(i)});
        } else if (getCount() == 0 || i >= this.contentFeedBeans.size()) {
            return null;
        } else {
            return this.contentFeedBeans.get(i);
        }
    }
}
