<%-- 
    Document   : nurse_dashboard
    Created on : 29 May, 2017, 10:50:59 AM
    Author     : 59347937
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.DataConnect"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

        <link href="css1/bootstrap.css" rel="stylesheet" type="text/css" media="all" />

        <link rel="stylesheet" href="css1/style.css" type="text/css" media="all" />

        <link href="css1/font-awesome.css" rel="stylesheet"> 

        <link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
        <!-- //font -->
        <script src="js1/jquery-1.11.1.min.js"></script>
        <script src="js1/bootstrap.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script> 


        <title>Dashboard </title>

        <!-- Bootstrap -->
        <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-wysiwyg -->
        <link href="../vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
        <!-- Select2 -->
        <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet">
        <!-- Switchery -->
        <link href="../vendors/switchery/dist/switchery.min.css" rel="stylesheet">
        <!-- starrr -->
        <link href="../vendors/starrr/dist/starrr.css" rel="stylesheet">
        <!-- bootstrap-daterangepicker -->
        <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../build/css/custom.min.css" rel="stylesheet">
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <%@include file="common_blank.jsp" %>
                        <div class="navbar nav_title" style="border: 0;"> </div>
                        <div class="clearfix">   </div>
                    </div>
                </div>

                <!-- top navigation -->

                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <ul class="nav navbar-nav navbar-right">   
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->
                <%@include file="blank2.jsp"%>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">
                                        <h2><b>Dashboard</b></h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--<div class="clearfix"></div>-->
                        <!--<div class="row">-->
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <!--<div class="x_content">-->

                                <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left"  action="<%=request.getContextPath()%>/DashboardController" method="post">

                                    <div class="container"> 
                                        <div class="team-main">
                                            <div class="team-bottom">

                                                <%
                                                    DataConnect dcnt = new DataConnect();
                                                    Connection conn = null;
                                                    try {
                                                        conn = dcnt.getConnect();
                                                        String str = "SELECT * FROM tbl_modules where module_id IN (select module_id from tbl_category_module_mapping where category_id=3)";
                                                        Statement st = conn.createStatement();
                                                        ResultSet rst = st.executeQuery(str);

                                                        while (rst.next()) {


                                                %>

                                                <div class="col-md-3 team-grids">
                                                    <!-- normal -->    
                                                    <div class="ih-item circle effect5">
                                                        <div class="img">
                                                            <!--<a href="#" id="img" onclick="document.location = this.id + '.html';return false;" >-->
                                                            <img src="<%=rst.getString(3)%>" alt="img" class="img-responsive"/>
                                                            <!--</a>-->
                                                        </div>
                                                        <div class="info">
                                                            <div class="info-back">
                                                                <h3><%=rst.getString(2)%></h3>		          
                                                            </div>			          
                                                        </div>
                                                    </div>

                                                    <div class="team-bottom-info">
                                                        <br>
                                                        <br>	
                                                    </div>
                                                    <!-- end normal -->	

                                                </div>
                                                <%
                                                        }
                                                    } catch (Exception e) {

                                                    }
                                                %>	                
                                                <!-- end normal -->			 

                                                <div class="clearfix"> </div>                                         
                                            </div>                     
                                        </div>         
                                    </div>



                                </form>
                                <!--									</div>-->
                            </div>
                        </div>
                        <!--						</div>-->

                    </div>  
                </div>

            </div>
            <!-- /page content -->


            <!-- /footer content -->
        </div>


        <!-- jQuery -->
        <script src="../vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../vendors/nprogress/nprogress.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="../vendors/iCheck/icheck.min.js"></script>
        <!-- bootstrap-daterangepicker -->
        <script src="../vendors/moment/min/moment.min.js"></script>
        <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
        <!-- bootstrap-wysiwyg -->
        <script src="../vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
        <script src="../vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
        <script src="../vendors/google-code-prettify/src/prettify.js"></script>
        <!-- jQuery Tags Input -->
        <script src="../vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
        <!-- Switchery -->
        <script src="../vendors/switchery/dist/switchery.min.js"></script>
        <!-- Select2 -->
        <script src="../vendors/select2/dist/js/select2.full.min.js"></script>
        <!-- Parsley -->
        <script src="../vendors/parsleyjs/dist/parsley.min.js"></script>
        <!-- Autosize -->
        <script src="../vendors/autosize/dist/autosize.min.js"></script>
        <!-- jQuery autocomplete -->
        <script src="../vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
        <!-- starrr -->
        <script src="../vendors/starrr/dist/starrr.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="../build/js/custom.min.js"></script>
        <script src="js1/jarallax.js"></script>
        <script src="js1/SmoothScroll.min.js"></script>
        <script type="text/javascript">
            /* init Jarallax */
            $('.jarallax').jarallax({
                speed: 0.5,
                imgWidth: 1366,
                imgHeight: 768
            })
        </script>
        <!-- //jarallax -->
        <script src="js1/SmoothScroll.min.js"></script>
        <script type="text/javascript" src="js1/move-top.js"></script>
        <script type="text/javascript" src="js1/easing.js"></script>
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */

                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <!-- //here ends scrolling icon -->
        <script src="js1/modernizr.custom.js"></script>

    </body>

</html>
