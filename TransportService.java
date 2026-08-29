package com.ca.transport.service;

import com.ca.transport.model.Transport;
import com.ca.transport.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class TransportService {

	@Autowired
	private TransportRepository transportRepository;
	
	//get all
	  public List<Transport> getAllTransports() {
	        return transportRepository.findAll();
	    }
	
	  //get  by id
	    public Optional<Transport> getTransportById(String id) {
	        return transportRepository.findById(id);
	    }
	    
	    //create
	    public Transport saveTransport(Transport transport) {
	        return transportRepository.save(transport);
	    }
	    
	    //update
	    public Transport updateTransport(Transport transport) {
	        return transportRepository.save(transport);
	    }

	    //delete
	     public void deleteTransport(String id) {
	    	 transportRepository.deleteById(id);
	     }
	     
	     //search by status
	     public List<Transport> getByStatus(String status) {
	    	 return transportRepository.findByStatus(status);
	     }
	     
	     //search by locality
	     public List<Transport> getByLocality(String locality) {
	    	 return transportRepository.findByLocality(locality); 
	     }
	     public Page<Transport> getAllTransports(Pageable pageable) {
	    	    return transportRepository.findAll(pageable);
	     }
}
