package com.techwiz5.techwiz5.services.impl;



import com.techwiz5.techwiz5.dtos.menuadmin.Menu;
import com.techwiz5.techwiz5.entities.User;

import java.util.List;


public interface AdminService {
    List<Menu> getMenu(User currenUser);



}