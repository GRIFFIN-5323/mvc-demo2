/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.edu.mvc.Controller;

import java.util.ArrayList;
import project2.edu.mvc.dto.ItemDto;
import project2.edu.mvc.model.ItemModel;
import java.sql.SQLException;

/**
 *
 * @author gihan5323
 */
public class ItemController {
    
    private ItemModel itemModel=new ItemModel();
    
    public ArrayList<ItemDto> getAll() throws ClassNotFoundException, SQLException{
        
        
         ArrayList<ItemDto> resp = itemModel.getALL();
         
     

 

        return resp;
        
        
    }
    
}
