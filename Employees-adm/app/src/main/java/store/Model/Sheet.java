package store.Model;

public class Sheet {
    private Integer sheetID;
    private Integer employeeID;
    private String employeeName;
    private String date;
    private Double totalCost;

    public Sheet(Integer sheetID, Integer employeeID, String date, Double totalCost) {
        this.sheetID = sheetID;
        this.employeeID = employeeID;
        this.date = date;
        this.totalCost = totalCost;
    }

    public Sheet(Integer sheetID, Integer employeeID, String employeeName, String date, Double totalCost) {
        this.sheetID = sheetID;
        this.employeeID = employeeID;
        this.date = date;
        this.totalCost = totalCost;
        this.employeeName = employeeName;
    }
    
    public Sheet(Integer sheetID, String employeeName, String date, Double totalCost) {
        this.sheetID = sheetID;
        this.date = date;
        this.totalCost = totalCost;
        this.employeeName = employeeName;
    }

    public Sheet(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getSheetID() {
        return sheetID;
    }

    public void setSheetID(Integer sheetID) {
        this.sheetID = sheetID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "sheetID=" + sheetID +
                ", employeeID=" + employeeID +
                ", date='" + date + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }

}
