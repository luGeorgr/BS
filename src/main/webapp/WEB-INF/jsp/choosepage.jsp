<%@page contentType="text/html" pageEncoding = "utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Choose Book To Recite</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath%>/css/jumbotron.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="http://localhost:9999/ReciteWebApp/ChoosePage">ReciteWebApp</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/homepage.com">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="http://localhost:9999/ReciteWebApp/MyBook">MyBook</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="http://localhost:9999/ReciteWebApp/Review">Review</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="http://localhost:9999/ReciteWebApp/Exam">Exam</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link active" href="http://localhost:9999/ReciteWebApp/Progress">Progress</a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Welcome To ReciteWebApp</h1>
          <p>In ReciteWebApp You can recite words. You can get a lot</p>
		  <p>Please join us!</p>
          <p><a class="btn btn-primary btn-lg" href="http://localhost:9999/ReciteWebApp/MoreInfo" role="button">Learn more »</a></p>
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2>CET 4</h2>
            <h2>CET 4</h2>
			<p><a class="btn btn-info" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=CET4&&number=20" role="button">Learn 20 words »</a></p>
            <p><a class="btn btn-success" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=CET4&&number=40" role = "button">Learn 40 words »</a></p>
			<p><a class="btn btn-danger" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=CET4&&number=60" role = "button">Learn 60 words »</a></p>
		 </div>
          <div class="col-md-4">
            <h2>CET 6</h2>
			<p><a class="btn btn-info" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=CET6&&number=20" role="button">Learn 20 words »</a></p>
            <p><a class="btn btn-success" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=CET6&&number=40" role = "button">Learn 40 words »</a></p>
			<p><a class="btn btn-danger" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=CET6&&number=60" role = "button">Learn 60 words »</a></p>
          </div>
          <div class="col-md-4">
            <h2>GRE</h2>
			<p><a class="btn btn-info" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=GRE&&number=20" role="button">Learn 20 words »</a></p>
            <p><a class="btn btn-success" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=GRE&&number=40" role = "button">Learn 40 words »</a></p>
			<p><a class="btn btn-danger" href="http://localhost:9999/ReciteWebApp/Recite?lexicon=GRE&&number=60" role = "button">Learn 60 words »</a></p>
          </div>
        </div>

        <hr>

      </div> <!-- /container -->

    </main>

    <footer class="container">
      <p>© Recite English WebApp</p>
    </footer>


</body></html>