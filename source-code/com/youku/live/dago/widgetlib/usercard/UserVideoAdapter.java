package com.youku.live.dago.widgetlib.usercard;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.view.usercard.RatioImageView;
import com.youku.live.dago.widgetlib.view.usercard.UserCardVideo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class UserVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_HORIZONTAL = 2;
    public static final int TYPE_VERTICAL = 1;
    private ItemClickListener mClickListener;
    private Context mContext;
    private View mHeaderView;
    private List<UserCardVideo> mVideoList;

    /* compiled from: Taobao */
    static class HorizontalViewHolder extends UserVideoViewHolder {
        private static float horizontalRatio = 1.78f;

        public HorizontalViewHolder(View view) {
            super(view);
            this.ivCover.setScaleRadio(horizontalRatio);
        }
    }

    /* compiled from: Taobao */
    public interface ItemClickListener {
        void onClickHome(long j);

        void onClickVideo(String str);
    }

    /* compiled from: Taobao */
    static class UserCardHeaderViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        public UserCardHeaderViewHolder(View view) {
            super(view);
            this.itemView = view;
        }
    }

    /* compiled from: Taobao */
    static class UserVideoViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView ivComment;
        RatioImageView ivCover;
        TextView tvCommentsNum = ((TextView) this.itemView.findViewById(R.id.tv_user_card_item_comment_num));
        TextView tvDuration = ((TextView) this.itemView.findViewById(R.id.tv_user_card_item_duration));
        TextView tvName = ((TextView) this.itemView.findViewById(R.id.tv_user_card_item_name));
        TextView tvTime = ((TextView) this.itemView.findViewById(R.id.tv_user_card_item_time));

        public UserVideoViewHolder(View view) {
            super(view);
            this.itemView = view;
            this.ivComment = (ImageView) view.findViewById(R.id.iv_user_card_comment);
            RatioImageView ratioImageView = (RatioImageView) this.itemView.findViewById(R.id.iv_user_card_video_cover);
            this.ivCover = ratioImageView;
            ratioImageView.setScaleType(RatioImageView.ImageScaleType.WIDTH);
        }
    }

    /* compiled from: Taobao */
    static class VerticalViewHolder extends UserVideoViewHolder {
        private static float verticalRatio = 0.75f;

        public VerticalViewHolder(View view) {
            super(view);
            this.ivCover.setScaleRadio(verticalRatio);
        }
    }

    public UserVideoAdapter(Context context, List<UserCardVideo> list) {
        this.mContext = context;
        this.mVideoList = list;
        if (list == null) {
            this.mVideoList = new ArrayList();
        }
    }

    public void addHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "25830178")) {
            ipChange.ipc$dispatch("25830178", new Object[]{this, view});
            return;
        }
        this.mHeaderView = view;
    }

    public void addVideos(List<UserCardVideo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674836699")) {
            ipChange.ipc$dispatch("674836699", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            int size = this.mVideoList.size();
            this.mVideoList.addAll(list);
            notifyItemRangeInserted(size, list.size());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-892845708")) {
            return this.mVideoList.size() + 1;
        }
        return ((Integer) ipChange.ipc$dispatch("-892845708", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<UserCardVideo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54485531")) {
            return ((Integer) ipChange.ipc$dispatch("54485531", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (this.mHeaderView == null || (list = this.mVideoList) == null) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return list.get(i - 1).verticalStyle ? 1 : 2;
    }

    public int getRealPosition(RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1102342147")) {
            return viewHolder.getLayoutPosition() - 1;
        }
        return ((Integer) ipChange.ipc$dispatch("-1102342147", new Object[]{this, viewHolder})).intValue();
    }

    public List<UserCardVideo> getVideos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1484353326")) {
            return this.mVideoList;
        }
        return (List) ipChange.ipc$dispatch("-1484353326", new Object[]{this});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        r7 = r5.mVideoList.get(getRealPosition(r6));
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        List<UserCardVideo> list;
        final UserCardVideo userCardVideo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887431429")) {
            ipChange.ipc$dispatch("1887431429", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (getItemViewType(i) != 0 && (list = this.mVideoList) != null && list.size() >= i && userCardVideo != null) {
            UserVideoViewHolder userVideoViewHolder = (UserVideoViewHolder) viewHolder;
            if (TextUtils.isEmpty(userCardVideo.img)) {
                userVideoViewHolder.ivCover.setImageBitmap(null);
            } else {
                DagoImageLoader.getInstance().showDefault(this.mContext, userCardVideo.img, userVideoViewHolder.ivCover);
            }
            if (TextUtils.isEmpty(userCardVideo.totalComment) || "0".equals(userCardVideo.totalComment)) {
                userVideoViewHolder.tvCommentsNum.setVisibility(8);
                userVideoViewHolder.ivComment.setVisibility(8);
            } else {
                userVideoViewHolder.tvCommentsNum.setVisibility(0);
                userVideoViewHolder.ivComment.setVisibility(0);
                userVideoViewHolder.tvCommentsNum.setText(userCardVideo.totalComment);
            }
            userVideoViewHolder.tvDuration.setText(userCardVideo.duration);
            userVideoViewHolder.tvName.setText(userCardVideo.title);
            userVideoViewHolder.tvTime.setText(userCardVideo.publishTime);
            userVideoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "377754054")) {
                        ipChange.ipc$dispatch("377754054", new Object[]{this, view});
                    } else if (UserVideoAdapter.this.mClickListener != null) {
                        UserVideoAdapter.this.mClickListener.onClickVideo(userCardVideo.videoId);
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432861039")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-432861039", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 0) {
            return new UserCardHeaderViewHolder(this.mHeaderView);
        } else {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dago_pgc_user_card_video_item, viewGroup, false);
            if (Build.VERSION.SDK_INT >= 21) {
                inflate.setOutlineProvider(new ViewOutlineProvider() {
                    /* class com.youku.live.dago.widgetlib.usercard.UserVideoAdapter.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void getOutline(View view, Outline outline) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "30599163")) {
                            ipChange.ipc$dispatch("30599163", new Object[]{this, view, outline});
                            return;
                        }
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) DensityUtil.dip2px(AppContextUtils.getApp(), 6.0f));
                    }
                });
                inflate.setClipToOutline(true);
            }
            if (i == 2) {
                return new HorizontalViewHolder(inflate);
            }
            return new VerticalViewHolder(inflate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1538802744")) {
            ipChange.ipc$dispatch("1538802744", new Object[]{this, viewHolder});
            return;
        }
        super.onViewAttachedToWindow(viewHolder);
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            if (viewHolder.getItemViewType() == 0) {
                layoutParams2.setFullSpan(true);
            } else {
                layoutParams2.setFullSpan(false);
            }
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822513275")) {
            ipChange.ipc$dispatch("-822513275", new Object[]{this, itemClickListener});
            return;
        }
        this.mClickListener = itemClickListener;
    }

    public void updateVideos(List<UserCardVideo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338914793")) {
            ipChange.ipc$dispatch("-338914793", new Object[]{this, list});
            return;
        }
        this.mVideoList.clear();
        if (list == null || list.size() == 0) {
            notifyDataSetChanged();
            return;
        }
        this.mVideoList.addAll(list);
        notifyDataSetChanged();
    }
}
