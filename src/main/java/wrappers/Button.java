package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class Button {
    private UIElement uiElement;

    public Button(BrowserService browserService, By by) {
        this.uiElement = new UIElement(browserService, by);
    }

    public Button(UIElement uiElement) {
        this.uiElement = uiElement;
    }

    public void click() {
        uiElement.click();
    }
}
