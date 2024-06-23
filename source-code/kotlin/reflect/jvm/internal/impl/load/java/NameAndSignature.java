package kotlin.reflect.jvm.internal.impl.load.java;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* access modifiers changed from: package-private */
/* compiled from: specialBuiltinMembers.kt */
public final class NameAndSignature {
    private final Name name;
    private final String signature;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameAndSignature)) {
            return false;
        }
        NameAndSignature nameAndSignature = (NameAndSignature) obj;
        return Intrinsics.areEqual(this.name, nameAndSignature.name) && Intrinsics.areEqual(this.signature, nameAndSignature.signature);
    }

    public int hashCode() {
        Name name2 = this.name;
        int i = 0;
        int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
        String str = this.signature;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ")";
    }

    public NameAndSignature(Name name2, String str) {
        Intrinsics.checkParameterIsNotNull(name2, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(str, "signature");
        this.name = name2;
        this.signature = str;
    }

    public final Name getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }
}
