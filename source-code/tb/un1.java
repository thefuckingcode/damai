package tb;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.IPageFactory;

/* compiled from: Taobao */
public class un1 implements IPageFactory {
    @Override // com.taobao.monitor.procedure.IPageFactory
    @NonNull
    public IPage createPage(@NonNull View view, boolean z) {
        return new qn1().l(lc0.g).i(view).e(z).a();
    }

    @Override // com.taobao.monitor.procedure.IPageFactory
    @NonNull
    public IPage createStartedPage(@NonNull Fragment fragment, String str, String str2, @NonNull View view, boolean z) {
        return new qn1().h(fragment).g(str).k(str2).l(lc0.g).i(view).e(z).a();
    }
}
