package com.example.demo.service2;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity2.Product;
import com.example.demo.entity2.WishList;
import com.example.demo.entity2.WishListItem;
import com.example.demo.repository2.WishListItemRepository;
import com.example.demo.repository2.WishListRepository;

@Service
public class WishListService2 {
	
	@Autowired
	private WishListRepository wishListRepository;
	@Autowired
	private WishListItemRepository wishListItemRepository;
	@Autowired
	private ProductService2 productService;
	
	public WishList addToWishFirstTime(Long id, String sessionToken) {
		WishList wishlist = new WishList();
		WishListItem item = new WishListItem();
		
		item.setDate(new Date());
		item.setProduct(productService.getProductById(id));
		wishlist.getItems().add(item);
		wishlist.setSessionToken(sessionToken);
		wishlist.setDate(new Date());
		return wishListRepository.save(wishlist);

	}

	public WishList addToExistingWishList(Long id, String sessionToken) {

		WishList wishList = wishListRepository.findBySessionToken(sessionToken);
		Product p = productService.getProductById(id);
		Boolean productDoesExistInTheCart = false;
		if (wishList != null) {
		    Set<WishListItem> items = wishList.getItems();
			for (WishListItem item : items) {
				if (item.getProduct().equals(p)) {
					productDoesExistInTheCart = true;
					break;  
				}
				
			}
		}
		if(!productDoesExistInTheCart && (wishList != null))
		{
			WishListItem item1 = new WishListItem();
			item1.setDate(new Date());
			item1.setProduct(p);
			wishList.getItems().add(item1);
			return wishListRepository.saveAndFlush(wishList);
		}
		
		return null;

	}

	public WishList getWishListBySessionTokent(String sessionToken) {
		
		return  wishListRepository.findBySessionToken(sessionToken);
	}

	
	public WishList removeItemWishList(Long id, String sessionToken) {
		WishList WishList = wishListRepository.findBySessionToken(sessionToken);
		Set<WishListItem> items = WishList.getItems();
		WishListItem item = null;
		for(WishListItem item1 : items) {
			if(item1.getId()==id) {
				item = item1;
			}
		}
		items.remove(item);
		wishListItemRepository.delete(item);
	    WishList.setItems(items);
	    return wishListRepository.save(WishList);
	}

	public void clearWishList(String sessionToken) {
		WishList sh = wishListRepository.findBySessionToken(sessionToken);
		wishListRepository.delete(sh);
		
	}
	

}
