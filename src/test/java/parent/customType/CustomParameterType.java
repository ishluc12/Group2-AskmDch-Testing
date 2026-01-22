package parent.customType;

import parent.domainObject.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {
    @ParameterType(".*")
    public Product setProduct(String product){
        return new Product(product);
    }

}

