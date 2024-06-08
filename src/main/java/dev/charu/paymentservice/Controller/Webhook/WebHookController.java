package dev.charu.paymentservice.Controller.Webhook;

import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripeWebhook")
public class WebHookController {
    @PostMapping
    public void HandleWebHookRequest( @RequestBody String payload,@RequestHeader("Stripe-Signature") String sigHeader) throws SignatureVerificationException {
        Event event;
        String sec="whsec_fOxRlOAYF4dJKdstRJ8aZfRnLZHieDiL";
        event=Webhook.constructEvent(payload,sigHeader,sec);
        return;
    }

}
