package com.links;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lis {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Links\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = 0;
		for (WebElement link : links) {
			String linkurl = link.getAttribute("href");
			if (!(linkurl == null)) {
				URL u = new URL(linkurl);
				URLConnection o = u.openConnection();
				HttpsURLConnection h = (HttpsURLConnection) o;
				int code = h.getResponseCode();
				if (!(code == 200)) {
					count++;
					System.out.println(linkurl);
				}
			}
		}
	}

}
