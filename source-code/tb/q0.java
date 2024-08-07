package tb;

import android.content.Context;
import com.alibaba.ability.env.IAbilityEnv;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class q0 implements IAbilityEnv {
    @Nullable
    private WeakReference<Context> a;
    private Object b;
    @NotNull
    private String c;
    @NotNull
    private String d;

    @JvmOverloads
    public q0(@NotNull String str, @NotNull String str2) {
        k21.i(str, "businessID");
        k21.i(str2, "namespace");
        this.c = str;
        this.d = str2;
    }

    @NotNull
    public final q0 a(@Nullable Object obj) {
        this.b = obj;
        return this;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    @NotNull
    public String getBusinessID() {
        return this.c;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    @Nullable
    public Context getContext() {
        return IAbilityEnv.a.a(this);
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    @Nullable
    public WeakReference<Context> getContextRef() {
        return this.a;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    @NotNull
    public String getNamespace() {
        return this.d;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    public void setBusinessID(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.c = str;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    public void setContextRef(@Nullable WeakReference<Context> weakReference) {
        this.a = weakReference;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    public void setNamespace(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.d = str;
    }

    @Override // com.alibaba.ability.env.IAbilityEnv
    @NotNull
    public IAbilityEnv withContext(@Nullable Context context) {
        return IAbilityEnv.a.b(this, context);
    }
}
