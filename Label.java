// ---------------------------------------------------------
// Assignment 4
// Written by: Zin Bitar 40305895
// For COMP 248 Section H 2242– Fall 2024
// ---------------------------------------------------------
public class Label{


    //making private attributes
    private String type;
    private int id;
    private int exDay;
    private int exMonth;

    //default constructor
    public Label(){
        this.type = "";
        this.id = 0;
        this.exDay = 0;
        this.exMonth = 0;
    }

    //constructor
    public Label(String type, int id, int exDay, int exMonth){
        this.type = type;
        this.id = id;
        if (exDay <= 31 && exDay >= 1)
            this.exDay = exDay;
        else
            this.exDay = 0;
        if(exMonth <= 12 && exMonth >= 1)
            this.exMonth = exMonth;
        else
            this.exMonth = 0;
    }

    //copy method
    public Label (Label copy){
        this.type = copy.getType();
        this.id = copy.getId();
        this.exDay = copy.getexDay();
        this.exMonth = copy.getexMonth();

    }

    //getters and setters
    public int getexMonth() {
        return exMonth;
    }
    public void setexMonth(int exMonth) {
        if(exMonth <= 12 && exMonth >= 1)
            this.exMonth = exMonth;
        else
            this.exMonth = 0;
    }
    public int getexDay() {
        return exDay;
    }
    public void setexDay(int exDay) {
        if (exDay <= 31 && exDay >= 1)
            this.exDay = exDay;
        else
            this.exDay = 0;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //toString
    @Override
    public String toString() {
        return ("\n" + type + " - " + id + " - " + exDay + "/" + exMonth + "\n");
    }

    //equals
    public boolean equals(Label another){
        return(this.type.equalsIgnoreCase(another.type) && this.id == another.id && this.exDay == another.exDay && this.exMonth == another.exMonth);
    }
}
