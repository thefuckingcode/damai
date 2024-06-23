package cn.damai.tetris.component.star.group.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.star.group.bean.StarInfoItem;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.nav.INav;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.s50;

/* compiled from: Taobao */
public class GridAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private LayoutInflater layoutInflater;
    private BasePresenter mPresenter;
    private List<StarInfoItem> starInfoItems;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ StarInfoItem b;
        final /* synthetic */ int c;

        a(ViewGroup viewGroup, StarInfoItem starInfoItem, int i) {
            this.a = viewGroup;
            this.b = starInfoItem;
            this.c = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "146341404")) {
                ipChange.ipc$dispatch("146341404", new Object[]{this, view});
                return;
            }
            INav from = NavProxy.from(this.a.getContext());
            from.toUri("damai://userprofile?userId=" + this.b.damaiId + "&&userType=" + 2);
            BasePresenter basePresenter = GridAdapter.this.mPresenter;
            StringBuilder sb = new StringBuilder();
            sb.append("artist_item_");
            sb.append(this.c);
            basePresenter.userTrackClick(sb.toString(), true);
        }
    }

    public GridAdapter(Context context, List<StarInfoItem> list, BasePresenter basePresenter) {
        this.starInfoItems = list;
        this.layoutInflater = LayoutInflater.from(context);
        this.mPresenter = basePresenter;
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563951896")) {
            return ((Integer) ipChange.ipc$dispatch("1563951896", new Object[]{this})).intValue();
        }
        List<StarInfoItem> list = this.starInfoItems;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1790568945")) {
            return (long) i;
        }
        return ((Long) ipChange.ipc$dispatch("-1790568945", new Object[]{this, Integer.valueOf(i)})).longValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097450209")) {
            return (View) ipChange.ipc$dispatch("2097450209", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        View inflate = this.layoutInflater.inflate(R$layout.item_stargrid_layout, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(s50.a(viewGroup.getContext(), 68.0f), s50.a(viewGroup.getContext(), 68.0f)));
        StarInfoItem item = getItem(i);
        if (item != null) {
            ((TextView) inflate.findViewById(R$id.tv_gridView_item_name)).setText(item.name);
            DMAvatar dMAvatar = (DMAvatar) inflate.findViewById(R$id.icon_star_header);
            dMAvatar.setVisibility(0);
            dMAvatar.setAvatar(item.headPic);
            dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
            dMAvatar.setAvatarPlaceholder(R$drawable.transparent_bg);
            dMAvatar.setAvatarVTagVisibility(0);
        }
        BasePresenter basePresenter = this.mPresenter;
        basePresenter.userTrackExpose(inflate, "artist_item_" + i);
        inflate.setOnClickListener(new a(viewGroup, item, i));
        return inflate;
    }

    public StarInfoItem getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756927245")) {
            return (StarInfoItem) ipChange.ipc$dispatch("-1756927245", new Object[]{this, Integer.valueOf(i)});
        } else if (getCount() == 0 || i >= this.starInfoItems.size()) {
            return null;
        } else {
            return this.starInfoItems.get(i);
        }
    }
}
