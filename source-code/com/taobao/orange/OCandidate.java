package com.taobao.orange;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.orange.aidl.OrangeCandidateCompareStub;
import com.taobao.orange.aidl.ParcelableCandidateCompare;
import com.taobao.orange.candidate.DefCandidateCompare;

/* compiled from: Taobao */
public class OCandidate {
    private String clientVal;
    private ParcelableCandidateCompare compare;
    private String key;

    public OCandidate(@NonNull String str, @Nullable String str2, @NonNull ICandidateCompare iCandidateCompare) {
        if (TextUtils.isEmpty(str) || iCandidateCompare == null) {
            throw new IllegalArgumentException("key or compare is null");
        }
        this.key = str;
        this.clientVal = str2;
        this.compare = new OrangeCandidateCompareStub(iCandidateCompare);
    }

    public boolean compare(OCandidate oCandidate) {
        if (oCandidate == null) {
            return false;
        }
        if (this == oCandidate) {
            return true;
        }
        if (!this.key.equals(oCandidate.key)) {
            return false;
        }
        String str = this.clientVal;
        if (str == null ? oCandidate.clientVal != null : !str.equals(oCandidate.clientVal)) {
            return false;
        }
        if (((OrangeCandidateCompareStub) this.compare).getRealClass() == ((OrangeCandidateCompareStub) oCandidate.compare).getRealClass()) {
            return true;
        }
        return false;
    }

    public String getClientVal() {
        return this.clientVal;
    }

    public ParcelableCandidateCompare getCompare() {
        return this.compare;
    }

    public String getKey() {
        return this.key;
    }

    public String toString() {
        ParcelableCandidateCompare parcelableCandidateCompare = this.compare;
        return String.format("%s=%s %s", this.key, this.clientVal, parcelableCandidateCompare instanceof OrangeCandidateCompareStub ? ((OrangeCandidateCompareStub) parcelableCandidateCompare).getName() : null);
    }

    public OCandidate(@NonNull String str, String str2, @NonNull Class<? extends ICandidateCompare> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            throw new IllegalArgumentException("key or compare is null");
        }
        this.key = str;
        this.clientVal = str2;
        try {
            this.compare = new OrangeCandidateCompareStub((ICandidateCompare) cls.newInstance());
        } catch (Exception unused) {
            this.compare = new OrangeCandidateCompareStub(new DefCandidateCompare());
        }
    }

    public OCandidate(@NonNull String str, String str2, ParcelableCandidateCompare parcelableCandidateCompare) {
        if (TextUtils.isEmpty(str) || parcelableCandidateCompare == null) {
            throw new IllegalArgumentException("key or compare is null");
        }
        this.key = str;
        this.clientVal = str2;
        this.compare = parcelableCandidateCompare;
    }
}
