package parent.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    CHECKOUT("/checkout");

    public final String url;
    EndPoint(String url){
        this.url=url;
    }
}
