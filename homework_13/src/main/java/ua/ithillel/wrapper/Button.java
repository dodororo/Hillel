package ua.ithillel.wrapper;

import org.openqa.selenium.WebElement;

public class Button {
    private WebElement element;

    public Button(WebElement element) {
        this.element = element;
    }

    public static void clickButton(WebElement element) {
        element.click();
        System.out.println("Clicked button " + element.getAttribute("textContent"));
    }

}