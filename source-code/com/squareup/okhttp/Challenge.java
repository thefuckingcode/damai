package com.squareup.okhttp;

import com.alibaba.wireless.security.SecExceptionCode;
import com.squareup.okhttp.internal.Util;

/* compiled from: Taobao */
public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this.scheme = str;
        this.realm = str2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return Util.equal(this.scheme, challenge.scheme) && Util.equal(this.realm, challenge.realm);
        }
    }

    public String getRealm() {
        return this.realm;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int hashCode() {
        String str = this.realm;
        int i = 0;
        int hashCode = (SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.scheme;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\"";
    }
}
