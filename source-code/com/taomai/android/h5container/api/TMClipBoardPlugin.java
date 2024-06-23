package com.taomai.android.h5container.api;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import tb.k21;
import tb.lf2;
import tb.m40;
import tb.ur2;
import tb.xi2;

public final class TMClipBoardPlugin extends TaoMaiApiPlugin {
    public static final String ACTION_GET_CLIPBOARD;
    public static final String ACTION_SET_CLIPBOARD;
    public static final a Companion = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public final void clearClipTextContent() {
        try {
            Application application = xi2.a;
            Object systemService = application != null ? application.getSystemService("clipboard") : null;
            if (systemService != null) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("taomai", ""));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        } catch (Exception unused) {
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1610002720) {
                if (hashCode == -61010092 && str.equals(ACTION_SET_CLIPBOARD)) {
                    return writeToClipBoard(str2, wVCallBackContext);
                }
            } else if (str.equals(ACTION_GET_CLIPBOARD)) {
                return getClipTextContent(str2, wVCallBackContext);
            }
        }
        return false;
    }

    public final boolean getClipTextContent(String str, WVCallBackContext wVCallBackContext) {
        try {
            Context context = this.mContext;
            Object obj = null;
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            if (systemService instanceof ClipboardManager) {
                obj = systemService;
            }
            ClipboardManager clipboardManager = (ClipboardManager) obj;
            if (clipboardManager != null && clipboardManager.hasPrimaryClip()) {
                ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
                k21.f(primaryClipDescription);
                if (primaryClipDescription.hasMimeType(IRequestConst.CONTENT_TYPE_TEXT_PLAIN)) {
                    ClipData primaryClip = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager);
                    k21.f(primaryClip);
                    CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.mContext);
                    String obj2 = coerceToText != null ? coerceToText.toString() : "";
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", (Object) obj2);
                    ur2 ur2 = ur2.INSTANCE;
                    wVCallBackContext.success(jSONObject.toJSONString());
                    return true;
                }
            }
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.error();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final boolean writeToClipBoard(String str, WVCallBackContext wVCallBackContext) {
        JSONObject a2 = str != null ? lf2.a(str) : null;
        if (a2 == null || a2.containsKey("text")) {
            try {
                new Handler(Looper.getMainLooper()).post(new TMClipBoardPlugin$writeToClipBoard$1(this, a2, wVCallBackContext));
            } catch (Exception unused) {
            }
            return true;
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.error("text is requried for clipboard written");
        }
        return true;
    }
}
