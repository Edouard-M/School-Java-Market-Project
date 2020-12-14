/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Edouard MIGNIEN
 * @author Clément BOUVARD
 */
/**
  * Classe Abstraite Person (Classe modele, d'une Persone)
  *
  * Contient : - un nom
  *            - un prénom
  *            - un age
  *            - un téléphone
  *            - une adresse
  *            - un email
  *            - un mot de passe
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

    
    // Constructeur
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

    // Getteurs
    public String getName()
    {
        return name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public int getAge()
    {
        return age;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getAddress()
    {
        return address;
    }
    
}
