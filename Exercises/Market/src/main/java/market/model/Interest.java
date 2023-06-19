package market.model;

import lombok.Getter;
import lombok.Setter;
import market.observer.OfferObserver;

@Setter
@Getter
public class Interest implements OfferObserver {
    private Offer offer;
    private Client client;
    private double interest;
    private double lastPrice;

    public Interest(Offer offer, Client client) {
        this.offer = offer;
        this.client = client;
        interest = Math.max(Math.random(), 0.5);
        lastPrice = offer.getPrice();
    }

    @Override
    public void update(Offer offer) {
        if (offer.isBought()) {
            client.unfollowOffer(offer);
        }
        double increase = (offer.getPrice() - lastPrice) / lastPrice;
        lastPrice = offer.getPrice();
        if(Math.abs(increase) > 0.02) {
            increaseInterest(increase);
            if (interest >= client.getRule()) {
                client.canBuyOffer(offer);
            }
        }
    }

    public void updateInflation(double inflationDiff) {
        if (Math.abs(inflationDiff) > 0.02) {
            increaseInterest(inflationDiff * interest);
        }
    }

    public void increaseInterest(double increase) {
        setInterest(interest - increase);
    }

    public void setInterest(double interest) {
        this.interest = Math.max(0, interest);
    }
}
