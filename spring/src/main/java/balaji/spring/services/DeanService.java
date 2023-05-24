package balaji.spring.services;

import balaji.spring.entities.Dean;
import balaji.spring.repositories.DeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeanService {

    @Autowired
    private DeanRepository deanRepo;

    public Dean getDeanById(Integer id) {
            return deanRepo.findById(id).orElse(null);
        }
    }

