package com.gglobal.pages;

import static com.gglobal.utils.Constants.RMA_INPUT;
import static com.gglobal.utils.Constants.TRACKING_INPUT;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ReturnsPage extends BasePage {

  private static final Logger LOG = LogManager.getLogger(ReturnsPage.class);

  @FindBy(id = RMA_INPUT)
  WebElement rmaInput;
  @FindBy(id = TRACKING_INPUT)
  WebElement trackingInput;
  @FindBys(@FindBy(className = "MuiDataGrid-columnHeaderTitle"))
  List<WebElement> headers;

  public void setRmaInput(String rma){
    rmaInput.sendKeys(Keys.CONTROL + "a");
    rmaInput.sendKeys(rma);
  }

  public void setTrackingInput(String tracking){
    trackingInput.sendKeys(Keys.CONTROL + "a");
    trackingInput.sendKeys(tracking);
  }

  public String getDataTableCell(String columnHeader,int row,int expectedRows ){
    waitRowsToBeN("MuiDataGrid-row",expectedRows);
    List<WebElement> rows = driver.findElements(By.className("MuiDataGrid-row"));
    List<WebElement> cell = rows.get(row).findElements(By.className("MuiDataGrid-cell"));
    return cell.get(getHeaderPosition(columnHeader)).getAttribute("innerHTML");
  }

  public int getHeaderPosition(String columnHeader){
    int position=0;
    for (WebElement header : headers)
    {
      if(header.getAttribute("innerHTML").equals(columnHeader)) {
        return position;
      }
        position++;
    }
    return 0;
  }

}
