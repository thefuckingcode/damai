package com.youku.live.dago.widgetlib.ailproom.adapter.userlist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.util.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tb.gp;

/* compiled from: Taobao */
public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private ReadWriteLock mLock = new ReentrantReadWriteLock();
    private String mMode = "normal";
    private List<UserListBean> mUserList = new LinkedList();
    public UserListView.IClickCallback onItemClick;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final TUrlImageView mImage;
        private final TextView mRankNum;
        private final ImageView mRankOval;

        UserViewHolder(View view) {
            super(view);
            TUrlImageView tUrlImageView = (TUrlImageView) view.findViewById(R.id.lf_rw_imageView_watcher);
            this.mImage = tUrlImageView;
            this.mRankOval = (ImageView) view.findViewById(R.id.lf_rank_oval);
            this.mRankNum = (TextView) view.findViewById(R.id.lf_rank_num);
            tUrlImageView.setFadeIn(true);
        }
    }

    UserListAdapter(Context context, UserListView.IClickCallback iClickCallback) {
        this.mContext = context;
        this.onItemClick = iClickCallback;
    }

    private void showOvalAndNum(int i, long j, TextView textView, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-478881409")) {
            ipChange.ipc$dispatch("-478881409", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), textView, imageView});
        } else if (j > 0) {
            UIUtil.setGone((View) imageView, false);
            UIUtil.setGone((View) textView, false);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.dago_pgc_rank_one);
                textView.setBackgroundResource(R.drawable.dago_pgc_rank_num_bg_one);
            } else if (i == 1) {
                imageView.setBackgroundResource(R.drawable.dago_pgc_rank_two);
                textView.setBackgroundResource(R.drawable.dago_pgc_rank_num_bg_two);
            } else if (i != 2) {
                textView.setBackgroundResource(R.drawable.dago_pgc_rank_num_bg_normal);
                UIUtil.setGone((View) imageView, true);
            } else {
                imageView.setBackgroundResource(R.drawable.dago_pgc_rank_three);
                textView.setBackgroundResource(R.drawable.dago_pgc_rank_num_bg_three);
            }
            textView.setText(Util.formatNumber2(j));
        } else {
            UIUtil.setGone((View) imageView, true);
            UIUtil.setGone((View) textView, true);
        }
    }

    public void clearUserList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152955544")) {
            ipChange.ipc$dispatch("1152955544", new Object[]{this});
            return;
        }
        this.mUserList.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-353798615")) {
            return ((Integer) ipChange.ipc$dispatch("-353798615", new Object[]{this})).intValue();
        }
        if (this.mUserList != null) {
            this.mLock.readLock().lock();
            try {
                i = this.mUserList.size();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.mLock.readLock().unlock();
                throw th;
            }
            this.mLock.readLock().unlock();
        }
        return i;
    }

    public UserListBean getItemObject(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639145928")) {
            return (UserListBean) ipChange.ipc$dispatch("639145928", new Object[]{this, Integer.valueOf(i)});
        } else if (getItemCount() <= 0) {
            return null;
        } else {
            this.mLock.readLock().lock();
            try {
                return this.mUserList.get(i);
            } finally {
                this.mLock.readLock().unlock();
            }
        }
    }

    public void setMode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289262035")) {
            ipChange.ipc$dispatch("289262035", new Object[]{this, str});
            return;
        }
        this.mMode = str;
        notifyDataSetChanged();
    }

    public void updateUserList(List<UserListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-603150853")) {
            ipChange.ipc$dispatch("-603150853", new Object[]{this, list});
            return;
        }
        this.mUserList.addAll(list);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425777338")) {
            ipChange.ipc$dispatch("-425777338", new Object[]{this, userViewHolder, Integer.valueOf(i)});
            return;
        }
        final UserListBean itemObject = getItemObject(i);
        if (itemObject != null) {
            if (!TextUtils.isEmpty(itemObject.a) && !itemObject.a.startsWith("http")) {
                itemObject.a = "http://m1.ykimg.com/" + itemObject.a;
            }
            if ("plus".equals(this.mMode)) {
                long j = itemObject.coins;
                if (j > 0) {
                    showOvalAndNum(i, j, userViewHolder.mRankNum, userViewHolder.mRankOval);
                    userViewHolder.mImage.setImageUrl(itemObject.a, new PhenixOptions().bitmapProcessors(new gp()));
                    UIUtil.setViewRoundedCorner(userViewHolder.mImage, UIUtil.dip2px(14));
                    userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListAdapter.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onClick(View view) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-536903558")) {
                                ipChange.ipc$dispatch("-536903558", new Object[]{this, view});
                                return;
                            }
                            UserListView.IClickCallback iClickCallback = UserListAdapter.this.onItemClick;
                            if (iClickCallback != null) {
                                iClickCallback.onItemClick(itemObject);
                            }
                        }
                    });
                }
            }
            UIUtil.setGone((View) userViewHolder.mRankOval, true);
            UIUtil.setGone((View) userViewHolder.mRankNum, true);
            userViewHolder.mImage.setImageUrl(itemObject.a, new PhenixOptions().bitmapProcessors(new gp()));
            UIUtil.setViewRoundedCorner(userViewHolder.mImage, UIUtil.dip2px(14));
            userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListAdapter.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-536903558")) {
                        ipChange.ipc$dispatch("-536903558", new Object[]{this, view});
                        return;
                    }
                    UserListView.IClickCallback iClickCallback = UserListAdapter.this.onItemClick;
                    if (iClickCallback != null) {
                        iClickCallback.onItemClick(itemObject);
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1027335568")) {
            return new UserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dago_pgc_item_userlist_image, viewGroup, false));
        }
        return (UserViewHolder) ipChange.ipc$dispatch("-1027335568", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }
}
