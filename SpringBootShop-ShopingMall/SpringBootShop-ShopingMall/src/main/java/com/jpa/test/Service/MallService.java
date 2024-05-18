package com.jpa.test.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.MallEntity;
import com.jpa.test.Repository.MallRepository;

@Service
public class MallService {
	
	@Autowired
	MallRepository repo;
	
	public MallEntity AddRecord(MallEntity m)
	{
		return repo.save(m);
	}
	
	public List<MallEntity> getAllMallRecords()
	{
		return repo.findAll();
	}
	
	public MallEntity getMallRecordById(int mid)
	{
		 MallEntity m = null;
		 try {
			 Optional<MallEntity> mall =repo.findById((long) mid);
			 if(mall.isPresent())
			 {
				 return mall.get();
			 }
			
		 }
		 catch(NoSuchElementException excep)
		 {
			 System.out.println("No such record found");
		 }
		 
		 return m;
	}
	
	public String deleteMallRecordById(int mid)
	{
		MallEntity m = getMallRecordById(mid);
		if(m==null)
		{
			return "Record is not found";
		}
		else
		{
		repo.deleteById((long) mid);
		return "Record is deleted";
		}
	}
	
	public String updateMallRecordById(int mid, MallEntity m)
	{
		MallEntity mall = getMallRecordById(mid);
		if(mall== null)
		{
			return "Mall record is not found for updation...";
		}
		else
		{
			repo.save(m);
			return "Mall record is Updated";
		}
		
	}

}
