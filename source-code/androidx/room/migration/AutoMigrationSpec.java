package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public interface AutoMigrationSpec {
    void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
