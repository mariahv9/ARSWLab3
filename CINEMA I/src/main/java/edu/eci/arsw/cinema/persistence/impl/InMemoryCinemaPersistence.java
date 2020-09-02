/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 * @author cristian
 */
@Component
@Qualifier("InMemoryCinemaPersistence")
public class InMemoryCinemaPersistence implements CinemaPersitence{
    
    private final Map<String,Cinema> cinemas=new HashMap<>();

    public InMemoryCinemaPersistence() {
        //load stub data
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("cinemaX",functions);
        cinemas.put("cinemaX", c);
    }    

    @Override
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {

        Cinema c = getCinema(cinema);
        if(c!=null) {
            boolean notfounded = true;
            for (int i=0;i<c.getFunctions().size() && notfounded ;i++) {

                if (c.getFunctions().get(i).getMovie().getName().equals(movieName) && c.getFunctions().get(i).getDate().equals(date)) {

                    c.getFunctions().get(i).buyTicket(row,col);
                    notfounded = false;
                }
            }

            if(notfounded) {
                throw new CinemaException("Movie,Date or Position non-existent");
            }
        }else {
            throw new CinemaException("Cinema non-existent");
        }
    }

    @Override
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date)  {
        Cinema c = getCinema(cinema);
        if(c!=null) {
            List<CinemaFunction> listc = new ArrayList<>();

            for (CinemaFunction function : c.getFunctions()) {

                if (function.getDate().equals(date)) {
                    listc.add(function);
                }
            }

            return listc;
        }else {
            return null;
        }
    }

    @Override
    public void saveCinema(Cinema c) throws CinemaPersistenceException {
        if (cinemas.containsKey(c.getName())){
            throw new CinemaPersistenceException("The given cinema already exists: "+c.getName());
        }
        else{
            cinemas.put(c.getName(),c);
        }   
    }

    @Override
    public Cinema getCinema(String name){
        return cinemas.get(name);
    }

    @Override
    public Set<Cinema> getAllCinema() {
        return (Set<Cinema>) cinemas;
    }

}
