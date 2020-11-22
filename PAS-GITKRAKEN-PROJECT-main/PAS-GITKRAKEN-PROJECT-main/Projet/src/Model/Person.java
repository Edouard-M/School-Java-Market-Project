/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dwans
 */
public abstract class Person
{
    protected final String name;
    protected final String firstName;
    protected int age;
    protected String phone;
    protected String address;
    protected final String email;
    protected String password;

    public Person(String name, String firstName, int age, String phone, String address, String email, String password)
    {
        this.name = name;
        this.firstName = firstName;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    
}
