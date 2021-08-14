/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.dao;
import com.mycompany.maven.app.model.Room;
import java.util.List;
/**
 *
 * @author mac
 */
public interface RoomDAO {
    public boolean insert(Room r);
    
    public boolean update(Room r);

    public boolean delete(String id);

    public Room getRoomById(String id);

    public List<Room> getAllRooms();   
}
