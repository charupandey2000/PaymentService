package dev.charu.paymentservice.Services;

import com.stripe.exception.StripeException;
import dev.charu.paymentservice.PaymentGateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    PaymentGateway paymentGateway;
    public PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }

    public String generatePaymentLink(Long orderId) throws StripeException {
        String email="charupandey2000";
        String phoneNumber="9818806924";
        return paymentGateway.generatePaymentLink(orderId,email,phoneNumber,1000L);
    }


}
