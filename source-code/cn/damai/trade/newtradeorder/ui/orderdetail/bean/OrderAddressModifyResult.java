package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

/* compiled from: Taobao */
public class OrderAddressModifyResult {
    public static final int SUPPLEMENT_TYPE_NEED_PAY = 1;
    public static final int SUPPLEMENT_TYPE_NEED_REFOUND = 2;
    public static final int SUPPLEMENT_TYPE_NO_CHARGE = 0;
    public long buyerId;
    public AddressModifyExt ext;
    public DeliveryInfo newDeliveryInfo;
    public long orderId;
    public DeliveryInfo originalDeliveryInfo;
    public boolean sameAddress;
    public String supplementFee;
    public int supplementType;

    /* compiled from: Taobao */
    public static class AddressModifyExt {
        public String[] tips;
    }

    /* compiled from: Taobao */
    public static class DeliveryInfo {
        public AddressInfo address;
        public long addressId;
        public String consignee;
        public String deliveryFee;
        public long orderId;
        public String phoneNumber;

        /* compiled from: Taobao */
        public static class AddressInfo {
            public String address;
            public long cityId;
            public String cityName;
            public long districtId;
            public String districtName;
            public String fullAddress;
            public long provinceId;
            public String provinceName;
            public long streetId;
            public String streetName;
        }
    }
}
