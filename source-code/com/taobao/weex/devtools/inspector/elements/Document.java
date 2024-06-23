package com.taobao.weex.devtools.inspector.elements;

import android.app.Activity;
import android.app.Application;
import android.os.SystemClock;
import android.view.View;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.ArrayListAccumulator;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.inspector.elements.ShadowDocument;
import com.taobao.weex.devtools.inspector.helper.ObjectIdMapper;
import com.taobao.weex.devtools.inspector.helper.ThreadBoundProxy;
import com.taobao.weex.devtools.inspector.protocol.module.DOM;
import com.taobao.weex.ui.component.WXComponent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: Taobao */
public final class Document extends ThreadBoundProxy {
    private AttributeListAccumulator mCachedAttributeAccumulator;
    private ChildEventingList mCachedChildEventingList;
    private ArrayListAccumulator<Object> mCachedChildrenAccumulator;
    private final Queue<Object> mCachedUpdateQueue = new ArrayDeque();
    private DocumentProvider mDocumentProvider;
    private final DocumentProviderFactory mFactory;
    private final ObjectIdMapper mObjectIdMapper = new DocumentObjectIdMapper();
    @GuardedBy("this")
    private int mReferenceCounter = 0;
    private ShadowDocument mShadowDocument;
    private UpdateListenerCollection mUpdateListeners = new UpdateListenerCollection();

    /* compiled from: Taobao */
    public static final class AttributeListAccumulator extends ArrayList<String> implements AttributeAccumulator {
        @Override // com.taobao.weex.devtools.inspector.elements.AttributeAccumulator
        public void store(String str, String str2) {
            add(str);
            add(str2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class ChildEventingList extends ArrayList<Object> {
        private DocumentView mDocumentView;
        private Object mParentElement;
        private int mParentNodeId;

        private ChildEventingList() {
            this.mParentElement = null;
            this.mParentNodeId = -1;
        }

        public void acquire(Object obj, DocumentView documentView) {
            int i;
            this.mParentElement = obj;
            if (obj == null) {
                i = -1;
            } else {
                i = Document.this.mObjectIdMapper.getIdForObject(this.mParentElement).intValue();
            }
            this.mParentNodeId = i;
            this.mDocumentView = documentView;
        }

        public void addWithEvent(int i, Object obj, Accumulator<Object> accumulator) {
            int i2;
            Object obj2 = i == 0 ? null : get(i - 1);
            if (obj2 == null) {
                i2 = -1;
            } else {
                i2 = Document.this.mObjectIdMapper.getIdForObject(obj2).intValue();
            }
            add(i, obj);
            Document.this.mUpdateListeners.onChildNodeInserted(this.mDocumentView, obj, this.mParentNodeId, i2, accumulator);
        }

        public void release() {
            clear();
            this.mParentElement = null;
            this.mParentNodeId = -1;
            this.mDocumentView = null;
        }

        public void removeWithEvent(int i) {
            Integer idForObject = Document.this.mObjectIdMapper.getIdForObject(remove(i));
            if (idForObject != null) {
                Document.this.mUpdateListeners.onChildNodeRemoved(this.mParentNodeId, idForObject.intValue());
            }
        }
    }

    /* compiled from: Taobao */
    private final class DocumentObjectIdMapper extends ObjectIdMapper {
        private DocumentObjectIdMapper() {
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.helper.ObjectIdMapper
        public void onMapped(Object obj, int i) {
            Document.this.verifyThreadAccess();
            Document.this.mDocumentProvider.getNodeDescriptor(obj).hook(obj);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.weex.devtools.inspector.helper.ObjectIdMapper
        public void onUnmapped(Object obj, int i) {
            Document.this.verifyThreadAccess();
            Document.this.mDocumentProvider.getNodeDescriptor(obj).unhook(obj);
        }
    }

    /* compiled from: Taobao */
    private final class ProviderListener implements DocumentProviderListener {
        private ProviderListener() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.DocumentProviderListener
        public void onAttributeModified(Object obj, String str, String str2) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onAttributeModified(obj, str, str2);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.DocumentProviderListener
        public void onAttributeRemoved(Object obj, String str) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onAttributeRemoved(obj, str);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.DocumentProviderListener
        public void onInspectRequested(Object obj) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onInspectRequested(obj);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.DocumentProviderListener
        public void onPossiblyChanged() {
            Document.this.updateTree();
        }
    }

    /* compiled from: Taobao */
    public interface UpdateListener {
        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);

        void onChildNodeInserted(DocumentView documentView, Object obj, int i, int i2, Accumulator<Object> accumulator);

        void onChildNodeRemoved(int i, int i2);

        void onInspectRequested(Object obj);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class UpdateListenerCollection implements UpdateListener {
        private final List<UpdateListener> mListeners = new ArrayList();
        private volatile UpdateListener[] mListenersSnapshot;

        public UpdateListenerCollection() {
        }

        private UpdateListener[] getListenersSnapshot() {
            while (true) {
                UpdateListener[] updateListenerArr = this.mListenersSnapshot;
                if (updateListenerArr != null) {
                    return updateListenerArr;
                }
                synchronized (this) {
                    if (this.mListenersSnapshot == null) {
                        List<UpdateListener> list = this.mListeners;
                        this.mListenersSnapshot = (UpdateListener[]) list.toArray(new UpdateListener[list.size()]);
                        return this.mListenersSnapshot;
                    }
                }
            }
        }

        public synchronized void add(UpdateListener updateListener) {
            this.mListeners.add(updateListener);
            this.mListenersSnapshot = null;
        }

        public synchronized void clear() {
            this.mListeners.clear();
            this.mListenersSnapshot = null;
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onAttributeModified(Object obj, String str, String str2) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onAttributeModified(obj, str, str2);
            }
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onAttributeRemoved(Object obj, String str) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onAttributeRemoved(obj, str);
            }
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onChildNodeInserted(DocumentView documentView, Object obj, int i, int i2, Accumulator<Object> accumulator) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onChildNodeInserted(documentView, obj, i, i2, accumulator);
            }
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onChildNodeRemoved(int i, int i2) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onChildNodeRemoved(i, i2);
            }
        }

        @Override // com.taobao.weex.devtools.inspector.elements.Document.UpdateListener
        public void onInspectRequested(Object obj) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onInspectRequested(obj);
            }
        }

        public synchronized void remove(UpdateListener updateListener) {
            this.mListeners.remove(updateListener);
            this.mListenersSnapshot = null;
        }
    }

    public Document(DocumentProviderFactory documentProviderFactory) {
        super(documentProviderFactory);
        this.mFactory = documentProviderFactory;
    }

    private AttributeListAccumulator acquireCachedAttributeAccumulator() {
        AttributeListAccumulator attributeListAccumulator = this.mCachedAttributeAccumulator;
        if (attributeListAccumulator == null) {
            attributeListAccumulator = new AttributeListAccumulator();
        }
        this.mCachedChildrenAccumulator = null;
        return attributeListAccumulator;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ChildEventingList acquireChildEventingList(Object obj, DocumentView documentView) {
        ChildEventingList childEventingList = this.mCachedChildEventingList;
        if (childEventingList == null) {
            childEventingList = new ChildEventingList();
        }
        this.mCachedChildEventingList = null;
        childEventingList.acquire(obj, documentView);
        return childEventingList;
    }

    private ArrayListAccumulator<Object> acquireChildrenAccumulator() {
        ArrayListAccumulator<Object> arrayListAccumulator = this.mCachedChildrenAccumulator;
        if (arrayListAccumulator == null) {
            arrayListAccumulator = new ArrayListAccumulator<>();
        }
        this.mCachedChildrenAccumulator = null;
        return arrayListAccumulator;
    }

    private void applyDocumentUpdate(final ShadowDocument.Update update) {
        update.getGarbageElements(new Accumulator<Object>() {
            /* class com.taobao.weex.devtools.inspector.elements.Document.AnonymousClass3 */

            @Override // com.taobao.weex.devtools.common.Accumulator
            public void store(Object obj) {
                if (Document.this.mObjectIdMapper.containsObject(obj)) {
                    if (update.getElementInfo(obj).parentElement == null) {
                        Integer idForObject = Document.this.mObjectIdMapper.getIdForObject(Document.this.mShadowDocument.getElementInfo(obj).parentElement);
                        Integer idForObject2 = Document.this.mObjectIdMapper.getIdForObject(obj);
                        if (!(idForObject == null || idForObject2 == null)) {
                            Document.this.mUpdateListeners.onChildNodeRemoved(idForObject.intValue(), idForObject2.intValue());
                        }
                    }
                    Document.this.mObjectIdMapper.removeObject(obj);
                    return;
                }
                throw new IllegalStateException();
            }
        });
        update.getChangedElements(new Accumulator<Object>() {
            /* class com.taobao.weex.devtools.inspector.elements.Document.AnonymousClass4 */

            @Override // com.taobao.weex.devtools.common.Accumulator
            public void store(Object obj) {
                ElementInfo elementInfo;
                if (Document.this.mObjectIdMapper.containsObject(obj) && (elementInfo = Document.this.mShadowDocument.getElementInfo(obj)) != null && update.getElementInfo(obj).parentElement != elementInfo.parentElement) {
                    Integer idForObject = Document.this.mObjectIdMapper.getIdForObject(elementInfo.parentElement);
                    Integer idForObject2 = Document.this.mObjectIdMapper.getIdForObject(obj);
                    if (idForObject != null && idForObject2 != null) {
                        Document.this.mUpdateListeners.onChildNodeRemoved(idForObject.intValue(), idForObject2.intValue());
                    }
                }
            }
        });
        update.getChangedElements(new Accumulator<Object>() {
            /* class com.taobao.weex.devtools.inspector.elements.Document.AnonymousClass5 */
            private Accumulator<Object> insertedElements = new Accumulator<Object>() {
                /* class com.taobao.weex.devtools.inspector.elements.Document.AnonymousClass5.AnonymousClass1 */

                @Override // com.taobao.weex.devtools.common.Accumulator
                public void store(Object obj) {
                    if (update.isElementChanged(obj)) {
                        AnonymousClass5.this.listenerInsertedElements.add(obj);
                    }
                }
            };
            private final HashSet<Object> listenerInsertedElements = new HashSet<>();

            @Override // com.taobao.weex.devtools.common.Accumulator
            public void store(Object obj) {
                List<Object> list;
                ElementInfo elementInfo;
                if (Document.this.mObjectIdMapper.containsObject(obj) && !this.listenerInsertedElements.contains(obj)) {
                    ElementInfo elementInfo2 = Document.this.mShadowDocument.getElementInfo(obj);
                    ElementInfo elementInfo3 = update.getElementInfo(obj);
                    if (elementInfo2 != null) {
                        list = elementInfo2.children;
                    } else {
                        list = Collections.emptyList();
                    }
                    List<Object> list2 = elementInfo3.children;
                    ChildEventingList acquireChildEventingList = Document.this.acquireChildEventingList(obj, update);
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        Object obj2 = list.get(i);
                        if (Document.this.mObjectIdMapper.containsObject(obj2) && ((elementInfo = update.getElementInfo(obj2)) == null || elementInfo.parentElement == obj)) {
                            acquireChildEventingList.add(obj2);
                        }
                    }
                    Document.updateListenerChildren(acquireChildEventingList, list2, this.insertedElements);
                    Document.this.releaseChildEventingList(acquireChildEventingList);
                }
            }
        });
        update.commit();
    }

    private void cleanUp() {
        this.mDocumentProvider.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.elements.Document.AnonymousClass2 */

            public void run() {
                Document.this.mDocumentProvider.setListener(null);
                Document.this.mShadowDocument = null;
                Document.this.mObjectIdMapper.clear();
                Document.this.mDocumentProvider.dispose();
                Document.this.mDocumentProvider = null;
            }
        });
        this.mUpdateListeners.clear();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ShadowDocument.Update createShadowDocumentUpdate() {
        verifyThreadAccess();
        if (this.mDocumentProvider.getRootElement() == this.mShadowDocument.getRootElement()) {
            ArrayListAccumulator<Object> acquireChildrenAccumulator = acquireChildrenAccumulator();
            ShadowDocument.UpdateBuilder beginUpdate = this.mShadowDocument.beginUpdate();
            this.mCachedUpdateQueue.add(this.mDocumentProvider.getRootElement());
            while (!this.mCachedUpdateQueue.isEmpty()) {
                Object remove = this.mCachedUpdateQueue.remove();
                NodeDescriptor nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(remove);
                this.mObjectIdMapper.putObject(remove);
                nodeDescriptor.getChildren(remove, acquireChildrenAccumulator);
                int size = acquireChildrenAccumulator.size();
                int i = 0;
                while (i < size) {
                    Object obj = acquireChildrenAccumulator.get(i);
                    if (obj != null) {
                        this.mCachedUpdateQueue.add(obj);
                    } else {
                        LogUtil.e("%s.getChildren() emitted a null child at position %s for element %s", nodeDescriptor.getClass().getName(), Integer.toString(i), remove);
                        acquireChildrenAccumulator.remove(i);
                        i--;
                        size--;
                    }
                    i++;
                }
                beginUpdate.setElementChildren(remove, acquireChildrenAccumulator);
                acquireChildrenAccumulator.clear();
            }
            releaseChildrenAccumulator(acquireChildrenAccumulator);
            return beginUpdate.build();
        }
        throw new IllegalStateException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    private boolean doesElementMatch(Object obj, int i, int i2) {
        View view;
        if (DOM.isNativeMode()) {
            if (obj instanceof View) {
                view = (View) obj;
                return view == null && isPointInsideView(i, i2, view) && view.isShown();
            }
        } else if (obj instanceof WXComponent) {
            view = ((WXComponent) obj).getHostView();
            if (view == null) {
            }
        }
        view = null;
        if (view == null) {
        }
    }

    private void findMatches(Object obj, int i, int i2, Accumulator<Integer> accumulator, Boolean bool) {
        ElementInfo elementInfo = this.mShadowDocument.getElementInfo(obj);
        for (int size = elementInfo.children.size() - 1; size >= 0; size--) {
            Object obj2 = elementInfo.children.get(size);
            if (doesElementMatch(obj2, i, i2)) {
                accumulator.store(this.mObjectIdMapper.getIdForObject(obj2));
                bool = Boolean.TRUE;
            }
            findMatches(obj2, i, i2, accumulator, bool);
        }
    }

    private void init() {
        DocumentProvider create = this.mFactory.create();
        this.mDocumentProvider = create;
        create.postAndWait(new Runnable() {
            /* class com.taobao.weex.devtools.inspector.elements.Document.AnonymousClass1 */

            public void run() {
                Document document = Document.this;
                document.mShadowDocument = new ShadowDocument(document.mDocumentProvider.getRootElement());
                Document.this.createShadowDocumentUpdate().commit();
                Document.this.mDocumentProvider.setListener(new ProviderListener());
            }
        });
    }

    public static boolean isPointInsideView(int i, int i2, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        if (i <= i3 || i2 <= i4 || i >= i3 + view.getWidth() || i2 >= i4 + view.getHeight()) {
            return false;
        }
        return true;
    }

    private void releaseCachedAttributeAccumulator(AttributeListAccumulator attributeListAccumulator) {
        attributeListAccumulator.clear();
        if (this.mCachedAttributeAccumulator == null) {
            this.mCachedAttributeAccumulator = attributeListAccumulator;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void releaseChildEventingList(ChildEventingList childEventingList) {
        childEventingList.release();
        if (this.mCachedChildEventingList == null) {
            this.mCachedChildEventingList = childEventingList;
        }
    }

    private void releaseChildrenAccumulator(ArrayListAccumulator<Object> arrayListAccumulator) {
        arrayListAccumulator.clear();
        if (this.mCachedChildrenAccumulator == null) {
            this.mCachedChildrenAccumulator = arrayListAccumulator;
        }
    }

    /* access modifiers changed from: private */
    public static void updateListenerChildren(ChildEventingList childEventingList, List<Object> list, Accumulator<Object> accumulator) {
        int i = 0;
        while (i <= childEventingList.size()) {
            if (i == childEventingList.size()) {
                if (i != list.size()) {
                    childEventingList.addWithEvent(i, list.get(i), accumulator);
                } else {
                    return;
                }
            } else if (i == list.size()) {
                childEventingList.removeWithEvent(i);
            } else {
                Object obj = childEventingList.get(i);
                Object obj2 = list.get(i);
                if (obj != obj2) {
                    int indexOf = childEventingList.indexOf(obj2);
                    if (indexOf == -1) {
                        childEventingList.addWithEvent(i, obj2, accumulator);
                    } else {
                        childEventingList.removeWithEvent(indexOf);
                        childEventingList.addWithEvent(i, obj2, accumulator);
                    }
                }
            }
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTree() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ShadowDocument.Update createShadowDocumentUpdate = createShadowDocumentUpdate();
        boolean isEmpty = createShadowDocumentUpdate.isEmpty();
        if (isEmpty) {
            createShadowDocumentUpdate.abandon();
        } else {
            applyDocumentUpdate(createShadowDocumentUpdate);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        Object[] objArr = new Object[2];
        objArr[0] = Long.toString(elapsedRealtime2);
        objArr[1] = isEmpty ? " (no changes)" : "";
        LogUtil.d("Document.updateTree() completed in %s ms%s", objArr);
    }

    public synchronized void addRef() {
        int i = this.mReferenceCounter;
        this.mReferenceCounter = i + 1;
        if (i == 0) {
            init();
        }
    }

    public void addUpdateListener(UpdateListener updateListener) {
        this.mUpdateListeners.add(updateListener);
    }

    public void findMatchingElements(int i, int i2, Accumulator<Integer> accumulator) {
        verifyThreadAccess();
        ElementInfo elementInfo = this.mShadowDocument.getElementInfo(this.mDocumentProvider.getRootElement());
        if (elementInfo != null) {
            for (int size = elementInfo.children.size() - 1; size >= 0; size--) {
                Object obj = elementInfo.children.get(size);
                Boolean bool = Boolean.FALSE;
                if (DOM.isNativeMode()) {
                    if (obj instanceof Application) {
                        for (int size2 = elementInfo.children.size() - 1; size2 >= 0; size2--) {
                            ElementInfo elementInfo2 = this.mShadowDocument.getElementInfo(obj);
                            if (elementInfo2 != null) {
                                Object obj2 = elementInfo2.children.get(size2);
                                if (obj2 instanceof Activity) {
                                    findMatches(obj2, i, i2, accumulator, bool);
                                }
                            }
                        }
                    }
                } else if (obj instanceof WXSDKInstance) {
                    findMatches(obj, i, i2, accumulator, bool);
                }
            }
        }
    }

    public DocumentView getDocumentView() {
        verifyThreadAccess();
        return this.mShadowDocument;
    }

    @Nullable
    public Object getElementForNodeId(int i) {
        return this.mObjectIdMapper.getObjectForId(i);
    }

    public void getElementStyles(Object obj, StyleAccumulator styleAccumulator) {
        getNodeDescriptor(obj).getStyles(obj, styleAccumulator);
    }

    @Nullable
    public NodeDescriptor getNodeDescriptor(Object obj) {
        verifyThreadAccess();
        return this.mDocumentProvider.getNodeDescriptor(obj);
    }

    @Nullable
    public Integer getNodeIdForElement(Object obj) {
        return this.mObjectIdMapper.getIdForObject(obj);
    }

    public Object getRootElement() {
        verifyThreadAccess();
        Object rootElement = this.mDocumentProvider.getRootElement();
        if (rootElement == null) {
            throw new IllegalStateException();
        } else if (rootElement == this.mShadowDocument.getRootElement()) {
            return rootElement;
        } else {
            throw new IllegalStateException();
        }
    }

    public void hideHighlight() {
        verifyThreadAccess();
        this.mDocumentProvider.hideHighlight();
    }

    public void highlightElement(Object obj, int i) {
        verifyThreadAccess();
        this.mDocumentProvider.highlightElement(obj, i);
    }

    public synchronized void release() {
        int i = this.mReferenceCounter;
        if (i > 0) {
            int i2 = i - 1;
            this.mReferenceCounter = i2;
            if (i2 == 0) {
                cleanUp();
            }
        }
    }

    public void removeUpdateListener(UpdateListener updateListener) {
        this.mUpdateListeners.remove(updateListener);
    }

    public void setAttributesAsText(Object obj, String str) {
        verifyThreadAccess();
        this.mDocumentProvider.setAttributesAsText(obj, str);
    }

    public void setInspectModeEnabled(boolean z) {
        verifyThreadAccess();
        this.mDocumentProvider.setInspectModeEnabled(z);
    }

    private boolean doesElementMatch(Object obj, Pattern pattern) {
        AttributeListAccumulator acquireCachedAttributeAccumulator = acquireCachedAttributeAccumulator();
        NodeDescriptor nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(obj);
        nodeDescriptor.getAttributes(obj, acquireCachedAttributeAccumulator);
        int size = acquireCachedAttributeAccumulator.size();
        for (int i = 0; i < size; i++) {
            if (pattern.matcher((CharSequence) acquireCachedAttributeAccumulator.get(i)).find()) {
                releaseCachedAttributeAccumulator(acquireCachedAttributeAccumulator);
                return true;
            }
        }
        releaseCachedAttributeAccumulator(acquireCachedAttributeAccumulator);
        return pattern.matcher(nodeDescriptor.getNodeName(obj)).find();
    }

    private void findMatches(Object obj, Pattern pattern, Accumulator<Integer> accumulator) {
        ElementInfo elementInfo = this.mShadowDocument.getElementInfo(obj);
        int size = elementInfo.children.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = elementInfo.children.get(i);
            if (doesElementMatch(obj2, pattern)) {
                accumulator.store(this.mObjectIdMapper.getIdForObject(obj2));
            }
            findMatches(obj2, pattern, accumulator);
        }
    }

    public void findMatchingElements(String str, Accumulator<Integer> accumulator) {
        verifyThreadAccess();
        findMatches(this.mDocumentProvider.getRootElement(), Pattern.compile(Pattern.quote(str), 2), accumulator);
    }
}
