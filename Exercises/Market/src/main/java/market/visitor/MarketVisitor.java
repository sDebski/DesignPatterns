package market.visitor;

import market.model.Offer;

public interface MarketVisitor {
    void visit(Offer offer);
}
