package android.taobao.windvane.embed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;

/* compiled from: Taobao */
public class Empty extends BaseEmbedView {
    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public View generateView(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundColor(-7829368);
        textView.setText("Empty View");
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setTextSize(30.0f);
        textView.setGravity(17);
        return textView;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.embed.BaseEmbedView
    public String getViewType() {
        return DXRecyclerLayout.LOAD_MORE_EMPTY;
    }
}
