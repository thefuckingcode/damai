package cn.damai.ultron.view.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.adapter.DmUltronPromotionAdapterOld;
import cn.damai.ultron.view.bean.DmPromotionOptionsBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import tb.w90;

/* compiled from: Taobao */
public class DmUltronPromotionActivityOld extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private String TAG_ID;
    DmChooseSwitchListenerImpl<DmPromotionOptionsBean> itemClickListener = new a();
    private List<DmPromotionOptionsBean> mPromotionBeanList;
    private String selectId;

    /* compiled from: Taobao */
    public class a implements DmChooseSwitchListenerImpl<DmPromotionOptionsBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void chooseItemListener(DmPromotionOptionsBean dmPromotionOptionsBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1877508849")) {
                ipChange.ipc$dispatch("1877508849", new Object[]{this, dmPromotionOptionsBean, Integer.valueOf(i)});
            } else if (dmPromotionOptionsBean != null) {
                try {
                    w90.h(DmUltronPromotionActivityOld.this, dmPromotionOptionsBean.fullTitle);
                    w90.i(DmUltronPromotionActivityOld.this, dmPromotionOptionsBean.id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (DmUltronPromotionActivityOld.this.selectId == null || !DmUltronPromotionActivityOld.this.selectId.equals(dmPromotionOptionsBean.id)) {
                    Intent intent = new Intent();
                    intent.putExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, dmPromotionOptionsBean.id);
                    intent.putExtra(SocialConstants.PARAM_APP_DESC, dmPromotionOptionsBean.title);
                    intent.putExtra("tag_id", DmUltronPromotionActivityOld.this.TAG_ID);
                    DmUltronPromotionActivityOld.this.setResult(-1, intent);
                }
                DmUltronPromotionActivityOld.this.finishActivity();
            }
        }
    }

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446655155")) {
            ipChange.ipc$dispatch("-446655155", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        Bundle bundle = null;
        if (intent != null) {
            bundle = intent.getExtras();
        }
        if (bundle != null) {
            this.selectId = bundle.getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            String string = bundle.getString("paramvalue");
            this.TAG_ID = bundle.getString("tag_id");
            List parseArray = JSON.parseArray(string, DmPromotionOptionsBean.class);
            if (this.mPromotionBeanList == null) {
                this.mPromotionBeanList = new ArrayList();
            }
            if (parseArray != null) {
                this.mPromotionBeanList.addAll(parseArray);
            }
        }
    }

    private void setRecyclerView() {
        List<DmPromotionOptionsBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760454823")) {
            ipChange.ipc$dispatch("760454823", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null && (list = this.mPromotionBeanList) != null) {
            DmUltronPromotionAdapterOld dmUltronPromotionAdapterOld = new DmUltronPromotionAdapterOld(this, list, this.itemClickListener);
            dmUltronPromotionAdapterOld.g(this.selectId);
            recyclerView.setAdapter(dmUltronPromotionAdapterOld);
        }
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "864945636")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("864945636", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2130148042")) {
            return "店铺优惠";
        }
        return (String) ipChange.ipc$dispatch("2130148042", new Object[]{this});
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2026682930")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2026682930", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088431794")) {
            ipChange.ipc$dispatch("1088431794", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
        setRecyclerView();
    }
}
