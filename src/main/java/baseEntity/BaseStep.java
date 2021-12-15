package baseEntity;

import org.techmeskills.auf.core.BrowsersService;

public class BaseStep {
    public BrowsersService browsersService;

    public BaseStep(BrowsersService browsersService) {
        this.browsersService = browsersService;
    }
}
