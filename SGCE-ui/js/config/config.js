URL_BASE = "http://localhost:8080/";
TOTAL_REGISTROS = "5";



$('.dropdown-button').dropdown({
    inDuration: 300,
    outDuration: 225,
    constrainWidth: false, // Does not change width of dropdown to that of the activator
    hover: false, // Activate on hover
    gutter: 0, // Spacing from edge
    belowOrigin: true, // Displays dropdown below the button
    alignment: 'right', // Displays dropdown with edge aligned to the left of button
    stopPropagation: false // Stops event propagation
}
                              );

$(".button-collapse").sideNav();


$('.collapsible').collapsible();
$('select').material_select();

var diaSemana = [ 'Domingo', 'Segunda-Feira',
                 'Terca-Feira', 'Quarta-Feira', 'Quinta-Feira',
                 'Sexta-Feira', 'Sabado' ];
var mesAno = [ 'Janeiro', 'Fevereiro', 'Marco', 'Abril',
              'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
              'Outubro', 'Novembro', 'Dezembro' ];
var data = new Date();

$('select').material_select();

$('.datepicker').pickadate(
    {
        selectMonths : true,
        selectYears : 15,
        format : 'yyyy-mm-dd',
        monthsFull : mesAno,
        monthsShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
                       'Mai', 'Jun', 'Jul', 'Ago', 'Set',
                       'Out', 'Nov', 'Dez' ],
        weekdaysFull : diaSemana,
        weekdaysShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
                         'Qui', 'Sex', 'Sab' ],
        weekdaysLetter : [ 'D', 'S', 'T', 'Q', 'Q',
                          'S', 'S' ],
        clear : "Limpar",        
        today : "Hoje",
        close : "X",
        min : new Date(data.getFullYear() - 5, 0, 1),
        max : new Date(data.getFullYear() + 1, 11, 31),
        closeOnSelect : true        
    });

$(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
});

 $('.modal').modal({
      dismissible: true, // Modal can be dismissed by clicking outside of the modal
      opacity: .5, // Opacity of modal background
      inDuration: 300, // Transition in duration
      outDuration: 200, // Transition out duration
      startingTop: '4%', // Starting top style attribute
      endingTop: '10%', // Ending top style attribute
      ready: function(modal, trigger) { // Callback for Modal open. Modal and trigger parameters available.
       
      },
      complete: function() { alert('Closed'); } // Callback for Modal close
    }
  );