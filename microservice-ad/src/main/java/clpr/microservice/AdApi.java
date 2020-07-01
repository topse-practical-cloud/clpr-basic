package clpr.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.logstash.logback.argument.StructuredArguments.v;

import java.util.Random;

@SpringBootApplication
@RestController
public class AdApi extends SpringBootServletInitializer {
	Logger log;

	public static void main(String[] args) {
		SpringApplication.run(AdApi.class, args);
	}
	@GetMapping("/ad/user/{userId}")
	public Ad getPersonalizedAd(@PathVariable("userId") String userId) {
		log = LoggerFactory.getLogger(AdApi.class);
		long startTime = System.currentTimeMillis();

		Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(20)); 
		} catch (InterruptedException e) {
		}

		Ad ad;
		String ignoreUser = "user03@example.com";
		if(userId.equals(ignoreUser)){
			ad = new Ad("","");
		}else{
			ad = new Ad("/product/7153A3AB", userId+"様　いつもご利用ありがとうございます。前回ご購入いただいた商品が食べ終わることだと思います。再度ご購入いたかがでしょうか。");
		}
		long responseTime = System.currentTimeMillis() - startTime;
		log.info("request processed",v("ResponseTime", responseTime));
		return ad;
	}

	@GetMapping("/ad/anonymous")
	public Ad getAnonymousAd() {
		log = LoggerFactory.getLogger(AdApi.class);
		long startTime = System.currentTimeMillis();
		
		
		Random rand = new Random();
		try {
			Thread.sleep(1000+rand.nextInt(20)); 
		} catch (InterruptedException e) {
		}
		
		long responseTime = System.currentTimeMillis() - startTime;
		log.info("request processed",v("ResponseTime", responseTime));
		return new Ad("/product/20712D70","今SNSで話題沸騰中の人気マグカップが数量限定で入荷中");
	}
}
