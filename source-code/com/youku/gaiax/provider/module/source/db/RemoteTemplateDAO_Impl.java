package com.youku.gaiax.provider.module.source.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public final class RemoteTemplateDAO_Impl implements RemoteTemplateDAO {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<YKTemplateEntity> __insertionAdapterOfYKTemplateEntity;

    public RemoteTemplateDAO_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfYKTemplateEntity = new EntityInsertionAdapter<YKTemplateEntity>(roomDatabase) {
            /* class com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `yk_template_v2` (`template_id`,`template_version`,`template_biz`,`template_platform`,`template_desc`,`template_resource_url`,`template_local_url`,`template_priority`,`template_support_min_version`,`template_support_max_version`,`template_createtime`,`template_modifytime`,`template_create_empid`,`template_modify_empid`,`template_release_status`,`template_ext_info`,`template_fileType`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, YKTemplateEntity yKTemplateEntity) {
                if (yKTemplateEntity.getTemplate_id() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, yKTemplateEntity.getTemplate_id());
                }
                supportSQLiteStatement.bindLong(2, (long) yKTemplateEntity.getTemplate_version());
                if (yKTemplateEntity.getTemplate_biz() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, yKTemplateEntity.getTemplate_biz());
                }
                if (yKTemplateEntity.getTemplate_platform() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, yKTemplateEntity.getTemplate_platform());
                }
                if (yKTemplateEntity.getTemplate_desc() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, yKTemplateEntity.getTemplate_desc());
                }
                if (yKTemplateEntity.getTemplate_resource_url() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, yKTemplateEntity.getTemplate_resource_url());
                }
                if (yKTemplateEntity.getTemplate_local_url() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, yKTemplateEntity.getTemplate_local_url());
                }
                if (yKTemplateEntity.getTemplate_priority() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, yKTemplateEntity.getTemplate_priority());
                }
                supportSQLiteStatement.bindLong(9, yKTemplateEntity.getTemplate_support_min_version());
                supportSQLiteStatement.bindLong(10, yKTemplateEntity.getTemplate_support_max_version());
                if (yKTemplateEntity.getTemplate_createtime() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, yKTemplateEntity.getTemplate_createtime());
                }
                if (yKTemplateEntity.getTemplate_modifytime() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, yKTemplateEntity.getTemplate_modifytime());
                }
                if (yKTemplateEntity.getTemplate_create_empid() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, yKTemplateEntity.getTemplate_create_empid());
                }
                if (yKTemplateEntity.getTemplate_modify_empid() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, yKTemplateEntity.getTemplate_modify_empid());
                }
                if (yKTemplateEntity.getTemplate_release_status() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, yKTemplateEntity.getTemplate_release_status());
                }
                if (yKTemplateEntity.getTemplate_ext_info() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, yKTemplateEntity.getTemplate_ext_info());
                }
                if (yKTemplateEntity.getTemplate_fileType() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, yKTemplateEntity.getTemplate_fileType());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getAll() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType   FROM yk_template_v2 ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                int i = query.getInt(1);
                if (query.isNull(2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(2);
                }
                if (query.isNull(3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(3);
                }
                if (query.isNull(4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(4);
                }
                if (query.isNull(5)) {
                    str5 = null;
                } else {
                    str5 = query.getString(5);
                }
                if (query.isNull(6)) {
                    str6 = null;
                } else {
                    str6 = query.getString(6);
                }
                if (query.isNull(7)) {
                    str7 = null;
                } else {
                    str7 = query.getString(7);
                }
                long j = query.getLong(8);
                long j2 = query.getLong(9);
                if (query.isNull(10)) {
                    str8 = null;
                } else {
                    str8 = query.getString(10);
                }
                if (query.isNull(11)) {
                    str9 = null;
                } else {
                    str9 = query.getString(11);
                }
                if (query.isNull(12)) {
                    str10 = null;
                } else {
                    str10 = query.getString(12);
                }
                if (query.isNull(13)) {
                    str11 = null;
                } else {
                    str11 = query.getString(13);
                }
                if (query.isNull(14)) {
                    str12 = null;
                } else {
                    str12 = query.getString(14);
                }
                if (query.isNull(15)) {
                    str13 = null;
                } else {
                    str13 = query.getString(15);
                }
                if (query.isNull(16)) {
                    str14 = null;
                } else {
                    str14 = query.getString(16);
                }
                arrayList.add(new YKTemplateEntity(str, i, str2, str3, str4, str5, str6, str7, j, j2, str8, str9, str10, str11, str12, str13, str14));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getAllTemplatesWithStatusAndAppVersion(String str, long j, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType FROM yk_template_v2 WHERE template_release_status=? AND template_support_min_version<=? AND template_support_max_version>=? AND template_platform=? GROUP BY template_id", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, j);
        acquire.bindLong(3, j);
        if (str2 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str3 = null;
                } else {
                    str3 = query.getString(0);
                }
                int i = query.getInt(1);
                if (query.isNull(2)) {
                    str4 = null;
                } else {
                    str4 = query.getString(2);
                }
                if (query.isNull(3)) {
                    str5 = null;
                } else {
                    str5 = query.getString(3);
                }
                if (query.isNull(4)) {
                    str6 = null;
                } else {
                    str6 = query.getString(4);
                }
                if (query.isNull(5)) {
                    str7 = null;
                } else {
                    str7 = query.getString(5);
                }
                if (query.isNull(6)) {
                    str8 = null;
                } else {
                    str8 = query.getString(6);
                }
                if (query.isNull(7)) {
                    str9 = null;
                } else {
                    str9 = query.getString(7);
                }
                long j2 = query.getLong(8);
                long j3 = query.getLong(9);
                if (query.isNull(10)) {
                    str10 = null;
                } else {
                    str10 = query.getString(10);
                }
                if (query.isNull(11)) {
                    str11 = null;
                } else {
                    str11 = query.getString(11);
                }
                if (query.isNull(12)) {
                    str12 = null;
                } else {
                    str12 = query.getString(12);
                }
                if (query.isNull(13)) {
                    str13 = null;
                } else {
                    str13 = query.getString(13);
                }
                if (query.isNull(14)) {
                    str14 = null;
                } else {
                    str14 = query.getString(14);
                }
                if (query.isNull(15)) {
                    str15 = null;
                } else {
                    str15 = query.getString(15);
                }
                if (query.isNull(16)) {
                    str16 = null;
                } else {
                    str16 = query.getString(16);
                }
                arrayList.add(new YKTemplateEntity(str3, i, str4, str5, str6, str7, str8, str9, j2, j3, str10, str11, str12, str13, str14, str15, str16));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getTemplateWithStatus(String str, int i, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=? AND template_version=? AND template_biz=? AND template_release_status=?", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, (long) i);
        if (str2 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str2);
        }
        if (str3 == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str4 = null;
                } else {
                    str4 = query.getString(0);
                }
                int i2 = query.getInt(1);
                if (query.isNull(2)) {
                    str5 = null;
                } else {
                    str5 = query.getString(2);
                }
                if (query.isNull(3)) {
                    str6 = null;
                } else {
                    str6 = query.getString(3);
                }
                if (query.isNull(4)) {
                    str7 = null;
                } else {
                    str7 = query.getString(4);
                }
                if (query.isNull(5)) {
                    str8 = null;
                } else {
                    str8 = query.getString(5);
                }
                if (query.isNull(6)) {
                    str9 = null;
                } else {
                    str9 = query.getString(6);
                }
                if (query.isNull(7)) {
                    str10 = null;
                } else {
                    str10 = query.getString(7);
                }
                long j = query.getLong(8);
                long j2 = query.getLong(9);
                if (query.isNull(10)) {
                    str11 = null;
                } else {
                    str11 = query.getString(10);
                }
                if (query.isNull(11)) {
                    str12 = null;
                } else {
                    str12 = query.getString(11);
                }
                if (query.isNull(12)) {
                    str13 = null;
                } else {
                    str13 = query.getString(12);
                }
                if (query.isNull(13)) {
                    str14 = null;
                } else {
                    str14 = query.getString(13);
                }
                if (query.isNull(14)) {
                    str15 = null;
                } else {
                    str15 = query.getString(14);
                }
                if (query.isNull(15)) {
                    str16 = null;
                } else {
                    str16 = query.getString(15);
                }
                if (query.isNull(16)) {
                    str17 = null;
                } else {
                    str17 = query.getString(16);
                }
                arrayList.add(new YKTemplateEntity(str4, i2, str5, str6, str7, str8, str9, str10, j, j2, str11, str12, str13, str14, str15, str16, str17));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getTemplateWithStatusAndAppVersion(String str, String str2, String str3, long j, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=? AND template_biz=? AND template_release_status=? AND template_support_min_version<=? AND template_support_max_version>=? AND template_platform=?", 6);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        acquire.bindLong(4, j);
        acquire.bindLong(5, j);
        if (str4 == null) {
            acquire.bindNull(6);
        } else {
            acquire.bindString(6, str4);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str5 = null;
                } else {
                    str5 = query.getString(0);
                }
                int i = query.getInt(1);
                if (query.isNull(2)) {
                    str6 = null;
                } else {
                    str6 = query.getString(2);
                }
                if (query.isNull(3)) {
                    str7 = null;
                } else {
                    str7 = query.getString(3);
                }
                if (query.isNull(4)) {
                    str8 = null;
                } else {
                    str8 = query.getString(4);
                }
                if (query.isNull(5)) {
                    str9 = null;
                } else {
                    str9 = query.getString(5);
                }
                if (query.isNull(6)) {
                    str10 = null;
                } else {
                    str10 = query.getString(6);
                }
                if (query.isNull(7)) {
                    str11 = null;
                } else {
                    str11 = query.getString(7);
                }
                long j2 = query.getLong(8);
                long j3 = query.getLong(9);
                if (query.isNull(10)) {
                    str12 = null;
                } else {
                    str12 = query.getString(10);
                }
                if (query.isNull(11)) {
                    str13 = null;
                } else {
                    str13 = query.getString(11);
                }
                if (query.isNull(12)) {
                    str14 = null;
                } else {
                    str14 = query.getString(12);
                }
                if (query.isNull(13)) {
                    str15 = null;
                } else {
                    str15 = query.getString(13);
                }
                if (query.isNull(14)) {
                    str16 = null;
                } else {
                    str16 = query.getString(14);
                }
                if (query.isNull(15)) {
                    str17 = null;
                } else {
                    str17 = query.getString(15);
                }
                if (query.isNull(16)) {
                    str18 = null;
                } else {
                    str18 = query.getString(16);
                }
                arrayList.add(new YKTemplateEntity(str5, i, str6, str7, str8, str9, str10, str11, j2, j3, str12, str13, str14, str15, str16, str17, str18));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public List<YKTemplateEntity> getTemplatesWithStatusAndAppVersion(String str, String str2, String str3, long j, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT template_id,max(template_version) as template_version,template_biz,template_platform,template_desc,template_resource_url,template_local_url,template_priority,template_support_min_version,template_support_max_version,template_createtime,template_modifytime,template_create_empid,template_modify_empid,template_release_status,template_ext_info,template_fileType  FROM yk_template_v2 WHERE template_id=? AND template_biz=? AND template_release_status=? AND template_support_min_version<=? AND template_support_max_version>=? AND template_platform=?", 6);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        acquire.bindLong(4, j);
        acquire.bindLong(5, j);
        if (str4 == null) {
            acquire.bindNull(6);
        } else {
            acquire.bindString(6, str4);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str5 = null;
                } else {
                    str5 = query.getString(0);
                }
                int i = query.getInt(1);
                if (query.isNull(2)) {
                    str6 = null;
                } else {
                    str6 = query.getString(2);
                }
                if (query.isNull(3)) {
                    str7 = null;
                } else {
                    str7 = query.getString(3);
                }
                if (query.isNull(4)) {
                    str8 = null;
                } else {
                    str8 = query.getString(4);
                }
                if (query.isNull(5)) {
                    str9 = null;
                } else {
                    str9 = query.getString(5);
                }
                if (query.isNull(6)) {
                    str10 = null;
                } else {
                    str10 = query.getString(6);
                }
                if (query.isNull(7)) {
                    str11 = null;
                } else {
                    str11 = query.getString(7);
                }
                long j2 = query.getLong(8);
                long j3 = query.getLong(9);
                if (query.isNull(10)) {
                    str12 = null;
                } else {
                    str12 = query.getString(10);
                }
                if (query.isNull(11)) {
                    str13 = null;
                } else {
                    str13 = query.getString(11);
                }
                if (query.isNull(12)) {
                    str14 = null;
                } else {
                    str14 = query.getString(12);
                }
                if (query.isNull(13)) {
                    str15 = null;
                } else {
                    str15 = query.getString(13);
                }
                if (query.isNull(14)) {
                    str16 = null;
                } else {
                    str16 = query.getString(14);
                }
                if (query.isNull(15)) {
                    str17 = null;
                } else {
                    str17 = query.getString(15);
                }
                if (query.isNull(16)) {
                    str18 = null;
                } else {
                    str18 = query.getString(16);
                }
                arrayList.add(new YKTemplateEntity(str5, i, str6, str7, str8, str9, str10, str11, j2, j3, str12, str13, str14, str15, str16, str17, str18));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO
    public void insert(YKTemplateEntity yKTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfYKTemplateEntity.insert(yKTemplateEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
