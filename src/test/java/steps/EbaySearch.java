package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EbayHome;

public class EbaySearch {
	
	public WebDriver driver;
	private EbayHome ebayHome;
	
	public EbaySearch(PicoTestContext picoTestContext) {
		ebayHome = picoTestContext.getPageObjectManager().getEbayHome();
	}
	
	@Given("Naviagate to Ebay URL")
	public void naviagate_to_ebay_url() {
		ebayHome.navigateToEbay();
	}

	@When("Enter the search product name and product catagory")
	public void enter_the_search_product_name_and_product_catagory() {
		ebayHome.enterSearchText("iPhone");
		ebayHome.selectProdCatagory("Cell Phones & Accessories");
	}
	
	@When("^Enter the multiple search product name as ([^0-9]+) and multiple product catagory as ([^0-9]+)$")
	public void enter_the_multiple_search_product_name_as_samsung_and_multiple_product_catagory_as_cell_phones_accessories(String prodName, String prodCatagory) {
		ebayHome.enterSearchText(prodName);
		ebayHome.selectProdCatagory(prodCatagory);
	}
	
	@When("Click on Search button")
	public void click_on_search_button() {
		ebayHome.clickOnSearchButton();
	}

	@Then("User should see the search result")
	public void user_should_see_the_search_result() {
		String result = ebayHome.getSearchResult();
		String numberOnly = result.replaceAll("[^0-9]", "");
		int iResult = Integer.parseInt(numberOnly);
		System.out.println("Result in number is : "+iResult);
		if(iResult > 0) {
			System.out.println("Result List is existing");
		}else {
			System.out.println("Result is ZERO");
		}
	}

}
