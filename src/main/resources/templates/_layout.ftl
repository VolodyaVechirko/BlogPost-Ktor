<#-- @ftlvariable name="author" type="models.PageOwner" -->
<#-- @ftlvariable name="tagList" type="kotlin.collections.List<kotlin.String>" -->
<#-- @ftlvariable name="postLinks" type="kotlin.collections.List<models.PostLink>" -->
<#macro header>
  <!DOCTYPE html>
  <html lang="en">
  <head>
    <title>My blog</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <style>
        body, h1, h2, h3, h4, h5 {font-family: "Raleway", sans-serif;}
        textarea {resize: none;}
        a {text-decoration: none;}
    </style>
  </head>
  <body class="w3-light-grey">
  <div class="w3-content" style="max-width:1400px">

    <!-- Header -->
    <header class="w3-container w3-center w3-padding-32">
      <a href="/"><h1><b>MY BLOG</b></h1></a>
      <p>Welcome to my <span class="w3-tag">Travel blog</span></p>
    </header>

    <!-- Grid -->
    <div class="w3-row">

      <!-- Blog entries -->
      <div class="w3-col l8 s12">
          <#nested>
      </div>

      <!-- Introduction menu -->
      <div class="w3-col l4">
        <!-- About Card -->
        <div class="w3-card w3-margin w3-margin-top">
          <img src="${author.avatarUrl}" style="width:100%">
          <div class="w3-container w3-white">
            <h4><b>${author.fullName}</b></h4>
            <p>${author.aboutMe}</p>
            <p>
              <a href="/articles/new" class="w3-button w3-padding-large w3-white w3-border"><b>NEW STORY
                  »</b></a>
            </p>
          </div>
        </div>
        <hr>

        <!-- Posts -->
        <div class="w3-card w3-margin">
          <div class="w3-container w3-padding">
            <h4>Popular Posts</h4>
          </div>
          <ul class="w3-ul w3-hoverable w3-white">
              <#list postLinks?reverse as link>
                <li class="w3-padding-16">
                  <img src="${link.imageUrl}" alt="Image" class="w3-left w3-margin-right"
                       style="width:50px">
                  <span class="w3-large">${link.title}</span><br>
                  <span>${link.subtitle}</span>
                </li>
              </#list>
          </ul>
        </div>
        <hr>

        <!-- Labels / tags -->
        <div class="w3-card w3-margin">
          <div class="w3-container w3-padding">
            <h4>Tags</h4>
          </div>
          <div class="w3-container w3-white">
            <p>
                <#list tagList as tag>
                    <#if tag == author.tag>
                      <span class="w3-tag w3-black w3-margin-bottom">${tag}</span>
                    <#else>
                      <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">${tag}</span>
                    </#if>
                </#list>
            </p>
          </div>
        </div>

        <!-- END Introduction Menu -->
      </div>

      <!-- END GRID -->
    </div>
    <br>

    <!-- END w3-content -->
  </div>

  <!-- Footer -->
  <footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top">
    <button class="w3-button w3-black w3-disabled w3-padding-large w3-margin-bottom">Previous</button>
    <button class="w3-button w3-black w3-padding-large w3-margin-bottom">Next »</button>
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a>, Ktor &
      Freemarker</p>
  </footer>
  </body>
  </html>
</#macro>