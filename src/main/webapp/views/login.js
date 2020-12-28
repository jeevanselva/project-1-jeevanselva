async function loginSubmission(e){
    e.preventDefault();
    let userName = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    const credentials = {
        username:userName,
        password:password
    }

    try {
    let response = await fetch ("http://localhost.8080/ers/login", {
        method: "POST",
        body: JSON.stringify(credentials),
        headers: {
            "Content-Type":"application/json"
        }
    })

} catch (e) {
    console.log(e);
}
}

document.getElementsByTagName("form")[0].addEventListener('submit',loginSubmission);