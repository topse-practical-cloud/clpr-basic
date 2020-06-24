package clpr.onlinestore;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Controller
public class OnlinestoreApplication extends SpringBootServletInitializer {
	@Autowired
	OrderService orderservice;

	@Autowired
	ProductService productService;

	@Autowired
	SkuService skuService;

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreApplication.class, args);
	}
	@GetMapping("/")
	public String index(@RequestParam(name = "name", defaultValue = "World") String name, Model model) {
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
		return "index";
	}
	@GetMapping(path="/product/{productId}")
    public String showProduct(@PathVariable("productId") String productId, Model model) {
		ProductCatalog pc = productService.getProductById(productId);
		List<Sku> skus = skuService.getSkuByProductId(productId);
		model.addAttribute("productCatalog", pc);
		model.addAttribute("skus", skus);
        return "product";
	}
	@GetMapping(path="/order/{sku}")
    public String sendOrder(@PathVariable("sku") String sku, Model model) {
		OrderHistory orderhistory = orderservice.sendOrder(sku);
		model.addAttribute("orderhistory", orderhistory);
		return "order";	
    }
}
