package ASOserver.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

        @JsonCreator
        public static PaymentMethodEnum fromValue(String value) {
            return getPaymentMethod(value);
        }

        @JsonValue
        public String toJson() {
            return getPaymentMethod();
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }
    }

    public List<String> getPaymentMethods() {
        List<String> paymentMethodEnumList = new ArrayList<>();
        PaymentMethodEnum[] paymentMethodEnums = PaymentMethodEnum.values();
        for (PaymentMethodEnum paymentMethodEnum : paymentMethodEnums) {
            paymentMethodEnumList.add(paymentMethodEnum.getPaymentMethod());
        }
        return paymentMethodEnumList;
    }
}
