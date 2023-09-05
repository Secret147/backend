package phone2.entity;

import javax.persistence.Column;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class productEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String memory;
	
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	
	private String img;
	
	private Long price;
	
	private String type;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
    private List<cartEntity> carts = new ArrayList<>();
    
    @OneToMany(mappedBy = "productbill")
	@JsonIgnore
    private List<billdetailEntity> billdetails = new ArrayList<>();
    
    

}
