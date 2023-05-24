package balaji.spring.services;

import balaji.spring.entities.Dean;
import balaji.spring.repositories.DeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.ContentHandler;

@Service
public class DeanService {

    @Autowired
    private DeanRepository deanRepo;

    public Dean getDeanById(Integer id) {
            return deanRepo.findById(id).orElse(null);
        }

    public Page<Dean> getAllDeansSortedById(Pageable pageable) {
        return deanRepo.findAll(pageable);
    }
}

