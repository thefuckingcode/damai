package cn.damai.setting;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.setting.adapter.PEntranceAdapter;
import cn.damai.setting.bean.PermissionBean;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vk1;
import tb.xs0;

/* compiled from: Taobao */
public class PermissionEntranceActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements SimpleTitleLayout.OnBtnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onBackClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2014674352")) {
                ipChange.ipc$dispatch("-2014674352", new Object[]{this});
                return;
            }
            PermissionEntranceActivity.this.finish();
        }

        @Override // cn.damai.uikit.view.SimpleTitleLayout.OnBtnClickListener
        public void onShareClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1127124464")) {
                ipChange.ipc$dispatch("-1127124464", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnItemClickListener<PermissionBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void onEditClick(PermissionBean permissionBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418335591")) {
                ipChange.ipc$dispatch("1418335591", new Object[]{this, permissionBean, Integer.valueOf(i)});
            }
        }

        /* renamed from: b */
        public void onItemClick(PermissionBean permissionBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-358606530")) {
                ipChange.ipc$dispatch("-358606530", new Object[]{this, permissionBean, Integer.valueOf(i)});
                return;
            }
            PermissionEntranceActivity.this.openAppSetting();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(PermissionBean permissionBean, int i) {
            vk1.a(this, permissionBean, i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openAppSetting() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568024434")) {
            ipChange.ipc$dispatch("568024434", new Object[]{this});
            return;
        }
        try {
            String packageName = getPackageName();
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            startActivity(intent.setData(Uri.parse("package:" + packageName)));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            } catch (Exception e2) {
                e2.printStackTrace();
                ToastUtil.a().j(xs0.a(), "请前往系统设置对权限进行变更！");
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167582829")) {
            ipChange.ipc$dispatch("-167582829", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1421893239")) {
            return R$layout.activity_permission_entrance;
        }
        return ((Integer) ipChange.ipc$dispatch("1421893239", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732981276")) {
            ipChange.ipc$dispatch("-732981276", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123278023")) {
            ipChange.ipc$dispatch("123278023", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9442166")) {
            ipChange.ipc$dispatch("9442166", new Object[]{this});
            return;
        }
        hideBaseLayout();
        SimpleTitleLayout simpleTitleLayout = (SimpleTitleLayout) findViewById(R$id.p_entrance_stl);
        simpleTitleLayout.enableImmersiveMode(this);
        simpleTitleLayout.showShareBtn(false);
        simpleTitleLayout.switchMode(true);
        simpleTitleLayout.setAlpha(1.0f);
        simpleTitleLayout.setListener(new a());
        simpleTitleLayout.setTitle("系统权限");
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.p_entrance_list);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration(this) {
            /* class cn.damai.setting.PermissionEntranceActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1396025966")) {
                    ipChange.ipc$dispatch("1396025966", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                rect.bottom = 3;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        PEntranceAdapter pEntranceAdapter = new PEntranceAdapter(this, new b());
        recyclerView.setAdapter(pEntranceAdapter);
        pEntranceAdapter.d(PermissionBean.getShowList());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1955321685")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-1955321685", new Object[]{this});
    }
}
