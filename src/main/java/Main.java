
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        List<String> ev1 = new ArrayList<>();
        List<String> hesab1 = new ArrayList<>();
        List<String> dep1 = new ArrayList<>();
        List<String> ev2 = new ArrayList<>();
        List<String> hesab2 = new ArrayList<>();
        List<String> dep2 = new ArrayList<>();
        List<String> ev3 = new ArrayList<>();
        List<String> hesab3 = new ArrayList<>();
        List<String> dep3 = new ArrayList<>();
        List<String> asianHome = new ArrayList<>();
        List<String> Handicap = new ArrayList<>();
        List<String> asianAway = new ArrayList<>();
        List<String> ms1 = new ArrayList<>();
        List<String> msX = new ArrayList<>();
        List<String> ms2 = new ArrayList<>();
        List<String> OU_over = new ArrayList<>();
        List<String> OU_goal_ = new ArrayList<>();
        List<String> OU_under = new ArrayList<>();
        List<String> htt = new ArrayList<>();
        List<String> ftt = new ArrayList<>();


        datacek(driver, ev1, hesab1, dep1, ev2, hesab2, dep2, ev3, hesab3, dep3, asianHome, Handicap, asianAway, ms1, msX, ms2, OU_over, OU_goal_, OU_under, htt, ftt);
        exceleYazdir(ev1, hesab1, dep1, ev2, hesab2, dep2, ev3, hesab3, dep3, asianHome, Handicap, asianAway, ms1, msX, ms2, OU_over, OU_goal_, OU_under, htt, ftt);

    }

    private static void exceleYazdir(List<String> ev1, List<String> hesab1, List<String> dep1, List<String> ev2, List<String> hesab2, List<String> dep2, List<String> ev3, List<String> hesab3, List<String> dep3, List<String> asianHome, List<String> Handicap, List<String> asianAway, List<String> ms1, List<String> msX, List<String> ms2, List<String> OU_over, List<String> OU_goal_, List<String> OU_under, List<String> htt, List<String> ftt) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Home Team 1");
        headerRow.createCell(1).setCellValue("Third Score ");
        headerRow.createCell(2).setCellValue("Away Team 1");

        headerRow.createCell(3).setCellValue("Home Team 2");
        headerRow.createCell(4).setCellValue("Second Score");
        headerRow.createCell(5).setCellValue("Away Team 2");

        headerRow.createCell(6).setCellValue("Home Team 3");
        headerRow.createCell(7).setCellValue("First Score");
        headerRow.createCell(8).setCellValue("Away Team 3");

        headerRow.createCell(9).setCellValue("Asian-home");
        headerRow.createCell(10).setCellValue("Handicap ");
        headerRow.createCell(11).setCellValue("Asian-away");

        headerRow.createCell(12).setCellValue("MS 1");
        headerRow.createCell(13).setCellValue("MS X");
        headerRow.createCell(14).setCellValue("MS 2");

        headerRow.createCell(15).setCellValue("Over");
        headerRow.createCell(16).setCellValue("Goals");
        headerRow.createCell(17).setCellValue("Under");

        headerRow.createCell(18).setCellValue("HT");
        headerRow.createCell(19).setCellValue("FT");

        // Write the data to the Excel file
        for (int i = 0; i < ev1.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(ev1.get(i));
            row.createCell(1).setCellValue(hesab1.get(i));
            row.createCell(2).setCellValue(dep1.get(i));

            row.createCell(3).setCellValue(ev2.get(i));
            row.createCell(4).setCellValue(hesab2.get(i));
            row.createCell(5).setCellValue(dep2.get(i));

            row.createCell(6).setCellValue(ev3.get(i));
            row.createCell(7).setCellValue(hesab3.get(i));
            row.createCell(8).setCellValue(dep3.get(i));

            row.createCell(9).setCellValue(asianHome.get(i));
            row.createCell(10).setCellValue(Handicap.get(i));
            row.createCell(11).setCellValue(asianAway.get(i));

            row.createCell(12).setCellValue(ms1.get(i));
            row.createCell(13).setCellValue(msX.get(i));
            row.createCell(14).setCellValue(ms2.get(i));

            row.createCell(15).setCellValue(OU_over.get(i));
            row.createCell(16).setCellValue(OU_goal_.get(i));
            row.createCell(17).setCellValue(OU_under.get(i));



            row.createCell(18).setCellValue(htt.get(i));
            row.createCell(19).setCellValue(ftt.get(i));

        }

        // Save the workbook
        try (FileOutputStream fileOut = new FileOutputStream("src\\FUll_data.xlsx")) {
            workbook.write(fileOut);
            fileOut.close();
        }
        catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }


    }


    public static void datacek(
            WebDriver driver,List<String> ev1, List<String> hesab1,List<String> dep1,
            List<String> ev2, List<String> hesab2,List<String> dep2,
            List<String> ev3, List<String> hesab3,List<String> dep3,
            List<String> asianHome, List<String> Handicap, List<String> asianAway,
            List<String> ms1, List<String> msX, List<String> ms2,
            List<String> OU_over, List<String> OU_goal_, List<String> OU_under,
            List<String> htt, List<String> ftt)
                                                 {

        for (int i = 1900000; i < 1900010; i++) {
            try {
                System.out.println("LInkin idsi : "+i);
                driver.get("https://live.nowgoal14.com/match/h2h-" + i);
                driver.findElement(By.xpath("//*[@id=\"checkboxleague1\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"checkboxleague2\"]")).click();
                //Thread.sleep(2500);
                driver.findElement(By.xpath("//*[@id=\"selectMatchCount1\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"selectMatchCount1\"]/option[3]")).click();
                driver.findElement(By.xpath("//*[@id=\"selectMatchCount2\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"selectMatchCount2\"]/option[3]")).click();

                WebElement htElement = driver.findElement(By.xpath("//*[@id=\"mScore\"]/div/div[2]/span/span[1]"));
                WebElement ftElement = driver.findElement(By.xpath("//*[@id=\"mScore\"]/div/div[2]/span/span[2]"));
                String ht = htElement.getText();
                String ft = ftElement.getText();

                for (int o = 1; o <= 2; o++) {
                    ftt.add(ft);
                    htt.add(ht);


                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[3]", asianHome);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[4]", Handicap);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[5]", asianAway);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[6]", ms1);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[7]", msX);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[8]", ms2);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[9]", OU_over);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[10]", OU_goal_);
                    addElementToList(driver, "//*[@id=\"tr_o_1_8\"]/td[11]", OU_under);


                }





                WebElement hometable = driver.findElement(By.xpath("//*[@id=\"table_v1\" and @class =\"team-table-home\"]"));
                int count = 0;
                for (int k = 1; k <= 2; k++) {
                    for (int j = 4; j <= 12; j++) {
                        WebElement ev = hometable.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[10]/div[" + k + "]/table/tbody/tr[" + j + "]"));
                        if (ev.getText().length() > 3) {
                            count++;
                            int div = k;
                            int tr = j;

                            if (div == 1 && count == 1) {
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[3]", ev1);
                                addElementToListSubString(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[4]", hesab1);
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[5]", dep1);

                            } else if (div == 1 && count == 2) {
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[3]", ev2);
                                addElementToListSubString(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[4]", hesab2);
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[5]", dep2);
                            } else if (div == 1 && count == 3) {
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[3]", ev3);
                                addElementToListSubString(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[4]", hesab3);
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[5]", dep3);
                            }

                            else if (div == 2 && count == 4) {
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[3]", ev1);
                                addElementToListSubString(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[4]", hesab1);
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[5]", dep1);

                            }
                            else if (div == 2 && count == 5) {
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[3]", ev2);
                                addElementToListSubString(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[4]", hesab2);
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[5]", dep2);
                            }
                            else if (div == 2 && count == 6) {
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[3]", ev3);
                                addElementToListSubString(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[4]", hesab3);
                                addElementToList(driver, "/html/body/div[6]/div[1]/div[2]/div[10]/div[" + div + "]/table/tbody/tr[" + tr + "]/td[5]", dep3);
                            }


                        }
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        driver.quit();
    }

    private static void addElementToList(WebDriver driver, String xpath, List<String> list) {
        String elementText = driver.findElement(By.xpath(xpath)).getText();
        list.add((elementText == null || elementText.isEmpty()) ? " - " : elementText);
    }

    private static void addElementToListSubString(WebDriver driver, String xpath, List<String> list) {
        String elementText = driver.findElement(By.xpath(xpath)).getText();
        list.add((elementText == null || elementText.isEmpty()) ? " - " : elementText.substring(0, 3));
    }

}
