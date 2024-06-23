package cn.damai.ultron.secondpage.deliveryway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.ultron.R$id;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.activity.DmPopWindowBaseActivity;
import cn.damai.ultron.view.bean.DmDeliveryWayBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.ma0;
import tb.xf2;

/* compiled from: Taobao */
public class DmUltronDeliveryWayActivity extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    DmChooseSwitchListenerImpl<List<DmDeliveryWayBean>> itemClickListener = new a();
    private DmDeliveryWayAdapter mAdapter;
    private String mCurrentDeliveryWayType;
    private List<DmDeliveryWayBean> mDeliveryWayEntries = new ArrayList();
    private RecyclerView mRecyclerView;

    /* compiled from: Taobao */
    public class a implements DmChooseSwitchListenerImpl<List<DmDeliveryWayBean>> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void chooseItemListener(List<DmDeliveryWayBean> list, int i) {
            DmDeliveryWayBean dmDeliveryWayBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1320767713")) {
                ipChange.ipc$dispatch("1320767713", new Object[]{this, list, Integer.valueOf(i)});
            } else if (i < xf2.e(list) && i >= 0 && (dmDeliveryWayBean = list.get(i)) != null) {
                c.e().x(ma0.u().k(DmUltronDeliveryWayActivity.this, dmDeliveryWayBean.desc, i));
                String str = dmDeliveryWayBean.deliveryType;
                if (DmUltronDeliveryWayActivity.this.mCurrentDeliveryWayType == null || !DmUltronDeliveryWayActivity.this.mCurrentDeliveryWayType.equalsIgnoreCase(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("deliveryWayEntries", JSON.toJSONString(list));
                    Intent intent = new Intent();
                    intent.putExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, dmDeliveryWayBean.deliveryType);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, dmDeliveryWayBean.desc);
                    intent.putExtra("eventparams", JSON.toJSONString(hashMap));
                    DmUltronDeliveryWayActivity.this.setResult(-1, intent);
                }
                DmUltronDeliveryWayActivity.this.finishActivity();
            }
        }
    }

    private void getComponentData(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93646685")) {
            ipChange.ipc$dispatch("-93646685", new Object[]{this, bundle});
        } else if (bundle != null && bundle.containsKey(ScriptSelectFragment.EXTRA_KEY_SELECT_ID)) {
            this.mCurrentDeliveryWayType = bundle.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
        }
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1528120168")) {
            ipChange.ipc$dispatch("1528120168", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle bundle = null;
        if (intent != null) {
            bundle = intent.getExtras();
        }
        getComponentData(bundle);
        getDeliveryWayList(bundle);
    }

    private void getDeliveryWayList(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961295563")) {
            ipChange.ipc$dispatch("-961295563", new Object[]{this, bundle});
        } else if (bundle != null && bundle.containsKey("param")) {
            try {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("param");
                if (xf2.e(parcelableArrayList) > 0) {
                    this.mDeliveryWayEntries.clear();
                    this.mDeliveryWayEntries.addAll(parcelableArrayList);
                    DmDeliveryWayAdapter dmDeliveryWayAdapter = this.mAdapter;
                    if (dmDeliveryWayAdapter != null) {
                        dmDeliveryWayAdapter.notifyDataSetChanged();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709754430")) {
            ipChange.ipc$dispatch("-709754430", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            DmDeliveryWayAdapter dmDeliveryWayAdapter = new DmDeliveryWayAdapter(this, this.mDeliveryWayEntries, this.itemClickListener);
            this.mAdapter = dmDeliveryWayAdapter;
            this.mRecyclerView.setAdapter(dmDeliveryWayAdapter);
        }
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-605263617")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-605263617", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "70144271")) {
            return "选择配送方式";
        }
        return (String) ipChange.ipc$dispatch("70144271", new Object[]{this});
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1179791497")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1179791497", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402965107")) {
            ipChange.ipc$dispatch("402965107", new Object[]{this, view});
        } else if (view.getId() == R$id.v_outside) {
            finishActivity();
        } else if (view.getId() == R$id.text_ok) {
            c.e().x(ma0.u().j(this));
            finishActivity();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529774925")) {
            ipChange.ipc$dispatch("529774925", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
