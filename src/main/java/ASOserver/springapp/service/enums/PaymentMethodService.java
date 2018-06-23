package ASOserver.springapp.service.enums;

import ASOserver.model.enums.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    PaymentMethod paymentMethod = new PaymentMethod();

    public List<String> getPaymentMethods() {
        List <String> paymentMethodList = paymentMethod.getPaymentMethods();
        return paymentMethodList;
    }
}
