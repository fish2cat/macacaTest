package macaca.client;
import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;

// API doc https://macacajs.github.io/wd.java/
/**
 * 
 * @ClassName:  DesktopSampleTest   
 * @Description:TODO   
 * @author: 山东工商学院软件工程专业 
 * @date:   2019年7月2日 上午8:36:21   
 *     
 * @Copyright: 2019 www.sdtbu.edu.cn All rights reserved.
 */
public class DesktopSampleTest {

    MacacaClient driver = new MacacaClient();

    @Before
    public void setUp() throws Exception {

		/*
           Desired Capabilities are used to configure webdriver when initiating the session.
           Document URL: https://macacajs.github.io/desired-caps.html
         */
        JSONObject porps = new JSONObject();
        porps.put("browserName", "electron");
        porps.put("platformName", "desktop");
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);        
        driver.initDriver(desiredCapabilities).setWindowSize(1280, 800)         
        .get("http://localhost:8080/JspWeb/index.jsp");
    }

    @Test
    public void testCaseOne() throws Exception {        
    	driver
    	.elementById("username")
    	.sendKeys("yulp");
    	driver.sleep(1000);
    	driver    	
    	.elementById("password")
    	.sendKeys("123456");
    	driver.sleep(1000);       
        driver
        .elementById("login")
        .click();
        driver.sleep(3000);

        String html = driver.source();                
        Assert.assertThat(html, containsString("success"));        
        driver.takeScreenshot();
    }   
    @Test
    public void testCaseTwo() throws Exception {        
    	driver
    	.elementById("username")
    	.sendKeys("yulp");
    	driver.sleep(1000);
    	driver    	
    	.elementById("password")
    	.sendKeys("111");
    	driver.sleep(1000);       
        driver
        .elementById("login")
        .click();
        driver.sleep(3000);

        String html = driver.source();                
        Assert.assertThat(html, containsString("不合法用户"));        
        driver.takeScreenshot();
    }   

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }    
}

