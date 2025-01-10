// ---------------------------------------------------------
// Assignment 4
// Written by: Zin Bitar 40305895
// For COMP 248 Section H 2242– Fall 2024
// ---------------------------------------------------------
public class Registry {

    //making private attributes
    private Stamps stamps;
    private Label[] labels;

    //default constructor
    public Registry(){
        labels = null;
        stamps = new Stamps();
    }

    //constructor
    public Registry(Stamps stamps, Label[] labels){

        this.stamps = stamps;
        this.labels = labels;
    }

    //getter for label
    public Label getLabel(int i){
        if(i < 0 || i > labels.length)
            return null;
        else
            return labels[i];
    }

    //method that returns true if stamp prices are equal for 2 registries
    public boolean equalPriceStamps(Registry other){
        if (this.stamps == null || other.stamps == null)
            return false;
        return (stamps.StampsTotal() == other.stamps.StampsTotal());
    }

    //method that returns true if stamps distribution is the same for 2 registries
    public boolean equalNumStamps(Registry other){
        if (stamps == null || other.stamps == null)
            return false;
        return (stamps.equals(other.stamps));
    }

    //method to check $ of stamps
    public int priceOfStamps(){

        return this.stamps.StampsTotal();
    }

    //method to check number of labels
    public int numberOfLabels(){

        return this.labels.length;
    }

    //method to add labels
    public int addLabel(Label labelToAdd){

        //adding one to a label if it is null
        if(labels==null) {
            Label[] newLabels = new Label[1];
            newLabels[0] = labelToAdd;
            this.labels = newLabels;
        }
        //making a new label array with one more place allocation
        //copying everything that the other label had
        else{
            int newSize = this.labels.length+1;
            Label[] newLabels = new Label[newSize];
            newLabels[newSize-1] = labelToAdd;
            for (int i = 0; i < labels.length; i++) {
                newLabels[i] = labels[i];
            }
            this.labels = newLabels;
        }
        return labels.length;
    }

    //method to remove a label
    public boolean removeLabel(Label label) {

        //making sure label has a label to remove
        if (labels == null)
            return false;

        //looking for the label that they want to remove
        //once it is found, create new array of labels with one less memory allocation and skipping it
        else {
            boolean found = false;
            for (int i = 0; i < labels.length; i++) {
                if (labels[i].equals(label)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
            int newSize = this.labels.length - 1;
            Label[] newLabels = new Label[newSize];
            for (int j = 0, i = 0; i < labels.length; i++) {
                if (labels[i].equals(label))
                    continue;
                newLabels[j] = labels[i];
                j++;
            }
            this.labels = newLabels;
            return true;
        }

    }

    //method to change expiry date
    public void changeExpiryDate(Label labelToChange, int newExDay, int newExMonth) {
        for (int i = 0; i < labels.length; i++) {
            if (labels[i].equals(labelToChange)) {
                labels[i].setexDay(newExDay);
                labels[i].setexMonth(newExMonth);
            }
        }
    }

    //method that return number of each category of stamps
    public String stampsBreakDown() {

        return this.stamps.toString();
    }

    //method that adds stamps
    public void addStamps(int catA, int catB, int catC, int catD, int catE){
        this.stamps.addStamps(catA,catB,catC,catD,catE);
    }

    //toString
    @Override
    public String toString() {
        if (labels != null) {
            String arrLabels = "";
            for (int i = 0; i < labels.length; i++) {
                arrLabels = arrLabels.concat(labels[i].toString());
            }
            return stamps + "\n" + arrLabels;

        }
        else
            return stamps + "\nNo Labels";

    }

    //equals method
    public boolean equals(Registry other) {
        return (this.priceOfStamps()== other.priceOfStamps() && this.numberOfLabels() == other.numberOfLabels());
    }
}
