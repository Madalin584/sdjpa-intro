package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Integer> {
}
