package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.trade.R$drawable;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectPicAndVideo;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class ProjectPicAndVideoAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectPicAndVideo> b = new ArrayList();
    private OnHeadClickListener c;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1116561433")) {
                ipChange.ipc$dispatch("1116561433", new Object[]{this, view});
            } else if (ProjectPicAndVideoAdapter.this.c != null) {
                ProjectPicAndVideoAdapter.this.c.onVideoClick(this.a);
            }
        }
    }

    public ProjectPicAndVideoAdapter(Context context, List<ProjectPicAndVideo> list, OnHeadClickListener onHeadClickListener) {
        this.a = context;
        this.b = list;
        this.c = onHeadClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160022526")) {
            ipChange.ipc$dispatch("160022526", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-97417835")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("-97417835", new Object[]{this})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678907380")) {
            return ((Integer) ipChange.ipc$dispatch("-678907380", new Object[]{this, obj})).intValue();
        } else if (getCount() > 0) {
            return -2;
        } else {
            return super.getItemPosition(obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230983456")) {
            return ipChange.ipc$dispatch("-230983456", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (this.b.get(i) == null) {
            return null;
        } else {
            ImageView imageView = new ImageView(this.a);
            imageView.setImageResource(R$drawable.uikit_default_image_bg_grey);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            cn.damai.common.image.a.b().c(this.b.get(i).url).i(R$drawable.transparent_bg).c(R$drawable.ip_video_cover_black).g(imageView);
            viewGroup.addView(imageView);
            imageView.setOnClickListener(new a(i));
            return imageView;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "850446159")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("850446159", new Object[]{this, view, obj})).booleanValue();
    }
}
