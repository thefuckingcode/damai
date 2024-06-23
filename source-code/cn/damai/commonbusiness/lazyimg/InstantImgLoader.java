package cn.damai.commonbusiness.lazyimg;

import android.view.View;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.n01;

/* compiled from: Taobao */
public class InstantImgLoader extends ImgLoader implements TaskListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private HashMap<View, n01> a = new HashMap<>();

    @Override // cn.damai.commonbusiness.lazyimg.ImgLoader
    public void a(n01 n01) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346486155")) {
            ipChange.ipc$dispatch("-346486155", new Object[]{this, n01});
        } else if (n01 != null && n01.c()) {
            GifCareImageView b = n01.b();
            n01 remove = this.a.remove(b);
            if (remove != null) {
                remove.a();
            }
            this.a.put(b, n01);
            n01.f();
            n01.e(this);
        }
    }

    @Override // cn.damai.commonbusiness.lazyimg.TaskListener
    public void onTaskLoadFinish(n01 n01) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301676980")) {
            ipChange.ipc$dispatch("-1301676980", new Object[]{this, n01});
        } else if (n01 != null) {
            this.a.remove(n01.b());
        }
    }
}
