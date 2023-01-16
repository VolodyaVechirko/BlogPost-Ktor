<#-- @ftlvariable name="article" type="com.example.models.Article" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit article</h3>
        <form action="/articles/${article.id}" method="post">
            <p>
                <input type="text" name="title" value="${article.title}">
            </p>
            <p>
                <textarea name="body">${article.body}</textarea>
            </p>
            <p>
                <button name="_action" value="update">Update post</button>
            </p>
        </form>
    </div>
    <div>
        <form action="/articles/${article.id}" method="post">
            <p>
                <button name="_action" value="delete">Delete post</button>
            </p>
        </form>
    </div>
</@layout.header>