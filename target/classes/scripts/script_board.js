/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let board_directory = document.getElementById("username").innerText;

function complete_task(timeslotid, taskid) {
    console.log("completing timeslot " + timeslotid + " task " + taskid);


    request({url: window.location + "/fn/task-compl?ts=" + timeslotid + "&id=" + taskid})
            .then(data => {
                console.log("Task completion success");
            })
            .catch(error => {
                console.log("An error occured while trying to complete a task. " + error);
                alert("An error occured while trying to complete a task. " + error); //should remove the alerts at one point
            });


    location.reload();
}

function add_task(timeslotid) {
    console.log("Adding a task to timeslot " + timeslotid);

    let content = prompt("Task content");

    if (content === "") {
        console.log("Tried to add task but content was null");
        return;
    }
    
    request({url: window.location + "/fn/task-add?ts=" + timeslotid, body: content, method: "PUT"})
            .then(data => {
                console.log("Task addition success");
            })
            .catch(error => {
                console.log("An error occured while trying to add a task. " + error);
                alert("An error occured while trying to add a task. " + error); //should remove the alerts at one point
            });

    location.reload();
}

function remove_task_setup(timeslotid) {
    let timeslots = document.getElementsByClassName("list");
    let complbtns = timeslots[timeslotid].getElementsByClassName("checkbox");
    
    for (i = 0; i < complbtns.length; i++){
        complbtns[i].setAttribute("onclick", "remove_task(" + timeslotid + ", " + i + ")");
        complbtns[i].setAttribute("style", "transform: rotate(45deg);");
        complbtns[i].setAttribute("src", "/images/plus-beta.png");
    }
}

function remove_task(timeslotid, taskid){
    //do the removing
    console.log("removing task " + timeslotid + " . " + taskid);
    
    request({url: window.location + "/fn/task-rm?ts=" + timeslotid + "&id=" + taskid})
            .then(data => console.log("Task removal success"))
            .catch(error => {
                    console.log("An error occured while trying to remove a task. " + error);
                    alert("An error occured while trying to remove a task. " + error);
            });
    
    location.reload();
    
}