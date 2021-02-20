package be.dhofief.farmwatchbackend.repository;

import be.dhofief.farmwatchbackend.entity.Appel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelRepository extends JpaRepository<Appel, String> {

}
