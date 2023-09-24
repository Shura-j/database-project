<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<%@ page import="com.shura.domain.*"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <title>Home page</title>

	<link href="./css/bootstrap.min.css" rel="stylesheet" >

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
      #wise {
		  color: red;
	  }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
    </style>

    
  </head>
  <body>
    
    <div class="container py-3">
  <header>
    <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
      

      <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Features</a>
        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Book List</a>
        
        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Pricing</a>
        <!--  form action="login.jsp" method="post">
			<button class="btn btn-primary">Sign In</button>
		</form -->
		<form method="post">
			<a class="btn btn-primary" href="Logout">Log Out</a>
        </form>
      </nav>
    </div>
  </header>
  <%
  User loggedUser = (User)request.getAttribute("user");
  String Username = loggedUser.Name;
  %>
  
<main>
  <div class="container py-4">
  
    <header class="">
      <a href="/" class="d-flex align-items-center text-body-emphasis text-decoration-none">
       
        <span class="fs-4">Welcome to our book store app ${Username}</span>
      </a>
    </header>

    <div class="">
      <div class="">
        <h1 class="">we have anything you want</h1>
        <p class="col-md-8 fs-4">Using a series of utilities, you can create this jumbotron, 
			just like the one in previous versions of Bootstrap. 
			Check out the examples below for how you can remix and restyle it to your liking.</p>
        
      </div>
    </div>

    <div class="row align-items-md-stretch">
      <div class="col-md-6">
        <div class="h-100 p-5 text-bg-dark rounded-3">
          <h2>To sell books</h2>
          <p>Swap the background-color utility and add a `.text-*` color utility to mix up the jumbotron look. Then, mix and match with additional component themes and more.</p>
          <form action="To-sell.jsp" method="post">
          	<button class="btn btn-outline-light">To Sell</button>
          </form>
        </div>
      </div>
      <div class="col-md-6">
        <div class="h-100 p-5 bg-body-tertiary border rounded-3">
          <h2>To buy a books</h2>
          <p>Or, keep it light and add a border for some added definition to the boundaries of your content. Be sure to look under the hood at the source HTML here as we've adjusted the alignment and sizing of both column's content for equal-height.</p>
          <form action="To-buy.jsp" method="post">
			  <button class="btn btn-outline-secondary">To Buy</button>
		  </form>
          
        </div>
      </div>
    </div>

    <footer class="pt-3 mt-4 text-body-secondary border-top">
      &copy; 2023
    </footer>
  </div>
</main>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
    