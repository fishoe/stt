package sample.study.stt.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import sample.study.stt.Data.Name;

public interface NameRepo extends Repository<Name, Long>{
    List<Name> findAll();
    Optional<Name> findByName(String Name);

    void save(Name name);
}
