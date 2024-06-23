package tb;

import android.util.Log;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class m91 implements LottieLogger {
    private static final Set<String> a = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str) {
        debug(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(String str, Throwable th) {
        if (k61.a) {
            Log.d(k61.TAG, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String str) {
        warning(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str, Throwable th) {
        if (k61.a) {
            Log.d(k61.TAG, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void warning(String str, Throwable th) {
        Set<String> set = a;
        if (!set.contains(str)) {
            Log.w(k61.TAG, str, th);
            set.add(str);
        }
    }
}
