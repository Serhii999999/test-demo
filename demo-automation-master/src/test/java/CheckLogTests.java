
import com.demo.core.base.Actions;
import com.demo.core.base.DriverInit;
import com.demo.core.base.reportAutomation.pages.BuildPage;
import com.demo.core.base.reportAutomation.pages.LoginPage;
import com.demo.core.base.reportAutomation.pages.ProjectPage;
import com.demo.core.base.reportAutomation.pages.ScreamingFrogPage;
import com.demo.core.base.reportAutomation.services.Constants;
import com.demo.core.base.reportAutomation.services.CredService;
import com.demo.core.base.reportAutomation.services.UrlService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckLogTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private BuildPage buildPage;
    private ScreamingFrogPage screamingFrogPage;
    private Actions actions;
    private final int THRESHOLD = 30;
    @BeforeTest
    public void setUp()  {
        driver = DriverInit.getDriver();
        loginPage = new LoginPage(driver);
        buildPage = new BuildPage(driver);
        screamingFrogPage = new ScreamingFrogPage(driver);
        actions = new Actions(driver);
        actions.open(UrlService.BASIC_URL_JENKINS);
        loginPage.logInSystem(CredService.USERNAME, CredService.PASSWORD);
    }
    @Test
    public void checkAllValuesAreCorrect(){
        SoftAssert softAssert = new SoftAssert();
        screamingFrogPage.frogLink();
        screamingFrogPage.prodLinkClick();
        new ProjectPage(driver).clickBuildLink();
        buildPage.clickConsoleOutputButton();
        buildPage.clickFullLogButton();
        var prodServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PROD_URL_CASINO);
        var prodPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PROD_URL_CASINO);
        var prodTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PROD_URL_CASINO);
        var prodTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PROD_URL_CASINO);
        var prodMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PROD_URL_CASINO);
        var prodMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PROD_URL_CASINO);
        var prodH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PROD_URL_CASINO);
        var prodH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PROD_URL_CASINO);
        var prodH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PROD_URL_CASINO);

        softAssert.assertEquals(prodServerError,0, "500 on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodTitleMissing,0,"missing title on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodTitleDuplicate,0,"duplicate titles on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodMetaMissing,0,"missing meta on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodMetaDuplicate,0,"duplicate meta on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodH1Missing,0, "missing H1 on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodH1Duplicate,0,"duplicate H1 on prod for "+UrlService.PROD_URL_CASINO);
        softAssert.assertEquals(prodH2Missing,0,"missing H2 on prod for "+UrlService.PROD_URL_CASINO);

        var prodKServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PROD_URL_K_CASINO);
        var prodKPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PROD_URL_K_CASINO);
        var prodKTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PROD_URL_K_CASINO);
        var prodKTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PROD_URL_K_CASINO);
        var prodKMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PROD_URL_K_CASINO);
        var prodKMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PROD_URL_K_CASINO);
        var prodKH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PROD_URL_K_CASINO);
        var prodKH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PROD_URL_K_CASINO);
        var prodKH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PROD_URL_K_CASINO);

        softAssert.assertEquals(prodKServerError,0, "500 on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKTitleMissing,0,"missing title on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKTitleDuplicate,0,"duplicate titles on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKMetaMissing,0,"missing meta on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKMetaDuplicate,0,"duplicate meta on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKH1Missing,0, "missing H1 on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKH1Duplicate,0,"duplicate H1 on prod for "+UrlService.PROD_URL_K_CASINO);
        softAssert.assertEquals(prodKH2Missing,0,"missing H2 on prod for "+UrlService.PROD_URL_K_CASINO);

        var prodAUSServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PROD_URL_AUS_CASINO);
        var prodAUSH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PROD_URL_AUS_CASINO);

        softAssert.assertEquals(prodAUSServerError,0, "500 on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSTitleMissing,0,"missing title on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSTitleDuplicate,0,"duplicate titles on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSMetaMissing,0,"missing meta on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSMetaDuplicate,0,"duplicate meta on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSH1Missing,0, "missing H1 on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSH1Duplicate,0,"duplicate H1 on prod for "+UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertEquals(prodAUSH2Missing,0,"missing H2 on prod for "+UrlService.PROD_URL_AUS_CASINO);

        var prodCAServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PROD_URL_CA_CASINO);
        var prodCAPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PROD_URL_CA_CASINO);
        var prodCATitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PROD_URL_CA_CASINO);
        var prodCATitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PROD_URL_CA_CASINO);
        var prodCAMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PROD_URL_CA_CASINO);
        var prodCAMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PROD_URL_CA_CASINO);
        var prodCAH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PROD_URL_CA_CASINO);
        var prodCAH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PROD_URL_CA_CASINO);
        var prodCAH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PROD_URL_CA_CASINO);

        softAssert.assertEquals(prodCAServerError,0, "500 on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCATitleMissing,0,"missing title on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCATitleDuplicate,0,"duplicate titles on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCAMetaMissing,0,"missing meta on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCAMetaDuplicate,0,"duplicate meta on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCAH1Missing,0, "missing H1 on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCAH1Duplicate,0,"duplicate H1 on prod for "+UrlService.PROD_URL_CA_CASINO);
        softAssert.assertEquals(prodCAH2Missing,0,"missing H2 on prod for "+UrlService.PROD_URL_CA_CASINO);

        var prodUKServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PROD_URL_UK_CASINO);
        var prodUKPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PROD_URL_UK_CASINO);
        var prodUKTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PROD_URL_UK_CASINO);
        var prodUKTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PROD_URL_UK_CASINO);
        var prodUKMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PROD_URL_UK_CASINO);
        var prodUKMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PROD_URL_UK_CASINO);
        var prodUKH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PROD_URL_UK_CASINO);
        var prodUKH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PROD_URL_UK_CASINO);
        var prodUKH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PROD_URL_UK_CASINO);

        softAssert.assertEquals(prodUKServerError,0, "500 on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKTitleMissing,0,"missing title on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKTitleDuplicate,0,"duplicate titles on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKMetaMissing,0,"missing meta on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKMetaDuplicate,0,"duplicate meta on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKH1Missing,0, "missing H1 on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKH1Duplicate,0,"duplicate H1 on prod for "+UrlService.PROD_URL_UK_CASINO);
        softAssert.assertEquals(prodUKH2Missing,0,"missing H2 on prod for "+UrlService.PROD_URL_UK_CASINO);

        var prodNZServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PROD_URL_NZ_CASINO);
        var prodNZPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PROD_URL_NZ_CASINO);
        var prodNZTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PROD_URL_NZ_CASINO);
        var prodNZTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PROD_URL_NZ_CASINO);
        var prodNZMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PROD_URL_NZ_CASINO);
        var prodNZMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PROD_URL_NZ_CASINO);
        var prodNZH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PROD_URL_NZ_CASINO);
        var prodNZH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PROD_URL_NZ_CASINO);
        var prodNZH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PROD_URL_NZ_CASINO);

        softAssert.assertEquals(prodNZServerError,0, "500 on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZTitleMissing,0,"missing title on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZTitleDuplicate,0,"duplicate titles on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZMetaMissing,0,"missing meta on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZMetaDuplicate,0,"duplicate meta on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZH1Missing,0, "missing H1 on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZH1Duplicate,0,"duplicate H1 on prod for "+UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertEquals(prodNZH2Missing,0,"missing H2 on prod for "+UrlService.PROD_URL_NZ_CASINO);


        actions.navigateBack();
        actions.navigateBack();
        actions.navigateBack();

        new ScreamingFrogPage(driver).preprodLinkClick();
        new ProjectPage(driver).clickBuildLink();
        buildPage.clickConsoleOutputButton();
        buildPage.clickFullLogButton();

        var preProdServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PREPOD_URL_CASINO);
        var preProdPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PREPOD_URL_CASINO);
        var preProdTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PREPOD_URL_CASINO);
        var preProdTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PREPOD_URL_CASINO);
        var preProdMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PREPOD_URL_CASINO);
        var preProdMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PREPOD_URL_CASINO);
        var preProdH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PREPOD_URL_CASINO);
        var preProdH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PREPOD_URL_CASINO);
        var preProdH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PREPOD_URL_CASINO);

        softAssert.assertEquals(preProdServerError,0, "500 on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdTitleMissing,0,"missing title on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdTitleDuplicate,0,"duplicate titles on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdMetaMissing,0,"missing meta on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdMetaDuplicate,0,"duplicate meta on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdH1Missing,0,"missing H1 on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdH1Duplicate,0,"duplicate H1 on preProd for "+UrlService.PREPOD_URL_CASINO);
        softAssert.assertEquals(preProdH2Missing,0,"missing H2 on preProd for "+UrlService.PREPOD_URL_CASINO);

        var preProdKServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PREPOD_URL_K_CASINO);
        var preProdKPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PREPOD_URL_K_CASINO);
        var preProdKTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PREPOD_URL_K_CASINO);
        var preProdKTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PREPOD_URL_K_CASINO);
        var preProdKMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PREPOD_URL_K_CASINO);
        var preProdKMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PREPOD_URL_K_CASINO);
        var preProdKH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PREPOD_URL_K_CASINO);
        var preProdKH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PREPOD_URL_K_CASINO);
        var preProdKH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PREPOD_URL_K_CASINO);

        softAssert.assertEquals(preProdKServerError,0, "500 on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKTitleMissing,0,"missing title on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKTitleDuplicate,0,"duplicate titles on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKMetaMissing,0,"missing meta on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKMetaDuplicate,0,"duplicate meta on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKH1Missing,0,"missing H1 on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKH1Duplicate,0,"duplicate H1 on preProd for "+UrlService.PREPOD_URL_K_CASINO);
        softAssert.assertEquals(preProdKH2Missing,0,"missing H2 on preProd for "+UrlService.PREPOD_URL_K_CASINO);

        var preProdAUSServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PREPOD_URL_AUS_CASINO);
        var preProdAUSH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PREPOD_URL_AUS_CASINO);

        softAssert.assertEquals(preProdAUSServerError,0, "500 on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSTitleMissing,0,"missing title on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSTitleDuplicate,0,"duplicate titles on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSMetaMissing,0,"missing meta on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSMetaDuplicate,0,"duplicate meta on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSH1Missing,0,"missing H1 on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSH1Duplicate,0,"duplicate H1 on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);
        softAssert.assertEquals(preProdAUSH2Missing,0,"missing H2 on preProd for "+UrlService.PREPOD_URL_AUS_CASINO);

        var preProdCAServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCAPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCATitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCATitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCAMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCAMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCAH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCAH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PREPOD_URL_CA_CASINO);
        var preProdCAH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PREPOD_URL_CA_CASINO);

        softAssert.assertEquals(preProdCAServerError,0, "500 on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCATitleMissing,0,"missing title on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCATitleDuplicate,0,"duplicate titles on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCAMetaMissing,0,"missing meta on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCAMetaDuplicate,0,"duplicate meta on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCAH1Missing,0,"missing H1 on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCAH1Duplicate,0,"duplicate H1 on preProd for "+UrlService.PREPOD_URL_CA_CASINO);
        softAssert.assertEquals(preProdCAH2Missing,0,"missing H2 on preProd for "+UrlService.PREPOD_URL_CA_CASINO);

        var preProdUKServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PREPOD_URL_UK_CASINO);
        var preProdUKH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PREPOD_URL_UK_CASINO);

        softAssert.assertEquals(preProdUKServerError,0, "500 on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKTitleMissing,0,"missing title on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKTitleDuplicate,0,"duplicate titles on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKMetaMissing,0,"missing meta on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKMetaDuplicate,0,"duplicate meta on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKH1Missing,0,"missing H1 on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKH1Duplicate,0,"duplicate H1 on preProd for "+UrlService.PREPOD_URL_UK_CASINO);
        softAssert.assertEquals(preProdUKH2Missing,0,"missing H2 on preProd for "+UrlService.PREPOD_URL_UK_CASINO);

        var preProdNZServerError = actions.retrieveNumberFromPage(Constants.REGEX_FOR_500, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZPages = actions.retrieveNumberFromPage(Constants.REGEX_FOR_PAGES, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZTitleMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_MISSING, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZTitleDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_TITLE_DUPLICATE, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZMetaMissing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_MISSING, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZMetaDuplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_META_DUPLICATE, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZH1Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_MISSING, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZH1Duplicate = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H1_DUPLICATE, UrlService.PREPOD_URL_NZ_CASINO);
        var preProdNZH2Missing = actions.retrieveNumberFromPage(Constants.REGEX_FOR_H2_MISSING, UrlService.PREPOD_URL_NZ_CASINO);

        softAssert.assertEquals(preProdNZServerError,0, "500 on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZTitleMissing,0,"missing title on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZTitleDuplicate,0,"duplicate titles on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZMetaMissing,0,"missing meta on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZMetaDuplicate,0,"duplicate meta on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZH1Missing,0,"missing H1 on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZH1Duplicate,0,"duplicate H1 on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);
        softAssert.assertEquals(preProdNZH2Missing,0,"missing H2 on preProd for "+UrlService.PREPOD_URL_NZ_CASINO);

        softAssert.assertTrue(actions.areApproximatelyEqual(prodPages,preProdPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd for " + UrlService.PROD_URL_CASINO);
        softAssert.assertTrue(actions.areApproximatelyEqual(prodKPages,preProdKPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd for " + UrlService.PROD_URL_K_CASINO);
        softAssert.assertTrue(actions.areApproximatelyEqual(prodAUSPages,preProdAUSPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd for " + UrlService.PROD_URL_AUS_CASINO);
        softAssert.assertTrue(actions.areApproximatelyEqual(prodCAPages,preProdCAPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd for " + UrlService.PROD_URL_CA_CASINO);
        softAssert.assertTrue(actions.areApproximatelyEqual(prodUKPages,preProdUKPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd for " + UrlService.PROD_URL_UK_CASINO);
        softAssert.assertTrue(actions.areApproximatelyEqual(prodNZPages,preProdNZPages, THRESHOLD ),
                "there is a big difference between amount of pages on prod and preProd for " + UrlService.PROD_URL_NZ_CASINO);
        softAssert.assertAll();
    }

        @AfterTest
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }

}
