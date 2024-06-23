package com.alibaba.poplayerconsole.debug;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.a;
import com.alibaba.poplayer.trigger.b;
import com.alibaba.poplayer.trigger.view.d;
import com.alibaba.poplayerconsole.PopLayerDebugActivity;
import com.youku.arch.v3.core.Constants;
import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.c7;
import tb.cr1;
import tb.dr1;
import tb.fo1;
import tb.rg0;

/* compiled from: Taobao */
public class PopLayerDebugManager extends WVApiPlugin {
    private void hookConfigAdapter(a aVar, IConfigAdapter iConfigAdapter) throws IllegalAccessException {
        Field field;
        Field[] declaredFields = a.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            field.setAccessible(true);
            if (field.get(aVar) instanceof IConfigAdapter) {
                break;
            }
            i++;
        }
        field.set(aVar, iConfigAdapter);
    }

    private void singleStartMock(b bVar, String str) throws JSONException, IllegalAccessException {
        if (bVar.g().k() instanceof rg0) {
            ((rg0) bVar.g().k()).b = new JSONObject(str);
            return;
        }
        hookConfigAdapter(bVar.g(), new rg0(bVar.g().k(), new JSONObject(str)));
    }

    private boolean singleStopMock(b bVar) throws IllegalAccessException {
        if (!(bVar.g().k() instanceof rg0)) {
            return false;
        }
        hookConfigAdapter(bVar.g(), ((rg0) bVar.g().k()).a);
        return true;
    }

    private boolean startMock(String str, WVCallBackContext wVCallBackContext) throws IllegalAccessException, IllegalArgumentException, JSONException {
        singleStartMock(c7.A(), str);
        singleStartMock(fo1.A(), str);
        singleStartMock(d.M(), str);
        c7.A().d();
        fo1.A().d();
        d.M().d();
        PopLayer.getReference().updateCacheConfigAsync(1);
        PopLayer.getReference().updateCacheConfigAsync(2);
        PopLayer.getReference().updateCacheConfigAsync(3);
        cr1.b("PopLayerManager.startMock.success", new Object[0]);
        wVCallBackContext.success();
        return true;
    }

    private boolean stopMock(WVCallBackContext wVCallBackContext) throws IllegalAccessException, IllegalArgumentException {
        if (singleStopMock(c7.A())) {
            PopLayer.getReference().updateCacheConfigAsync(1);
            cr1.b("PopLayerManager.stopMock.success App.", new Object[0]);
        }
        if (singleStopMock(fo1.A())) {
            PopLayer.getReference().updateCacheConfigAsync(2);
            cr1.b("PopLayerManager.stopMock.success Page.", new Object[0]);
        }
        if (singleStopMock(d.M())) {
            PopLayer.getReference().updateCacheConfigAsync(3);
            cr1.b("PopLayerManager.stopMock.success View.", new Object[0]);
        }
        cr1.b("PopLayerManager.stopMock.success", new Object[0]);
        wVCallBackContext.success();
        return false;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        try {
            if ("enableMock".equals(str)) {
                cr1.b("PopLayerManager.jsEnableMock.params{%s}", str2);
                JSONObject jSONObject = (JSONObject) new JSONTokener(str2).nextValue();
                return jSONObject.optBoolean("enable", false) ? startMock(jSONObject.optString(Constants.CONFIG, ""), wVCallBackContext) : stopMock(wVCallBackContext);
            } else if ("clearCount".equals(str)) {
                dr1.a();
                wVCallBackContext.success();
                return true;
            } else if ("openConsole".equals(str)) {
                JSONObject jSONObject2 = (JSONObject) new JSONTokener(str2).nextValue();
                String optString = jSONObject2.optString("windvane", "");
                int optInt = jSONObject2.optInt("logCacheSize", 50);
                Intent intent = new Intent(this.mContext, PopLayerDebugActivity.class);
                intent.setData(Uri.parse(String.format("http://tb.cn/n/poplayerdebug?windvane=%s&log_cache_size=%s", optString, Integer.valueOf(optInt))));
                this.mContext.startActivity(intent);
                return true;
            } else if ("getIP".equals(str)) {
                int ipAddress = ((WifiManager) PopLayer.getReference().getApp().getSystemService("wifi")).getConnectionInfo().getIpAddress();
                String format = String.format(Locale.getDefault(), "%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
                cr1.b("PopLayerManager.jsGetIp.ip{%s}", format);
                wVCallBackContext.success(new JSONObject().put(TbAuthConstants.IP, format).toString());
                return true;
            } else if ("mockBroadcast".equals(str)) {
                JSONObject jSONObject3 = (JSONObject) new JSONTokener(str2).nextValue();
                String optString2 = jSONObject3.optString("event", "");
                String optString3 = jSONObject3.optString("param", "");
                if (TextUtils.isEmpty(optString2)) {
                    return true;
                }
                Intent intent2 = new Intent(PopLayer.ACTION_POP);
                intent2.putExtra("event", optString2);
                intent2.putExtra("param", optString3);
                cr1.b("PopLayerManager.mockBroadcast.event{%s},param:{%s}.", optString2, optString3);
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent2);
                wVCallBackContext.success();
                return true;
            } else {
                wVCallBackContext.error("PopLayerManager.execute.noMethodFound");
                return false;
            }
        } catch (Throwable th) {
            cr1.c("PopLayerManager.execute.error", th);
            wVCallBackContext.error(th.toString() + StringUtils.LF + th.getMessage());
            return false;
        }
    }
}
