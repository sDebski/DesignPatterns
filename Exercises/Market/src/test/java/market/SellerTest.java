package market;

import market.model.Bank;
import market.model.Offer;
import market.model.Product;
import market.model.Seller;
import market.visitor.HighIncreaseVisitor;
import market.visitor.MarketVisitor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SellerTest {

    private double PRICE = 100.0;
    private double PRODUCTION_COST = 10.0;
    public  double HIGH_INCREASE_MUL = 0.15;
    private Seller seller;
    private Bank bank;

    @BeforeEach
    public void setUp() {
        seller = new Seller("Seller1");
        bank = Bank.getInstance();
    }

    @Test
    public void listOffer() {
        Offer offer = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);

        seller.addOffer(offer);

        assertThat(seller.getOffers())
                .isNotNull()
                .contains(offer)
                .hasSize(1);
    }

    @Test
    public void updateAfterInflation() {
        Offer offer1 = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        Offer offer2 = new Offer(new Product("Product2"), PRICE, PRODUCTION_COST);
        seller.addOffer(offer1);
        seller.addOffer(offer2);

        bank.setInflation(bank.getInflation() + 0.5);

        List<Double> prices = seller.getOffers().stream().map(Offer::getPrice).collect(Collectors.toList());
        List<Double> list = new ArrayList<>();
        list.add(PRICE + PRICE * 0.5);
        list.add(PRICE + PRICE * 0.5);
        assertThat(prices).isEqualTo(list);
    }

    @Test
    public void acceptVisitor() {
        Offer offer1 = new Offer(new Product("Product1"), PRICE, PRODUCTION_COST);
        Offer offer2 = new Offer(new Product("Product2"), PRICE, PRODUCTION_COST);
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        MarketVisitor visitor = new HighIncreaseVisitor();

        seller.acceptMarketChanges(visitor);


        List<Double> prices = seller.getOffers().stream().map(Offer::getPrice).collect(Collectors.toList());

        List<Double> list = new ArrayList<>();
        list.add(PRICE + PRICE * HIGH_INCREASE_MUL);
        list.add(PRICE + PRICE * HIGH_INCREASE_MUL);
        assertThat(prices).isEqualTo(list);
    }
}
