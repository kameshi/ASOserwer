package ASOserver.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethod {
    public enum PaymentMethodEnum {

        CARD("karta"),
        CASH("gotówka"),
        TRANSFER("przelew");

        private String paymentMethod;

        private PaymentMethodEnum(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }
    }

    public List<String> getPaymentMethod() {
        List<String> paymentMethodEnumList = new ArrayList<>();
        PaymentMethodEnum[] paymentMethodEnums = PaymentMethodEnum.values();
        for (PaymentMethodEnum paymentMethodEnum : paymentMethodEnums) {
            paymentMethodEnumList.add(paymentMethodEnum.getPaymentMethod());
        }
        return paymentMethodEnumList;
    }
}
