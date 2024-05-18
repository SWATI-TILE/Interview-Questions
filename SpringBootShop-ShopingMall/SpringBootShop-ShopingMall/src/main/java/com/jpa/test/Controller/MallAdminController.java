package com.jpa.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entity.MallAdmin;
import com.jpa.test.Service.MallAdminService;

@RestController
@EntityScan("com.jpa.test.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class MallAdminController {
	
	@Autowired
	MallAdminService service;
	
	//save
		@PostMapping("/SaveMallAdmin")
		public MallAdmin saveMallAdmin(@RequestBody MallAdmin s) {		
			service.addrecord(s);
			return s;
		}
		
		
		//show all record
		@GetMapping("/MallAdmins")
		public List<MallAdmin> getAllMallAdmin()
		{
			return service.getAllMallAdmin();
		}
		
		
		@GetMapping("/MallAdmin/{id}")
		public MallAdmin getMallAdmin(@PathVariable int id) {
			
			MallAdmin s1 = service.getMallAdminByid(id) ;
			return s1;
		}
		
		@DeleteMapping("/DeleteMallAdmin/{id}")
		public String deleterecord(@PathVariable int id) {
			
			return service.deleterecord(id) ;
			
		}
		
		@PutMapping("UpdateMallAdmin/{id}")
		public String putMethodName(@PathVariable int id, @RequestBody MallAdmin s) {
			
			
			return service.updateMallAdminRecordById(id, s);
		}

}
