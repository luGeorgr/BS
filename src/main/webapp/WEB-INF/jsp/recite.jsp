<%@page contentType="text/html" pageEncoding = "utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<!-- saved from url=(0057)https://getbootstrap.com/docs/4.1/examples/navbar-static/ -->
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Recite Page</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath%>/css/navbar-top.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" >ReciteWebApp</a>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/homepage.com">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/MyBook">MyBook<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/Review">Review<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/Exam">Exam<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/Progress?lexicon=CET4">Progress<span class="sr-only">(current)</span></a>
          </li>
        </ul>
		<ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="http://localhost:9999/ReciteWebApp/ChoosePage">Back</a>
        </li>
		</ul>
      </ul>
      </div>
    </nav>

    <main role="main" class="container">
      <div class="jumbotron">
        <h1>${word}</h1>
      </div>
    </main>

	<main role="main" class="container">
      <div class="jumbotron">
        <p class="lead">${meaning}</p>
      </div>
    </main>

	<main role="main" class="container">
      <div class="jumbotron">
        <a class="btn btn-lg btn-primary" href="http://localhost:9999/ReciteWebApp/Recite/UnKnow" role="button">Don't Know »</a>
		<a class="btn btn-lg btn-primary" href="http://localhost:9999/ReciteWebApp/Recite/Know?wid=${wid}" role="button">I Know it »</a>
		<a class="btn btn-lg btn-primary" href="http://localhost:9999/ReciteWebApp/Recite/AddBook?wid=${wid}" role="button">Add To MyBook »</a>
      </div>
	  <div class="progress">
		<div class="progress-bar" id = "displayBar" style="width: ${progressPercent}; background: linear-gradient(to right, #cc5345 35%, #ff7f36 68%);">
			<div class="progress-value" id = "displayNumber">${progressPercent}</div>
	    </div>
	  </div>
    </main>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>/js/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="<%=basePath%>/js/popper.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
</body></html>