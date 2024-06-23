package com.taobao.weex.ui.component.richtext.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.taobao.weex.ui.component.richtext.span.ASpan;
import com.taobao.weex.ui.component.richtext.span.ItemClickSpan;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ANode extends RichTextNode {
    public static final String HREF = "href";
    public static final String NODE_TYPE = "a";

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public boolean isInternalNode() {
        return true;
    }

    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public String toString() {
        return "";
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.richtext.node.RichTextNode
    public void updateSpans(SpannableStringBuilder spannableStringBuilder, int i) {
        super.updateSpans(spannableStringBuilder, i);
        Map<String, Object> map = this.attr;
        if (map == null || !map.containsKey(RichTextNode.PSEUDO_REF)) {
            Map<String, Object> map2 = this.attr;
            if (map2 != null && map2.containsKey("href")) {
                spannableStringBuilder.setSpan(new ASpan(this.mInstanceId, this.attr.get("href").toString()), 0, spannableStringBuilder.length(), RichTextNode.createSpanFlag(i));
                return;
            }
            return;
        }
        spannableStringBuilder.setSpan(new ItemClickSpan(this.mInstanceId, this.mComponentRef, this.attr.get(RichTextNode.PSEUDO_REF).toString()), 0, spannableStringBuilder.length(), RichTextNode.createSpanFlag(i));
    }

    /* compiled from: Taobao */
    static class ANodeCreator implements RichTextNodeCreator<ANode> {
        ANodeCreator() {
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public ANode createRichTextNode(Context context, String str, String str2) {
            return new ANode(context, str, str2);
        }

        @Override // com.taobao.weex.ui.component.richtext.node.RichTextNodeCreator
        public ANode createRichTextNode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
            return new ANode(context, str, str2, str3, map, map2);
        }
    }

    private ANode(Context context, String str, String str2) {
        super(context, str, str2);
    }

    private ANode(Context context, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        super(context, str, str2, str3, map, map2);
    }
}
