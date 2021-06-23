package market.model;

import market.observer.InflationObserver;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


@Getter
@Setter
public class Client implements InflationObserver {
    private String name;
    private List<Interest> interests;
    private Bank bank;
    private double rule;
    private double lastKnownInflation;
    private double money;
    private List<Product> boughtProducts;

    public Client(String name, double rule) {
        this.name = name;
        this.interests = new CopyOnWriteArrayList<>();
        this.rule = rule;
        this.bank = Bank.getInstance();
        this.lastKnownInflation = bank.getInflation();
        this.boughtProducts = new ArrayList<>();
        this.money = 5000.0;
        this.bank.addFollower(this);
    }

    public Client(String name) {
        this(name, 0.5);
    }

    public void addProductToBoughtProducts(Product product) {
        boughtProducts.add(product);
    }

    public void followOffer(Offer offer) {
        Interest interest = new Interest(offer, this);
        interests.add(interest);
        offer.addFollower(interest);
    }

    public void unfollowOffer(Offer offer) {
        interests.removeIf(o -> offer.equals(o.getOffer()));
    }

    public void spendMoney(double amount) {
        money -= amount;
    }

    @Override
    public void update(double inflation) {
        double inflationDiff = inflation - lastKnownInflation;
        lastKnownInflation = inflation;
        interests.forEach(i -> i.updateInflation(inflationDiff));
    }

    public void canBuyOffer(Offer offer) {
        if (offer.getPrice() <= money) {
            offer.buy(this);
        }
    }


}
