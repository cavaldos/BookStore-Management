package store.Service;

import store.Model.Sheet;
import store.Model.SheetDetail;
import store.Model.Book;

import store.Repository.SheetDAO;
import java.util.List;

public class EmployeeService {
    private SheetDAO sheetDAO;

    public EmployeeService() {
        sheetDAO = new SheetDAO();
    }

    // create sheet
    public void createSheet(int employeeID) {
        try {
            sheetDAO.createSheet(employeeID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // import book sheet
    public void importBookSheet(Book book) {
        try {
            sheetDAO.importBookSheet(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // void delete deleteSheetImporting

    public void deleteSheetImporting() {
        try {
            sheetDAO.deleteSheetImporting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // getAllBookImporting

    public List<Book> getAllBookImporting() {
        try {
            return sheetDAO.getAllBookImporting();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // get all sheet
    public List<Sheet> getAllSheet() {
        try {
            return sheetDAO.getAllSheet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // get sheet detail by id 
    public List<SheetDetail> getSheetDetailBySheetID(int sheetID) {
        try {
            return sheetDAO.getSheetDetailBySheetID(sheetID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}