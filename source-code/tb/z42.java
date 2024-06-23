package tb;

import com.alibaba.pictures.bricks.fragment.ScriptDetailFragment;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class z42 implements IImageSuccListener {
    public final /* synthetic */ ScriptDetailFragment a;

    public /* synthetic */ z42(ScriptDetailFragment scriptDetailFragment) {
        this.a = scriptDetailFragment;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        ScriptDetailFragment.m161updateHeaderBg$lambda8$lambda6(this.a, successEvent);
    }
}
