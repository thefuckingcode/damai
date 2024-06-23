package cn.damai.videobrowse;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.videobrowse.fragment.ImageFragment;
import cn.damai.videobrowse.fragment.VideoFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class VideoImageAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<PicInfo> a;
    private List<VideoInfo> b;
    private int c;
    private int d;
    private String e;

    public VideoImageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    private Fragment a(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-479911609")) {
            return ImageFragment.getInstance(this.a.get(i - this.c).getPicUrl());
        }
        return (Fragment) ipChange.ipc$dispatch("-479911609", new Object[]{this, Integer.valueOf(i)});
    }

    private Fragment b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859648985")) {
            return (Fragment) ipChange.ipc$dispatch("-1859648985", new Object[]{this, Integer.valueOf(i)});
        }
        return VideoFragment.getInstance(this.e, this.b.get(i));
    }

    private Fragment c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243374653")) {
            return (Fragment) ipChange.ipc$dispatch("1243374653", new Object[]{this, Integer.valueOf(i)});
        }
        int d2 = d(i);
        if (d2 == 0) {
            return b(i);
        }
        if (d2 == 1) {
            return a(i);
        }
        return null;
    }

    private int d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005468274")) {
            return ((Integer) ipChange.ipc$dispatch("-2005468274", new Object[]{this, Integer.valueOf(i)})).intValue();
        } else if (i < this.c) {
            return 0;
        } else {
            if (this.d <= 0 || i >= getCount()) {
                return -1;
            }
            return 1;
        }
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393482313")) {
            ipChange.ipc$dispatch("-393482313", new Object[]{this});
            return;
        }
        List<VideoInfo> list = this.b;
        if (list == null || list.isEmpty()) {
            this.c = 0;
        } else {
            this.c = this.b.size();
        }
        List<PicInfo> list2 = this.a;
        if (list2 == null || list2.isEmpty()) {
            this.d = 0;
        } else {
            this.d = this.a.size();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1329940359")) {
            return this.c + this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("-1329940359", new Object[]{this})).intValue();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-588472915")) {
            return c(i);
        }
        return (Fragment) ipChange.ipc$dispatch("-588472915", new Object[]{this, Integer.valueOf(i)});
    }

    public VideoImageAdapter(FragmentManager fragmentManager, String str, List<VideoInfo> list, List<PicInfo> list2) {
        this(fragmentManager);
        this.b = list;
        this.a = list2;
        this.e = str;
        e();
    }
}
