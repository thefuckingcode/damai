package com.real.android.nativehtml.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.dom.HtmlSelectElement;
import com.real.android.nativehtml.common.util.HtmlCollectionImpl;
import tb.sa0;

/* compiled from: Taobao */
public class AndroidSelectElement extends AndroidWrapperElement implements HtmlSelectElement {
    HtmlCollectionImpl children = new HtmlCollectionImpl();
    Spinner spinner;

    /* compiled from: Taobao */
    private class SelectElementAdapter extends BaseAdapter {
        LayoutInflater inflater;

        private SelectElementAdapter() {
            this.inflater = (LayoutInflater) AndroidSelectElement.this.getContext().getSystemService("layout_inflater");
        }

        private View getResourceView(int i, View view, ViewGroup viewGroup, int i2) {
            if (view == null) {
                view = this.inflater.inflate(i2, viewGroup, false);
            }
            TextView textView = (TextView) view;
            textView.setText(((Element) getItem(i)).getTextContent());
            return textView;
        }

        public int getCount() {
            return AndroidSelectElement.this.children.getLength();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getResourceView(i, view, viewGroup, 17367049);
        }

        public Object getItem(int i) {
            return AndroidSelectElement.this.children.item(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getResourceView(i, view, viewGroup, 17367048);
        }
    }

    AndroidSelectElement(Context context, sa0 sa0) {
        super(context, sa0, "select", new Spinner(context));
        Spinner spinner2 = (Spinner) this.child;
        this.spinner = spinner2;
        spinner2.setAdapter((SpinnerAdapter) new SelectElementAdapter());
    }

    @Override // com.real.android.nativehtml.common.dom.Element, com.real.android.nativehtml.android.AndroidWrapperElement
    public HtmlCollection getChildren() {
        return this.children;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.DATA_ELEMENTS;
    }

    @Override // com.real.android.nativehtml.common.dom.Element, com.real.android.nativehtml.android.AndroidWrapperElement
    public void insertBefore(Element element, Element element2) {
        this.children.insertBefore(this, element, element2);
        ((SelectElementAdapter) this.spinner.getAdapter()).notifyDataSetChanged();
    }

    @Override // com.real.android.nativehtml.common.dom.Element, com.real.android.nativehtml.android.AbstractAndroidComponentElement
    public void setAttribute(String str, String str2) {
        super.setAttribute(str, str2);
    }
}
