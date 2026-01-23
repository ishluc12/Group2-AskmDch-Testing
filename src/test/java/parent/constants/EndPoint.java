package parent.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    MEN("/men"),
    WOMEN("/women"),
    ACCESSORIES("/accessories"),
    CART("/cart"),
    CHECKOUT("/checkout");

    public final String url;
    EndPoint(String url){
        this.url=url;
    }
}
