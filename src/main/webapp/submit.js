let userId = 2
async function reimbursementSubmission(e){
    e.preventDefault();
    let type = document.getElementById("loanType").value
    let amount = document.getElementById("inputAmount").value
    let description = document.getElementById("inputText").value

    const reimbursement = {
        authorId:userId,
        amount:amount,
        description:description,
        type:type
    }

    try {
    let response = await fetch ("http://localhost:8080/ers/reimbursement", {
        method: "POST",
        body: JSON.stringify(reimbursement),
        headers: {
            "Content-Type":"application/json"
        }
    })

    let data = await response.json()
    console.log(data.reimbursementId)

} catch (e) {
    console.log(e);
}
}

document.getElementsByTagName("form")[0].addEventListener('submit',reimbursementSubmission);