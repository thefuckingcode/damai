package cn.damai.tetris.v2.componentplugin;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.View;
import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public class a implements SectionSensitive {
    private static transient /* synthetic */ IpChange $ipChange;
    private ComponentPageUi a;
    private final HashMap<String, ComponentPlugin> b = new HashMap<>();
    private final HashMap<ISection, ComponentPlugin> c = new HashMap<>();
    private final LinkedList<ISection> d = new LinkedList<>();

    public a(ComponentPageUi componentPageUi) {
        this.a = componentPageUi;
    }

    private ComponentPlugin a(Class<? extends ComponentPlugin> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "906233112")) {
            return (ComponentPlugin) ipChange.ipc$dispatch("906233112", new Object[]{this, cls});
        } else if (cls == null) {
            return null;
        } else {
            try {
                return (ComponentPlugin) cls.getConstructor(ComponentPageUi.class).newInstance(this.a);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418579508")) {
            ipChange.ipc$dispatch("1418579508", new Object[]{this, view});
            return;
        }
        for (ComponentPlugin componentPlugin : this.b.values()) {
            componentPlugin.onLoadMore();
        }
        for (ComponentPlugin componentPlugin2 : this.c.values()) {
            componentPlugin2.onLoadMore();
        }
    }

    public void c(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "890191861")) {
            ipChange.ipc$dispatch("890191861", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        for (ComponentPlugin componentPlugin : this.b.values()) {
            componentPlugin.onMessage(i, obj);
        }
        for (ComponentPlugin componentPlugin2 : this.c.values()) {
            componentPlugin2.onMessage(i, obj);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839212103")) {
            ipChange.ipc$dispatch("-1839212103", new Object[]{this, iSection, vBaseViewHolder});
            return;
        }
        try {
            ComponentPlugin componentPlugin = this.b.get(iSection.getComponentId());
            if (componentPlugin != null) {
                componentPlugin.onSectionBindViewHolder(iSection, vBaseViewHolder);
            }
            ComponentPlugin componentPlugin2 = this.c.get(iSection);
            if (componentPlugin2 != null) {
                componentPlugin2.onSectionBindViewHolder(iSection, vBaseViewHolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionChanged(ISection iSection, boolean z) {
        String componentId;
        Pair<ComponentPluginType, Class<? extends ComponentPlugin>> pair;
        ComponentPlugin componentPlugin;
        ComponentPlugin a2;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "967994870")) {
            ipChange.ipc$dispatch("967994870", new Object[]{this, iSection, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            if (!this.d.contains(iSection)) {
                this.d.add(iSection);
            }
            if (!z2 && (pair = ComponentPlugin.getPair((componentId = iSection.getComponentId()))) != null) {
                ComponentPluginType componentPluginType = (ComponentPluginType) pair.first;
                Class<? extends ComponentPlugin> cls = (Class) pair.second;
                if (!z) {
                    if (componentPluginType == ComponentPluginType.ONE_CID_2_ONE_PLUGIN) {
                        componentPlugin = this.b.get(componentId);
                    } else {
                        componentPlugin = this.c.remove(iSection);
                    }
                    if (componentPlugin != null) {
                        componentPlugin.onSectionRemoved(iSection);
                        return;
                    }
                    return;
                } else if (componentPluginType == ComponentPluginType.ONE_CID_2_ONE_PLUGIN) {
                    ComponentPlugin componentPlugin2 = this.b.get(componentId);
                    if (componentPlugin2 == null) {
                        ComponentPlugin a3 = a(cls);
                        if (a3 != null) {
                            a3.bindSection(iSection);
                            this.b.put(componentId, a3);
                            return;
                        }
                        return;
                    }
                    componentPlugin2.bindSection(iSection);
                    return;
                } else if (componentPluginType == ComponentPluginType.ONE_SECTION_2_ONE_PLUGIN && (a2 = a(cls)) != null) {
                    a2.bindSection(iSection);
                    this.c.put(iSection, a2);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            if (this.d.contains(iSection)) {
                this.d.remove(iSection);
            }
            if (!z2) {
                return;
            }
            return;
        }
        z2 = true;
        if (!z2) {
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionListChanged(List<ISection> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88783644")) {
            ipChange.ipc$dispatch("88783644", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (list != null && list.size() > 0) {
            for (ISection iSection : list) {
                sectionChanged(iSection, z);
            }
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.SectionSensitive
    public void sectionListClear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782840590")) {
            ipChange.ipc$dispatch("782840590", new Object[]{this});
            return;
        }
        this.d.clear();
        for (ISection iSection : this.c.keySet()) {
            ComponentPlugin componentPlugin = this.c.get(iSection);
            if (componentPlugin != null) {
                componentPlugin.onSectionRemoved(iSection);
            }
        }
        this.c.clear();
        for (String str : this.b.keySet()) {
            ComponentPlugin componentPlugin2 = this.b.get(str);
            if (componentPlugin2 != null) {
                componentPlugin2.onSectionRemoved(componentPlugin2.mSection);
            }
        }
    }
}
