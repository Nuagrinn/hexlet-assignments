@template.layout.page(
content = @`
    <h1>Регистрация нового пользователя</h1>

    <form action="/users" method="post">
        <div class="mb-3">
            <label>
                Имя
                <input type="text" name="firstName" class="form-control" required />
            </label>
        </div>
        <div class="mb-3">
            <label>
                Фамилия
                <input type="text" name="lastName" class="form-control" required />
            </label>
        </div>
        <div class="mb-3">
            <label>
                Email
                <input type="email" name="email" class="form-control" required />
            </label>
        </div>
        <div class="mb-3">
            <label>
                Пароль
                <input type="password" name="password" class="form-control" required />
            </label>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Зарегистрировать</button>
        </div>
    </form>

    <div class="mt-3">
        <a href="/users">Пользователи</a>
    </div>
`
)
