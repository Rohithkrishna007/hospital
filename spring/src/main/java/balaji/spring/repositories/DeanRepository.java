package balaji.spring.repositories;

import balaji.spring.entities.Dean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeanRepository extends JpaRepository<Dean,Integer>{
}
