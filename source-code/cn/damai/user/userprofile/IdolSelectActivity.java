package cn.damai.user.userprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.view.PagerSlidingTabStrip;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.IdolSelectRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class IdolSelectActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<IdolSelectFragment> mCategoryListFragments;
    ViewPager myViewpager;
    IdolSelectAdapter pagerAdapter;
    int position = 0;
    PagerSlidingTabStrip tabs;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1731701136")) {
                ipChange.ipc$dispatch("-1731701136", new Object[]{this, view});
                return;
            }
            IdolSelectActivity.this.setResult(0, new Intent());
            IdolSelectActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1804087694")) {
                ipChange.ipc$dispatch("-1804087694", new Object[]{this, view});
                return;
            }
            IdolSelectActivity.this.finish();
        }
    }

    private void initPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737898323")) {
            ipChange.ipc$dispatch("737898323", new Object[]{this});
            return;
        }
        findViewById(R$id.select_null).setOnClickListener(new a());
        this.mCategoryListFragments = new ArrayList();
        int size = IdolSelectRequest.tabs.size();
        for (int i = 0; i < size; i++) {
            IdolSelectFragment idolSelectFragment = new IdolSelectFragment();
            idolSelectFragment.setType(IdolSelectRequest.tabIds.get(i));
            this.mCategoryListFragments.add(idolSelectFragment);
        }
        IdolSelectAdapter idolSelectAdapter = new IdolSelectAdapter(getSupportFragmentManager(), this.mCategoryListFragments, IdolSelectRequest.tabs.toArray());
        this.pagerAdapter = idolSelectAdapter;
        this.myViewpager.setAdapter(idolSelectAdapter);
        this.myViewpager.setOffscreenPageLimit(1);
        this.myViewpager.setCurrentItem(0);
        this.tabs.setViewPager(this.myViewpager);
        this.tabs.setFadingEdgeLength(0);
        this.tabs.notifyDataSetChanged();
        this.myViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.user.userprofile.IdolSelectActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1644086977")) {
                    ipChange.ipc$dispatch("1644086977", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1843700832")) {
                    ipChange.ipc$dispatch("1843700832", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1547891532")) {
                    ipChange.ipc$dispatch("1547891532", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                IdolSelectActivity.this.position = i;
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333694310")) {
            ipChange.ipc$dispatch("-1333694310", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1535215888")) {
            return R$layout.idol_select;
        }
        return ((Integer) ipChange.ipc$dispatch("1535215888", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514946453")) {
            ipChange.ipc$dispatch("-1514946453", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652161312")) {
            ipChange.ipc$dispatch("1652161312", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995675517")) {
            ipChange.ipc$dispatch("1995675517", new Object[]{this});
            return;
        }
        this.myViewpager = (ViewPager) findViewById(R$id.vPager);
        this.tabs = (PagerSlidingTabStrip) findViewById(R$id.indicator);
        initPage();
        this.base_header_left.setOnClickListener(new b());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822151779")) {
            ipChange.ipc$dispatch("-822151779", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new a.b().i("circle_list"));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272395878")) {
            ipChange.ipc$dispatch("-272395878", new Object[]{this});
            return;
        }
        stopProgressDialog();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "457597243")) {
            ipChange.ipc$dispatch("457597243", new Object[]{this});
            return;
        }
        startProgressDialog();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628464890")) {
            ipChange.ipc$dispatch("-1628464890", new Object[]{this});
            return;
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-536456316")) {
            return "选择圈子";
        }
        return (String) ipChange.ipc$dispatch("-536456316", new Object[]{this});
    }
}
