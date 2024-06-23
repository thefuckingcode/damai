package tb;

import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
public final /* synthetic */ class bs0 implements IImageSuccListener {
    public final /* synthetic */ Object a;
    public final /* synthetic */ GenericBannerPresenterExt b;
    public final /* synthetic */ GenericItem c;

    public /* synthetic */ bs0(Object obj, GenericBannerPresenterExt genericBannerPresenterExt, GenericItem genericItem) {
        this.a = obj;
        this.b = genericBannerPresenterExt;
        this.c = genericItem;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        GenericBannerPresenterExt.m143init$lambda10$lambda9$lambda8$lambda7$lambda5(this.a, this.b, this.c, successEvent);
    }
}
