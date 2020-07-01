package clpr.onlinestore;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.logstash.logback.argument.StructuredArguments.v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@Controller
public class OnlinestoreApplication extends SpringBootServletInitializer {
	@Autowired
	OrderService orderservice;

	@Autowired
	ProductService productService;

	@Autowired
	SkuService skuService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${clpr.endpoint.ad}")
	private String adSrvEndpoint;

	Logger log;

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/")
	public String index(Model model) {
		log = LoggerFactory.getLogger(OnlinestoreApplication.class);
		long startTime = System.currentTimeMillis();

		List<ProductCatalog> productCatalogs = productService.getFeaturedProduct();
		List<ProductCatalog> tempResult = new ArrayList<ProductCatalog>();
		List<List<ProductCatalog>> productsInRow = new ArrayList<List<ProductCatalog>>();
		for(int i = 0; i < productCatalogs.size(); i++){
			tempResult.add(productCatalogs.get(i));
			if (i % 3 == 2){
				productsInRow.add(tempResult);
				tempResult = new ArrayList<ProductCatalog>();
			}
		}
		model.addAttribute("productsInRow", productsInRow);
		//TODO uncomment below lines in practice 3-4
		/*
		List<String> sampleUsers = new ArrayList<String>(Arrays.asList("user01@example.com", "user02@example.com", "user03@example.com"));
		Random rand = new Random();
		String sampleUserId = sampleUsers.get(rand.nextInt(sampleUsers.size()));
		Ad ad = restTemplate.getForObject(
				adSrvEndpoint+"/ad/user/"+sampleUserId, Ad.class);
		if(ad.getRedirectUrl() == ""){
			ad = restTemplate.getForObject(
				adSrvEndpoint+"/ad/anonymous", Ad.class);
		}
		model.addAttribute("ad", ad);
		*/
		long responseTime = System.currentTimeMillis() - startTime;
		log.info("request processed",v("ResponseTime", responseTime));
		return "index";
	}
	@GetMapping(path="/product/{productId}")
    public String showProduct(@PathVariable("productId") String productId, Model model) {
		log = LoggerFactory.getLogger(OnlinestoreApplication.class);
		long startTime = System.currentTimeMillis();

		ProductCatalog pc = productService.getProductById(productId);
		List<Sku> skus = skuService.getSkuByProductId(productId);
		model.addAttribute("productCatalog", pc);
		model.addAttribute("skus", skus);

		long responseTime = System.currentTimeMillis() - startTime;
		log.info("request processed",v("ResponseTime", responseTime));
		return "product";
	}
	@GetMapping(path="/order/{sku}")
    public String sendOrder(@PathVariable("sku") String sku, Model model) {
		log = LoggerFactory.getLogger(OnlinestoreApplication.class);
		long startTime = System.currentTimeMillis();

		OrderHistory orderhistory = orderservice.sendOrder(sku);
		model.addAttribute("orderhistory", orderhistory);

		long responseTime = System.currentTimeMillis() - startTime;
		log.info("request processed",v("ResponseTime", responseTime));
		return "order";	
    }
}
