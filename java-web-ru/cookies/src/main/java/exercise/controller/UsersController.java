package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN

    public static void create(Context ctx) throws Exception {
        // Получаем данные из формы
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        // Шифруем пароль
        String encryptedPassword = Security.encrypt(password);

        // Генерируем токен
        String token = Security.generateToken();

        // Создаем пользователя и сохраняем его в репозитории
        User user = new User(firstName, lastName, email, encryptedPassword, token);
        UserRepository.save(user);

        // Устанавливаем куку с токеном
        ctx.cookie("token", token);

        // Редирект на страницу пользователя
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) throws Exception {
        String idParam = ctx.pathParam("id");

        // Проверяем, является ли ID числом
        if (!StringUtils.isNumeric(idParam)) {
            throw new NotFoundResponse("Invalid user ID");
        }

        // Получаем ID пользователя из URL
        Long userId = Long.valueOf(idParam);

        // Ищем пользователя в репозитории
        User user = UserRepository.find(userId).orElseThrow(() -> new NotFoundResponse("User not found"));

        // Получаем токен из куки
        String token = ctx.cookie("token");

        // Проверяем совпадает ли токен
        if (token == null || !token.equals(user.getToken())) {
            ctx.redirect(NamedRoutes.buildUserPath());
            return;
        }

        // Отрисовываем страницу пользователя
        UserPage userPage = new UserPage(user);
        ctx.render("users/show.jte", model("page", userPage));
    }

    // END
}
