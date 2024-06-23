package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.SplitImageSizeCache;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.g91;
import tb.ln2;
import tb.v50;
import tb.vt1;
import tb.xf2;
import tb.zq;

/* compiled from: Taobao */
public class ProjectRichShrinkViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int u;
    private Context a;
    private LinearLayout b = ((LinearLayout) this.itemView.findViewById(R$id.rich_info_container_lv));
    private LinearLayout c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private TextView g;
    private View h;
    private View.OnClickListener i;
    private List<HtmlParserManager.a> j;
    private int k;
    private IRichTextManager l;
    private int m;
    private ViewTreeObserver.OnGlobalLayoutListener n;
    private ViewTreeObserver.OnGlobalLayoutListener o;
    private ViewTreeObserver.OnGlobalLayoutListener p;
    private String q;
    private OnItemExtendInfoItemClickListener r;
    private int s;
    private int t;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1535531936")) {
                ipChange.ipc$dispatch("-1535531936", new Object[]{this, view});
            } else if (ProjectRichShrinkViewHolder.this.r != null) {
                ProjectRichShrinkViewHolder.this.r.onExtendInfoMoreBtnClick(ProjectRichShrinkViewHolder.this.k);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "845782852")) {
                ipChange.ipc$dispatch("845782852", new Object[]{this});
                return;
            }
            ProjectRichShrinkViewHolder.this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: Taobao */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1057133765")) {
                ipChange.ipc$dispatch("1057133765", new Object[]{this});
                return;
            }
            ProjectRichShrinkViewHolder.this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: Taobao */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1268484678")) {
                ipChange.ipc$dispatch("1268484678", new Object[]{this});
                return;
            }
            ProjectRichShrinkViewHolder.this.e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: Taobao */
    public class e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        e(ProjectRichShrinkViewHolder projectRichShrinkViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1925983338")) {
                ipChange.ipc$dispatch("-1925983338", new Object[]{this, dVar});
                return;
            }
            this.a.setImageResource(R$drawable.project_default_image_bg);
        }
    }

    /* compiled from: Taobao */
    public class f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ DMImageStrategyConfig.DMImageCropType e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;
        final /* synthetic */ String h;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1614028238")) {
                    ipChange.ipc$dispatch("-1614028238", new Object[]{this, view});
                } else if (ProjectRichShrinkViewHolder.this.r != null) {
                    OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener = ProjectRichShrinkViewHolder.this.r;
                    int i = ProjectRichShrinkViewHolder.this.k;
                    f fVar = f.this;
                    onItemExtendInfoItemClickListener.onExtendInfoImageItemClick(view, i, fVar.h, fVar.d);
                }
            }
        }

        f(ImageView imageView, int i2, int i3, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i4, boolean z, String str2) {
            this.a = imageView;
            this.b = i2;
            this.c = i3;
            this.d = str;
            this.e = dMImageCropType;
            this.f = i4;
            this.g = z;
            this.h = str2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1825848491")) {
                ipChange.ipc$dispatch("1825848491", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = eVar.a.getIntrinsicHeight();
                int i3 = this.b;
                if (intrinsicWidth > i3 || intrinsicWidth == i3) {
                    i2 = this.c;
                } else {
                    i2 = v50.a(ProjectRichShrinkViewHolder.this.a, (float) intrinsicWidth);
                }
                int i4 = (int) ((((float) (intrinsicHeight * i2)) * 1.0f) / ((float) intrinsicWidth));
                String d2 = SplitImageSizeCache.d(this.d, this.e, this.f);
                if (this.g) {
                    SplitImageSizeCache.ImageSizeCache c2 = SplitImageSizeCache.c(d2);
                    if (!(c2 != null && c2.imgWidth == i2 && c2.imgHeight == i4)) {
                        SplitImageSizeCache.a(d2, new SplitImageSizeCache.ImageSizeCache(d2, i2, i4));
                        ProjectRichShrinkViewHolder.this.y(this.a, i2, i4);
                    }
                } else {
                    SplitImageSizeCache.a(d2, new SplitImageSizeCache.ImageSizeCache(d2, i2, i4));
                    ProjectRichShrinkViewHolder.this.y(this.a, i2, i4);
                }
                this.a.setImageDrawable(eVar.a);
                this.a.setOnClickListener(new a());
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        g(ProjectRichShrinkViewHolder projectRichShrinkViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "35591320")) {
                ipChange.ipc$dispatch("35591320", new Object[]{this, dVar});
                return;
            }
            this.a.setImageResource(R$drawable.project_default_image_bg);
        }
    }

    /* compiled from: Taobao */
    public class h implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ boolean b;
        final /* synthetic */ LinearLayout c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1836933556")) {
                    ipChange.ipc$dispatch("1836933556", new Object[]{this, view});
                } else if (ProjectRichShrinkViewHolder.this.r != null) {
                    OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener = ProjectRichShrinkViewHolder.this.r;
                    int i = ProjectRichShrinkViewHolder.this.k;
                    h hVar = h.this;
                    onItemExtendInfoItemClickListener.onExtendInfoImageItemClick(view, i, hVar.e, hVar.d);
                }
            }
        }

        h(ImageView imageView, boolean z, LinearLayout linearLayout, String str, String str2) {
            this.a = imageView;
            this.b = z;
            this.c = linearLayout;
            this.d = str;
            this.e = str2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "609694765")) {
                ipChange.ipc$dispatch("609694765", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            } else if (this.b) {
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int i2 = intrinsicHeight / 500;
                if (intrinsicHeight % 500 > 0) {
                    i2++;
                }
                this.c.removeAllViews();
                for (int i3 = 0; i3 < i2; i3++) {
                    RoundImageView roundImageView = new RoundImageView(ProjectRichShrinkViewHolder.this.a);
                    roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    roundImageView.setType(1);
                    roundImageView.setBorderRadius(0);
                    roundImageView.setBackgroundResource(R$drawable.project_image_bg);
                    String str = this.d;
                    DMImageStrategyConfig.DMImageCropType dMImageCropType = DMImageStrategyConfig.DMImageCropType.cy500;
                    SplitImageSizeCache.ImageSizeCache c2 = SplitImageSizeCache.c(SplitImageSizeCache.d(str, dMImageCropType, i3));
                    if (c2 != null) {
                        roundImageView.setLayoutParams(new ViewGroup.LayoutParams(c2.imgWidth, c2.imgHeight));
                    }
                    this.c.addView(roundImageView);
                    ProjectRichShrinkViewHolder.this.w(this.d, roundImageView, this.e, dMImageCropType, i3, c2 != null);
                }
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight2 = eVar.a.getIntrinsicHeight();
                if (intrinsicWidth > ProjectRichShrinkViewHolder.this.t || intrinsicWidth == ProjectRichShrinkViewHolder.this.t) {
                    i = ProjectRichShrinkViewHolder.this.s;
                } else {
                    i = v50.a(ProjectRichShrinkViewHolder.this.a, (float) intrinsicWidth);
                }
                ProjectRichShrinkViewHolder.this.y(this.a, i, (int) ((((float) (intrinsicHeight2 * i)) * 1.0f) / ((float) intrinsicWidth)));
                this.a.setImageDrawable(eVar.a);
                this.a.setOnClickListener(new a());
            }
        }
    }

    public ProjectRichShrinkViewHolder(Context context, ViewGroup viewGroup, OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_rich_text_item_layout, viewGroup, false));
        this.a = context;
        u = v50.a(context, 450.0f);
        int a2 = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (v50.a(this.a, 21.0f) * 2);
        this.s = a2;
        this.t = v50.e(this.a, (float) a2);
        this.r = onItemExtendInfoItemClickListener;
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.rich_image_text_ll);
        this.c = linearLayout;
        linearLayout.setVisibility(8);
        TextView textView = (TextView) this.itemView.findViewById(R$id.rich_text_tv);
        this.d = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R$id.rich_text_image_ll);
        this.e = linearLayout2;
        linearLayout2.setVisibility(8);
        this.f = (LinearLayout) this.itemView.findViewById(R$id.rich_more_container_lv);
        this.g = (TextView) this.itemView.findViewById(R$id.project_item_more_text_tv);
        this.h = this.itemView.findViewById(R$id.line);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i = new a();
        x();
    }

    private void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919930555")) {
            ipChange.ipc$dispatch("-919930555", new Object[]{this});
            return;
        }
        this.b.getLayoutParams().width = -1;
        this.b.getLayoutParams().height = -2;
        LinearLayout linearLayout = this.b;
        linearLayout.setLayoutParams(linearLayout.getLayoutParams());
    }

    private void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014355133")) {
            ipChange.ipc$dispatch("1014355133", new Object[]{this});
            return;
        }
        this.g.setText("展开更多");
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.f.setOnClickListener(this.i);
        IRichTextManager iRichTextManager = this.l;
        if (iRichTextManager != null) {
            iRichTextManager.setHasMore(true);
        }
        ln2.r().R1(this.f, this.q);
    }

    private void k(HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467898564")) {
            ipChange.ipc$dispatch("467898564", new Object[]{this, aVar});
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        u(aVar, this.c);
    }

    private void l(HtmlParserManager.a aVar, HtmlParserManager.a aVar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096566591")) {
            ipChange.ipc$dispatch("-1096566591", new Object[]{this, aVar, aVar2});
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        u(aVar, this.c);
        u(aVar2, this.e);
    }

    private void m(HtmlParserManager.a aVar, HtmlParserManager.a aVar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534026581")) {
            ipChange.ipc$dispatch("-1534026581", new Object[]{this, aVar, aVar2});
            return;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(8);
        if (aVar2 != null) {
            this.d.setText(aVar2.a());
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        u(aVar, this.c);
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449458692")) {
            ipChange.ipc$dispatch("449458692", new Object[]{this});
        } else if (xf2.e(this.j) > 0) {
            int q2 = q();
            this.m = q2;
            if (q2 == 1) {
                o(this.j.get(0));
            } else if (q2 == 2) {
                k(this.j.get(0));
            } else {
                HtmlParserManager.a aVar = this.j.get(0);
                HtmlParserManager.a aVar2 = this.j.get(1);
                int i2 = this.m;
                if (i2 == 3) {
                    p(aVar, aVar2);
                } else if (i2 == 4) {
                    m(aVar, aVar2);
                } else if (i2 == 5) {
                    l(aVar, aVar2);
                }
            }
        }
    }

    private void o(HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733251788")) {
            ipChange.ipc$dispatch("-1733251788", new Object[]{this, aVar});
            return;
        }
        this.c.setVisibility(8);
        this.e.setVisibility(8);
        if (aVar != null) {
            this.d.setText(aVar.a());
            this.d.setVisibility(0);
        }
    }

    private void p(HtmlParserManager.a aVar, HtmlParserManager.a aVar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44859697")) {
            ipChange.ipc$dispatch("44859697", new Object[]{this, aVar, aVar2});
            return;
        }
        this.e.setVisibility(0);
        this.c.setVisibility(8);
        if (aVar != null) {
            this.d.setText(aVar.a());
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        u(aVar2, this.e);
    }

    private int q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045219711")) {
            return ((Integer) ipChange.ipc$dispatch("-2045219711", new Object[]{this})).intValue();
        }
        int e2 = xf2.e(this.j);
        if (e2 <= 0) {
            return -1;
        }
        if (e2 == 1) {
            if (this.j.get(0) != null) {
                return this.j.get(0).e();
            }
            return -1;
        } else if (e2 <= 1) {
            return -1;
        } else {
            HtmlParserManager.a aVar = this.j.get(0);
            HtmlParserManager.a aVar2 = this.j.get(1);
            if (aVar == null || aVar2 == null) {
                return -1;
            }
            if (aVar.e() == 1) {
                if (aVar2.e() == 2) {
                    return 3;
                }
                return -1;
            } else if (aVar.e() != 2) {
                return -1;
            } else {
                if (aVar2.e() == 1) {
                    return 4;
                }
                if (aVar2.e() == 2) {
                    return 5;
                }
                return -1;
            }
        }
    }

    private boolean s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935993003")) {
            return ((Boolean) ipChange.ipc$dispatch("-935993003", new Object[]{this})).booleanValue();
        }
        IRichTextManager iRichTextManager = this.l;
        if (iRichTextManager != null) {
            return iRichTextManager.hasMoreRichItems();
        }
        return false;
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009539928")) {
            ipChange.ipc$dispatch("2009539928", new Object[]{this});
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setOnClickListener(null);
    }

    private void u(HtmlParserManager.a aVar, LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734553337")) {
            ipChange.ipc$dispatch("1734553337", new Object[]{this, aVar, linearLayout});
        } else if (aVar != null && aVar.a() != null && linearLayout != null) {
            linearLayout.removeAllViews();
            boolean b2 = vt1.b(aVar.c(), aVar.b());
            boolean d2 = cn.damai.common.image.b.d(aVar.a().toString());
            if (!b2 || !d2) {
                g91.c("RichShrink", "load loadSingleImage " + aVar.a().toString());
                RoundImageView roundImageView = new RoundImageView(this.a);
                roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundImageView.setType(1);
                roundImageView.setBorderRadius(0);
                roundImageView.setBackgroundResource(R$drawable.project_image_bg);
                linearLayout.addView(roundImageView);
                v(aVar, d2, roundImageView, linearLayout);
                return;
            }
            int b3 = aVar.b() / 500;
            if (aVar.b() % 500 > 0) {
                b3++;
            }
            for (int i2 = 0; i2 < b3; i2++) {
                RoundImageView roundImageView2 = new RoundImageView(this.a);
                roundImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                roundImageView2.setType(1);
                roundImageView2.setBorderRadius(0);
                roundImageView2.setBackgroundResource(R$drawable.project_image_bg);
                String obj = aVar.a().toString();
                DMImageStrategyConfig.DMImageCropType dMImageCropType = DMImageStrategyConfig.DMImageCropType.cy500;
                SplitImageSizeCache.ImageSizeCache c2 = SplitImageSizeCache.c(SplitImageSizeCache.d(obj, dMImageCropType, i2));
                if (c2 != null) {
                    roundImageView2.setLayoutParams(new ViewGroup.LayoutParams(c2.imgWidth, c2.imgHeight));
                }
                linearLayout.addView(roundImageView2);
                w(aVar.a().toString(), roundImageView2, aVar.d(), dMImageCropType, i2, c2 != null);
            }
        }
    }

    private void v(HtmlParserManager.a aVar, boolean z, ImageView imageView, LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188613009")) {
            ipChange.ipc$dispatch("-1188613009", new Object[]{this, aVar, Boolean.valueOf(z), imageView, linearLayout});
            return;
        }
        String obj = aVar.a().toString();
        String d2 = aVar.d();
        if (imageView.getTag() instanceof zq) {
            ((zq) imageView.getTag()).cancel();
        }
        DMImageStrategyConfig b2 = cn.damai.common.image.b.b(obj, -1, -1);
        if (b2 != null) {
            b2.b = false;
        }
        DMImageCreator g2 = cn.damai.common.image.a.b().g(obj, b2);
        int i2 = R$drawable.project_default_image_bg;
        imageView.setTag(g2.i(i2).c(i2).h(null, this.s, 16383).n(new h(imageView, z, linearLayout, obj, d2)).e(new g(this, imageView)).f());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void w(String str, ImageView imageView, String str2, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010742489")) {
            ipChange.ipc$dispatch("-2010742489", new Object[]{this, str, imageView, str2, dMImageCropType, Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        g91.c("RichShrink", "hasCache " + z + " index=" + i2 + " url=" + str);
        if (imageView.getTag() instanceof zq) {
            ((zq) imageView.getTag()).cancel();
        }
        int a2 = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (v50.a(this.a, 21.0f) * 2);
        int e2 = v50.e(this.a, (float) a2);
        DMImageStrategyConfig b2 = cn.damai.common.image.b.b(str, -1, -1);
        if (b2 != null) {
            b2.b = false;
            b2.c = true;
            b2.d = dMImageCropType;
            b2.e = i2;
        }
        DMImageCreator g2 = cn.damai.common.image.a.b().g(str, b2);
        int i3 = R$drawable.project_default_image_bg;
        imageView.setTag(g2.i(i3).c(i3).n(new f(imageView, e2, a2, str, dMImageCropType, i2, z, str2)).e(new e(this, imageView)).f());
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-217936570")) {
            ipChange.ipc$dispatch("-217936570", new Object[]{this});
            return;
        }
        ViewTreeObserver viewTreeObserver = this.d.getViewTreeObserver();
        this.n = new b();
        ViewTreeObserver viewTreeObserver2 = this.c.getViewTreeObserver();
        this.o = new c();
        ViewTreeObserver viewTreeObserver3 = this.e.getViewTreeObserver();
        this.p = new d();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.n);
        }
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.addOnGlobalLayoutListener(this.o);
        }
        if (viewTreeObserver3.isAlive()) {
            viewTreeObserver3.addOnGlobalLayoutListener(this.p);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void y(ImageView imageView, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739622483")) {
            ipChange.ipc$dispatch("739622483", new Object[]{this, imageView, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        imageView.getLayoutParams().width = i2;
        imageView.getLayoutParams().height = i3;
        imageView.setLayoutParams(imageView.getLayoutParams());
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684808870")) {
            ipChange.ipc$dispatch("-684808870", new Object[]{this});
            return;
        }
        this.b.getLayoutParams().width = -1;
        this.b.getLayoutParams().height = u;
        LinearLayout linearLayout = this.b;
        linearLayout.setLayoutParams(linearLayout.getLayoutParams());
    }

    public void r(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1299260409")) {
            ipChange.ipc$dispatch("-1299260409", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.q = projectDataHolder.getProjectId();
            this.j = projectDataHolder.getShrinkConvertedItem();
            int shrinkRichType = projectDataHolder.getShrinkRichType();
            this.k = shrinkRichType;
            IRichTextManager richTextManager = this.r.getRichTextManager(shrinkRichType);
            this.l = richTextManager;
            if (richTextManager == null || !richTextManager.overLimitedHeight()) {
                z = false;
            }
            if (z) {
                z();
                B();
            } else if (s()) {
                A();
                B();
            } else {
                A();
                t();
            }
            n();
        }
    }
}
