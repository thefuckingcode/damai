package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface LocaleListInterface {
    Locale get(int i);

    @Nullable
    Locale getFirstMatch(@NonNull String[] strArr);

    Object getLocaleList();

    @IntRange(from = -1)
    int indexOf(Locale locale);

    boolean isEmpty();

    @IntRange(from = 0)
    int size();

    String toLanguageTags();
}
