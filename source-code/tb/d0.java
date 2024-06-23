package tb;

import com.taobao.pexode.mimetype.MimeType;

/* compiled from: Taobao */
public class d0 {
    public static final MimeType APNG = new MimeType("PNG", "apng", true, new String[]{"png"}, (MimeType.MimeTypeChecker) new a());

    /* compiled from: Taobao */
    static class a implements MimeType.MimeTypeChecker {
        a() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            if (bArr == null || bArr.length < 41 || !vd1.m(bArr, 0, vd1.PNG_HEADER) || !vd1.b(bArr)) {
                return false;
            }
            return true;
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 41;
        }
    }
}
