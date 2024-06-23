package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.home.adapter.StarTourTabAdapter;
import cn.damai.tetris.component.home.bean.HomeStarTourBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.gr;
import tb.tx1;
import tb.v50;
import tb.xf2;
import tb.xs0;
import tb.zw0;

/* compiled from: Taobao */
public class StarTourViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int currentPosition;
    private Context mContext = xs0.a();
    private List<HomeStarTourBean.HomeStarTourItem> mData = new ArrayList();
    private TextView mModuleTitle = ((TextView) this.itemView.findViewById(R$id.homepage_module_title_label));
    private TextView mMoreTitle = ((TextView) this.itemView.findViewById(R$id.homepage_module_title_more_text));
    private LinearLayout mMoreTitleLayout;
    private View.OnClickListener mOnClickListener = new b();
    private StarTourTabAdapter.OnTabItemClickListener mOnTabItemClickListener = new a();
    private DMPosterView mPosterView;
    private TextView mProjectCityName;
    private RelativeLayout mProjectLayout;
    private View mProjectLine;
    private DMDigitTextView mProjectPrice;
    private FrameLayout mProjectPriceLayout;
    private DMDigitTextView mProjectPriceUnknown;
    private TextView mProjectTime;
    private TextView mProjectTitle;
    private TextView mProjectVenueName;
    private TextView mSaleProjectCount;
    private RoundImageView mStarAvatar;
    private LinearLayout mStarLayout;
    private TextView mStarName;
    private RecyclerView mTabList;
    private StarTourTabAdapter mTabListAdapter;
    private TextView mTourCityCount;
    private LinearLayout mTourCityListLayout;
    private TextView mTourCityName;
    private TrackInfo mTrackInfo;
    private String moduleTitle;
    private View starTourCardLayout;

    /* compiled from: Taobao */
    public class a implements StarTourTabAdapter.OnTabItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.home.adapter.StarTourTabAdapter.OnTabItemClickListener
        public void onItemClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2088800938")) {
                ipChange.ipc$dispatch("-2088800938", new Object[]{this, view});
                return;
            }
            HomeStarTourBean.HomeStarTourItem homeStarTourItem = (HomeStarTourBean.HomeStarTourItem) view.getTag();
            if (homeStarTourItem != null) {
                zw0.B().t(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
                if (StarTourViewHolder.this.currentPosition != homeStarTourItem.position) {
                    ((HomeStarTourBean.HomeStarTourItem) StarTourViewHolder.this.mData.get(StarTourViewHolder.this.currentPosition)).isSelected = false;
                    homeStarTourItem.isSelected = true;
                    StarTourViewHolder.this.currentPosition = homeStarTourItem.position;
                    StarTourViewHolder.this.mTabListAdapter.notifyDataSetChanged();
                    StarTourViewHolder.this.handleProject(homeStarTourItem);
                }
                tx1.a(StarTourViewHolder.this.mContext, StarTourViewHolder.this.mTabList, view);
                zw0.B().K(StarTourViewHolder.this.mTrackInfo, view, StarTourViewHolder.this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "291275370")) {
                ipChange.ipc$dispatch("291275370", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.homepage_module_title_more_layout) {
                zw0.B().q(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle);
                DMNav.from(StarTourViewHolder.this.mContext).toUri(NavUri.b(gr.r));
            } else if (id == R$id.homepage_star_tour_star) {
                HomeStarTourBean.HomeStarTourItem homeStarTourItem = (HomeStarTourBean.HomeStarTourItem) view.getTag();
                if (homeStarTourItem != null && !TextUtils.isEmpty(homeStarTourItem.artistId)) {
                    zw0.B().s(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
                    Bundle bundle = new Bundle();
                    bundle.putString(RepertoireDetailFragment.USERTYPE, "2");
                    bundle.putString("userId", homeStarTourItem.artistId);
                    DMNav.from(StarTourViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(gr.Y));
                }
            } else {
                HomeStarTourBean.HomeStarTourItem homeStarTourItem2 = (HomeStarTourBean.HomeStarTourItem) view.getTag();
                if (homeStarTourItem2 != null) {
                    zw0.B().r(StarTourViewHolder.this.mTrackInfo, StarTourViewHolder.this.moduleTitle, homeStarTourItem2.artistId, homeStarTourItem2.projectId, homeStarTourItem2.position);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(MonitorType.SKIP, true);
                    bundle2.putString("from_page", "homepage");
                    bundle2.putString("projectImage", homeStarTourItem2.projectPic);
                    if (TextUtils.isEmpty(homeStarTourItem2.schema)) {
                        bundle2.putString("id", homeStarTourItem2.projectId);
                        DMNav.from(StarTourViewHolder.this.mContext).withExtras(bundle2).toUri(NavUri.b(gr.b));
                        return;
                    }
                    DMNav.from(StarTourViewHolder.this.mContext).withExtras(bundle2).toUri(homeStarTourItem2.schema);
                }
            }
        }
    }

    public StarTourViewHolder(View view) {
        super(view);
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_module_title_more_layout);
        this.mMoreTitleLayout = linearLayout;
        linearLayout.setOnClickListener(this.mOnClickListener);
        this.mTabList = (RecyclerView) this.itemView.findViewById(R$id.homepage_star_tour_tab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mTabList.setLayoutManager(linearLayoutManager);
        StarTourTabAdapter starTourTabAdapter = new StarTourTabAdapter();
        this.mTabListAdapter = starTourTabAdapter;
        this.mTabList.setAdapter(starTourTabAdapter);
        this.mTabListAdapter.g(this.mOnTabItemClickListener);
        this.mTabList.addItemDecoration(new RankItemDividerDecoration(21, 21));
        this.starTourCardLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_star_tour_card);
        LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R$id.homepage_star_tour_star);
        this.mStarLayout = linearLayout2;
        linearLayout2.setOnClickListener(this.mOnClickListener);
        this.mStarAvatar = (RoundImageView) this.itemView.findViewById(R$id.homepage_star_tour_star_avatar);
        this.mStarName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_star_name);
        this.mSaleProjectCount = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_count);
        RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.homepage_star_tour_project_layout);
        this.mProjectLayout = relativeLayout;
        relativeLayout.setOnClickListener(this.mOnClickListener);
        this.mPosterView = (DMPosterView) this.itemView.findViewById(R$id.homepage_star_tour_project_image);
        this.mProjectTitle = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_title);
        this.mProjectTime = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_time);
        this.mProjectCityName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_city);
        this.mProjectLine = this.itemView.findViewById(R$id.homepage_star_tour_project_line);
        this.mProjectVenueName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_project_venue);
        this.mProjectPriceLayout = (FrameLayout) this.itemView.findViewById(R$id.homepage_star_tour_project_price_layout);
        this.mProjectPrice = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_star_tour_project_price);
        DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_star_tour_project_price_unknown);
        this.mProjectPriceUnknown = dMDigitTextView;
        dMDigitTextView.setVisibility(8);
        LinearLayout linearLayout3 = (LinearLayout) this.itemView.findViewById(R$id.homepage_star_tour_city_list);
        this.mTourCityListLayout = linearLayout3;
        linearLayout3.setOnClickListener(this.mOnClickListener);
        this.mTourCityCount = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_city_count);
        this.mTourCityName = (TextView) this.itemView.findViewById(R$id.homepage_star_tour_city_name);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void handleProject(HomeStarTourBean.HomeStarTourItem homeStarTourItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453582152")) {
            ipChange.ipc$dispatch("453582152", new Object[]{this, homeStarTourItem});
        } else if (homeStarTourItem != null) {
            this.mStarLayout.setTag(homeStarTourItem);
            DMImageCreator c = cn.damai.common.image.a.b().c(homeStarTourItem.artistHeadPic);
            int i = R$drawable.uikit_user_default_icon;
            c.i(i).c(i).g(this.mStarAvatar);
            this.mStarName.setText(homeStarTourItem.artistName);
            if (TextUtils.isEmpty(homeStarTourItem.total)) {
                this.mSaleProjectCount.setText("");
            } else {
                this.mSaleProjectCount.setText(String.format("%s场在售演出", homeStarTourItem.total));
            }
            this.mProjectLayout.setTag(homeStarTourItem);
            this.mTourCityListLayout.setTag(homeStarTourItem);
            this.mPosterView.setImageUrlForWebp(homeStarTourItem.projectPic, v50.a(this.mContext, 98.0f), v50.a(this.mContext, 131.0f));
            this.mPosterView.setLabelType(DMLabelType.LABEL_TYPE_TOUR);
            if (TextUtils.isEmpty(homeStarTourItem.projectName)) {
                this.mProjectTitle.setText("");
            } else {
                this.mProjectTitle.setText(homeStarTourItem.projectName);
            }
            if (TextUtils.isEmpty(homeStarTourItem.projectDatetime)) {
                this.mProjectTime.setText("");
            } else {
                this.mProjectTime.setText(homeStarTourItem.projectDatetime);
            }
            if (TextUtils.isEmpty(homeStarTourItem.cityName)) {
                this.mProjectCityName.setText("");
            } else {
                this.mProjectCityName.setText(homeStarTourItem.cityName);
            }
            if (TextUtils.isEmpty(homeStarTourItem.venueName)) {
                this.mProjectVenueName.setText("");
            } else {
                this.mProjectVenueName.setText(homeStarTourItem.venueName);
            }
            if (TextUtils.isEmpty(homeStarTourItem.cityName) || TextUtils.isEmpty(homeStarTourItem.venueName)) {
                this.mProjectLine.setVisibility(8);
            } else {
                this.mProjectLine.setVisibility(0);
            }
            if (TextUtils.isEmpty(homeStarTourItem.priceLow) || homeStarTourItem.priceLow.equals("价格待定") || homeStarTourItem.priceLow.equals("待定")) {
                this.mProjectPriceLayout.setVisibility(8);
                this.mProjectPriceUnknown.setVisibility(0);
            } else {
                this.mProjectPriceUnknown.setVisibility(8);
                this.mProjectPriceLayout.setVisibility(0);
                this.mProjectPrice.setText(homeStarTourItem.priceLow);
            }
            int e = xf2.e(homeStarTourItem.tourCityNames);
            if (e <= 0) {
                this.mTourCityListLayout.setVisibility(4);
            } else {
                this.mTourCityListLayout.setVisibility(0);
                this.mTourCityCount.setText(String.valueOf(e));
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < e; i2++) {
                    String str = homeStarTourItem.tourCityNames.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        if (i2 != e - 1) {
                            sb.append(" | ");
                        }
                    }
                }
                this.mTourCityName.setText(sb.toString());
            }
            zw0.B().K(this.mTrackInfo, this.starTourCardLayout, this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.position);
            zw0.B().J(this.mTrackInfo, this.mProjectLayout, this.moduleTitle, homeStarTourItem.artistId, homeStarTourItem.projectId, homeStarTourItem.position);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-350243324")) {
            ipChange.ipc$dispatch("-350243324", new Object[]{this, commonBean});
        } else if (commonBean != null && (commonBean instanceof HomeStarTourBean)) {
            this.mTrackInfo = commonBean.trackInfo;
            HomeStarTourBean homeStarTourBean = (HomeStarTourBean) commonBean;
            String str = homeStarTourBean.mainTitle;
            this.moduleTitle = str;
            this.mModuleTitle.setText(str);
            this.mMoreTitle.setText(homeStarTourBean.moreText);
            if (!TextUtils.isEmpty(homeStarTourBean.moreText)) {
                zw0.B().L(this.mTrackInfo, this.mMoreTitle);
            }
            LinearLayout linearLayout = this.mMoreTitleLayout;
            if (TextUtils.isEmpty(homeStarTourBean.moreText)) {
                i = 8;
            }
            linearLayout.setVisibility(i);
            this.mData.clear();
            this.mData.addAll(homeStarTourBean.content);
            this.mData.get(this.currentPosition).isSelected = true;
            this.mTabListAdapter.f(this.mData, this.mTrackInfo, this.moduleTitle);
            handleProject(this.mData.get(this.currentPosition));
        }
    }
}
