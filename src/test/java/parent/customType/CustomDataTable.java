package parent.customType;

import io.cucumber.java.DataTableType;
import parent.domainObject.BillingDetails;

import java.util.Map;

public class CustomDataTable {
    @DataTableType
    public BillingDetails billingDetails(Map<String, String> entry){
        return new BillingDetails(
                entry.get("firstname"),
                entry.get("lastname"),
                entry.get("company"),
                entry.get("country"),
                entry.get("lastAddressOne"),
                entry.get("city"),
                entry.get("stateName"),
                entry.get("zipCode"),
                entry.get("email"),
                entry.get("phone"),
                entry.get("additionText"));
    }
}
