package com.youku.live.dago.widgetlib.interactive.gift.view.multitarget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestRecyclerView;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListAdapter;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.GiftUTUtils;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class MultiTargetListView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "MultiTargetListView";
    private String anchorId;
    private int basePx = 0;
    private int gradientEndColor = 0;
    private int gradientStartColor = 0;
    private boolean isAttentioned;
    private boolean isFirstScroll = true;
    private TextView mBtnAttention;
    private TextView mBtnUserDetail;
    private GiftTargetInfoBean mCheckedModel;
    private ArrayList<GiftTargetInfoBean> mCheckedModelList = new ArrayList<>();
    private Context mContext;
    private GiftTargetInfoBean mDetailtarget;
    private EventListener mEventListenr;
    private boolean mHasMultipleTargets;
    private ImageView mIvAvater;
    private ImageView mIvBack;
    private int mLastPosition = -1;
    private ArrayList<GiftTargetInfoBean> mList = new ArrayList<>();
    private LinearLayout mListContainer;
    private String mMultipleText;
    private boolean mNowIsCheckAll = false;
    private TextView mSelectAllBtn;
    private TextView mTagretDetailView;
    private MultiTargetListAdapter mTargetListAdapter;
    private NestRecyclerView mTargetListView;
    private RelativeLayout mUserDetailContainer;
    private String nowCheckedId = "";
    private String roomId;
    private long roomType;
    private View rootView;
    private String screenId;
    private int themeColor = 0;

    /* compiled from: Taobao */
    public interface EventListener {
        void onClick(GiftTargetInfoBean giftTargetInfoBean);

        void onExposed(List<GiftTargetInfoBean> list);

        void openUserCard(GiftTargetInfoBean giftTargetInfoBean);
    }

    public MultiTargetListView(@NonNull Context context) {
        super(context, null, 0);
        this.mContext = context;
        initView();
    }

    private void attention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115145528")) {
            ipChange.ipc$dispatch("-115145528", new Object[]{this});
        }
    }

    private void btnAttention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956054338")) {
            ipChange.ipc$dispatch("1956054338", new Object[]{this});
            return;
        }
        clickFollowUT();
        if (this.isAttentioned) {
            unAttention();
        } else {
            attention();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkAll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666154967")) {
            ipChange.ipc$dispatch("-666154967", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCheckedModelList.clear();
        for (int i = 0; i < this.mList.size(); i++) {
            this.mList.get(i).isChecked = z;
            if (z) {
                this.mCheckedModelList.add(this.mList.get(i));
            }
        }
        this.mTargetListAdapter.notifyDataSetChanged();
    }

    private void clickFollowUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607705234")) {
            ipChange.ipc$dispatch("-607705234", new Object[]{this});
        }
    }

    private GiftTargetInfoBean getCheckedModel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987944069")) {
            return (GiftTargetInfoBean) ipChange.ipc$dispatch("-1987944069", new Object[]{this, Integer.valueOf(i)});
        }
        ArrayList<GiftTargetInfoBean> arrayList = this.mList;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            if (this.mList.get(i2).position == i) {
                return this.mList.get(i2);
            }
        }
        return null;
    }

    private int getGradientEndColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1464343691")) {
            return ((Integer) ipChange.ipc$dispatch("1464343691", new Object[]{this})).intValue();
        }
        int i = this.gradientEndColor;
        return i == 0 ? Color.parseColor("#FFB700") : i;
    }

    private int getGradientStartColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904344146")) {
            return ((Integer) ipChange.ipc$dispatch("904344146", new Object[]{this})).intValue();
        }
        int i = this.gradientStartColor;
        return i == 0 ? Color.parseColor("#FF8200") : i;
    }

    private Drawable getSelectAllBtnBg(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121741850")) {
            return (Drawable) ipChange.ipc$dispatch("1121741850", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            return ThemeUtils.getGradientDrawable(getGradientStartColor(), getGradientEndColor(), GradientDrawable.Orientation.LEFT_RIGHT, 0, 0, (float) (this.basePx * 15));
        } else {
            int i = this.themeColor;
            int i2 = this.basePx;
            return ThemeUtils.getDrawable(0, i, i2, (float) (i2 * 15));
        }
    }

    private int getThemeColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306556663")) {
            return ((Integer) ipChange.ipc$dispatch("-306556663", new Object[]{this})).intValue();
        }
        int i = this.themeColor;
        return i == 0 ? Color.parseColor("#FFAC00") : i;
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-986787281")) {
            ipChange.ipc$dispatch("-986787281", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.dago_pgc_ykl_gift_target_list_view, this);
        this.rootView = inflate;
        this.mListContainer = (LinearLayout) inflate.findViewById(R.id.voice_live_list_container);
        this.mTargetListView = (NestRecyclerView) this.rootView.findViewById(R.id.voice_live_list);
        this.mSelectAllBtn = (TextView) this.rootView.findViewById(R.id.cb_all_voice);
        this.mUserDetailContainer = (RelativeLayout) this.rootView.findViewById(R.id.user_detail_container);
        this.mIvBack = (ImageView) this.rootView.findViewById(R.id.iv_back);
        this.mIvAvater = (ImageView) this.rootView.findViewById(R.id.iv_avater);
        this.mTagretDetailView = (TextView) this.rootView.findViewById(R.id.tv_detail);
        this.mBtnAttention = (TextView) this.rootView.findViewById(R.id.attention);
        this.mBtnUserDetail = (TextView) this.rootView.findViewById(R.id.user_detail);
        this.mSelectAllBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-444775390")) {
                    ipChange.ipc$dispatch("-444775390", new Object[]{this, view});
                    return;
                }
                MultiTargetListView multiTargetListView = MultiTargetListView.this;
                multiTargetListView.checkAll(!multiTargetListView.mNowIsCheckAll);
                MultiTargetListView multiTargetListView2 = MultiTargetListView.this;
                multiTargetListView2.setCheckBtnState(!multiTargetListView2.mNowIsCheckAll);
            }
        });
        this.mIvBack.setOnClickListener(this);
        this.mBtnUserDetail.setOnClickListener(this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
        this.mTargetListAdapter = new MultiTargetListAdapter(this.mContext, this.mList);
        this.mTargetListView.setLayoutManager(linearLayoutManager);
        this.mTargetListView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dip2px(getContext(), 3.0f)));
        this.mTargetListView.setHorizontalFadingEdgeEnabled(true);
        this.mTargetListView.setFadingEdgeLength(DensityUtil.dip2px(getContext(), 20.0f));
        this.mTargetListView.setAdapter(this.mTargetListAdapter);
        this.mTargetListAdapter.setOnItemClickListener(new MultiTargetListAdapter.OnItemClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListAdapter.OnItemClickListener
            public void onItemClick(int i, View view) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange, "102207345")) {
                    ipChange.ipc$dispatch("102207345", new Object[]{this, Integer.valueOf(i), view});
                    return;
                }
                GiftTargetInfoBean giftTargetInfoBean = (GiftTargetInfoBean) MultiTargetListView.this.mList.get(i);
                if (MultiTargetListView.this.isHasMultipleTargets()) {
                    if (giftTargetInfoBean.isChecked) {
                        giftTargetInfoBean.isChecked = false;
                        MultiTargetListView.this.mCheckedModelList.remove(giftTargetInfoBean);
                    } else {
                        giftTargetInfoBean.isChecked = true;
                        MultiTargetListView.this.mCheckedModelList.add(giftTargetInfoBean);
                    }
                    if (MultiTargetListView.this.mEventListenr != null) {
                        MultiTargetListView.this.mEventListenr.onClick(giftTargetInfoBean);
                    }
                    GiftUTUtils.targetClick(giftTargetInfoBean);
                    MultiTargetListView multiTargetListView = MultiTargetListView.this;
                    if (multiTargetListView.mCheckedModelList.size() != MultiTargetListView.this.mList.size()) {
                        z = false;
                    }
                    multiTargetListView.setCheckBtnState(z);
                } else {
                    if (MultiTargetListView.this.mLastPosition != -1) {
                        GiftTargetInfoBean giftTargetInfoBean2 = (GiftTargetInfoBean) MultiTargetListView.this.mList.get(MultiTargetListView.this.mLastPosition);
                        giftTargetInfoBean2.isChecked = false;
                        MultiTargetListView.this.mCheckedModelList.remove(giftTargetInfoBean2);
                    }
                    if (MultiTargetListView.this.mLastPosition != i) {
                        giftTargetInfoBean.isChecked = true;
                        MultiTargetListView.this.mCheckedModelList.add(giftTargetInfoBean);
                        MultiTargetListView.this.mLastPosition = i;
                    }
                }
                MultiTargetListView.this.mTargetListAdapter.notifyDataSetChanged();
            }
        });
        this.mTargetListView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.multitarget.MultiTargetListView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                LinearLayoutManager linearLayoutManager;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-516728528")) {
                    ipChange.ipc$dispatch("-516728528", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && (linearLayoutManager = linearLayoutManager) != null) {
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                            if (MultiTargetListView.this.mList != null && findFirstVisibleItemPosition < MultiTargetListView.this.mList.size()) {
                                GiftUTUtils.targetExpose((GiftTargetInfoBean) MultiTargetListView.this.mList.get(findFirstVisibleItemPosition));
                            }
                            findFirstVisibleItemPosition++;
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-209483537")) {
                    ipChange.ipc$dispatch("-209483537", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                if (MultiTargetListView.this.isFirstScroll) {
                    MultiTargetListView.this.isFirstScroll = false;
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                            if (MultiTargetListView.this.mList != null && findFirstVisibleItemPosition < MultiTargetListView.this.mList.size()) {
                                GiftUTUtils.targetExpose((GiftTargetInfoBean) MultiTargetListView.this.mList.get(findFirstVisibleItemPosition));
                            }
                            findFirstVisibleItemPosition++;
                        }
                    }
                }
            }
        });
    }

    private void openUserCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354789729")) {
            ipChange.ipc$dispatch("-354789729", new Object[]{this});
            return;
        }
        EventListener eventListener = this.mEventListenr;
        if (eventListener != null) {
            eventListener.openUserCard(this.mDetailtarget);
        }
    }

    private void setAttentionUi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-329151916")) {
            ipChange.ipc$dispatch("-329151916", new Object[]{this});
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCheckBtnState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438638037")) {
            ipChange.ipc$dispatch("-438638037", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.mSelectAllBtn.setTextColor(-1);
        } else {
            this.mSelectAllBtn.setTextColor(getThemeColor());
        }
        this.mSelectAllBtn.setBackground(getSelectAllBtnBg(z));
        this.mNowIsCheckAll = z;
    }

    private void unAttention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865203263")) {
            ipChange.ipc$dispatch("-1865203263", new Object[]{this});
        }
    }

    private void updateUI(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1650835579")) {
            ipChange.ipc$dispatch("-1650835579", new Object[]{this, giftTheme});
            return;
        }
        this.mSelectAllBtn.setTextColor(this.themeColor);
        this.mSelectAllBtn.setText(getMultipleText());
        TextView textView = this.mSelectAllBtn;
        int i2 = this.themeColor;
        int i3 = this.basePx;
        textView.setBackground(ThemeUtils.getDrawable(0, i2, i3, (float) (i3 * 15)));
        TextView textView2 = this.mSelectAllBtn;
        if (!isHasMultipleTargets()) {
            i = 8;
        }
        textView2.setVisibility(i);
        MultiTargetListAdapter multiTargetListAdapter = this.mTargetListAdapter;
        if (multiTargetListAdapter != null) {
            multiTargetListAdapter.updateTheme(giftTheme);
        }
    }

    public void changeView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532950245")) {
            ipChange.ipc$dispatch("532950245", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mUserDetailContainer.setVisibility(8);
            this.mListContainer.setVisibility(0);
        } else {
            this.mUserDetailContainer.setVisibility(0);
            this.mListContainer.setVisibility(8);
        }
    }

    public String getCheckedIds() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256496831")) {
            return (String) ipChange.ipc$dispatch("-256496831", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mCheckedModelList.size() <= 0) {
            return "";
        }
        for (int i = 0; i < this.mCheckedModelList.size(); i++) {
            stringBuffer.append(this.mCheckedModelList.get(i).id);
            stringBuffer.append(",");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    public String getMultipleText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043853363")) {
            return (String) ipChange.ipc$dispatch("-2043853363", new Object[]{this});
        } else if (TextUtils.isEmpty(this.mMultipleText)) {
            return "全麦";
        } else {
            return this.mMultipleText;
        }
    }

    public List<GiftTargetInfoBean> getTargetInfos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1550313311")) {
            return this.mCheckedModelList;
        }
        return (List) ipChange.ipc$dispatch("-1550313311", new Object[]{this});
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189846306")) {
            ipChange.ipc$dispatch("1189846306", new Object[]{this});
            return;
        }
        ArrayList<GiftTargetInfoBean> arrayList = this.mList;
        if (arrayList != null && arrayList.size() >= 1 && getVisibility() != 8) {
            setVisibility(8);
        }
    }

    public boolean isHasMultipleTargets() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1709789498")) {
            return this.mHasMultipleTargets;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1709789498", new Object[]{this})).booleanValue();
    }

    public boolean isShowing() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-408695409")) {
            return getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-408695409", new Object[]{this})).booleanValue();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154388395")) {
            ipChange.ipc$dispatch("-1154388395", new Object[]{this, view});
        } else if (view.getId() == this.mIvBack.getId()) {
            changeView(true);
        } else if (view.getId() == this.mBtnUserDetail.getId()) {
            openUserCard();
        }
    }

    public void openMultiSendMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236945816")) {
            ipChange.ipc$dispatch("-1236945816", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mHasMultipleTargets = z;
    }

    public void resumeData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687299187")) {
            ipChange.ipc$dispatch("-687299187", new Object[]{this});
            return;
        }
        MultiTargetListAdapter multiTargetListAdapter = this.mTargetListAdapter;
        if (multiTargetListAdapter != null) {
            multiTargetListAdapter.resumeData();
        }
        setCheckBtnState(false);
    }

    public void scrollTo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209516636")) {
            ipChange.ipc$dispatch("209516636", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mTargetListView.scrollTo(i, i2);
    }

    public void selectAndScrollToPosition(ArrayList<Integer> arrayList) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "973302160")) {
            ipChange.ipc$dispatch("973302160", new Object[]{this, arrayList});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "positions : " + arrayList.toString());
        this.mTargetListView.scrollToPosition(arrayList.get(0).intValue());
        for (int i = 0; i < arrayList.size(); i++) {
            GiftTargetInfoBean giftTargetInfoBean = this.mList.get(arrayList.get(i).intValue());
            if (giftTargetInfoBean != null) {
                giftTargetInfoBean.isChecked = true;
                this.mCheckedModelList.add(giftTargetInfoBean);
                if (i == 0) {
                    this.mDetailtarget = giftTargetInfoBean;
                    DagoImageLoader.getInstance().showCircle(this.mContext, giftTargetInfoBean.icon, this.mIvAvater, R.drawable.dago_pgc_ykl_gift_board_bg);
                    TextView textView = this.mTagretDetailView;
                    textView.setText("送给：" + giftTargetInfoBean.desc);
                }
            }
        }
        if (this.mCheckedModelList.size() != this.mList.size()) {
            z = false;
        }
        setCheckBtnState(z);
        MultiTargetListAdapter multiTargetListAdapter = this.mTargetListAdapter;
        if (multiTargetListAdapter != null) {
            multiTargetListAdapter.notifyDataSetChanged();
        }
        if (!isHasMultipleTargets()) {
            this.mLastPosition = arrayList.get(0).intValue();
        }
    }

    public void setEventListener(EventListener eventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465549928")) {
            ipChange.ipc$dispatch("-465549928", new Object[]{this, eventListener});
            return;
        }
        this.mEventListenr = eventListener;
    }

    public void setMultiCheckedModel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745343160")) {
            ipChange.ipc$dispatch("1745343160", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        GiftTargetInfoBean checkedModel = getCheckedModel(i);
        this.mCheckedModel = checkedModel;
        if (checkedModel != null) {
            this.nowCheckedId = checkedModel.id;
            this.isAttentioned = checkedModel.isAttentioned;
            DagoImageLoader.getInstance().showCircle(this.mContext, this.mCheckedModel.icon, this.mIvAvater, R.drawable.dago_pgc_ykl_gift_board_bg);
            TextView textView = this.mTagretDetailView;
            textView.setText("送给：" + this.mCheckedModel.name);
            setAttentionUi();
            changeView(false);
            checkAll(false);
            setCheckBtnState(false);
        }
    }

    public void setMultipleText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462936241")) {
            ipChange.ipc$dispatch("1462936241", new Object[]{this, str});
            return;
        }
        this.mMultipleText = str;
    }

    public void setRoomData(String str, String str2, String str3, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518157721")) {
            ipChange.ipc$dispatch("-518157721", new Object[]{this, str, str2, str3, Long.valueOf(j)});
            return;
        }
        this.roomId = str;
        this.anchorId = str2;
        this.screenId = str3;
        this.roomType = j;
    }

    public void setTargetList(List<GiftTargetInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028891738")) {
            ipChange.ipc$dispatch("-1028891738", new Object[]{this, list});
        } else if (list == null || list.size() <= 0) {
            hide();
        } else {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "micList : " + list.toString());
            this.mList.clear();
            this.mCheckedModelList.clear();
            this.mList.addAll(list);
            MultiTargetListAdapter multiTargetListAdapter = this.mTargetListAdapter;
            if (multiTargetListAdapter != null) {
                multiTargetListAdapter.notifyDataSetChanged();
            }
            show();
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950449273")) {
            ipChange.ipc$dispatch("-1950449273", new Object[]{this});
            return;
        }
        ArrayList<GiftTargetInfoBean> arrayList = this.mList;
        if (arrayList != null && arrayList.size() >= 1 && getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "660165478")) {
            ipChange.ipc$dispatch("660165478", new Object[]{this, giftTheme});
            return;
        }
        this.basePx = DensityUtil.dip2px(this.mContext, 1.0f);
        this.themeColor = giftTheme.themeColor;
        this.gradientStartColor = giftTheme.btnGiantStartColor;
        this.gradientEndColor = giftTheme.btnGiantEndColor;
        updateUI(giftTheme);
    }

    public MultiTargetListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mContext = context;
        initView();
    }

    public MultiTargetListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }
}
