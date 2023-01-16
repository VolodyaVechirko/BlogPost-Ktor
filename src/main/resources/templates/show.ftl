<#-- @ftlvariable name="article" type="com.example.models.Article" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            ${article.title}
        </h3>
        <p>
            ${article.body}
        </p>
        <p>
            <a href="/articles/${article.id}/edit"><button>Edit post</button></a>
        </p>
    </div>
</@layout.header>