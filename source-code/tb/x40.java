package tb;

import com.alibaba.pictures.bricks.util.htmlparser.DefaultImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class x40 implements IImageSuccListener {
    public final /* synthetic */ DefaultImageGetter a;
    public final /* synthetic */ ImageGetterCallBack b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public /* synthetic */ x40(DefaultImageGetter defaultImageGetter, ImageGetterCallBack imageGetterCallBack, String str, int i, int i2) {
        this.a = defaultImageGetter;
        this.b = imageGetterCallBack;
        this.c = str;
        this.d = i;
        this.e = i2;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        DefaultImageGetter.b(this.a, this.b, this.c, this.d, this.e, successEvent);
    }
}
