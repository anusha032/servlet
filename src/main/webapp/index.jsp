<!DOCTYPE html>
<html>
<head>
<title>Student Result Form</title>

<script>
function validateForm() {

    var roll = document.forms["studentForm"]["rollno"].value;
    var name = document.forms["studentForm"]["sname"].value;

    var s1 = document.forms["studentForm"]["sub1"].value;
    var s2 = document.forms["studentForm"]["sub2"].value;
    var s3 = document.forms["studentForm"]["sub3"].value;
    var s4 = document.forms["studentForm"]["sub4"].value;
    var s5 = document.forms["studentForm"]["sub5"].value;

    if (roll == "" || name == "" ||
        s1 == "" || s2 == "" ||
        s3 == "" || s4 == "" || s5 == "") {

        alert("All fields must be filled!");
        return false;
    }

    if (s1 < 0 || s1 > 100 ||
        s2 < 0 || s2 > 100 ||
        s3 < 0 || s3 > 100 ||
        s4 < 0 || s4 > 100 ||
        s5 < 0 || s5 > 100) {

        alert("Marks must be between 0 and 100");
        return false;
    }

    return true;
}
</script>

</head>

<body>

<h2>Student Result Entry</h2>

<form name="studentForm"
      action="ResultServlet"
      method="post"
      onsubmit="return validateForm()">

Roll No:
<input type="text" name="rollno"><br><br>

Student Name:
<input type="text" name="sname"><br><br>

Subject 1:
<input type="number" name="sub1"><br><br>

Subject 2:
<input type="number" name="sub2"><br><br>

Subject 3:
<input type="number" name="sub3"><br><br>

Subject 4:
<input type="number" name="sub4"><br><br>

Subject 5:
<input type="number" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>