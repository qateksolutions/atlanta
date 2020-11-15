package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue() {
        return new Object[][]{
                {"Rifat"},
                {"Mohammad"},
                {"Ashraf"}};
    }

    @DataProvider (name = "MultipleValues")
    public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Rifat","Florida", 33018},
                {"Farid", "New York", 12457},
                {"Ashraf", "Bangladesh", 1207}
        };
    }

    @DataProvider (name = "RealAprRates")
    public Object[][] storeRealAprRates() {
        return new Object[][] {
                {"200000","15000","3","3.130%"}
        };
    }
}
