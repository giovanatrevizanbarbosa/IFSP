const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
});

const myModal = document.getElementById('myModal');
myModal.addEventListener('show.bs.modal', function (event) {
    // Botão que acionou o modal
    const button = event.relatedTarget;
    // Extrair informações dos atributos data-bs-*
    const id = button.getAttribute('data-bs-id');

    // Atualizar o conteúdo do modal
    const modalTitle = myModal.querySelector('.modal-title')
    const modalFooterA = myModal.querySelector('.modal-footer a')

    modalTitle.textContent = 'Excluir Atividade ' + id;
    modalFooterA.href = 'activityRegister?action=remove&activity-id=' + id;
})