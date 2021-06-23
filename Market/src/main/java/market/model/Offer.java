package market.model;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;
import lombok.Setter;
import market.observer.OfferObserver;
import market.visitor.MarketVisitor;

@Setter
@Getter
public class Offer {
    private final Product product;
    private Seller seller;
    private double price;
    private final double productionCost;
    private List<OfferObserver> followers;
    boolean bought;

    public Offer(Product product, double price, double productionCost) {
        this.product = product;
        this.price = price;
        this.productionCost = productionCost;
        this.followers = new CopyOnWriteArrayList<>();
    }

    public void accept(MarketVisitor visitor) {
        visitor.visit(this);
    }

    public void buy(Client client) {
        client.addProductToBoughtProducts(this.product);
        client.spendMoney(price);
        bought = true;
        for ( OfferObserver follower : followers) {
            follower.update(this);
            followers.remove(follower);
        }
        followers = null;
        seller.makeMoney(price - productionCost);
        seller.getOffers().remove(this);
    }

   public void addFollower(OfferObserver observer) {
        followers.add(observer);
    }

    public void removeObserver(OfferObserver observer) {
        followers.remove(observer);
    }

    public  void increasePriceByPercent(double val) {
        this.setPrice(price + price * val);
        for (OfferObserver follower : followers) {
            follower.update(this);
        }
    }

    public void setPrice(double price) {
        this.price = Math.max(0, price);
    }
}
