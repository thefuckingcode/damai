package tb;

import com.alibaba.pictures.bricks.fragment.ScriptDetailFragment;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class y42 implements IImageFailListener {
    public static final /* synthetic */ y42 a = new y42();

    private /* synthetic */ y42() {
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        ScriptDetailFragment.m162updateHeaderBg$lambda8$lambda7(failEvent);
    }
}
