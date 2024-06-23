package com.taobao.weex.ui.component.list;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSON;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXBaseRefresh;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXRefresh;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(lazyload = false)
/* compiled from: Taobao */
public class WXListComponent extends BasicListComponent<BounceRecyclerView> {
    private String TAG;
    private boolean hasSetGapItemDecoration;
    private float mPaddingLeft;
    private float mPaddingRight;
    private Float[] mSpanOffsets;
    private String mSpanOffsetsStr;

    /* compiled from: Taobao */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXListComponent(wXSDKInstance, wXVContainer, true, basicComponentData);
        }
    }

    @Deprecated
    public WXListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    private boolean hasColumnPros() {
        return (getAttrs().containsKey(Constants.Name.COLUMN_WIDTH) && this.mColumnWidth != WXUtils.parseFloat(getAttrs().get(Constants.Name.COLUMN_WIDTH))) || (getAttrs().containsKey(Constants.Name.COLUMN_COUNT) && this.mColumnCount != WXUtils.parseInt(getAttrs().get(Constants.Name.COLUMN_COUNT))) || (getAttrs().containsKey(Constants.Name.COLUMN_GAP) && this.mColumnGap != WXUtils.parseFloat(getAttrs().get(Constants.Name.COLUMN_GAP)));
    }

    private boolean isRecycler(WXComponent wXComponent) {
        return WXBasicComponentType.WATERFALL.equals(wXComponent.getComponentType()) || WXBasicComponentType.RECYCLE_LIST.equals(wXComponent.getComponentType()) || WXBasicComponentType.RECYCLER.equals(wXComponent.getComponentType());
    }

    private void removeFooterOrHeader(WXComponent wXComponent) {
        if (wXComponent instanceof WXLoading) {
            ((BounceRecyclerView) getHostView()).removeFooterView(wXComponent);
        } else if (wXComponent instanceof WXRefresh) {
            ((BounceRecyclerView) getHostView()).removeHeaderView(wXComponent);
        }
    }

    private boolean setRefreshOrLoading(final WXComponent wXComponent) {
        if (getHostView() == null) {
            WXLogUtils.e(this.TAG, "setRefreshOrLoading: HostView == null !!!!!! check list attr has append =tree");
            return true;
        } else if (wXComponent instanceof WXRefresh) {
            ((BounceRecyclerView) getHostView()).setOnRefreshListener((WXRefresh) wXComponent);
            ((BounceRecyclerView) getHostView()).postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.component.list.WXListComponent.AnonymousClass1 */

                public void run() {
                    ((BounceRecyclerView) WXListComponent.this.getHostView()).setHeaderView(wXComponent);
                }
            }), 100);
            return true;
        } else if (!(wXComponent instanceof WXLoading)) {
            return false;
        } else {
            ((BounceRecyclerView) getHostView()).setOnLoadingListener((WXLoading) wXComponent);
            ((BounceRecyclerView) getHostView()).postDelayed(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.component.list.WXListComponent.AnonymousClass2 */

                public void run() {
                    ((BounceRecyclerView) WXListComponent.this.getHostView()).setFooterView(wXComponent);
                }
            }), 100);
            return true;
        }
    }

    private void updateRecyclerAttr() {
        int parseInt = WXUtils.parseInt(getAttrs().get(Constants.Name.COLUMN_COUNT));
        this.mColumnCount = parseInt;
        if (parseInt <= 0 && this.mLayoutType != 1) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, getComponentType());
            arrayMap.put("attribute", getAttrs().toString());
            arrayMap.put("stackTrace", Arrays.toString(Thread.currentThread().getStackTrace()));
            WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), WXErrorCode.WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT, Constants.Name.COLUMN_COUNT, String.format(Locale.ENGLISH, "You are trying to set the list/recycler/vlist/waterfall's column to %d, which is illegal. The column count should be a positive integer", Integer.valueOf(this.mColumnCount)), arrayMap);
            this.mColumnCount = 1;
        }
        this.mColumnGap = WXUtils.parseFloat(getAttrs().get(Constants.Name.COLUMN_GAP));
        this.mColumnWidth = WXUtils.parseFloat(getAttrs().get(Constants.Name.COLUMN_WIDTH));
        this.mPaddingLeft = WXUtils.parseFloat(getAttrs().get("paddingLeft"));
        this.mPaddingRight = WXUtils.parseFloat(getAttrs().get("paddingRight"));
        String str = (String) getAttrs().get(Constants.Name.SPAN_OFFSETS);
        this.mSpanOffsetsStr = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                List parseArray = JSON.parseArray(this.mSpanOffsetsStr, Float.class);
                int size = parseArray.size();
                Float[] fArr = this.mSpanOffsets;
                if (fArr == null || fArr.length != size) {
                    this.mSpanOffsets = new Float[size];
                }
                parseArray.toArray(this.mSpanOffsets);
            } else {
                this.mSpanOffsets = null;
            }
        } catch (Throwable th) {
            WXLogUtils.w("Parser SpanOffsets error ", th);
        }
        if (!this.hasSetGapItemDecoration && getSpanOffsets() != null && getHostView() != null && ((BounceRecyclerView) getHostView()).getInnerView() != null) {
            this.hasSetGapItemDecoration = true;
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).addItemDecoration(new GapItemDecoration(this));
        }
    }

    @Override // com.taobao.weex.ui.component.list.BasicListComponent, com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent, int i) {
        super.addChild(wXComponent, i);
        if (wXComponent != null && i >= -1) {
            setRefreshOrLoading(wXComponent);
            if (getHostView() != null && hasColumnPros()) {
                updateRecyclerAttr();
                ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void createChildViewAt(int i) {
        if (i >= 0 || childCount() - 1 >= 0) {
            final WXComponent child = getChild(i);
            if (child instanceof WXBaseRefresh) {
                child.createView();
                if (child instanceof WXRefresh) {
                    ((BounceRecyclerView) getHostView()).setOnRefreshListener((WXRefresh) child);
                    ((BounceRecyclerView) getHostView()).postDelayed(new Runnable() {
                        /* class com.taobao.weex.ui.component.list.WXListComponent.AnonymousClass3 */

                        public void run() {
                            ((BounceRecyclerView) WXListComponent.this.getHostView()).setHeaderView(child);
                        }
                    }, 100);
                } else if (child instanceof WXLoading) {
                    ((BounceRecyclerView) getHostView()).setOnLoadingListener((WXLoading) child);
                    ((BounceRecyclerView) getHostView()).postDelayed(new Runnable() {
                        /* class com.taobao.weex.ui.component.list.WXListComponent.AnonymousClass4 */

                        public void run() {
                            ((BounceRecyclerView) WXListComponent.this.getHostView()).setFooterView(child);
                        }
                    }, 100);
                }
            } else {
                super.createChildViewAt(i);
            }
        }
    }

    public Float[] getSpanOffsets() {
        return this.mSpanOffsets;
    }

    @Override // com.taobao.weex.ui.component.list.BasicListComponent, com.taobao.weex.ui.component.WXVContainer
    public void remove(WXComponent wXComponent, boolean z) {
        super.remove(wXComponent, z);
        removeFooterOrHeader(wXComponent);
    }

    @WXComponentProp(name = Constants.Name.COLUMN_COUNT)
    public void setColumnCount(int i) {
        if (i != this.mColumnCount) {
            markComponentUsable();
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @WXComponentProp(name = Constants.Name.COLUMN_GAP)
    public void setColumnGap(float f) throws InterruptedException {
        if (f != this.mColumnGap) {
            markComponentUsable();
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @WXComponentProp(name = Constants.Name.COLUMN_WIDTH)
    public void setColumnWidth(float f) {
        if (f != this.mColumnWidth) {
            markComponentUsable();
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    @WXComponentProp(name = Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).setScrollable(z);
    }

    @WXComponentProp(name = Constants.Name.SPAN_OFFSETS)
    public void setSpanOffsets(String str) {
        if (!TextUtils.equals(str, this.mSpanOffsetsStr)) {
            markComponentUsable();
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(Map<String, Object> map) {
        super.updateProperties(map);
        if (isRecycler(this)) {
            if (WXBasicComponentType.WATERFALL.equals(getComponentType())) {
                this.mLayoutType = 3;
            } else {
                this.mLayoutType = getAttrs().getLayoutType();
            }
        }
        if (!map.containsKey(Constants.Name.PADDING) && !map.containsKey("paddingLeft") && !map.containsKey("paddingRight")) {
            return;
        }
        if (this.mPaddingLeft != WXUtils.parseFloat(map.get("paddingLeft")) || this.mPaddingRight != WXUtils.parseFloat(map.get("paddingRight"))) {
            markComponentUsable();
            updateRecyclerAttr();
            ((WXRecyclerView) ((BounceRecyclerView) getHostView()).getInnerView()).initView(getContext(), this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        }
    }

    public WXListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.TAG = "WXListComponent";
        this.hasSetGapItemDecoration = false;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.list.BasicListComponent
    public BounceRecyclerView generateListView(Context context, int i) {
        SnapHelper snapHelper;
        BounceRecyclerView bounceRecyclerView = new BounceRecyclerView(context, this.mLayoutType, this.mColumnCount, this.mColumnGap, i);
        if (bounceRecyclerView.getSwipeLayout() != null && WXUtils.getBoolean(getAttrs().get(Constants.Name.NEST_SCROLLING_ENABLED), Boolean.FALSE).booleanValue()) {
            bounceRecyclerView.getSwipeLayout().setNestedScrollingEnabled(true);
        }
        if (WXUtils.getBoolean(getAttrs().get(Constants.Name.PAGE_ENABLED), Boolean.FALSE).booleanValue()) {
            if (TextUtils.isEmpty(WXUtils.getString(getAttrs().get(Constants.Name.PAGE_SIZE), null))) {
                snapHelper = new PagerSnapHelper();
            } else {
                snapHelper = new WXPagerSnapHelper();
            }
            snapHelper.attachToRecyclerView((RecyclerView) bounceRecyclerView.getInnerView());
        }
        return bounceRecyclerView;
    }
}
