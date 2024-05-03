package store.view.admin.chart.dataCateModel;

/**
 *
 * @author RAVEN
 */
public class ModelCategoryData {

    

  
    public String getNameCate() {
        return name;
    }

    public void setNameCate(String name) {
        this.name = name;
    }
 public double getRevenueCate() {
        return revenue;
    }

    public void setRevenueCate(double revenue) {
        this.revenue = revenue;
    }
    public ModelCategoryData(String name, double revenue) {
        
        this.name = name;
          this.revenue = revenue;
    }

    public ModelCategoryData() {
    }
    private String name;
    private double revenue;
}
