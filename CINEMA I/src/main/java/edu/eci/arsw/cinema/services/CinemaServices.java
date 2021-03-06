/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.filters.Filter;
import edu.eci.arsw.cinema.filters.GenreFilter;
import edu.eci.arsw.cinema.filters.SeatsFilter;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */

@Service
public class CinemaServices {
    final String a = "filterOfGenre";

    @Autowired
    @Qualifier("InMemoryCinemaPersistence")
    CinemaPersitence cps;

    @Autowired
    @Qualifier(a)
    Filter filter;
    

    /**
     *
     * @param c cinema's instance
     * @return the cinema of the given name created by the given author
     * @throws CinemaException
     */
    public void addNewCinema(Cinema c){
        try {
            cps.saveCinema(c);
        } catch (CinemaPersistenceException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return  All cinema's instance
     */
    public Set<Cinema> getAllCinemas(){
        return cps.getAllCinema();
    }
    
    /**
     * 
     * @param name cinema's name
     * @return the cinema of the given name created by the given author
     * @throws CinemaException
     */
    public Cinema getCinemaByName(String name) throws CinemaException{
        try {
           return cps.getCinema(name);
        } catch (CinemaPersistenceException e) {
            throw new CinemaException(e.getMessage());
        }

    }

    /**
     *
     * @param row row of the seats
     * @param col col of the seats
     * @param cinema cinema's name
     * @param date movie's date
     * @param movieName movie's name
     *
     */
    public void buyTicket(int row, int col, String cinema, String date, String movieName){
        try {
            cps.buyTicket(row, col, cinema, date, movieName);
        }catch (CinemaException ce){
            System.out.println(ce.toString());
        }

    }


    /**
     *
     * @param cinema cinema's name
     * @param date movie's date
     * @return All functions of the given cinema's name
     */
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        return cps.getFunctionsbyCinemaAndDate(cinema, date);
    }

    /**
     *
     * @param c cinema's instance
     * @param date movie's date
     * @param genre movie's genre
     * @return All functions of the given genre
     */
    public List<CinemaFunction> getFunctionsFilter(Cinema c,String date,String genre){
        return filter.filter(c,date,genre);
    }

    /**
     *
     * @param c cinema's instance
     * @param date movie's date
     * @param x amount expected of seats in the movie
     * @return All functions of the given
     */
    public List<CinemaFunction> geFunctionsFilter(Cinema c,String date, Integer x){
        return filter.filter(c,date,x);
    }




    public void filterChange(String fil){
        if(a!=fil) {
            if(fil=="filterOfSeats") {
                filter = new SeatsFilter();
            }else {
                filter = new GenreFilter();
            }
        }
    }
}
