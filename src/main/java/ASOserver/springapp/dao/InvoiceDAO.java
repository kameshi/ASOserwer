package ASOserver.springapp.dao;

import ASOserver.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDAO extends CrudRepository<Invoice, Long> {
}
