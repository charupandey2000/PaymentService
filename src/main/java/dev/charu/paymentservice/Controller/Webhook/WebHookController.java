package dev.charu.paymentservice.Controller.Webhook;

import com.stripe.net.Webhook;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.events.Event;

@RestController
@RequestMapping("/stripeWebhook")
public class WebHookController {
    @PostMapping
    public void HandleWebHookRequest(@RequestBody Webhook webhooks){
         return;
    }

}
