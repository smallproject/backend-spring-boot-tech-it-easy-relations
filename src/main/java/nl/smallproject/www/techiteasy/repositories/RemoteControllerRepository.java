package nl.smallproject.www.techiteasy.repositories;

import nl.smallproject.www.techiteasy.models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RemoteControllerRepository extends JpaRepository<RemoteController, Long> {
}
