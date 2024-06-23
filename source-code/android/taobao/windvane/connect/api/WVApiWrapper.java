package android.taobao.windvane.connect.api;

/* compiled from: Taobao */
public class WVApiWrapper {
    public static String formatBody(ApiRequest apiRequest, Class<? extends IApiAdapter> cls) {
        if (apiRequest == null || cls == null) {
            return "";
        }
        try {
            return ((IApiAdapter) cls.newInstance()).formatBody(apiRequest);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return "";
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String formatUrl(ApiRequest apiRequest, Class<? extends IApiAdapter> cls) {
        if (apiRequest == null || cls == null) {
            return "";
        }
        try {
            return ((IApiAdapter) cls.newInstance()).formatUrl(apiRequest);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return "";
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
