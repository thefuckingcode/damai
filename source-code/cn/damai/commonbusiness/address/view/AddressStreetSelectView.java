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
public class AddressStreetSelectView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isScrolling;
    private View.OnClickListener mOnCompletedClickListener;
    private OnStreetDivisionChangedListener mOnStreetDivisionChangedListener;
    private OnStreetDivisionSelectedListener mOnStreetDivisionSelectedListener;
    private OnWheelScrollListener mOnStreetWheelScrollListener;
    private DivisionBean mSelectedStreet;
    private l90 mStreetDivisionAdapter;
    private List<DivisionBean> mStreetDivisionList;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private WheelView mWheelViewStreet;

    /* compiled from: Taobao */
    public interface OnStreetDivisionChangedListener {
        void onStreetDivisionChanged(DivisionBean divisionBean);
    }

    /* compiled from: Taobao */
    public interface OnStreetDivisionSelectedListener {
        void onStreetDivisionSelected(DivisionBean divisionBean);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-44404379")) {
                ipChange.ipc$dispatch("-44404379", new Object[]{this, view});
            } else if (AddressStreetSelectView.this.mOnStreetDivisionSelectedListener != null && AddressStreetSelectView.this.mSelectedStreet != null && !AddressStreetSelectView.this.isScrolling) {
                AddressStreetSelectView.this.mOnStreetDivisionSelectedListener.onStreetDivisionSelected(AddressStreetSelectView.this.mSelectedStreet);
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
            DivisionBean divisionBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "487500152")) {
                ipChange.ipc$dispatch("487500152", new Object[]{this, wheelView});
                return;
            }
            AddressStreetSelectView.this.isScrolling = false;
            if (AddressStreetSelectView.this.mStreetDivisionList != null && !AddressStreetSelectView.this.mStreetDivisionList.isEmpty() && (divisionBean = (DivisionBean) AddressStreetSelectView.this.mStreetDivisionList.get(wheelView.getCurrentItem())) != null) {
                AddressStreetSelectView.this.mSelectedStreet = divisionBean;
            }
        }

        @Override // cn.damai.uikit.wheel.OnWheelScrollListener
        public void onScrollingStarted(WheelView wheelView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-892672203")) {
                ipChange.ipc$dispatch("-892672203", new Object[]{this, wheelView});
                return;
            }
            AddressStreetSelectView.this.isScrolling = true;
        }
    }

    public AddressStreetSelectView(Context context) {
        super(context);
        init(context);
    }

    private int getSelectedDivisionIndex(List<DivisionBean> list, DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817082056")) {
            return ((Integer) ipChange.ipc$dispatch("-1817082056", new Object[]{this, list, divisionBean})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "344783569")) {
            ipChange.ipc$dispatch("344783569", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.common_business_select_street_division_layout, this);
        this.mTvCancel = (TextView) findViewById(R$id.common_business_street_select_cancel_tv);
        this.mTvConfirm = (TextView) findViewById(R$id.common_business_street_select_completed_tv);
        this.mWheelViewStreet = (WheelView) findViewById(R$id.common_business_street_wheel_view);
        initListeners();
        setupListeners();
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396580396")) {
            ipChange.ipc$dispatch("-396580396", new Object[]{this});
            return;
        }
        this.mOnCompletedClickListener = new a();
        this.mOnStreetWheelScrollListener = new b();
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818969115")) {
            ipChange.ipc$dispatch("-818969115", new Object[]{this});
            return;
        }
        this.mTvConfirm.setOnClickListener(this.mOnCompletedClickListener);
        this.mWheelViewStreet.addScrollingListener(this.mOnStreetWheelScrollListener);
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319474285")) {
            ipChange.ipc$dispatch("-319474285", new Object[]{this, onClickListener});
            return;
        }
        this.mTvCancel.setOnClickListener(onClickListener);
    }

    public void setOnStreetDivisionChangedListener(OnStreetDivisionChangedListener onStreetDivisionChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505427800")) {
            ipChange.ipc$dispatch("1505427800", new Object[]{this, onStreetDivisionChangedListener});
            return;
        }
        this.mOnStreetDivisionChangedListener = onStreetDivisionChangedListener;
    }

    public void setOnStreetDivisionSelectedListener(OnStreetDivisionSelectedListener onStreetDivisionSelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274567470")) {
            ipChange.ipc$dispatch("274567470", new Object[]{this, onStreetDivisionSelectedListener});
            return;
        }
        this.mOnStreetDivisionSelectedListener = onStreetDivisionSelectedListener;
    }

    public void setStreetDivisionList(List<DivisionBean> list, DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571133797")) {
            ipChange.ipc$dispatch("1571133797", new Object[]{this, list, divisionBean});
        } else if (list == null || list.size() <= 0) {
            this.mSelectedStreet = null;
            this.mStreetDivisionList = new ArrayList();
            l90 l90 = new l90(getContext(), this.mStreetDivisionList);
            this.mStreetDivisionAdapter = l90;
            this.mWheelViewStreet.setViewAdapter(l90);
        } else {
            this.mStreetDivisionList = list;
            l90 l902 = new l90(getContext(), this.mStreetDivisionList);
            this.mStreetDivisionAdapter = l902;
            this.mWheelViewStreet.setViewAdapter(l902);
            int selectedDivisionIndex = getSelectedDivisionIndex(this.mStreetDivisionList, divisionBean);
            this.mWheelViewStreet.setCurrentItem(selectedDivisionIndex);
            DivisionBean divisionBean2 = this.mStreetDivisionList.get(selectedDivisionIndex);
            this.mSelectedStreet = divisionBean2;
            OnStreetDivisionChangedListener onStreetDivisionChangedListener = this.mOnStreetDivisionChangedListener;
            if (onStreetDivisionChangedListener != null && divisionBean2 != null) {
                onStreetDivisionChangedListener.onStreetDivisionChanged(divisionBean2);
            }
        }
    }

    public AddressStreetSelectView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AddressStreetSelectView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
