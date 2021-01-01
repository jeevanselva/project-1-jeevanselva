
async function checkPastReimbursements(){
    
    try {
    let response = await fetch ("http://localhost:8080/ers/reimbursement", {
        method: "POST",
        //body: JSON.stringify(credentials),
        headers: {
            "method":"GET",
            "Content-Type":"application/json"
        }
    })

    let data = await response.json()

    if (data){
let reimbursements
reimbursements = `<table> 
<thead>
<th>Reimbursement Id</th>
<th>Type</th>
<th>Amount</th>
<th>Description</th>
<th>Date Submitted</th>
<th>Date Resolved</th>
<th>Status</th>
</thead>
<tbody>`
for (i = 0; i <data.length; i++ ) {
    reimbursements += `
    <tr>
<td>{data[0].reimbursementId}</td>
<td>data[0].type}</td>
<td>data[0].amount}</td>
<td>data[0].description}</td>
<td>data[0].dateSubmitted}</td>
<td>data[0].dateResolved}</td>
<td>data[0].status}</td>
    </tr>
</tbody>
</table>
    `
} 
    
let body = getElementsByTagName("body")[0]
let container = document.createElement('div') 
body.appendChild(container)
container.innerHTML=reimbursements
}
    console.log("This works!")

} catch (e) {
    console.log(e);
}
}

checkPastReimbursements()