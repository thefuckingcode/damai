package cn.damai.user.repertoite.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.bean.RepertoireDetailDataBean;
import cn.damai.user.repertoite.ui.GalleryImagesActivity;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.v50;
import tb.wz1;
import tb.zq;

/* compiled from: Taobao */
public class HorizontalImageScrollAdapter extends RecyclerView.Adapter<c> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> a;
    private ArrayList<String> b = new ArrayList<>();
    private Context c;
    private String d = "";
    private String e = "";
    private boolean f;
    int g;
    int h = 97;
    int i = SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean a;
        final /* synthetic */ c b;
        final /* synthetic */ int c;

        /* renamed from: cn.damai.user.repertoite.adapter.HorizontalImageScrollAdapter$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class View$OnClickListenerC0063a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC0063a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "760745028")) {
                    ipChange.ipc$dispatch("760745028", new Object[]{this, view});
                    return;
                }
                Intent intent = new Intent(HorizontalImageScrollAdapter.this.c, GalleryImagesActivity.class);
                intent.putExtra("images", HorizontalImageScrollAdapter.this.b);
                intent.putExtra("location", a.this.c);
                if (HorizontalImageScrollAdapter.this.c != null && !((Activity) HorizontalImageScrollAdapter.this.c).isFinishing()) {
                    HorizontalImageScrollAdapter.this.c.startActivity(intent);
                }
            }
        }

        a(RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean picInfosBean, c cVar, int i) {
            this.a = picInfosBean;
            this.b = cVar;
            this.c = i;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "313019305")) {
                ipChange.ipc$dispatch("313019305", new Object[]{this, dVar});
                return;
            }
            if (this.a.getWidth() == null || this.a.getHeight() == null || Double.valueOf(this.a.getWidth()).doubleValue() <= 0.0d || Double.valueOf(this.a.getHeight()).doubleValue() <= 0.0d) {
                HorizontalImageScrollAdapter horizontalImageScrollAdapter = HorizontalImageScrollAdapter.this;
                int i = (horizontalImageScrollAdapter.g * horizontalImageScrollAdapter.h) / horizontalImageScrollAdapter.i;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.a.getLayoutParams();
                layoutParams.width = i;
                HorizontalImageScrollAdapter horizontalImageScrollAdapter2 = HorizontalImageScrollAdapter.this;
                layoutParams.height = horizontalImageScrollAdapter2.g;
                if (this.c == 0) {
                    layoutParams.leftMargin = v50.a(horizontalImageScrollAdapter2.c, 18.0f);
                } else {
                    layoutParams.leftMargin = v50.a(horizontalImageScrollAdapter2.c, 6.0f);
                }
                if (this.c == HorizontalImageScrollAdapter.this.a.size() - 1) {
                    layoutParams.rightMargin = v50.a(HorizontalImageScrollAdapter.this.c, 18.0f);
                } else {
                    layoutParams.rightMargin = 0;
                }
                this.b.a.setLayoutParams(layoutParams);
            }
            this.b.a.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            this.b.a.setOnClickListener(new View$OnClickListenerC0063a());
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean a;
        final /* synthetic */ c b;
        final /* synthetic */ int c;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1808741371")) {
                    ipChange.ipc$dispatch("-1808741371", new Object[]{this, view});
                    return;
                }
                Intent intent = new Intent(HorizontalImageScrollAdapter.this.c, GalleryImagesActivity.class);
                intent.putExtra("images", HorizontalImageScrollAdapter.this.b);
                intent.putExtra("location", b.this.c);
                if (HorizontalImageScrollAdapter.this.c != null && !((Activity) HorizontalImageScrollAdapter.this.c).isFinishing()) {
                    HorizontalImageScrollAdapter.this.c.startActivity(intent);
                    cn.damai.common.user.c.e().x(wz1.h().o(HorizontalImageScrollAdapter.this.d, HorizontalImageScrollAdapter.this.e, HorizontalImageScrollAdapter.this.f, b.this.c));
                }
            }
        }

        b(RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean picInfosBean, c cVar, int i) {
            this.a = picInfosBean;
            this.b = cVar;
            this.c = i;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-467330434")) {
                ipChange.ipc$dispatch("-467330434", new Object[]{this, eVar});
                return;
            }
            Drawable drawable = eVar.a;
            if (drawable != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (this.a.getWidth() == null || this.a.getHeight() == null || Double.valueOf(this.a.getWidth()).doubleValue() <= 0.0d || Double.valueOf(this.a.getHeight()).doubleValue() <= 0.0d) {
                    int width = (HorizontalImageScrollAdapter.this.g * bitmap.getWidth()) / bitmap.getHeight();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.a.getLayoutParams();
                    layoutParams.width = width;
                    HorizontalImageScrollAdapter horizontalImageScrollAdapter = HorizontalImageScrollAdapter.this;
                    layoutParams.height = horizontalImageScrollAdapter.g;
                    if (this.c == 0) {
                        layoutParams.leftMargin = v50.a(horizontalImageScrollAdapter.c, 18.0f);
                    } else {
                        layoutParams.leftMargin = v50.a(horizontalImageScrollAdapter.c, 6.0f);
                    }
                    if (this.c == HorizontalImageScrollAdapter.this.a.size() - 1) {
                        layoutParams.rightMargin = v50.a(HorizontalImageScrollAdapter.this.c, 18.0f);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    this.b.a.setLayoutParams(layoutParams);
                }
                this.b.a.setImageBitmap(bitmap);
                this.b.a.setOnClickListener(new a());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends RecyclerView.ViewHolder {
        private ImageView a;

        public c(HorizontalImageScrollAdapter horizontalImageScrollAdapter, View view, ImageView imageView) {
            super(view);
            this.a = imageView;
        }
    }

    public HorizontalImageScrollAdapter(Context context, String str, String str2, boolean z) {
        this.g = v50.a(context, 129.0f);
        DisplayMetrics.getwidthPixels(v50.b(context));
        this.c = context;
        this.d = str;
        this.e = str2;
        this.f = z;
        k();
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498514186")) {
            ipChange.ipc$dispatch("-498514186", new Object[]{this});
            return;
        }
        List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list = this.a;
        if (list != null && list.size() > 0) {
            this.b.clear();
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                this.b.add(this.a.get(i2).getPicUrl());
            }
        }
    }

    /* renamed from: g */
    public void onBindViewHolder(c cVar, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699739103")) {
            ipChange.ipc$dispatch("-1699739103", new Object[]{this, cVar, Integer.valueOf(i2)});
            return;
        }
        RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean picInfosBean = this.a.get(i2);
        if (picInfosBean.getWidth() != null && picInfosBean.getHeight() != null && Double.valueOf(picInfosBean.getWidth()).doubleValue() > 0.0d && Double.valueOf(picInfosBean.getHeight()).doubleValue() > 0.0d) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.a.getLayoutParams();
            layoutParams.width = (int) ((((double) this.g) * Double.valueOf(picInfosBean.getWidth()).doubleValue()) / Double.valueOf(picInfosBean.getHeight()).doubleValue());
            layoutParams.height = this.g;
            if (i2 == 0) {
                layoutParams.leftMargin = v50.a(this.c, 18.0f);
            } else {
                layoutParams.leftMargin = v50.a(this.c, 6.0f);
            }
            if (i2 == this.a.size() - 1) {
                layoutParams.rightMargin = v50.a(this.c, 18.0f);
            } else {
                layoutParams.rightMargin = 0;
            }
            cVar.a.setLayoutParams(layoutParams);
        }
        if (cVar.a.getTag() instanceof zq) {
            ((zq) cVar.a.getTag()).cancel();
        }
        cVar.a.setOnClickListener(null);
        cVar.a.setTag(cn.damai.common.image.a.b().c(picInfosBean.getPicUrl()).i(R$drawable.uikit_default_image_bg_gradient).n(new b(picInfosBean, cVar, i2)).e(new a(picInfosBean, cVar, i2)).f());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102996314")) {
            return ((Integer) ipChange.ipc$dispatch("-102996314", new Object[]{this})).intValue();
        }
        List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: h */
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9529355")) {
            return (c) ipChange.ipc$dispatch("-9529355", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        RoundImageView roundImageView = new RoundImageView(viewGroup.getContext());
        roundImageView.setBorderRadius(3);
        roundImageView.setType(1);
        relativeLayout.addView(roundImageView);
        return new c(this, relativeLayout, roundImageView);
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573202887")) {
            ipChange.ipc$dispatch("1573202887", new Object[]{this, str});
            return;
        }
        this.d = str;
    }

    public void j(List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370771364")) {
            ipChange.ipc$dispatch("1370771364", new Object[]{this, list});
            return;
        }
        this.a = list;
        k();
    }

    public HorizontalImageScrollAdapter(Context context, String str, String str2, boolean z, List<RepertoireDetailDataBean.RepertoireInfoBean.StoryPicsInfoBean.PicInfosBean> list) {
        this.g = v50.a(context, 129.0f);
        DisplayMetrics.getwidthPixels(v50.b(context));
        this.c = context;
        this.d = str;
        this.a = list;
        this.e = str2;
        this.f = z;
        k();
    }
}
