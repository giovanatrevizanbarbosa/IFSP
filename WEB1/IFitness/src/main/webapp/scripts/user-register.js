"use strict"
window.onload = initPage;

function initPage(){
    let form;
    form = document.querySelector('#form1');
    // desativar a validação automática do HTML5
    form.noValidate = true;
    form.addEventListener('submit', (e)=>{
        let valid = processValidation(this);
        if(!valid){
            e.preventDefault();
        }
    });
}

function processValidation(form){
    let valid;
    validatePassword(form);
    valid = applyValidation(form);
    return valid;
}

function applyValidation(form){
    let valid = true;
    let count = 0;
    let elements= form.elements;
    for(let i = 0; i < elements.length - 1; i++){
        let element = elements[i];
        let span =  document.querySelector(`#${i}`);
        if(!element.validity.valid){
            span.innerHTML = element.validationMessage;
            count++;
        }else{
            span.innerHTML = "";
        }
    }
    if(count > 0){
        valid = false;
    }
    return valid;
}

function validatePassword(form){
    let password = form.querySelector('#password');
    let confirmPassword = form.querySelector('#confirmPassword');
    if(password.value !== confirmPassword.value){
        password.setCustomValidity("Os valores dos campos de senha e confirmação de senha devem ser iguais.");
    }else{
        password.setCustomValidity("");
    }
}