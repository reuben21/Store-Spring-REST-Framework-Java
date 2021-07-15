<h2>
A Store REST application using Spring Boot
</h2>

<h3>What was your motivation?</h3>
<ul>
  <li> To Learn Spring Boot and its Many New Features </li>
</ul>
<h3>Why did you build this project?</h3>
<ul>
  <li> To Learn How REST API's work with Spring Boot</li>
</ul>
<!-- <h3>What problem does it solve?</h3>
<ul>
  <li> To Learn How REST API's work with Spring Boot</li>
</ul> -->
<h3>What did you learn?</h3>
<ul>
  <li> Implement Spring Security </li>
  <li> Spring Boot Automatically creates tables in the database </li>
  <li> Also Learned to Perform Custom Queries </li>
</ul>
<br></br>
<h4> Below is the image of The REST Framework Designed and the flow of the project</h4>

<img src="https://firebasestorage.googleapis.com/v0/b/projects-in-java.appspot.com/o/SpringFrameworkcarg.svg?alt=media&token=8b47c3f4-008b-4115-a753-f65cda84a1ae" alt="error"/>

<br></br>

<h3>The GET APIs</h3>
<ol>
<li>To Fetch Products Before A Certain Date<br>
@GetMapping("/product/purchase/{vendor_id}")</li>
<br>
<li>To Fetch Customer From A Certain Vendor<br>
@GetMapping("/customer/purchase/{vendor_id}")</li>
<br>
<li>To Fetch Products From the Ceratin City, City Field is Stored in Profile<br>
@GetMapping("/product/customer/{city}")</li>
<br>
</ol>
<h3>The POST APIs</h3>
<ol>
<li>To Create A vendor <br> @PostMapping("/vendor")
</li>
<br>
<li> To Create A Customer  <br>  @PostMapping("/customer")
</li>
<br>
<li> To Update Customer Profile <br> @PostMapping("/customer/{customer_id}")
</li>
<br>

<li> To Add A Product To the Vendor, Where Vendor Can be Identified By his ID <br> @PostMapping("addproduct/{vendor_id}")
</li>
<br>
<li> For A Customer to  Purchase A Product , where customer id and product id will be taken <br>     @PostMapping("/customer/product/{customer_id}/{product_id}")
</li>
<br>
</ol>
