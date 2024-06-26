package cn.damai.commonbusiness.fission;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.commonbusiness.fission.bean.FissionViewPagerBean;
import cn.damai.commonbusiness.fission.view.FissionContentView;
import cn.damai.commonbusiness.fission.view.FissionImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class FissionViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CONTENT_TYPR = "content_type";
    public static final String IMAVE_TYPR = "image_type";
    private Context a;
    private List<FissionViewPagerBean> b = new ArrayList();
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private View f;

    public FissionViewPagerAdapter(Context context) {
        this.a = context;
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1090009721")) {
            return this.e;
        }
        return ((Integer) ipChange.ipc$dispatch("-1090009721", new Object[]{this})).intValue();
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-261881220")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("-261881220", new Object[]{this})).intValue();
    }

    public View c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-109912861")) {
            return this.f;
        }
        return (View) ipChange.ipc$dispatch("-109912861", new Object[]{this});
    }

    public void d(List<FissionViewPagerBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357997391")) {
            ipChange.ipc$dispatch("1357997391", new Object[]{this, list});
            return;
        }
        this.b = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963156445")) {
            ipChange.ipc$dispatch("-963156445", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        viewGroup.removeView((View) obj);
    }

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489500515")) {
            ipChange.ipc$dispatch("1489500515", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.e = i;
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468506202")) {
            ipChange.ipc$dispatch("-468506202", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1563128954")) {
            return this.b.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1563128954", new Object[]{this})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096670919")) {
            return ((Integer) ipChange.ipc$dispatch("1096670919", new Object[]{this, obj})).intValue();
        } else if (this.c > 0) {
            return -2;
        } else {
            return super.getItemPosition(obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: cn.damai.commonbusiness.fission.view.FissionImageView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        FissionContentView fissionContentView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234494619")) {
            return ipChange.ipc$dispatch("1234494619", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        FissionViewPagerBean fissionViewPagerBean = this.b.get(i);
        if (i == 0) {
            FissionImageView fissionImageView = new FissionImageView(this.a);
            fissionImageView.update(fissionViewPagerBean, b(), a(), i);
            fissionContentView = fissionImageView;
        } else {
            FissionContentView fissionContentView2 = new FissionContentView(this.a);
            fissionContentView2.update(fissionViewPagerBean, b(), a(), i);
            fissionContentView = fissionContentView2;
        }
        fissionContentView.setId(i);
        viewGroup.addView(fissionContentView);
        return fissionContentView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-571258742")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("-571258742", new Object[]{this, view, obj})).booleanValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703140603")) {
            ipChange.ipc$dispatch("1703140603", new Object[]{this});
            return;
        }
        this.c = getCount();
        super.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200501363")) {
            ipChange.ipc$dispatch("200501363", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        this.f = (View) obj;
    }
}
