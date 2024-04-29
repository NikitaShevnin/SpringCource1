package sem2.my_first_crud.src.main.java.ru.gb.my_first_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sem2.my_first_crud.src.main.java.ru.gb.my_first_crud.model.User;
import sem2.my_first_crud.src.main.java.ru.gb.my_first_crud.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Получаем значение id пользователя из URL-адреса с помощью @PathVariable("id") int id.
     * Затем вызываем метод deleteById из UserService, передавая в него полученный id.
     * @param id представляет собой идентификатор (уникальный номер) пользователя, который нужно удалить из базы данных.
     * @return мы возвращаем строку "redirect:/users", что перенаправляет пользователя на
     * страницу со списком всех пользователей (/users). Это позволяет увидеть обновленный список
     * после удаления пользователя.
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
