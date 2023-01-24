<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="w3-card-4 w3-margin w3-white">
      <div class="w3-container">
        <h3 class="w3-center">NEW STORY</h3>
        <form action="/articles" method="post">
          <p>
            <label>Title</label>
            <input class="w3-input w3-border" type="text" name="title">
          </p>
          <p>
            <label>Content</label>
            <textarea class="w3-input w3-border" rows="16" name="body"></textarea>
          </p>
          <p>
            <button class="w3-button w3-padding-large w3-white w3-border"><b>UPLOAD STORY »</b></button>
          </p>
        </form>
      </div>
    </div>
    <hr>
</@layout.header>