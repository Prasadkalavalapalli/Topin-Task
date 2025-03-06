package com.topin.www.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topin.www.dto.TopinDto;
import com.topin.www.model.Topin;
import com.topin.www.model.TopinUpdates;
import com.topin.www.repo.TopinRepo;
import com.topin.www.repo.TopinupdateRepo;

@Service
public class TopinService {

    @Autowired
    TopinRepo repo;

    @Autowired
    TopinupdateRepo repo2;

    @Autowired
    private ModelMapper modelmapper;

    public ResponseEntity<String> createUser(TopinDto dto) {
        Topin topin = modelmapper.map(dto, Topin.class);
        TopinUpdates topinupdates = new TopinUpdates();
        
        if (topin != null) {
            repo.save(topin);
            topinupdates.setId(topin.getId());
            topinupdates.setCreatedAt(new Date());
            topinupdates.setUpdatedAt(null);
            topinupdates.setStatus("Active");
            repo2.save(topinupdates);
            return ResponseEntity.status(200).body("User created successfully");
        } else {
            return ResponseEntity.status(500).body("Sorry...! User not created");
        }
    }

    public ResponseEntity<?> getUsers() {
        List<Topin> topindata = repo.findAll();
        if (!topindata.isEmpty()) {
            return ResponseEntity.status(200).body(topindata);
        } else {
            return ResponseEntity.status(204).body("Topin is Empty"); 
        }
    }

    public ResponseEntity<String> deleteUser(Long id) {
        Optional<Topin> topin = repo.findById(id);
        TopinUpdates topinupdates = new TopinUpdates();

        if (topin.isPresent()) {
            topinupdates.setId(id);
            topinupdates.setCreatedAt(new Date());
            topinupdates.setUpdatedAt(null);
            topinupdates.setStatus("Not Active");
            repo2.save(topinupdates);
            repo.deleteById(id);
            return ResponseEntity.status(200).body("User Deleted successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    public ResponseEntity<String> updateUser(TopinDto dto, Long id) {
        Optional<Topin> topin = repo.findById(id);
        TopinUpdates topinupdates = new TopinUpdates();

        if (topin.isPresent()) {
            Topin updatedTopin = modelmapper.map(dto, Topin.class);
            updatedTopin.setId(id);
            repo.save(updatedTopin);
            
            topinupdates.setId(id);
            topinupdates.setCreatedAt(new Date());
            topinupdates.setUpdatedAt(new Date());
            topinupdates.setStatus("Updated");
            repo2.save(topinupdates);
            
            return ResponseEntity.status(200).body("User Updated Successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
