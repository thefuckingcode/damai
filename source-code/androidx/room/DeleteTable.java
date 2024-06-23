package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Repeatable(Entries.class)
@Retention(RetentionPolicy.CLASS)
/* compiled from: Taobao */
public @interface DeleteTable {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    /* compiled from: Taobao */
    public @interface Entries {
        DeleteTable[] value();
    }

    String tableName();
}
