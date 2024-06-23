package tb;

import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.lazyimg.TaskListener;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import cn.damai.uikit.image.IImageLoader;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gh0 extends n01<GifCareImageView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private IImageLoader.ImageTicket c;

    /* compiled from: Taobao */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TaskListener a;

        a(TaskListener taskListener) {
            this.a = taskListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "664579458")) {
                ipChange.ipc$dispatch("664579458", new Object[]{this, bVar});
                return;
            }
            gh0.this.b().setImageDrawable(bVar.a);
            this.a.onTaskLoadFinish(gh0.this);
        }
    }

    /* compiled from: Taobao */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TaskListener a;

        b(TaskListener taskListener) {
            this.a = taskListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1634875243")) {
                ipChange.ipc$dispatch("1634875243", new Object[]{this, aVar});
                return;
            }
            this.a.onTaskLoadFinish(gh0.this);
        }
    }

    public gh0(GifCareImageView gifCareImageView, String str) {
        super(gifCareImageView, str);
    }

    @Override // tb.n01
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618734578")) {
            ipChange.ipc$dispatch("618734578", new Object[]{this});
            return;
        }
        try {
            IImageLoader.ImageTicket imageTicket = this.c;
            if (imageTicket != null) {
                imageTicket.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // tb.n01
    public void e(TaskListener taskListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "116389715")) {
            ipChange.ipc$dispatch("116389715", new Object[]{this, taskListener});
        } else if (!d()) {
            if (this.b != null) {
                int a2 = (int) (((float) ((int) (((float) ((DisplayMetrics.getwidthPixels(n42.b(xs0.a())) - (n42.a(xs0.a(), 21.0f) * 2)) - n42.a(xs0.a(), 12.0f))) / 2.0f))) * 1.3333334f);
                int i = a2 > 800 ? 800 : a2;
                this.c = cn.damai.common.image.a.b().load(this.b, i, i, new a(taskListener), new b(taskListener));
                return;
            }
            taskListener.onTaskLoadFinish(this);
        }
    }

    @Override // tb.n01
    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175665993")) {
            ipChange.ipc$dispatch("-1175665993", new Object[]{this});
            return;
        }
        GifCareImageView b2 = b();
        if (b2 != null) {
            if (d()) {
                b2.setImageDrawable(new rv2());
            } else {
                b2.setImageDrawable(xs0.a().getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
            }
        }
    }
}
