<?php

	// 1. import the databse connection
	include("db-admin.php");

	// SINGLE PAGE

	// 	1. separate out your post & get request
	if ($_SERVER["REQUEST_METHOD"] == "GET") {
		//	2. write code for GET request
		echo "<h1> I GOT GET REQUEST! </h1>";

		$id = $_GET["id"];

		// 3.  MAKE a SQL QUERY
		$query = "SELECT * from products where id=" . $id;

		$results = mysqli_query($conn, $query);

		// you can do this becuse there's only 1 result that
		// comes from the database
		$product = mysqli_fetch_assoc($results);

	}
	else if ($_SERVER["REQUEST_METHOD"] == "POST") {

		// 	3. write code for POST request
		echo "<h1> I GOT POST REQUEST! </h1>";

		// get the data from the form
		$id = $_POST["product_id"];
		$name = $_POST["name"];
		$desc = $_POST["desc"];
		$price = $_POST["price"];

		// 3.  MAKE a SQL QUERY

		$query = 	"UPDATE products ";
		$query .= 	"SET ";
		$query .= 	"name= '" . $name . "', ";
		$query .= 	"product_desc='" . $desc . "', ";
		$query .= 	"price='" . $price . "' " ;
		$query .=	"WHERE ";
		$query .= 	"id=" . $id;


		echo $query ."<br>";

		$results = mysqli_query($conn, $query);

		if ($results) {
			echo "OKAY! <br>";

			// command to redirect back to show-products page.
			header("Location: show-products.php");

		}
		else {
			echo "BAD! <br>";
			echo mysqli_error($conn);
		}

	}

?>
<!DOCTYPE html5>
<html>
<title>Edit Product</title>
<head>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
	<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
	<style type="text/css">
		.mdl-grid {
			max-width:1024px;
			margin-top:40px;
		}

		h1 {
			font-size:36px;
		}
		h2 {
			font-size:30px;
		}
	</style>

</head>
<body>

	<div class="mdl-grid">
	  <div class="mdl-cell mdl-cell--12-col">
	  	<h1> Edit Product </h1>
		<h2> Edit your product info below: </h2>

		<!-- form -->
		<!-- @TODO: Update your form action/method here -->
		<form id="edit_form" action="edit-product.php" method="POST">
		  <div id="form_input">
			<input name="product_id"
					value="<?php echo $id; ?>"
					hidden=true
			>


			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<!-- @TODO: update NAME and ID! -->
				<input 	name="name"
						class="mdl-textfield__input"
						type="text"
						id="name"
						value="<?php echo $product["name"]; ?>">


				<label class="mdl-textfield__label" for="sample3">Product Name</label>
			</div>
			<br>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<!-- @TODO: update NAME and ID! -->
				<input	name="desc"
						class="mdl-textfield__input"
						type="text"
						id="descp"
						value="<?php echo $product["product_desc"]; ?>">

				<label class="mdl-textfield__label" for="sample3">Description</label>
			</div>
			<br>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<!-- @TODO: update NAME and ID! -->
				<input 	name="price"
						class="mdl-textfield__input"
						type="text"
						pattern="-?[0-9]*(\.[0-9]+)?"
						id="price"
						value="<?php echo $product["price"]; ?>"
						>
				<label class="mdl-textfield__label" for="sample2">Price</label>
				<span class="mdl-textfield__error">Input is not a number!</span>
			</div>
			<br>
        </div>
		  <!-- @TODO: Update the link  -->
		  <div id="update_btn">
		  <button  class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
			Update
		  </button>
		  </div>
		</form>

		<br>

		<a href="show-products.php" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
			< Go Back
		</a>
	  </div>
	</div>

</body>
</html>
