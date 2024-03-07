
public class Group {

    private final String[] people;

    /**
     * Constructor taking in String [] of people.
     * If the reference passed in is null, a new array is created with length 0.
     * If the reference passed in is non-null, a deep copy of the array should be made.
     * @param people String array representing names of people in a group.
     */
    public Group(String[] people) {
        int groupSize = people.length;
        if (people == null) {
            this.people = new String[0];
        } else {
            this.people = new String[groupSize];
            for (int i = 0; i < groupSize; i++){
                this.people[i] = people[i];
            }
        }
    }

    /**
     * Method which returns the size of the group (ie the number of people in the group).
     * @return int representing the size of the group
     */
    public int size(){
        return this.people.length;
    }

    @Override
    public String toString(){
        //CHECK THIS!!!!!!!!!! :)
        if (this.people == null){
            return "";
        }
        String formattedString = "";
        for (int i = 0; i < this.people.length; i++){
            formattedString += String.format("%s/", this.people[i]);
        }
        return formattedString.substring(0, formattedString.length() - 1);
    }

    /**
     * Getter method which returns a String array representing names of people in a group.
     * @return
     */
    public String[] getPeople() {
        return people;
    }
}
