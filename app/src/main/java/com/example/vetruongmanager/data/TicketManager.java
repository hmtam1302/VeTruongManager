package com.example.vetruongmanager.data;

import java.util.ArrayList;

public class TicketManager {
    private Ticket ticket;
    private ArrayList<Ticket> ticketList;

    public TicketManager(){
        ticketList = new ArrayList<>();
    }

    public void addNewTicket(Ticket ticket){
        ticketList.add(ticket);
    }

    public int getSize(){
        return ticketList.size();
    }

    public ArrayList<Ticket> getTicketList(){
        return ticketList;
    }
}
