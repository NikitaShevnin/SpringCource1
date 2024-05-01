package ru.gb.example3_sem3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3.domain.User;
import ru.gb.example3_sem3.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;
    /**
     *  TODO: 1 Созданны поля UserService, NotificationService
     */
    private UserService userService;
    private NotificationService notificationService;

    /**
     * TODO: 1.1 добавить в IOC контейнер аннотацией @Autowired или через конструктор класса
     */
    @Autowired
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * TODO: 2 Разработать метод processRegistration
     *  - создается пользователь из параметров метода
     *  - созданный пользователь добавляется в репозиторий
     *  - через notificationService выводится сообщение в консоль
     */
    public void processRegistration(String name, int age, String email) {
        // 1. Создаем пользователя из параметров метода
        User user = userService.createUser(name, age, email);

        // 2. Добавляем созданного пользователя в репозиторий
        UserRepository.addUser(user);

        // 3. Выводим сообщение о создании пользователя через NotificationService
        notificationService.sendNotification("A new user has been created: " + user.getName());
    }

}
