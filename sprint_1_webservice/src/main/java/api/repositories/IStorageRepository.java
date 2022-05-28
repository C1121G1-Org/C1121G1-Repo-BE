package api.repositories;

import api.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStorageRepository extends JpaRepository<Storage, Long> {
}
