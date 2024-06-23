package com.alient.onearch.adapter.component.pager;

import android.app.Activity;
import android.util.SparseArray;
import com.google.common.collect.Lists;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.VDefaultAdapter;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PagerGridPresenter$init$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ GenericItem $item;
    final /* synthetic */ PagerGridPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerGridPresenter$init$1(PagerGridPresenter pagerGridPresenter, GenericItem genericItem, Activity activity) {
        super(0);
        this.this$0 = pagerGridPresenter;
        this.$item = genericItem;
        this.$activity = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final String invoke() {
        String pathConfig;
        ComponentConfigBean.ComponentBean componentBean;
        ComponentConfigBean.ComponentBean.LayoutBean layout;
        HashMap<String, Object> params;
        List<DATA> list;
        ConfigManager configManager = this.$item.getPageContext().getConfigManager();
        Integer num = null;
        if (configManager == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null) {
            return null;
        }
        SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(this.$activity, pathConfig);
        if (!(componentConfigs == null || (componentBean = componentConfigs.get(PageUtil.INSTANCE.getItemType(this.$item))) == null || (layout = componentBean.getLayout()) == null || (params = layout.getParams()) == null)) {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            int i = this.this$0.getDimenId(this.$activity, params, "rowHeight");
            if (i != 0) {
                ref$ObjectRef.element = (T) Integer.valueOf(this.$activity.getResources().getDimensionPixelSize(i));
            }
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = 0;
            int i2 = this.this$0.getDimenId(this.$activity, params, Constants.GAP);
            if (i2 != 0) {
                ref$IntRef.element = this.$activity.getResources().getDimensionPixelSize(i2);
            }
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = 0;
            Ref$IntRef ref$IntRef3 = new Ref$IntRef();
            ref$IntRef3.element = 0;
            int i3 = this.this$0.getDimenId(this.$activity, params, "listMarginLeft");
            if (i3 != 0) {
                ref$IntRef2.element = this.$activity.getResources().getDimensionPixelSize(i3);
            }
            int i4 = this.this$0.getDimenId(this.$activity, params, "listMarginRight");
            if (i4 != 0) {
                ref$IntRef3.element = this.$activity.getResources().getDimensionPixelSize(i4);
            }
            Object obj = params.get("rowCount");
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num2 = (Integer) obj;
            Object obj2 = params.get(Constants.Name.COLUMN_COUNT);
            if (obj2 instanceof Integer) {
                num = obj2;
            }
            Integer num3 = num;
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = this.$item.getComponent().getInnerAdapter();
            if (!(ref$ObjectRef.element == null || num2 == null || num3 == null || innerAdapter == null || (list = innerAdapter.data) == null)) {
                List<List> n = Lists.n(list, num2.intValue() * num3.intValue());
                k21.h(n, "Lists.partition(this, rowCount * columnCount)");
                for (List list2 : n) {
                    Activity activity = this.$item.getPageContext().getActivity();
                    k21.f(activity);
                    VDefaultAdapter vDefaultAdapter = new VDefaultAdapter(activity);
                    vDefaultAdapter.setPageContext(innerAdapter.getPageContext());
                    vDefaultAdapter.m886setViewTypeSupport(innerAdapter.getViewTypeSupport());
                    vDefaultAdapter.setData(list2);
                    this.this$0.childAdapters.add(vDefaultAdapter);
                }
                this.$item.getPageContext().runOnUIThreadLocked(new PagerGridPresenter$init$1$$special$$inlined$apply$lambda$3(num2, num3, innerAdapter, ref$IntRef, ref$IntRef2, ref$IntRef3, ref$ObjectRef, this));
            }
        }
        return pathConfig;
    }
}
