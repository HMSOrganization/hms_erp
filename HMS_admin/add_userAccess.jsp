<%@page import="controller.ModuleController" %>
<%@page import="controller.FormController" %>
<%@page import="controller.ReportController" %>
<%@page import="controller.categoryController" %>
<%@page import="controller.userDetailController" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Add user access </title>

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
        <!--bootstrap-daterangepicker -->
        <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">


    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <%@include file="blank.jsp" %>
                        <div class="navbar nav_title" style="border: 0;">  
                        </div>
                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                    </div>
                </div>

                <%@include file="blank2.jsp"%>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title" >
                            <a href="add_userAccess.jsp">  <b>Provide user access</b></a>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">

                                    <div class="x_content">
                                        <br />
                                        
                                        
                                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left"  action="<%=request.getContextPath()%>/UserAccessController">

                                            <input type = "hidden" name = "uname" value="<%= request.getParameter("uname")%>">
                                            <div class="form-group">
                                                <div style="width:100%;">
                                                    <div style="float:left;width:33%;">
                                                        <h4><label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Module:
                                                            </label></h4>
                                                        <br>
                                                        <br>
                                                        
                                                            <c:forEach var="i" items="${sessionScope.listcheck}">
                                                                <input type="checkbox" name="mname" value="${i.getModulename()}" checked="checked">&nbsp;&nbsp;${i.getModulename()}<br/>
                                                            </c:forEach>
                                                                  <c:forEach var="i" items="${sessionScope.listuncheck}">
                                                                <input type="checkbox" name="mname" value="${i.getModulename()}" >&nbsp;&nbsp;${i.getModulename()}<br/>
                                                            </c:forEach>
                                                    
                                                    </div>


                                                    <div style="float:left;width:33%;">
                                                        <h4><label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Form:
                                                            </label></h4>
                                                        <br>
                                                        <br>
                                                            <c:forEach var="i" items="${sessionScope.listfcheck}">
                                                                <input type="checkbox" name="fname" value="${i.getFormname()}" checked="checked">&nbsp;&nbsp;${i.getFormname()}<br/>
                                                            </c:forEach>
                                                             <c:forEach var="i" items="${sessionScope.listfuncheck}">
                                                                <input type="checkbox" name="fname" value="${i.getFormname()}" >&nbsp;&nbsp;${i.getFormname()}<br/>
                                                            </c:forEach>
                                                      

                                                    </div>
                                                    <div style="float:left;width:34%;">
                                                        <h4><label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Report:
                                                            </label></h4>
                                                        <br>
                                                        <br>
                                                            <c:forEach var="i" items="${sessionScope.list3}">
                                                                <input type="checkbox" name="rname" value="">&nbsp;&nbsp;${i.getReportname()}<br/>
                                                            </c:forEach>
                                                       
                                                    </div>
                                                </div>


                                            </div>
                                                <!--                                                <div class="ln_solid"></div>-->

                                       
                                        <div  class="form-group">
                                            <button class="btn btn-primary" type="reset">Reset</button>
                                            <button type="submit" class="btn btn-success"  >Submit</button>
                                        </div>
                                    </form>
                                    </div>
                                </div>
                                 </div>
                             </div>
                            </div>
                        </div>

                        <!-- /page content -->


                        <!-- /footer content -->
                    </div>
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
                <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>-->
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

                </body>
                </html>
