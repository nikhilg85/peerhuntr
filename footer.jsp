<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- start footer --> 
        <footer class="footer-strip-dark bg-extra-dark-gray padding-50px-tb xs-padding-30px-tb">
            <div class="container">
                <div class="row equalize xs-equalize-auto">
                    <!-- start logo -->
                    <div class="col-md-3 col-sm-3 col-xs-12 display-table sm-text-center xs-margin-20px-bottom" style="">
                        <div class="display-table-cell vertical-align-middle">
                            <a href='<spring:url value="/home"/>'><img class="footer-logo"src="<c:url value='/resources/images/logo-white.png' />"  alt="Pofo"></a>
                        </div>
                    </div> 
                    <!-- end logo -->
                    <!-- start copyright -->
                    <div class="col-md-6 col-sm-6 col-xs-12 text-center text-small alt-font display-table xs-margin-10px-bottom" style="">
                        <div class="display-table-cell vertical-align-middle">
                            © 2017 peerHuntr is designed by <a href="#" target="_blank" title="">Infodart Technologies</a>.
                        </div>
                    </div>
                    <!-- end copyright -->
                    <!-- start social media -->
                    <div class="col-md-3 col-sm-3 col-xs-12 display-table text-right sm-text-center" style="">
                        <div class="display-table-cell vertical-align-middle">
                            <div class="social-icon-style-8 display-inline-block vertical-align-middle">
                                <ul class="small-icon no-margin-bottom">
                                    <li><a class="facebook text-white" href="https://www.facebook.com/" target="_blank"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                    <li><a class="twitter text-white" href="https://twitter.com/" target="_blank"><i class="fa fa-twitter"></i></a></li>
                                    <li><a class="google text-white" href="https://plus.google.com/" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                    <li><a class="instagram text-white" href="https://instagram.com/" target="_blank"><i class="fa fa-instagram no-margin-right" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- end social media -->
                </div>
            </div>
        </footer>
        <!-- end footer -->
        <!-- start scroll to top -->
        <a class="scroll-top-arrow" href="javascript:void(0);"><i class="ti-arrow-up"></i></a>
        <!-- end scroll to top  -->
        <!-- javascript libraries -->
        <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>" > </script>
       <script type="text/javascript" src="<c:url value="/resources/js/modernizr.js"/>" > </script>
       <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>" > </script>
       <script type="text/javascript" src="<c:url value="/resources/js/jquery.easing.1.3.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/resources/js/skrollr.min.js"/>" > </script>
       <script type="text/javascript" src="<c:url value="/resources/js/smooth-scroll.js"/>" > </script>
         <script type="text/javascript" src="<c:url value="/resources/js/jquery.appear.js"/>" > </script>
        <!-- menu navigation -->
        <script type="text/javascript" src="<c:url value="/resources/js/bootsnav.js"/>" > </script>
         <script type="text/javascript" src="<c:url value="/resources/js/jquery.nav.js"/>" > </script>
       <!-- animation -->
         <script type="text/javascript" src="<c:url value="/resources/js/wow.min.js"/>" > </script>
        <!-- page scroll -->
       <script type="text/javascript" src="<c:url value="/resources/js/page-scroll.js"/>" > </script>
        <!-- swiper carousel -->
       <script type="text/javascript" src="<c:url value="/resources/js/swiper.min.js"/>" > </script>
        <!-- counter -->
       <script type="text/javascript" src="<c:url value="/resources/js/jquery.count-to.js"/>" > </script>
        <!-- parallax -->
        <script type="text/javascript" src="<c:url value="/resources/js/jquery.stellar.js"/>" > </script>
        <!-- magnific popup -->
         <script type="text/javascript" src="<c:url value="/resources/js/jquery.magnific-popup.min.js"/>" > </script>
        <!-- portfolio with shorting tab -->
         <script type="text/javascript" src="<c:url value="/resources/js/isotope.pkgd.min.js"/>" > </script>
        <!-- images loaded -->
      <script type="text/javascript" src="<c:url value="/resources/js/imagesloaded.pkgd.min.js"/>" > </script>
       <!-- pull menu -->
         <script type="text/javascript" src="<c:url value="/resources/js/classie.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/resources/js/hamburger-menu.js"/>" > </script>
        <!-- counter  -->
        <script type="text/javascript" src="<c:url value="/resources/js/counter.js"/>" > </script>
        <!-- fit video  -->
       <script type="text/javascript" src="<c:url value="/resources/js/jquery.fitvids.js"/>" > </script>
        <!-- equalize -->
        <script type="text/javascript" src="<c:url value="/resources/js/equalize.min.js"/>" > </script>
        <!-- skill bars  -->
      <script type="text/javascript" src="<c:url value="/resources/js/skill.bars.jquery.js"/>" > </script> 
        <!-- justified gallery  -->
        <script type="text/javascript" src="<c:url value="/resources/js/justified-gallery.min.js"/>" > </script>
        <!--pie chart-->
         <script type="text/javascript" src="<c:url value="/resources/js/jquery.easypiechart.min.js"/>" > </script>
        <!-- instagram -->
        <script type="text/javascript" src="<c:url value="/resources/js/instafeed.min.js"/>" > </script>
        <!-- retina -->
          <script type="text/javascript" src="<c:url value="/resources/js/retina.min.js"/>" > </script>
        <!-- revolution -->
      <script type="text/javascript"src="<c:url value="/resources/revolution/js/jquery.themepunch.tools.min.js"/>" > </script>
        <script type="text/javascript" src="<c:url value="/resources/revolution/js/jquery.themepunch.revolution.min.js"/>" > </script>
         
         
       
        <!-- revolution slider extensions (load below extensions JS files only on local file systems to make the slider work! The following part can be removed on server for on demand loading) -->
        <!--<script type="text/javascript" src="revolution/js/extensions/revolution.extension.actions.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.carousel.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.migration.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.navigation.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.parallax.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
        <script type="text/javascript" src="revolution/js/extensions/revolution.extension.video.min.js"></script>-->
        <!-- setting -->
        <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>" > </script>
        <!-- jQuery Custom Scroller CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
       <script type="text/javascript" src="<c:url value="/resources/js/password-show.js"/>" > </script>
       
        <script type="text/javascript">
            $(document).ready(function () {
                $("#sidebar").mCustomScrollbar({
                    theme: "minimal"
                });

                $('#dismiss, .overlay').on('click', function () {
                    $('#sidebar').removeClass('active');
                    $('.overlay').fadeOut();
                });

                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').addClass('active');
                    $('.overlay').fadeIn();
                    $('.collapse.in').toggleClass('in');
                    $('a[aria-expanded=true]').attr('aria-expanded', 'false');
                });
            });
        </script>
        <%--  <script type="text/javascript"src="<c:url value="/resources/js/sweetalert.min.js"/>" > </script>  --%>
         <script type="text/javascript"src="<c:url value="/resources/js/sweetalert2.all.js"/>" > </script>  
       <!--  <script src="https://unpkg.com/sweetalert2@7.7.0/dist/sweetalert2.all.js"></script>  -->
        
        
     <script src="<c:url value='/resources/js/lazy-scroll.js' />"></script> 


<script>
$(document).ready(function () {
    if (!$.browser.webkit) {
        $('.wrapper').html('<p>Sorry! Non webkit users. :(</p>');
    }
});
</script>


    </body>
</html>