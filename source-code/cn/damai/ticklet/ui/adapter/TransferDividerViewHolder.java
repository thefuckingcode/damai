package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cn.damai.member.R$layout;
import tb.v50;

/* compiled from: Taobao */
public class TransferDividerViewHolder extends ViewHolder {
    public TransferDividerViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.member_divider_layout, (ViewGroup) null));
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, v50.a(context, 10.0f)));
    }
}
