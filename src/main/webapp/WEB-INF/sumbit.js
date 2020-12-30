let userId = 2
async function reimbursementSubmission(e){
    e.preventDefault();
    let type = document.getElementById("loan-type").value
    let amount = document.getElementById("inputeAmount").value
    let description = document.getElementById("inputText").value

    const reimbursement = {
        authorId:userId,
        amount:amount,
        description:description,
        type:type
    }

    try {
    let response = await fetch ("http://localhost:8080/ers/login", {
        method: "POST",
        body: JSON.stringify(reimbursement),
        headers: {
            "Content-Type":"application/json"
        }
    })

    let data = await response.json
    console.log("test")

} catch (e) {
    console.log(e);
}
}

document.getElementsByTagName("form")[0].addEventListener('submit',loginSubmission);