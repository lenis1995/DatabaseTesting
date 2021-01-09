import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";
		Connection conec = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"lenis19");
		Statement s = conec.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM credentials WHERE scenario='zerobalancedcard';");

		while (rs.next()) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\lenix\\Desktop\\CURSOS PROGRAMACIÓN\\CURSO SELENIUM CON JAVA\\"
							+ "CURSO SELENIUM UDEMY\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
			String user=rs.getString("username");
			String pass=rs.getString("password");
			WebDriver driver=new ChromeDriver();;
			driver.get("https://login.salesforce.com/?locale=es");
			driver.findElement(By.id("username")).sendKeys(user);
			driver.findElement(By.id("password")).sendKeys(pass);
			
			Thread.sleep(3000);
			driver.quit();
		}
		
		

	}
}
