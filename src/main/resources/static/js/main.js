$(document).ready(function() {
   $(".pagelink").click(function() {
       var url = $(this).attr('href');
       var pageNumber = $(this).attr('page');

       if(_.isNil(pageNumber)) {
           pageNumber = 1;
       }

       var pagination = {
           page: pageNumber - 1,
           size: 9,
           sort: 'name,asc'
       }

       $(this).attr('href', url + '?' + $.param(pagination));
   })
});

var medicine = {
    goToDetails: function(id) {
        window.location.href = 'medicine/details/' + id;
    }
};

var cart = {
  add: function() {
      var order = {
          medicineId: $("#medicineId").val(),
          quantity: $("#quantityId").val()
      };
      
      $.post('/api/cart', order)
          .done(function() {
              $.toast(msg.cart.add.success);
          })
          .fail(function(response) {
              $.toast(response.message);
          });
  }
};