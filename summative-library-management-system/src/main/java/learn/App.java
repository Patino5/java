package learn;

import learn.data.BookFileRepository;
import learn.domain.BookService;
import learn.ui.ConsoleIO;
import learn.ui.Controller;
import learn.ui.View;

public class App {
    public static void main(String[] args) {
        // "./data/books.txt" is the path to "production" data file.
        BookFileRepository repository = new BookFileRepository("./data/books.txt");
        BookService service = new BookService(repository);

        ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        Controller controller = new Controller(view, service);

        controller.run();
    }
}
