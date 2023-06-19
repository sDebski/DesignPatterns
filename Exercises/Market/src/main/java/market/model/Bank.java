package market.model;

import lombok.Getter;
import market.observer.TurnoverObserver;
import market.observer.InflationObserver;

import java.util.*;

@Getter
public class Bank implements TurnoverObserver {
    private static Bank instance;
    private double inflation;
    private List<InflationObserver> followers;
    private double averageIncome;
    private double money;
    private double transactions;

    public void addFollower(InflationObserver observer) {
        followers.add(observer);
    }

    private Bank() {
        inflation = 1.0;
        followers = new ArrayList<>();
    }

    public void update(double amount) {
        ++transactions;
        money +=amount;
        averageIncome = money / transactions;
        if (amount >= 1.2 * averageIncome) {
            setInflation(inflation + 0.1);
        } else if (amount <= 0.8 * averageIncome) {
            setInflation(inflation - 0.1);
        }
    }

    public void setInflation(double value) {
        this.inflation = (value >= 0) ? value : 0;
        followers.forEach(f -> f.update(value));
    }

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return  instance;
    }

}
