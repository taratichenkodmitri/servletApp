let signInButton = document.querySelector('.signIn');
let listUsersButton = document.querySelector('.listUsers');

signInButton.addEventListener('click', () => {
    signInButton.style.display = 'none';
    listUsersButton.style.display = 'none';

    createForm();
});

listUsersButton.addEventListener('click', () => {
    signInButton.style.display = 'none';
    listUsersButton.style.display = 'none';

    fetch('http://localhost:8080/hornSite-1.0-SNAPSHOT/list-users').then(function (response) {
        return response.json();
    }).then(function(json) {
       createTable(json);
    }).catch(function (err) {
        console.log('Fetch problem: ' + err.message);
    })
});

function createForm() {
    let registerForm = document.createElement('form');
    registerForm.setAttribute('method', 'post')
    registerForm.setAttribute('action', 'http://localhost:8080/hornSite-1.0-SNAPSHOT/sign-up');

    let labelUsername = createLabel('username');
    registerForm.append(labelUsername);
    let inputUsername = createInput('username', 'text');
    registerForm.append(inputUsername);

    let labelPassword = createLabel('password');
    registerForm.append(labelPassword);
    let inputPassword = createInput('password', 'text');
    registerForm.append(inputPassword);

    let inputSubmit = createInput('password','submit');
    registerForm.append(inputSubmit);

    document.getElementsByTagName('body')[0]
        .appendChild(registerForm);

}

function createLabel(nameLabel) {
    let label = document.createElement('label');
    label.setAttribute('for', nameLabel);
    label.textContent = nameLabel;

    return label;
}

function createInput(name, type) {
    let input = document.createElement('input');
    input.setAttribute('type', type);
    if(type === 'text'){
        input.setAttribute('id', name);
        input.setAttribute('name', name);
    } else  if (type === 'submit') {
        input.setAttribute("value", "sign in");
        input.addEventListener('click', () => {
            console.log('ok');
        });
    }

    return input;
}
function createTable(json){
    let table = document.createElement('table');
    for(let user of json){
        let tr = document.createElement('tr');
        table.appendChild(tr);

        let td = document.createElement('td');
        td.textContent = user.username;
        tr.appendChild(td);

        document.getElementsByTagName('body')[0].appendChild(table);
    }
}