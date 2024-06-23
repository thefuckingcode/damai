package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/youku/arch/v3/core/TypeRange;", "", "other", "", "equals", "", "hashCode", "component1", "component2", "typeStart", "typeEnd", by0.ARG_COPY, "", "toString", "I", "getTypeStart", "()I", "getTypeEnd", "<init>", "(II)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class TypeRange {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int typeEnd;
    private final int typeStart;

    public TypeRange(int i, int i2) {
        this.typeStart = i;
        this.typeEnd = i2;
    }

    public static /* synthetic */ TypeRange copy$default(TypeRange typeRange, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = typeRange.typeStart;
        }
        if ((i3 & 2) != 0) {
            i2 = typeRange.typeEnd;
        }
        return typeRange.copy(i, i2);
    }

    public final int component1() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-719046284")) {
            return this.typeStart;
        }
        return ((Integer) ipChange.ipc$dispatch("-719046284", new Object[]{this})).intValue();
    }

    public final int component2() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-719016493")) {
            return this.typeEnd;
        }
        return ((Integer) ipChange.ipc$dispatch("-719016493", new Object[]{this})).intValue();
    }

    @NotNull
    public final TypeRange copy(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "440772773")) {
            return new TypeRange(i, i2);
        }
        return (TypeRange) ipChange.ipc$dispatch("440772773", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539578602")) {
            return ((Boolean) ipChange.ipc$dispatch("-539578602", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof TypeRange)) {
            return super.equals(obj);
        } else {
            TypeRange typeRange = (TypeRange) obj;
            if (this.typeStart == typeRange.typeStart && this.typeEnd == typeRange.typeEnd) {
                return true;
            }
            return false;
        }
    }

    public final int getTypeEnd() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-256704035")) {
            return this.typeEnd;
        }
        return ((Integer) ipChange.ipc$dispatch("-256704035", new Object[]{this})).intValue();
    }

    public final int getTypeStart() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2059778294")) {
            return this.typeStart;
        }
        return ((Integer) ipChange.ipc$dispatch("2059778294", new Object[]{this})).intValue();
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1436578099")) {
            return (this.typeStart * 31) + this.typeEnd;
        }
        return ((Integer) ipChange.ipc$dispatch("-1436578099", new Object[]{this})).intValue();
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564608727")) {
            return (String) ipChange.ipc$dispatch("1564608727", new Object[]{this});
        }
        return "TypeRange(typeStart=" + this.typeStart + ", typeEnd=" + this.typeEnd + ')';
    }
}
