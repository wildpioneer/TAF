package baseEntities;

import core.BrowserService;

public class BaseStep {
    public BrowserService browserService;

    public BaseStep(BrowserService browserService) {
        this.browserService = browserService;
    }
}
