import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<BookDTO> findAll();
    Optional<BookDTO> findById(Long bookId);
    BookDTO save(BookDTO bookDTO);
    void deleteById(Long bookId);
}