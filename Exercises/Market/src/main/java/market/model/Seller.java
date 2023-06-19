package market.model;

import market.observer.InflationObserver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;
import lombok.Setter;
import market.visitor.MarketVisitor;

@Getter
@Setter
public class Seller implements InflationObserver {
    private final String name;
    private final List<Offer> offers;
    private double lastKnownInflation;
    private double money;
    private final Bank bank;

    public Seller(String name) {
        this.name = name;
        this.offers = new CopyOnWriteArrayList<>();
        this.bank = Bank.getInstance();
        this.lastKnownInflation = bank.getInflation();
        this.bank.addFollower(this);
    }

    public void addOffer(Offer offer) {
        offer.setSeller(this);
        offers.add(offer);
    }
    public void makeMoney(double amount) {
        bank.update(amount);
        setMoney(money + amount);
    }

    @Override
    public void update(double inflation) {
        double inflationDiff = inflation - lastKnownInflation;
        if (Math.abs(inflationDiff) > 0.02) {
            lastKnownInflation = inflation;
            offers.forEach(o -> o.setPrice(o.getPrice() + o.getPrice() * inflationDiff));
        }
    }

    public void acceptMarketChanges(MarketVisitor visitor) {
        for (Offer offer : offers) {
            offer.accept(visitor);
        }
    }

}
