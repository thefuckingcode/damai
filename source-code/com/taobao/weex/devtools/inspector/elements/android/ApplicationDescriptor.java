package com.taobao.weex.devtools.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.NodeType;
import com.taobao.weex.devtools.inspector.elements.android.ActivityTracker;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ApplicationDescriptor extends AbstractChainedDescriptor<Application> {
    private final ActivityTracker mActivityTracker = ActivityTracker.get();
    private final Map<Application, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ElementContext {
        private Application mElement;
        private final ActivityTracker.Listener mListener = new ActivityTracker.Listener() {
            /* class com.taobao.weex.devtools.inspector.elements.android.ApplicationDescriptor.ElementContext.AnonymousClass1 */

            @Override // com.taobao.weex.devtools.inspector.elements.android.ActivityTracker.Listener
            public void onActivityAdded(Activity activity) {
            }

            @Override // com.taobao.weex.devtools.inspector.elements.android.ActivityTracker.Listener
            public void onActivityRemoved(Activity activity) {
            }
        };

        public ElementContext() {
        }

        public List<Activity> getActivitiesList() {
            return ApplicationDescriptor.this.mActivityTracker.getActivitiesView();
        }

        public void hook(Application application) {
            this.mElement = application;
            ApplicationDescriptor.this.mActivityTracker.registerListener(this.mListener);
        }

        public void unhook() {
            ApplicationDescriptor.this.mActivityTracker.unregisterListener(this.mListener);
            this.mElement = null;
        }
    }

    ApplicationDescriptor() {
    }

    private ElementContext getContext(Application application) {
        return this.mElementToContextMap.get(application);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.taobao.weex.devtools.common.Accumulator] */
    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public /* bridge */ /* synthetic */ void onGetChildren(Application application, Accumulator accumulator) {
        onGetChildren(application, (Accumulator<Object>) accumulator);
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(Application application, Accumulator<Object> accumulator) {
        List<Activity> activitiesList = getContext(application).getActivitiesList();
        for (int size = activitiesList.size() - 1; size >= 0; size--) {
            accumulator.store(activitiesList.get(size));
        }
    }

    /* access modifiers changed from: protected */
    public NodeType onGetNodeType(Application application) {
        return NodeType.ELEMENT_NODE;
    }

    /* access modifiers changed from: protected */
    public void onHook(Application application) {
        ElementContext elementContext = new ElementContext();
        elementContext.hook(application);
        this.mElementToContextMap.put(application, elementContext);
    }

    /* access modifiers changed from: protected */
    public void onUnhook(Application application) {
        this.mElementToContextMap.remove(application).unhook();
    }
}
