package cn.damai.issue.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask;
import cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask2;
import cn.damai.issue.listener.DMOnItemChildClickListener;
import cn.damai.issue.listener.DMOnRVItemClickListener;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.d20;
import tb.fe;
import tb.g91;
import tb.r21;
import tb.v50;
import tb.zq;

/* compiled from: Taobao */
public class DMSortableNinePhotoLayout extends RecyclerView implements DMOnItemChildClickListener, DMOnRVItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_ITEM_COUNT = 11;
    private static final int MAX_SPAN_COUNT = 3;
    private int itemWidth;
    private Activity mActivity;
    private Context mContext;
    private GridLayoutManager mGridLayoutManager;
    private boolean mIsPlusSwitchOpened;
    private boolean mIsSortable;
    private float mItemDecoration;
    private ItemTouchHelper mItemTouchHelper;
    private int mLRDistance;
    private OnNinePhotoClickListener mOnNinePhotoClickListener;
    private OnSortListener mOnSortListener;
    private PhotoAdapter mPhotoAdapter;

    /* compiled from: Taobao */
    public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
        private static transient /* synthetic */ IpChange $ipChange;

        private ItemTouchHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "691167403")) {
                ipChange.ipc$dispatch("691167403", new Object[]{this, recyclerView, viewHolder});
                return;
            }
            ViewCompat.setScaleX(viewHolder.itemView, 1.0f);
            ViewCompat.setScaleY(viewHolder.itemView, 1.0f);
            ((DMRecyclerViewHolder) viewHolder).a().getImageView(R$id.iv_item_nine_photo_photo).setColorFilter((ColorFilter) null);
            if (DMSortableNinePhotoLayout.this.mOnSortListener != null) {
                DMSortableNinePhotoLayout.this.mOnSortListener.onSortComplete(DMSortableNinePhotoLayout.this.mPhotoAdapter.d());
            }
            super.clearView(recyclerView, viewHolder);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-999912472")) {
                return ((Integer) ipChange.ipc$dispatch("-999912472", new Object[]{this, recyclerView, viewHolder})).intValue();
            } else if (DMSortableNinePhotoLayout.this.mPhotoAdapter.q(viewHolder.getAdapterPosition()) || DMSortableNinePhotoLayout.this.mPhotoAdapter.r(viewHolder.getAdapterPosition()) || DMSortableNinePhotoLayout.this.mPhotoAdapter.getItem(viewHolder.getAdapterPosition()).getType() == "2") {
                return 0;
            } else {
                return ItemTouchHelper.Callback.makeMovementFlags(51, 51);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isItemViewSwipeEnabled() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-59210749")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-59210749", new Object[]{this})).booleanValue();
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "605783036")) {
                return DMSortableNinePhotoLayout.this.mIsSortable && DMSortableNinePhotoLayout.this.mPhotoAdapter.d().size() > 1;
            }
            return ((Boolean) ipChange.ipc$dispatch("605783036", new Object[]{this})).booleanValue();
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1650374472")) {
                ipChange.ipc$dispatch("1650374472", new Object[]{this, canvas, recyclerView, viewHolder, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-215404149")) {
                return ((Boolean) ipChange.ipc$dispatch("-215404149", new Object[]{this, recyclerView, viewHolder, viewHolder2})).booleanValue();
            } else if (viewHolder.getItemViewType() != viewHolder2.getItemViewType() || DMSortableNinePhotoLayout.this.mPhotoAdapter.q(viewHolder2.getAdapterPosition()) || DMSortableNinePhotoLayout.this.mPhotoAdapter.r(viewHolder2.getAdapterPosition()) || DMSortableNinePhotoLayout.this.mPhotoAdapter.getItem(viewHolder2.getAdapterPosition()).getType() == "2") {
                return false;
            } else {
                DMSortableNinePhotoLayout.this.mPhotoAdapter.e(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
                return true;
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        @RequiresApi(api = 8)
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-692364329")) {
                ipChange.ipc$dispatch("-692364329", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            if (i != 0) {
                ViewCompat.setScaleX(viewHolder.itemView, 1.2f);
                ViewCompat.setScaleY(viewHolder.itemView, 1.2f);
                ((DMRecyclerViewHolder) viewHolder).a().getImageView(R$id.iv_item_nine_photo_photo).setColorFilter(Color.parseColor("#4D000000"));
            }
            super.onSelectedChanged(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1160057216")) {
                ipChange.ipc$dispatch("1160057216", new Object[]{this, viewHolder, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public interface OnNinePhotoClickListener {
        void onClickAddNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList);

        void onClickAddVideoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList);

        void onClickChangeVideoCoverItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, int i, Image image, ArrayList<Image> arrayList);

        void onClickDeleteNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, Image image, ArrayList<Image> arrayList);

        void onClickNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, Image image, ArrayList<Image> arrayList);

        void onClickPalyerVideoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList);
    }

    /* compiled from: Taobao */
    public interface OnSortListener {
        void onSortComplete(ArrayList<Image> arrayList);
    }

    /* compiled from: Taobao */
    public class PhotoAdapter extends DMRecyclerViewAdapter<Image> {
        private static transient /* synthetic */ IpChange $ipChange;
        private int j;

        /* compiled from: Taobao */
        public class a implements ImageTask.Listener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ DMViewHolderHelper a;

            a(PhotoAdapter photoAdapter, DMViewHolderHelper dMViewHolderHelper) {
                this.a = dMViewHolderHelper;
            }

            @Override // cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask.Listener
            public void onSuccess(Bitmap bitmap) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-621552069")) {
                    ipChange.ipc$dispatch("-621552069", new Object[]{this, bitmap});
                } else if (bitmap != null) {
                    this.a.getImageView(R$id.iv_item_nine_photo_photo).setImageBitmap(bitmap);
                    g91.c("uploader 获取视频第一帧", "重新加载获取成功");
                }
            }
        }

        /* compiled from: Taobao */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "157959717")) {
                    ipChange.ipc$dispatch("157959717", new Object[]{this, view});
                    return;
                }
                OnNinePhotoClickListener onNinePhotoClickListener = DMSortableNinePhotoLayout.this.mOnNinePhotoClickListener;
                DMSortableNinePhotoLayout dMSortableNinePhotoLayout = DMSortableNinePhotoLayout.this;
                onNinePhotoClickListener.onClickChangeVideoCoverItem(dMSortableNinePhotoLayout, this.a, dMSortableNinePhotoLayout.mPhotoAdapter.getItem(this.a), DMSortableNinePhotoLayout.this.mPhotoAdapter.d());
            }
        }

        public PhotoAdapter(RecyclerView recyclerView) {
            super(recyclerView, R$layout.layout_nine_photo_item);
            this.j = DisplayMetrics.getwidthPixels(v50.b(DMSortableNinePhotoLayout.this.getContext())) / 6;
        }

        @Override // cn.damai.issue.view.DMRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-158788653")) {
                return ((Integer) ipChange.ipc$dispatch("-158788653", new Object[]{this})).intValue();
            } else if (!DMSortableNinePhotoLayout.this.mIsPlusSwitchOpened || super.getItemCount() >= 11) {
                return super.getItemCount();
            } else {
                return super.getItemCount() + 2;
            }
        }

        /* access modifiers changed from: protected */
        @Override // cn.damai.issue.view.DMRecyclerViewAdapter
        public void k(DMViewHolderHelper dMViewHolderHelper) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "884541017")) {
                ipChange.ipc$dispatch("884541017", new Object[]{this, dMViewHolderHelper});
                return;
            }
            dMViewHolderHelper.setItemChildClickListener(R$id.iv_item_nine_photo_flag);
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public void c(DMViewHolderHelper dMViewHolderHelper, int i, Image image) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1693155466")) {
                ipChange.ipc$dispatch("1693155466", new Object[]{this, dMViewHolderHelper, Integer.valueOf(i), image});
                return;
            }
            g91.c("DMSortableNinePhotoLayout", "fillData" + i + "");
            if (q(i)) {
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_photo_flag, 8);
                int i2 = R$id.add_photo_layout;
                dMViewHolderHelper.setVisibility(i2, 0);
                if (DMSortableNinePhotoLayout.this.mPhotoAdapter.d().size() == 9) {
                    dMViewHolderHelper.setTextColor(R$id.add_image, Color.parseColor("#669C9CA5"));
                    dMViewHolderHelper.setTextColor(R$id.add_image_tip, Color.parseColor("#669C9CA5"));
                } else {
                    dMViewHolderHelper.setTextColor(R$id.add_image, Color.parseColor("#9C9CA5"));
                    dMViewHolderHelper.setTextColor(R$id.add_image_tip, Color.parseColor("#9C9CA5"));
                }
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_video_flag, 8);
                dMViewHolderHelper.setVisibility(R$id.issue_update_cover, 8);
                dMViewHolderHelper.setVisibility(R$id.add_video_layout, 8);
                dMViewHolderHelper.setVisibility(R$id.issue_progress, 8);
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_photo_photo, 4);
                DMSortableNinePhotoLayout.this.loadPerformImage(dMViewHolderHelper, "");
                g91.c("DMSortableNinePhotoLayout", "添加图片" + i + "");
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", d20.E());
                r21.m(hashMap);
                cn.damai.common.user.c.e().G(dMViewHolderHelper.getView(i2), "picture_upload", "bottom", r21.PAGE_EVALUATE_SUBMIT, hashMap);
            } else if (r(i)) {
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_photo_flag, 8);
                dMViewHolderHelper.setVisibility(R$id.add_photo_layout, 8);
                int i3 = R$id.add_video_layout;
                dMViewHolderHelper.setVisibility(i3, 0);
                dMViewHolderHelper.setVisibility(R$id.issue_progress, 8);
                if (DMSortableNinePhotoLayout.this.mPhotoAdapter.d().size() == 9 || (DMSortableNinePhotoLayout.this.mPhotoAdapter.d().size() > 0 && DMSortableNinePhotoLayout.this.mPhotoAdapter.d().size() < 9 && "2".equals(((Image) DMSortableNinePhotoLayout.this.mPhotoAdapter.d().get(0)).getType()))) {
                    dMViewHolderHelper.setTextColor(R$id.add_video, Color.parseColor("#669C9CA5"));
                    dMViewHolderHelper.setTextColor(R$id.add_video_tip, Color.parseColor("#669C9CA5"));
                } else {
                    dMViewHolderHelper.setTextColor(R$id.add_video, Color.parseColor("#9C9CA5"));
                    dMViewHolderHelper.setTextColor(R$id.add_video_tip, Color.parseColor("#9C9CA5"));
                }
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_video_flag, 8);
                dMViewHolderHelper.setVisibility(R$id.issue_update_cover, 8);
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_photo_photo, 4);
                DMSortableNinePhotoLayout.this.loadPerformImage(dMViewHolderHelper, "");
                g91.c("DMSortableNinePhotoLayout", "添加视频" + i + "");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("usercode", d20.E());
                r21.m(hashMap2);
                cn.damai.common.user.c.e().G(dMViewHolderHelper.getView(i3), "video_upload", "bottom", r21.PAGE_EVALUATE_SUBMIT, hashMap2);
            } else if (!"2".equals(image.getType()) || i != 0) {
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_photo_flag, 0);
                dMViewHolderHelper.setVisibility(R$id.add_photo_layout, 8);
                dMViewHolderHelper.setVisibility(R$id.add_video_layout, 8);
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_video_flag, 8);
                dMViewHolderHelper.setVisibility(R$id.issue_update_cover, 8);
                dMViewHolderHelper.setVisibility(R$id.issue_progress, 8);
                int i4 = R$id.iv_item_nine_photo_photo;
                dMViewHolderHelper.setVisibility(i4, 0);
                dMViewHolderHelper.getImageView(i4).setImageResource(R$drawable.uikit_default_image_bg_grey);
                DMSortableNinePhotoLayout.this.loadPerformImage(dMViewHolderHelper, image.getPath());
                g91.c("DMSortableNinePhotoLayout", "图片位置" + i + "");
            } else {
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_photo_flag, 0);
                dMViewHolderHelper.setVisibility(R$id.add_photo_layout, 8);
                dMViewHolderHelper.setVisibility(R$id.add_video_layout, 8);
                dMViewHolderHelper.setVisibility(R$id.iv_item_nine_video_flag, 0);
                int i5 = R$id.issue_update_cover;
                dMViewHolderHelper.setVisibility(i5, 0);
                dMViewHolderHelper.setVisibility(R$id.issue_progress, 8);
                int i6 = R$id.iv_item_nine_photo_photo;
                dMViewHolderHelper.setVisibility(i6, 0);
                dMViewHolderHelper.getImageView(i6).setImageResource(R$drawable.uikit_default_image_bg_grey);
                if (image.getThumbnail() != null) {
                    DMSortableNinePhotoLayout.this.loadPerformImage(dMViewHolderHelper, image.getThumbnail());
                } else {
                    Bitmap bitmap = null;
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 12) {
                        bitmap = fe.a.get(image.getPath());
                    }
                    if (bitmap != null) {
                        dMViewHolderHelper.getImageView(i6).setImageBitmap(bitmap);
                        g91.c("uploader 获取视频第一帧", "缓存获取成功");
                    } else if (i7 >= 3) {
                        new ImageTask(this.b, new a(this, dMViewHolderHelper)).execute(image.getPath(), image.getPath());
                    }
                }
                dMViewHolderHelper.getView(i5).setOnClickListener(new b(i));
                g91.c("DMSortableNinePhotoLayout", "视频第一个" + i + "");
            }
        }

        /* renamed from: p */
        public Image getItem(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1333555298")) {
                return (Image) ipChange.ipc$dispatch("-1333555298", new Object[]{this, Integer.valueOf(i)});
            } else if (!q(i) && !r(i)) {
                return (Image) super.getItem(i);
            } else {
                return null;
            }
        }

        public boolean q(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1436374648")) {
                return DMSortableNinePhotoLayout.this.mIsPlusSwitchOpened && super.getItemCount() < 11 && i == getItemCount() - 1;
            }
            return ((Boolean) ipChange.ipc$dispatch("1436374648", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }

        public boolean r(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2049552013")) {
                return DMSortableNinePhotoLayout.this.mIsPlusSwitchOpened && super.getItemCount() < 11 && i == getItemCount() - 2;
            }
            return ((Boolean) ipChange.ipc$dispatch("2049552013", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }

        /* access modifiers changed from: protected */
        /* renamed from: s */
        public void n(DMViewHolderHelper dMViewHolderHelper, int i, Image image, List<Object> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714293606")) {
                ipChange.ipc$dispatch("-1714293606", new Object[]{this, dMViewHolderHelper, Integer.valueOf(i), image, list});
            } else if (list != null && list.size() > 0 && list.get(0) != null) {
                if (list.get(0).toString().startsWith("progress")) {
                    String[] split = list.get(0).toString().split(":");
                    int intValue = Integer.valueOf(split[split.length - 1]).intValue();
                    ((FrameLayout.LayoutParams) dMViewHolderHelper.getView(R$id.issue_progress_bg).getLayoutParams()).height = DMSortableNinePhotoLayout.this.itemWidth - ((DMSortableNinePhotoLayout.this.itemWidth * intValue) / 100);
                    TextView textView = dMViewHolderHelper.getTextView(R$id.issue_progress_text);
                    textView.setText(intValue + "%\n上传中");
                } else if ("start".equals(list.get(0).toString())) {
                    ((FrameLayout.LayoutParams) dMViewHolderHelper.getView(R$id.issue_progress_bg).getLayoutParams()).height = DMSortableNinePhotoLayout.this.itemWidth;
                    dMViewHolderHelper.getTextView(R$id.issue_progress_text).setText("0%\n上传中");
                    dMViewHolderHelper.setVisibility(R$id.issue_progress, 0);
                    dMViewHolderHelper.setVisibility(R$id.iv_item_nine_video_flag, 8);
                } else if ("onFailure".equals(list.get(0).toString())) {
                    dMViewHolderHelper.setVisibility(R$id.issue_progress, 8);
                } else if ("success".equals(list.get(0).toString())) {
                    dMViewHolderHelper.setVisibility(R$id.issue_progress, 8);
                    dMViewHolderHelper.setVisibility(R$id.iv_item_nine_video_flag, 0);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ int b;

        a(View view, int i) {
            this.a = view;
            this.b = i;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1688024253")) {
                ipChange.ipc$dispatch("-1688024253", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            OnNinePhotoClickListener onNinePhotoClickListener = DMSortableNinePhotoLayout.this.mOnNinePhotoClickListener;
            DMSortableNinePhotoLayout dMSortableNinePhotoLayout = DMSortableNinePhotoLayout.this;
            onNinePhotoClickListener.onClickDeleteNinePhotoItem(dMSortableNinePhotoLayout, this.a, this.b, dMSortableNinePhotoLayout.mPhotoAdapter.getItem(this.b), DMSortableNinePhotoLayout.this.mPhotoAdapter.d());
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "596663795")) {
                ipChange.ipc$dispatch("596663795", new Object[]{this, eVar});
            } else if (eVar != null) {
                Bitmap bitmap = eVar.b;
                if (bitmap != null) {
                    this.a.setImageBitmap(bitmap);
                } else {
                    this.a.setImageDrawable(DMSortableNinePhotoLayout.this.mContext.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements ImageTask2.Listener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        c(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, String str) {
            this.a = str;
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask2.Listener
        public void onSuccess(ImageView imageView, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1590393717")) {
                ipChange.ipc$dispatch("-1590393717", new Object[]{this, imageView, bitmap});
            } else if (bitmap != null && this.a.equals(imageView.getTag())) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public DMSortableNinePhotoLayout(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadPerformImage(DMViewHolderHelper dMViewHolderHelper, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466754725")) {
            ipChange.ipc$dispatch("1466754725", new Object[]{this, dMViewHolderHelper, str});
            return;
        }
        ImageView imageView = dMViewHolderHelper.getImageView(R$id.iv_item_nine_photo_photo);
        if (TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(this.mContext.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey));
        } else if (str.startsWith("http")) {
            String str2 = str + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0";
            if (imageView.getTag() instanceof zq) {
                ((zq) imageView.getTag()).cancel();
            }
            imageView.setTag(cn.damai.common.image.a.b().e(str2).n(new b(imageView)).f());
        } else {
            imageView.setImageDrawable(this.mContext.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey));
            imageView.setTag(str);
            Bitmap bitmap = null;
            int i = Build.VERSION.SDK_INT;
            if (i >= 12) {
                bitmap = fe.a.get(str);
            }
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else if (i >= 3) {
                new ImageTask2(this.mContext, true, imageView, new c(this, str)).execute(str);
            }
        }
    }

    private void updateHeight() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-112658723")) {
            ipChange.ipc$dispatch("-112658723", new Object[]{this});
            return;
        }
        if (this.mPhotoAdapter.getItemCount() <= 0 || this.mPhotoAdapter.getItemCount() >= 3) {
            this.mGridLayoutManager.setSpanCount(3);
        } else {
            this.mGridLayoutManager.setSpanCount(this.mPhotoAdapter.getItemCount());
        }
        int a2 = (DisplayMetrics.getwidthPixels(v50.b(this.mActivity)) - v50.a(this.mActivity, (float) this.mLRDistance)) / 3;
        this.itemWidth = a2;
        int spanCount = a2 * this.mGridLayoutManager.getSpanCount();
        if (this.mPhotoAdapter.getItemCount() != 0) {
            i = this.itemWidth * (((this.mPhotoAdapter.getItemCount() - 1) / this.mGridLayoutManager.getSpanCount()) + 1);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = spanCount;
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void addFirstItem(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297886139")) {
            ipChange.ipc$dispatch("297886139", new Object[]{this, image});
            return;
        }
        this.mPhotoAdapter.a(image);
        PhotoAdapter photoAdapter = this.mPhotoAdapter;
        photoAdapter.notifyItemRangeChanged(0, photoAdapter.getItemCount());
        updateHeight();
    }

    public ArrayList<Image> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1061361399")) {
            return this.mPhotoAdapter.d();
        }
        return (ArrayList) ipChange.ipc$dispatch("1061361399", new Object[]{this});
    }

    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2115746982")) {
            return this.mPhotoAdapter.d().size();
        }
        return ((Integer) ipChange.ipc$dispatch("-2115746982", new Object[]{this})).intValue();
    }

    public void init(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974536529")) {
            ipChange.ipc$dispatch("-974536529", new Object[]{this, activity});
            return;
        }
        this.mActivity = activity;
    }

    public void notifyItemChanged(int i, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506434470")) {
            ipChange.ipc$dispatch("-1506434470", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        this.mPhotoAdapter.notifyItemChanged(i, obj);
    }

    public void notifyItemRangeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734413734")) {
            ipChange.ipc$dispatch("-734413734", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mPhotoAdapter.notifyItemRangeChanged(i, i2);
    }

    @Override // cn.damai.issue.listener.DMOnItemChildClickListener
    public void onItemChildClick(ViewGroup viewGroup, View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172464927")) {
            ipChange.ipc$dispatch("172464927", new Object[]{this, viewGroup, view, Integer.valueOf(i)});
        } else if (this.mOnNinePhotoClickListener != null && i > -1 && i < getItemCount()) {
            DMDialog dMDialog = new DMDialog(this.mContext);
            dMDialog.v(getResources().getString(R$string.damai_delete_image));
            dMDialog.g(R$string.damai_no, null);
            dMDialog.l(R$string.damai_yes, new a(view, i));
            dMDialog.show();
        }
    }

    @Override // cn.damai.issue.listener.DMOnRVItemClickListener
    public void onRVItemClick(ViewGroup viewGroup, View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236998171")) {
            ipChange.ipc$dispatch("236998171", new Object[]{this, viewGroup, view, Integer.valueOf(i)});
        } else if (i <= -1 || !this.mPhotoAdapter.q(i)) {
            if (i <= -1 || !this.mPhotoAdapter.r(i)) {
                if (i == 0 && this.mPhotoAdapter.getItem(i) != null && "2".equals(this.mPhotoAdapter.getItem(i).getType())) {
                    this.mOnNinePhotoClickListener.onClickPalyerVideoItem(this, view, i, this.mPhotoAdapter.d());
                } else if (this.mOnNinePhotoClickListener != null && ViewCompat.getScaleX(view) <= 1.0f && i > -1 && i < getItemCount()) {
                    this.mOnNinePhotoClickListener.onClickNinePhotoItem(this, view, i, this.mPhotoAdapter.getItem(i), this.mPhotoAdapter.d());
                }
            } else if (this.mPhotoAdapter.d().size() > 0 && "2".equals(((Image) this.mPhotoAdapter.d().get(0)).getType())) {
                ToastUtil a2 = ToastUtil.a();
                Context context = this.mContext;
                a2.e(context, context.getResources().getString(R$string.issue_add_video_limit));
            } else if (this.mPhotoAdapter.d().size() == 9) {
                ToastUtil a3 = ToastUtil.a();
                Context context2 = this.mContext;
                a3.e(context2, context2.getResources().getString(R$string.issue_add_video_limit_nine));
            } else {
                this.mOnNinePhotoClickListener.onClickAddVideoItem(this, view, i, this.mPhotoAdapter.d());
            }
        } else if (this.mPhotoAdapter.d().size() == 9) {
            ToastUtil a4 = ToastUtil.a();
            Context context3 = this.mContext;
            a4.e(context3, context3.getResources().getString(R$string.issue_add_image_limit));
        } else {
            OnNinePhotoClickListener onNinePhotoClickListener = this.mOnNinePhotoClickListener;
            if (onNinePhotoClickListener != null) {
                onNinePhotoClickListener.onClickAddNinePhotoItem(this, view, i, this.mPhotoAdapter.d());
            }
        }
    }

    public void removeItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-270169939")) {
            ipChange.ipc$dispatch("-270169939", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPhotoAdapter.i(i);
        notifyItemRangeChanged(i, this.mPhotoAdapter.getItemCount() - i);
        updateHeight();
    }

    public void setData(ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853267143")) {
            ipChange.ipc$dispatch("-853267143", new Object[]{this, arrayList});
        } else if (this.mActivity != null) {
            this.mPhotoAdapter.j(arrayList);
            updateHeight();
        } else {
            throw new RuntimeException("请先调用init方法进行初始化");
        }
    }

    public void setIsPlusSwitchOpened(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1676025850")) {
            ipChange.ipc$dispatch("1676025850", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsPlusSwitchOpened = z;
        updateHeight();
    }

    public void setIsSortable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784615419")) {
            ipChange.ipc$dispatch("784615419", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsSortable = z;
    }

    public void setOnNinePhotoClickListener(OnNinePhotoClickListener onNinePhotoClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741068704")) {
            ipChange.ipc$dispatch("1741068704", new Object[]{this, onNinePhotoClickListener});
            return;
        }
        this.mOnNinePhotoClickListener = onNinePhotoClickListener;
    }

    public void setOnSortListener(OnSortListener onSortListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772260532")) {
            ipChange.ipc$dispatch("1772260532", new Object[]{this, onSortListener});
            return;
        }
        this.mOnSortListener = onSortListener;
    }

    public DMSortableNinePhotoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void notifyItemChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169342462")) {
            ipChange.ipc$dispatch("169342462", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPhotoAdapter.notifyItemChanged(i);
    }

    public DMSortableNinePhotoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsPlusSwitchOpened = true;
        this.mIsSortable = true;
        this.mItemDecoration = 1.0f;
        this.mLRDistance = 62;
        if (Build.VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
        this.mContext = context;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback());
        this.mItemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this);
        AnonymousClass1 r3 = new GridLayoutManager(this, context, 3) {
            /* class cn.damai.issue.view.DMSortableNinePhotoLayout.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
            public boolean canScrollVertically() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "499401396")) {
                    return false;
                }
                return ((Boolean) ipChange.ipc$dispatch("499401396", new Object[]{this})).booleanValue();
            }
        };
        this.mGridLayoutManager = r3;
        setLayoutManager(r3);
        addItemDecoration(new DMSpaceItemDecoration(v50.a(context, this.mItemDecoration)));
        PhotoAdapter photoAdapter = new PhotoAdapter(this);
        this.mPhotoAdapter = photoAdapter;
        photoAdapter.l(this);
        this.mPhotoAdapter.m(this);
        setAdapter(this.mPhotoAdapter);
    }
}
