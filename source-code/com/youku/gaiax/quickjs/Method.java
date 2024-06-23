package com.youku.gaiax.quickjs;

import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.gaiax.quickjs.Types;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import tb.jl1;
import tb.v00;

/* compiled from: Taobao */
public final class Method {
    public final String name;
    public final Type[] parameterTypes;
    public final Type returnType;

    public Method(Type type, String str, Type[] typeArr) {
        this.returnType = canonicalize(type);
        this.name = str;
        this.parameterTypes = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            this.parameterTypes[i] = canonicalize(typeArr[i]);
        }
    }

    private static Type canonicalize(Type type) {
        return Types.removeSubtypeWildcard(Types.canonicalize(type));
    }

    public static Method create(Type type, java.lang.reflect.Method method) {
        Class<?> rawType = Types.getRawType(type);
        Type resolve = Types.resolve(type, rawType, method.getGenericReturnType());
        if (resolve instanceof TypeVariable) {
            return null;
        }
        String name2 = method.getName();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        int length = genericParameterTypes.length;
        Type[] typeArr = new Type[length];
        for (int i = 0; i < length; i++) {
            typeArr[i] = Types.resolve(type, rawType, genericParameterTypes[i]);
            if (typeArr[i] instanceof TypeVariable) {
                return null;
            }
        }
        return new Method(resolve, name2, typeArr);
    }

    private static String getTypeSignature(Type type) {
        if (type instanceof Types.GenericArrayTypeImpl) {
            return jl1.ARRAY_START_STR + getTypeSignature(((Types.GenericArrayTypeImpl) type).getGenericComponentType());
        }
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (type == Void.TYPE) {
                return "V";
            }
            if (type == Boolean.TYPE) {
                return "Z";
            }
            if (type == Byte.TYPE) {
                return "B";
            }
            if (type == Character.TYPE) {
                return "C";
            }
            if (type == Short.TYPE) {
                return ExifInterface.LATITUDE_SOUTH;
            }
            if (type == Integer.TYPE) {
                return "I";
            }
            if (type == Long.TYPE) {
                return "J";
            }
            if (type == Float.TYPE) {
                return UTConstant.Args.UT_SUCCESS_F;
            }
            if (type == Double.TYPE) {
                return "D";
            }
        }
        String name2 = Types.getRawType(type).getName();
        StringBuilder sb = new StringBuilder(name2.length() + 2);
        sb.append("L");
        for (int i = 0; i < name2.length(); i++) {
            char charAt = name2.charAt(i);
            if (charAt == '.') {
                charAt = v00.DIR;
            }
            sb.append(charAt);
        }
        sb.append(";");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Method)) {
            return false;
        }
        Method method = (Method) obj;
        if (!this.returnType.equals(method.returnType) || !this.name.equals(method.name) || !Arrays.equals(this.parameterTypes, method.parameterTypes)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public String getSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.BRACKET_START_STR);
        for (Type type : this.parameterTypes) {
            sb.append(getTypeSignature(type));
        }
        sb.append(jl1.BRACKET_END_STR);
        sb.append(getTypeSignature(this.returnType));
        return sb.toString();
    }

    public int hashCode() {
        return ((((this.returnType.hashCode() + 31) * 31) + this.name.hashCode()) * 31) + Arrays.hashCode(this.parameterTypes);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.returnType);
        sb.append(" ");
        sb.append(this.name);
        sb.append(jl1.BRACKET_START_STR);
        for (int i = 0; i < this.parameterTypes.length; i++) {
            if (i != 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append(this.parameterTypes[i]);
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }
}
