package org.example.entities;

import org.example.enums.UserRoles;

public class Admin extends User{
    public Admin(int id, String username, String password, UserRoles role) {
        super(id, username, password, UserRoles.ADMIN);
    }

}
