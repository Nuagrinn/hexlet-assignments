@import exercise.util.NamedRoutes;
@import exercise.dto.posts.PostsPage;
@import exercise.dto.posts.PostPage;

@param PostsPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <title>Posts</title>
</head>
<body>
<div class="container mt-5">
    <h1>All Posts</h1>
    <ul class="list-group">
        @for(var post : page.getPosts()) {
        <li class="list-group-item">
            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
        </li>
        }
        @endfor
    </ul>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item @{page.getCurrentPage() == 1 ? 'disabled' : ''}">
                <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() - 1}">Previous</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
