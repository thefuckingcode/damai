package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import tb.jl1;

/* compiled from: Taobao */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    @RequiresApi(29)
    /* compiled from: Taobao */
    private static class Api29Impl {
        private Api29Impl() {
        }

        @NonNull
        static LocusId create(@NonNull String str) {
            return new LocusId(str);
        }

        @NonNull
        static String getId(@NonNull LocusId locusId) {
            return locusId.getId();
        }
    }

    public LocusIdCompat(@NonNull String str) {
        this.mId = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped = Api29Impl.create(str);
        } else {
            this.mWrapped = null;
        }
    }

    @NonNull
    private String getSanitizedId() {
        int length = this.mId.length();
        return length + "_chars";
    }

    @NonNull
    @RequiresApi(29)
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(locusId), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.mId;
        if (str != null) {
            return str.equals(locusIdCompat.mId);
        }
        if (locusIdCompat.mId == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        String str = this.mId;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @NonNull
    @RequiresApi(29)
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + jl1.ARRAY_END_STR;
    }
}
