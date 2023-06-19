package market;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import market.model.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {
    private double PRICE = 100.0;
    private double PRODUCTION_COST = 10.0;
    private double INTEREST = 0.5;
    Client client;
    Bank bank;
    @Mock
    Seller seller;

    @BeforeEach
    public void setUp() {
        client = new Client("Client1");
        bank = Bank.getInstance();
    }

    @Test
    public void followOffer() {
        Offer offer = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        offer.setSeller(seller);
        client.followOffer(offer);
        assertThat(client.getInterests())
                .isNotNull()
                .hasSize(1);
    }

    @Test
    public void updateAfterInflation() {
        Offer offer1 = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        offer1.setSeller(seller);
        Offer offer2 = new Offer(new Product("Product2"), PRICE, PRODUCTION_COST);
        offer2.setSeller(seller);
        client.followOffer(offer1);
        client.followOffer(offer2);
        client.getInterests().forEach(e -> e.setInterest(INTEREST));

        bank.setInflation(bank.getInflation() + 0.3);

        List<Double> prices = client.getInterests()
                .stream()
                .map(Interest::getInterest)
                .collect(Collectors.toList());

        assertThat(prices)
                .doesNotContain(INTEREST, INTEREST)
                .allMatch(e -> e < INTEREST);
    }
}
