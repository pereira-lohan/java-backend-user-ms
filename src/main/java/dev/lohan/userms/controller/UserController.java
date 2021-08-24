package dev.lohan.userms.controller;

import dev.lohan.userms.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    public static List<UserDTO> userDTOList = new ArrayList<UserDTO>();

    @GetMapping
    public List<UserDTO> listAll() {
        return userDTOList;
    }

    @GetMapping(path = "{taxId}")
    public UserDTO listByTaxId(@PathVariable String taxId) {
        Optional<UserDTO> optionalUserDTO = userDTOList.stream().filter(user -> user.getTaxId().equals(taxId)).findFirst();

        return optionalUserDTO.orElse(null);
    }

    @PostMapping("/new")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        userDTO.setRegistrationDate(new Date());
        userDTOList.add(userDTO);
        return userDTO;
    }

    @DeleteMapping(path = "{taxId}")
    public boolean delete(@PathVariable String taxId) {
        for (UserDTO userFilter: userDTOList) {
            if (userFilter.getTaxId().equals(taxId)) {
                userDTOList.remove(userFilter);
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO1 = UserDTO.builder()
                                  .name("Yuri Isaac Corte Real")
                                  .taxId("843.298.707-70")
                                  .address("Praia de São Conrado, 30 Qd 441 Lt 13")
                                  .email("yuriisaaccortereal_@oul.com.br")
                                  .phoneNumber("(22) 98388-8049")
                                  .registrationDate(new Date())
                                  .build();
        userDTOList.add(userDTO1);

        UserDTO userDTO2 = UserDTO.builder()
                .name("José Noah Silveira")
                .taxId("781.571.967-87")
                .address("Rua Jayme Mello 02")
                .email("josenoahsilveira-78@ddfnet.com.br")
                .phoneNumber("(22) 98518-8979")
                .registrationDate(new Date())
                .build();
        userDTOList.add(userDTO2);

        UserDTO userDTO3 = UserDTO.builder()
                .name("Catarina Betina Sophie Aragão")
                .taxId("966.144.127-87")
                .address("Rua Alfredo Muniz, 1220")
                .email("catarinabetinasophiearagao_@trt15.jus.br")
                .phoneNumber("(22) 99296-6532")
                .registrationDate(new Date())
                .build();
        userDTOList.add(userDTO3);

    }

}
