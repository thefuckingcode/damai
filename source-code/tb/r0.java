package tb;

import android.os.Looper;
import com.alibaba.ability.IAbility;
import com.alibaba.ability.builder.IAbilityBuilder;
import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.ability.env.IAbilityEnv;
import com.alibaba.ability.hub.IAbilityHub;
import com.alibaba.ability.middleware.IAbilityInvoker;
import com.taobao.analysis.v3.FalcoSpanLayer;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r0 {
    @NotNull
    public static final a Companion = new a(null);
    private static final ReentrantReadWriteLock e = new ReentrantReadWriteLock();
    private static final Map<String, Map<String, IAbility>> f = new HashMap();
    private final Map<String, IAbility> a = new LinkedHashMap();
    private IAbilityHub b;
    private final IAbilityInvoker c = new b(this);
    private final IAbilityEnv d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements IAbilityInvoker {
        final /* synthetic */ r0 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(r0 r0Var) {
            this.a = r0Var;
        }

        @Override // com.alibaba.ability.middleware.IAbilityInvoker
        @Nullable
        public lf0 invoke(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener) {
            k21.i(str, FalcoSpanLayer.ABILITY);
            k21.i(str2, "api");
            k21.i(iAbilityContext, WPKFactory.INIT_KEY_CONTEXT);
            k21.i(map, "params");
            k21.i(iOnCallbackListener, WXBridgeManager.METHOD_CALLBACK);
            try {
                IAbility b = this.a.b(str);
                if (b != null) {
                    return b.execute(str2, iAbilityContext, map, new o0(iOnCallbackListener));
                }
                return new je0("404", null, null, 6, null);
            } catch (Throwable th) {
                return new je0("500", "call stack : " + th.getMessage(), null, 4, null);
            }
        }
    }

    public r0(@NotNull IAbilityEnv iAbilityEnv) {
        k21.i(iAbilityEnv, "env");
        this.d = iAbilityEnv;
    }

    private final IAbilityBuilder c(String str, String str2) {
        IAbilityBuilder iAbilityBuilder;
        IAbilityHub iAbilityHub = this.b;
        return (iAbilityHub == null || (iAbilityBuilder = iAbilityHub.get(str, str2)) == null) ? s0.a().get(str, str2) : iAbilityBuilder;
    }

    @Nullable
    public final lf0 a(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener) {
        k21.i(str, "name");
        k21.i(str2, "api");
        k21.i(iAbilityContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(map, "params");
        k21.i(iOnCallbackListener, WXBridgeManager.METHOD_CALLBACK);
        if (iAbilityContext.getEnv() == null) {
            iAbilityContext.setEnv(this.d);
        }
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        k21.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            return td1.Companion.a(ud1.a().get(str, this.d.getNamespace()), this.c).invoke(str, str2, iAbilityContext, map, iOnCallbackListener);
        }
        throw new RuntimeException("Please use asyncCall in NonMain thread");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @org.jetbrains.annotations.Nullable
    public final com.alibaba.ability.IAbility b(@org.jetbrains.annotations.NotNull java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 265
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.r0.b(java.lang.String):com.alibaba.ability.IAbility");
    }
}
