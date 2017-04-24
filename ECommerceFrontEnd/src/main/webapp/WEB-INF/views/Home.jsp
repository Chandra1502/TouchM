<%@include file="Header.jsp"%>

<!-- This is to check if the comment is being uploaded to Git. -->



<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="resources/images/AndroidLogo.jpg" alt="Android">
			<div class="carousel-caption">
				<h3>Android</h3>
				<!-- <p>The atmosphere in Chania has a touch of Florence and Venice.</p> -->
			</div>
		</div>

		<div class="item">
			<img src="resources/images/BlackberryOSLogo.jpeg" alt="BlackBerry">
			<div class="carousel-caption">
				<h3>Blackberry</h3>
				<!-- <p>The atmosphere in Chania has a touch of Florence and Venice.</p> -->
			</div>
		</div>
		
		<div class="item">
			<img src="resources/images/AppleLogo.jpg" alt="Apple">
			<div class="carousel-caption">
				<h3>Apple</h3>
				<!-- <p>Beatiful flowers in Kolymbari, Crete.</p> -->
			</div>
		</div>

		<div class="item">
			<img src="resources/images/WindowsLogoJPG.jpg" alt="Windows">
			<div class="carousel-caption">
				<h3>Windows</h3>
				<!-- <p>Beatiful flowers in Kolymbari, Crete.</p> -->
			</div>
		</div>
	</div>

	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>

<%@include file="Footer.jsp"%>