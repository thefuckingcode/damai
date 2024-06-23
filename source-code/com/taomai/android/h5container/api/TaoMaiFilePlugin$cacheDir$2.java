package com.taomai.android.h5container.api;

import android.app.Application;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.xi2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class TaoMaiFilePlugin$cacheDir$2 extends Lambda implements Function0<String> {
    public static final TaoMaiFilePlugin$cacheDir$2 INSTANCE = new TaoMaiFilePlugin$cacheDir$2();

    TaoMaiFilePlugin$cacheDir$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String invoke() {
        File filesDir;
        StringBuilder sb = new StringBuilder();
        Application application = xi2.a;
        sb.append((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(TaoMaiFilePlugin.FILES_DIR);
        return sb.toString();
    }
}
