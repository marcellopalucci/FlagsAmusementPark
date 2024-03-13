package FlagsAmusementPark;

public class RollerCoaster extends Attraction{
    private final int maxCapacity;
    private int occupancy = 0;
    public RollerCoaster(String name, double admissionFee, int maxCapacity){
        super(name, admissionFee);
        this.maxCapacity = (maxCapacity < 25) ? 25 : maxCapacity;
    }
    public RollerCoaster(String name){
        this(name, 5.25, 25);
    }

    @Override
    public void admit(String[] newVisitorNames) {
        super.admit(newVisitorNames);
    }

    @Override
    public void rateAndExit(int groupIndex, int groupRating) {
        super.rateAndExit(groupIndex, groupRating);
        occupancy --;
    }
    public double percentOccupancy(){
        double percent = occupancy / maxCapacity * 10000.0;
        return  Math.round(percent) / 100;
    }
    @Override
    public String toString (){
        return String.format("RollerCoaster: %s/%f/%f/%d%\n",
                super.getName(), super.averageRating(), super.getAdmissionFee(), percentOccupancy());
    }
}
