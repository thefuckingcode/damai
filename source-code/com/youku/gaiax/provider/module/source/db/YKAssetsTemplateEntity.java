package com.youku.gaiax.provider.module.source.db;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.taobao.accs.common.Constants;
import com.youku.gaiax.impl.register.assetsbinary.IGaiaXRemoteAssetsBinaryTemplateEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.k21;
import tb.m40;
import tb.tn;

@Entity(primaryKeys = {"template_id", "template_biz"}, tableName = "yk_assets_template_v1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B'\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b'\u0010)J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\t\u0010\u0010\u001a\u00020\nHÆ\u0003J\t\u0010\u0011\u001a\u00020\nHÆ\u0003J\t\u0010\u0012\u001a\u00020\nHÆ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u000eHÆ\u0001J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003R\u001c\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0015\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b\"\u0010!R\u001c\u0010\u0016\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b#\u0010!R\u001c\u0010\u0017\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/YKAssetsTemplateEntity;", "Landroid/os/Parcelable;", "Lcom/youku/gaiax/impl/register/assetsbinary/IGaiaXRemoteAssetsBinaryTemplateEntity;", "Landroid/os/Parcel;", "parcel", "", Constants.KEY_FLAGS, "Ltb/ur2;", "writeToParcel", "describeContents", "", "getTemplateId", "getTemplateBiz", "getTemplateLocalPath", "", "getTemplateAppVersion", "component1", "component2", "component3", "component4", "template_id", "template_biz", "template_local_url", "template_app_version", by0.ARG_COPY, "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTemplate_id", "()Ljava/lang/String;", "getTemplate_biz", "getTemplate_local_url", "J", "getTemplate_app_version", "()J", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class YKAssetsTemplateEntity implements Parcelable, IGaiaXRemoteAssetsBinaryTemplateEntity {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @ColumnInfo(name = "template_app_version")
    private final long template_app_version;
    @ColumnInfo(name = "template_biz")
    @NotNull
    private final String template_biz;
    @ColumnInfo(name = "template_id")
    @NotNull
    private final String template_id;
    @ColumnInfo(name = "template_local_url")
    @NotNull
    private final String template_local_url;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/YKAssetsTemplateEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/youku/gaiax/provider/module/source/db/YKAssetsTemplateEntity;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "", "size", "", "newArray", "(I)[Lcom/youku/gaiax/provider/module/source/db/YKAssetsTemplateEntity;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class CREATOR implements Parcelable.Creator<YKAssetsTemplateEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(m40 m40) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public YKAssetsTemplateEntity createFromParcel(@NotNull Parcel parcel) {
            k21.i(parcel, "parcel");
            return new YKAssetsTemplateEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public YKAssetsTemplateEntity[] newArray(int i) {
            return new YKAssetsTemplateEntity[i];
        }
    }

    public YKAssetsTemplateEntity(@NotNull String str, @NotNull String str2, @NotNull String str3, long j) {
        k21.i(str, "template_id");
        k21.i(str2, "template_biz");
        k21.i(str3, "template_local_url");
        this.template_id = str;
        this.template_biz = str2;
        this.template_local_url = str3;
        this.template_app_version = j;
    }

    public static /* synthetic */ YKAssetsTemplateEntity copy$default(YKAssetsTemplateEntity yKAssetsTemplateEntity, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yKAssetsTemplateEntity.template_id;
        }
        if ((i & 2) != 0) {
            str2 = yKAssetsTemplateEntity.template_biz;
        }
        if ((i & 4) != 0) {
            str3 = yKAssetsTemplateEntity.template_local_url;
        }
        if ((i & 8) != 0) {
            j = yKAssetsTemplateEntity.template_app_version;
        }
        return yKAssetsTemplateEntity.copy(str, str2, str3, j);
    }

    @NotNull
    public final String component1() {
        return this.template_id;
    }

    @NotNull
    public final String component2() {
        return this.template_biz;
    }

    @NotNull
    public final String component3() {
        return this.template_local_url;
    }

    public final long component4() {
        return this.template_app_version;
    }

    @NotNull
    public final YKAssetsTemplateEntity copy(@NotNull String str, @NotNull String str2, @NotNull String str3, long j) {
        k21.i(str, "template_id");
        k21.i(str2, "template_biz");
        k21.i(str3, "template_local_url");
        return new YKAssetsTemplateEntity(str, str2, str3, j);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YKAssetsTemplateEntity)) {
            return false;
        }
        YKAssetsTemplateEntity yKAssetsTemplateEntity = (YKAssetsTemplateEntity) obj;
        return k21.d(this.template_id, yKAssetsTemplateEntity.template_id) && k21.d(this.template_biz, yKAssetsTemplateEntity.template_biz) && k21.d(this.template_local_url, yKAssetsTemplateEntity.template_local_url) && this.template_app_version == yKAssetsTemplateEntity.template_app_version;
    }

    @Override // com.youku.gaiax.impl.register.assetsbinary.IGaiaXRemoteAssetsBinaryTemplateEntity
    public long getTemplateAppVersion() {
        return this.template_app_version;
    }

    @Override // com.youku.gaiax.impl.register.assetsbinary.IGaiaXRemoteAssetsBinaryTemplateEntity
    @NotNull
    public String getTemplateBiz() {
        return this.template_biz;
    }

    @Override // com.youku.gaiax.impl.register.assetsbinary.IGaiaXRemoteAssetsBinaryTemplateEntity
    @NotNull
    public String getTemplateId() {
        return this.template_id;
    }

    @Override // com.youku.gaiax.impl.register.assetsbinary.IGaiaXRemoteAssetsBinaryTemplateEntity
    @NotNull
    public String getTemplateLocalPath() {
        return this.template_local_url;
    }

    public final long getTemplate_app_version() {
        return this.template_app_version;
    }

    @NotNull
    public final String getTemplate_biz() {
        return this.template_biz;
    }

    @NotNull
    public final String getTemplate_id() {
        return this.template_id;
    }

    @NotNull
    public final String getTemplate_local_url() {
        return this.template_local_url;
    }

    public int hashCode() {
        return (((((this.template_id.hashCode() * 31) + this.template_biz.hashCode()) * 31) + this.template_local_url.hashCode()) * 31) + tn.a(this.template_app_version);
    }

    @NotNull
    public String toString() {
        return "YKAssetsTemplateEntity(template_id=" + this.template_id + ", template_biz=" + this.template_biz + ", template_local_url=" + this.template_local_url + ", template_app_version=" + this.template_app_version + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        k21.i(parcel, "parcel");
        parcel.writeString(this.template_id);
        parcel.writeString(this.template_biz);
        parcel.writeString(this.template_local_url);
        parcel.writeLong(this.template_app_version);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public YKAssetsTemplateEntity(@NotNull Parcel parcel) {
        this(r2, r3, r4, parcel.readLong());
        k21.i(parcel, "parcel");
        String readString = parcel.readString();
        k21.f(readString);
        k21.h(readString, "parcel.readString()!!");
        String readString2 = parcel.readString();
        k21.f(readString2);
        k21.h(readString2, "parcel.readString()!!");
        String readString3 = parcel.readString();
        k21.f(readString3);
        k21.h(readString3, "parcel.readString()!!");
    }
}
