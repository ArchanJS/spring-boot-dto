package com.test.dtotest.service;

import com.test.dtotest.dto.UserLocationDto;
import com.test.dtotest.model.User;
import com.test.dtotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserLocationDto> getAllUserLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserLocationDto convertEntityToDto(User user){
        UserLocationDto userLocationDto=new UserLocationDto();
        userLocationDto.setUserId(user.getId());
        userLocationDto.setEmail(user.getEmail());
        userLocationDto.setPlace(user.getLocation().getPlace());
        userLocationDto.setLatitude(user.getLocation().getLatitude());
        userLocationDto.setLongitude(user.getLocation().getLongitude());
        return userLocationDto;
    }
}
