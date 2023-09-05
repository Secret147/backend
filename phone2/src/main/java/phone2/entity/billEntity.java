package phone2.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class billEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createAt;
	
	private String address;
	
	private String name;
	
	private String numberphone;
	
	private String email;
	
	private String method;
	
	private String note;
    
	private String bill;
	
	private Long totalprice;
	
    

	@PrePersist
    protected void onCreate() {
        createAt = new Date();
    }
    
    @OneToMany(mappedBy = "bill")
	@JsonIgnore
    private List<billdetailEntity> billdetails = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customerEntity customerbill;

}
