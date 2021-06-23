package market.visitor;

import market.model.Offer;

public class SmallIncreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(0.04);
    }
}
