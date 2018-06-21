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

    <title>Exam Page</title>

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
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/MyBook?index=0">MyBook<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="http://localhost:9999/ReciteWebApp/Review?method=show">Review<span class="sr-only">(current)</span></a>
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
        <h1></h1>
    </main>

	<main role="main" class="container">
	    <button class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#ModalA">${A}</button>
    </main>

	<main role="main" class="container">
        <h1></h1>
    </main>

	<main role="main" class="container">
	    <button class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#ModalB">${B}</button>
    </main>

	<main role="main" class="container">
        <h1></h1>
    </main>

	<main role="main" class="container">
	    <button class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#ModalC">${C}</button>
    </main>
	<main role="main" class="container">
        <h1></h1>
    </main>

	<main role="main" class="container">
	    <button class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#ModalD">${D}</button>
    </main>

	<div class="modal fade" id="ModalA" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">You choose A</h5>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		  </div>
		  <div class="modal-body" id = "result">
			  ${messageA}
		  </div>
		  <div class="modal-footer">
			<a class="btn btn-primary" href="http://localhost:9999/ReciteWebApp/Exam/Result?wid=${wid}&&bid=${bid}&&state=${stateA}" role="button">Next</a>
		  </div>
		</div>
	  </div>
	</div>

	<div class="modal fade" id="ModalB" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">You choose B</h5>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		  </div>
		  <div class="modal-body" id = "result">
			  ${messageB}
		  </div>
		  <div class="modal-footer">
			<a class="btn btn-primary" href="http://localhost:9999/ReciteWebApp/Exam/Result?wid=${wid}&&bid=${bid}&&state=${stateB}" role="button">Next</a>
		  </div>
		</div>
	  </div>
	</div>

	<div class="modal fade" id="ModalC" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">You choose C</h5>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		  </div>
		  <div class="modal-body" id = "result">
			  ${messageC}
		  </div>
		  <div class="modal-footer">
			<a class="btn btn-primary" href="http://localhost:9999/ReciteWebApp/Exam/Result?wid=${wid}&&bid=${bid}&&state=${stateC}" role="button">Next</a>
		  </div>
		</div>
	  </div>
	</div>

	<div class="modal fade" id="ModalD" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">You choose D</h5>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		  </div>
		  <div class="modal-body" id = "result">
			  ${messageD}
		  </div>
		  <div class="modal-footer">
			<a class="btn btn-primary" href="http://localhost:9999/ReciteWebApp/Exam/Result?wid=${wid}&&bid=${bid}&&state=${stateD}" role="button">Next</a>
		  </div>
		</div>
	  </div>
	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>/js/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="<%=basePath%>/js/popper.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
</body></html>