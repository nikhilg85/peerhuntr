<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            h1{
                text-align: center;
            }
            table{
                width: 100%;
            }
            table,tr,td,th{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <c:if test="${view=='getQuestion'}">
            <form action="question" method="post">
                <table width="100%" cellpadding="10px">
                        <tr>
                            <th style="width: 80%">Question Text</th>
                          
                           <td align="center">${c.questionText}</td>
                        </tr>
                        <tr>
                          <c:forEach var="c" items="${list}">
                        <th style="width: 10%">Answer</th>
                        <td align="center">${c.answer}</td>
                         <th></th>
                              
                            <th></th>
                        </tr>
                        </c:forEach>
                      
                        
                         
                            <tr>
                             
                                
                                
                                
                            </tr>
                        
                </table>
            </form>
       </c:if>
    </body>
</html>
