package tb;

import android.widget.ImageView;
import com.alibaba.pictures.bricks.component.home.DMGenericHeaderView;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;

/* compiled from: Taobao */
public final /* synthetic */ class oq implements IImageSuccListener {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ DMGenericHeaderView b;

    public /* synthetic */ oq(ImageView imageView, DMGenericHeaderView dMGenericHeaderView) {
        this.a = imageView;
        this.b = dMGenericHeaderView;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        DMGenericHeaderView.b(this.a, this.b, successEvent);
    }
}
