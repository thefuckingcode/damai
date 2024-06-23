package cn.damai.commonbusiness.address.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.address.bean.DivisionBean;
import cn.damai.uikit.wheel.OnWheelScrollListener;
import cn.damai.uikit.wheel.WheelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.l90;

/* compiled from: Taobao */
public class AddressDivisionSelectView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isCityScrolling;
    private boolean isCountyScrolling;
    private boolean isProvinceScrolling;
    private l90 mCityDivisionAdapter;
    private List<DivisionBean> mCityDivisionList;
    private l90 mCountyDivisionAdapter;
    private List<DivisionBean> mCountyDivisionList;
    private OnCityDivisionChangedListener mOnCityDivisionChangedListener;
    private OnWheelScrollListener mOnCityWheelScrollListener;
    private View.OnClickListener mOnCompletedClickListener;
    private OnCountyDivisionChangedListener mOnCountyDivisionChangedListener;
    private OnWheelScrollListener mOnCountyWheelScrollListener;
    private OnProvinceCityCountySelectedListener mOnProvinceCityCountySelectedListener;
    private OnProvinceDivisionChangedListener mOnProvinceDivisionChangedListener;
    private OnWheelScrollListener mOnProvinceWheelScrollListener;
    private l90 mProvinceDivisionAdapter;
    private List<DivisionBean> mProvinceDivisionList;
    private DivisionBean mSelectedCity;
    private DivisionBean mSelectedCounty;
    private DivisionBean mSelectedProvince;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private WheelView mWheelViewCity;
    private WheelView mWheelViewCounty;
    private WheelView mWheelViewProvince;

    /* compiled from: Taobao */
    public interface OnCityDivisionChangedListener {
        void onCityDivisionChanged(DivisionBean divisionBean);
    }

    /* compiled from: Taobao */
    public interface OnCountyDivisionChangedListener {
        void onCountyDivisionChanged(DivisionBean divisionBean);
    }

    /* compiled from: Taobao */
    public interface OnProvinceCityCountySelectedListener {
        void onDivisionsSelected(DivisionBean divisionBean, DivisionBean divisionBean2, DivisionBean divisionBean3);
    }

    /* compiled from: Taobao */
    public interface OnProvinceDivisionChangedListener {
        void onProvinceDivisionChanged(DivisionBean divisionBean);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "756409487")) {
                ipChange.ipc$dispatch("756409487", new Object[]{this, view});
            } else if (AddressDivisionSelectView.this.mOnProvinceCityCountySelectedListener != null && !AddressDivisionSelectView.this.isProvinceScrolling && !AddressDivisionSelectView.this.isCityScrolling && !AddressDivisionSelectView.this.isCountyScrolling) {
                AddressDivisionSelectView.this.mOnProvinceCityCountySelectedListener.onDivisionsSelected(AddressDivisionSelectView.this.mSelectedProvince, AddressDivisionSelectView.this.mSelectedCity, AddressDivisionSelectView.this.mSelectedCounty);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnWheelScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingFinished(WheelView wheelView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1941059982")) {
                ipChange.ipc$dispatch("1941059982", new Object[]{this, wheelView});
                return;
            }
            AddressDivisionSelectView.this.isProvinceScrolling = false;
            AddressDivisionSelectView addressDivisionSelectView = AddressDivisionSelectView.this;
            addressDivisionSelectView.updateCityBySelectedProvince(addressDivisionSelectView.mWheelViewProvince.getCurrentItem());
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingStarted(WheelView wheelView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677067169")) {
                ipChange.ipc$dispatch("-1677067169", new Object[]{this, wheelView});
                return;
            }
            AddressDivisionSelectView.this.isProvinceScrolling = true;
        }
    }

    /* compiled from: Taobao */
    public class c implements OnWheelScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingFinished(WheelView wheelView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "10440877")) {
                ipChange.ipc$dispatch("10440877", new Object[]{this, wheelView});
                return;
            }
            AddressDivisionSelectView.this.isCityScrolling = false;
            AddressDivisionSelectView.this.updateCountyBySelectedCity(wheelView.getCurrentItem());
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingStarted(WheelView wheelView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1046608544")) {
                ipChange.ipc$dispatch("-1046608544", new Object[]{this, wheelView});
                return;
            }
            AddressDivisionSelectView.this.isCityScrolling = true;
        }
    }

    /* compiled from: Taobao */
    public class d implements OnWheelScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingFinished(WheelView wheelView) {
            DivisionBean divisionBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1920178228")) {
                ipChange.ipc$dispatch("-1920178228", new Object[]{this, wheelView});
                return;
            }
            AddressDivisionSelectView.this.isCountyScrolling = false;
            int currentItem = wheelView.getCurrentItem();
            if (currentItem >= 0 && currentItem < AddressDivisionSelectView.this.mCountyDivisionList.size() && (divisionBean = (DivisionBean) AddressDivisionSelectView.this.mCountyDivisionList.get(currentItem)) != null) {
                AddressDivisionSelectView.this.mSelectedCounty = divisionBean;
            }
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingStarted(WheelView wheelView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-416149919")) {
                ipChange.ipc$dispatch("-416149919", new Object[]{this, wheelView});
                return;
            }
            AddressDivisionSelectView.this.isCountyScrolling = true;
        }
    }

    public AddressDivisionSelectView(Context context) {
        super(context);
        init(context);
    }

    private int getSelectedDivisionIndex(List<DivisionBean> list, DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455532338")) {
            return ((Integer) ipChange.ipc$dispatch("-1455532338", new Object[]{this, list, divisionBean})).intValue();
        }
        if (divisionBean != null) {
            String divisionId = divisionBean.getDivisionId();
            if (!TextUtils.isEmpty(divisionId)) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    DivisionBean divisionBean2 = list.get(i);
                    if (divisionBean2 != null && divisionId.equals(divisionBean2.getDivisionId())) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599790361")) {
            ipChange.ipc$dispatch("-599790361", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.common_business_select_division_layout, this);
        this.mTvCancel = (TextView) findViewById(R$id.common_business_division_select_cancel_tv);
        this.mTvConfirm = (TextView) findViewById(R$id.common_business_division_select_completed_tv);
        this.mWheelViewProvince = (WheelView) findViewById(R$id.common_business_province_wheel_view);
        this.mWheelViewCity = (WheelView) findViewById(R$id.common_business_city_wheel_view);
        this.mWheelViewCounty = (WheelView) findViewById(R$id.common_business_county_wheel_view);
        initListeners();
        setupListeners();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022527466")) {
            ipChange.ipc$dispatch("1022527466", new Object[]{this});
            return;
        }
        this.mOnCompletedClickListener = new a();
        this.mOnProvinceWheelScrollListener = new b();
        this.mOnCityWheelScrollListener = new c();
        this.mOnCountyWheelScrollListener = new d();
    }

    private void resetData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939954976")) {
            ipChange.ipc$dispatch("939954976", new Object[]{this});
            return;
        }
        this.mProvinceDivisionList = null;
        this.mSelectedProvince = null;
        this.mCityDivisionList = null;
        this.mSelectedCity = null;
        this.mCountyDivisionList = null;
        this.mSelectedCounty = null;
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223701647")) {
            ipChange.ipc$dispatch("223701647", new Object[]{this});
            return;
        }
        this.mTvConfirm.setOnClickListener(this.mOnCompletedClickListener);
        this.mWheelViewProvince.addScrollingListener(this.mOnProvinceWheelScrollListener);
        this.mWheelViewCity.addScrollingListener(this.mOnCityWheelScrollListener);
        this.mWheelViewCounty.addScrollingListener(this.mOnCountyWheelScrollListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCityBySelectedProvince(int i) {
        DivisionBean divisionBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295682200")) {
            ipChange.ipc$dispatch("-295682200", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<DivisionBean> list = this.mProvinceDivisionList;
        if (list != null && (divisionBean = list.get(i)) != null) {
            if (this.mSelectedProvince == null) {
                this.mSelectedProvince = divisionBean;
            } else {
                String divisionId = divisionBean.getDivisionId();
                if (!TextUtils.isEmpty(divisionId) && !divisionId.equals(this.mSelectedProvince.getDivisionId())) {
                    this.mSelectedProvince = divisionBean;
                }
            }
            OnProvinceDivisionChangedListener onProvinceDivisionChangedListener = this.mOnProvinceDivisionChangedListener;
            if (onProvinceDivisionChangedListener != null) {
                onProvinceDivisionChangedListener.onProvinceDivisionChanged(this.mSelectedProvince);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCountyBySelectedCity(int i) {
        DivisionBean divisionBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101481474")) {
            ipChange.ipc$dispatch("101481474", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<DivisionBean> list = this.mCityDivisionList;
        if (list != null && i >= 0 && i < list.size() && (divisionBean = this.mCityDivisionList.get(i)) != null) {
            if (this.mSelectedCity == null) {
                this.mSelectedCity = divisionBean;
            } else {
                String divisionId = divisionBean.getDivisionId();
                if (!TextUtils.isEmpty(divisionId) && !divisionId.equals(this.mSelectedCity.getDivisionId())) {
                    this.mSelectedCity = divisionBean;
                }
            }
            OnCityDivisionChangedListener onCityDivisionChangedListener = this.mOnCityDivisionChangedListener;
            if (onCityDivisionChangedListener != null) {
                onCityDivisionChangedListener.onCityDivisionChanged(this.mSelectedCity);
            }
        }
    }

    public void setCityList(List<DivisionBean> list, DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501688086")) {
            ipChange.ipc$dispatch("-501688086", new Object[]{this, list, divisionBean});
        } else if (list == null || list.size() <= 0) {
            this.mCityDivisionList = new ArrayList();
            l90 l90 = new l90(getContext(), this.mCityDivisionList);
            this.mCityDivisionAdapter = l90;
            this.mWheelViewCity.setViewAdapter(l90);
            this.mSelectedCity = null;
        } else {
            this.mCityDivisionList = list;
            l90 l902 = new l90(getContext(), this.mCityDivisionList);
            this.mCityDivisionAdapter = l902;
            this.mWheelViewCity.setViewAdapter(l902);
            int selectedDivisionIndex = getSelectedDivisionIndex(this.mCityDivisionList, divisionBean);
            this.mWheelViewCity.setCurrentItem(selectedDivisionIndex);
            DivisionBean divisionBean2 = this.mCityDivisionList.get(selectedDivisionIndex);
            this.mSelectedCity = divisionBean2;
            OnCityDivisionChangedListener onCityDivisionChangedListener = this.mOnCityDivisionChangedListener;
            if (onCityDivisionChangedListener != null && divisionBean2 != null) {
                onCityDivisionChangedListener.onCityDivisionChanged(divisionBean2);
            }
        }
    }

    public void setCountyList(List<DivisionBean> list, DivisionBean divisionBean) {
        DivisionBean divisionBean2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1543511689")) {
            ipChange.ipc$dispatch("1543511689", new Object[]{this, list, divisionBean});
        } else if (list == null || list.size() <= 0) {
            this.mSelectedCounty = null;
            this.mCountyDivisionList = new ArrayList();
            l90 l90 = new l90(getContext(), this.mCountyDivisionList);
            this.mCountyDivisionAdapter = l90;
            this.mWheelViewCounty.setViewAdapter(l90);
        } else {
            this.mCountyDivisionList = list;
            l90 l902 = new l90(getContext(), this.mCountyDivisionList);
            this.mCountyDivisionAdapter = l902;
            this.mWheelViewCounty.setViewAdapter(l902);
            int selectedDivisionIndex = getSelectedDivisionIndex(this.mCountyDivisionList, divisionBean);
            this.mWheelViewCounty.setCurrentItem(selectedDivisionIndex);
            this.mSelectedCounty = this.mCountyDivisionList.get(selectedDivisionIndex);
            DivisionBean divisionBean3 = this.mSelectedCity;
            if (divisionBean3 != null && divisionBean3.getDivisionName().equals(this.mSelectedCounty.getDivisionName())) {
                l90 l903 = new l90(getContext(), new ArrayList());
                this.mCountyDivisionAdapter = l903;
                this.mWheelViewCounty.setViewAdapter(l903);
            }
            OnCountyDivisionChangedListener onCountyDivisionChangedListener = this.mOnCountyDivisionChangedListener;
            if (onCountyDivisionChangedListener != null && (divisionBean2 = this.mSelectedCounty) != null) {
                onCountyDivisionChangedListener.onCountyDivisionChanged(divisionBean2);
            }
        }
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971987159")) {
            ipChange.ipc$dispatch("-1971987159", new Object[]{this, onClickListener});
            return;
        }
        this.mTvCancel.setOnClickListener(onClickListener);
    }

    public void setOnCityDivisionChangedListener(OnCityDivisionChangedListener onCityDivisionChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588434840")) {
            ipChange.ipc$dispatch("-1588434840", new Object[]{this, onCityDivisionChangedListener});
            return;
        }
        this.mOnCityDivisionChangedListener = onCityDivisionChangedListener;
    }

    public void setOnCountyDivisionChangedListener(OnCountyDivisionChangedListener onCountyDivisionChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928916634")) {
            ipChange.ipc$dispatch("-928916634", new Object[]{this, onCountyDivisionChangedListener});
            return;
        }
        this.mOnCountyDivisionChangedListener = onCountyDivisionChangedListener;
    }

    public void setOnDivisionsSelectedListener(OnProvinceCityCountySelectedListener onProvinceCityCountySelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436553847")) {
            ipChange.ipc$dispatch("-436553847", new Object[]{this, onProvinceCityCountySelectedListener});
            return;
        }
        this.mOnProvinceCityCountySelectedListener = onProvinceCityCountySelectedListener;
    }

    public void setOnProvinceDivisionChangedListener(OnProvinceDivisionChangedListener onProvinceDivisionChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-82506830")) {
            ipChange.ipc$dispatch("-82506830", new Object[]{this, onProvinceDivisionChangedListener});
            return;
        }
        this.mOnProvinceDivisionChangedListener = onProvinceDivisionChangedListener;
    }

    public void setProvinceList(List<DivisionBean> list, DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "990056815")) {
            ipChange.ipc$dispatch("990056815", new Object[]{this, list, divisionBean});
        } else if (list == null || list.size() <= 0) {
            this.mProvinceDivisionList = new ArrayList();
            this.mProvinceDivisionAdapter = new l90(getContext(), this.mProvinceDivisionList);
            this.mWheelViewProvince.setViewAdapter(this.mCityDivisionAdapter);
            this.mSelectedProvince = null;
        } else {
            this.mProvinceDivisionList = list;
            l90 l90 = new l90(getContext(), this.mProvinceDivisionList);
            this.mProvinceDivisionAdapter = l90;
            this.mWheelViewProvince.setViewAdapter(l90);
            int selectedDivisionIndex = getSelectedDivisionIndex(this.mProvinceDivisionList, divisionBean);
            this.mWheelViewProvince.setCurrentItem(selectedDivisionIndex);
            DivisionBean divisionBean2 = this.mProvinceDivisionList.get(selectedDivisionIndex);
            this.mSelectedProvince = divisionBean2;
            OnProvinceDivisionChangedListener onProvinceDivisionChangedListener = this.mOnProvinceDivisionChangedListener;
            if (onProvinceDivisionChangedListener != null && divisionBean2 != null) {
                onProvinceDivisionChangedListener.onProvinceDivisionChanged(divisionBean2);
            }
        }
    }

    public AddressDivisionSelectView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AddressDivisionSelectView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
