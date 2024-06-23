package cn.damai.comment.view;

import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$color;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.bean.DmInfo;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.phenix.bitmap.b;
import com.youku.resource.utils.CircleBorderBitmapProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.uv1;
import tb.v50;

/* compiled from: Taobao */
public final class PublishDMSelectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemClickListener a;
    @NotNull
    private final ImageView b;
    @NotNull
    private final CheckBox c;
    @NotNull
    private final TextView d;
    @Nullable
    private DmInfo e;
    @Nullable
    private Drawable f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishDMSelectViewHolder(@NotNull View view, @Nullable OnItemClickListener onItemClickListener) {
        super(view);
        k21.i(view, "itemView");
        this.a = onItemClickListener;
        View findViewById = view.findViewById(R$id.iv_dm_head);
        k21.h(findViewById, "itemView.findViewById(R.id.iv_dm_head)");
        ImageView imageView = (ImageView) findViewById;
        this.b = imageView;
        View findViewById2 = view.findViewById(R$id.cb_dm_select);
        k21.h(findViewById2, "itemView.findViewById(R.id.cb_dm_select)");
        CheckBox checkBox = (CheckBox) findViewById2;
        this.c = checkBox;
        View findViewById3 = view.findViewById(R$id.tv_dm_name);
        k21.h(findViewById3, "itemView.findViewById(R.id.tv_dm_name)");
        this.d = (TextView) findViewById3;
        view.setOnClickListener(new uv1(this));
        checkBox.setClickable(false);
        this.f = new BitmapDrawable(new CircleBorderBitmapProcessor((float) v50.a(imageView.getContext(), 1.0f), ColorStateList.valueOf(imageView.getResources().getColor(R$color.color_D8D8D8))).process("", new b(), BitmapFactory.decodeResource(checkBox.getResources(), R$drawable.dm_profile_placeholder)));
    }

    /* access modifiers changed from: private */
    public static final void b(PublishDMSelectViewHolder publishDMSelectViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631889952")) {
            ipChange.ipc$dispatch("-631889952", new Object[]{publishDMSelectViewHolder, view});
            return;
        }
        k21.i(publishDMSelectViewHolder, "this$0");
        OnItemClickListener onItemClickListener = publishDMSelectViewHolder.a;
        if (onItemClickListener != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            onItemClickListener.onItemClick(view, publishDMSelectViewHolder.getLayoutPosition(), publishDMSelectViewHolder.e);
        }
    }

    public final void c(@NotNull DmInfo dmInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "17257204")) {
            ipChange.ipc$dispatch("17257204", new Object[]{this, dmInfo, Boolean.valueOf(z)});
            return;
        }
        k21.i(dmInfo, DMShareMessage.KEY_EVALUATE_DMINFO);
        this.e = dmInfo;
        a.b().c(dmInfo.dmHeadImageUrl).j(this.f).d(this.f).k(new CircleBorderBitmapProcessor((float) v50.a(this.b.getContext(), 1.0f), ColorStateList.valueOf(this.b.getResources().getColor(R$color.color_D8D8D8)))).g(this.b);
        this.d.setText(dmInfo.dmName);
        this.c.setChecked(z);
    }
}
