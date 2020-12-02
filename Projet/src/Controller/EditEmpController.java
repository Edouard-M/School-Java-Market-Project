/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dwans
 */
public class EditEmpController
{
    public DAO dao;
    public EditEmpController()
    {
        dao=new DAO();
    }
    public Employee findEmployee(String email)
    {
        dao.getConnection();
        Employee employee=null;
        try
        {
            employee = dao.getEmployee(email);
        } catch (Exception ex)
        {
            Logger.getLogger(EditEmpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
        return employee;
    }
    public void EditEmployee(String email, String text1, String text6, String text2, String text3,int index1,String text4)
    {
        dao.getConnection();
        try
        {
            if(!"".equals(text4))
            dao.EditEmployee(email, text1, text6, text2, text3, index1, text4);
            else 
                dao.EditEmployee(email, text1, text6, text2, text3, index1, dao.getEmployeePassword(email));
        } catch (Exception ex)
        {
            Logger.getLogger(EditCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.closeConnection();
    }
}
