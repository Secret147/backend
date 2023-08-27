package phonesale.service.impl;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import phonesale.converter.productConverter;
import phonesale.dto.productDTO;
import phonesale.entity.cartEntity;
import phonesale.entity.customerEntity;
import phonesale.entity.productEntity;
import phonesale.repository.cartRepository;
import phonesale.repository.customerRepository;
import phonesale.repository.productRepository;
import phonesale.service.productService;

@Service
public class productServiceImpl implements productService {

	@Autowired
	private productRepository productRe;
	
	@Autowired
	private productConverter productCo;
	
	@Autowired
	private customerRepository customerRe;
	
	@Autowired
	private cartRepository cartRe;
 
	@Override
	public List<productDTO> findAllPage(Pageable pageble){
		List<productDTO> results = new ArrayList<>();
		List<productEntity> entities = productRe.findAll(pageble).getContent();
		for ( productEntity item : entities) {
			productDTO product = productCo.toproductDTO(item);
			results.add(product);
		}
		return results;
	}
	
	@Override
	public List<productEntity> searchProducts(String keyword) {
        String normalizedKeyword = StringUtils.hasText(keyword) ? normalizeText(keyword) : "";
        List<productEntity> allProductnull = new ArrayList<>();
        List<productEntity> allProducts = productRe.findAll();
        if(keyword != "") {
        return allProducts.stream()
                .filter(product -> normalizeText(product.getName()).contains(normalizedKeyword))
                .collect(Collectors.toList());
        }
        else {
        	return allProductnull;
        }
    }
    
    private String normalizeText(String text) {
        return StringUtils.hasText(text) ? Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase() : "";
    }
    
    @Override
    public List<productDTO> findByType(String type){
    	List<productEntity> products = productRe.findByType(type);
    	List<productDTO> productDTOs = new ArrayList<>();
    	for(productEntity product: products) {
    		productDTOs.add(productCo.toproductDTO(product));
    	}
    	return productDTOs;
    }
    
    @Override
    public List<productDTO> findAll(){
    	List<productEntity> products = productRe.findAll();
    	List<productDTO> productDTOs = new ArrayList<>();
    	for(productEntity product: products) {
    		productDTOs.add(productCo.toproductDTO(product));
    	}
    	return productDTOs;
    }
    
    @Override
    public productDTO findById(Long id) {
    	productEntity product = productRe.findById(id).get();
    	return productCo.toproductDTO(product);
    }
    
    @Override
    public void saveCart(String username, Long productId) {
    	customerEntity customer = customerRe.findByName(username);
		productEntity product = productRe.findById(productId).get();
		cartEntity cart = cartRe.findByProduct_Id(product.getId());
		if (cart != null) {
			cart.setQuantity(cart.getQuantity() + 1);
			cartRe.save(cart);
		} else if (cart == null) {
			cartEntity cart2 = new cartEntity();
			cart2.setCustomer(customer);
			cart2.setProduct(product);
			cart2.setQuantity(1);
			cartRe.save(cart2);
		}
    }
    
    @Override
    public void save(productDTO product) {
    	productRe.save(productCo.toproductEntity(product));
    }
    
    @Override
    public void delete(Long id) {
    	productEntity product = productRe.findById(id).get();
		productRe.delete(product);
    }

}


