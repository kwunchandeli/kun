package com.kun.deploy;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.kun.deploy.DeployResult;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Deploy {

	Deploy() {
		super();
		System.out.println("实例化部署对象");
	}

	public void dodeploy(String projectname) throws InterruptedException {
		System.out.println("开始进行更新");
		// File file = new File("E:/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// file.getAbsolutePath());
		// WebDriver driver = new ChromeDriver();
		// File file = new File("E:/geckodriver.exe");
		File file = new File("geckodriver");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 识别元素时的超时时间
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//
		// 页面加载时的超时时间
		// driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);//
		// 异步脚本的超时时间

		driver.get("http://168.168.68.88:7001/console/login/LoginForm.jsp");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement uElement = driver.findElement(By.id("j_username"));
		uElement.sendKeys("chenkun");
		driver.findElement(By.id("j_password")).sendKeys("Chen#1101");
		uElement.submit();
		Thread.sleep(5000);
		// 若锁定并编辑按钮可以被点击，则先点击此按钮
		WebElement editElement = driver.findElement(By
				.xpath("//button[@name='save']"));
		if (editElement.isEnabled()) {
			editElement.click();
		}
		driver.findElement(By.linkText("部署")).click();
		Thread.sleep(3000);
		/*
		 * // 定位应用所在的table WebElement dElement = driver
		 * .findElement(By.id("genericTableFormtable")); // 按行找到所有部署的项目
		 * List<WebElement> trElements =
		 * dElement.findElements(By.tagName("tr"));
		 * System.out.println(trElements.size()); // 定义临时变量 WebElement
		 * tempElement = null; WebElement pElement = null; //
		 * 循环每一行的数据，从中查找出部署的应用所在的tr元素 for (WebElement tr : trElements) { //
		 * System.out.println(tr.getSize()); System.out.println(tr.getText());
		 * // 根据tr元素中是否含有应用的名称来确定需要更新的应用 if (tr.getText().contains(projectname))
		 * { // 若找到所需要更新的应用，则将此tr的第一个td赋值给临时变量 tempElement =
		 * tr.findElement(By.tagName("td")); System.out.println("查询到需要更新的应用！");
		 * 
		 * // 查找到td中的单选框 pElement =
		 * tr.findElement(By.className("radioAndCheckbox")); // 选中单选框
		 * pElement.click(); break; } }
		 */
		this.clickRadio(driver, projectname);
		Thread.sleep(2000);

		// 点击更新按钮
		driver.findElement(By.xpath("//button[@name='更新']")).click();
		Thread.sleep(3000);
		// 点击完成按钮
		driver.findElement(By.xpath("//button[@name='完成']")).click();
		Thread.sleep(2000);
		// 等待激活更改按钮可以被点击后点击激活更改
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By
						.xpath("//button[@name='save'][@class='formButton']"));
			}
		}).click();
		// 根据提示消息判断更新包是否正确
		List<WebElement> mesageSpan = driver.findElements(By
				.className("message_SUCCESS"));
		// 如果成功消息数量为0，则更新包错误
		// 更新完成之后，将更新结果写入到文件中
		System.out.println(mesageSpan.size());
		if (mesageSpan.isEmpty()) {
			System.out.println("有错误，更新失败！");
			DeployResult.saveResult(1);
			// 停止更新失败的应用
			for (int i = 0; i < 2; i++) {
				// 选择更新失败的应用
				this.clickRadio(driver, projectname);
				// 点击停止
				driver.findElement(By.xpath("//button[@name='停止']")).click();
				// 点击立即强制停止链接
				driver.findElement(By.linkText("立即强制停止")).click();
			}

		} else {
			DeployResult.saveResult(0);
			System.out.println("更新成功！");
		}
		// 如果是更新失败回滚后重新进行部署，则启动此状态为”准备就绪“的应用
		if (this.clickRadio(driver, "准备就绪")) {
			// 点击启动按钮
			driver.findElement(By.xpath("//button[@name='启动']")).click();
			// 点击为所有请求提供服务链接
			driver.findElement(By.linkText("为所有请求提供服务")).click();
			// 点击是按钮
			driver.findElement(By.xpath("//button[@name='是']")).click();
		}
		Thread.sleep(3000);
		// driver.close();
		driver.quit();
	}

	public void dodeployByExecCommand(String projectname)
			throws InterruptedException {
		System.out.println("开始进行更新");
		// File file = new File("E:/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// file.getAbsolutePath());
		// WebDriver driver = new ChromeDriver();
		File file = new File("E:/geckodriver.exe");
		//File file = new File("geckodriver");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 识别元素时的超时时间
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//
		// 页面加载时的超时时间
		// driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);//
		// 异步脚本的超时时间

		driver.get("http://168.168.68.88:7001/console/login/LoginForm.jsp");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement uElement = driver.findElement(By.id("j_username"));
		uElement.sendKeys("chenkun");
		driver.findElement(By.id("j_password")).sendKeys("Chen#1101");
		uElement.submit();
		Thread.sleep(5000);
		// 若锁定并编辑按钮可以被点击，则先点击此按钮
		WebElement editElement = driver.findElement(By
				.xpath("//button[@name='save']"));
		if (editElement.isEnabled()) {
			editElement.click();
		}
		driver.findElement(By.linkText("部署")).click();
		Thread.sleep(3000);
		/*
		 * // 定位应用所在的table WebElement dElement = driver
		 * .findElement(By.id("genericTableFormtable")); // 按行找到所有部署的项目
		 * List<WebElement> trElements =
		 * dElement.findElements(By.tagName("tr"));
		 * System.out.println(trElements.size()); // 定义临时变量 WebElement
		 * tempElement = null; WebElement pElement = null; //
		 * 循环每一行的数据，从中查找出部署的应用所在的tr元素 for (WebElement tr : trElements) { //
		 * System.out.println(tr.getSize()); System.out.println(tr.getText());
		 * // 根据tr元素中是否含有应用的名称来确定需要更新的应用 if (tr.getText().contains(projectname))
		 * { // 若找到所需要更新的应用，则将此tr的第一个td赋值给临时变量 tempElement =
		 * tr.findElement(By.tagName("td")); System.out.println("查询到需要更新的应用！");
		 * 
		 * // 查找到td中的单选框 pElement =
		 * tr.findElement(By.className("radioAndCheckbox")); // 选中单选框
		 * pElement.click(); break; } }
		 */
		this.clickRadio(driver, projectname);
		Thread.sleep(2000);

		// 点击更新按钮
		driver.findElement(By.xpath("//button[@name='更新']")).click();
		Thread.sleep(3000);
		// 点击完成按钮
		driver.findElement(By.xpath("//button[@name='完成']")).click();
		Thread.sleep(2000);
		// 等待激活更改按钮可以被点击后点击激活更改
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By
						.xpath("//button[@name='save'][@class='formButton']"));
			}
		}).click();
		// 根据提示消息判断更新包是否正确
		List<WebElement> mesageSpan = driver.findElements(By
				.className("message_SUCCESS"));
		// 如果成功消息数量为0，则更新包错误
		// 更新完成之后，将更新结果写入到文件中
		System.out.println(mesageSpan.size());
		if (mesageSpan.isEmpty()) {
			System.out.println("有错误，更新失败！");
			DeployResult.saveResult(1);
			// 停止更新失败的应用
			for (int i = 0; i < 2; i++) {
				// 选择更新失败的应用
				this.clickRadio(driver, projectname);
				// 点击停止
				driver.findElement(By.xpath("//button[@name='停止']")).click();
				// 点击立即强制停止链接
				driver.findElement(By.linkText("立即强制停止")).click();
			}
			//执行回滚操作
			//Runtime.getRuntime().exec("");
			//回滚完成后启动应用
			this.clickRadio(driver, projectname);
			// 点击启动按钮
			driver.findElement(By.xpath("//button[@name='启动']")).click();
			// 点击为所有请求提供服务链接
			driver.findElement(By.linkText("为所有请求提供服务")).click();
			// 点击是按钮
			driver.findElement(By.xpath("//button[@name='是']")).click();
		} else {
			DeployResult.saveResult(0);
			System.out.println("更新成功！");
		}
		
		Thread.sleep(3000);
		// driver.close();
		driver.quit();
	}

	public boolean clickRadio(WebDriver driver, String text) {
		// 定位应用所在的table
		WebElement dElement = driver
				.findElement(By.id("genericTableFormtable"));
		// 按行找到所有部署的项目
		List<WebElement> trElements = dElement.findElements(By.tagName("tr"));
		System.out.println(trElements.size());
		// 定义临时变量
		WebElement tempElement = null;
		WebElement pElement = null;
		// 循环每一行的数据，从中查找出部署的应用所在的tr元素
		for (WebElement tr : trElements) {
			// System.out.println(tr.getSize());
			System.out.println(tr.getText());
			// 根据tr元素中是否含有应用的名称来确定需要更新的应用
			if (tr.getText().contains(text)) {
				// 若找到所需要更新的应用，则将此tr的第一个td赋值给临时变量
				tempElement = tr.findElement(By.tagName("td"));
				System.out.println("查询到需要更新的应用！");

				// 查找到td中的单选框
				pElement = tr.findElement(By.className("radioAndCheckbox"));
				// 选中单选框
				pElement.click();
				if (text == "准备就绪") {
					return true;
				}
				break;
			}
		}
		return false;
	}

}
