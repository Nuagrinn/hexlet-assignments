package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/welcome", ctx -> ctx.result("Hello World"));
        return app;
    }
        // END

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
