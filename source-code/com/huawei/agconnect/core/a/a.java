package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.a.b;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class a extends AGConnectInstance {
    private static List<Service> a;
    private static final Object b = new Object();
    private static final Map<String, AGConnectInstance> c = new HashMap();
    private final AGConnectOptions d;
    private final c e;
    private final c f;

    public a(AGConnectOptions aGConnectOptions) {
        this.d = aGConnectOptions;
        if (a == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        this.e = new c(a);
        c cVar = new c(null);
        this.f = cVar;
        if (aGConnectOptions instanceof b) {
            cVar.a(((b) aGConnectOptions).a());
        }
    }

    public static AGConnectInstance a() {
        return a("DEFAULT_INSTANCE");
    }

    public static AGConnectInstance a(AGConnectOptions aGConnectOptions) {
        return a(aGConnectOptions, false);
    }

    private static AGConnectInstance a(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance aGConnectInstance;
        synchronized (b) {
            Map<String, AGConnectInstance> map = c;
            aGConnectInstance = map.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z) {
                aGConnectInstance = new a(aGConnectOptions);
                map.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    public static AGConnectInstance a(String str) {
        AGConnectInstance aGConnectInstance;
        synchronized (b) {
            aGConnectInstance = c.get(str);
            if (aGConnectInstance == null) {
                if ("DEFAULT_INSTANCE".equals(str)) {
                    Log.w("AGConnectInstance", "please call `initialize()` first");
                } else {
                    Log.w("AGConnectInstance", "not find instance for : " + str);
                }
            }
        }
        return aGConnectInstance;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (c.get("DEFAULT_INSTANCE") != null) {
                Log.w("AGConnectInstance", "Repeated invoking initialize");
            } else {
                a(context, AGConnectServicesConfig.fromContext(context));
            }
        }
    }

    private static synchronized void a(Context context, AGConnectOptions aGConnectOptions) {
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGConnectInstance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            com.huawei.agconnect.config.a.a.a(context);
            if (a == null) {
                a = new b(context).a();
            }
            b();
            a(aGConnectOptions, true);
        }
    }

    public static synchronized void a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (a.class) {
            a(context, aGConnectOptionsBuilder.build(context, "DEFAULT_INSTANCE"));
        }
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() {
            /* class com.huawei.agconnect.core.a.a.AnonymousClass1 */

            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() {
            /* class com.huawei.agconnect.core.a.a.AnonymousClass2 */

            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    public void a(final CustomAuthProvider customAuthProvider) {
        this.f.a(Collections.singletonList(Service.builder(AuthProvider.class, new AuthProvider() {
            /* class com.huawei.agconnect.core.a.a.AnonymousClass4 */

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens(boolean z) {
                return customAuthProvider.getTokens(z);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public String getUid() {
                return "";
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()));
    }

    public void a(final CustomCredentialsProvider customCredentialsProvider) {
        this.f.a(Collections.singletonList(Service.builder(CredentialsProvider.class, new CredentialsProvider() {
            /* class com.huawei.agconnect.core.a.a.AnonymousClass3 */

            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens(boolean z) {
                return customCredentialsProvider.getTokens(z);
            }
        }).build()));
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public String getIdentifier() {
        return this.d.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.d;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        T t = (T) this.f.a(this, cls);
        return t != null ? t : (T) this.e.a(this, cls);
    }
}
