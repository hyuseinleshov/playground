function changeContent() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("foo").innerHTML =
                this.responseText;
        }
    };
    xhttp.open("GET", "content.txt", true);
    xhttp.send();
}
