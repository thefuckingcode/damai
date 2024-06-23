package cn.damai.uikit.nav;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class NavProxy implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String navClass = "cn.damai.common.nav.DMNav";

    /* compiled from: Taobao */
    public static class DefaultNav extends INav {
        private static transient /* synthetic */ IpChange $ipChange;

        public DefaultNav(Context context) {
            super(context);
            Log.e("DefaultNav", "nav error, please check NavProxy");
        }

        @Override // cn.damai.uikit.nav.INav
        public INav disableTransition() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1678456180")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("1678456180", new Object[]{this});
        }

        @Override // cn.damai.uikit.nav.INav
        public INav forResult(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1814835934")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("1814835934", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // cn.damai.uikit.nav.INav
        public INav needLogin() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1598310046")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("1598310046", new Object[]{this});
        }

        @Override // cn.damai.uikit.nav.INav
        public INav skipHooker() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "331823376")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("331823376", new Object[]{this});
        }

        @Override // cn.damai.uikit.nav.INav
        public INav skipPreprocess() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1568349644")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("-1568349644", new Object[]{this});
        }

        @Override // cn.damai.uikit.nav.INav
        public INav skipPriorHooker() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1872544298")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("-1872544298", new Object[]{this});
        }

        @Override // cn.damai.uikit.nav.INav
        public boolean toHost(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-688789273")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-688789273", new Object[]{this, str})).booleanValue();
        }

        @Override // cn.damai.uikit.nav.INav
        public boolean toUri(Uri uri) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1032360046")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("1032360046", new Object[]{this, uri})).booleanValue();
        }

        @Override // cn.damai.uikit.nav.INav
        public boolean toUri(INavUri iNavUri) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "988705650")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("988705650", new Object[]{this, iNavUri})).booleanValue();
        }

        @Override // cn.damai.uikit.nav.INav
        public boolean toUri(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-461270261")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-461270261", new Object[]{this, str})).booleanValue();
        }

        @Override // cn.damai.uikit.nav.INav
        public INav withExtras(Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1688388932")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("1688388932", new Object[]{this, bundle});
        }

        @Override // cn.damai.uikit.nav.INav
        public INav withFlags(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1240588153")) {
                return this;
            }
            return (INav) ipChange.ipc$dispatch("1240588153", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public static INav from(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268208249")) {
            return (INav) ipChange.ipc$dispatch("1268208249", new Object[]{context});
        }
        try {
            return (INav) Class.forName(navClass).getMethod("from", Context.class).invoke(null, context);
        } catch (Exception e) {
            Log.e("DefaultNav", "nav constructor error, please check NavProxy");
            e.printStackTrace();
            return new DefaultNav(context);
        }
    }
}
