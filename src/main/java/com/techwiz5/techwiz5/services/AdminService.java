package com.techwiz5.techwiz5.services;



import com.techwiz5.techwiz5.dtos.menuadmin.Menu;
import com.techwiz5.techwiz5.entities.User;

import java.util.List;


public interface AdminService {
    List<Menu> getMenu(User currenUser);

}