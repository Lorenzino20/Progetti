var primo = document.getElementById('primo-numero');
var secondo = document.getElementById('secondo-numero');
var risultato = document.getElementById('risultato');
primo.addEventListener("input", somma);
secondo.addEventListener("input", somma);
function somma() {
    var valorePrimoBox 	= parseFloat(primo.value) || 0;
    var valoreSecondoBox 	= parseFloat(secondo.value) || 0;
    risultato.innerHTML = valorePrimoBox + valoreSecondoBox;
}