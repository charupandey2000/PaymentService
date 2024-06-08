package dev.charu.paymentservice.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway{
    @Value("${stripe.key.secret}")
    private String stripesceretkey;
    @Override
    public String generatePaymentLink(long orderId, String email, String phoneNumber, Long amount) throws StripeException {
        Stripe.apiKey ="sk_test_51PP8jcHZcUCGdHtaMymgI56y5fLPI3nNXWvgX3AtUYMpRIECt8qbgEF18kytNQK56UWeS6ZO7ZMVpChv3Tg8fslM00QtLM9sSF";


        ProductCreateParams product= ProductCreateParams.builder().
        setName("genric").build();

        Product product1=Product.create(product);

        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("usd")
                        .setUnitAmount(amount)
                        .setProduct(
                                product1.getId()
                        )
                        .build();
        Price price = Price.create(params);
        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);
        return paymentLink.getUrl();
    }
}
