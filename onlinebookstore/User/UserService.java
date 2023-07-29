import java.util.UUID;
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new RuntimeException("Username already taken");
        }

        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new RuntimeException("Email already registered");
        }

        String uniqueId = UUID.randomUUID().toString();
        userDTO.setUserId(uniqueId);

        User user = convertToEntity(userDTO);
        user.setRole("USER");
        userRepository.save(user);

        return userDTO;
    }
}
