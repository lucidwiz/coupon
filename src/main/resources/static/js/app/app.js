$(document).ready(function() {

    var PAGE_LIST = ['ISSUE', 'LIST'];

    var ajaxRequestCouponIssue = function(emailAddr) {
        $.ajax({
            type: 'POST',
            url: "/api/v1/issue/" + emailAddr,
            dataType: "text",
            success: function(resultData) {
                $('#txt-email-addr').val('');
                alert('Save Complete');
            },
            error: function() {
                alert('Failed!!');
            }
        });
    };

    var ajaxRequestCouponList = function() {
        if ( $.fn.dataTable.isDataTable( '#table-coupon-list' ) ) {
            table = $('#table-coupon-list').DataTable().ajax.reload();
        } else {
            table = $('#table-coupon-list').DataTable({
                ajax: {
                    url: '/api/v1/getlist?pagenum=0&pagesize=10',
                    dataSrc: 'couponList'
                },
                columns: [
                    { data: 'id' },
                    { data: 'email' },
                    { data: 'coupon' },
                    { data: 'issued_time' }
                ]
            });
        }
    };

    var toggleNavMainPageSelected = function(type) {
        if (type === 'ISSUE') {
            $('#nav-page-1').show();
            $('#nav-page-2').hide();
        } else if (type === 'LIST') {
            $('#nav-page-2').show();
            $('#nav-page-1').hide();
        }
    };

    var toggleNavItemSelected = function(type) {
        if (type === 'ISSUE') {
            $('#a-issue-nav').addClass('active');
            $('#a-list-nav').removeClass('active');
        } else if (type === 'LIST') {
            $('#a-issue-nav').removeClass('active');
            $('#a-list-nav').addClass('active');
        }
    };

    $('#btn-coupon-issue').click(function() {
        var emailAddr = $("#txt-email-addr").val();

        if (emailAddr && emailAddr.length > 0) {
            ajaxRequestCouponIssue(emailAddr);
        } else {
            alert('You need to enter valid email address');
        }
    });

    $("#a-issue-nav").click(function() {
        toggleNavMainPageSelected(PAGE_LIST[0]);
        toggleNavItemSelected(PAGE_LIST[0]);
    });

    $("#a-list-nav").click(function() {
        toggleNavMainPageSelected(PAGE_LIST[1]);
        toggleNavItemSelected(PAGE_LIST[1]);

        ajaxRequestCouponList();
    });
});