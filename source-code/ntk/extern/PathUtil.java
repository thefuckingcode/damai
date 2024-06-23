package ntk.extern;

import androidx.annotation.Keep;
import com.youku.core.context.YoukuContext;

@Keep
/* compiled from: Taobao */
public final class PathUtil {
    public static String getSystemRootPath() {
        return YoukuContext.getApplication().getFilesDir().getAbsolutePath();
    }
}
