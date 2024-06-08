package dev.charu.paymentservice.PaymentGateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String generatePaymentLink(long orderId, String email, String phoneNumber, Long amount) throws StripeException;

}
