package ASOserver.springapp.dao;

import ASOserver.model.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionDAO extends CrudRepository<Promotion, Long> {
}
