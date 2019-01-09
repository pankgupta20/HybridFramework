package com.HybridFramework.GridTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GridParallelTest extends GridTest {
	@Test
	public void test_01() throws InterruptedException, MalformedURLException {
		try {
			getDriver().get("http://demoqa.com/autocomplete/");
			getDriver().findElement(By.id("ui-id-5")).click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
