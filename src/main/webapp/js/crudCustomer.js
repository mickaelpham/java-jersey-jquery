function refreshCustomers() {
	$('#customers').empty();
	
	$.getJSON('rest/customers',function(data){
		$('#load').hide();
		
		var items = [];
		items.push('<tr><th>Contact</th><th>Email</th><th>Phone</th><th colspan="2">Actions</th></tr>');
		
		$.each(data,function(id,customer){
			items.push('<tr><td>' + customer.name + '</td><td><a href="mailto:' + customer.email + '">'
					+ customer.email + '</a></td><td>' + customer.phone + '</td>'
					+ '<td><a href="rest/customer-' + customer.id + '" class="edit">Edit</a></td>'
					+ '<td><a href="rest/customer-' + customer.id + '" class="del">Delete</a></td></tr>');
		});
		
		$('<table/>',{
			html: items.join('')
		}).appendTo('#customers');
		
		// Edit link
		$('.edit').click(function(event){
			event.preventDefault();
			var editUrl = $(this).attr('href');
			$.getJSON(editUrl,function(customer){
				$('#name').val(customer.name);
				$('#email').val(customer.email);
				$('#phone').val(customer.phone);
				$('#customerId').val(customer.id);
				$('#formTitle').html('Edit customer "' + customer.name + '"');
				$('#submitButton').html('Edit customer');
				$('#cancelLink').html('or <a href="index.html">cancel editing</a>')
			});
		});
		
		// Delete link
		$('.del').click(function(event){
			event.preventDefault();

			var r = confirm('Do you really want to delete this customer?');
			if (r) {
				var delUrl = $(this).attr('href');
				$.ajax({
					url:delUrl,
					type:'DELETE'
				})
				refreshCustomers();
			}
		});
	});
}

$(function(){
	$('#load').click(function(){
		refreshCustomers();
	});
	
	$('#addForm').submit(function(event){
		// Prevents the current link to be followed by the browser
		event.preventDefault();
		
		// Check if we want to create or edit a customer
		if ($('#customerId').val() == 0) {
			$.post('rest/customer', $(this).serialize(), function(){
				refreshCustomers();
				$('#addForm')[0].reset();
				$('#name').focus();
			});
		} else {
			var customerId = $('#customerId').val();
			$.ajax({
				url:'rest/customer-'+customerId,
				type:'PUT',
				data:$(this).serialize(),
				success:function(){
					refreshCustomers();
					$('#addForm')[0].reset();
					$('#formTitle').html('Add a customer');
					$('#submitButton').html('Add customer');
					$('#customerId').val(0);
					$('#name').focus();
					$('#cancelLink').empty();
				}
			});
		}
	});
});