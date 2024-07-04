@import exercise.dto.posts.PostPage;

@param PostPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <title>${page.getPost().getName()}</title>
</head>
<body>
<div class="container mt-5">
    <h1>${page.getPost().getName()}</h1>
    <p>${page.getPost().getBody()}</p>
    <a href="${exercise.util.NamedRoutes.postsPath()}" class="btn btn-primary">Back to all posts</a>
</div>
</body>
</html>
