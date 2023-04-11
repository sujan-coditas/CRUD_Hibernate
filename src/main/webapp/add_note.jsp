<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Add Notes</title>
    <%@ include file="formating.jsp"%>
  </head>
  <body>
  <div class="container">
  <%@ include file="navbar.jsp"%> </div>

<h3> Enter your Note</h3>
<br>
   <!-- user input form -->

   <form action=" SaveNoteServ " method="post">
     <div class="form-group">
       <label for="title">Note Title</label>
       <input
        name="title"
        required
         type="text"
        class="form-control"
        id="title"
        placeholder="Enter here">
     </div>

     <div class="form-group">
       <label for="NoteContent">Note Content</label>
       <textarea required
        name="content"
        id="content"
       placeholder="Enter your Content"
       class="form-control"
       style="height:250px;">
        </textarea>
     </div>


     <button type="submit" class="btn btn-primary">Add</button>
   </form>


    </body>
</html>