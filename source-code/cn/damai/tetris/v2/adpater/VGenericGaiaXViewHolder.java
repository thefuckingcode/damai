package cn.damai.tetris.v2.adpater;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.config.ComponentConfig;
import cn.damai.tetris.gaiax.GaiaXDefaultModel;
import cn.damai.tetris.gaiax.GaiaXDefaultPresenter;
import cn.damai.tetris.gaiax.GaiaXDefaultView;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class VGenericGaiaXViewHolder extends VBaseViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    protected GaiaXDefaultPresenter d;

    public VGenericGaiaXViewHolder(View view, IContext iContext, ComponentConfig componentConfig) {
        super(view, iContext);
        if (componentConfig != null) {
            try {
                Class<?> cls = Class.forName(componentConfig.vClass);
                this.d = (GaiaXDefaultPresenter) Class.forName(componentConfig.pClass).getConstructor(cls, String.class, w9.class).newInstance((GaiaXDefaultView) cls.getConstructor(View.class).newInstance(view), componentConfig.mClass, iContext);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private BaseNode g(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956711381")) {
            return (BaseNode) ipChange.ipc$dispatch("-1956711381", new Object[]{this, iSection});
        }
        BaseNode baseNode = new BaseNode();
        if (!(iSection == null || iSection.getItem() == null)) {
            baseNode.setItem(iSection.getItem());
            baseNode.setOffset(iSection.getIndex());
            baseNode.setTrackInfo(iSection.getTrackInfo());
            baseNode.setStyle(iSection.getStyleInfo());
            baseNode.setGaiaxConfig(iSection.getGaiaxConfig());
            if (iSection.getRawData() != null && !TextUtils.isEmpty(iSection.getRawData().getString("abBucket"))) {
                baseNode.setAbBucket(iSection.getRawData().getString("abBucket"));
            }
        }
        return baseNode;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public GaiaXDefaultModel b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169681218")) {
            return (GaiaXDefaultModel) ipChange.ipc$dispatch("-169681218", new Object[]{this});
        }
        GaiaXDefaultPresenter gaiaXDefaultPresenter = this.d;
        if (gaiaXDefaultPresenter == null) {
            return null;
        }
        gaiaXDefaultPresenter.setSection(this.b);
        GaiaXDefaultPresenter gaiaXDefaultPresenter2 = this.d;
        GaiaXDefaultModel gaiaXDefaultModel = (GaiaXDefaultModel) gaiaXDefaultPresenter2.createModel(g(gaiaXDefaultPresenter2.getSection()));
        this.d.init();
        return gaiaXDefaultModel;
    }
}
