package cn.damai.common.db.config;

import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k91;

/* compiled from: Taobao */
public enum DbConfigs {
    HTTP(new DbManager.a().h("xUtils_http_cache.db").k(1).i(new b()).j(new a())),
    COOKIE(new DbManager.a().h("xUtils_http_cookie.db").k(1).i(new d()).j(new c()));
    
    private DbManager.a config;

    /* compiled from: Taobao */
    public class a implements DbManager.DbUpgradeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.db.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1237513475")) {
                ipChange.ipc$dispatch("-1237513475", new Object[]{this, dbManager, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                k91.c(e.getMessage(), e);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DbManager.DbOpenListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.db.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "512905499")) {
                ipChange.ipc$dispatch("512905499", new Object[]{this, dbManager});
                return;
            }
            dbManager.getDatabase().enableWriteAheadLogging();
        }
    }

    /* compiled from: Taobao */
    public class c implements DbManager.DbUpgradeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.db.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "701648571")) {
                ipChange.ipc$dispatch("701648571", new Object[]{this, dbManager, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                k91.c(e.getMessage(), e);
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DbManager.DbOpenListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.common.db.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "159817117")) {
                ipChange.ipc$dispatch("159817117", new Object[]{this, dbManager});
                return;
            }
            dbManager.getDatabase().enableWriteAheadLogging();
        }
    }

    private DbConfigs(DbManager.a aVar) {
        this.config = aVar;
    }

    public DbManager.a getConfig() {
        return this.config;
    }
}
