package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import com.taomai.android.h5container.provider.INavigationBarProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.lf2;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0019"}, d2 = {"Lcom/taomai/android/h5container/api/TMNavigationBarPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "enableHookBack", "", "params", TMNavigationBarPlugin.ACTION_SET_TRANSPARENT_TITLE, "Lcom/taomai/android/h5container/provider/INavigationBarProvider;", "navigationBarProvider", "actionName", "execute", "setWebTitle", "showWebTitle", "hideWebTitle", "showWebOptionMenu", "hideWebOptionMenu", "setWebOptionMenu", "hideWebTitleBackBtn", "showWebTitleBackBtn", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TMNavigationBarPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_ENABLE_HOOK_BACK = "enableHookNativeBack";
    @NotNull
    public static final String ACTION_HIDE_BACK_BUTTON = "hideBackButton";
    @NotNull
    public static final String ACTION_HIDE_OPTION_MENU = "hideOptionMenu";
    @NotNull
    public static final String ACTION_HIDE_TITLE_BAR = "hideTitleBar";
    @NotNull
    public static final String ACTION_SET_OPTION_MENU = "setOptionMenu";
    @NotNull
    public static final String ACTION_SET_TRANSPARENT_TITLE = "setTransparentTitle";
    @NotNull
    public static final String ACTION_SET_WEB_TITLE = "setTitle";
    @NotNull
    public static final String ACTION_SHOW_BACK_BUTTON = "showBackButton";
    @NotNull
    public static final String ACTION_SHOW_OPTION_MENU = "showOptionMenu";
    @NotNull
    public static final String ACTION_SHOW_TITLE_BAR = "showTitleBar";
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b implements View.OnClickListener {
        final /* synthetic */ WVCallBackContext a;
        final /* synthetic */ String b;

        b(WVCallBackContext wVCallBackContext, String str) {
            this.a = wVCallBackContext;
            this.b = str;
        }

        public final void onClick(View view) {
            WVCallBackContext wVCallBackContext = this.a;
            if (wVCallBackContext != null) {
                wVCallBackContext.success(this.b);
            }
        }
    }

    private final boolean enableHookBack(WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.enableHookBackBtn();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    private final INavigationBarProvider navigationBarProvider() {
        Object provider = getProvider("NavigationBarProvider");
        if (!(provider instanceof INavigationBarProvider)) {
            provider = null;
        }
        return (INavigationBarProvider) provider;
    }

    private final boolean setTransparentTitle(String str, WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        if (!(str == null || (a2 = lf2.a(str)) == null)) {
            INavigationBarProvider navigationBarProvider = navigationBarProvider();
            if (navigationBarProvider != null) {
                navigationBarProvider.setTransparentTitle(a2.getString("transparentTitle"));
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
            } else if (wVCallBackContext != null) {
                wVCallBackContext.error();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1327518127:
                    if (str.equals(ACTION_SHOW_OPTION_MENU)) {
                        return showWebOptionMenu(str2, wVCallBackContext);
                    }
                    break;
                case -1307803139:
                    if (str.equals(ACTION_HIDE_TITLE_BAR)) {
                        return hideWebTitle(str2, wVCallBackContext);
                    }
                    break;
                case -794464810:
                    if (str.equals("showBackButton")) {
                        return showWebTitleBackBtn(str2, wVCallBackContext);
                    }
                    break;
                case 505699926:
                    if (str.equals(ACTION_HIDE_OPTION_MENU)) {
                        return hideWebOptionMenu(str2, wVCallBackContext);
                    }
                    break;
                case 1038753243:
                    if (str.equals(ACTION_HIDE_BACK_BUTTON)) {
                        return hideWebTitleBackBtn(str2, wVCallBackContext);
                    }
                    break;
                case 1202279592:
                    if (str.equals(ACTION_SET_TRANSPARENT_TITLE)) {
                        return setTransparentTitle(str2, wVCallBackContext);
                    }
                    break;
                case 1405084438:
                    if (str.equals("setTitle")) {
                        return setWebTitle(str2, wVCallBackContext);
                    }
                    break;
                case 1572967608:
                    if (str.equals(ACTION_SHOW_TITLE_BAR)) {
                        return showWebTitle(str2, wVCallBackContext);
                    }
                    break;
                case 1846900612:
                    if (str.equals(ACTION_ENABLE_HOOK_BACK)) {
                        return enableHookBack(wVCallBackContext);
                    }
                    break;
                case 1849742710:
                    if (str.equals(ACTION_SET_OPTION_MENU)) {
                        return setWebOptionMenu(str2, wVCallBackContext);
                    }
                    break;
            }
        }
        return false;
    }

    public final boolean hideWebOptionMenu(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.hideWebOptionMenu();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean hideWebTitle(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.hideWebTitle();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean hideWebTitleBackBtn(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.hideWebTitleBackBtn();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean setWebOptionMenu(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.setWebOptionMenu(str != null ? lf2.a(str) : null, new b(wVCallBackContext, str));
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean setWebTitle(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            JSONObject a2 = lf2.a(str);
            navigationBarProvider.setWebTitle(a2 != null ? a2.getString("title") : null);
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean showWebOptionMenu(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.showWebOptionMenu();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean showWebTitle(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.showWebTitle();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }

    public final boolean showWebTitleBackBtn(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        INavigationBarProvider navigationBarProvider = navigationBarProvider();
        if (navigationBarProvider != null) {
            navigationBarProvider.showWebTitleBackBtn();
            if (wVCallBackContext == null) {
                return true;
            }
            wVCallBackContext.success();
            return true;
        } else if (wVCallBackContext == null) {
            return true;
        } else {
            wVCallBackContext.error();
            return true;
        }
    }
}
