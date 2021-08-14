/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.dao;

import com.mycompany.maven.app.model.BookedRoom;
import java.util.List;

/**
 *
 * @author mac
 */
public interface BookedRoomDAO {
    public boolean insert(BookedRoom br);
    
    public boolean update(BookedRoom br);

    public boolean delete(String id);

    public BookedRoom getBookedRoomById(String id);

    public List<BookedRoom> getAllBookedRooms();   
}
