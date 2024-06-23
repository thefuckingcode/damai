package tb;

import android.app.Application;
import android.content.Context;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
public class i30 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static i30 b;
    public static DbManager c;
    private int a = 20;

    /* compiled from: Taobao */
    public class a implements DbManager.DbUpgradeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Application a;

        a(Application application) {
            this.a = application;
        }

        @Override // cn.damai.common.db.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-26331558")) {
                ipChange.ipc$dispatch("-26331558", new Object[]{this, dbManager, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            try {
                i30.this.b(dbManager, this.a);
            } catch (Exception e) {
                vl2.h(vl2.TICKLET_DB_VERSION_UPGRADE_ERROR_CODE, vl2.TICKLET_DB_VERSION_UPGRADE_ERROR_MSG, e.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DbManager.TableCreateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(i30 i30) {
        }

        @Override // cn.damai.common.db.DbManager.TableCreateListener
        public void onTableCreated(DbManager dbManager, si2<?> si2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2139686831")) {
                ipChange.ipc$dispatch("2139686831", new Object[]{this, dbManager, si2});
                return;
            }
            try {
                if (!si2.j()) {
                    vl2.g(vl2.TICKLET_DB_CREAT_TABLE_ERROR_CODE, vl2.TICKLET_DB_CREAT_TABLE_ERROR_MSG, si2.f() + "创建失败");
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
        }
    }

    public static i30 e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648717679")) {
            return (i30) ipChange.ipc$dispatch("-648717679", new Object[0]);
        }
        if (b == null) {
            synchronized (i30.class) {
                if (b == null) {
                    i30 i30 = new i30();
                    b = i30;
                    i30.d(xs0.a());
                }
            }
        }
        return b;
    }

    public void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884931922")) {
            ipChange.ipc$dispatch("-1884931922", new Object[]{this, context});
            return;
        }
        b(c, context);
    }

    public void b(DbManager dbManager, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-910755546")) {
            ipChange.ipc$dispatch("-910755546", new Object[]{this, dbManager, context});
        } else if (context != null) {
            fs1.a(context);
            try {
                if (dbManager.getTable(PerformTable.class).j()) {
                    dbManager.dropTable(PerformTable.class);
                }
                if (dbManager.getTable(UserTicketTable.class).j()) {
                    dbManager.dropTable(UserTicketTable.class);
                }
            } catch (DbException e) {
                g91.b("DbMainManager", e.getMessage());
                vl2.g(vl2.TICKLET_DB_DELET_TABLE_ERROR_CODE, vl2.TICKLET_DB_DELET_TABLE_ERROR_MSG, e.getMessage());
            }
        }
    }

    public synchronized DbManager c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528162538")) {
            return (DbManager) ipChange.ipc$dispatch("-1528162538", new Object[]{this});
        }
        DbManager dbManager = c;
        if (dbManager != null) {
            return dbManager;
        }
        return d(xs0.a());
    }

    public synchronized DbManager d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815826137")) {
            return (DbManager) ipChange.ipc$dispatch("-1815826137", new Object[]{this, application});
        }
        if (c == null && application != null) {
            File databasePath = application.getDatabasePath("walletsdk.db");
            if (databasePath != null && databasePath.exists() && databasePath.isFile()) {
                databasePath.delete();
            }
            DbManager.a aVar = new DbManager.a();
            aVar.k(this.a);
            aVar.h("ticketlet.db");
            aVar.j(new a(application));
            aVar.l(new b(this));
            c = j30.c(aVar, application);
        }
        if (c == null) {
            vl2.g(vl2.TICKLET_DB_INIT_ERROR_CODE, vl2.TICKLET_DB_INIT_ERROR_MSG, null);
        }
        return c;
    }
}
