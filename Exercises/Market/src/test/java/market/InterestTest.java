package market;

import market.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InterestTest {
    private double PRICE = 100.0;
    private double PRODUCTION_COST = 10.0;
    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client("Client1");
    }

    @Test
    public void updateAfterPriceChange() {
        Offer offer = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        Interest interest = new Interest(offer, client);
        interest.setInterest(0.5);

        offer.addFollower(interest);

        double currentInterest = interest.getInterest();
        offer.increasePriceByPercent(0.1);
        assertThat(interest.getInterest())
                .isLessThan(currentInterest);
    }

    @Test
    public void buyIfInterestIncrease() {
        Product p1 = new Product("Product1");
        Seller seller = new Seller("Seller1");
        Offer offer = new Offer(p1, PRICE, PRODUCTION_COST);
        seller.addOffer(offer);
        Interest interest = new Interest(offer, client);
        offer.addFollower(interest);
        interest.setInterest(0.75);

        offer.increasePriceByPercent(-0.1);

        assertThat(client.getBoughtProducts())
                .hasSize(1)
                .contains(p1);
    }
}
