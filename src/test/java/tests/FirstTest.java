package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    String url = "https://qa1505.testrail.io";
    String username = "atrostyanko+0401@gmail.com";
    String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @Test
    @Description
    public void userCanLogin() {
        // Настройка log4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настроить Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;

        //Configuration.headless = true;

        // Написать тест
        open("/");

        // $(By.id("name")).$(By.xpath("/")); //FindElement
        //Todo - рассмотреть варианты поиска
        $(By.id("name")).setValue(username);
        $(By.id("password")).val(password);
        $(By.id("button_primary")).submit();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive")).shouldHaveSize(388).find(text("123456")).find(By.tagName("a")).click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }


    @Test
    @Description
    public void test1() {
        // Настройка log4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настроить Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;

        //Configuration.headless = true;

        // Написать тест
        open("/");

        // $(By.id("name")).$(By.xpath("/")); //FindElement
        //Todo - рассмотреть варианты поиска
        $(By.id("name")).setValue(username);
        $(By.id("password")).val(password);
        $(By.id("button_primary")).submit();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$(".chart-legend-name")
                .filter(visible)
                .shouldHave(
                        texts(
                                "123456",
                                "aaaDencheck",
                                "aaaDencheck",
                                "aaaDencheck"
                        )
                );
    }

    @Test
    @Description
    public void test2() {
        // Настройка log4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настроить Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;

        //Configuration.headless = true;

        // Написать тест
        open("/");

        $(By.id("name")).setValue(username);
        $(By.id("password")).val(password);
        $(By.id("button_primary")).submit();

        $(byText("ahlhtdqk")).shouldBe(visible);
        $(withText("123")).shouldBe(visible);

        SelenideElement parent = $(withText("123")).parent();
        System.out.println(parent.getTagName());

        $(withText("123")).closest("tr");
        $(withText("123")).find("tr");
        $(withText("123")).scrollTo();
        $(withText("123")).innerText();
        $(withText("123")).innerHtml();
        $(withText("123")).isImage();
        $(withText("123")).doubleClick();
        $(withText("123")).contextClick();
        $(withText("123")).hover();


    }

    @Test
    @Description
    public void uploadTest() {
        // Не работает
        // Настройка log4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настроить Selenide
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;

        // Написать тест
        open("http://the-internet.herokuapp.com/upload");

        $("#file-submit").uploadFile(new File("/Users/aleksandr/Documents/Work/TechMeSkills/code/TAF/src/test/resources/download.jpeg"));
    }

    @Test
    @Description
    public void downloadTest() throws FileNotFoundException {
        // Не работает
        // Настройка log4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настроить Selenide
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;

        // Написать тест
        open("http://the-internet.herokuapp.com/download");

        $("#content a").download();
    }

    @Test
    @Description
    public void dragAndDropTest() {
        // Не работает
        // Настройка log4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настроить Selenide
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;

        // Написать тест
        open("http://the-internet.herokuapp.com/drag_and_drop");

        $("#column-b").dragAndDropTo($("#column-a"));
        sleep(3000);
    }
}
