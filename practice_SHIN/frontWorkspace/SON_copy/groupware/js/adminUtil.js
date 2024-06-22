document.addEventListener('DOMContentLoaded', function() {
    fetch('./header.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('headerContainer').innerHTML = data;
        });
});

document.addEventListener('DOMContentLoaded', function() {
    fetch('./nav.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('navContainer').innerHTML = data;
        });
});

document.addEventListener('DOMContentLoaded', function() {
    fetch('./footer.html')
    .then(response => response.text())
    .then(data => {
        document.getElementById('footerContainer').innerHTML = data;
    });
})

document.addEventListener('DOMContentLoaded', function() {
    fetch('./sidebar.html')
    .then(response => response.text())
    .then(data => {
        document.getElementById('sidebar').innerHTML = data;
    });
})