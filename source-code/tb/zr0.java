package tb;

import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alibaba.pictures.bricks.util.DMRGBUtil;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
public final /* synthetic */ class zr0 implements DMRGBUtil.OnFetchColorListener {
    public final /* synthetic */ GenericBannerPresenterExt a;
    public final /* synthetic */ GenericItem b;

    public /* synthetic */ zr0(GenericBannerPresenterExt genericBannerPresenterExt, GenericItem genericItem) {
        this.a = genericBannerPresenterExt;
        this.b = genericItem;
    }

    @Override // com.alibaba.pictures.bricks.util.DMRGBUtil.OnFetchColorListener
    public final void onFetchColor(int i) {
        GenericBannerPresenterExt.m144init$lambda10$lambda9$lambda8$lambda7$lambda5$lambda4(this.a, this.b, i);
    }
}
