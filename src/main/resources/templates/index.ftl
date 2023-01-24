<#-- @ftlvariable name="articles" type="kotlin.collections.List<com.example.models.Article>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list articles?reverse as article>
      <!-- Blog entry -->
      <div class="w3-card-4 w3-margin w3-white">
        <img src="/static/post_woods.jpeg" alt="Nature" style="width:100%">
        <div class="w3-container">
          <h3><b>${article.title}</b></h3>
          <h5>Title description, <span class="w3-opacity">April 7, 2014</span></h5>
        </div>

        <div class="w3-container">
          <p>${article.body}</p>

          <div class="w3-row">
            <div class="w3-col m8 s12">
              <p><a href="/articles/${article.id}">
              <button class="w3-button w3-padding-large w3-white w3-border"><b>READ MORE »</b></button>
              </a></p>
            </div>
            <div class="w3-col m4 w3-hide-small">
              <p><span class="w3-padding-large w3-right"><b>Comments </b> <span class="w3-badge">2</span></span></p>
            </div>
          </div>
        </div>
      </div>
      <hr>
    </#list>
</@layout.header>