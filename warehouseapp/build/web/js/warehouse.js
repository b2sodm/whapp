/* 
 * warehouse.js
 */

var date = new Date();
var D;
var M;
var Y;
var DD;
var HH;
var MM;
var SS;
var WL = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
var ML = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
function init()
{
    document.getElementById('btnOrd').onclick = function() {
        document.getElementById('frmOrd').hidden = false;
        document.getElementById('btnOrd').hidden = true;
    };
    document.getElementById('btnPro').onclick = function() {
        document.getElementById('frmPro').hidden = false;
        document.getElementById('btnPro').hidden = true;
    };
    document.getElementById('btnSup').onclick = function() {
        document.getElementById('frmSup').hidden = false;
        document.getElementById('btnSup').hidden = true;
    };
    document.getElementById('btnCat').onclick = function() {
        document.getElementById('frmCat').hidden = false;
        document.getElementById('btnCat').hidden = true;
    };
    document.getElementById('btnSupFilter').onclick = function() {
        window.location = "productfilter.jsp?wcode=sup";
    };
    document.getElementById('btnCatFilter').onclick = function() {
        window.location = "productfilter.jsp?wcode=cat";
    };
    HH = date.getHours();
    MM = date.getMinutes();
    SS = date.getSeconds();
    Y = date.getFullYear();
    M = date.getMonth();
    D = date.getDay();
    DD = date.getDate();
    document.getElementById('lblInfo').textContent = Y+"/"+ML[M]+"/"+DD+", "+WL[D]+" "+HH+":"+MM+":"+SS;
    document.getElementById('lblYear2').textContent = Y;
}

window.onload = function()
{
    init();
};
