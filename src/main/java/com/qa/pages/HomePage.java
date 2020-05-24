package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Alok Kumar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[.='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[.='New Contact']")
	WebElement newContactLink;
	
	@FindBy(linkText="Logout")
	WebElement logoutLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public void logout() {
		logoutLink.click();
		
	}
}
