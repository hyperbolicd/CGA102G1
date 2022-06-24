<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.report.model.*" %>
<%@ page import="com.member.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>檢舉管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_all.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back_end/css/emp_footer.css">

    <!-- ***************************自己的CSS****************************** -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/back_end/ManageReport/report_main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.2.1/font-awesome-animation.min.css">
    <!-- ***************************自己的CSS****************************** -->
</head>

<body>
    <header>
        <nav>
            <div id="logo">
                <img src="${pageContext.request.contextPath}/back_end/logo2noline.jpg">
            </div>
            <h2>員工後台操作系統</h2>
            <ul>
                <li>登出</li>
            </ul>
        </nav>
    </header>
    <aside id="aside">
    <%@ include file="/back_end/aside_html.jsp"%>         
    </aside>
    <!-- ********************************************* -->
    <main>
        <div id="main">
            <div class="notifybox" >
                <div class="alertbox">
                    <div class="alert fade alert-simple alert-warning alert-dismissible text-left font__family-montserrat font__size-16 font__weight-light brk-library-rendered rendered show" role="alert" data-brk-library="component__alert">
                    <i class="start-icon fa fa-exclamation-triangle faa-flash animated"></i>
                    <strong class="font__weight-semibold">請注意!</strong>  您有 3 則檢舉尚未處理 !
                    </div>
                </div>
                <div class="alertbox">
                    <div class="alert fade alert-simple alert-success alert-dismissible text-left font__family-montserrat font__size-16 font__weight-light brk-library-rendered rendered show">
                        <i class="start-icon far fa-check-circle faa-tada animated"></i>
                        <strong class="font__weight-semibold">太棒了!</strong> 目前沒有檢舉需要處理 !
                    </div>
                </div>
            </div>
            <div class="tablebox" style="border:solid 0px red ;">
                <table id="maintable" class="table table-hover table-bordered single-ellipsis">
                    <thead>
                        <tr>
                            <th>檢舉單號</th>
                            <th>被檢舉人編號</th>
                            <th>被檢舉人姓名</th>
                            <th>評論編號</th>
                            <th>檢舉人編號</th>
                            <th>檢舉人姓名</th>
                            <th>檢舉類別</th>
                            <th>狀態</th>
                            <th>功能區</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="organisationnumber">140406</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="organisationname">sanctus est</td>
                            <td class="actions">
                                <a href="?" class="btn btn-secondary" title="Remove" >管理檢舉</a>
                            </td> 
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
    
    
    
    <!-- ********************************************* -->
    <footer>
        嗨邇覓影城 &copy; HIREME CINEMA 2022
    </footer>
</body>

</html>