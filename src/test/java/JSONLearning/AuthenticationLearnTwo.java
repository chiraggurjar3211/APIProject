package JSONLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AuthenticationLearnTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		Thread.sleep(3000);
		driver.findElement(By.id("identifierId")).sendKeys("chiraggurjar2691@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name=\"Passwd\"]")).sendKeys("Cc_9033207186");
		Thread.sleep(2000);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(4000);
//		driver.findElement(By.xpath("(//*[@jsname=\"LgbsSe\"])[2]")).click();
		Thread.sleep(4000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String[] urlsplit=url.split("&");
		String[] urlsplitwithEqual=urlsplit[0].split("=");
		String code=urlsplitwithEqual[1];
		System.out.println(code);
		
		//AccessToken get URL
		String getAccessTokenUrl="https://www.googleapis.com/oauth2/v4/";
		String responseAccessKey=given().baseUri(getAccessTokenUrl)
				.urlEncodingEnabled(false).queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
//		.queryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
//		.queryParam("response_type", "code")
//		.queryParam("authuser", "1")
//		.queryParam("prompt", "consent")
		.log().all().when().post("token").asString();
		System.out.println(responseAccessKey);
		JsonPath json=new JsonPath(responseAccessKey);
		String accessTOken=json.getString("access_token");
		
		//Main get Course URL
		String getCourseUrl="https://rahulshettyacademy.com/";
		String course=given().baseUri(getCourseUrl)
				.urlEncodingEnabled(false).
				queryParam("access_token", accessTOken).log().all().when().post("getCourse.php").asString();
		System.out.println(course);
	}

}
