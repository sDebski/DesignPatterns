package market.visitor;

import market.model.Offer;

public class SmallDecreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(-.04);
    }
}
