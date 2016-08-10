<%@ page pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
  <div class="container container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-header">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="navbar-header">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#" onclick="javascript:navClick(this);">普通专利(Common)</a></li>
        <li><a href="#" onclick="javascript:navClick(this);">专利项目(Project)</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search"/>
        </div>
      </form>
    </div>
  </div>
</nav>