<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' media='screen'
	href='${pageContext.servletContext.contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css'>
<link rel='stylesheet' media='screen'
	href='${pageContext.servletContext.contextPath}/webjars/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css'>

<script
	src="${pageContext.servletContext.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/webjars/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>


<script type="text/javascript">
	$(function() {
		$('#minTripStartDate').datepicker('');
		$('#maxTripStartDate').datepicker('');
	});
</script>
</head>
<body>

	<div class="navbar">
		<div class="container-fluid" style="margin-top: 10px;">
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">Oops! Error occurred while
					retrieving data, please try again later</div>
			</c:if>

			<c:if test="${deals ne null and empty deals}">
				<div class="alert alert-warning">Oops! No data found, please
					check the search criteria</div>
			</c:if>
			<form class="form-horizontal" method="post"
				action="${pageContext.servletContext.contextPath}/deals/filterHotelDeals.htm">
				<div class="form-group">
					<label class="control-label col-sm-2" for="destinationCity">Destination
						City</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="destinationCity"
							value="${destinationCity}" name="destinationCity"
							placeholder="e.g Amman" required="required">
					</div>
					<label class="control-label col-sm-2" for="destinationName">Destination
						Name</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="destinationName"
							value="${destinationName}" name="destinationName"
							placeholder="e.g Dead Sea">
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-sm-2" for="minTripStartDate">Minimum
						Trip Start Date</label>

					<div class="date col-sm-4">
						<input class="form-control" size="10" type="text"
							data-date-format="yyyy-mm-dd" id="minTripStartDate"
							value="${minTripStartDate}" name="minTripStartDate"
							placeholder="YYYY-MM-DD" /> <span class="add-on"><i
							class="icon-th"></i></span>
					</div>

					<label class="control-label col-sm-2" for="maxTripStartDate">Maximum
						Trip Start Date</label>
					<div class="date col-sm-4">
						<input data-date-format="yyyy-mm-dd" type="text"
							class="form-control" size="10" id="maxTripStartDate"
							value="${maxTripStartDate}" name="maxTripStartDate"
							placeholder="YYYY-MM-DD" /><span class="add-on"><i
							class="icon-th"></i></span>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="lengthOfStay">Length
						Of Stay</label>
					<div class="col-sm-4">
						<input type="number" step="1" min="0" max="365"
							class="form-control" id="lengthOfStay" name="lengthOfStay"
							value="${lengthOfStay}" placeholder="Length of Stay (Days)">
					</div>
					<label class="control-label col-sm-2" for="regionIds">Region
						ID's</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="regionIds"
							value="${regionIds}" name="regionIds"
							placeholder="Region ID's (Comma Seperated)">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="minStarRating">Minimum
						Star Rating</label>
					<div class="col-sm-4">
						<input type="number" min="1" max="5" step="1" class="form-control"
							id="minStarRating" name="minStarRating" value="${minStarRating}"
							placeholder="Minimum Star Rating">
					</div>
					<label class="control-label col-sm-2" for="maxStarRating">Maximum
						Star Rating</label>
					<div class="col-sm-4">
						<input type="number" min="1" max="5" step="1" class="form-control"
							id="maxStarRating" name="maxStarRating" value="${maxStarRating}"
							placeholder="Maximum Star Rating">
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-sm-2" for="minTotalRate">Minimum
						Rate</label>
					<div class="col-sm-4">
						<input type="number" min="0" step="1" class="form-control"
							id="minTotalRate" name="minTotalRate" value="${minTotalRate}"
							placeholder="Amount in USD, for example: 100.00">
					</div>
					<label class="control-label col-sm-2" for="maxTotalRate">Maximum
						Rate</label>
					<div class="col-sm-4">
						<input type="number" min="0" step="1" class="form-control"
							id="maxTotalRate" name="maxTotalRate" value="${maxTotalRate}"
							placeholder="Amount in USD, for example: 180.00">
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-sm-2" for="minGuestRating">Minimum
						Guest Rating</label>
					<div class="col-sm-4">
						<input type="number" min="0" max="10" step="0.01"
							class="form-control" id="minGuestRating" name="minGuestRating"
							value="${minGuestRating}" placeholder="Minimum Guest Rating">
					</div>
					<label class="control-label col-sm-2" for="minGuestRating">Maximum
						Guest Rating</label>
					<div class="col-sm-4">
						<input type="number" min="0" max="10" step="0.01"
							class="form-control" id="maxGuestRating" name="maxGuestRating"
							value="${maxGuestRating}" placeholder="Maximum Guest Rating">
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Search</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="panel-group">
		<c:forEach var="deal" items="${deals}">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<img src="${deal.hotelInfo.hotelImageUrl}" /> <span
							style="vertical-align: top;"> <a
							style="vertical-align: top;" data-toggle="collapse"
							href="#${deal.hotelInfo.hotelId}">${deal.hotelInfo.hotelName}
								(${deal.hotelPricingInfo.totalPriceValue}&nbsp;${deal.hotelPricingInfo.currency}
								) </a>
						</span>
						<c:choose>
							<c:when test="${deal.hotelInfo.hotelGuestReviewRating eq 2.5}">
								<c:set var="rateColor" value="blue" />
							</c:when>
							<c:when test="${deal.hotelInfo.hotelGuestReviewRating gt 2.5}">
								<c:set var="rateColor" value="green" />
							</c:when>
							<c:when test="${deal.hotelInfo.hotelGuestReviewRating lt 2.5}">
								<c:set var="rateColor" value="red" />
							</c:when>
						</c:choose>
						<span style="float: right; font-weight: bold; color: ${rateColor}">

							${deal.hotelInfo.hotelGuestReviewRating} / 5 </span>
					</h4>

				</div>
				<div id="${deal.hotelInfo.hotelId}" class="panel-collapse collapse">
					<div class="panel-body">
						<div>${deal.destination.city},${deal.destination.country}</div>
						<div>
							<c:set var="frm" value="" />
							<c:forEach var="itm" varStatus="varStatus"
								items="${deal.offerDateRange.travelStartDate}">
								<c:set var="frm"
									value="${frm}${itm}${varStatus.count lt 3?'-':''}" />
							</c:forEach>
							${frm} &nbsp;to&nbsp;
							<c:set var="to" value="" />
							<c:forEach var="itm" varStatus="varStatus"
								items="${deal.offerDateRange.travelEndDate}">
								<c:set var="to"
									value="${to}${itm}${varStatus.count lt 3?'-':''}" />
							</c:forEach>
							${to}&nbsp;(${deal.offerDateRange.lengthOfStay} Days)
						</div>
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>