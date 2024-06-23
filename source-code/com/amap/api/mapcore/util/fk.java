package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* compiled from: Taobao */
public class fk extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    private boolean[] a;
    private int b = -1;
    private List<OfflineMapProvince> c = null;
    private OfflineMapManager d;
    private Context e;

    /* compiled from: Taobao */
    public final class a {
        public fo a;

        public a() {
        }
    }

    public fk(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.c = list;
        this.d = offlineMapManager;
        this.e = context;
        this.a = new boolean[list.size()];
    }

    private boolean a(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    public void b() {
        this.b = 0;
        notifyDataSetChanged();
    }

    public Object getChild(int i, int i2) {
        return null;
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            fo foVar = new fo(this.e, this.d);
            foVar.a(1);
            View a2 = foVar.a();
            aVar.a = foVar;
            a2.setTag(aVar);
            view = a2;
        }
        aVar.a.a(this.c.get(i).getCityList().get(i2));
        return view;
    }

    public int getChildrenCount(int i) {
        if (a(i)) {
            return this.c.get(i).getCityList().size();
        }
        return this.c.get(i).getCityList().size();
    }

    public Object getGroup(int i) {
        return this.c.get(i).getProvinceName();
    }

    public int getGroupCount() {
        int i = this.b;
        return i == -1 ? this.c.size() : i;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) fs.a(this.e, 2130903043, null);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(this.c.get(i).getProvinceName());
        if (this.a[i]) {
            imageView.setImageDrawable(fs.a().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(fs.a().getDrawable(2130837510));
        }
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void onGroupCollapse(int i) {
        this.a[i] = false;
    }

    public void onGroupExpand(int i) {
        this.a[i] = true;
    }

    public void a() {
        this.b = -1;
        notifyDataSetChanged();
    }
}
