package tb;

import com.alibaba.pictures.bricks.bean.HomeBallBean;
import com.alibaba.pictures.bricks.component.home.ball.HomeBallView;

/* compiled from: Taobao */
public final /* synthetic */ class mv0 implements Runnable {
    public final /* synthetic */ HomeBallView a;
    public final /* synthetic */ HomeBallBean b;

    public /* synthetic */ mv0(HomeBallView homeBallView, HomeBallBean homeBallBean) {
        this.a = homeBallView;
        this.b = homeBallBean;
    }

    public final void run() {
        HomeBallView.b.b(this.a, this.b);
    }
}
