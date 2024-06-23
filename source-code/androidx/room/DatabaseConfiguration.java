package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    @NonNull
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    @Nullable
    public final List<RoomDatabase.Callback> callbacks;
    @NonNull
    public final Context context;
    @Nullable
    public final String copyFromAssetPath;
    @Nullable
    public final File copyFromFile;
    @Nullable
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    @Nullable
    public final String name;
    @Nullable
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;
    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    @NonNull
    public final Executor transactionExecutor;
    @NonNull
    public final List<Object> typeConverters;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, boolean z2, @Nullable Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor, false, z2, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    public boolean isMigrationRequired(int i, int i2) {
        Set<Integer> set;
        if ((!(i > i2) || !this.allowDestructiveMigrationOnDowngrade) && this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i)))) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, str2, file, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback2, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, @Nullable List<Object> list2) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback2, list2, (List<AutoMigrationSpec>) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @SuppressLint({"LambdaLast"})
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, boolean z2, boolean z3, boolean z4, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, @Nullable List<Object> list2, @Nullable List<AutoMigrationSpec> list3) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor2, z2 ? new Intent(context2, MultiInstanceInvalidationService.class) : null, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback2, list2, list3);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, @NonNull RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, @NonNull Executor executor2, @Nullable Intent intent, boolean z2, boolean z3, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, @Nullable List<Object> list2, @Nullable List<AutoMigrationSpec> list3) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context2;
        this.name = str;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.multiInstanceInvalidation = intent != null;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
        this.typeConverters = list2 == null ? Collections.emptyList() : list2;
        this.autoMigrationSpecs = list3 == null ? Collections.emptyList() : list3;
    }
}
