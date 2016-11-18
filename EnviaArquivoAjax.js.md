# Enviar arquivo com Ajax
#### Obs: requer o jquery
```js
var $form = $("#archive-form");
var formData = new FormData();
var params = $form.serializeArray();
var files = $form.find('[name="fileup"]')[0].files;

$.each(files, function (i, file) {
    formData.append('arquivo-' + i, file);
});

$.each(params, function (i, val) {
    formData.append(val.name, val.value);
});

$.ajax({
    url: "../assets/requests/archive.php",
    type: "POST",
    data: formData,
    contentType: false,
    processData: false
}).done(function (a) {
    console.log(a);
}).fail(function (b, c, d) {
    console.log(b, c, d);
});
```
