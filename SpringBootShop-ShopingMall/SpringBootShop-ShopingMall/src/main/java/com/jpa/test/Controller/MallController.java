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


import com.jpa.test.Entity.MallEntity;
import com.jpa.test.Service.MallService;

@RestController
@EntityScan("com.jpa.test.Entity")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class MallController {
	
	@Autowired
	MallService service;
	
	@PostMapping("/SaveMall")
	public int saveMallDetails(@RequestBody MallEntity m)
	{
		
		service.AddRecord(m);
		return 0;
	}
	
	//show all records
		@GetMapping("/Malls")
		public List<MallEntity> getAllMallsDetails()
		{
			return service.getAllMallRecords();
		}
		
		//show only one record using id
		@GetMapping("/Mall/{id}")
		public MallEntity getMallRecordUsingId(@PathVariable int id)
		{
			MallEntity m1 = service.getMallRecordById(id);
			return m1;
		}
		
		//delete only one record using id
		@DeleteMapping("/MAllRecordDelete/{id}")
		public String deleteMallRecord(@PathVariable int id)
		{
			return service.deleteMallRecordById(id);
			
		}
		
		//update one record using id 
		@PutMapping("/MallRecordUpdate/{id}")
		public String updateMallRecord(@PathVariable int id,@RequestBody MallEntity m)
		{
			return service.updateMallRecordById(id, m);
			
		}
		
	

}
