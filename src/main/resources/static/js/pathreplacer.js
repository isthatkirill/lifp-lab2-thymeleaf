let formURLWithoutId = document.getElementById('myForm').action;

document.getElementById('factSelect').addEventListener('change', function () {
    let factId = this.value;
    if (factId) {
        document.getElementById('myForm').action = formURLWithoutId + "/" + factId;
    } else {
        document.getElementById('myForm').action = formURLWithoutId;
    }
});
