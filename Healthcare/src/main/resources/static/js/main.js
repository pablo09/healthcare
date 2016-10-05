$(document).ready(function() {

    pageLink('pagelink', 'name');
    pageLink('pagelinkBySellDate', 'sellDate');

    pageFormButton('pagelink', 'name');
    pageFormButton('pagelinkBySellDate', 'sellDate');

    function pageLink(className, sortAttr) {
        $("a." + className).click(function() {
            var url = $(this).attr('href');
            var pageNumber = $(this).attr('page');

            if(_.isNil(pageNumber)) {
                pageNumber = 1;
            }

            var pagination = {
                page: pageNumber - 1,
                size: 9,
                sort: sortAttr + ',asc'
            }

            $(this).attr('href', url + '?' + $.param(pagination));
        });
    };

    function pageFormButton(className, sortAttr) {
        $("button." + className).click(function() {
            var action = $(this).closest('form').attr('action');
            var pageNumber = $(this).attr('page');

            if(_.isNil(pageNumber)) {
                pageNumber = 1;
            }

            var pagination = {
                page: pageNumber - 1,
                size: 9,
                sort: sortAttr + ',asc'
            }

            $(this).closest('form').attr('action', action + '?' + $.param(pagination));
        });
    };
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
      
      $.post('/cart', order)
          .done(function() {
              $.toast(msg.cart.add.success);
          })
          .fail(function(response) {
              $.toast(response.message);
          });
  }
};