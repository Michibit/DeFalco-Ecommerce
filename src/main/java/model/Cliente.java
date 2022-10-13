package model;

/*
 * CREATE table Cliente(
	ID CHAR(6),
    Username CHAR(20) NOT NULL,
    Pass char(20) NOT NULL,
    Email CHAR(30) NOT NULL,
    admin bool default false,
    
    primary key(ID)
);
 */

import java.util.ArrayList;

public class Cliente {
    private String ID, Username, pass, email;
    private ArrayList<Carrello> carrello;
    private boolean admin;


    public Cliente(String ID, String Username, String pass, String email, boolean admin) {
        this.ID = ID;
        this.Username = Username;
        this.pass = pass;
        this.email = email;
        this.admin = admin;
        this.carrello = new ArrayList<>();
    }

    public Cliente(String username, String pass) {
        this.Username = username;
        this.pass = pass;
    }


    public Cliente() {
        this.carrello = new ArrayList<>();

    }

    public ArrayList<Carrello> getCarrello() {
        return carrello;
    }

    public void setCarrello(ArrayList<Carrello> carrello) {
        this.carrello = carrello;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
