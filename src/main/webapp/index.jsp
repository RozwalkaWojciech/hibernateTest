<!DOCTYPE>
<html lang="pl">
<head>
    <title> Hibernate </title>
</head>
<body>

<form action="save-person" method="post">
    <label for="namePost"> Name: </label> <input type="text" name="name" id="namePost">
    <label for="lastNamePost"> Last Name: </label> <input type="text" name="lastName" id="lastNamePost">
    Birthdate
<%--    change type text to date--%>
    <label for="yearPost"> Year(yyyy): </label> <input type="text" name="year" id="yearPost">
    <label for="monthPost"> Month(MM): </label> <input type="text" name="month" id="monthPost">
    <label for="dayPost"> Day(dd): </label> <input type="text" name="day" id="dayPost">
    <button type="submit"> SAVE</button>
</form>

<br>

<form action="find-person" method="post">
    <label for="idPost"> Find by ID: </label> <input type="text" name="id" id="idPost">
    <button type="submit"> FIND</button>
</form>

<br>

<form action="edit-person" method="post">
    <label for="idToEdit"> Person to edit: </label> <input type="text" name="id" id="idToEdit">
    <label for="name"> New name: </label> <input type="text" name="name" id="name">
    <label for="lastName"> New last name: </label> <input type="text" name="lastName" id="lastName">
    <label for="birthdate"> New birthdate: </label> <input type="text" name="birthdate" id="birthdate">
    <button type="submit"> EDIT</button>
</form>

<br>

<form action="remove-person" method="post">
    <label for="idToRemove"> Person to remove: </label> <input type="text" name="id" id="idToRemove">
    <button type="submit"> REMOVE</button>
</form>

</body>
</html>
