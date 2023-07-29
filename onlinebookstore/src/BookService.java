import java.util.List;
import java.util.stream.Collectors;
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long bookId) {
        BookDTO book = bookRepository.findById(bookId).orElse(null);
        return (book != null) ? convertToDTO(book) : null;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        bookDTO = bookRepository.save(book);
        return convertToDTO(bookDTO);
    }
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        BookDTO existingBook = bookRepository.findById(bookId).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setAuthor(bookDTO.getAuthor());
            existingBook = bookRepository.save(existingBook);
        }
        return (existingBook != null) ? convertToDTO(existingBook) : null;
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    private BookDTO convertToDTO(BookDTO book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }
}
