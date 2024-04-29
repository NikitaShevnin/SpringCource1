package sem2.my_first_crud.src.main.java.ru.gb.my_first_crud.service;

import org.springframework.stereotype.Service;
import sem2.my_first_crud.src.main.java.ru.gb.my_first_crud.model.User;
import sem2.my_first_crud.src.main.java.ru.gb.my_first_crud.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    /*
    Добавлен метод deleteById в класс UserService. Этот метод принимает
    id пользователя в качестве параметра и вызывает соответствующий метод
    deleteById из UserRepository.
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
