//package com.example.demo.entity;
//
//import java.util.Collection;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//@Entity
//@Table(name = "categories")
//@Data
//public class Category {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@Column(unique = true)
//	@NotEmpty(message = "{category.names.notempty}") 
//	private String nameCategory;
//	
////	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
////    // MapopedBy trỏ tới tên biến Address ở trong Person.
////    private Collection<Book> books;
//}