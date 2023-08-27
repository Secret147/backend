package phonesale.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class customerDTO {

    private Long id;
	
	private String name;
	
	private String password;
	
	private String number;
	
	private String address;
	
	private Date birth;
	
	private int role;

}
