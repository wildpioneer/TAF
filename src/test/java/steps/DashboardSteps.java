package steps;

import core.BrowserService;
import pages.DashboardPage;

public class DashboardSteps extends HeaderSteps {
    private DashboardPage dashboardPage = null;

    public DashboardSteps(BrowserService browserService) {
        super(browserService);
    }

    public DashboardSteps openDashboardPage(boolean openByUrl) {
        dashboardPage = new DashboardPage(browserService, openByUrl);

        return this;
    }
}
