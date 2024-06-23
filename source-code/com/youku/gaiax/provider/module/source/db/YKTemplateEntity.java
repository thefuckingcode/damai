package com.youku.gaiax.provider.module.source.db;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.taobao.accs.common.Constants;
import com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.k21;
import tb.m40;
import tb.tn;

@Entity(primaryKeys = {"template_id", "template_version", "template_biz", "template_platform"}, tableName = "yk_template_v2")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\b\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0001\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u000b\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0007\u0012\u0006\u0010/\u001a\u00020\u0007\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003¢\u0006\u0004\bT\u0010UB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bT\u0010VJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J³\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u0003HÆ\u0001J\t\u00108\u001a\u00020\u000bHÖ\u0001J\u0013\u0010<\u001a\u00020;2\b\u0010:\u001a\u0004\u0018\u000109HÖ\u0003R\u001c\u0010&\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010'\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010(\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010=\u001a\u0004\bC\u0010?R\u001c\u0010)\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010=\u001a\u0004\bD\u0010?R\u001c\u0010*\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010=\u001a\u0004\bE\u0010?R\u001c\u0010+\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010=\u001a\u0004\bF\u0010?R\u001c\u0010,\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010=\u001a\u0004\bG\u0010?R\u001c\u0010-\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010=\u001a\u0004\bH\u0010?R\u001c\u0010.\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010/\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010I\u001a\u0004\bL\u0010KR\u001c\u00100\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010=\u001a\u0004\bM\u0010?R\u001c\u00101\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010=\u001a\u0004\bN\u0010?R\u001c\u00102\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u0010=\u001a\u0004\bO\u0010?R\u001c\u00103\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010=\u001a\u0004\bP\u0010?R\u001c\u00104\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u0010=\u001a\u0004\bQ\u0010?R\u001c\u00105\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b5\u0010=\u001a\u0004\bR\u0010?R\u001c\u00106\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010=\u001a\u0004\bS\u0010?¨\u0006X"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/YKTemplateEntity;", "Landroid/os/Parcelable;", "Lcom/youku/gaiax/impl/register/remote/IGaiaXRemoteTemplateEntity;", "", "getLocalPath", "getTemplateBiz", "getTemplateId", "", "getSupportMinVersion", "getSupportMaxVersion", "getReleaseStatus", "", "getTemplateVersion", "getTemplatePlatform", "Landroid/os/Parcel;", "parcel", Constants.KEY_FLAGS, "Ltb/ur2;", "writeToParcel", "describeContents", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "template_id", "template_version", "template_biz", "template_platform", "template_desc", "template_resource_url", "template_local_url", "template_priority", "template_support_min_version", "template_support_max_version", "template_createtime", "template_modifytime", "template_create_empid", "template_modify_empid", "template_release_status", "template_ext_info", "template_fileType", by0.ARG_COPY, "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTemplate_id", "()Ljava/lang/String;", "I", "getTemplate_version", "()I", "getTemplate_biz", "getTemplate_platform", "getTemplate_desc", "getTemplate_resource_url", "getTemplate_local_url", "getTemplate_priority", "J", "getTemplate_support_min_version", "()J", "getTemplate_support_max_version", "getTemplate_createtime", "getTemplate_modifytime", "getTemplate_create_empid", "getTemplate_modify_empid", "getTemplate_release_status", "getTemplate_ext_info", "getTemplate_fileType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class YKTemplateEntity implements Parcelable, IGaiaXRemoteTemplateEntity {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @ColumnInfo(name = "template_biz")
    @NotNull
    private final String template_biz;
    @ColumnInfo(name = "template_create_empid")
    @NotNull
    private final String template_create_empid;
    @ColumnInfo(name = "template_createtime")
    @NotNull
    private final String template_createtime;
    @ColumnInfo(name = "template_desc")
    @NotNull
    private final String template_desc;
    @ColumnInfo(name = "template_ext_info")
    @NotNull
    private final String template_ext_info;
    @ColumnInfo(name = "template_fileType")
    @NotNull
    private final String template_fileType;
    @ColumnInfo(name = "template_id")
    @NotNull
    private final String template_id;
    @ColumnInfo(name = "template_local_url")
    @NotNull
    private final String template_local_url;
    @ColumnInfo(name = "template_modify_empid")
    @NotNull
    private final String template_modify_empid;
    @ColumnInfo(name = "template_modifytime")
    @NotNull
    private final String template_modifytime;
    @ColumnInfo(name = "template_platform")
    @NotNull
    private final String template_platform;
    @ColumnInfo(name = "template_priority")
    @NotNull
    private final String template_priority;
    @ColumnInfo(name = "template_release_status")
    @NotNull
    private final String template_release_status;
    @ColumnInfo(name = "template_resource_url")
    @NotNull
    private final String template_resource_url;
    @ColumnInfo(name = "template_support_max_version")
    private final long template_support_max_version;
    @ColumnInfo(name = "template_support_min_version")
    private final long template_support_min_version;
    @ColumnInfo(name = "template_version")
    private final int template_version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/provider/module/source/db/YKTemplateEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/youku/gaiax/provider/module/source/db/YKTemplateEntity;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "", "size", "", "newArray", "(I)[Lcom/youku/gaiax/provider/module/source/db/YKTemplateEntity;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class CREATOR implements Parcelable.Creator<YKTemplateEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(m40 m40) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public YKTemplateEntity createFromParcel(@NotNull Parcel parcel) {
            k21.i(parcel, "parcel");
            return new YKTemplateEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public YKTemplateEntity[] newArray(int i) {
            return new YKTemplateEntity[i];
        }
    }

    public YKTemplateEntity(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, long j, long j2, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
        k21.i(str, "template_id");
        k21.i(str2, "template_biz");
        k21.i(str3, "template_platform");
        k21.i(str4, "template_desc");
        k21.i(str5, "template_resource_url");
        k21.i(str6, "template_local_url");
        k21.i(str7, "template_priority");
        k21.i(str8, "template_createtime");
        k21.i(str9, "template_modifytime");
        k21.i(str10, "template_create_empid");
        k21.i(str11, "template_modify_empid");
        k21.i(str12, "template_release_status");
        k21.i(str13, "template_ext_info");
        k21.i(str14, "template_fileType");
        this.template_id = str;
        this.template_version = i;
        this.template_biz = str2;
        this.template_platform = str3;
        this.template_desc = str4;
        this.template_resource_url = str5;
        this.template_local_url = str6;
        this.template_priority = str7;
        this.template_support_min_version = j;
        this.template_support_max_version = j2;
        this.template_createtime = str8;
        this.template_modifytime = str9;
        this.template_create_empid = str10;
        this.template_modify_empid = str11;
        this.template_release_status = str12;
        this.template_ext_info = str13;
        this.template_fileType = str14;
    }

    public static /* synthetic */ YKTemplateEntity copy$default(YKTemplateEntity yKTemplateEntity, String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, long j, long j2, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, Object obj) {
        return yKTemplateEntity.copy((i2 & 1) != 0 ? yKTemplateEntity.template_id : str, (i2 & 2) != 0 ? yKTemplateEntity.template_version : i, (i2 & 4) != 0 ? yKTemplateEntity.template_biz : str2, (i2 & 8) != 0 ? yKTemplateEntity.template_platform : str3, (i2 & 16) != 0 ? yKTemplateEntity.template_desc : str4, (i2 & 32) != 0 ? yKTemplateEntity.template_resource_url : str5, (i2 & 64) != 0 ? yKTemplateEntity.template_local_url : str6, (i2 & 128) != 0 ? yKTemplateEntity.template_priority : str7, (i2 & 256) != 0 ? yKTemplateEntity.template_support_min_version : j, (i2 & 512) != 0 ? yKTemplateEntity.template_support_max_version : j2, (i2 & 1024) != 0 ? yKTemplateEntity.template_createtime : str8, (i2 & 2048) != 0 ? yKTemplateEntity.template_modifytime : str9, (i2 & 4096) != 0 ? yKTemplateEntity.template_create_empid : str10, (i2 & 8192) != 0 ? yKTemplateEntity.template_modify_empid : str11, (i2 & 16384) != 0 ? yKTemplateEntity.template_release_status : str12, (i2 & 32768) != 0 ? yKTemplateEntity.template_ext_info : str13, (i2 & 65536) != 0 ? yKTemplateEntity.template_fileType : str14);
    }

    @NotNull
    public final String component1() {
        return this.template_id;
    }

    public final long component10() {
        return this.template_support_max_version;
    }

    @NotNull
    public final String component11() {
        return this.template_createtime;
    }

    @NotNull
    public final String component12() {
        return this.template_modifytime;
    }

    @NotNull
    public final String component13() {
        return this.template_create_empid;
    }

    @NotNull
    public final String component14() {
        return this.template_modify_empid;
    }

    @NotNull
    public final String component15() {
        return this.template_release_status;
    }

    @NotNull
    public final String component16() {
        return this.template_ext_info;
    }

    @NotNull
    public final String component17() {
        return this.template_fileType;
    }

    public final int component2() {
        return this.template_version;
    }

    @NotNull
    public final String component3() {
        return this.template_biz;
    }

    @NotNull
    public final String component4() {
        return this.template_platform;
    }

    @NotNull
    public final String component5() {
        return this.template_desc;
    }

    @NotNull
    public final String component6() {
        return this.template_resource_url;
    }

    @NotNull
    public final String component7() {
        return this.template_local_url;
    }

    @NotNull
    public final String component8() {
        return this.template_priority;
    }

    public final long component9() {
        return this.template_support_min_version;
    }

    @NotNull
    public final YKTemplateEntity copy(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, long j, long j2, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
        k21.i(str, "template_id");
        k21.i(str2, "template_biz");
        k21.i(str3, "template_platform");
        k21.i(str4, "template_desc");
        k21.i(str5, "template_resource_url");
        k21.i(str6, "template_local_url");
        k21.i(str7, "template_priority");
        k21.i(str8, "template_createtime");
        k21.i(str9, "template_modifytime");
        k21.i(str10, "template_create_empid");
        k21.i(str11, "template_modify_empid");
        k21.i(str12, "template_release_status");
        k21.i(str13, "template_ext_info");
        k21.i(str14, "template_fileType");
        return new YKTemplateEntity(str, i, str2, str3, str4, str5, str6, str7, j, j2, str8, str9, str10, str11, str12, str13, str14);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YKTemplateEntity)) {
            return false;
        }
        YKTemplateEntity yKTemplateEntity = (YKTemplateEntity) obj;
        return k21.d(this.template_id, yKTemplateEntity.template_id) && this.template_version == yKTemplateEntity.template_version && k21.d(this.template_biz, yKTemplateEntity.template_biz) && k21.d(this.template_platform, yKTemplateEntity.template_platform) && k21.d(this.template_desc, yKTemplateEntity.template_desc) && k21.d(this.template_resource_url, yKTemplateEntity.template_resource_url) && k21.d(this.template_local_url, yKTemplateEntity.template_local_url) && k21.d(this.template_priority, yKTemplateEntity.template_priority) && this.template_support_min_version == yKTemplateEntity.template_support_min_version && this.template_support_max_version == yKTemplateEntity.template_support_max_version && k21.d(this.template_createtime, yKTemplateEntity.template_createtime) && k21.d(this.template_modifytime, yKTemplateEntity.template_modifytime) && k21.d(this.template_create_empid, yKTemplateEntity.template_create_empid) && k21.d(this.template_modify_empid, yKTemplateEntity.template_modify_empid) && k21.d(this.template_release_status, yKTemplateEntity.template_release_status) && k21.d(this.template_ext_info, yKTemplateEntity.template_ext_info) && k21.d(this.template_fileType, yKTemplateEntity.template_fileType);
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    @NotNull
    public String getLocalPath() {
        return this.template_local_url;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    @NotNull
    public String getReleaseStatus() {
        return this.template_release_status;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    public long getSupportMaxVersion() {
        return this.template_support_max_version;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    public long getSupportMinVersion() {
        return this.template_support_min_version;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    @NotNull
    public String getTemplateBiz() {
        return this.template_biz;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    @NotNull
    public String getTemplateId() {
        return this.template_id;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    @NotNull
    public String getTemplatePlatform() {
        return this.template_platform;
    }

    @Override // com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity
    public int getTemplateVersion() {
        return this.template_version;
    }

    @NotNull
    public final String getTemplate_biz() {
        return this.template_biz;
    }

    @NotNull
    public final String getTemplate_create_empid() {
        return this.template_create_empid;
    }

    @NotNull
    public final String getTemplate_createtime() {
        return this.template_createtime;
    }

    @NotNull
    public final String getTemplate_desc() {
        return this.template_desc;
    }

    @NotNull
    public final String getTemplate_ext_info() {
        return this.template_ext_info;
    }

    @NotNull
    public final String getTemplate_fileType() {
        return this.template_fileType;
    }

    @NotNull
    public final String getTemplate_id() {
        return this.template_id;
    }

    @NotNull
    public final String getTemplate_local_url() {
        return this.template_local_url;
    }

    @NotNull
    public final String getTemplate_modify_empid() {
        return this.template_modify_empid;
    }

    @NotNull
    public final String getTemplate_modifytime() {
        return this.template_modifytime;
    }

    @NotNull
    public final String getTemplate_platform() {
        return this.template_platform;
    }

    @NotNull
    public final String getTemplate_priority() {
        return this.template_priority;
    }

    @NotNull
    public final String getTemplate_release_status() {
        return this.template_release_status;
    }

    @NotNull
    public final String getTemplate_resource_url() {
        return this.template_resource_url;
    }

    public final long getTemplate_support_max_version() {
        return this.template_support_max_version;
    }

    public final long getTemplate_support_min_version() {
        return this.template_support_min_version;
    }

    public final int getTemplate_version() {
        return this.template_version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.template_id.hashCode() * 31) + this.template_version) * 31) + this.template_biz.hashCode()) * 31) + this.template_platform.hashCode()) * 31) + this.template_desc.hashCode()) * 31) + this.template_resource_url.hashCode()) * 31) + this.template_local_url.hashCode()) * 31) + this.template_priority.hashCode()) * 31) + tn.a(this.template_support_min_version)) * 31) + tn.a(this.template_support_max_version)) * 31) + this.template_createtime.hashCode()) * 31) + this.template_modifytime.hashCode()) * 31) + this.template_create_empid.hashCode()) * 31) + this.template_modify_empid.hashCode()) * 31) + this.template_release_status.hashCode()) * 31) + this.template_ext_info.hashCode()) * 31) + this.template_fileType.hashCode();
    }

    @NotNull
    public String toString() {
        return "YKTemplateEntity(template_id='" + this.template_id + "', template_version=" + this.template_version + ", template_biz='" + this.template_biz + "', template_platform='" + this.template_platform + "', template_local_url='" + this.template_local_url + "')";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        k21.i(parcel, "parcel");
        parcel.writeString(this.template_id);
        parcel.writeInt(this.template_version);
        parcel.writeString(this.template_biz);
        parcel.writeString(this.template_platform);
        parcel.writeString(this.template_desc);
        parcel.writeString(this.template_resource_url);
        parcel.writeString(this.template_local_url);
        parcel.writeString(this.template_priority);
        parcel.writeLong(this.template_support_min_version);
        parcel.writeLong(this.template_support_max_version);
        parcel.writeString(this.template_createtime);
        parcel.writeString(this.template_modifytime);
        parcel.writeString(this.template_create_empid);
        parcel.writeString(this.template_modify_empid);
        parcel.writeString(this.template_release_status);
        parcel.writeString(this.template_ext_info);
        parcel.writeString(this.template_fileType);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public YKTemplateEntity(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22);
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        k21.i(parcel, "parcel");
        String readString = parcel.readString();
        String str14 = readString == null ? "" : readString;
        int readInt = parcel.readInt();
        String readString2 = parcel.readString();
        if (readString2 == null) {
            str = "";
        } else {
            str = readString2;
        }
        String readString3 = parcel.readString();
        if (readString3 == null) {
            str2 = "";
        } else {
            str2 = readString3;
        }
        String readString4 = parcel.readString();
        if (readString4 == null) {
            str3 = "";
        } else {
            str3 = readString4;
        }
        String readString5 = parcel.readString();
        if (readString5 == null) {
            str4 = "";
        } else {
            str4 = readString5;
        }
        String readString6 = parcel.readString();
        if (readString6 == null) {
            str5 = "";
        } else {
            str5 = readString6;
        }
        String readString7 = parcel.readString();
        if (readString7 == null) {
            str6 = "";
        } else {
            str6 = readString7;
        }
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        String readString8 = parcel.readString();
        if (readString8 == null) {
            str7 = "";
        } else {
            str7 = readString8;
        }
        String readString9 = parcel.readString();
        if (readString9 == null) {
            str8 = "";
        } else {
            str8 = readString9;
        }
        String readString10 = parcel.readString();
        if (readString10 == null) {
            str9 = "";
        } else {
            str9 = readString10;
        }
        String readString11 = parcel.readString();
        if (readString11 == null) {
            str10 = "";
        } else {
            str10 = readString11;
        }
        String readString12 = parcel.readString();
        if (readString12 == null) {
            str11 = "";
        } else {
            str11 = readString12;
        }
        String readString13 = parcel.readString();
        if (readString13 == null) {
            str12 = "";
        } else {
            str12 = readString13;
        }
        String readString14 = parcel.readString();
        if (readString14 == null) {
            str13 = "";
        } else {
            str13 = readString14;
        }
    }
}
