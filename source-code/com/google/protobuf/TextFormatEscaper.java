package com.google.protobuf;

import tb.d80;

/* compiled from: Taobao */
final class TextFormatEscaper {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface ByteSequence {
        byte byteAt(int i);

        int size();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ByteSequence {
        final /* synthetic */ ByteString a;

        a(ByteString byteString) {
            this.a = byteString;
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public byte byteAt(int i) {
            return this.a.byteAt(i);
        }

        @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
        public int size() {
            return this.a.size();
        }
    }

    static String a(ByteString byteString) {
        return b(new a(byteString));
    }

    static String b(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i = 0; i < byteSequence.size(); i++) {
            byte byteAt = byteSequence.byteAt(i);
            if (byteAt == 34) {
                sb.append("\\\"");
            } else if (byteAt == 39) {
                sb.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (byteAt < 32 || byteAt > 126) {
                            sb.append(d80.TokenESC);
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((byteAt & 7) + 48));
                            break;
                        } else {
                            sb.append((char) byteAt);
                            continue;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String c(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
