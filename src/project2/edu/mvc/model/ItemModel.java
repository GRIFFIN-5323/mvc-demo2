/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.edu.mvc.model;


import java.sql.SQLException;
import project2.edu.mvc.DBConnection.DBConnection;
import project2.edu.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.ResultSet;
 

import java.util.ArrayList;

 

import java.sql.PreparedStatement;
 

import java.sql.SQLException;
 


/**
 *
 * @author gihan5323
 */
public class ItemModel {
    
    public String saveItem(ItemDto dto) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        
        String sql="INSERT INTO Item VALUES (?,?,?,?,?)";
        PreparedStatement statement =connection.prepareStatement(sql);
        
        statement.setString(1, dto.getItemCode());
         statement.setString(2, dto.getDescription());
          statement.setString(3, dto.getPackSize());
            statement.setDouble(4, dto.getUnitPrice());
             statement.setInt(5, dto.getQoh());
            
            
            
            return statement.executeUpdate() > 0 ? "Succesfully Saved" : "Fail";
            
          
       
        
        
    }
    
        public String updateItem(ItemDto dto) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        
        String sql="UPDATE Item SET  Description =?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode =?  ";
        PreparedStatement statement =connection.prepareStatement(sql);
        
        
         statement.setString(1, dto.getDescription());
          statement.setString(2, dto.getPackSize());
           statement.setDouble(3, dto.getUnitPrice());
             statement.setInt(4, dto.getQoh());
             statement.setString(5, dto.getItemCode());
           
           
        
          
           
           
            
            
            return statement.executeUpdate() > 0 ? "Succesfully update" : "Fail";
            
          
       
        
        
    }
        
        
        
            public String DeleteItem(String code) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        
        String sql="DELETE FROM Item WHERE Itemcode=?";
        PreparedStatement statement =connection.prepareStatement(sql);
        
        statement.setString(1,code);
        
        
            
            
            
            return statement.executeUpdate() > 0 ? "Succesfully Saved" : "Fail";
            
          
       
        
        
    }
            
                 public ItemDto searchItem(String code) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        
        String sql="SELECT ALL * FROM Item WHERE ItemCode=? ";
        PreparedStatement statement =connection.prepareStatement(sql);
        
        statement.setString(1,code);
        
        ResultSet rst= statement.executeQuery();
        
        if(rst.next()){
            
            ItemDto dto=new ItemDto(rst.getString("ItemCode"),rst.getString("Description"),rst.getString(PackSize),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand"));
            
              return dto;
            
        }
        
        return null;
        
      
        }
        
        
            
            public ArrayList<ItemDto> getALL(String code) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        
        String sql="SELECT ALL * FROM Item ";
        PreparedStatement statement =connection.prepareStatement(sql);
        
     
        
        ResultSet rst= statement.executeQuery();
          ArrayList<ItemDto> itemDtos = new ArrayList<>();
        
        while(rst.next()){
            
            ItemDto dto=new ItemDto(rst.getString("ItemCode"),rst.getString("Description"),rst.getString(PackSize),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand"));
            itemDtos.add(dto);
            
        }
        
        return Itemdtos;
        
      
        }
               
            
            
            
            
   
    
    
    

    }
    
    

