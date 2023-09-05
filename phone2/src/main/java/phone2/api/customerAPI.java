package phone2.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phone2.dto.customerDTO;
import phone2.entity.customerEntity;
import phone2.repository.customerRepository;
import phone2.service.customerService;

@RestController
@CrossOrigin
public class customerAPI {
	@Autowired
	private customerRepository customerRe;

	@Autowired
	private customerService customerSe;

	@PostMapping("/customer/new")
	public ResponseEntity<?> addUser(@RequestBody customerDTO customer) {
		if (customerSe.check(customer) == 0) {
			return ResponseEntity.badRequest().body("Tài khoản đã tồn tại");
		} else if (customer.getPassword().length() < 6) {
			return ResponseEntity.badRequest().body("Mật khẩu phải có ít nhất 6 kí tự");
		} else {
			customerSe.save(customer);
			return ResponseEntity.ok(customer);
		}
	}
	@PostMapping("/customer")
	public ResponseEntity<?> login(@RequestBody customerDTO model, HttpSession session) {
		if (customerSe.check(model) == 0) {
			customerDTO customer = customerSe.findByName(model.getName());
			if (customer.getName().equals(model.getName()) && customer.getPassword().equals(model.getPassword())) {
				session.setAttribute("id_user", customer.getId());
				return ResponseEntity.ok(customer.getRole());
			}
			else if(customer.getName().equals(model.getName()) && !customer.getPassword().equals(model.getPassword())) {
				return ResponseEntity.badRequest().body("Mật khẩu không chính xác");
			}
		}	
			return ResponseEntity.badRequest().body("Tài khoản chưa được đăng ký. Vui lòng thực hiện việc đăng ký trước khi đăng nhập");
	}

	@PutMapping("/customer/new")
	public ResponseEntity<?> editCustomer(@RequestBody customerDTO customer) {
		customerSe.save(customer);
		return ResponseEntity.ok(null);
	}

	@PostMapping("/customer/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.removeAttribute("id_user");
		return ResponseEntity.ok(null);

	}

	@GetMapping("/customer/new")
	public List<customerDTO> getUser() {
		List<customerDTO> customers = customerSe.findAll();
		return customers;
	}
	

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
		customerDTO customer = customerSe.findById(id);
		return ResponseEntity.ok(customer);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		customerDTO customer = customerSe.findById(id);
		customerSe.delete(customer);
		return ResponseEntity.ok(null);
	}

}