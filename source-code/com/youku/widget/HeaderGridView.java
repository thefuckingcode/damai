package com.youku.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public class HeaderGridView extends GridView {
    private static final String TAG = "HeaderGridView";
    private ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList<>();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;
        public ViewGroup viewContainer;

        private FixedViewInfo() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class FullWidthFixedViewLayout extends FrameLayout {
        public FullWidthFixedViewLayout(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class HeaderViewGridAdapter implements Filterable, WrapperListAdapter {
        private final ListAdapter mAdapter;
        boolean mAreAllFixedViewsSelectable;
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        ArrayList<FixedViewInfo> mHeaderViewInfos;
        private final boolean mIsFilterable;
        private int mNumColumns = 1;

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> arrayList, ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mIsFilterable = listAdapter instanceof Filterable;
            if (arrayList != null) {
                this.mHeaderViewInfos = arrayList;
                this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(arrayList);
                return;
            }
            throw new IllegalArgumentException("headerViewInfos cannot be null");
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> arrayList) {
            if (arrayList == null) {
                return true;
            }
            Iterator<FixedViewInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().isSelectable) {
                    return false;
                }
            }
            return true;
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                return true;
            }
            if (!this.mAreAllFixedViewsSelectable || !listAdapter.areAllItemsEnabled()) {
                return false;
            }
            return true;
        }

        public int getCount() {
            if (this.mAdapter != null) {
                return (getHeadersCount() * this.mNumColumns) + this.mAdapter.getCount();
            }
            return getHeadersCount() * this.mNumColumns;
        }

        public Filter getFilter() {
            if (this.mIsFilterable) {
                return ((Filterable) this.mAdapter).getFilter();
            }
            return null;
        }

        public int getHeadersCount() {
            return this.mHeaderViewInfos.size();
        }

        public Object getItem(int i) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i >= i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && i4 < listAdapter.getCount()) {
                    return this.mAdapter.getItem(i4);
                }
                throw new ArrayIndexOutOfBoundsException(i);
            } else if (i % i2 == 0) {
                return this.mHeaderViewInfos.get(i / i2).data;
            } else {
                return null;
            }
        }

        public long getItemId(int i) {
            int i2;
            int headersCount = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null || i < headersCount || (i2 = i - headersCount) >= listAdapter.getCount()) {
                return -1;
            }
            return this.mAdapter.getItemId(i2);
        }

        public int getItemViewType(int i) {
            int i2;
            int headersCount = getHeadersCount();
            int i3 = this.mNumColumns;
            int i4 = headersCount * i3;
            if (i >= i4 || i % i3 == 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter == null || i < i4 || (i2 = i - i4) >= listAdapter.getCount()) {
                    return -2;
                }
                return this.mAdapter.getItemViewType(i2);
            }
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                return listAdapter2.getViewTypeCount();
            }
            return 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i < i3) {
                ViewGroup viewGroup2 = this.mHeaderViewInfos.get(i / i2).viewContainer;
                if (i % this.mNumColumns == 0) {
                    return viewGroup2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(viewGroup2.getHeight());
                return view;
            }
            int i4 = i - i3;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && i4 < listAdapter.getCount()) {
                return this.mAdapter.getView(i4, view, viewGroup);
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }

        public int getViewTypeCount() {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount() + 1;
            }
            return 2;
        }

        public ListAdapter getWrappedAdapter() {
            return this.mAdapter;
        }

        public boolean hasStableIds() {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return false;
        }

        public boolean isEmpty() {
            ListAdapter listAdapter = this.mAdapter;
            return (listAdapter == null || listAdapter.isEmpty()) && getHeadersCount() == 0;
        }

        public boolean isEnabled(int i) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int i3 = headersCount * i2;
            if (i < i3) {
                return i % i2 == 0 && this.mHeaderViewInfos.get(i / i2).isSelectable;
            }
            int i4 = i - i3;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && i4 < listAdapter.getCount()) {
                return this.mAdapter.isEnabled(i4);
            }
            throw new ArrayIndexOutOfBoundsException(i);
        }

        public void notifyDataSetChanged() {
            this.mDataSetObservable.notifyChanged();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public boolean removeHeader(View view) {
            for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
                if (this.mHeaderViewInfos.get(i).view == view) {
                    this.mHeaderViewInfos.remove(i);
                    this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos);
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public void setNumColumns(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            } else if (this.mNumColumns != i) {
                this.mNumColumns = i;
                notifyDataSetChanged();
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public HeaderGridView(Context context) {
        super(context);
        initHeaderGridView();
    }

    @SuppressLint({"NewApi"})
    private int getColumns() {
        if (Build.VERSION.SDK_INT >= 11) {
            return getNumColumns();
        }
        try {
            return Integer.parseInt(getFieldValue(this, "mNumColumns").toString());
        } catch (Exception unused) {
            return 2;
        }
    }

    private void initHeaderGridView() {
        super.setClipChildren(false);
    }

    private void removeFixedViewInfo(View view, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).view == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof HeaderViewGridAdapter)) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            FullWidthFixedViewLayout fullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
            fullWidthFixedViewLayout.addView(view);
            fixedViewInfo.view = view;
            fixedViewInfo.viewContainer = fullWidthFixedViewLayout;
            fixedViewInfo.data = obj;
            fixedViewInfo.isSelectable = z;
            this.mHeaderViewInfos.add(fixedViewInfo);
            if (adapter != null) {
                ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str) {
        try {
            Field declaredField = getDeclaredField(obj, str);
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof HeaderViewGridAdapter)) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(getColumns());
        }
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewGridAdapter) adapter).removeHeader(view)) {
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
    }

    public void setClipChildren(boolean z) {
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mHeaderViewInfos.size() > 0) {
            HeaderViewGridAdapter headerViewGridAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, listAdapter);
            int columns = getColumns();
            if (columns > 1) {
                headerViewGridAdapter.setNumColumns(columns);
            }
            super.setAdapter((ListAdapter) headerViewGridAdapter);
            return;
        }
        super.setAdapter(listAdapter);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initHeaderGridView();
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initHeaderGridView();
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }
}
