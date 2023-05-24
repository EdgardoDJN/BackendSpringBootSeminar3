package unimagalena.micalificacionunimag.api.dto;

import unimagalena.micalificacionunimag.entities.User;

public class UserMapper {
    
    public static UserDTO toEmailDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
