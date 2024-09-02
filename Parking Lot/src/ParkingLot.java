import java.util.*;

public class ParkingLot {
    ArrayList<CompactSpot> compactSpots=new ArrayList<>();
    ArrayList<LargeSpot> largeSpots=new ArrayList<>();
    ArrayList<BikeSpot> bikeSpots=new ArrayList<>();

    int freeCompactSpots;
    int freeLargeSpots;
    int freeBikeSpots;

    public ParkingLot(int freeCompactSpots,int freeLargeSpots,int freeBikeSpots){
        this.freeBikeSpots=freeBikeSpots;
        this.freeCompactSpots=freeCompactSpots;
        this.freeLargeSpots=freeLargeSpots;
    }


    //Parking a vehicle
    public void parkVehicle(Vehicle vehicle){
        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(freeLargeSpots>0){
                parkYourLargeVehicle(vehicle);
            }
            else{
                System.out.println("Sorry! The parking lot is full.");
            }
        }
        else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(freeBikeSpots>0){
                parkYourBike(vehicle);
            }
            else if(freeCompactSpots>0){
                parkYourCompactVehicle(vehicle);
            }
            else if(freeLargeSpots>0){
                parkYourLargeVehicle(vehicle);
            }
            else{
                System.out.println("Sorry! The parking lot is full.");
            }
        }
        else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(freeCompactSpots>0){
                parkYourCompactVehicle(vehicle);
            }
            else if(freeLargeSpots>0){
                parkYourLargeVehicle(vehicle);
            }
            else{
                System.out.println("Sorry! The parking lot is full.");
            }
        }
        else{

        }
    }

    private void parkYourLargeVehicle(Vehicle vehicle){
        LargeSpot largeSpot=new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);

        vehicle.setParkingSpot(largeSpot);

        largeSpots.add(largeSpot);
        freeLargeSpots--;
    }

    private void parkYourBike(Vehicle vehicle){
        BikeSpot bikeSpot=new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);

        vehicle.setParkingSpot(bikeSpot);

        bikeSpots.add(bikeSpot);

        freeBikeSpots--;
    }
    private void parkYourCompactVehicle(Vehicle vehicle){
        CompactSpot compactSpot=new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);

        vehicle.setParkingSpot(compactSpot);

        compactSpots.add(compactSpot);
        freeCompactSpots--;
    }

    //Unparking the Vehicle

    public void unparkVehicle(Vehicle vehicle){
        System.out.println("We are going to unpark your vehicle of type:"+vehicle.getVehicleType());

        ParkingSpot parkingSpot=vehicle.getParkingSpot();
        parkingSpot.setFree(true);

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(largeSpots.remove(parkingSpot)){
                System.out.println("Your vehicle has been successfully removed");
                freeLargeSpots++;
            }
            else{
                System.out.println("Your vehicle is not present is this parking lot");
            }
        }
        else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(compactSpots.remove(parkingSpot)){
                System.out.println("Your vehicle has been successfully removed");
                freeCompactSpots++;
            }
            else if(largeSpots.remove(parkingSpot)){
                System.out.println("Your vehicle has been successfully removed");
                freeLargeSpots++;
            }
            else{
                System.out.println("Your vehicle is not present is this parking lot");
            }
        }
        else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(bikeSpots.remove(parkingSpot)){
                System.out.println("Your vehicle has been successfully removed");
                freeBikeSpots++;
            }
            else if(compactSpots.remove(parkingSpot)){
                System.out.println("Your vehicle has been successfully removed");
                freeCompactSpots++;
            }
            else if(largeSpots.remove(parkingSpot)){
                System.out.println("Your vehicle has been successfully removed");
                freeLargeSpots++;
            }
            else{
                System.out.println("Your vehicle is not present is this parking lot");
            }
        }

    }


}
