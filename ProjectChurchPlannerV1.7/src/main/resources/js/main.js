/* 
 Add a confirmation warning before deleting the record
 */

$('document').ready(function(){
    $('table #deleteButton').on('click', function (event) {
        console.log("Hello from js");
        $('#deleteModal').modal();
    })
});

