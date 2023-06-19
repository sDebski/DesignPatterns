package market.visitor;

import market.model.Offer;

public class HighDecreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(-.15);
    }
}
