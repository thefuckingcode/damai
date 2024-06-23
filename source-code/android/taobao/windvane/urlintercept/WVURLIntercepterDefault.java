package android.taobao.windvane.urlintercept;

import android.content.Context;
import android.taobao.windvane.config.ModuleConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVConfigUtils;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.connect.ApiUrlManager;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.urlintercept.WVURLInterceptData;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVURLIntercepterDefault implements WVURLIntercepterInterface {
    private static final String ADDRESS = "http://my.m.taobao.com/deliver/wap_deliver_address_list.htm";
    private static final String CART = "http://h5.m.taobao.com/awp/base/cart.htm";
    private static final String DETAIL = "http://a.m.taobao.com/i";
    private static final String FAV = "http://fav.m.taobao.com/my_collect_list.htm";
    private static final String LOGIN = "http://login.m.taobao.com/login.htm";
    private static final String MYTAOBAO = "http://my.m.taobao.com/myTaobao.htm";
    private static final String ORDER_LIST = "http://trade.taobao.com/trade/itemlist/list_bought_items.htm";
    private static final String SEARCH = "http://s.m.taobao.com/search.htm?q=";
    private static final String SHOP = "http://shop.m.taobao.com/shop/shop_index.htm";
    private static final String TAG = "WVUrlResolver";
    private boolean isUpdating = false;

    public WVURLIntercepterDefault() {
        if (isNeedupdateURLRule(true)) {
            updateURLRule();
        }
        refreshConfig(null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getStorageKeyPrefix() {
        return getClass().getName();
    }

    public static String hitURLInterceptRules(String str) {
        WVURLInterceptData.URLInfo parse;
        if (TextUtils.isEmpty(str) || (parse = parse(str)) == null || parse.code == 0) {
            return null;
        }
        return WVUrlUtil.rebuildWVurl(str, toUri(parse));
    }

    public static WVURLInterceptData.URLInfo parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (WVURLInterceptService.getWVURLinterceptRules() != null && WVURLInterceptService.getWVURLinterceptRules().isEmpty()) {
            return null;
        }
        WVURLInterceptData.URLInfo parseByTag = WVURLInterceptHelper.parseByTag(str);
        if (parseByTag == null || parseByTag.code <= 0) {
            return WVURLInterceptHelper.parseByRule(str, WVURLInterceptService.getWVURLinterceptRules(), WVURLInterceptService.getWVURLInterceptRulePats());
        }
        TaoLog.d(TAG, "parse url success through tag.");
        return parseByTag;
    }

    private void refreshConfig(List<WVURLInterceptData.RuleData> list) {
        if (list == null) {
            list = WVURLInterceptHelper.parseRuleData(readConfigFile());
        }
        if (WVCommonConfig.commonConfig.urlRuleStatus == 2 && list != null && WVServerConfig.URL_FILTER) {
            WVURLInterceptService.resetRulesAndPat();
            for (WVURLInterceptData.RuleData ruleData : list) {
                WVURLInterceptService.getWVURLinterceptRules().add(ruleData);
            }
        }
    }

    public static String toUri(WVURLInterceptData.URLInfo uRLInfo) {
        if (uRLInfo == null) {
            return null;
        }
        int i = uRLInfo.code;
        Map<String, String> map = uRLInfo.params;
        if (i == 100) {
            return DETAIL + map.get(WVURLRuleConstants.WV_PARAM_HY_ITM_ID) + ".htm";
        } else if (i == 200) {
            return SEARCH + map.get(WVURLRuleConstants.WV_PARAM_HY_S_Q);
        } else {
            if (i == 300) {
                String str = map.get(WVURLRuleConstants.WV_PARAM_HY_SHOP_ID);
                String str2 = map.get(WVURLRuleConstants.WV_PARAM_HY_USER_ID);
                if (!TextUtils.isEmpty(str2)) {
                    return "http://shop.m.taobao.com/shop/shop_index.htm?user_id=" + str2;
                } else if (!TextUtils.isEmpty(str)) {
                    return "http://shop.m.taobao.com/shop/shop_index.htm?shop_id=" + str;
                }
            } else if (i == 400) {
                return CART;
            } else {
                if (i == 600) {
                    return MYTAOBAO;
                }
                if (i == 700) {
                    return FAV;
                }
                if (i == 500) {
                    return ORDER_LIST;
                }
                if (i == 800) {
                    return ADDRESS;
                }
                if (i == 1000) {
                    return LOGIN;
                }
            }
            return uRLInfo.url;
        }
    }

    /* access modifiers changed from: protected */
    public String getConfigUrl() {
        return ApiUrlManager.getConfigUrl("urlRule.json", "2");
    }

    @Override // android.taobao.windvane.urlintercept.WVURLIntercepterInterface
    public boolean isNeedupdateURLRule(boolean z) {
        if (!isOpenURLIntercept()) {
            return false;
        }
        return WVConfigUtils.isNeedUpdate(z, WVConfigUtils.SPNAME, getStorageKeyPrefix());
    }

    @Override // android.taobao.windvane.urlintercept.WVURLIntercepterInterface
    public boolean isOpenURLIntercept() {
        return ModuleConfig.getInstance().url_updateConfig;
    }

    /* access modifiers changed from: protected */
    public boolean needSaveConfig(String str) {
        List<WVURLInterceptData.RuleData> parseRuleData;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject jSONObject = null;
        ApiResponse apiResponse = new ApiResponse();
        if (apiResponse.parseJsonResult(str).success) {
            jSONObject = apiResponse.data;
        }
        if (jSONObject == null || (parseRuleData = WVURLInterceptHelper.parseRuleData(jSONObject.toString())) == null || parseRuleData.isEmpty()) {
            return false;
        }
        refreshConfig(parseRuleData);
        return true;
    }

    /* access modifiers changed from: protected */
    public String readConfigFile() {
        String str = WVConfigUtils.SPNAME;
        return ConfigStorage.getStringVal(str, getStorageKeyPrefix() + ConfigStorage.KEY_DATA);
    }

    /* access modifiers changed from: protected */
    public void saveConfigFile(String str) {
        String str2 = WVConfigUtils.SPNAME;
        ConfigStorage.putStringVal(str2, getStorageKeyPrefix() + ConfigStorage.KEY_DATA, str);
    }

    @Override // android.taobao.windvane.urlintercept.WVURLIntercepterInterface
    public boolean shouldOverrideUrlLoading(Context context, IWVWebView iWVWebView, String str) {
        WVURLInterceptData.URLInfo parse = parse(str);
        if (parse == null || WVURLInterceptService.getWVURLInterceptHandler() == null) {
            return false;
        }
        return WVURLInterceptService.getWVURLInterceptHandler().doURLIntercept(context, iWVWebView, str, parse);
    }

    @Override // android.taobao.windvane.urlintercept.WVURLIntercepterInterface
    public void updateURLRule() {
        if (!this.isUpdating) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "doUpdateConfig: " + getConfigUrl());
            }
            this.isUpdating = true;
            ConnectManager.getInstance().connect(getConfigUrl(), new HttpConnectListener<HttpResponse>() {
                /* class android.taobao.windvane.urlintercept.WVURLIntercepterDefault.AnonymousClass1 */

                public void onFinish(HttpResponse httpResponse, int i) {
                    if (httpResponse == null || httpResponse.getData() == null) {
                        WVURLIntercepterDefault.this.isUpdating = false;
                        return;
                    }
                    try {
                        String str = new String(httpResponse.getData(), "utf-8");
                        if (TaoLog.getLogStatus()) {
                            TaoLog.d(WVURLIntercepterDefault.TAG, "callback: Download config successfully.\nclass = " + getClass().getName() + "\ncontent=" + str);
                        }
                        if (WVURLIntercepterDefault.this.needSaveConfig(str)) {
                            String str2 = WVConfigUtils.SPNAME;
                            ConfigStorage.putLongVal(str2, WVURLIntercepterDefault.this.getStorageKeyPrefix() + ConfigStorage.KEY_TIME, System.currentTimeMillis());
                            WVURLIntercepterDefault.this.saveConfigFile(str);
                        }
                    } catch (UnsupportedEncodingException e) {
                        TaoLog.e(WVURLIntercepterDefault.TAG, "config encoding error. " + e.getMessage());
                    } catch (Throwable th) {
                        WVURLIntercepterDefault.this.isUpdating = false;
                        throw th;
                    }
                    WVURLIntercepterDefault.this.isUpdating = false;
                }
            });
        }
    }
}
