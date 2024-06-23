package com.youku.alixplugin.layer;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class LMViewGroupLayerManager implements ILMLayerManager<ViewGroup> {
    private Context context;
    private LMLayerClassLoader layerClassLoader;
    private List<ILMLayer<ViewGroup>> layers = new ArrayList();
    private Map<String, Object> params = null;
    private ViewGroup parentViewGroup;

    public LMViewGroupLayerManager(Context context2, List<LMLayerInfo> list, ViewGroup viewGroup) {
        initialize(context2, list, viewGroup);
    }

    private ViewGroup getAllLayers(ViewGroup viewGroup, Context context2, Map<String, Object> map) throws LMLayerException {
        for (LMLayerInfo lMLayerInfo : this.layerClassLoader.getLayers()) {
            ILMLayer<ViewGroup> layerByBean = getLayerByBean(lMLayerInfo, context2, map);
            if (layerByBean != null) {
                viewGroup.addView(layerByBean.getUIContainer(), viewGroup.getChildCount(), new FrameLayout.LayoutParams(-1, -1));
                this.layers.add(layerByBean);
                layerByBean.onAdded();
                LMUtilLog.debugLog(LMViewGroupLayerManager.class, "LayerId:" + lMLayerInfo.getPluginId() + " onAdded().");
            }
        }
        return viewGroup;
    }

    private LMLayerInfo getLayerBean(String str) throws LMLayerDataSourceException {
        for (ILMLayer<ViewGroup> iLMLayer : this.layers) {
            if (str.equals(iLMLayer.getLayerInfo().getPluginId())) {
                return iLMLayer.getLayerInfo();
            }
        }
        new LMLayerInfo().setPluginId(str);
        LMLayerClassLoader lMLayerClassLoader = this.layerClassLoader;
        if (lMLayerClassLoader == null) {
            return null;
        }
        return lMLayerClassLoader.getMapedLayerInfo(str);
    }

    private ILMLayer<ViewGroup> getLayerByBean(LMLayerInfo lMLayerInfo, Context context2, Map<String, Object> map) {
        for (ILMLayer<ViewGroup> iLMLayer : this.layers) {
            if (lMLayerInfo.getPluginId().equals(iLMLayer.getLayerInfo().getPluginId())) {
                return iLMLayer;
            }
        }
        ILMLayer mapedLayer = this.layerClassLoader.getMapedLayer(lMLayerInfo);
        if (mapedLayer == null) {
            return null;
        }
        if (!(lMLayerInfo.getParams() == null || map == null)) {
            map.putAll(lMLayerInfo.getParams());
        }
        mapedLayer.onCreate(map);
        LMUtilLog.debugLog(LMViewGroupLayerManager.class, "LayerId:" + lMLayerInfo.getPluginId() + " onCreate().");
        return mapedLayer;
    }

    private ViewGroup getLayerByPlugins(ViewGroup viewGroup, List<LMLayerInfo> list, Context context2, Map<String, Object> map) {
        if (list == null) {
            return null;
        }
        new LMListSort().Sort(list, "getPriority", SocialConstants.PARAM_APP_DESC);
        for (LMLayerInfo lMLayerInfo : list) {
            ILMLayer<ViewGroup> layerByBean = getLayerByBean(lMLayerInfo, context2, map);
            if (layerByBean != null) {
                viewGroup.addView(layerByBean.getUIContainer(), viewGroup.getChildCount(), new FrameLayout.LayoutParams(-1, -1));
                this.layers.add(layerByBean);
                layerByBean.onAdded();
                LMUtilLog.debugLog(LMViewGroupLayerManager.class, "LayerId:" + lMLayerInfo.getPluginId() + " onAdded().");
            }
        }
        return viewGroup;
    }

    private void initialize(Context context2, List<LMLayerInfo> list, ViewGroup viewGroup) {
        this.context = context2;
        this.parentViewGroup = viewGroup;
        this.layerClassLoader = new LMLayerClassLoader(context2, list);
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void addLayer(ILMLayer<ViewGroup> iLMLayer) {
        iLMLayer.onCreate(this.params);
        ViewGroup viewGroup = this.parentViewGroup;
        viewGroup.addView(iLMLayer.getUIContainer(), viewGroup.getChildCount(), new FrameLayout.LayoutParams(-1, -1));
        this.layers.add(iLMLayer);
        iLMLayer.onAdded();
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public int getChildCount() {
        return this.parentViewGroup.getChildCount();
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public ILMLayer<ViewGroup> getLayerById(String str, Context context2) throws LMLayerDataSourceException {
        return getLayerById(str, context2, null);
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void hideLayer(String str) throws LMLayerDataSourceException {
        ILMLayer<ViewGroup> layerById = getLayerById(str, this.context, this.params);
        if (layerById != null) {
            layerById.getUIContainer().setVisibility(8);
            layerById.onHide();
        }
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void release() {
        this.layerClassLoader.release();
        this.layers.clear();
        this.layerClassLoader = null;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void removeAllLayers() {
        this.parentViewGroup.removeAllViews();
        for (ILMLayer<ViewGroup> iLMLayer : this.layers) {
            iLMLayer.onRemove();
        }
        this.layers.clear();
        this.layerClassLoader.release();
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void removeLayer(String str) throws LMLayerDataSourceException {
        ILMLayer<ViewGroup> layerById = getLayerById(str, this.context, this.params);
        if (layerById != null) {
            this.parentViewGroup.removeView(layerById.getUIContainer());
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.layers.size()) {
                    break;
                } else if (str.equals(this.layers.get(i2))) {
                    this.layers.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
            LMLayerClassLoader lMLayerClassLoader = this.layerClassLoader;
            if (lMLayerClassLoader != null && lMLayerClassLoader.getLayerInfos() != null) {
                while (true) {
                    if (i >= this.layerClassLoader.getLayerInfos().size()) {
                        break;
                    } else if (str.equals(this.layerClassLoader.getLayerInfos().get(i))) {
                        this.layerClassLoader.getLayerInfos().remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            layerById.onRemove();
        }
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void removeLayerAt(int i) {
        this.parentViewGroup.removeViewAt(i);
        ILMLayer<ViewGroup> iLMLayer = this.layers.get(i);
        for (int i2 = 0; i2 < this.layerClassLoader.getLayerInfos().size(); i2++) {
            if (iLMLayer.getLayerInfo().getPluginId().equals(this.layerClassLoader.getLayerInfos().get(i2))) {
                this.layerClassLoader.release(i);
            }
        }
        this.layers.remove(i);
        iLMLayer.onRemove();
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void setDebugLogEnable(boolean z) {
        LMUtilLog.needDebugLog = z;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public void showLayer(String str) throws LMLayerDataSourceException {
        ILMLayer<ViewGroup> layerById = getLayerById(str, this.context, this.params);
        if (layerById != null) {
            layerById.getUIContainer().setVisibility(0);
            layerById.onShow();
        }
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public ILMLayer<ViewGroup> getLayerById(String str, Context context2, Map<String, Object> map) throws LMLayerDataSourceException {
        if (str == null) {
            return null;
        }
        for (ILMLayer<ViewGroup> iLMLayer : this.layers) {
            if (str.equals(iLMLayer.getLayerInfo().getPluginId())) {
                return iLMLayer;
            }
        }
        LMLayerInfo layerBean = getLayerBean(str);
        if (layerBean == null) {
            return null;
        }
        return getLayerByBean(layerBean, context2, map);
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public ViewGroup getRootUIContainer() {
        return this.parentViewGroup;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public ViewGroup loadAllConfigLayers() throws LMLayerException {
        if (getChildCount() > 0) {
            removeAllLayers();
        }
        return getAllLayers(this.parentViewGroup, this.context, this.params);
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public ViewGroup loadLayersByConfig() throws LMLayerDataSourceException {
        if (getChildCount() > 0) {
            removeAllLayers();
        }
        ArrayList arrayList = new ArrayList();
        for (LMLayerInfo lMLayerInfo : this.layerClassLoader.getLayers()) {
            if (Boolean.parseBoolean(lMLayerInfo.getParams().get("enable"))) {
                arrayList.add(lMLayerInfo);
            }
        }
        return getLayerByPlugins(this.parentViewGroup, arrayList, this.context, this.params);
    }

    @Override // com.youku.alixplugin.layer.ILMLayerManager
    public ViewGroup loadLayersByIds(List<String> list) throws LMLayerDataSourceException {
        if (list == null) {
            return null;
        }
        if (getChildCount() > 0) {
            removeAllLayers();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(getLayerBean(str));
        }
        return getLayerByPlugins(this.parentViewGroup, arrayList, this.context, this.params);
    }
}
