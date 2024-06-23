package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.tencent.open.SocialConstants;
import com.vivo.push.PushClientConstants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.gl1;

/* compiled from: Taobao */
public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, TypedValues.Custom.S_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, TypedValues.Custom.S_FLOAT, UTConstant.Args.UT_SUCCESS_F, "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = new HashMap();
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = new HashMap();
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
    private static final Set<en0> WRAPPERS_CLASS_NAMES = new HashSet();
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final en0 wrapperFqName;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0015  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Object[] objArr;
        if (!(i == 2 || i == 4)) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (!(i == 2 || i == 4)) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        i2 = 3;
                        break;
                }
                objArr = new Object[i2];
                switch (i) {
                    case 1:
                    case 7:
                        objArr[0] = "name";
                        break;
                    case 2:
                    case 4:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                        break;
                    case 3:
                        objArr[0] = "type";
                        break;
                    case 5:
                    case 8:
                        objArr[0] = SocialConstants.PARAM_APP_DESC;
                        break;
                    case 6:
                        objArr[0] = "primitiveType";
                        break;
                    case 9:
                        objArr[0] = "wrapperClassName";
                        break;
                    default:
                        objArr[0] = PushClientConstants.TAG_CLASS_NAME;
                        break;
                }
                if (i == 2 && i != 4) {
                    switch (i) {
                        case 10:
                            objArr[1] = "getPrimitiveType";
                            break;
                        case 11:
                            objArr[1] = "getJavaKeywordName";
                            break;
                        case 12:
                            objArr[1] = "getDesc";
                            break;
                        case 13:
                            objArr[1] = "getWrapperFqName";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                            break;
                    }
                } else {
                    objArr[1] = gl1.TYPE_OPEN_URL_METHOD_GET;
                }
                switch (i) {
                    case 1:
                    case 3:
                        objArr[2] = gl1.TYPE_OPEN_URL_METHOD_GET;
                        break;
                    case 2:
                    case 4:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    case 5:
                        objArr[2] = "getByDesc";
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        objArr[2] = "<init>";
                        break;
                    default:
                        objArr[2] = "isWrapperClassName";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i == 2 || i == 4)) {
                    switch (i) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i2 = 2;
            objArr = new Object[i2];
            switch (i) {
            }
            if (i == 2) {
            }
            objArr[1] = gl1.TYPE_OPEN_URL_METHOD_GET;
            switch (i) {
            }
            String format2 = String.format(str, objArr);
            switch (i) {
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
        }
        objArr = new Object[i2];
        switch (i) {
        }
        if (i == 2) {
        }
        objArr[1] = gl1.TYPE_OPEN_URL_METHOD_GET;
        switch (i) {
        }
        String format22 = String.format(str, objArr);
        switch (i) {
        }
        throw new IllegalStateException(format22);
    }

    static {
        JvmPrimitiveType[] values = values();
        for (JvmPrimitiveType jvmPrimitiveType : values) {
            WRAPPERS_CLASS_NAMES.add(jvmPrimitiveType.getWrapperFqName());
            TYPE_BY_NAME.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            TYPE_BY_PRIMITIVE_TYPE.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            TYPE_BY_DESC.put(jvmPrimitiveType.getDesc(), jvmPrimitiveType);
        }
    }

    private JvmPrimitiveType(@NotNull PrimitiveType primitiveType2, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        if (primitiveType2 == null) {
            $$$reportNull$$$0(6);
        }
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        if (str2 == null) {
            $$$reportNull$$$0(8);
        }
        if (str3 == null) {
            $$$reportNull$$$0(9);
        }
        this.primitiveType = primitiveType2;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new en0(str3);
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_NAME.get(str);
        if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    @NotNull
    public String getDesc() {
        String str = this.desc;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        return str;
    }

    @NotNull
    public String getJavaKeywordName() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return str;
    }

    @NotNull
    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType2 = this.primitiveType;
        if (primitiveType2 == null) {
            $$$reportNull$$$0(10);
        }
        return primitiveType2;
    }

    @NotNull
    public en0 getWrapperFqName() {
        en0 en0 = this.wrapperFqName;
        if (en0 == null) {
            $$$reportNull$$$0(13);
        }
        return en0;
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull PrimitiveType primitiveType2) {
        if (primitiveType2 == null) {
            $$$reportNull$$$0(3);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get(primitiveType2);
        if (jvmPrimitiveType == null) {
            $$$reportNull$$$0(4);
        }
        return jvmPrimitiveType;
    }
}
