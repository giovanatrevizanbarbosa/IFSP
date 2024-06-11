const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
});

var myModal = document.getElementById('myModal');
var bsModal = new bootstrap.Modal(document.getElementById('myModal'));
myModal.addEventListener('show.bs.modal', function (event) {
    // Botão que acionou o modal
    var button = event.relatedTarget;
    // Extrair informações dos atributos data-bs-*
    var id = button.getAttribute('data-bs-id');

    // Atualizar o conteúdo do modal
    var modalTitle = myModal.querySelector('.modal-title');
    var modalButton = myModal.querySelector('.modal-footer #delete');

    modalTitle.textContent = 'Excluir Atividade ' + id;
    modalButton.addEventListener('click', ()=>{
        deleteActivity(button, id);
        bsModal.hide();
    });
});

function deleteActivity(button, id) {
    var row = button.parentNode.parentNode.parentNode // button->span->td->tr
    const url =  `activityRegister?action=remove&activity-id=${id}`;
    fetch(url)
        .then(response =>{
            return response.json(); // converte para json
        })
        .then(data =>{
            if (data) {
                row.parentNode.removeChild(row); // remover linha da tabela
            }
        })
        .catch(error => console.log('Erro de solicitação', error)); // lidar com os erros por catch
}