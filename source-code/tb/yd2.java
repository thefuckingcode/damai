package tb;

import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.tetris.component.star.header.a;

/* compiled from: Taobao */
public final /* synthetic */ class yd2 implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ ImageView a;

    public /* synthetic */ yd2(ImageView imageView) {
        this.a = imageView;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        a.g(this.a, eVar);
    }
}
