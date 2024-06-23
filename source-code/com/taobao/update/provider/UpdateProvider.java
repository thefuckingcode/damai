package com.taobao.update.provider;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

/* compiled from: Taobao */
public class UpdateProvider extends FileProvider {
    public static Uri getUriForFile(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".update.provider", file);
    }
}
