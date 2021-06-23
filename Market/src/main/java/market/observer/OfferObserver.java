package market.observer;

import market.model.Offer;

public interface OfferObserver {
    void update(Offer offer);
}
