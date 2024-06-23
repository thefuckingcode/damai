package tb;

import cn.damai.commonbusiness.lazyimg.TaskListener;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class n01<T extends GifCareImageView> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VIDEO_UNDER_REVIEW_URL = "VIDEO_UNDER_REVIEW_URL";
    protected final T a;
    protected final String b;

    public n01(T t, String str) {
        this.a = t;
        this.b = str;
    }

    public abstract void a();

    public T b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1744970712")) {
            return this.a;
        }
        return (T) ((GifCareImageView) ipChange.ipc$dispatch("1744970712", new Object[]{this}));
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1825874848")) {
            return this.a != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("1825874848", new Object[]{this})).booleanValue();
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140318530")) {
            return ((Boolean) ipChange.ipc$dispatch("1140318530", new Object[]{this})).booleanValue();
        }
        String str = this.b;
        return str != null && str.contains("VIDEO_UNDER_REVIEW_URL");
    }

    public abstract void e(TaskListener taskListener);

    public abstract void f();

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197905328")) {
            return (String) ipChange.ipc$dispatch("-197905328", new Object[]{this});
        }
        return this.a.hashCode() + " " + this.b;
    }
}
