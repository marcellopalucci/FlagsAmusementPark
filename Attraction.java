package FlagsAmusementPark;

public class Attraction implements Admittable{
    private final String name;
    private long sumRatings = 0L;
    private int numRatings = 0;
    private final double admissionFee;
    private Group[] visitors;

    /**
     * Constructor taking in String name and double admissionFee and setting both.
     * Setting visitor group array to its defualt value of 5.
     * @param name String representing the name of the attraction.
     * @param admissionFee double representing the fee for going into the attraction
     */
    public Attraction(String name, double admissionFee){
        this.name = validName(name);
        this.admissionFee = (admissionFee >= 0) ? admissionFee : 0;
        this.visitors = new Group[5];
    }

    /**
     * Constructor taking in String name and setting name, and admission fee to 5.25.
     * Setting visitor group array to its defualt value of 5.
     * @param name String representing the name of the attraction.
     */
    public Attraction(String name) {
        this(name, 5.25);
    }

    @Override
    public void admit(String[] newVisitorNames) {
        int numNewVisitorNames = 0;

            int numGroups = (newVisitorNames.length % 5 == 0) ? newVisitorNames.length : newVisitorNames.length + 1;
            Group[] splitGroups = new Group[numGroups];
            for(int i = 0; i < newVisitorNames.length; i++){
                for (int j = 0; j < 5; j++) {
                    splitGroups[j] = newVisitorNames[i + j];
                }
                visitors[i] = splitGroups;
            }
    }

    /**
     * Method which removes a group of visitors from the attractions and updates the attraction's
     * rating based on their response.
     * @param groupIndex int corresponding to the index for a Group in the visitors array
     * @param groupRating int corresponding to the rating the Group will give the attraction
     */
    public void rateAndExit(int groupIndex, int groupRating){
        sumRatings += checkRating(groupRating);
        numRatings ++;
    }


    public double averageRating() {
        //average rating
        double avgRating = Math.round((double) sumRatings / (double) numRatings);
        return (avgRating == 0) ? 0 : avgRating;
    }
    private int checkRating(int rating){
        if (rating < 1){
            return 1;
        } else if (rating > 10) {
            return 10;
        }
        return rating;
    }
    private String validName(String name){
        return (name == null || name.isBlank()) ? String.format("No name") : name;
    }

    public String getName() {
        return name;
    }

    public double getAdmissionFee() {
        return admissionFee;
    }
}
