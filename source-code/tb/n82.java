package tb;

import com.alibaba.motu.tbrest.SendService;

/* compiled from: Taobao */
public class n82 {
    private static final Integer a = 61004;
    private static final String b = null;

    public static boolean a(String str, String str2) {
        try {
            Boolean sendRequest = SendService.getInstance().sendRequest(b, System.currentTimeMillis(), null, a.intValue(), "AliHA", str2, str, null);
            if (sendRequest.booleanValue()) {
                p91.d("SendManager", "send success");
            } else {
                p91.g("SendManager", "send failure");
            }
            return sendRequest.booleanValue();
        } catch (Throwable th) {
            p91.f(th);
            return false;
        }
    }
}
