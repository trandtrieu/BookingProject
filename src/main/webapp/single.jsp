<%--
    Document   : single
    Created on : May 21, 2023, 12:22:04 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Single Tour Detail</title>
        <%@include file="includes/head.jsp" %>
        <style>
            .tour-image {
                width: 100%;
                height: auto;
            }
        </style>
    </head>
    <body>
        <%@include file="includes/topbar.jsp" %>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-6">
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 1">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 2">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 3">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 4">
                            </div>
                            <div class="carousel-item">
                                <img src="img/${detail.imageTour}" class="d-block w-100" alt="Image 5">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>



                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a id="menu1-tab"  class="nav-link active" data-toggle="tab" href="#home">Lịch trình</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#menu1">Điều khoản và chính sách</a>
                        </li>

                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div id="home" class="container tab-pane active"><br>
                            <h3>Schedule</h3>
                            <p> ${detail.day1}</p> <br>
                            <p> ${detail.day2}</p> <br>
                            <p> ${detail.day3}</p> <br>
                            <p> ${detail.day4}</p> <br>
                            <p> ${detail.day5}</p> <br>
                            <p> ${detail.day6}</p> <br>
                            <p> ${detail.day7}</p> <br>


                        </div>

                        <%@include file="includes/policies.jsp" %>


                    </div>

                </div>

                <div class="col-md-6">

                    <div class="col-md-12">
                        <h1>${detail.tourName} <span class="badge badge-danger">New</span></h1>

<!--                         <h2> ${detail.tourName} </h2>-->
                        <p><strong>Price: </strong><fmt:formatNumber value=" ${detail.price}" pattern="#,##0" /> VND</p>

                        <p><strong>Departure Date:</strong> ${detail.dateStart}</p>
                        <p><strong>Return Date:</strong> ${detail.dateEnd}</p>
                        <p><strong>Place:</strong> ${detail.placeName}</p>
                        <p><a href="detailGuide?gid=${detail.guideId}">
                                <strong>Your guide:</strong> ${detail.guideName}
                            </a></p>
                        <p>${detail.detailTour}</p> 


                        <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">Book Now</button>

                        <div id="demo" class="collapse mt-3" >
                            <form action="BookingServlet" method="post" >
                                <div class="form-group">
                                    <label for="fullName">Họ tên:</label>
                                    <input type="text" name="fullName" class="form-control" id="fullName" placeholder="Nhập họ tên" value="" minlength="3"  required>
                                </div>
                                <div class="form-group">
                                    <label for="phone">Số điện thoại:</label> 
                                    <input type="number" class="form-control"  name="phone" id="phone" pattern="[-+]?[0-9]" placeholder="Nhập số điện thoại" minlength="10" maxlength="10" value="" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Nhập địa chỉ email" value="" required>
                                </div>
                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <input type="address" class="form-control" name="address" id="address" placeholder="Nhập địa chỉ" value="" required>
                                </div>
                                <div class="form-group">
                                    <label for="adults">Số lượng người lớn:</label>
                                    <input type="number" class="form-control" id="adults" name="adults" placeholder="Nhập số lượng người lớn" min="1" value="1">
                                </div>
                                <div class="form-group">
                                    <label for="children">Số lượng trẻ em:</label>
                                    <input type="number" class="form-control" id="children" name="children" placeholder="Nhập số lượng trẻ em" min="0">
                                </div>

                                <div class="form-group">
                                    <label for="note">Ghi chú:</label>
                                    <textarea class="form-control" id="note" name="note" rows="3" placeholder="Nhập ghi chú" value="hello" required></textarea>
                                </div>



                                <input type="hidden" name="id" value="${detail.tourId}">
                                <button type="submit" class="btn btn-primary">Đặt vé</button>
                            </form>
                        </div>
                        <div class="col-md-12 mt-5">
                            <h4 class="text-uppercase mb-4" style="letter-spacing: 5px;">Some new tours</h4>
                            <c:forEach var="r" items="${tRelated}" varStatus="status">
                                <div class="d-flex align-items-center text-decoration-none bg-white mb-3">
                                    <img class="img-fluid" src="img/${r.imageTour}" alt="" width="100" height="100">
                                    <div class="pl-3">
                                        <h6 class="m-1" id="tour-${r.tourId}" onclick="redirectToDetail('${r.tourId}')" style="cursor: pointer">${r.tourName}</h6>
                                        <small>Jan 01, 2050</small>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>


                </div>
            </div>



            <!-- Blog End -->

            <%@include file="includes/footer.jsp" %>

    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://web8802.com/wp-content/themes/hienads/assets/js/quanhuyen.js"></script>

    <%@include file="includes/foot.jsp" %>

</html>