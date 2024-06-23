package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* compiled from: Taobao */
public class TickletContractResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private List<IdInfosEntity> result;

    /* compiled from: Taobao */
    public static class IdInfosEntity implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        private long contactsId;
        private String createSource;
        private Date createTime;
        private String identityHash;
        private String identityNo;
        private int identityType;
        private String identityTypeName;
        private boolean isSelected;
        private int isUserVerified;
        private String maskedIdentityNo;
        private String maskedName;
        private Date modifyTime;
        private String name;
        private long userCode;
        private int verifyStatus;

        public long getContactsId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-675357386")) {
                return this.contactsId;
            }
            return ((Long) ipChange.ipc$dispatch("-675357386", new Object[]{this})).longValue();
        }

        public String getCreateSource() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1954410311")) {
                return this.createSource;
            }
            return (String) ipChange.ipc$dispatch("1954410311", new Object[]{this});
        }

        public Date getCreateTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1856906256")) {
                return this.createTime;
            }
            return (Date) ipChange.ipc$dispatch("1856906256", new Object[]{this});
        }

        public String getIdentityHash() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "984830332")) {
                return this.identityHash;
            }
            return (String) ipChange.ipc$dispatch("984830332", new Object[]{this});
        }

        public String getIdentityNo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1443255151")) {
                return this.identityNo;
            }
            return (String) ipChange.ipc$dispatch("1443255151", new Object[]{this});
        }

        public int getIdentityType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1561907691")) {
                return this.identityType;
            }
            return ((Integer) ipChange.ipc$dispatch("1561907691", new Object[]{this})).intValue();
        }

        public String getIdentityTypeName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-435091885")) {
                return this.identityTypeName;
            }
            return (String) ipChange.ipc$dispatch("-435091885", new Object[]{this});
        }

        public int getIsUserVerified() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "463155238")) {
                return this.isUserVerified;
            }
            return ((Integer) ipChange.ipc$dispatch("463155238", new Object[]{this})).intValue();
        }

        public String getMaskedIdentityNo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1392456934")) {
                return this.maskedIdentityNo;
            }
            return (String) ipChange.ipc$dispatch("-1392456934", new Object[]{this});
        }

        public String getMaskedName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "451778694")) {
                return this.maskedName;
            }
            return (String) ipChange.ipc$dispatch("451778694", new Object[]{this});
        }

        public Date getModifyTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1314421070")) {
                return this.modifyTime;
            }
            return (Date) ipChange.ipc$dispatch("1314421070", new Object[]{this});
        }

        public String getName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1216265061")) {
                return this.name;
            }
            return (String) ipChange.ipc$dispatch("-1216265061", new Object[]{this});
        }

        public long getUserCode() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1169507372")) {
                return this.userCode;
            }
            return ((Long) ipChange.ipc$dispatch("1169507372", new Object[]{this})).longValue();
        }

        public int getVerifyStatus() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1755107416")) {
                return this.verifyStatus;
            }
            return ((Integer) ipChange.ipc$dispatch("1755107416", new Object[]{this})).intValue();
        }

        public boolean isSelected() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1844577277")) {
                return this.isSelected;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1844577277", new Object[]{this})).booleanValue();
        }

        public void setContactsId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-401364530")) {
                ipChange.ipc$dispatch("-401364530", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.contactsId = j;
        }

        public void setCreateSource(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "855058551")) {
                ipChange.ipc$dispatch("855058551", new Object[]{this, str});
                return;
            }
            this.createSource = str;
        }

        public void setCreateTime(Date date) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-44474724")) {
                ipChange.ipc$dispatch("-44474724", new Object[]{this, date});
                return;
            }
            this.createTime = date;
        }

        public void setIdentityHash(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "862850274")) {
                ipChange.ipc$dispatch("862850274", new Object[]{this, str});
                return;
            }
            this.identityHash = str;
        }

        public void setIdentityNo(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-318646705")) {
                ipChange.ipc$dispatch("-318646705", new Object[]{this, str});
                return;
            }
            this.identityNo = str;
        }

        public void setIdentityType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-369199849")) {
                ipChange.ipc$dispatch("-369199849", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.identityType = i;
        }

        public void setIdentityTypeName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1774741269")) {
                ipChange.ipc$dispatch("-1774741269", new Object[]{this, str});
                return;
            }
            this.identityTypeName = str;
        }

        public void setIsUserVerified(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-285816004")) {
                ipChange.ipc$dispatch("-285816004", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.isUserVerified = i;
        }

        public void setMaskedIdentityNo(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1388286716")) {
                ipChange.ipc$dispatch("-1388286716", new Object[]{this, str});
                return;
            }
            this.maskedIdentityNo = str;
        }

        public void setMaskedName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-989645800")) {
                ipChange.ipc$dispatch("-989645800", new Object[]{this, str});
                return;
            }
            this.maskedName = str;
        }

        public void setModifyTime(Date date) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "318353694")) {
                ipChange.ipc$dispatch("318353694", new Object[]{this, date});
                return;
            }
            this.modifyTime = date;
        }

        public void setName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "657732003")) {
                ipChange.ipc$dispatch("657732003", new Object[]{this, str});
                return;
            }
            this.name = str;
        }

        public void setSelected(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1607739029")) {
                ipChange.ipc$dispatch("-1607739029", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.isSelected = z;
        }

        public void setUserCode(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1489193832")) {
                ipChange.ipc$dispatch("-1489193832", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.userCode = j;
        }

        public void setVerifyStatus(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1325024330")) {
                ipChange.ipc$dispatch("1325024330", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.verifyStatus = i;
        }
    }

    public List<IdInfosEntity> getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "67533355")) {
            return this.result;
        }
        return (List) ipChange.ipc$dispatch("67533355", new Object[]{this});
    }

    public void setResult(List<IdInfosEntity> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588643327")) {
            ipChange.ipc$dispatch("-1588643327", new Object[]{this, list});
            return;
        }
        this.result = list;
    }
}
