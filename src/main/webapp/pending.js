async function checkPending(e){
    e.preventDefault();
    let userName = document.getElementById("inputUserName").value
    let password = document.getElementById("inputPassword").value

    const credentials = {
        userName:userName,
        password:password
    }

    try {
    let response = await fetch ("http://localhost:8080/ers/login", {
        method: "POST",
        body: JSON.stringify(credentials),
        headers: {
            "Content-Type":"application/json"
        }
    })

    let data = await response.json()
    
    if (data.userRole=='manager'){
        window.location.href="/manager/main"
    }
    else if (data.userRole=='employee'){
        window.location.href='/employee/main'
    }
    else { window.location.href='/login'
    
}
    console.log(data)
console.log(location)
} catch (e) {
    console.log(e);
}
}

document.getElementsByTagName("form")[0].addEventListener('submit',loginSubmission);