package com.techwiz5.techwiz5.models.auth;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UpdateProfile {
    private String preferredCurrency;
    private List<String> travelPreferences;
    private MultipartFile profilePictureUrl;
}
