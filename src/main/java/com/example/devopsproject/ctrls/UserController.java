import com.example.devopsproject.entities.User;
import com.example.devopsproject.repps.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users/all")
    List<User> getAllUsers(){
        return userRepo.findAll();
    }

    //ajouter un utilisateur
    @PostMapping("/users/add")
    User newUser(@RequestBody User newUser){
        return userRepo.save(newUser);
    }

    //get User by id
    @GetMapping("/users/{idu}")
    User getUserById(@PathVariable Long idu) {
        return userRepo.findById(idu).orElse(null);
    }


    @PutMapping("/users/update/{idu}")
    public ResponseEntity<User> updateUser(@PathVariable long idu, @RequestBody User userDetails) {
        User updateUser = userRepo.findById(idu)
                .orElseThrow(null);

        updateUser.setFirstNameu(userDetails.getFirstNameu());
        updateUser.setLastNameu(userDetails.getLastNameu());
        updateUser.setPhoneu(userDetails.getPhoneu());
        updateUser.setEmailu(userDetails.getEmailu());
        updateUser.setRoleu(userDetails.getRoleu());
        updateUser.setPasswordu((userDetails.getPasswordu()));
        userRepo.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }


    @DeleteMapping("/users/delete/{idu}")
    public ResponseEntity<User> deleteUser(@PathVariable long idu){
        userRepo.deleteById(idu);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/byRole/{roleu}")
    List<User> getUsersByRole(@PathVariable String roleu) {
        return userRepo.findByRoleu(roleu);
    }


    @DeleteMapping("/users/deleteByRoleu/{roleu}")
    public ResponseEntity<String> deleteUsersByRoleu(@PathVariable String roleu) {
        List<User> usersToDelete = userRepo.findByRoleu(roleu);

        if (usersToDelete.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found with the specified role");
        }

        //yejbdhom kol w baed yfasskhhom
        userRepo.deleteInBatch(usersToDelete);

        return ResponseEntity.ok("Users deleted successfully");
    }




}
