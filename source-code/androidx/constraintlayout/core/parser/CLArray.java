package androidx.constraintlayout.core.parser;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i2 > 0 || json.length() + i >= CLElement.MAX_LINE) {
            sb.append("[\n");
            Iterator<CLElement> it = this.mElements.iterator();
            boolean z = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (!z) {
                    sb.append(",\n");
                } else {
                    z = false;
                }
                addIndent(sb, CLElement.BASE_INDENT + i);
                sb.append(next.toFormattedJSON(CLElement.BASE_INDENT + i, i2 - 1));
            }
            sb.append(StringUtils.LF);
            addIndent(sb, i);
            sb.append(jl1.ARRAY_END_STR);
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + jl1.ARRAY_START_STR);
        boolean z = true;
        for (int i = 0; i < this.mElements.size(); i++) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            } else {
                z = false;
            }
            sb.append(this.mElements.get(i).toJSON());
        }
        return ((Object) sb) + jl1.ARRAY_END_STR;
    }
}
