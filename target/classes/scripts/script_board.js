/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let board_directory = document.getElementById("username").innerText;

function complete_task(timeslotid, taskid){
    console.log("completing timeslot " + timeslotid + " task " + taskid);
    
    
    request({url: window.location + "/fn/task-compl?ts=" + timeslotid + "&id=" + taskid})
            .then(data => {
                console.log("Task completion success");
            })
            .catch(error => {
                console.log("An error occured.");
                alert("An error occured while trying to complete a task.");
            });
            
    
    location.reload();
}