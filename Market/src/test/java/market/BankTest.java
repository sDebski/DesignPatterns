package market;

import market.model.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {
    private double PRICE = 100.0;
    private double PRODUCTION_COST = 10.0;

    @Test
    public void updateInflationAfterTransaction() {
        Bank bank = Bank.getInstance();
        Client client = new Client("Client1");
        Seller seller = new Seller("Seller1");
        Offer offer1 = new Offer(new Product("Offer1"), PRICE, PRODUCTION_COST);
        Offer offer2 = new Offer(new Product("Offer2"), PRICE * 10, PRODUCTION_COST);
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        double inflation = bank.getInflation();

        offer1.buy(client);
        offer2.buy(client);

        assertThat(bank.getInflation()).isGreaterThan(inflation);

    }
}
