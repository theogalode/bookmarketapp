package fr.mds.theogalode.bookmarketapp.repository;

import fr.mds.theogalode.bookmarketapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByNameContaining(String name);
    List<Book> findAllByNbPagesEquals(Integer nbPages);
    List<Book> findAllByNbPagesGreaterThan(Integer nbPages);
    List<Book> findAllByNbPagesLessThan(Integer nbPages);
    List<Book> findAllByPriceGreaterThan(BigDecimal price);
    List<Book> findAllByPriceLessThan(BigDecimal price);
    List<Book> findAllByPriceBetween(BigDecimal min, BigDecimal max);
}
