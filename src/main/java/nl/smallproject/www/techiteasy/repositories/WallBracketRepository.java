package nl.smallproject.www.techiteasy.repositories;

import nl.smallproject.www.techiteasy.models.WallBracket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallBracketRepository extends JpaRepository<WallBracket, Long> {
}
