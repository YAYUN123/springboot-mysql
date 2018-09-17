package json.example.repository;

import json.example.entity.Qas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QasRepository extends JpaRepository<Qas, Long> {
      //Qas findByImage_id(Long Image_id);
//    Qas findByQa_id(Long Qa_id);

}
