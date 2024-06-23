package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSONObject;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXNativeEventManager;", "", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "registerMessage", "unRegisterMessage", "Ljava/util/concurrent/CopyOnWriteArraySet;", "eventsData", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getEventsData", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "<init>", "()V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXNativeEventManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GaiaXNativeEventManager> instance$delegate = b.b(GaiaXNativeEventManager$Companion$instance$2.INSTANCE);
    @NotNull
    private final CopyOnWriteArraySet<JSONObject> eventsData = new CopyOnWriteArraySet<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXNativeEventManager$Companion;", "", "Lcom/youku/gaiax/js/support/GaiaXNativeEventManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/js/support/GaiaXNativeEventManager;", "instance", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GaiaXNativeEventManager getInstance() {
            return (GaiaXNativeEventManager) GaiaXNativeEventManager.instance$delegate.getValue();
        }
    }

    @NotNull
    public final CopyOnWriteArraySet<JSONObject> getEventsData() {
        return this.eventsData;
    }

    public final boolean registerMessage(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        boolean z = false;
        if (!jSONObject.containsKey("type") || !jSONObject.containsKey("contextId") || !jSONObject.containsKey("instanceId")) {
            return false;
        }
        Iterator<JSONObject> it = this.eventsData.iterator();
        while (true) {
            if (it.hasNext()) {
                if (k21.d(jSONObject, it.next())) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            return true;
        }
        this.eventsData.add(jSONObject);
        return true;
    }

    public final boolean unRegisterMessage(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "data");
        if (!jSONObject.containsKey("type") || !jSONObject.containsKey("contextId") || !jSONObject.containsKey("instanceId")) {
            return false;
        }
        Iterator<JSONObject> it = this.eventsData.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JSONObject next = it.next();
            if (k21.d(jSONObject, next)) {
                this.eventsData.remove(next);
                break;
            }
        }
        return true;
    }
}
