
import java.util.List;
public class Controller {
    private final BookService bookService;

    public Controller(BookService bookService) {
        this.bookService = bookService;
    }

    // API endpoint to retrieve all books
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    // API endpoint to retrieve a book by ID
    public BookDTO getBookById(Long bookId) {
        return bookService.getBookById(bookId);
    }

    // API endpoint to add a new book
    public BookDTO addBook(BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    // API endpoint to update an existing book
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        return bookService.updateBook(bookId, bookDTO);
    }

    // API endpoint to delete a book by ID
    public void deleteBook(Long bookId) {
        bookService.deleteBook(bookId);
    }
}
