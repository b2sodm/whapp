/* 
 * productfilter.js
 */
var rsl;
var flt;
var res;
var done = 0;
var par = " ";
//alert("start.#1");

$(document).ready(function(){
   //alert("using jquery.#3");
   $('#result').change(function(){
       flt = $('#txbFilter').val();
       res = $('#result').val();
       if(flt === "sup")
       {
           $('#divResult').text(res);
           $('#divResult').hide("slow");
           $('#divResult2').hide("slow");
           if(done === 1)
           {
               par = [flt, res, "sup1", "01"];
               $('#divResult').load("result.jsp?wcode="+par+"");
               done = 4;
           }
           $('#divResult').show("slow");
       }
       else
       {
           $('#divResult2').text(res);
           $('#divResult2').hide("slow");
           $('#divResult').hide("slow");
           if(done === 2)
           {
               par = [flt, res, "cat2", "02"];
               $('#divResult2').load("result.jsp?wcode="+par+"");
               done = 5;
           }
           $('#divResult2').show("slow");
       }
       
   });
});

function init()
{
    //alert("using js.#4");
    document.getElementById('btnOK').onclick = function() {
      rsl = document.getElementById('result').value;
      flt = document.getElementById('txbFilter').value;
      //alert("# "+flt +": "+rsl);
      if(flt === "cat")
      {
          done = 2;
      }
      else
      {
          done = 1;
      }
      $('#result').change();
    };
}

window.onload = function()
{
    init();
};
//alert("done.#2");
