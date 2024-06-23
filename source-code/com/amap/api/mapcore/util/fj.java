package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class fj extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    List<OfflineMapProvince> a = new ArrayList();
    private boolean[] b;
    private Context c;
    private fo d;
    private List<OfflineMapProvince> e = new ArrayList();
    private fq f;
    private OfflineMapManager g;

    /* compiled from: Taobao */
    public final class a {
        public fo a;

        public a() {
        }
    }

    public fj(Context context, fq fqVar, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.c = context;
        this.f = fqVar;
        this.g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.e.clear();
            this.e.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.e) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.a.add(offlineMapProvince);
                }
            }
        }
        this.b = new boolean[this.a.size()];
    }

    public void b() {
        try {
            for (int size = this.a.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.a.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.a.remove(offlineMapProvince);
                }
            }
            this.b = new boolean[this.a.size()];
            notifyDataSetChanged();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Object getChild(int i, int i2) {
        return this.a.get(i).getDownloadedCityList().get(i2);
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
            fo foVar = new fo(this.c, this.g);
            this.d = foVar;
            foVar.a(2);
            view = this.d.a();
            aVar.a = this.d;
            view.setTag(aVar);
        }
        OfflineMapProvince offlineMapProvince = this.a.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            final OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i2);
            aVar.a.a(offlineMapCity);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.amap.api.mapcore.util.fj.AnonymousClass1 */

                public void onClick(View view) {
                    fj.this.f.a(offlineMapCity);
                }
            });
        }
        return view;
    }

    public int getChildrenCount(int i) {
        return this.a.get(i).getDownloadedCityList().size();
    }

    public Object getGroup(int i) {
        return this.a.get(i).getProvinceName();
    }

    public int getGroupCount() {
        return this.a.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) fs.a(this.c, 2130903043, null);
        }
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        ((TextView) view.findViewById(2131165201)).setText(this.a.get(i).getProvinceName());
        if (this.b[i]) {
            imageView.setImageDrawable(fs.a().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(fs.a().getDrawable(2130837510));
        }
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void onGroupCollapse(int i) {
        this.b[i] = false;
    }

    public void onGroupExpand(int i) {
        this.b[i] = true;
    }

    public void a() {
        for (OfflineMapProvince offlineMapProvince : this.e) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.a.contains(offlineMapProvince)) {
                this.a.add(offlineMapProvince);
            }
        }
        this.b = new boolean[this.a.size()];
        notifyDataSetChanged();
    }
}
