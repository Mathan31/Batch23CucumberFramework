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

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbaySearch {
	
	public WebDriver driver;
	public String sURL = "https://www.ebay.com/";
	public static int iBrowserType = 8; // 1 - Chrome, 2 - Edge, 3 - FF, 4 - IE
	
	@Given("User should launch chrome browser")
	public void invokeChrome() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : "+iBrowserType+", So invoking the Chrome browser.");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is : "+iBrowserType+", So invoking the Edge browser.");
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("User option is : "+iBrowserType+", So invoking the FireFox browser.");
			driver = new FirefoxDriver();
			break;
		case 4:
			System.out.println("User option is : "+iBrowserType+", So invoking the IE browser.");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("User option is wrong: "+iBrowserType+", So invoking the default Chrome browser.");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	// Cucumber Expressions

	@Given("User should launch the browser based on {int}")
	public void user_should_launch_the_browser_based_on(Integer iBrowserType) {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : "+iBrowserType+", So invoking the Chrome browser.");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is : "+iBrowserType+", So invoking the Edge browser.");
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("User option is : "+iBrowserType+", So invoking the FireFox browser.");
			driver = new FirefoxDriver();
			break;
		case 4:
			System.out.println("User option is : "+iBrowserType+", So invoking the IE browser.");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("User option is wrong: "+iBrowserType+", So invoking the default Chrome browser.");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Given("^User should launch the browser based on examples ([0-9]+)$")
	public void user_should_launch_the_browser_based_on_examples(Integer iBrowserType) {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : "+iBrowserType+", So invoking the Chrome browser.");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User option is : "+iBrowserType+", So invoking the Edge browser.");
			driver = new EdgeDriver();
			break;
		case 3:
			System.out.println("User option is : "+iBrowserType+", So invoking the FireFox browser.");
			driver = new FirefoxDriver();
			break;
		case 4:
			System.out.println("User option is : "+iBrowserType+", So invoking the IE browser.");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("User option is wrong: "+iBrowserType+", So invoking the default Chrome browser.");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Given("Naviagate to Ebay URL")
	public void naviagate_to_ebay_url() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("Enter the search product name and product catagory")
	public void enter_the_search_product_name_and_product_catagory() {
		WebElement oSearchText,oCatagorySelect;
		oSearchText = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		oSearchText.sendKeys("iPhone");
		
		oCatagorySelect = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oCatagorySelect);
		oSelect.selectByVisibleText("Cell Phones & Accessories");
	}
	
	@When("Enter the search product name as {string} and product catagory as {string}")
	public void enter_the_search_product_name_as_and_product_catagory_as(String prodName, String prodCatagory) {
		WebElement oSearchText,oCatagorySelect;
		oSearchText = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		oSearchText.sendKeys(prodName);
		
		oCatagorySelect = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oCatagorySelect);
		oSelect.selectByVisibleText(prodCatagory);
	}
	//[a-z A-Z 0-9]
	/**
	 * 
	 */
	@When("^Enter the multiple search product name as ([^0-9]+) and multiple product catagory as ([^0-9]+)$")
	public void enter_the_multiple_search_product_name_as_samsung_and_multiple_product_catagory_as_cell_phones_accessories(String prodName, String prodCatagory) {
		WebElement oSearchText,oCatagorySelect;
		oSearchText = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		oSearchText.sendKeys(prodName);
		
		oCatagorySelect = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oCatagorySelect);
		oSelect.selectByVisibleText(prodCatagory);
	}
	
	@When("Enter the multiple search product and product catagory through data table as a list")
	public void enter_the_multiple_search_product_and_product_catagory_through_data_table_as_a_list(DataTable dataTable) {
		List<List<String>> values = dataTable.asLists();
		String prodName, prodCatagory;
		for (List<String> list : values) {
			prodName = list.get(0);
			prodCatagory = list.get(1);
			WebElement oSearchText,oCatagorySelect;
			oSearchText = driver.findElement(By.xpath("//input[@id='gh-ac']"));
			oSearchText.clear();
			oSearchText.sendKeys(prodName);
			
			oCatagorySelect = driver.findElement(By.xpath("//select[@id='gh-cat']"));
			Select oSelect = new Select(oCatagorySelect);
			oSelect.selectByVisibleText(prodCatagory);
			click_on_search_button();
		}
	}
	
	@When("Enter the multiple search product and product catagory through data table as a map")
	public void enter_the_multiple_search_product_and_product_catagory_through_data_table_as_a_map(DataTable dataTable) {
		List<Map<String, String>> values = dataTable.asMaps();
		String prodName, prodCatagory;
		for (Map<String, String> map : values) {
			prodName = map.get("productName");
			prodCatagory = map.get("productCatagory");
			WebElement oSearchText,oCatagorySelect;
			oSearchText = driver.findElement(By.xpath("//input[@id='gh-ac']"));
			oSearchText.clear();
			oSearchText.sendKeys(prodName);
			
			oCatagorySelect = driver.findElement(By.xpath("//select[@id='gh-cat']"));
			Select oSelect = new Select(oCatagorySelect);
			oSelect.selectByVisibleText(prodCatagory);
			click_on_search_button();
		}
	}




	@When("Click on Search button")
	public void click_on_search_button() {
	    WebElement oSearcButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
		oSearcButton.click();
	}

	@Then("User should see the search result")
	public void user_should_see_the_search_result() {
		WebElement oResult;
		oResult = driver.findElement(By.xpath("(//h1[@class='srp-controls__count-heading']/span)[1]"));
		String result = oResult.getText();
		String numberOnly = result.replaceAll("[^0-9]", "");
		int iResult = Integer.parseInt(numberOnly);
		System.out.println("Result in number is : "+iResult);
		if(iResult > 0) {
			System.out.println("Result List is existing");
		}else {
			System.out.println("Result is ZERO");
		}
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}

}
