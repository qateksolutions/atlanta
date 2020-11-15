package parameters;

import org.testng.annotations.Test;
import utilities.DataProviderClass;


public class TestDataProvider {
    @Test (dataProvider = "MultipleValues", dataProviderClass = DataProviderClass.class)
    public void readMultipleValues(String name, String state, int zipCode) {
        System.out.println("Name is: " + name);
        System.out.println("State is: " + state);
        System.out.println("Zip Code is: " + zipCode);
    }
}
