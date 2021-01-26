package base.com.ua;

import base.com.ua.decoratorimpl.MyDefaultFieldDecorator;
import base.com.ua.utils.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class PageObject {

  public PageObject() {
    PageFactory.initElements(
        new MyDefaultFieldDecorator(new DefaultElementLocatorFactory(DriverManager.getDriver())),
        this);
  }
}
