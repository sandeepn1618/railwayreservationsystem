package com.train;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrainService {

    private static List<Train> allTrains = new LinkedList<>();

    static {
        allTrains.add(new Train(101,"Rajdhani",
                "Hyderabad","Trivendrum",100,125, LocalDate.now()));
        allTrains.add(new Train(102,"AP-Express",
                "Hyderabad","Chennai",100,125, LocalDate.now()));
        allTrains.add(new Train(103,"Krishna-Express",
                "Hyderabad","Mumbai",100,125, LocalDate.now()));
        allTrains.add(new Train(104,"SF-Delhi",
                "Chennai","Delhi",100,125, LocalDate.now()));
        allTrains.add(new Train(105,"SF-Chennai",
                "Delhi","Chennai",100,125, LocalDate.now()));
    }

    public TrainService() {
        super();
    }

    public static Train findTrain(int trainNumber){
        //from allTrains need to loop to get train
   Train temp = null;
        for (Train t:
             allTrains) {
     if (t.getTrainNumber() == trainNumber){
          temp = t;
         System.out.println(temp.getTrainNumber() + "--" + temp.getTrainName() + "--"
                 + temp.getFromStation() + "--" + temp.getToStation() + "--"
                 + temp.getSeatsAvailable() + "--" + temp.getFare());
         break;
     }

        }
        return temp;
    }
    public static void trainBetweenStations(String fromStation,String toStation,LocalDate Doj,int noOfSeats){
        List<Train> searchTrainList = new LinkedList<>();
        for (Train t:
                allTrains){
            if (t.getFromStation().equals(fromStation)
                    && t.getToStation().equals(toStation)
                    && t.getDoj().equals(Doj)
                    && t.getSeatsAvailable() > noOfSeats){
             //
                searchTrainList.add(t);
            }
        }

        if (searchTrainList.size() == 0){
            System.out.println("No matching train for your search");
        }else{
        for (Train searchList:searchTrainList
             ) {
        }
        }

    }
    public static void bookTickets(int trainNumber,List<Passenger> passengerList){
        // Subtract bank balance / noOfSeats
        int noOfSeats = passengerList.size();
        // BankAccount account = tempPassenger.getBankAccount();
       BankAccount account = passengerList.get(0).getBankAccount();

       Train tempTrain = findTrain(trainNumber);
       int actualFare = tempTrain.getFare();
       int totalTicketFare = actualFare * noOfSeats;
       account.withdraw(totalTicketFare);
       tempTrain.setSeatsAvailable(tempTrain.getSeatsAvailable()-noOfSeats);

       TicketService.addNewTicket(trainNumber,passengerList);

       TicketService.ticketDeatils(1);


    }
}
