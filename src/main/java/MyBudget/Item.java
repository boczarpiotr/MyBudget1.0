package MyBudget;

public class Item {
    private String date;
    private String kindOfOutcome;
    private String month;
    private double outcome;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKindOfOutcome() {
        return kindOfOutcome;
    }

    public void setKindOfOutcome(String kindOfOutcome) {
        this.kindOfOutcome = kindOfOutcome;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Item{" +
                "date='" + date + '\'' +
                ", kindOfOutcome='" + kindOfOutcome + '\'' +
                ", month='" + month + '\'' +
                ", outcome=" + outcome;
    }

}
