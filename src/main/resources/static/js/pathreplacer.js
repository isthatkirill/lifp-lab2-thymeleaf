document.getElementById('factSelect').addEventListener('change', function () {
    let factId = this.value;
    let form = document.getElementById('deleteForm');
    form.action = '/expert-system/facts/delete/' + factId;
});