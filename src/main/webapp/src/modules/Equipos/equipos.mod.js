/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var mod = ng.module("equiposModule", ["ui-router"]);
function nada (entero){
    if(entero==1 || entero==0){return 1;}
    if (entero>1){
        return nada(entero-1)+nada(entero-2);
    }
}
