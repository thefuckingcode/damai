package tb;

import android.widget.ImageView;
import com.alibaba.pictures.bricks.component.home.DMGenericHeaderView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class nq implements IImageFailListener {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ DMGenericHeaderView b;

    public /* synthetic */ nq(ImageView imageView, DMGenericHeaderView dMGenericHeaderView) {
        this.a = imageView;
        this.b = dMGenericHeaderView;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        DMGenericHeaderView.a(this.a, this.b, failEvent);
    }
}
