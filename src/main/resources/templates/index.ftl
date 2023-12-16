<#-- @ftlvariable name="postList" type="kotlin.collections.List<models.Post>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list postList?reverse as post>
      <!-- Blog entry -->
      <div class="w3-card-4 w3-margin w3-white">
        <img src="${post.coverImage}" alt="Nature" style="width:100%">
        <div class="w3-container">
          <h3><b>${post.title}</b></h3>
          <h5>${post.subtitle}, <span class="w3-opacity">${post.date}</span></h5>
        </div>

        <div class="w3-container">
          <p>${post.body}</p>

          <div class="w3-row">
            <div class="w3-col m8 s12">
              <p><a href="/articles/${post.id}">
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