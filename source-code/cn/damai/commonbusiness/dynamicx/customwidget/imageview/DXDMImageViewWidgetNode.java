package cn.damai.commonbusiness.dynamicx.customwidget.imageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import java.lang.ref.WeakReference;
import tb.c00;
import tb.c80;
import tb.ht;

/* compiled from: Taobao */
public class DXDMImageViewWidgetNode extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMIMAGEVIEW = 6122288056951898906L;
    public static final long DX_DMIMAGEVIEW_DEFAULTIMAGENAME = 7673813157303070297L;
    public static final String HEIGHT_LIMIT = "heightLimit";
    public static final String TAG = "DXDMImageViewWidgetNode";
    public static final String WIDTH_LIMIT = "widthLimit";
    static LruCache<String, Double> i = new LruCache<>(1024);
    private String a;
    private String b;
    private int c;
    private Drawable d;
    private double e = -1.0d;
    private String f;
    private boolean g;
    private boolean h = true;

    /* compiled from: Taobao */
    public interface ImageLoadListener {
        boolean onHappen(d dVar);
    }

    /* compiled from: Taobao */
    public class a implements ImageLoadListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode.ImageLoadListener
        public boolean onHappen(d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1506825874")) {
                return ((Boolean) ipChange.ipc$dispatch("-1506825874", new Object[]{this, dVar})).booleanValue();
            }
            throw null;
        }
    }

    /* compiled from: Taobao */
    public static class b implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-743664298")) {
                return new DXDMImageViewWidgetNode();
            }
            return (DXWidgetNode) ipChange.ipc$dispatch("-743664298", new Object[]{this, obj});
        }
    }

    /* compiled from: Taobao */
    public static class c {
        private static transient /* synthetic */ IpChange $ipChange;
        public int[] a;
        public String b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        public boolean i() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-523907040")) {
                return this.j;
            }
            return ((Boolean) ipChange.ipc$dispatch("-523907040", new Object[]{this})).booleanValue();
        }

        public boolean j() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1619102648")) {
                return this.f;
            }
            return ((Boolean) ipChange.ipc$dispatch("1619102648", new Object[]{this})).booleanValue();
        }

        public boolean k() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2116753979")) {
                return this.i;
            }
            return ((Boolean) ipChange.ipc$dispatch("-2116753979", new Object[]{this})).booleanValue();
        }
    }

    /* compiled from: Taobao */
    public static class d {
    }

    /* compiled from: Taobao */
    public static class e extends AsyncTask<Void, Void, Drawable> {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private WeakReference<ImageView> b;
        private Context c;

        public e(ImageView imageView, String str) {
            this.b = new WeakReference<>(imageView);
            this.a = str;
            this.c = imageView.getContext().getApplicationContext();
        }

        private int b(Context context, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1286047361")) {
                return ((Integer) ipChange.ipc$dispatch("-1286047361", new Object[]{this, context, str})).intValue();
            } else if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            } else {
                try {
                    return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
                } catch (Exception e) {
                    Log.e(DXDMImageViewWidgetNode.TAG, "getDrawableId exception", e);
                    return 0;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1952050475")) {
                return (Drawable) ipChange.ipc$dispatch("-1952050475", new Object[]{this, voidArr});
            }
            int b2 = b(this.c, this.a);
            if (b2 == 0) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.c.getDrawable(b2);
                } else {
                    drawable = this.c.getResources().getDrawable(b2);
                }
                return drawable;
            } catch (Exception e) {
                Log.e(DXDMImageViewWidgetNode.TAG, "Get layout parser exception", e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-179970173")) {
                ipChange.ipc$dispatch("-179970173", new Object[]{this, drawable});
                return;
            }
            ImageView imageView = this.b.get();
            if (imageView != null) {
                if (this.a.equals((String) imageView.getTag(c80.TAG_CURRENT_IMAGE_NAME))) {
                    imageView.setImageDrawable(drawable);
                    imageView.setTag(c80.TAG_IMAGE_NAME, this.a);
                }
            }
        }
    }

    public DXDMImageViewWidgetNode() {
        setCornerRadius(-1);
        setCornerRadiusLeftBottom(-1);
        setCornerRadiusRightBottom(-1);
        setCornerRadiusRightTop(-1);
        setCornerRadiusLeftTop(-1);
    }

    /* access modifiers changed from: protected */
    public void a(ImageView imageView, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424156972")) {
            ipChange.ipc$dispatch("-424156972", new Object[]{this, imageView, Integer.valueOf(i2)});
        } else if (i2 == 0) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (i2 == 1) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (i2 != 2) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    /* access modifiers changed from: protected */
    public void b(ImageView imageView, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818060052")) {
            ipChange.ipc$dispatch("-818060052", new Object[]{this, imageView, drawable});
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-914969139")) {
            return new DXDMImageViewWidgetNode();
        }
        return (DXWidgetNode) ipChange.ipc$dispatch("-914969139", new Object[]{this, obj});
    }

    /* access modifiers changed from: protected */
    public void c(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234647891")) {
            ipChange.ipc$dispatch("-1234647891", new Object[]{this, imageView, str});
            return;
        }
        imageView.setTag(c80.TAG_CURRENT_IMAGE_NAME, str);
        if (str == null) {
            imageView.setImageDrawable(null);
            imageView.setTag(c80.TAG_IMAGE_NAME, null);
        } else if (!str.equals((String) imageView.getTag(c80.TAG_IMAGE_NAME))) {
            c00.q(new e(imageView, str), new Void[0]);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820247692")) {
            return ((Integer) ipChange.ipc$dispatch("-1820247692", new Object[]{this, Long.valueOf(j)})).intValue();
        } else if (-2989625047271068027L == j) {
            return 1;
        } else {
            return super.getDefaultValueForIntAttr(j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515520327")) {
            ipChange.ipc$dispatch("1515520327", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
            return;
        }
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXDMImageViewWidgetNode) {
            DXDMImageViewWidgetNode dXDMImageViewWidgetNode = (DXDMImageViewWidgetNode) dXWidgetNode;
            this.e = dXDMImageViewWidgetNode.e;
            this.f = dXDMImageViewWidgetNode.f;
            this.b = dXDMImageViewWidgetNode.b;
            this.c = dXDMImageViewWidgetNode.c;
            this.d = dXDMImageViewWidgetNode.d;
            this.g = dXDMImageViewWidgetNode.g;
            this.h = dXDMImageViewWidgetNode.h;
            this.a = dXDMImageViewWidgetNode.a;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850619584")) {
            return (View) ipChange.ipc$dispatch("1850619584", new Object[]{this, context});
        }
        IDXWebImageInterface e2 = DXGlobalCenter.e();
        if (e2 == null) {
            return new RoundImageView(context);
        }
        return e2.buildView(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i7 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2117468607")) {
            ipChange.ipc$dispatch("-2117468607", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i3);
        boolean z2 = a2 != 1073741824;
        if (a3 == 1073741824) {
            z = false;
        }
        if (z2 || z) {
            double d2 = this.e;
            if (d2 <= 0.0d) {
                if (!TextUtils.isEmpty(this.b)) {
                    Double d3 = i.get(this.b);
                    if (d3 != null) {
                        d2 = d3.doubleValue();
                    }
                } else {
                    Drawable drawable = this.d;
                    if (drawable != null) {
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = this.d.getIntrinsicHeight();
                        if (intrinsicHeight > 0) {
                            d2 = ((double) intrinsicWidth) / ((double) intrinsicHeight);
                        }
                    }
                }
            }
            if (!z2 || z) {
                if (!z2 && z) {
                    int size = View.MeasureSpec.getSize(i2);
                    if (d2 > 0.0d) {
                        i7 = size;
                        i6 = (int) (((double) size) / d2);
                    } else {
                        i7 = size;
                    }
                }
                i6 = 0;
            } else {
                i6 = View.MeasureSpec.getSize(i3);
                if (d2 > 0.0d) {
                    i7 = (int) (((double) i6) * d2);
                }
            }
            int max = Math.max(i7, getSuggestedMinimumWidth());
            i4 = Math.max(i6, getSuggestedMinimumHeight());
            i5 = max;
        } else {
            i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            i4 = DXWidgetNode.DXMeasureSpec.b(i3);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i5, i2), DXWidgetNode.resolveSize(i4, i3));
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777640134")) {
            ipChange.ipc$dispatch("-777640134", new Object[]{this, context, view});
        } else if (view != null && (view instanceof RoundImageView)) {
            RoundImageView roundImageView = (RoundImageView) view;
            c cVar = new c();
            a(roundImageView, this.c);
            if (!TextUtils.isEmpty(this.b)) {
                cVar.h = true;
                if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
                    new a();
                }
            } else {
                Drawable drawable = this.d;
                if (drawable != null) {
                    b(roundImageView, drawable);
                } else if (!TextUtils.isEmpty(this.f)) {
                    c(roundImageView, this.f);
                } else {
                    roundImageView.setImageDrawable(null);
                    cVar.h = true;
                }
            }
            if (!TextUtils.isEmpty(this.a)) {
                cVar.i = true;
                cVar.b = this.a;
            }
            if (isNeedSetBackground()) {
                cVar.a = getCornerRadius() > 0 ? new int[]{getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius()} : new int[]{getCornerRadiusLeftTop(), getCornerRadiusRightTop(), getCornerRadiusRightBottom(), getCornerRadiusLeftBottom()};
                cVar.f = true;
            }
            if (isNeedSetBackground()) {
                getBorderColor();
                getBorderWidth();
                cVar.e = true;
                cVar.d = true;
            }
            if (getLayoutWidth() == -2 && getLayoutHeight() != -2) {
                cVar.g = true;
            } else if (getLayoutWidth() != -2 && getLayoutHeight() == -2) {
                cVar.g = true;
            }
            cVar.c = this.g;
            if (getLayoutWidth() == getLayoutHeight() && getLayoutWidth() / 2 <= getCornerRadius()) {
                cVar.j = true;
            }
            DMDXWebImageInterface dMDXWebImageInterface = (DMDXWebImageInterface) DXGlobalCenter.e();
            if (dMDXWebImageInterface != null) {
                dMDXWebImageInterface.setImageWithPlaceHolder(roundImageView, this.b, cVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986503740")) {
            ipChange.ipc$dispatch("1986503740", new Object[]{this, Long.valueOf(j), Double.valueOf(d2)});
        } else if (7594222789952419722L == j) {
            this.e = d2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-613350481")) {
            ipChange.ipc$dispatch("-613350481", new Object[]{this, Long.valueOf(j), Integer.valueOf(i2)});
        } else if (1015096712691932083L == j) {
            this.c = i2;
        } else if (1166125168016292427L == j) {
            if (i2 == 1) {
                z = true;
            }
            this.g = z;
        } else if (-2989625047271068027L == j) {
            if (i2 == 1) {
                z = true;
            }
            this.h = z;
        } else {
            super.onSetIntAttribute(j, i2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3631448")) {
            ipChange.ipc$dispatch("-3631448", new Object[]{this, Long.valueOf(j), obj});
        } else if (18039699017736L == j && (obj instanceof Drawable)) {
            this.d = (Drawable) obj;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308267700")) {
            ipChange.ipc$dispatch("-308267700", new Object[]{this, Long.valueOf(j), str});
        } else if (ht.DXDMCOLORFRAMELAYOUT_IMAGEURL == j) {
            this.b = str;
        } else if (8842287408427345805L == j) {
            this.f = str;
        } else if (j == DX_DMIMAGEVIEW_DEFAULTIMAGENAME) {
            this.a = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148727166")) {
            ipChange.ipc$dispatch("-1148727166", new Object[]{this, view});
        } else if (isNeedSetBackground()) {
            view.setBackgroundColor(getBackGroundColor());
        }
    }
}
