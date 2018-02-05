<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
            <!DOCTYPE html >

            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
                <title>Show All Users</title>
            </head>

            <body>
                <table border=1>
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Continent</th>
                            <th>Region</th>
                            <th>Population</th>
                            <th>Capital</th>
                            <th colspan=6>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                        <c:forEach items="${countries}" var="country">
                            <tr>
                                <td>
                                    <c:out value="${country.code}" />
                                </td>
                                <td>
                                    <c:out value="${country.name}" />
                                </td>
                                <td>
                                    <c:out value="${country.continent}" />
                                </td>
                                <td>
                                    <c:out value="${country.population}" />
                                </td>
                                <td>
                                    <c:out value="${country.region}" />
                                </td>
                                <td>
                                    <c:out value="${country.capital}" />
                                </td>
                             
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
            </body>

            </html>