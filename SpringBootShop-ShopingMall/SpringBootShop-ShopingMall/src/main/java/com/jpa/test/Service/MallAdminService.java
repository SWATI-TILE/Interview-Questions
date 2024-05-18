package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.MallAdmin;
import com.jpa.test.Repository.MallAdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallAdminService {
	
	@Autowired
	MallAdminRepository repo; 
	
	//save
		public MallAdmin addrecord(MallAdmin s) {
			
			return repo.save(s);
		}
		
		//Select all
		public List<MallAdmin> getAllMallAdmin() {
			return repo.findAll();
		}
		
		//Select ById
		public MallAdmin getMallAdminByid(int sid) {
			MallAdmin e = null;
			 try {
				Optional<MallAdmin> sitem =repo.findById(sid);
				 if(sitem.isPresent())
				 {
					 return sitem.get();
				 }
				
			 }
			 catch(NoSuchElementException excep)
			 {
				 System.out.println("No such record found");
			 }
			 
			 return e;
		}
		
		//Delete BYId
		public String deleterecord(int sid) {
			
			MallAdmin s = getMallAdminByid(sid);
			if(s==null)
			{
				return "Record is not found";
			}
			else
			{
			repo.deleteById(sid);
			return "Record is deleted";
			}
		} 
		
		//update
		public String updateMallAdminRecordById(int sid, MallAdmin e)
		{
			MallAdmin sitem = getMallAdminByid(sid);
			if(sitem == null)
			{
				return "MallAdmin record is not found for updation...";
			}
			else
			{
				repo.save(e);
				return "MallAdmin record is Updated";
			}
			
		}

}
