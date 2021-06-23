package market.visitor;

import market.model.Offer;

public class HighIncreaseVisitor implements MarketVisitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(.15);
    }
}
