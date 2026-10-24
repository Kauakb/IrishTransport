package com.ca.transport.repository;

import com.ca.transport.model.Transport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransportRepository extends MongoRepository<Transport, String> {
    List<Transport> findByStatus(String status);
    List<Transport> findByStopType(String stopType);
    List<Transport> findByLocality(String locality);
    Page<Transport> findByCommonNameContainingIgnoreCase(String name, Pageable pageable);
}