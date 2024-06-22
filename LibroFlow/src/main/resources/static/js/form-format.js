document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('form').forEach(function(form) {
        form.addEventListener('submit', function() {
            form.querySelectorAll('input[type="text"]').forEach(function(input) {
                input.value = input.value.trim();
            });
        });
    });
});



