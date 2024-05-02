package store.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import store.Model.Book;
import store.Service.BookService;

public class CSVBookImporter {

    private BookService bookService;

    public CSVBookImporter(BookService bookService) {
        this.bookService = bookService;
    }

    public void importBooksFromCSV(String csvFilePath) throws SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Bỏ qua dòng trống
                if (line.trim().isEmpty())
                    continue;

                String[] values = line.split(",", -1);
                if (values.length != 6) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                // Chuyển đổi giá từ String sang Double
                String priceWithCurrency = values[1].trim();
                double price = parsePrice(priceWithCurrency);

                int volume = Integer.parseInt(values[2].trim());

                Book newBook = new Book(
                        values[0].trim(),
                        values[3].trim(),
                        values[5].trim(),
                        price,
                        values[4].trim(),
                        volume);

                bookService.insertBook(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private double parsePrice(String priceWithCurrency) throws ParseException {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(priceWithCurrency);
        return number.doubleValue();
    }

    // public static void main(String[] args) throws SQLException {
    //     BookService bookService = new BookService();
    //     CSVBookImporter importer = new CSVBookImporter(bookService);
    //     importer.importBooksFromCSV("1.csv");
    // }
}
