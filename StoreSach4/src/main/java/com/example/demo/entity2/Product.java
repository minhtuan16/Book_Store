package com.example.demo.entity2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	
	private Double price;
	
	private int quantity;
	
	private String brand;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Coupon discount;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_category", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
	private Set<Category> categories = new HashSet<Category>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id") 
	private Set<Carousel> carousel;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Review> review; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_thuongHieu", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "thuongHieu_id", referencedColumnName = "id")})
	private Set<ThuongHieu> thuongHieus = new HashSet<ThuongHieu>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_kichThuoc", joinColumns = { 
			@JoinColumn(name = "product_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "kichThuoc_id", referencedColumnName = "id")})
	private Set<KichThuoc> kichThuocs = new HashSet<KichThuoc>();
	 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_gioiTinh", joinColumns = { 
			@JoinColumn(name = "product_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "gioiTinh_id", referencedColumnName = "id")})
	private Set<GioiTinh> gioiTinhs = new HashSet<GioiTinh>();
	 
	@Override
	public int hashCode() { 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode()) ;
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		
		if(id == null) {
			if(other.id != null) 
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if(name == null) {
			if(other.name != null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [id = " + id + " , name = " + name + " ]";
	}
}
