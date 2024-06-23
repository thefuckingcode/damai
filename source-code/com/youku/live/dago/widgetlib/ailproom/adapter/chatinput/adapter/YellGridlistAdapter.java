package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.manager.BaseInfoBean;
import com.youku.live.dago.widgetlib.ailproom.utils.DensityUtil;
import java.util.ArrayList;
import java.util.List;
import tb.tp1;
import tb.vp1;

/* compiled from: Taobao */
public class YellGridlistAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BaseInfoBean> data = new ArrayList();
    private int mColumnNum = 4;
    private Context mContext;
    private int mItemHeight = (DensityUtil.getScreenHeight() / this.mColumnNum);
    private OnYellItemClickListener mListener;
    private boolean mShowGif = false;
    private List<Integer> mUserIndex;

    /* compiled from: Taobao */
    public interface OnYellItemClickListener {
        void onItemClick(int i, BaseInfoBean baseInfoBean);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View yellContainer;
        public ImageView yellImage;

        public ViewHolder(View view) {
            super(view);
            this.yellImage = (ImageView) view.findViewById(R.id.yell_image);
            this.yellContainer = view.findViewById(R.id.yell_icon_container);
        }
    }

    public YellGridlistAdapter(Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111103611")) {
            return ((Integer) ipChange.ipc$dispatch("-1111103611", new Object[]{this})).intValue();
        }
        List<BaseInfoBean> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnYellItemClickListener onYellItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019328578")) {
            ipChange.ipc$dispatch("2019328578", new Object[]{this, onYellItemClickListener});
            return;
        }
        this.mListener = onYellItemClickListener;
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195760161")) {
            ipChange.ipc$dispatch("-1195760161", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        List<BaseInfoBean> list = this.data;
        if (list != null && list.size() >= i) {
            final YellInfoBean yellInfoBean = (YellInfoBean) this.data.get(i);
            View view = viewHolder.yellContainer;
            int i2 = this.mItemHeight;
            view.setLayoutParams(new RelativeLayout.LayoutParams(i2, i2));
            if (yellInfoBean != null) {
                String str = yellInfoBean.url;
                if (!this.mShowGif) {
                    str = str + "?x-oss-process=image/format,jpg";
                }
                viewHolder.yellImage.setOnClickListener(new View.OnClickListener() {
                    /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellGridlistAdapter.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1927657942")) {
                            ipChange.ipc$dispatch("1927657942", new Object[]{this, view});
                        } else if (YellGridlistAdapter.this.mListener != null) {
                            YellGridlistAdapter.this.mListener.onItemClick(i, yellInfoBean);
                        }
                    }
                });
                vp1 s = tp1.o().s(str);
                int i3 = R.drawable.dago_pgc_chat_expression_default_bg;
                s.H(i3).k(i3).y(viewHolder.yellImage);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2109960265")) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dago_pgc_yell_item, (ViewGroup) null));
        }
        return (ViewHolder) ipChange.ipc$dispatch("-2109960265", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    public YellGridlistAdapter(Context context, List<BaseInfoBean> list) {
        this.data = list;
        this.mContext = context;
    }

    public YellGridlistAdapter(Context context, List<BaseInfoBean> list, int i, boolean z) {
        this.data = list;
        this.mContext = context;
        this.mItemHeight = i;
        this.mShowGif = z;
    }
}
