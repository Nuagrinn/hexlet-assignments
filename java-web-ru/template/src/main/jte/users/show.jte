@import exercise.dto.users.UserPage
@param UserPage page

<!-- Для наглядности мы не стали включать сюда основную структуру HTML -->
<main>
    <p>${page.getUser().getFirstName()}</p>
    <p>${page.getUser().getLastName()}</p>
</main>