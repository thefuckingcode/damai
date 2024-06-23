package tb;

import com.alibaba.pictures.bricks.util.htmlparser.DefaultImageGetter;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class w40 implements IImageFailListener {
    public static final /* synthetic */ w40 a = new w40();

    private /* synthetic */ w40() {
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        DefaultImageGetter.a(failEvent);
    }
}
