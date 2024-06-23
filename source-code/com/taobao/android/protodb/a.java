package com.taobao.android.protodb;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import tb.u51;
import tb.y51;

/* compiled from: Taobao */
public class a extends LSDB {
    private final SharedPreferences a;

    a(Context context) {
        super(0, "");
        this.a = context.getSharedPreferences("lsdb", 0);
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean close() {
        return false;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean contains(u51 u51) {
        return this.a.contains(u51.a());
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean delete(u51 u51) {
        this.a.edit().remove(u51.a()).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean forceCompact() {
        return false;
    }

    @Override // com.taobao.android.protodb.LSDB
    public byte[] getBinary(u51 u51) {
        return null;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean getBool(u51 u51) {
        return this.a.getBoolean(u51.a(), false);
    }

    @Override // com.taobao.android.protodb.LSDB
    public int getDataSize(@NonNull u51 u51) {
        return 0;
    }

    @Override // com.taobao.android.protodb.LSDB
    public double getDouble(u51 u51) {
        return (double) getFloat(u51);
    }

    @Override // com.taobao.android.protodb.LSDB
    public float getFloat(u51 u51) {
        return this.a.getFloat(u51.a(), 0.0f);
    }

    @Override // com.taobao.android.protodb.LSDB
    public int getInt(u51 u51) {
        return this.a.getInt(u51.a(), 0);
    }

    @Override // com.taobao.android.protodb.LSDB
    public long getLong(u51 u51) {
        return this.a.getLong(u51.a(), 0);
    }

    @Override // com.taobao.android.protodb.LSDB
    public String getString(u51 u51) {
        return this.a.getString(u51.a(), "");
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertBinary(u51 u51, byte[] bArr) {
        return false;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertBool(u51 u51, boolean z) {
        this.a.edit().putBoolean(u51.a(), z).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertDouble(u51 u51, double d) {
        this.a.edit().putFloat(u51.a(), (float) d).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertFloat(u51 u51, float f) {
        this.a.edit().putFloat(u51.a(), f).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertInt(u51 u51, int i) {
        this.a.edit().putInt(u51.a(), i).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertLong(u51 u51, long j) {
        this.a.edit().putLong(u51.a(), j).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public boolean insertString(u51 u51, String str) {
        this.a.edit().putString(u51.a(), str).apply();
        return true;
    }

    @Override // com.taobao.android.protodb.LSDB
    public Iterator<u51> keyIterator() {
        return new y51((String[]) this.a.getAll().keySet().toArray(new String[0]));
    }

    @Override // com.taobao.android.protodb.LSDB
    public Iterator<u51> keyIterator(u51 u51, u51 u512) {
        return null;
    }
}
