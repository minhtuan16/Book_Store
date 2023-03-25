package com.example.demo.service2;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity2.Carousel;
import com.example.demo.entity2.Category;
import com.example.demo.entity2.Coupon;
import com.example.demo.entity2.GioiTinh;
import com.example.demo.entity2.KichThuoc;
import com.example.demo.entity2.Product;
import com.example.demo.entity2.ThuongHieu;
import com.example.demo.repository2.CategoryRepository;
import com.example.demo.repository2.CouponRepository;
import com.example.demo.repository2.GioiTinhRepository;
import com.example.demo.repository2.KichThuocRepository;
import com.example.demo.repository2.ProductRepositry;
import com.example.demo.repository2.ThuongHieuRepository;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ProductService2 {
	@Autowired
	private ProductRepositry productRepo;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ThuongHieuRepository thuongHieuRepository;
	
	@Autowired
	private KichThuocRepository kichThuocRepository;
	
	@Autowired
	private GioiTinhRepository gioiTinhRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	public void  saveProductToDB(MultipartFile file,String name,String description,int quantity
			,Double price,String brand, String categories, String thuongHieus, String kichThuocs, String gioiTinhs)
	{
		Product p = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);
		
        p.setName(name);
        p.setPrice(price);
        p.setBrand(brand);
        p.setQuantity(quantity);
        
        Coupon c = new Coupon();
        c.setDiscount(0);
        p.setDiscount(c);
        p = addCategoriesToProduct(p,categories);
        p = addThuongHieusToProduct(p,thuongHieus);
        p = addKichThuocsToProduct(p, kichThuocs);
        p = addGioiTinhsToProduct(p, gioiTinhs);
        productRepo.save(p);
	}
	private Product addCategoriesToProduct(Product p ,String categories) {
		String [] cates = categories.split(",");
		Category category = null;
		for(String str : cates) {
		    category = categoryRepository.findById(Long.parseLong(str)).get();
		    p.getCategories().add(category);
		}
		return p;
	}
	
	private Product addThuongHieusToProduct(Product p, String thuongHieus) {
		String [] thuong_Hieus = thuongHieus.split(",");
		ThuongHieu thuongHieu = null;
		for(String str : thuong_Hieus) {
			thuongHieu = thuongHieuRepository.findById(Long.parseLong(str)).get();
		    p.getThuongHieus().add(thuongHieu);
		}
		return p;
	}
	
	private Product addKichThuocsToProduct(Product p, String kichThuocs) {
		String [] kich_Thuocs = kichThuocs.split(",");
		KichThuoc kichThuoc = null;
		for(String str : kich_Thuocs) {
			kichThuoc = kichThuocRepository.findById(Long.parseLong(str)).get();
		    p.getKichThuocs().add(kichThuoc);
		}
		return p;
	}
	
	private Product addGioiTinhsToProduct(Product p, String gioiTinhs) {
		String [] gioi_Tinhs = gioiTinhs.split(",");
		GioiTinh gioiTinh = null;
		for(String str : gioi_Tinhs) {
			gioiTinh = gioiTinhRepository.findById(Long.parseLong(str)).get();
		    p.getGioiTinhs().add(gioiTinh);
		}
		return p;
	}
	
	public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id);
    }
    public void chageProductName(Long id ,String name)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setName(name);
    	productRepo.save(p);    
    }
    public void changeProductDescription(Long id , String description)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
    public void changeProductPrice(Long id,Double price)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setPrice(price);
    	productRepo.save(p);
    }
    
    public Category saveCategory(Category category) {
    	 return categoryRepository.save(category);
    }
    
	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
	}
	
	public ThuongHieu saveThuongHieu(ThuongHieu thuongHieu) {
    	 return thuongHieuRepository.save(thuongHieu);
    }
    
	public List<ThuongHieu> getAllThuongHieus() {
		
		return thuongHieuRepository.findAll();
	}
	
	public KichThuoc saveKichThuoc(KichThuoc kichThuoc) {
   	 	return kichThuocRepository.save(kichThuoc);
	}
   
	public List<KichThuoc> getAllKichThuocs() {
		
		return kichThuocRepository.findAll();
	}
	
	public GioiTinh saveGioiTinh(GioiTinh gioiTinh) {
   	 	return gioiTinhRepository.save(gioiTinh);
	}
   
	public List<GioiTinh> getAllGioiTinhs() {
		
		return gioiTinhRepository.findAll();
	}
	
	public void addImageToProduct(MultipartFile file, Long id) {
		
       Product p = productRepo.findById(id).get();
       Carousel carousel = new Carousel();
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			carousel.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
		} catch (IOException e) {
			e.printStackTrace();
		}
         p.getCarousel().add(carousel);
         productRepo.save(p);
       
	}
	public void changeProductQuantity(Long id, int quantity) {
		Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setQuantity(quantity);
    	productRepo.save(p);
		
	}
	public void saveProductDicount(Long id, int discount) {
		Product p = new Product();
    	p = productRepo.findById(id).get();
    	if(p.getDiscount() == null) {
    		Coupon c = new Coupon();
        	c.setDiscount(discount);
        	p.setDiscount(c);
    	}
    	
    	else {
    		p.getDiscount().setDiscount(discount);
    	}
    	productRepo.save(p);
		
	}
	public void changeProductDiscount(Long id, int discount) {
		Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.getDiscount().setDiscount(discount);
    	productRepo.save(p);
		
	}
	
	// No API
	public String resizeImageForUse(String src,int width, int height) {
		BufferedImage image = base64ToBufferedImage(src);
		try {
			image = resizeImage(image, width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return bufferedImageTobase64(image);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private  BufferedImage resizeImage(BufferedImage image , int width , int height) throws IOException {
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		try {
			Thumbnails.of(image).size(width, height).outputFormat("JPEG").outputQuality(1).toOutputStream(outputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] data = outputstream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		return ImageIO.read(inputStream);
	}
	private BufferedImage base64ToBufferedImage(String base64Img) {
		BufferedImage image = null;
		byte[] decodedBytes = Base64.getDecoder().decode(base64Img);
		
		try {
			image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	private String bufferedImageTobase64(BufferedImage image ) throws UnsupportedEncodingException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", Base64.getEncoder().wrap(out));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toString(StandardCharsets.ISO_8859_1.name());
	}
	public Product getProductById(Long id) {
		
		return productRepo.findById(id).get();
	}
	public List<Product> searchProductByNameLike(String value) {
		
		return productRepo.findByNameContainingIgnoreCase(value);
	}
	
	
	public List<String> getAllBrands() {
		// TODO Auto-generated method stub
		return productRepo.findAllBrandsDistincts();
	}
	public Product getProductWithBigestDiscount() {
		Coupon discount = couponRepository.findMax();
		List<Product> products = productRepo.findAll();
		Product featuredProduct = null;
		for(Product p : products) {
			if(p.getDiscount().equals(discount)) {
				featuredProduct = p;
				break;
			}
		}
		return featuredProduct;
	}
	
	
}
