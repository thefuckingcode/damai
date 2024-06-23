package cn.damai.commonbusiness.dynamicx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import cn.damai.common.AppConfig;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.dynamicx.customwidget.imageview.DMDXWebImageInterface;
import cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode;
import cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout.DXDMScrollLayoutWidgetNode;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DXDMPicConvertViewWidgetNode;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.a;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.f;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.IDXAppMonitor;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.weex.common.Constants;
import java.io.Serializable;
import tb.eq;
import tb.fq;
import tb.g91;
import tb.gt;
import tb.hq;
import tb.ht;
import tb.hx;
import tb.it;
import tb.jt;
import tb.kt;
import tb.ku;
import tb.lt;
import tb.lu;
import tb.mt;
import tb.mu;
import tb.nt;
import tb.nu;
import tb.ot;
import tb.ou;
import tb.pu;
import tb.qt;
import tb.qu;
import tb.rt;
import tb.ru;
import tb.st;
import tb.su;
import tb.tt;
import tb.tu;
import tb.ut;
import tb.uu;
import tb.v50;
import tb.vt;
import tb.ww;
import tb.xf2;
import tb.xp;
import tb.xs0;
import tb.xt;
import tb.yt;

/* compiled from: Taobao */
public class DynamicXInit {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class ImgStateRecord implements Serializable {
        public boolean isShouldUseDefault;

        public ImgStateRecord(boolean z) {
            this.isShouldUseDefault = z;
        }
    }

    /* compiled from: Taobao */
    public class a implements DMDXWebImageInterface {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.commonbusiness.dynamicx.DynamicXInit$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0016a implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C0016a(a aVar, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "275876484")) {
                    ipChange.ipc$dispatch("275876484", new Object[]{this, eVar});
                    return;
                }
                Drawable drawable = eVar.a;
                if (drawable != null) {
                    this.a.setImageDrawable(drawable);
                }
            }
        }

        /* compiled from: Taobao */
        public class b implements DMImageCreator.DMImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ DXDMImageViewWidgetNode.c a;
            final /* synthetic */ ImageView b;

            b(a aVar, DXDMImageViewWidgetNode.c cVar, ImageView imageView) {
                this.a = cVar;
                this.b = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.d dVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1105066289")) {
                    ipChange.ipc$dispatch("1105066289", new Object[]{this, dVar});
                } else if (this.a.k()) {
                    hq.b(this.b, this.a.b, new ImgStateRecord(true));
                }
            }
        }

        /* compiled from: Taobao */
        public class c implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImgStateRecord a;
            final /* synthetic */ ImageView b;

            c(a aVar, ImgStateRecord imgStateRecord, ImageView imageView) {
                this.a = imgStateRecord;
                this.b = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-940277242")) {
                    ipChange.ipc$dispatch("-940277242", new Object[]{this, eVar});
                    return;
                }
                Drawable drawable = eVar.a;
                if (drawable != null) {
                    this.a.isShouldUseDefault = false;
                    hq.a = true;
                    this.b.setImageDrawable(drawable);
                }
            }
        }

        a() {
        }

        @Override // com.taobao.android.dinamicx.widget.IDXWebImageInterface
        public ImageView buildView(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2076446273")) {
                return (ImageView) ipChange.ipc$dispatch("-2076446273", new Object[]{this, context});
            }
            RoundImageView roundImageView = new RoundImageView(context);
            roundImageView.setType(1);
            roundImageView.setBorderRadius(0);
            return roundImageView;
        }

        @Override // com.taobao.android.dinamicx.widget.IDXWebImageInterface
        public void setImage(ImageView imageView, String str, DXImageWidgetNode.c cVar) {
            DMImageCreator dMImageCreator;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1957313351")) {
                ipChange.ipc$dispatch("-1957313351", new Object[]{this, imageView, str, cVar});
                return;
            }
            if (xf2.j(str) || !str.contains("?optParams=")) {
                dMImageCreator = cn.damai.common.image.a.b().c(str);
            } else {
                int[] f = DynamicXInit.f(str);
                dMImageCreator = cn.damai.common.image.a.b().f(DynamicXInit.g(str), f[0], f[1]);
            }
            if (cVar.m()) {
                imageView.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            }
            if (cVar.l()) {
                ((RoundImageView) imageView).setBorderRadius(v50.e(imageView.getContext(), (float) cVar.a[0]));
            }
            dMImageCreator.n(new C0016a(this, imageView));
            dMImageCreator.f();
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.imageview.DMDXWebImageInterface
        public void setImageWithPlaceHolder(ImageView imageView, String str, DXDMImageViewWidgetNode.c cVar) {
            DMImageCreator dMImageCreator;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-670335442")) {
                ipChange.ipc$dispatch("-670335442", new Object[]{this, imageView, str, cVar});
                return;
            }
            if (xf2.j(str) || !str.contains("?optParams=")) {
                dMImageCreator = cn.damai.common.image.a.b().c(str);
            } else {
                int[] f = DynamicXInit.f(str);
                dMImageCreator = cn.damai.common.image.a.b().f(DynamicXInit.g(str), f[0], f[1]);
            }
            ImgStateRecord imgStateRecord = new ImgStateRecord(true);
            if (cVar.k()) {
                hq.b(imageView, cVar.b, imgStateRecord);
            }
            if (cVar.j()) {
                int[] iArr = cVar.a;
                if (cVar.i()) {
                    ((RoundImageView) imageView).setType(0);
                } else {
                    ((RoundImageView) imageView).setBorderRadius(v50.e(imageView.getContext(), (float) iArr[0]));
                }
            }
            dMImageCreator.n(new c(this, imgStateRecord, imageView)).e(new b(this, cVar, imageView));
            dMImageCreator.f();
        }
    }

    public static IDXAppMonitor c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2009300106") ? (IDXAppMonitor) ipChange.ipc$dispatch("-2009300106", new Object[0]) : new eq();
    }

    public static DXLongSparseArray<IDXEventHandler> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655361033")) {
            return (DXLongSparseArray) ipChange.ipc$dispatch("655361033", new Object[0]);
        }
        DXLongSparseArray<IDXEventHandler> dXLongSparseArray = new DXLongSparseArray<>();
        dXLongSparseArray.put(gt.DX_EVENT_DMAUTOJUMP, new gt());
        return dXLongSparseArray;
    }

    private static IDXWebImageInterface e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1080750527") ? (IDXWebImageInterface) ipChange.ipc$dispatch("1080750527", new Object[0]) : new a();
    }

    /* access modifiers changed from: private */
    public static int[] f(String str) {
        int i;
        Exception e;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244724723")) {
            return (int[]) ipChange.ipc$dispatch("-244724723", new Object[]{str});
        }
        String replace = str.substring(str.indexOf("?optParams=")).replace("?optParams=", "");
        int i3 = -1;
        if (replace.contains(Constants.Name.X)) {
            String[] split = replace.split(Constants.Name.X);
            if (xp.a(split) == 2 && !xf2.j(split[0]) && !xf2.j(split[1])) {
                try {
                    i2 = Integer.parseInt(split[0]);
                } catch (Exception e2) {
                    e = e2;
                    i2 = -1;
                    g91.a(e.getMessage());
                    i3 = i2;
                    i = -1;
                    return new int[]{i3, i};
                }
                try {
                    i = Integer.parseInt(split[1]);
                    i3 = i2;
                } catch (Exception e3) {
                    e = e3;
                    g91.a(e.getMessage());
                    i3 = i2;
                    i = -1;
                    return new int[]{i3, i};
                }
                return new int[]{i3, i};
            }
        }
        i = -1;
        return new int[]{i3, i};
    }

    /* access modifiers changed from: private */
    public static String g(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-111892535")) {
            return str.substring(0, str.indexOf("?optParams="));
        }
        return (String) ipChange.ipc$dispatch("-111892535", new Object[]{str});
    }

    public static DXLongSparseArray<IDXDataParser> h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641378678")) {
            return (DXLongSparseArray) ipChange.ipc$dispatch("641378678", new Object[0]);
        }
        DXLongSparseArray<IDXDataParser> dXLongSparseArray = new DXLongSparseArray<>();
        dXLongSparseArray.put(tu.DX_PARSER_DMTRANSFERARRAY, new tu());
        dXLongSparseArray.put(pu.DX_PARSER_DMOSTYPE, new pu());
        dXLongSparseArray.put(uu.DX_PARSER_DMTRANSFERSTRING, new uu());
        dXLongSparseArray.put(ww.DX_PARSER_TOCOMPUTEPX, new ww());
        dXLongSparseArray.put(ku.DX_PARSER_DMADAPTIVEHEIGHT, new ku());
        dXLongSparseArray.put(mu.DX_PARSER_DMISH5, new mu());
        dXLongSparseArray.put(su.DX_PARSER_DMTOWEBP, new su());
        dXLongSparseArray.put(nu.DX_PARSER_DXDATAPARSERDMMERGE, new nu());
        dXLongSparseArray.put(qu.DX_PARSER_DMRANDOMEQUAL, new qu());
        dXLongSparseArray.put(ou.DX_PARSER_DMNUMBERFORMAT, new ou());
        dXLongSparseArray.put(lu.DX_PARSER_DMINDEX, new lu());
        dXLongSparseArray.put(ru.DX_PARSER_DMSUBARRAY, new ru());
        return dXLongSparseArray;
    }

    public static IDXRemoteDebugLog i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1474117847") ? (IDXRemoteDebugLog) ipChange.ipc$dispatch("1474117847", new Object[0]) : new fq();
    }

    private static DXLongSparseArray<IDXBuilderWidgetNode> j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "906630299")) {
            return (DXLongSparseArray) ipChange.ipc$dispatch("906630299", new Object[0]);
        }
        DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray = new DXLongSparseArray<>();
        dXLongSparseArray.put(kt.DX_DMFRAMELAYOUT, new kt.a());
        dXLongSparseArray.put(xt.DX_DMTEXTVIEW, new xt.a());
        dXLongSparseArray.put(mt.DX_DMHOMECARDTAGVIEW, new mt.a());
        dXLongSparseArray.put(ht.DX_DMCOLORFRAMELAYOUT, new ht.a());
        dXLongSparseArray.put(DXDMScrollLayoutWidgetNode.DX_DMSCROLLLAYOUT, new DXDMScrollLayoutWidgetNode.a());
        dXLongSparseArray.put(qt.DX_DMICONFONTVIEW, new qt.a());
        dXLongSparseArray.put(lt.DXDMGRADUALCOLORTEXTVIEW_DMGRADUALCOLORTEXTVIEW, new lt.a());
        dXLongSparseArray.put(vt.DX_DMTAPFRAMELAYOUT, new vt.a());
        dXLongSparseArray.put(DXDMImageViewWidgetNode.DX_DMIMAGEVIEW, new DXDMImageViewWidgetNode.b());
        dXLongSparseArray.put(jt.DX_DMDASHVIEW, new jt.a());
        dXLongSparseArray.put(nt.DXDMHOMEGRABTICKETNOTICEVIEW_DMHOMEGRABTICKETNOTICEVIEW, new nt.a());
        dXLongSparseArray.put(cn.damai.commonbusiness.dynamicx.customwidget.temp.a.DX_DMCOUNTDOWNVIEW, new a.C0017a());
        dXLongSparseArray.put(ut.DX_DMSELLTEXTVIEW, new ut.a());
        dXLongSparseArray.put(ot.DXDMHOMEMARKETADVIEW_DMHOMEMARKETADVIEW, new ot());
        dXLongSparseArray.put(tt.DXDMSCALEANIMATIONVIEW_DMSCALEANIMATIONVIEW, new tt());
        dXLongSparseArray.put(st.DXDMPROJECTSTATUSTAGVIEW_DMPROJECTSTATUSTAGVIEW, new st());
        dXLongSparseArray.put(it.DXDMCOMMENTSCOREVIEW_DMCOMMENTSCOREVIEW, new it());
        dXLongSparseArray.put(rt.DXDMLIVEANIMVIEW_DMLIVEANIMVIEW, new rt());
        dXLongSparseArray.put(hx.DXDMIMAGEANIMVIEW_DMIMAGEANIMVIEW, new hx());
        dXLongSparseArray.put(yt.DXDMVIEWFLIPPER_DMVIEWFLIPPER, new yt());
        dXLongSparseArray.put(DXDMPicConvertViewWidgetNode.DXDMPICCONVERTVIEW_DMPICCONVERTVIEW, new DXDMPicConvertViewWidgetNode());
        return dXLongSparseArray;
    }

    public static void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173634525")) {
            ipChange.ipc$dispatch("-173634525", new Object[0]);
            return;
        }
        f.b bVar = new f.b();
        bVar.B(e());
        bVar.z(j());
        bVar.x(h());
        bVar.y(d());
        bVar.w(AppConfig.v());
        bVar.v(c());
        bVar.A(i());
        DinamicXEngine.w(xs0.a(), bVar.u());
    }
}
