package extensions;

import helpers.AllureSteps;
import org.junit.jupiter.api.extension.*;
import ui.BaseTest;

public class AllureExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent())
            AllureSteps.captureScreenshotSpoiler(BaseTest.getDriver());
    }
}
