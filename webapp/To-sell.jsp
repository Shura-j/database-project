<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <title>To sell page</title>

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

    
    <!-- Custom styles for this template -->
    <link href="checkout.css" rel="stylesheet">
  </head>
  <body >

<div class="container mt-4">

	<div class="card shadow-sm rounded">
		<div class="card-body">
			<h5 class="card-title">${userName}</h5>
			<p>
			Email: ${userEmail} <br/>
			Phone: ${userPhone}
			</p>
		</div>
	</div>
	the user is ${userName}
	<h4 class="text-center mb-3 display-4">Register here to sell your book</h4>
    <div class="row" >
    	<div class="col"></div>
      <div class="col-lg-8">
        ${alert}
        <form class="needs-validation" method="post" action="/book_store/add_book">
          <div class="row g-3 mb-5">

            <div class="col-md-6">
              <label for="name" class="form-label">Book Name</label>
              <div class="input-group has-validation">
	              <input type="text" class="form-control" name="bname" id="name" required />
	              <div class="invalid-feedback">
	                 Book Name is required.
	              </div>
              </div>
            </div>

            <div class="col-md-6">
              <label for="bauthor" class="form-label">Book Author</label>
              <div class="input-group has-validation">
	              <input type="text" class="form-control" name="bauthor" id="bauthor" required />
	              <div class="invalid-feedback">
	                 Your author name is required.
	              </div>
              </div>
            </div>
            
            <div class="col-md-6">
	              <label for="btype" class="form-label">Book type</label>
	              <select class="form-select" name="btype" id="btype" required>
	                <option value="">Choose...</option>
	                <option>tarik</option>
	                <option>yetmhrt</option>
	                <option>lb weled</option>
	              </select>
	              <div class="invalid-feedback">
	                Please provide a valid type.
	              </div>
	            </div>
	            <div class="col-md-6">
	              <label for="price" class="form-label">Book Price</label>
	              <input type="number" class="form-control" name="bprice" id="price" placeholder="Price" required>
	              <div class="invalid-feedback">
	                Please enter your selling price.
	              </div>
	            </div>
	            
	            <div class="col-12">
	              <label for="quantity" class="form-label">Book Copies Quantity</label>
	              <input type="number" class="form-control" min="1" max="10000" name="bquantity" id="quantity" placeholder="Number of Copies" required>
	              <div class="invalid-feedback">
	                Please enter how many copies do you have.
	              </div>
	            </div>
	            
	            <div class="col-12">
	              <label for="description" class="form-label">Book Description</label>
	              <TextArea class="form-control" name="bdescription" id="decription" placeholder="Describe the book" ></TextArea>
	              <div class="invalid-feedback">
	                Please enter description of the book content in simple words.
	              </div>
	            </div>

            </div>
           	<button class="btn btn-success btn-lg" type="submit" value="sell">Add Book</button>
        </form>
		</div>
		<div class="col"></div>
	</div>

  <footer class="my-5 pt-5 text-body-secondary text-center text-small">
    <p class="mb-1">&copy; 2017/2023 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

    <script src="checkout.js"></script></body>
</html>
    