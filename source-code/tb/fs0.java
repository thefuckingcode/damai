package tb;

import cn.damai.tetris.core.IContext;
import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public class fs0 implements IModule {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<ILayer> a;
    private final List<DelegateAdapter.Adapter> b;
    protected volatile int c = -1;
    private IContext d;
    private IContainer e;
    private wh f;
    private vh<ILayer> g;
    private List<ILayer> h;
    private List<DelegateAdapter.Adapter> i;

    /* compiled from: Taobao */
    public class a implements OnChildAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ ILayer b;

        a(boolean z, ILayer iLayer) {
            this.a = z;
            this.b = iLayer;
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildAdded(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "11462788")) {
                ipChange.ipc$dispatch("11462788", new Object[]{this, addressable});
            } else if (this.a) {
                fs0.this.getContainer().updateContentAdapter();
                if (this.b.getAdapter() != null) {
                    this.b.getAdapter().notifyItemRangeInserted(0, this.b.getChildCount());
                }
            }
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildRemoved(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1728467300")) {
                ipChange.ipc$dispatch("1728467300", new Object[]{this, addressable});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnChildAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ILayer a;

        b(ILayer iLayer) {
            this.a = iLayer;
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildAdded(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1919156317")) {
                ipChange.ipc$dispatch("-1919156317", new Object[]{this, addressable});
            }
        }

        @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
        public void onChildRemoved(Addressable addressable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1829379267")) {
                ipChange.ipc$dispatch("1829379267", new Object[]{this, addressable});
                return;
            }
            if (this.a.getAdapter() != null) {
                this.a.getAdapter().notifyItemRangeRemoved(0, this.a.getChildCount());
            }
            fs0.this.getContainer().updateContentAdapter();
        }
    }

    public fs0(IContext iContext, Node node, wh whVar) {
        this.d = iContext;
        this.e = iContext.getContainer();
        this.f = whVar;
        List<ILayer> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.a = synchronizedList;
        this.h = Collections.unmodifiableList(synchronizedList);
        List<DelegateAdapter.Adapter> synchronizedList2 = Collections.synchronizedList(new ArrayList());
        this.b = synchronizedList2;
        this.i = Collections.unmodifiableList(synchronizedList2);
        this.g = new vh<>();
        a(node.data);
        createLayerList(node.children);
    }

    private void a(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-650963678")) {
            ipChange.ipc$dispatch("-650963678", new Object[]{this, jSONObject});
        }
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void addLayer(int i2, ILayer iLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277153723")) {
            ipChange.ipc$dispatch("-1277153723", new Object[]{this, Integer.valueOf(i2), iLayer});
            return;
        }
        addLayer(i2, iLayer, (OnChildAttachStateChangeListener) null);
    }

    @Override // cn.damai.tetris.v2.structure.module.IModule
    public void addSectionList(List<Node> list, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63387968")) {
            ipChange.ipc$dispatch("63387968", new Object[]{this, list, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (!this.a.isEmpty()) {
            List<ILayer> list2 = this.a;
            ILayer iLayer = z ? list2.get(list2.size() - 1) : list2.get(0);
            if (iLayer == null) {
                return;
            }
            if (z) {
                iLayer.createSectionList(list, z2);
            } else {
                iLayer.addSectionListHead(list, z2);
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void clearLayerList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529186865")) {
            ipChange.ipc$dispatch("-529186865", new Object[]{this});
            return;
        }
        this.a.clear();
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public ILayer createLayer(Node node) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220689796")) {
            return (ILayer) ipChange.ipc$dispatch("-1220689796", new Object[]{this, node});
        }
        es0 es0 = new es0(this.d, node);
        es0.setModule(this);
        return es0;
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void createLayerList(List<Node> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068393399")) {
            ipChange.ipc$dispatch("2068393399", new Object[]{this, list});
        } else if (list != null && !list.isEmpty()) {
            int size = this.a.size();
            for (Node node : list) {
                addLayer(size, createLayer(node), false);
                size++;
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.module.IModule
    public List<DelegateAdapter.Adapter> getAdapterList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887144723")) {
            return (List) ipChange.ipc$dispatch("-1887144723", new Object[]{this});
        }
        synchronized (this.a) {
            this.b.clear();
            if (!this.a.isEmpty()) {
                for (ILayer iLayer : this.a) {
                    if (!(iLayer == null || iLayer.getAdapter() == null)) {
                        this.b.add(iLayer.getAdapter());
                    }
                }
            }
        }
        return this.i;
    }

    @Override // cn.damai.tetris.v2.structure.module.IModule
    public IContainer getContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "674382045")) {
            return this.e;
        }
        return (IContainer) ipChange.ipc$dispatch("674382045", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public mn getCoordinate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1750858794")) {
            return new mn(getIndex(), -2, -2);
        }
        return (mn) ipChange.ipc$dispatch("-1750858794", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1585936088")) {
            return this.c;
        }
        return ((Integer) ipChange.ipc$dispatch("-1585936088", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public List<ILayer> getLayerList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1550557969")) {
            return this.h;
        }
        return (List) ipChange.ipc$dispatch("-1550557969", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void removeLayer(ILayer iLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813771973")) {
            ipChange.ipc$dispatch("-813771973", new Object[]{this, iLayer});
            return;
        }
        removeLayer(iLayer, (OnChildAttachStateChangeListener) null);
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void removeLayer(ILayer iLayer, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775218411")) {
            ipChange.ipc$dispatch("775218411", new Object[]{this, iLayer, onChildAttachStateChangeListener});
        }
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public void setIndex(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-370355998")) {
            ipChange.ipc$dispatch("-370355998", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.c = i2;
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void updateChildIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143744690")) {
            ipChange.ipc$dispatch("2143744690", new Object[]{this});
        } else if (this.g.a()) {
            this.g.c(this.a);
        }
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void addLayer(int i2, ILayer iLayer, OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71564043")) {
            ipChange.ipc$dispatch("-71564043", new Object[]{this, Integer.valueOf(i2), iLayer, onChildAttachStateChangeListener});
            return;
        }
        n91.a("GenericModule", "addLayer index is " + i2 + ", old layer list size is " + this.a.size());
        synchronized (this.a) {
            this.a.add(i2, iLayer);
        }
        this.f.c();
        this.g.onChildAdded(iLayer);
        if (onChildAttachStateChangeListener != null) {
            onChildAttachStateChangeListener.onChildAdded(iLayer);
        }
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void removeLayer(ILayer iLayer, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542918393")) {
            ipChange.ipc$dispatch("542918393", new Object[]{this, iLayer, Boolean.valueOf(z)});
            return;
        }
        removeLayer(iLayer, new b(iLayer));
    }

    @Override // cn.damai.tetris.v2.structure.module.ILayerManager
    public void addLayer(int i2, ILayer iLayer, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937013969")) {
            ipChange.ipc$dispatch("-937013969", new Object[]{this, Integer.valueOf(i2), iLayer, Boolean.valueOf(z)});
            return;
        }
        addLayer(i2, iLayer, new a(z, iLayer));
    }
}
