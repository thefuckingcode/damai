package cn.damai.ticklet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.ui.adapter.AutoResizeViewPager;
import cn.damai.ticklet.ui.adapter.TickletDetailViewPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collections;
import tb.gl2;
import tb.vl2;

/* compiled from: Taobao */
public class TickletDetailViewPager extends AutoResizeViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletTicketCallback callback;
    Context context;
    private TickletDetailViewPagerAdapter pagerAdapter;
    View partent;

    public TickletDetailViewPager(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260548851")) {
            ipChange.ipc$dispatch("-260548851", new Object[]{this});
            return;
        }
        TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = new TickletDetailViewPagerAdapter(this.context);
        this.pagerAdapter = tickletDetailViewPagerAdapter;
        setAdapter(tickletDetailViewPagerAdapter);
        this.pagerAdapter.l(this);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.ticklet.view.TickletDetailViewPager.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1405353298")) {
                    ipChange.ipc$dispatch("1405353298", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2083388401")) {
                    ipChange.ipc$dispatch("2083388401", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "91159325")) {
                    ipChange.ipc$dispatch("91159325", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TickletDetailViewPager.this.resetHeight(i);
            }
        });
        resetHeight(0);
    }

    public TickletDetailViewPagerAdapter getPagerAdapter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1487045894")) {
            return this.pagerAdapter;
        }
        return (TickletDetailViewPagerAdapter) ipChange.ipc$dispatch("1487045894", new Object[]{this});
    }

    public void onDestory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1769077555")) {
            ipChange.ipc$dispatch("1769077555", new Object[]{this});
            return;
        }
        TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = this.pagerAdapter;
        if (tickletDetailViewPagerAdapter != null) {
            tickletDetailViewPagerAdapter.h();
            this.pagerAdapter = null;
        }
    }

    public void setCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001185729")) {
            ipChange.ipc$dispatch("1001185729", new Object[]{this, tickletTicketCallback});
            return;
        }
        this.callback = tickletTicketCallback;
    }

    public void update(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063140427")) {
            ipChange.ipc$dispatch("-2063140427", new Object[]{this, ticketDeatilResult});
        } else if (ticketDeatilResult == null) {
            setVisibility(8);
        } else if (ticketDeatilResult.getTicketInfoList() == null || ticketDeatilResult.getTicketInfoList().size() == 0) {
            TickletTicketCallback tickletTicketCallback = this.callback;
            if (tickletTicketCallback != null) {
                tickletTicketCallback.renderFailXflush(vl2.TICKLET_PERFORM_DETAIL_RENDER_TICKLET_LIST_FAIL_MSG);
            }
            setVisibility(8);
        } else {
            setVisibility(0);
            Collections.sort(ticketDeatilResult.getTicketInfoList());
            if (this.pagerAdapter == null) {
                TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = new TickletDetailViewPagerAdapter(this.context);
                this.pagerAdapter = tickletDetailViewPagerAdapter;
                setAdapter(tickletDetailViewPagerAdapter);
                this.pagerAdapter.l(this);
            }
            if (ticketDeatilResult.isNftPerform()) {
                this.pagerAdapter.m(gl2.TICKLET_TICKET_VIEW_DETAIL_NFT);
            } else {
                this.pagerAdapter.m("DEFAULT");
            }
            this.pagerAdapter.i(this.callback);
            this.pagerAdapter.j(ticketDeatilResult.getTicketInfoList());
            this.pagerAdapter.k(ticketDeatilResult, null);
            this.pagerAdapter.notifyDataSetChanged();
        }
    }

    public void updateTicket(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020193456")) {
            ipChange.ipc$dispatch("1020193456", new Object[]{this, userTicketTable});
            return;
        }
        this.pagerAdapter.n(userTicketTable);
    }

    public TickletDetailViewPager(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        initView();
    }
}
