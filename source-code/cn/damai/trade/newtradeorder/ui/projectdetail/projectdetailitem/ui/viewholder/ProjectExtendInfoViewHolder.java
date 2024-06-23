package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import tb.v50;
import tb.vt1;
import tb.zq;

/* compiled from: Taobao */
public class ProjectExtendInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private RoundImageView c;
    private LinearLayout d;
    private Context e;
    private HtmlParserManager.a f;
    private int g;
    private int h;
    private int i;
    private IRichTextManager j;
    private int k;
    private int l;
    private int m;
    private int n;
    private OnItemExtendInfoItemClickListener o;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(ProjectExtendInfoViewHolder projectExtendInfoViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1751653237")) {
                ipChange.ipc$dispatch("1751653237", new Object[]{this, dVar});
                return;
            }
            this.a.setImageResource(R$drawable.project_default_image_bg);
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1921072431")) {
                    ipChange.ipc$dispatch("-1921072431", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.o != null) {
                    ProjectExtendInfoViewHolder.this.o.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.g, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "319818")) {
                ipChange.ipc$dispatch("319818", new Object[]{this, eVar});
            } else if (eVar == null || eVar.a == null) {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            } else {
                ProjectExtendInfoViewHolder.this.d.setVisibility(8);
                ProjectExtendInfoViewHolder.this.c.setVisibility(0);
                int intrinsicWidth = eVar.a.getIntrinsicWidth();
                int intrinsicHeight = eVar.a.getIntrinsicHeight();
                if (intrinsicWidth > ProjectExtendInfoViewHolder.this.n || intrinsicWidth == ProjectExtendInfoViewHolder.this.n) {
                    i = ProjectExtendInfoViewHolder.this.m;
                } else {
                    i = v50.a(ProjectExtendInfoViewHolder.this.e, (float) intrinsicWidth);
                }
                ProjectExtendInfoViewHolder.this.c.getLayoutParams().width = i;
                ProjectExtendInfoViewHolder.this.c.getLayoutParams().height = (int) ((((float) (intrinsicHeight * i)) * 1.0f) / ((float) intrinsicWidth));
                ProjectExtendInfoViewHolder.this.c.setImageDrawable(eVar.a);
                ProjectExtendInfoViewHolder.this.c.setOnClickListener(new a());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        c(ProjectExtendInfoViewHolder projectExtendInfoViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581739401")) {
                ipChange.ipc$dispatch("-581739401", new Object[]{this, dVar});
                return;
            }
            this.a.setImageResource(R$drawable.project_default_image_bg);
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ DMImageStrategyConfig.DMImageCropType e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1529889363")) {
                    ipChange.ipc$dispatch("1529889363", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.o != null) {
                    ProjectExtendInfoViewHolder.this.o.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.g, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        d(ImageView imageView, int i, int i2, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i3, boolean z) {
            this.a = imageView;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = dMImageCropType;
            this.f = i3;
            this.g = z;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1215833908")) {
                ipChange.ipc$dispatch("-1215833908", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = eVar.a.getIntrinsicHeight();
                int i2 = this.b;
                if (intrinsicWidth > i2 || intrinsicWidth == i2) {
                    i = this.c;
                } else {
                    i = v50.a(ProjectExtendInfoViewHolder.this.e, (float) intrinsicWidth);
                }
                int i3 = (int) ((((float) (intrinsicHeight * i)) * 1.0f) / ((float) intrinsicWidth));
                String d2 = SplitImageSizeCache.d(this.d, this.e, this.f);
                if (this.g) {
                    SplitImageSizeCache.ImageSizeCache c2 = SplitImageSizeCache.c(d2);
                    if (!(c2 != null && c2.imgWidth == i && c2.imgHeight == i3)) {
                        SplitImageSizeCache.a(d2, new SplitImageSizeCache.ImageSizeCache(d2, i, i3));
                        this.a.getLayoutParams().width = i;
                        this.a.getLayoutParams().height = i3;
                        this.a.requestLayout();
                    }
                } else {
                    SplitImageSizeCache.a(d2, new SplitImageSizeCache.ImageSizeCache(d2, i, i3));
                    this.a.getLayoutParams().width = i;
                    this.a.getLayoutParams().height = i3;
                    this.a.requestLayout();
                }
                this.a.setImageDrawable(eVar.a);
                this.a.setOnClickListener(new a());
            }
        }
    }

    public ProjectExtendInfoViewHolder(Context context, ViewGroup viewGroup, OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_detail_introduce_item_layout, viewGroup, false));
        this.e = context;
        this.o = onItemExtendInfoItemClickListener;
        int a2 = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()) - (v50.a(this.e, 21.0f) * 2);
        this.m = a2;
        this.n = v50.e(this.e, (float) a2);
        n();
    }

    private void i(HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439931808")) {
            ipChange.ipc$dispatch("-1439931808", new Object[]{this, aVar});
        } else if (aVar != null) {
            q();
            this.b.setVisibility(8);
            boolean b2 = vt1.b(aVar.c(), aVar.b());
            boolean d2 = cn.damai.common.image.b.d(aVar.a().toString());
            if (!b2 || !d2) {
                o(this.c, aVar);
                return;
            }
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            this.d.removeAllViews();
            int b3 = aVar.b() / 500;
            if (aVar.b() % 500 > 0) {
                b3++;
            }
            for (int i2 = 0; i2 < b3; i2++) {
                RoundImageView roundImageView = new RoundImageView(this.e);
                roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundImageView.setType(1);
                roundImageView.setBorderRadius(0);
                String obj = aVar.a().toString();
                DMImageStrategyConfig.DMImageCropType dMImageCropType = DMImageStrategyConfig.DMImageCropType.cy500;
                SplitImageSizeCache.ImageSizeCache c2 = SplitImageSizeCache.c(SplitImageSizeCache.d(obj, dMImageCropType, i2));
                if (c2 != null) {
                    roundImageView.setLayoutParams(new ViewGroup.LayoutParams(c2.imgWidth, c2.imgHeight));
                }
                this.d.addView(roundImageView);
                p(roundImageView, aVar.a().toString(), dMImageCropType, i2, c2 != null);
            }
        }
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004820848")) {
            ipChange.ipc$dispatch("-2004820848", new Object[]{this});
            return;
        }
        HtmlParserManager.a aVar = this.f;
        if (aVar != null) {
            k(aVar.e());
        }
    }

    private void k(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105584397")) {
            ipChange.ipc$dispatch("-2105584397", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 1) {
            l(this.f.a());
        } else if (i2 == 2) {
            i(this.f);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    private void l(Spanned spanned) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528580727")) {
            ipChange.ipc$dispatch("-528580727", new Object[]{this, spanned});
            return;
        }
        q();
        this.b.setVisibility(0);
        if (this.k < this.l - 1) {
            this.b.setText(spanned);
        } else if (spanned != null && !TextUtils.isEmpty(spanned.toString().trim())) {
            this.b.setText(r(spanned.toString().trim().toCharArray()));
        }
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.j(this.b.getMeasuredHeight());
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012448432")) {
            ipChange.ipc$dispatch("-2012448432", new Object[]{this});
            return;
        }
        this.a = this.itemView.findViewById(R$id.line);
        TextView textView = (TextView) this.itemView.findViewById(R$id.project_item_detail_intro_text_tv);
        this.b = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        RoundImageView roundImageView = (RoundImageView) this.itemView.findViewById(R$id.project_item_detail_intro_image_iv);
        this.c = roundImageView;
        roundImageView.setBorderRadius(0);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.rich_text_image_ll);
    }

    private void o(ImageView imageView, HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308755981")) {
            ipChange.ipc$dispatch("308755981", new Object[]{this, imageView, aVar});
            return;
        }
        String obj = aVar.a().toString();
        if (imageView != null) {
            if (imageView.getTag() instanceof zq) {
                ((zq) imageView.getTag()).cancel();
            }
            DMImageStrategyConfig b2 = cn.damai.common.image.b.b(obj, -1, -1);
            if (b2 != null) {
                b2.b = false;
            }
            DMImageCreator h2 = cn.damai.common.image.a.b().g(obj, b2).h(null, this.m, 16383);
            int i2 = R$drawable.project_default_image_bg;
            imageView.setTag(h2.i(i2).c(i2).n(new b(imageView)).e(new a(this, imageView)).f());
        }
    }

    private void p(ImageView imageView, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1446893842")) {
            ipChange.ipc$dispatch("-1446893842", new Object[]{this, imageView, str, dMImageCropType, Integer.valueOf(i2), Boolean.valueOf(z)});
        } else if (imageView != null) {
            if (imageView.getTag() instanceof zq) {
                ((zq) imageView.getTag()).cancel();
            }
            int a2 = DisplayMetrics.getwidthPixels(this.e.getResources().getDisplayMetrics()) - (v50.a(this.e, 21.0f) * 2);
            int e2 = v50.e(this.e, (float) a2);
            DMImageStrategyConfig b2 = cn.damai.common.image.b.b(str, -1, -1);
            if (b2 != null) {
                b2.b = false;
                b2.c = true;
                b2.d = dMImageCropType;
                b2.e = i2;
            }
            DMImageCreator g2 = cn.damai.common.image.a.b().g(str, b2);
            int i3 = R$drawable.project_default_image_bg;
            imageView.setTag(g2.i(i3).c(i3).n(new d(imageView, e2, a2, str, dMImageCropType, i2, z)).e(new c(this, imageView)).f());
        }
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537473527")) {
            ipChange.ipc$dispatch("-1537473527", new Object[]{this});
            return;
        }
        int i2 = this.i;
        if (i2 <= 0) {
            return;
        }
        if (i2 == 1 || this.h == 0) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public void m(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478622698")) {
            ipChange.ipc$dispatch("478622698", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.f = projectDataHolder.getConvertedItem();
            this.g = projectDataHolder.getRichType();
            this.h = projectDataHolder.getConvertedItemPosition();
            this.j = this.o.getRichTextManager(this.g);
            this.i = projectDataHolder.getConvertedItemSize();
            this.k = projectDataHolder.getConvertedItemPosition();
            this.l = projectDataHolder.getConvertedItemSize();
            j();
        }
    }

    public String r(char[] cArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185768533")) {
            return (String) ipChange.ipc$dispatch("185768533", new Object[]{this, cArr});
        }
        int length = cArr.length;
        while (length > 0 && cArr[length - 1] == '\n') {
            length--;
        }
        int length2 = cArr.length;
        String valueOf = String.valueOf(cArr);
        return length < length2 ? valueOf.substring(0, length) : valueOf;
    }
}
