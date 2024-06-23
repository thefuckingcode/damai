package com.uploader.export;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface IUploaderDependency {
    @NonNull
    IUploaderEnvironment getEnvironment();

    IUploaderLog getLog();

    IUploaderStatistics getStatistics();
}
