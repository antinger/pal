$(function () {

    /**
     * Some examples of how to use features.
     *
     **/

    

    setTimeout(function () {
        // $('#disconnected').modal('show');
        // $('#call').modal('show');
        // $('#videoCall').modal('show');
    }, 1000);

    $(document).on('submit', '.layout .content .chat .chat-footer form', function (e) {
        e.preventDefault();

        var input = $(this).find('input[type=text]');
        var message = input.val();

        message = $.trim(message);

        if (message) {
            RobaExamle.Message.add(message, 'outgoing-message');
            input.val('');

            setTimeout(function () {
                RobaExamle.Message.add();
            }, 1000);
        } else {
            input.focus();
        }
    });
});