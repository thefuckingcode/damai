package androidx.constraintlayout.core.parser;

/* compiled from: Taobao */
public class CLParser {
    static boolean DEBUG;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.parser.CLParser$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = iArr;
            iArr[TYPE.OBJECT.ordinal()] = 1;
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLElement cLElement2;
        if (DEBUG) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[type.ordinal()]) {
            case 1:
                cLElement2 = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                cLElement2 = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                cLElement2 = CLString.allocate(cArr);
                break;
            case 4:
                cLElement2 = CLNumber.allocate(cArr);
                break;
            case 5:
                cLElement2 = CLKey.allocate(cArr);
                break;
            case 6:
                cLElement2 = CLToken.allocate(cArr);
                break;
            default:
                cLElement2 = null;
                break;
        }
        if (cLElement2 == null) {
            return null;
        }
        cLElement2.setLine(this.lineNumber);
        if (z) {
            cLElement2.setStart((long) i);
        }
        if (cLElement instanceof CLContainer) {
            cLElement2.setContainer((CLContainer) cLElement);
        }
        return cLElement2;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c == '\t' || c == '\n' || c == '\r' || c == ' ') {
            return cLElement;
        }
        if (c == '\"' || c == '\'') {
            if (cLElement instanceof CLObject) {
                return createElement(cLElement, i, TYPE.KEY, true, cArr);
            }
            return createElement(cLElement, i, TYPE.STRING, true, cArr);
        } else if (c == '[') {
            return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
        } else {
            if (c != ']') {
                if (c == '{') {
                    return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
                }
                if (c != '}') {
                    switch (c) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            return cLElement;
                        case '/':
                            int i2 = i + 1;
                            if (i2 >= cArr.length || cArr[i2] != '/') {
                                return cLElement;
                            }
                            this.hasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i, TYPE.KEY, true, cArr);
                            }
                            CLElement createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) createElement;
                            if (cLToken.validate(c, (long) i)) {
                                return createElement;
                            }
                            throw new CLParsingException("incorrect token <" + c + "> at line " + this.lineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd((long) (i - 1));
            CLElement container = cLElement.getContainer();
            container.setEnd((long) i);
            return container;
        }
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i = 1;
        this.lineNumber = 1;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            char c = charArray[i2];
            if (c == '{') {
                break;
            }
            if (c == '\n') {
                this.lineNumber++;
            }
            i2++;
        }
        if (i2 != -1) {
            CLObject allocate = CLObject.allocate(charArray);
            allocate.setLine(this.lineNumber);
            allocate.setStart((long) i2);
            int i3 = i2 + 1;
            CLObject cLObject = allocate;
            while (i3 < length) {
                char c2 = charArray[i3];
                if (c2 == '\n') {
                    this.lineNumber += i;
                }
                if (this.hasComment) {
                    if (c2 == '\n') {
                        this.hasComment = z;
                    } else {
                        continue;
                        i3++;
                        i = 1;
                        z = false;
                    }
                }
                if (cLObject == null) {
                    break;
                }
                if (cLObject.isDone()) {
                    cLObject = getNextJsonElement(i3, c2, cLObject, charArray);
                } else if (cLObject instanceof CLObject) {
                    if (c2 == '}') {
                        cLObject.setEnd((long) (i3 - 1));
                    } else {
                        cLObject = getNextJsonElement(i3, c2, cLObject, charArray);
                    }
                } else if (!(cLObject instanceof CLArray)) {
                    boolean z2 = cLObject instanceof CLString;
                    if (z2) {
                        long j = cLObject.start;
                        if (charArray[(int) j] == c2) {
                            cLObject.setStart(j + 1);
                            cLObject.setEnd((long) (i3 - 1));
                        }
                    } else {
                        if (cLObject instanceof CLToken) {
                            CLToken cLToken = (CLToken) cLObject;
                            if (!cLToken.validate(c2, (long) i3)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                            }
                        }
                        if ((cLObject instanceof CLKey) || z2) {
                            long j2 = cLObject.start;
                            char c3 = charArray[(int) j2];
                            if ((c3 == '\'' || c3 == '\"') && c3 == c2) {
                                cLObject.setStart(j2 + 1);
                                cLObject.setEnd((long) (i3 - 1));
                            }
                        }
                        if (!cLObject.isDone() && (c2 == '}' || c2 == ']' || c2 == ',' || c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == ':')) {
                            long j3 = (long) (i3 - 1);
                            cLObject.setEnd(j3);
                            if (c2 == '}' || c2 == ']') {
                                cLObject = cLObject.getContainer();
                                cLObject.setEnd(j3);
                                if (cLObject instanceof CLKey) {
                                    cLObject = cLObject.getContainer();
                                    cLObject.setEnd(j3);
                                }
                            }
                        }
                    }
                } else if (c2 == ']') {
                    cLObject.setEnd((long) (i3 - 1));
                } else {
                    cLObject = getNextJsonElement(i3, c2, cLObject, charArray);
                }
                if (cLObject.isDone() && (!(cLObject instanceof CLKey) || ((CLKey) cLObject).mElements.size() > 0)) {
                    cLObject = cLObject.getContainer();
                }
                i3++;
                i = 1;
                z = false;
            }
            while (cLObject != null && !cLObject.isDone()) {
                if (cLObject instanceof CLString) {
                    cLObject.setStart((long) (((int) cLObject.start) + 1));
                }
                cLObject.setEnd((long) (length - 1));
                cLObject = cLObject.getContainer();
            }
            if (DEBUG) {
                System.out.println("Root: " + allocate.toJSON());
            }
            return allocate;
        }
        throw new CLParsingException("invalid json content", null);
    }
}
