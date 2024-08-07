package cn.damai.user.userprofile.cuser.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.user.userprofile.cuser.bean.CommonFavObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.gt2;
import tb.tb2;
import tb.v50;
import tb.zq;

/* compiled from: Taobao */
public class CommonFavAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<CommonFavObject> a;
    private Context b;

    /* compiled from: Taobao */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView a;
        public TextView b;
        public View c;

        public ViewHolder(View view, ImageView imageView, TextView textView, View view2) {
            super(view);
            this.a = imageView;
            this.b = textView;
            this.c = view2;
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommonFavObject a;
        final /* synthetic */ int b;

        a(CommonFavObject commonFavObject, int i) {
            this.a = commonFavObject;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1158792531")) {
                ipChange.ipc$dispatch("-1158792531", new Object[]{this, view});
            } else if (this.a.status != 1) {
                Bundle bundle = new Bundle();
                try {
                    bundle.putLong(IssueConstants.ProjectID, Long.parseLong(this.a.id));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                tb2.a(CommonFavAdapter.this.b, this.a.schema, bundle);
                CommonFavAdapter.this.d(this.b, this.a.id);
            }
        }
    }

    public CommonFavAdapter(Context context, List<CommonFavObject> list) {
        this.b = context;
        this.a = list;
    }

    /* renamed from: b */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781502593")) {
            ipChange.ipc$dispatch("-1781502593", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        CommonFavObject commonFavObject = this.a.get(i);
        if (viewHolder.a.getTag() instanceof zq) {
            ((zq) viewHolder.a.getTag()).cancel();
        }
        DMImageCreator k = cn.damai.common.image.a.b().c(commonFavObject.pic).k(new DMRoundedCornersBitmapProcessor(v50.a(this.b, 3.0f), 0));
        int i2 = R$drawable.uikit_default_image_bg_gradient;
        viewHolder.a.setTag(k.i(i2).c(i2).g(viewHolder.a));
        viewHolder.a.setOnClickListener(new a(commonFavObject, i));
        viewHolder.b.setText(commonFavObject.name);
        if (commonFavObject.status == 1) {
            viewHolder.c.setVisibility(0);
        } else {
            viewHolder.c.setVisibility(8);
        }
    }

    /* renamed from: c */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123220119")) {
            return (ViewHolder) ipChange.ipc$dispatch("2123220119", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(v50.a(this.b, 90.0f), -2);
        layoutParams.setMargins(0, 0, v50.a(this.b, 18.0f), 0);
        layoutParams.gravity = 1;
        linearLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(v50.a(this.b, 90.0f), v50.a(this.b, 120.0f));
        ImageView imageView = new ImageView(viewGroup.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(v50.a(this.b, 90.0f), v50.a(this.b, 120.0f));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(imageView, layoutParams3);
        imageView.setBackgroundResource(R$drawable.uikit_default_image_bg_gradient);
        TextView textView = new TextView(viewGroup.getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, v50.a(this.b, 18.0f));
        textView.setBackgroundResource(R$drawable.bg_item_vccount);
        textView.setPadding(v50.a(this.b, 6.0f), 0, v50.a(this.b, 6.0f), 0);
        textView.setText("已下架");
        textView.setGravity(17);
        textView.setTextSize(11.0f);
        textView.setTextColor(this.b.getResources().getColor(R$color.color_ffffff));
        textView.setVisibility(8);
        relativeLayout.addView(textView, layoutParams4);
        linearLayout.addView(relativeLayout, layoutParams2);
        TextView textView2 = new TextView(viewGroup.getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, v50.a(this.b, 40.0f));
        layoutParams5.setMargins(0, v50.a(this.b, 12.0f), 0, 0);
        textView2.setMaxLines(2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextSize(14.0f);
        textView2.setTextColor(viewGroup.getResources().getColor(R$color.color_111111));
        textView.setGravity(17);
        textView2.setLayoutParams(layoutParams5);
        textView2.setText("项目名");
        linearLayout.addView(textView2);
        return new ViewHolder(linearLayout, imageView, textView2, textView);
    }

    public void d(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "816448349")) {
            ipChange.ipc$dispatch("816448349", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", "");
        hashMap.put("item_id", str);
        hashMap.put("contentlabel", "");
        b bVar = new b();
        c.e().x(bVar.e(gt2.USER_HOME_PAGE, "taste", "project_" + i, hashMap, Boolean.TRUE));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-754911652")) {
            return this.a.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-754911652", new Object[]{this})).intValue();
    }
}
