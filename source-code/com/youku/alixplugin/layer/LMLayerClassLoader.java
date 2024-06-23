package com.youku.alixplugin.layer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class LMLayerClassLoader implements ILMLayerClassLoader<ILMLayer<?>> {
    private Context ctx;
    private List<LMLayerInfo> layerInfos = new ArrayList();

    public LMLayerClassLoader(Context context, List<LMLayerInfo> list) {
        this.ctx = context;
        if (list != null) {
            this.layerInfos = list;
        }
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public List<LMLayerInfo> getLayerInfos() {
        return this.layerInfos;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public List<LMLayerInfo> getLayers() throws LMLayerDataSourceException {
        return this.layerInfos;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public LMLayerInfo getMapedLayerInfo(String str) throws LMLayerDataSourceException {
        List<LMLayerInfo> list = this.layerInfos;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (LMLayerInfo lMLayerInfo : this.layerInfos) {
            if (str.equals(lMLayerInfo.getPluginId())) {
                return lMLayerInfo;
            }
        }
        return null;
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public void release() {
        this.layerInfos.clear();
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public void release(int i) {
        this.layerInfos.remove(i);
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public synchronized ILMLayer<?> getMapedLayer(String str) throws LMLayerDataSourceException {
        LMLayerInfo mapedLayerInfo = getMapedLayerInfo(str);
        if (mapedLayerInfo == null) {
            return null;
        }
        String viewClass = mapedLayerInfo.getViewClass();
        if (!TextUtils.isEmpty(viewClass)) {
            try {
                Object newInstance = Class.forName(viewClass).getDeclaredConstructor(Context.class).newInstance(this.ctx);
                if (newInstance instanceof ILMLayer) {
                    return (ILMLayer) newInstance;
                }
                Log.e("", "load plugin error!");
                return null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("", String.format("插件类: %s 不存在!", viewClass));
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException(String.format("插件: %s 未配置!", str));
        }
    }

    @Override // com.youku.alixplugin.layer.ILMLayerClassLoader
    public ILMLayer<?> getMapedLayer(LMLayerInfo lMLayerInfo) {
        String viewClass = lMLayerInfo.getViewClass();
        if (!TextUtils.isEmpty(viewClass)) {
            try {
                LMUtilLog.debugLog(LMLayerClassLoader.class, "execute-init-reflect-begin-ViewClassName=" + viewClass);
                Object newInstance = Class.forName(viewClass).getDeclaredConstructor(Context.class, LMLayerInfo.class).newInstance(this.ctx, lMLayerInfo);
                if (newInstance instanceof ILMLayer) {
                    LMUtilLog.debugLog(LMLayerClassLoader.class, "execute-init-reflect-finish-ViewClassName=" + viewClass);
                    return (ILMLayer) newInstance;
                }
                Log.e("", "load plugin error!");
                LMUtilLog.debugLog(LMLayerClassLoader.class, "execute-init-reflect-load plugin error!-ViewClassName");
                return null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Log.e("", String.format("插件类: %s 不存在!", viewClass));
                LMUtilLog.debugLog(LMLayerClassLoader.class, "ClassNotFoundException:" + e.getMessage());
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "InstantiationException" + e2.getMessage());
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "IllegalAccessException" + e3.getMessage());
                return null;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "IllegalArgumentException" + e4.getMessage());
                return null;
            } catch (InvocationTargetException e5) {
                e5.getCause().printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "InvocationTargetException" + e5.getMessage());
                return null;
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
                LMUtilLog.debugLog(LMLayerClassLoader.class, "NoSuchMethodException" + e6.getMessage());
                return null;
            }
        } else {
            throw new IllegalArgumentException(String.format("插件: %s 未配置!", lMLayerInfo.getPluginId()));
        }
    }
}
