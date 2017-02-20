/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entites.Action;
import Entites.User;
import java.util.ArrayList;

/**
 *
 * @author Krist
 */
public interface Iactions {
    
    public void InsertAction(Action A);
    public void DeleteAction();
    public ArrayList<Action> ListAction(); 
    public ArrayList<Action> ListActionCustom(String Username); 
}
