package phonesale.dto;

import lombok.Data;

@Data
public class productDTO {

    private Long id;
	
	private String name;
	
	private String memory;
	
	private String description;
	
	private String img;
	
	private Long price;
	
	private String type;

}
