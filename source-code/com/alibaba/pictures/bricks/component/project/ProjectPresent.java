package com.alibaba.pictures.bricks.component.project;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.alibaba.pictures.bricks.component.project.ProjectContract;
import com.alibaba.pictures.bricks.component.project.bean.Daojishi;
import com.alibaba.pictures.bricks.component.project.bean.SearchYouKuHelper;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;
import java.util.Map;
import tb.sb2;
import tb.u50;
import tb.x52;

/* compiled from: Taobao */
public class ProjectPresent extends AbsPresenter<IItem<ItemValue>, ProjectContract.Model<IItem<ItemValue>>, ProjectContract.View> implements ProjectContract.Presenter<IItem<ItemValue>, ProjectContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public Daojishi mDaojishi = new Daojishi(true);

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IItem a;

        a(IItem iItem) {
            this.a = iItem;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-912596735")) {
                ipChange.ipc$dispatch("-912596735", new Object[]{this, view});
                return;
            }
            ProjectPresent projectPresent = ProjectPresent.this;
            projectPresent.userTrackClick(projectPresent.dName(), ProjectPresent.this.getTrackArgsTemp(), true);
            sb2.a(this.a.getPageContext().getActivity(), ((ProjectContract.Model) ProjectPresent.this.model).getProjectItemBean().schema, ((ProjectContract.Model) ProjectPresent.this.model).getProjectItemBean().id, ((ProjectContract.Model) ProjectPresent.this.model).getProjectItemBean().name, ((ProjectContract.Model) ProjectPresent.this.model).getProjectItemBean().verticalPic);
        }
    }

    public ProjectPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String dName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64418280")) {
            return (String) ipChange.ipc$dispatch("64418280", new Object[]{this});
        }
        return "item_" + this.item.getIndex();
    }

    private void setDaojishiServerTime(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963399474")) {
            ipChange.ipc$dispatch("1963399474", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        this.mDaojishi.setServiceTimeAndDiff(SearchYouKuHelper.parseServerInfo(j), j2);
    }

    private void typeMap(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2111969088")) {
            ipChange.ipc$dispatch("2111969088", new Object[]{this, map});
            return;
        }
        map.put("item_id", ((ProjectContract.Model) this.model).getProjectItemBean().id);
        if (((ProjectContract.Model) this.model).getProjectItemBean().showStatus == null || TextUtils.isEmpty(((ProjectContract.Model) this.model).getProjectItemBean().showStatus.id) || !"2".equals(((ProjectContract.Model) this.model).getProjectItemBean().showStatus.id)) {
            map.put("status", "0");
        } else {
            map.put("status", "1");
        }
        String gotMarketUTValue = ((ProjectContract.Model) this.model).getProjectItemBean().gotMarketUTValue();
        if (!TextUtils.isEmpty(gotMarketUTValue)) {
            map.put("discount_type", gotMarketUTValue);
        }
    }

    public Map<String, String> getTrackArgsTemp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213559602")) {
            return (Map) ipChange.ipc$dispatch("1213559602", new Object[]{this});
        }
        HashMap hashMap = new HashMap(getTrackArgs());
        typeMap(hashMap);
        return hashMap;
    }

    @Override // com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter, com.alient.onearch.adapter.view.AbsPresenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634823199")) {
            ipChange.ipc$dispatch("634823199", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        if (((ProjectContract.Model) this.model).getProjectItemBean() != null) {
            setDaojishiServerTime(((ProjectContract.Model) this.model).getServerTime(), ((ProjectContract.Model) this.model).getNativeDiffTime());
            ((ProjectContract.View) this.view).getHolder().u(this.mDaojishi);
            ((ProjectContract.View) this.view).getHolder().l(((ProjectContract.Model) this.model).getProjectItemBean(), BricksProjectViewHolder.PageType.SEARCH_PAGE);
            BricksProjectViewHolder holder = ((ProjectContract.View) this.view).getHolder();
            u50 u50 = u50.INSTANCE;
            holder.w(u50.b(this.item.getPageContext().getActivity(), 63), u50.b(this.item.getPageContext().getActivity(), 84));
            ((ProjectContract.View) this.view).getRenderView().setOnClickListener(new a(iItem));
            userTrackExpose(((ProjectContract.View) this.view).getRenderView(), dName(), getTrackArgsTemp());
            x52.a(this, ((ProjectContract.View) this.view).getHolder().itemView);
            if (this.item.getComponent().getChildCount() - 1 != this.item.getIndex()) {
                ((ProjectContract.View) this.view).getHolder().i().setVisibility(0);
            } else {
                ((ProjectContract.View) this.view).getHolder().i().setVisibility(8);
            }
        }
    }
}
