package cn.damai.common.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import tb.qg0;
import tb.ug2;
import tb.vp1;
import tb.yz2;
import tb.zq;

/* compiled from: Taobao */
public class DMImageCreator {
    private static transient /* synthetic */ IpChange $ipChange;
    private Object a;
    private vp1 b;
    private DMImageSuccListener c;
    private DMImageFailListener d;

    /* compiled from: Taobao */
    public interface DMImageFailListener {
        void onFail(d dVar);
    }

    /* compiled from: Taobao */
    public interface DMImageMemCacheMissListener {
        void onCacheMiss(c cVar);
    }

    /* compiled from: Taobao */
    public interface DMImageSuccListener {
        void onSuccess(e eVar);
    }

    /* compiled from: Taobao */
    public class a implements IPhenixListener<ug2> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1409254332")) {
                return ((Boolean) ipChange.ipc$dispatch("-1409254332", new Object[]{this, ug2})).booleanValue();
            }
            e eVar = new e(DMImageCreator.this);
            eVar.a = ug2.f();
            eVar.b = ug2.f().getBitmap();
            DMImageCreator.this.c.onSuccess(eVar);
            return true;
        }
    }

    /* compiled from: Taobao */
    public class b implements IPhenixListener<qg0> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public boolean onHappen(qg0 qg0) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1880475487")) {
                return ((Boolean) ipChange.ipc$dispatch("-1880475487", new Object[]{this, qg0})).booleanValue();
            }
            d dVar = new d(DMImageCreator.this);
            dVar.a = qg0.f();
            DMImageCreator.this.d.onFail(dVar);
            if (!TextUtils.isEmpty(qg0.b())) {
                try {
                    yz2.g("DMImageCreator" + ":jsondata={appVersion:" + AppConfig.q() + ",resultCode:" + dVar.a + ",url:" + qg0.b() + ",message:" + qg0.e() + "}", StaticsUtil.PLAY_CODE_101, "图片加载失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    public class c {
    }

    /* compiled from: Taobao */
    public class d {
        public int a;

        public d(DMImageCreator dMImageCreator) {
        }
    }

    /* compiled from: Taobao */
    public class e {
        public Drawable a;
        public Bitmap b;

        public e(DMImageCreator dMImageCreator) {
        }
    }

    public DMImageCreator c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753634047")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-753634047", new Object[]{this, Integer.valueOf(i)});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.k(i);
        }
        return this;
    }

    public DMImageCreator d(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623869036")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-623869036", new Object[]{this, drawable});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.l(drawable);
        }
        return this;
    }

    public DMImageCreator e(DMImageFailListener dMImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333772380")) {
            return (DMImageCreator) ipChange.ipc$dispatch("333772380", new Object[]{this, dMImageFailListener});
        }
        this.d = dMImageFailListener;
        vp1 vp1 = this.b;
        if (!(vp1 == null || dMImageFailListener == null)) {
            vp1.m(new b());
        }
        return this;
    }

    public zq f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840819468")) {
            return (zq) ipChange.ipc$dispatch("-840819468", new Object[]{this});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            return new zq(vp1.n());
        }
        return null;
    }

    public zq g(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487877674")) {
            return (zq) ipChange.ipc$dispatch("-487877674", new Object[]{this, imageView});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            return new zq(vp1.y(imageView));
        }
        return null;
    }

    public DMImageCreator h(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609428642")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-1609428642", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.B(view, i, i2);
        }
        return this;
    }

    public DMImageCreator i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238035766")) {
            return (DMImageCreator) ipChange.ipc$dispatch("238035766", new Object[]{this, Integer.valueOf(i)});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.H(i);
        }
        return this;
    }

    public DMImageCreator j(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153646273")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-1153646273", new Object[]{this, drawable});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.I(drawable);
        }
        return this;
    }

    public DMImageCreator k(BitmapProcessor... bitmapProcessorArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045381593")) {
            return (DMImageCreator) ipChange.ipc$dispatch("1045381593", new Object[]{this, bitmapProcessorArr});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.h(bitmapProcessorArr);
        }
        return this;
    }

    public DMImageCreator l(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816801232")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-816801232", new Object[]{this, obj});
        }
        this.a = obj;
        if (obj instanceof vp1) {
            this.b = (vp1) obj;
        }
        return this;
    }

    public DMImageCreator m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803307021")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-803307021", new Object[]{this});
        }
        vp1 vp1 = this.b;
        if (vp1 != null) {
            vp1.P();
        }
        return this;
    }

    public DMImageCreator n(DMImageSuccListener dMImageSuccListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58308516")) {
            return (DMImageCreator) ipChange.ipc$dispatch("58308516", new Object[]{this, dMImageSuccListener});
        }
        this.c = dMImageSuccListener;
        vp1 vp1 = this.b;
        if (!(vp1 == null || dMImageSuccListener == null)) {
            vp1.Q(new a());
        }
        return this;
    }
}
