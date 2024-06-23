package tb;

import cn.damai.projectfiltercopy.listener.FilterParamChangeListener;
import com.alibaba.pictures.bricks.component.channel.ProjectFilterPresent;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
public final /* synthetic */ class au1 implements FilterParamChangeListener {
    public final /* synthetic */ GenericItem a;

    public /* synthetic */ au1(GenericItem genericItem) {
        this.a = genericItem;
    }

    @Override // cn.damai.projectfiltercopy.listener.FilterParamChangeListener
    public final void notifyFilterParamChanged() {
        ProjectFilterPresent.a(this.a);
    }
}
