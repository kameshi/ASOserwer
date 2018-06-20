package ASOserver.springapp.service;

import ASOserver.model.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {

    PaymentMethod paymentMethod = new PaymentMethod();

    public List<String> getPaymentMethod() {
        List <String> paymentMethodList = paymentMethod.getPaymentMethod();
        return paymentMethodList;
    }
}
