package nl.smallproject.www.techiteasy.repositories;

import nl.smallproject.www.techiteasy.models.CiModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiModuleRepository extends JpaRepository<CiModule, Long> {
}
