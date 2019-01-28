<?php
	// LOGIC => getting all the products from the db
	$dbhost = "localhost";
	$dbuser = "root";
	$dbpassword = "root";
	$dbname = "store";

	$conn = mysqli_connect($dbhost,$dbuser,$dbpassword,$dbname);

	$query = "SELECT * from locations";

	$results = mysqli_query($conn, $query);

	print_r($results);
?>
<?php
	// UI BOBAGEM => importing the html for the header
	include("header.php");
?>
	<title>Location</title>
    <!-- underneath the menu -->
    <section class="section">
		
      <div class="container">
        <h1 class="title has-text-centered">LOCATIONS</h1>
        <h2 class="subtitle has-text-centered">
          We have many locations to serve you!
        </h2>
      </div>
    </section>

    <section class="section">
      <div class="container">
        	<!-- @TODO:  put your products in here -->
			<?php
				//1. get the results from database and output to screen
				echo '<div class="columns">';
					echo '<div class="column has-text-centered">';
					while( $location = mysqli_fetch_assoc($results) ) {
						echo '<div class= "all_locations" style="margin-top:20px">';
							echo '<p>' . $location["name"] . '</p>';
							echo '<p>' . $location["street"] . '</p>';
							echo '<p>' . $location["city"] . ', ' . $location["province"] . '</p>';
						echo '</div>';
					}
					echo '</div>';
				echo '</div>';
			?>
      </div>
    </section>
		
  </body>
</html>

<?php
	// be a good citizen and close out your database connection here

?>
