<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/resources/css/style.css">
    <script type="text/javascript" src="/resources/js/app.js"></script>
    <title>Customer List</title>
</head>
<body>

<div class="form">
    <form method="post">
        <center>
            <table>
                <tr>
                    <td><h3>Please chose an option</h3></td>
                    <td>&nbsp;&nbsp;</td>
                    <td>
                        <div class="select">
                            <select name="code" onchange="this.form.submit()">
                                <
                                <option ${'Select' == code ? 'selected="selected"' : ''} value="Select">Select</option>
                                <option ${'All' == code ? 'selected="selected"' : ''} value="All"
                                                                                      title="Select all Numbers including Invalid">
                                    All
                                </option>
                                <option ${'Invalid' == code ? 'selected="selected"' : ''}
                                        title="Show all Invalid Numbers that doesn't belong to any country"
                                        value="Invalid">
                                    Invalid Numbers
                                </option>
                                <option ${'237' == code ? 'selected="selected"' : ''} value="237" title="+237">
                                    Cameroon
                                </option>
                                <option ${'251' == code ? 'selected="selected"' : ''} value="251" title="+251">
                                    Ethiopia
                                </option>
                                <option ${'212' == code ? 'selected="selected"' : ''} value="212" title="+212">Morocco
                                </option>
                                <option ${'258' == code ? 'selected="selected"' : ''} value="258" title="+258">
                                    Mozambique
                                </option>
                                <option ${'256' == code ? 'selected="selected"' : ''} value="256" title="+256">Uganda
                                </option>
                            </select>
                        </div>
                    </td>
                </tr>
            </table>
        </center>
        <br><br>
        <center>
            <table class="numbers">
                <thead style="text-align:center">
                <c:if test="${ (not countryList.isEmpty()) && (countryList.size() > 1)}">
                    <tr>
                        <th>Index</th>
                        <th>Phone Number</th>
                        <th>Customer name</th>
                        <th>State</th>
                    </tr>
                </c:if>
                </thead>
                <c:forEach items="${countryList}" var="country" varStatus="index">
                    <tr>
                        <td>
                            <center>${index.index+1}</center>
                        </td>
                        <td>
                            <center>${country.phone}</center>
                        </td>
                        <td>
                            <center>${country.name}</center>
                        </td>


                        <c:if test="${country.isInvalid}">
                            <td class="invalid">
                                <center>
                                    Not Valid
                                </center>
                            </td>
                        </c:if>
                        <c:if test="${not country.isInvalid}">
                            <td class="valid">
                                <center>
                                    Valid
                                </center>
                            </td>
                        </c:if>


                    </tr>
                </c:forEach>

            </table>
        </center>
    </form>
</div>

</body>
</html>
