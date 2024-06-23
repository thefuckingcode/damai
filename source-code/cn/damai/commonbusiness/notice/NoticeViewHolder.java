package cn.damai.commonbusiness.notice;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.a;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.uikit.view.FixImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gr;
import tb.k21;
import tb.s50;
import tb.tj1;

/* compiled from: Taobao */
public final class NoticeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private TextView a;
    @NotNull
    private TextView b;
    @NotNull
    private TextView c;
    @NotNull
    private LinearLayout d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoticeViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.notice_list_title);
        k21.h(findViewById, "itemView.findViewById(R.id.notice_list_title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.notice_list_time);
        k21.h(findViewById2, "itemView.findViewById(R.id.notice_list_time)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.notice_list_content);
        k21.h(findViewById3, "itemView.findViewById(R.id.notice_list_content)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.notice_list_imgcontent);
        k21.h(findViewById4, "itemView.findViewById(R.id.notice_list_imgcontent)");
        this.d = (LinearLayout) findViewById4;
    }

    /* access modifiers changed from: private */
    public static final void c(String str, NoticeViewHolder noticeViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973018239")) {
            ipChange.ipc$dispatch("-1973018239", new Object[]{str, noticeViewHolder, view});
            return;
        }
        k21.i(str, "$url");
        k21.i(noticeViewHolder, "this$0");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(str);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putString("projectId", String.valueOf(noticeViewHolder.getItemId()));
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", 0);
        DMNav.from(noticeViewHolder.itemView.getContext()).withExtras(bundle).toUri(gr.e());
    }

    public final void b(@Nullable ItemContent itemContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747727903")) {
            ipChange.ipc$dispatch("747727903", new Object[]{this, itemContent});
        } else if (itemContent != null) {
            this.a.setVisibility(8);
            if (!TextUtils.isEmpty(itemContent.getRootTitle())) {
                this.a.setText(itemContent.getRootTitle());
                this.a.setVisibility(0);
            }
            this.b.setVisibility(8);
            if (!TextUtils.isEmpty(itemContent.getPerformName())) {
                TextView textView = this.b;
                textView.setText("· " + itemContent.getPerformName());
                this.b.setVisibility(0);
            }
            this.c.setVisibility(8);
            if (!TextUtils.isEmpty(itemContent.getContent())) {
                this.c.setText(itemContent.getContent());
                this.c.setVisibility(0);
            }
            LinearLayout linearLayout = this.d;
            linearLayout.removeAllViews();
            ArrayList<String> imageUrlList = itemContent.getImageUrlList();
            if (imageUrlList != null) {
                for (T t : imageUrlList) {
                    FixImageView fixImageView = new FixImageView(this.itemView.getContext());
                    linearLayout.addView(fixImageView);
                    ViewGroup.LayoutParams layoutParams = fixImageView.getLayoutParams();
                    k21.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, s50.a(this.itemView.getContext(), 3.0f));
                    a.b().c(t).g(fixImageView);
                    fixImageView.setOnClickListener(new tj1(t, this));
                }
            }
        }
    }
}
