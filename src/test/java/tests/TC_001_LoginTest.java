package tests;

import base.BaseClass;
import java.io.IOException;
import org.testng.annotations.Test;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public  void testLogin() throws InterruptedException, IOException {		
		login();
		Thread.sleep(5000);
		driver.quit();
	}
}