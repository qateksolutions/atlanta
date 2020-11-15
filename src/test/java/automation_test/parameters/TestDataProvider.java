package automation_test.parameters;

import org.testng.annotations.Test;
import utilities.DataProviderClass;

public class TestDataProvider {
    @Test (dataProvider = "MultipleValues", dataProviderClass = DataProviderClass.class)
    public void readMultipleValues(String name, String state, int zipCode) {
        System.out.println("[Multiple Value] Name is: " + name);
        System.out.println("[Multiple Value] State is: " + state);
        System.out.println("[Multiple Value] Zip Code is: " + zipCode);
    }
}
