import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue in repository")
    @Story("Creating issue")
    @Owner("akimovss")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://apiOrDBorAnotherurl.dotcom.com")
    @DisplayName(("Creating issue for authorized user"))
    public void staticLabelsTest() {
        //...
    }

    @Test
    public void dynamicLabelsTest() {
        Allure.getLifecycle().updateTestCase( t -> t.setName("Creating Issue for authorized user"));
        Allure.feature("Issue in repository");
        Allure.story("Creating issue");
        Allure.label("owner", "akimovss");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("testing", "https://someUsefullUrl");
        //...
    }
}
