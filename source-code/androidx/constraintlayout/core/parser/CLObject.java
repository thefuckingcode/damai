package androidx.constraintlayout.core.parser;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    /* compiled from: Taobao */
    private class CLObjectIterator implements Iterator {
        int index = 0;
        CLObject myObject;

        public CLObjectIterator(CLObject cLObject) {
            this.myObject = cLObject;
        }

        public boolean hasNext() {
            return this.index < this.myObject.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey cLKey = (CLKey) this.myObject.mElements.get(this.index);
            this.index++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            } else {
                z = false;
            }
            sb.append(next.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder(getDebugName());
        sb.append("{\n");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (!z) {
                sb.append(",\n");
            } else {
                z = false;
            }
            sb.append(next.toFormattedJSON(CLElement.BASE_INDENT + i, i2 - 1));
        }
        sb.append(StringUtils.LF);
        addIndent(sb, i);
        sb.append("}");
        return sb.toString();
    }
}
