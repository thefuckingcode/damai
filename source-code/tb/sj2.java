package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;

/* compiled from: Taobao */
public class sj2 {
    @NonNull
    public static DXTemplateItem a(@NonNull mc0 mc0) {
        DXTemplateItem dXTemplateItem = new DXTemplateItem();
        if (mc0 == null) {
            return dXTemplateItem;
        }
        dXTemplateItem.name = mc0.c;
        long j = -1;
        try {
            j = Long.parseLong(mc0.e);
        } catch (NumberFormatException unused) {
        }
        dXTemplateItem.version = j;
        dXTemplateItem.templateUrl = mc0.d;
        return dXTemplateItem;
    }

    @NonNull
    public static mc0 b(DXTemplateItem dXTemplateItem) {
        mc0 mc0 = new mc0();
        if (dXTemplateItem == null) {
            return mc0;
        }
        mc0.c = dXTemplateItem.name;
        mc0.e = String.valueOf(dXTemplateItem.version);
        mc0.d = dXTemplateItem.templateUrl;
        return mc0;
    }
}
