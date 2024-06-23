package com.ali.user.mobile.register.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.AUPinnedHeaderListView;
import java.util.List;

/* compiled from: Taobao */
public class RegionAdapter extends BaseAdapter implements AUPinnedHeaderListView.PinnedHeaderAdapter {
    private List<RegionInfo> list = null;
    private Context mContext;
    private RegionInfo mCurrentRegion;

    /* compiled from: Taobao */
    class ViewHolder {
        protected LinearLayout mHeaderLayout;
        protected TextView mHeaderText;
        protected TextView mRegionNubmerText;
        protected ImageView mRegionSelectIcon;
        protected TextView mRegiontNameText;

        ViewHolder() {
        }
    }

    public RegionAdapter(Context context, List<RegionInfo> list2) {
        this.list = list2;
        this.mContext = context;
    }

    @Override // com.ali.user.mobile.ui.widget.AUPinnedHeaderListView.PinnedHeaderAdapter
    public void configurePinnedHeader(View view, int i, int i2) {
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return this.list.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    @Override // com.ali.user.mobile.ui.widget.AUPinnedHeaderListView.PinnedHeaderAdapter
    public int getPinnedHeaderState(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(DataProviderFactory.getApplicationContext()).inflate(R.layout.aliuser_region, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.mHeaderLayout = (LinearLayout) view.findViewById(R.id.contact_item_head);
            viewHolder.mHeaderText = (TextView) view.findViewById(R.id.contact_item_header_text);
            viewHolder.mRegiontNameText = (TextView) view.findViewById(R.id.region_name);
            viewHolder.mRegionNubmerText = (TextView) view.findViewById(R.id.region_number);
            viewHolder.mRegionSelectIcon = (ImageView) view.findViewById(R.id.region_select);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        RegionInfo regionInfo = this.list.get(i);
        if (regionInfo.isDisplayLetter) {
            if (DataProviderFactory.getDataProvider().showHeadCountry()) {
                viewHolder.mHeaderLayout.setVisibility(0);
            } else {
                viewHolder.mHeaderLayout.setVisibility(8);
            }
            viewHolder.mHeaderText.setText(regionInfo.character);
            view.setBackgroundColor(-1);
        } else {
            viewHolder.mHeaderLayout.setVisibility(8);
            view.setBackgroundResource(R.drawable.aliuser_region_item_bg);
        }
        viewHolder.mRegiontNameText.setText(regionInfo.name);
        viewHolder.mRegionNubmerText.setText(regionInfo.code);
        RegionInfo regionInfo2 = this.mCurrentRegion;
        if (regionInfo2 == null || TextUtils.isEmpty(regionInfo2.domain) || !this.mCurrentRegion.domain.equals(regionInfo.domain)) {
            viewHolder.mRegionNubmerText.setTextColor(this.mContext.getResources().getColor(R.color.aliuser_color_light_gray));
            viewHolder.mRegiontNameText.setTextColor(this.mContext.getResources().getColor(R.color.aliuser_color_black));
            viewHolder.mRegionSelectIcon.setVisibility(4);
        } else {
            TextView textView = viewHolder.mRegionNubmerText;
            Resources resources = this.mContext.getResources();
            int i2 = R.color.aliuser_selected_country_color;
            textView.setTextColor(resources.getColor(i2));
            viewHolder.mRegiontNameText.setTextColor(this.mContext.getResources().getColor(i2));
            viewHolder.mRegionSelectIcon.setVisibility(0);
        }
        return view;
    }

    public void setSelectedItem(RegionInfo regionInfo) {
        this.mCurrentRegion = regionInfo;
    }
}
