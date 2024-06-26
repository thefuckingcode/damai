package cn.damai.discover.main.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.discover.main.ui.adapter.ProjectListAdapter;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.kk2;
import tb.ne2;
import tb.u80;
import tb.za;

/* compiled from: Taobao */
public class ProjectListActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String DATA_LIST_KEY = "projectList";
    private List<ProjectItemBean> data;
    private DMIconFontTextView ivBack;
    private ProjectListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private final kk2 mUt = new kk2();

    /* compiled from: Taobao */
    public class a implements ProjectListAdapter.ProjectClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.discover.main.ui.adapter.ProjectListAdapter.ProjectClickListener
        public void onClick(int i, ProjectItemBean projectItemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1307168420")) {
                ipChange.ipc$dispatch("1307168420", new Object[]{this, Integer.valueOf(i), projectItemBean});
                return;
            }
            u80.j(ProjectListActivity.this, projectItemBean);
            za.j(ProjectListActivity.this.mUt.A(i, projectItemBean.id, true));
        }
    }

    /* compiled from: Taobao */
    public class b implements ProjectListAdapter.Exposure {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.discover.main.ui.adapter.ProjectListAdapter.Exposure
        public void exposureProject(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1892003992")) {
                ipChange.ipc$dispatch("1892003992", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
                return;
            }
            ProjectListActivity.this.mUt.u(view, projectItemBean.id, i, true);
        }
    }

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609764905")) {
            ipChange.ipc$dispatch("-1609764905", new Object[]{this});
        } else if (getIntent() == null) {
            finish();
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
            } else {
                this.data = (List) extras.getSerializable(DATA_LIST_KEY);
            }
        }
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980648257")) {
            ipChange.ipc$dispatch("-980648257", new Object[]{this});
            return;
        }
        this.mRecyclerView = (RecyclerView) findViewById(R$id.recycler_view);
        ProjectListAdapter projectListAdapter = new ProjectListAdapter(this, new a());
        this.mAdapter = projectListAdapter;
        projectListAdapter.c(new b());
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mAdapter.d(this.data);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534987942")) {
            ipChange.ipc$dispatch("-1534987942", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = ne2.a(this);
                findViewById.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
            return;
        }
        ne2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117888854")) {
            ipChange.ipc$dispatch("-1117888854", new Object[]{this});
            return;
        }
        this.bese_head_view.setVisibility(8);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.title_left_icon);
        this.ivBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        initTitleStatusBar();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348278245")) {
            ipChange.ipc$dispatch("-348278245", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1055876369")) {
            return R$layout.activity_theme_project_list_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-1055876369", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234427796")) {
            ipChange.ipc$dispatch("-234427796", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1601433281")) {
            ipChange.ipc$dispatch("-1601433281", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509220354")) {
            ipChange.ipc$dispatch("-509220354", new Object[]{this});
            return;
        }
        c.e().K(this);
        initExtra();
        initTitleView();
        initRecyclerView();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-478818204")) {
            ipChange.ipc$dispatch("-478818204", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.title_left_icon) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035703940")) {
            ipChange.ipc$dispatch("-1035703940", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(this.mUt.C());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1216007389")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-1216007389", new Object[]{this});
    }
}
