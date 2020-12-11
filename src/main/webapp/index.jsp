<html>
<body>

<form action="save-person" method="post">
    <label for="namePost"> Name: </label> <input type="text" name="name" id="namePost">
    <label for="lastNamePost"> Last Name: </label> <input type="text" name="lastName" id="lastNamePost">
    <label for="birthdatePost"> Birthdate: </label> <input type="text" name="birthdate" id="birthdatePost">
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

<%--CREATE NEW FORMS--%>

</body>
</html>
