package ASOserver.springapp.service;

import ASOserver.model.PaymentMethod;

import java.util.List;

public class PaymentMethodService {

    PaymentMethod paymentMethod = new PaymentMethod();

    public List<String> getPaymentMethod() {
        List <String> paymentMethodList = paymentMethod.getPaymentMethod();
        return paymentMethodList;
    }
}
