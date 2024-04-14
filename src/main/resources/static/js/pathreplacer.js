let formURLWithoutId = document.getElementById('myForm').action;

document.getElementById('mySelect').addEventListener('change', function () {
    let option = this.value;
    if (option) {
        document.getElementById('myForm').action = formURLWithoutId + "/" + option;
    } else {
        document.getElementById('myForm').action = formURLWithoutId;
    }
});
