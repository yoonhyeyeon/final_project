document.addEventListener('DOMContentLoaded', function() {
    fetch('/util/header.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('headerContainer').innerHTML = data;
        });
});

document.addEventListener('DOMContentLoaded', function() {
    fetch('/util/footer.html')
    .then(response => response.text())
    .then(data => {
        document.getElementById('footerContainer').innerHTML = data;
    });
})

document.addEventListener('DOMContentLoaded', function() {
    fetch('/home/nav.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('navContainer').innerHTML = data;
        });
});


document.addEventListener('DOMContentLoaded', function() {
    fetch('/home/sidebar.html')
    .then(response => response.text())
    .then(data => {
        document.getElementById('sidebar').innerHTML = data;
    });
})


