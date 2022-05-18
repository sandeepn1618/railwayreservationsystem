package com.train;

import java.util.LinkedList;
import java.util.List;

public class TicketService {

    private static List<Ticket> allTickets = new LinkedList<>();
    public static void addNewTicket(int trainNumber,List<Passenger> passengerList) {
        int pnr = allTickets.size()+1;
        Train bookedTrain = TrainService.findTrain(trainNumber);
        allTickets.add(new Ticket(pnr,bookedTrain,passengerList));
        System.out.println("Tickets booked sucessfully...");
    }
    public static void ticketDeatils(int pnr){
        Ticket tempTicket = null;
        for (Ticket t:
             allTickets) {
            if (t.getPnr() == pnr){
                tempTicket = t;
                break;
            }
            
        }
        Train tempTrain = tempTicket.getBookedTrain();
        List<Passenger> passengerList = tempTicket.getPassengerList();
        int totalFare = tempTrain.getFare() * passengerList.size();

        System.out.println("Booking Deatils");

        System.out.println("PNR :"+tempTicket.getPnr()+
                "--"+tempTrain.getTrainNumber());
        System.out.println("Train Name :"+tempTrain.getTrainName());
        System.out.println("From Station :"+tempTrain.getFromStation()+
                "--"+tempTrain.getToStation());
        System.out.println("DOJ"+tempTrain.getDoj() + "Fare" +
                tempTrain.getFare() +"Total Fare"+totalFare);
    }
}
