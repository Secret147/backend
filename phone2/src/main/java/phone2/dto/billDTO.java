package phone2.dto;

import java.util.Date;

import lombok.Data;

@Data
public class billDTO {

	private Long id;

	private Date createAt;

	private String address;

	private String name;

	private String numberphone;

	private String email;

	private String method;

	private String note;

	private String bill;

	private Long totalprice;

}
