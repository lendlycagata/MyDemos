/* for Restful*/
/*$(document).ready(function(){
	 var table=$('#example').DataTable({
		 "sAjaxSource": "/accounts",
			"sAjaxDataProp": "",
			"order":[[0 , "asc"]],
			"aoColumns": [
			      { "mData": "account_ID"},
		          { "mData": "account_NAME" },
				  { "mData": "location" },
				  { "mData": "lob" },
				  { "mData": "business_VERTICAL" },
				  { "mData": "work_TYPE" }
				  { "mData": null }
			],
	  columnDefs:[{
		 targets:[-1],render:function(a, b, data, d){
			  return "<a style='color: #248700; text-decoration: underline; cursor:pointer;'>Edit</a>";
		  }
	  }],
	 }) ;
	 table.on("click", "a", function(){
		var id=table.rows($(this).closest("tr")).data([0].account_ID;
		window.location.href = "/edit" + id;
	 });
 });
*/
$(document).ready( function () {
    $('#accountTable').DataTable();
} );


/*TABLE EDITOR*/
/*account edit*/
$(document).ready(function(){
	
    $('#accountTable').on('click','#editdetails1' ,function() {
	var currentRow=$(this).closest('tr'); 
	
	var col1=currentRow.find('td:eq(0)').text(); // get current row 1st TD value
    var col2=currentRow.find('td:eq(1)').text();
    var col3=currentRow.find('td:eq(2)').text();
    var col4=currentRow.find('td:eq(3)').text();
    var col5=currentRow.find('td:eq(4)').text();
    var col6=currentRow.find('td:eq(5)').text();
    
    /*  hidden columns*/
    var col7=currentRow.find('td:eq(6)').text();
    var col8=currentRow.find('td:eq(7)').text();
    var col9=currentRow.find('td:eq(8)').text();
    var col10=currentRow.find('td:eq(9)').text();
    var col11=currentRow.find('td:eq(10)').text();
    var col12=currentRow.find('td:eq(11)').text();
    var col13=currentRow.find('td:eq(12)').text();
    var col14=currentRow.find('td:eq(13)').text();
    var col15=currentRow.find('td:eq(14)').text();
    var col16=currentRow.find('td:eq(15)').text();
    
    /*tester*/
    /*var data=col1+'\n'+col2+'\n'+col3+'\n'+col4+'\n'+col5;
    
    alert(data);*/
    
    $('#account_id').val(col1);
    $('#account_name').val(col2);
    $('#location').val(col3);
    $('#lob').val(col4);
    $('#business_vertical').val(col5);
    $('#work_type').val(col6);
    
  /*  hidden columns*/
    
    
    $('#image_path').val(col7);
    $('#description').val(col8);
    $('#tm_task').val(col9);
    $('#education').val(col10);
    $('#bpo_exp').val(col11);
    $('#skills').val(col12);
    $('#operating_hours').val(col13);
    $('#skills_premium').val(col14);
    $('#category').val(col15);
    $('#trainings').val(col16);
    
     });

});

/*account mapping*/
$(document).ready(function(){
	
    $('#accountTable').on('click','#editmapping1' ,function() {
    	
	var currentRow=$(this).closest('tr'); 
	
	var col1=currentRow.find('td:eq(0)').text(); // get current row 1st TD value
	var col2=currentRow.find('td:eq(1)').text();
    
   /* tester
    var data=col1+'\n'+col2+'\n'+col3+'\n'+col4+'\n'+col5;
    
    alert(data);*/
	
	alert(col1);
    
    $('#editmapaccountid').val(col1);
    $('#editmapaccountname').val(col2);
     });

});


/*function viewmapping(accountID){
	$.ajax({
		url:"/accountmap/" + accountID,
		data:{ACCOUNT_ID:accountID},
		type:"GET",
		beforeSend:function(){
			$("#tableaccountmaps tbody").empty();
		}
	}).done(function(data){
		
		console.log(data);
		
		$.each( data.accountAnswers, function(i, accountAnswer) {
			
			$("#tableaccountmaps tbody").append("<tr>" +
											"<td>" + data.account_ID + "</td>" +
											"<td>" + accountAnswer.question.question_ID + "</td>" + 
											"<td>" + accountAnswer.question.question + "</td>" + 
											"<td>" + accountAnswer.answer.answer_ID + "</td>" + 
											"<td>" + accountAnswer.answer.answer + "</td>" + 
											"<td>" + "<button class='btn btn-danger'>Delete</button>" + "<td>"+ 
											"</tr>");
			
		})
	});
	

};
*/



/*TABLE EDITOR END*/