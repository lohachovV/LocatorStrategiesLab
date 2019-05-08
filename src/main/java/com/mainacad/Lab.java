package com.mainacad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Lab {
    private static By textInfo = By.cssSelector(".vc_message_box-standard");
    private static By partialLinkTest = By.linkText("Partial Link Test");
    private static By firstName = By.cssSelector("[name='firstname']");
    private static By lastName = By.cssSelector("[name='lastname']");
    private static By sex = By.cssSelector("fieldset .control-group:nth-child(18) [name='sex']:nth-child(2)");
    private static By yearsOfExperience = By.cssSelector("fieldset .control-group:nth-child(23) [name='exp']:nth-child(2)");
    private static By date = By.xpath("/html//input[@id='datepicker']");
    private static By tools2 = By.cssSelector("fieldset .control-group:nth-child(40) [name='tool']:nth-child(3)");
    private static By tools3 = By.cssSelector("fieldset .control-group:nth-child(40) [name='tool']:nth-child(4)");
    private static By dropBoxElement = By.cssSelector("[name='continents']");
    private static By multiSelectElement = By.cssSelector("[multiple='multiple']");
    private static By button = By.cssSelector("[name='submit']");
    private static By text1 = By.xpath("//label[@id='NextedText']/span[@class='bcd']");



    public static void main( String[] args )
    {
        //Создаём системную переменную которая содержит путь к драйверу
        System.setProperty("webdriver.chrome.driver","src/main/java/com/mainacad/drivers/chromedriver.exe");

        //Создаём вебдрайвер
        WebDriver driver = new ChromeDriver();

        //Открываем тестовую страницу
        driver.get("https://www.toolsqa.com/automation-practice-form/");

        //TODO: Вывести в консоль текст Инфо сообщения
        System.out.println(driver.findElement(textInfo).getText());

        //TODO: Вывести в консоль текст заголовка формы ("Practice Automation Form")
        System.out.println(driver.findElement(partialLinkTest).getText());

        //TODO: Кликнуть линк Partial Link Test
        driver.findElement(partialLinkTest).click();

        //TODO: Заполнить поле First name:
        driver.findElement(firstName).sendKeys("myName");

        //TODO: Заполнить поле Last name:
        driver.findElement(lastName).sendKeys("myLastName");

        //TODO: Выбрать пол
        driver.findElement(sex).click();

        //TODO: Выбрать количество лет опыта
        driver.findElement(yearsOfExperience).click();

        //TODO: Заполнить поле дата
        driver.findElement(date).sendKeys("06.05.2019");

        //TODO: Выбрать несколько Automation Tool
        tickCheckbox( driver.findElement(tools2), true);
        tickCheckbox( driver.findElement(tools3), true);

        //TODO: Выбрать континент из выпадающего списка
        Select elementOfDrop = new Select(driver.findElement(dropBoxElement));
        elementOfDrop.selectByVisibleText("Europe");

        //TODO: Выбрать несколько вариантов из списка Selenium Commands
        Select elementOfMultiChoice  = new Select(driver.findElement((multiSelectElement)));
        elementOfMultiChoice.selectByVisibleText("Browser Commands");
        elementOfMultiChoice.selectByVisibleText("Switch Commands");
        elementOfMultiChoice.selectByVisibleText("WebElement Commands");

        //TODO: Кликнуть на кнопку Button
        driver.findElement(button).click();

        //TODO: Вывести в консоль текст лейбла Text1
        System.out.println(driver.findElement(text1).getText());

        //TODO: Вывести в консоль текст лейбла Text2

        //TODO: Закрыть браузер
        driver.close();
    }

    private static void tickCheckbox(WebElement checkbox, boolean isTick){
        if(checkbox.isSelected()!=isTick)
            checkbox.click();
    }


}
