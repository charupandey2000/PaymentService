package dev.charu.paymentservice.Controller;

import com.stripe.exception.StripeException;
import dev.charu.paymentservice.Dto.InitiatePaymentRequestDto;
import dev.charu.paymentservice.Services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto request) throws StripeException {

        return paymentService.generatePaymentLink(request.getOrderId());
    }
}
