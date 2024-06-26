package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import tb.v50;
import tb.vt1;
import tb.yt1;
import tb.zq;

/* compiled from: Taobao */
public class ProjectExtendInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b = ((FrameLayout) this.itemView);
    private TextView c;
    private RoundImageView d;
    private LinearLayout e = ((LinearLayout) this.itemView.findViewById(R$id.rich_text_image_ll));
    private HtmlParserManager.a f;
    private int g;
    private int h;
    private yt1 i;
    private OnExtendInfoImageItemClickListener j;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(ProjectExtendInfoViewHolder projectExtendInfoViewHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1592845539")) {
                ipChange.ipc$dispatch("-1592845539", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1836188793")) {
                    ipChange.ipc$dispatch("1836188793", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.j != null) {
                    ProjectExtendInfoViewHolder.this.j.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        b(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1337490702")) {
                ipChange.ipc$dispatch("-1337490702", new Object[]{this, eVar});
            } else if (eVar != null && (drawable = eVar.a) != null) {
                ProjectExtendInfoViewHolder.this.l(this.a, (int) (((float) eVar.a.getIntrinsicHeight()) * ((((float) this.a) * 1.0f) / ((float) drawable.getIntrinsicWidth()))));
                try {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) eVar.a;
                    animatedImageDrawable.w();
                    this.b.setImageDrawable(animatedImageDrawable);
                } catch (Exception unused) {
                    this.b.setImageDrawable(eVar.a);
                }
                this.b.setOnClickListener(new a());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c(ProjectExtendInfoViewHolder projectExtendInfoViewHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "368729119")) {
                ipChange.ipc$dispatch("368729119", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "992183291")) {
                    ipChange.ipc$dispatch("992183291", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.j != null) {
                    ProjectExtendInfoViewHolder.this.j.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        d(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1741322868")) {
                ipChange.ipc$dispatch("1741322868", new Object[]{this, eVar});
            } else if (eVar != null && (drawable = eVar.a) != null) {
                float intrinsicWidth = (((float) this.a) * 1.0f) / ((float) drawable.getIntrinsicWidth());
                this.b.getLayoutParams().width = this.a;
                this.b.getLayoutParams().height = (int) (((float) eVar.a.getIntrinsicHeight()) * intrinsicWidth);
                try {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) eVar.a;
                    animatedImageDrawable.w();
                    this.b.setImageDrawable(animatedImageDrawable);
                } catch (Exception unused) {
                    this.b.setImageDrawable(eVar.a);
                }
                this.b.setOnClickListener(new a());
            }
        }
    }

    public ProjectExtendInfoViewHolder(Context context, ViewGroup viewGroup, OnExtendInfoImageItemClickListener onExtendInfoImageItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_detail_introduce_item_layout, viewGroup, false));
        this.a = context;
        this.j = onExtendInfoImageItemClickListener;
        TextView textView = (TextView) this.itemView.findViewById(R$id.project_item_detail_intro_text_tv);
        this.c = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        RoundImageView roundImageView = (RoundImageView) this.itemView.findViewById(R$id.project_item_detail_intro_image_iv);
        this.d = roundImageView;
        roundImageView.setBorderRadius(0);
    }

    private void d(HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309451704")) {
            ipChange.ipc$dispatch("309451704", new Object[]{this, aVar});
            return;
        }
        m();
        this.c.setVisibility(8);
        if (!vt1.b(aVar.c(), aVar.b())) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            i(this.d, aVar.a().toString());
            return;
        }
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.e.removeAllViews();
        int b2 = aVar.b() / 500;
        if (aVar.b() % 500 > 0) {
            b2++;
        }
        for (int i2 = 0; i2 < b2; i2++) {
            RoundImageView roundImageView = new RoundImageView(this.a);
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            roundImageView.setType(1);
            roundImageView.setBorderRadius(0);
            this.e.setBackgroundResource(R$drawable.project_image_bg);
            this.e.addView(roundImageView);
            j(roundImageView, aVar.a().toString(), DMImageStrategyConfig.DMImageCropType.cy500, i2);
        }
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030113816")) {
            ipChange.ipc$dispatch("-2030113816", new Object[]{this});
            return;
        }
        HtmlParserManager.a aVar = this.f;
        if (aVar != null) {
            f(aVar.e());
        }
    }

    private void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186886731")) {
            ipChange.ipc$dispatch("186886731", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 1) {
            g(this.f.a());
        } else if (i2 == 2) {
            d(this.f);
        } else {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    private void g(Spanned spanned) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948897073")) {
            ipChange.ipc$dispatch("1948897073", new Object[]{this, spanned});
            return;
        }
        this.c.setVisibility(0);
        this.c.setText(spanned);
        this.d.setVisibility(8);
        this.f.j(this.c.getMeasuredHeight());
        m();
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
    }

    private void i(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615429172")) {
            ipChange.ipc$dispatch("-615429172", new Object[]{this, imageView, str});
        } else if (imageView != null) {
            if (imageView.getTag() instanceof zq) {
                ((zq) imageView.getTag()).cancel();
            }
            int a2 = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (v50.a(this.a, 21.0f) * 2);
            DMImageStrategyConfig b2 = cn.damai.common.image.b.b(str, -1, -1);
            if (b2 != null) {
                b2.b = false;
            }
            DMImageCreator g2 = cn.damai.common.image.a.b().g(str, b2);
            int i2 = R$drawable.project_default_image_bg;
            imageView.setTag(g2.i(i2).c(i2).n(new b(a2, imageView)).e(new a(this)).f());
        }
    }

    private void j(ImageView imageView, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307128048")) {
            ipChange.ipc$dispatch("1307128048", new Object[]{this, imageView, str, dMImageCropType, Integer.valueOf(i2)});
        } else if (imageView != null) {
            if (imageView.getTag() instanceof zq) {
                ((zq) imageView.getTag()).cancel();
            }
            int a2 = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (v50.a(this.a, 21.0f) * 2);
            DMImageStrategyConfig b2 = cn.damai.common.image.b.b(str, -1, -1);
            if (b2 != null) {
                b2.b = false;
                b2.c = true;
                b2.d = dMImageCropType;
                b2.e = i2;
            }
            DMImageCreator g2 = cn.damai.common.image.a.b().g(str, b2);
            int i3 = R$drawable.project_default_image_bg;
            imageView.setTag(g2.i(i3).c(i3).n(new d(a2, imageView)).e(new c(this)).f());
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039253312")) {
            ipChange.ipc$dispatch("1039253312", new Object[]{this});
            return;
        }
        int e2 = this.f.e();
        int h2 = this.i.h(this.g);
        if (e2 == 2) {
            if (h2 == 2) {
                FrameLayout frameLayout = this.b;
                frameLayout.setPadding(frameLayout.getPaddingLeft(), v50.a(this.a, 18.0f), this.b.getPaddingRight(), 0);
                return;
            }
            FrameLayout frameLayout2 = this.b;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), v50.a(this.a, 8.0f), this.b.getPaddingRight(), 0);
        } else if (e2 != 1) {
        } else {
            if (h2 == 2) {
                FrameLayout frameLayout3 = this.b;
                frameLayout3.setPadding(frameLayout3.getPaddingLeft(), v50.a(this.a, 18.0f), this.b.getPaddingRight(), 0);
                return;
            }
            FrameLayout frameLayout4 = this.b;
            frameLayout4.setPadding(frameLayout4.getPaddingLeft(), 0, this.b.getPaddingRight(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558945746")) {
            ipChange.ipc$dispatch("-558945746", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.d.getLayoutParams().width = i2;
        this.d.getLayoutParams().height = i3;
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873960881")) {
            ipChange.ipc$dispatch("873960881", new Object[]{this});
            return;
        }
        int i2 = this.h;
        int a2 = v50.a(this.a, 21.0f);
        if (i2 <= 0) {
            return;
        }
        if (i2 == 1) {
            FrameLayout frameLayout = this.b;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), 0, this.b.getPaddingRight(), a2);
            return;
        }
        int i3 = this.g;
        if (i3 == i2 - 1) {
            k();
            FrameLayout frameLayout2 = this.b;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), v50.a(this.a, 36.0f));
        } else if (i3 == 0) {
            FrameLayout frameLayout3 = this.b;
            frameLayout3.setPadding(frameLayout3.getPaddingLeft(), 0, this.b.getPaddingRight(), 0);
        } else {
            k();
        }
    }

    public void h(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203340910")) {
            ipChange.ipc$dispatch("-203340910", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.f = projectDataHolder.getConvertedItem();
            this.g = projectDataHolder.getConvertedItemPosition();
            this.i = this.j.getProjectExtendInfoManager();
            this.h = projectDataHolder.getConvertedItemSize();
            e();
        }
    }
}
