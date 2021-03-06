package domain;

class Money implements Expression {
    protected int amount;
    protected String currency;
    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    protected String currency() {
        return currency;
    }
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && currency().equals(money.currency());

    }
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
    Expression plus(Money append) {
        return new Money(amount + append.amount, currency);
    }
}
